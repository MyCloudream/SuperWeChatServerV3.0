package cn.ucai.superwechat.mapper;

import cn.ucai.superwechat.pojo.Avatar;
import cn.ucai.superwechat.pojo.User;

public interface UserMapper {
	/**
	 * 根据用户名查找用户
	 * @param username 用户名
	 * @return
	 */
    User selectUserByUsername(String username);
    
    int insertUser(User user);
    
    int insertAvatar(Avatar avatar);

	int updateUser(User user);

}