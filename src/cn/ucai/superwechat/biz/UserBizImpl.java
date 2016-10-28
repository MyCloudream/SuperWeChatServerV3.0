package cn.ucai.superwechat.biz;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.session.SqlSession;

import cn.ucai.superwechat.bean.Result;
import cn.ucai.superwechat.mapper.UserMapper;
import cn.ucai.superwechat.pojo.Avatar;
import cn.ucai.superwechat.pojo.User;
import cn.ucai.superwechat.utils.I;
import cn.ucai.superwechat.utils.MyBatisUtil;
import cn.ucai.superwechat.utils.PropertiesUtils;

public class UserBizImpl implements IUserBiz {

	private SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
	private UserMapper mapper = sqlSession.getMapper(UserMapper.class);

	@Override
	public Result findUserByUserName(String userName) {
		User user = mapper.selectUserByUsername(userName);
		System.out.println(user);
		Result result = new Result();
		if (user == null) {
			result.setRetMsg(false);
			result.setRetCode(I.MSG_LOGIN_UNKNOW_USER);
		} else {
			result.setRetMsg(true);
			result.setRetCode(I.MSG_SUCCESS);
			result.setRetData(user);
		}
		return result;
	}

	@Override
	public Result register(User user, HttpServletRequest request) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(false);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		Result result = new Result();
		// 完成注册业务逻辑
		// 查找数据库中有没有重名的用户
		User u = userMapper.selectUserByUsername(user.getUsername());
		if (u == null) {// 没有
			// 获得头像的后缀名
			String suffix = uploadAvatar(user.getUsername(), I.AVATAR_TYPE_USER_PATH, request);
			if (addUserAndAvatar(sqlSession, userMapper, user, suffix)) {// 注册成功
				result.setRetMsg(true);
				result.setRetCode(I.MSG_SUCCESS);
			} else {// 删除头像
				deleteAvatar(PropertiesUtils.getValue("avatar_path", "path.properties") + I.AVATAR_TYPE_USER_PATH + "/",
						user.getUsername() + suffix);
				result.setRetMsg(false);
				result.setRetCode(I.MSG_REGISTER_FAIL);
			}
		} else {// 已存在
			result.setRetMsg(false);
			result.setRetCode(I.MSG_REGISTER_USERNAME_EXISTS);
		}
		return result;
	}

	public boolean addUserAndAvatar(SqlSession sqlSession, UserMapper mapper,User user, String suffix) {
		Avatar avatar = new Avatar(suffix, "0", System.currentTimeMillis()+"");
		mapper.insertAvatar(avatar);
//		user.getAvatar().setId(avatar.getId());
		user.setAvatar(avatar);
		mapper.insertUser(user);
		sqlSession.commit();
		return true;
	}
	
	/**
	 * 删除头像
	 * @param path
	 * @param name
	 */
	private void deleteAvatar(String path,String imageName) {
		File file = new File(path,imageName);
		if(file.exists()){
			file.delete();
		}
	}

	private String uploadAvatar(String name, String avatarType, HttpServletRequest request) {
		String path = null;
		if (avatarType.equals(I.AVATAR_TYPE_USER_PATH)) {// 用户上传头像
			path = PropertiesUtils.getValue("avatar_path", "path.properties") + I.AVATAR_TYPE_USER_PATH + "/";
		} else if (avatarType.equals(I.AVATAR_TYPE_GROUP_PATH)) {// 群组上传
			path = PropertiesUtils.getValue("avatar_path", "path.properties") + I.AVATAR_TYPE_GROUP_PATH + "/";
		}
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb
			// 设置临时文件目录
			factory.setRepository(new File(PropertiesUtils.getValue("temp_path", "path.properties")));// 设置缓冲区目录
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(4194304); // 设置最大文件尺寸，这里是4MB
			List<FileItem> items = upload.parseRequest(request);// 得到所有的文件
			Iterator<FileItem> i = items.iterator();
			String fileName = null;
			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				fileName = fi.getName();
				if (fileName != null) {
					File savedFile = null;
					if (name.indexOf(".") != -1) {// 更新头像操作
						// 如果是更新图片，传过来的是shangpeng.jpg,，需要修改为shangpeng.png,上传则不必
						savedFile = new File(path, name.substring(0, name.lastIndexOf("."))
								+ fileName.substring(fileName.lastIndexOf(".")));
					} else {// 上传头像操作
						savedFile = new File(path, name + fileName.substring(fileName.lastIndexOf(".")));
					}
					fi.write(savedFile);
				}
			}
			return fileName.substring(fileName.lastIndexOf("."));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
