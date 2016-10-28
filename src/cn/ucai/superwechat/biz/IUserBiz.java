package cn.ucai.superwechat.biz;

import javax.servlet.http.HttpServletRequest;

import cn.ucai.superwechat.bean.Result;
import cn.ucai.superwechat.pojo.User;

public interface IUserBiz {
	Result findUserByUserName(String userName);

	Result register(User user, HttpServletRequest request);
}
