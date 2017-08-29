package com.hauxin.shop.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.hauxin.shop.dao.UserDao;
import com.hauxin.shop.entity.User;
import com.hauxin.shop.util.MybatisUtil;

/**
 * @author @DT人 2017年7月13日 下午2:07:27
 *
 */
public class TestInterfaceUser {

	@Test
	public void testAdd() {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			User user = new User();
			user.setUserName("沙和尚");
			user.setPassWord("123456");
			user.setNickName("王五");
			user.setEmail("王五@qq.com");
			session.getMapper(UserDao.class).add(user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			MybatisUtil.CloseSession(session);
		}
	}
	
}
