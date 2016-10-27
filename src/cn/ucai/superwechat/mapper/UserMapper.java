package cn.ucai.superwechat.mapper;

import cn.ucai.superwechat.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(String mUserName);

    int insert(User record);

    int insertSelective(User record);

    User selectByUserName(String mUserName);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}