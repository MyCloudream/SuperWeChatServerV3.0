package cn.ucai.superwechat.biz;

import org.apache.ibatis.session.SqlSession;

import cn.ucai.superwechat.bean.Result;
import cn.ucai.superwechat.mapper.UserMapper;
import cn.ucai.superwechat.pojo.User;
import cn.ucai.superwechat.utils.I;
import cn.ucai.superwechat.utils.MyBatisUtil;

public class UserBizImpl implements IUserBiz {

	private SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
	private UserMapper mapper = sqlSession.getMapper(UserMapper.class);

	@Override
	public Result findUserByUserName(String userName) {
		User user = mapper.selectByUsername(userName);
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

}
