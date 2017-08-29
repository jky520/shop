package com.hauxin.shop.dao;

import com.hauxin.shop.dao.impl.UserDaoImpl;

/**
 * @author @DT人 2017年7月17日 下午12:57:01
 *
 */
public class DaoFactory {

	public static UserDao getUserDao() {
		return new UserDaoImpl();
	}
}
