package cn.ucai.superwechat.test;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import cn.ucai.superwechat.mapper.UserMapper;
import cn.ucai.superwechat.pojo.User;
import cn.ucai.superwechat.utils.MyBatisUtil;

public class Test {

    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByUserName("cloudream");
        sqlSession.close();
        System.out.println(user);
    }
}