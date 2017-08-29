package com.hauxin.shop.test;

import java.util.List;

import org.junit.Test;

import com.hauxin.shop.dao.UserDao;
import com.hauxin.shop.dao.impl.UserDaoImpl;
import com.hauxin.shop.entity.User;

/**
 * @author @DT人 2017年7月13日 下午5:20:05
 *
 */
public class TestUserDao {
	UserDao ud = null;
	public TestUserDao() {
		ud = new UserDaoImpl();
	}
	@Test
	public void loadUser() {
		User user = ud.load(5);
		System.out.println(user);
	}
	
	@Test
	public void testList() {
		List<User> list = ud.list();
		System.out.println(list);
	}
}
