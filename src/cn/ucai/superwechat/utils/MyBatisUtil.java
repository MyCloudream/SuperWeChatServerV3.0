package cn.ucai.superwechat.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory sqlSessionFactory;

	/**
	 * 获取SqlSessionFactory
	 * 
	 * @return SqlSessionFactory
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory == null) {
			InputStream is;
			try {
				is = Resources.getResourceAsStream("conf.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sqlSessionFactory;
	}

	/**
	 * 获取SqlSession
	 * 
	 * @return SqlSession
	 */
	public static SqlSession getSqlSession() {
		return getSqlSessionFactory().openSession();
	}

	/**
	 * 获取SqlSession
	 * 
	 * @param isAutoCommit
	 *            true 表示创建的SqlSession对象在执行完SQL之后会自动提交事务 false
	 *            表示创建的SqlSession对象在执行完SQL之后不会自动提交事务，这时就需要我们手动调用sqlSession.
	 *            commit()提交事务
	 * @return SqlSession
	 */
	public static SqlSession getSqlSession(boolean isAutoCommit) {
		return getSqlSessionFactory().openSession(isAutoCommit);
	}
}