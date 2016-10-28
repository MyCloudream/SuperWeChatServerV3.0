package cn.ucai.superwechat.test;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import cn.ucai.superwechat.mapper.AvatarMapper;
import cn.ucai.superwechat.mapper.UserMapper;
import cn.ucai.superwechat.pojo.Avatar;
import cn.ucai.superwechat.pojo.User;
import cn.ucai.superwechat.utils.MyBatisUtil;

public class Test {

    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
        AvatarMapper mapper = sqlSession.getMapper(AvatarMapper.class);
        /*User user = mapper.selectByUsername("shangpeng");
        sqlSession.close();
        System.out.println(user);*/
        
//        int count = mapper.insertUser(new User("abc", "def", "mon", new Avatar(1001, ".jpg","0", System.currentTimeMillis()+"")));
        Avatar avatar = new Avatar(".jpg2","1", System.currentTimeMillis()+""); 
        System.out.println(avatar);
        int count = mapper.insertAvatar(avatar);
        System.out.println("flag = "+avatar.getId());
        System.out.println(avatar);
    }
}