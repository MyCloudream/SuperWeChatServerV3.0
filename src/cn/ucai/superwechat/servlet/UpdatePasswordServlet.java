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

@WebServlet("/updatePassword")
public class UpdatePasswordServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IUserBiz  biz = new UserBizImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1、接收参数
		String username = request.getParameter(I.User.USER_NAME);
		String password = request.getParameter(I.User.PASSWORD);
		// 2、交给业务层去处理，返回结果
		Result result = biz.updatePassword(username,password);
		// 3、将结果发送到页面
		JsonUtil.writeJsonToClient(result, response);
	}
}
