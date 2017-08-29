package com.hauxin.shop.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.hauxin.shop.entity.User;

/**
 * mybatis一级二级缓存的测试
 * 
 * @author @DT人 2017年7月18日 下午9:52:58
 *
 */
public class TestCasheUser {
	
	SqlSession session = null;

	@Before
	public void init() throws IOException {
		// 通过配置文件得到连接信心
		Reader r = Resources.getResourceAsReader("mybatis-config.xml");
		// 通过配置信息构建一个SqlSessionFactory
		SqlSessionFactory f = new SqlSessionFactoryBuilder().build(r);
		// 通过SqlSession打开一个数据库的会话
		session = f.openSession();
	}
	
	/**
	 * mybatis一级缓存是指在内存中开辟一块区域，用来保存用户对数据库的操作信息（sql）和数据库返回的数据，
	 * 如果下一次用户再执行相同的请求，那么直接从内存中读数数据而不是从数据库读取
	 */
	@Test
	public void testLoad() {
		/**
		 * 然后执行该单元测试，发现效果跟上面执行一条的时候完全相同，
		 * 也就是执行第二次session.selectList(User.class.getName()+".list");
		 * 操作的时候没有对数据库进行查询，那么得到的数据是从哪里来的？答案是一级缓存。
		 */
		List<User> users = session.selectList(User.class.getName()+".list");
		users = session.selectList(User.class.getName()+".list");
		System.out.println(users);
	}
}
