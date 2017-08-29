package com.hauxin.shop.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.hauxin.shop.entity.User;
import com.hauxin.shop.util.MybatisUtil;

/**
 * @author @DT人 2017年7月13日 上午11:57:34
 *
 */
public class TestMybatis {
	
	@Test
	public void testAdd() {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			User user = new User();
			user.setUserName("八戒");
			user.setPassWord("123456");
			user.setNickName("李四");
			user.setEmail("lisi@qq.com");
			session.insert(User.class.getName()+".add", user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			MybatisUtil.CloseSession(session);
		}
		
	}
	
	@Test
	public void testLoad() {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			User user = session.selectOne(User.class.getName()+".load", 3);
			System.out.println(user);
		} finally {
			MybatisUtil.CloseSession(session);
		}
	}
	
	@Test
	public void testList() {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			List<User> users = session.selectList(User.class.getName()+".list");
			System.out.println(users);
		} finally {
			MybatisUtil.CloseSession(session);
		}
	}
}
