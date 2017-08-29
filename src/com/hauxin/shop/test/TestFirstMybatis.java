package com.hauxin.shop.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hauxin.shop.entity.User;

/**
 * @author @DT人 2017年7月13日 上午11:58:29
 *
 */
public class TestFirstMybatis {
	public static void main(String[] args) {
		add();
	}
	
	public static void delete() {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();
			session.delete(User.class.getName()+".delete", 2);
			session.commit();
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void update() {
		try {
			// 1.创建配置文件mybatis-config配置文件的输入流。
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			// 2.创建SqlSessionFactory
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			// 3.创建SqlSession
			SqlSession session = factory.openSession();
			// 4.调用相应的mapper文件，操作数据库（操作之前现在配置文件中注册mapper文件）
			User user = new User();
			user.setId(2);
			user.setUserName("悟空11");
			user.setPassWord("123456");
			user.setNickName("张三11");
			user.setEmail("zhangsan@qq.com");
			session.update("com.huaxin.shop.entity.User.update", user);
			session.commit();
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void add() {
		try {
			// 1.创建配置文件mybatis-config配置文件的输入流。
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			// 2.创建SqlSessionFactory
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			// 3.创建SqlSession
			SqlSession session = factory.openSession();
			// 4.调用相应的mapper文件，操作数据库（操作之前现在配置文件中注册mapper文件）
			User user = new User();
			user.setUserName("悟空");
			user.setPassWord("123456");
			user.setNickName("张三");
			user.setEmail("zhangsan@qq.com");
			session.insert(User.class.getName()+".add", user);
			session.commit();
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
