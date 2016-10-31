package cn.ucai.superwechat.biz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ucai.superwechat.bean.Result;
import cn.ucai.superwechat.pojo.User;

public interface IUserBiz {
	Result findUserByUserName(String userName);

	Result register(User user, HttpServletRequest request);

	Result login(User user);

	void downAvatar(String nameOrHxid, String avatarSuffix, String avatarType, HttpServletResponse response,
			String width, String height);

	Result updateAvatar(String nameOrHxid, String avatarType, HttpServletRequest request);

	Result updateNick(String username, String nick);

	Result updatePassword(String username, String password);
}
