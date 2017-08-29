package com.hauxin.shop.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.hauxin.shop.dao.UserDao;
import com.hauxin.shop.entity.User;
import com.hauxin.shop.util.MybatisUtil;

/**
 * @author @DT人 2017年7月13日 下午4:38:51
 *
 */
public class TestAnnotation {
	@Test
	public void testAdd() {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			User user = new User();
			user.setUserName("牛魔王");
			user.setPassWord("123456");
			user.setNickName("赵六");
			user.setEmail("zhaoliu@qq.com");
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
