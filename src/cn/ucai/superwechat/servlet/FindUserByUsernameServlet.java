package cn.ucai.superwechat.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ucai.superwechat.bean.Result;
import cn.ucai.superwechat.biz.IUserBiz;
import cn.ucai.superwechat.biz.UserBizImpl;
import cn.ucai.superwechat.utils.I;
import cn.ucai.superwechat.utils.JsonUtil;

@WebServlet("/findUserByUserName")
public class FindUserByUsernameServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IUserBiz  biz = new UserBizImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter(I.User.USER_NAME);
		System.out.println(userName);
		Result result = biz.findUserByUserName(userName);
		JsonUtil.writeJsonToClient(result, response);
	}
}
