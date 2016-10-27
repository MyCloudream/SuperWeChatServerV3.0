package cn.ucai.superwechat.biz;

import cn.ucai.superwechat.bean.Result;

public interface IUserBiz {
	Result findUserByUserName(String userName);
}
