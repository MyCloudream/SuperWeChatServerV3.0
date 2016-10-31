package cn.ucai.superwechat.biz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.session.SqlSession;

import cn.ucai.superwechat.bean.Result;
import cn.ucai.superwechat.mapper.UserMapper;
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
			String suffix = uploadAvatar(user.getUsername(), request);
			if (addUser(sqlSession, userMapper, user, suffix)) {// 注册成功
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

	public boolean addUser(SqlSession sqlSession, UserMapper mapper, User user, String suffix) {
		if (suffix != null) {
			user.setSuffix(suffix);
		}
		user.setUptime(System.currentTimeMillis() + "");
		mapper.insertUser(user);
		sqlSession.commit();
		return true;
	}

	/**
	 * 删除头像
	 * 
	 * @param path
	 * @param name
	 */
	private void deleteAvatar(String path, String imageName) {
		File file = new File(path, imageName);
		if (file.exists()) {
			file.delete();
		}
	}

	private String uploadAvatar(String name, HttpServletRequest request) {
		String path = PropertiesUtils.getValue("avatar_path", "path.properties") + I.AVATAR_TYPE_USER_PATH + "/";
		System.out.println(ServletFileUpload.isMultipartContent(request));
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
			if (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				fileName = fi.getName();
				File savedFile = null;
				savedFile = new File(path, name + fileName.substring(fileName.lastIndexOf(".")));
				fi.write(savedFile);
				return fileName.substring(fileName.lastIndexOf("."));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Result login(User user) {
		Result result = new Result();
		User u = mapper.selectUserByUsername(user.getUsername());
		if (u != null) {
			if (u.getPassword().equals(user.getPassword())) {
				result.setRetMsg(true);
				result.setRetCode(I.MSG_SUCCESS);
				result.setRetData(u);
			} else {
				result.setRetMsg(false);
				result.setRetCode(I.MSG_LOGIN_ERROR_PASSWORD);
			}
		} else {
			result.setRetMsg(false);
			result.setRetCode(I.MSG_LOGIN_UNKNOW_USER);
		}
		return result;
	}

	@Override
	public void downAvatar(String nameOrHxid, String avatarSuffix, String avatarType, HttpServletResponse response,
			String width, String height) {
		// 1、从文件中读
		// 2、将读到的内容写入到客户端
		response.setContentType("image/jpeg"); // MIME
		File file = new File(PropertiesUtils.getValue("avatar_path", "path.properties") + avatarType + "/",
				nameOrHxid + avatarSuffix);
		try {
			if (file.exists()) {
				zoom(file.getPath(), response.getOutputStream());
			}else{
				file = new File(PropertiesUtils.getValue("avatar_path", "path.properties") + avatarType + "/default.jpg");
				zoom(file.getPath(), response.getOutputStream());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void zoom(String sourcePath,OutputStream os) throws IOException{  
        File imageFile = new File(sourcePath);  
        String format = sourcePath.substring(sourcePath.lastIndexOf(".")+1,sourcePath.length());  
        BufferedImage image = ImageIO.read(imageFile);  
        ImageIO.write(image, format, os);  
        os.close();
    }

	/**
	 * 更新用户或群组的头像
	 */
	@Override
	public Result updateAvatar(String nameOrHxid, String avatarType, HttpServletRequest request) {
		Result result = new Result();
		// 先上传新图片覆盖旧图片
		String suffix = uploadAvatar(nameOrHxid,request);
		System.out.println("suffix:"+suffix);
		if(suffix!=null){
			if (avatarType.equals(I.AVATAR_TYPE_USER_PATH)) {// 用户
				User user = new User();
				user.setSuffix(suffix);
				user.setUptime(System.currentTimeMillis()+"");
				user.setUsername(nameOrHxid);
				if(mapper.updateUser(user)!=0){
					User u = mapper.selectUserByUsername(nameOrHxid);
					result.setRetData(u);
					System.out.println("success");
				}else{
					System.out.println("failed");
					result.setRetMsg(false);
					result.setRetCode(I.MSG_UPLOAD_AVATAR_FAIL);
				}
			} else if (avatarType.equals(I.AVATAR_TYPE_GROUP_PATH)) {// 群组
				
			}
			result.setRetMsg(true);
			result.setRetCode(I.MSG_SUCCESS);
		}else{
			result.setRetMsg(false);
			result.setRetCode(I.MSG_UPLOAD_AVATAR_FAIL);
		}
		return result;
	}

	/**
	 * 根据用户名更新昵称
	 */
	@Override
	public Result updateNick(String username, String nick) {
		Result result = new Result();
		User user = new User();
		user.setUsername(username);
		user.setNick(nick);
		if(mapper.updateUser(user)!=0){// 更新成功
			result.setRetMsg(true);
			result.setRetCode(I.MSG_SUCCESS);
			User u = mapper.selectUserByUsername(username);
			result.setRetData(u);
		}else{// 更新失败
			result.setRetMsg(false);
			result.setRetCode(I.MSG_USER_UPDATE_NICK_FAIL);
		}
		return result;
	}

	@Override
	public Result updatePassword(String username, String password) {
		Result result = new Result();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		if(mapper.updateUser(user)!=0){// 更新成功
			result.setRetMsg(true);
			result.setRetCode(I.MSG_SUCCESS);
			User u = mapper.selectUserByUsername(username);
			result.setRetData(u);
		}else{// 更新失败
			result.setRetMsg(false);
			result.setRetCode(I.MSG_USER_UPDATE_PASSWORD_FAIL);
		}
		return result;
	}
}
