package com.hauxin.shop.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author @DT人 2017年7月13日 下午12:52:19
 *
 */
public class MybatisUtil {
	/*
	 * 创建一个私有的全局SqlSessionFactory的对象f
	 */
	private static SqlSessionFactory f;
	
	/*
	 * 用静态块读取配置文件并获得工厂对象
	 */
	static {
		try {
			InputStream is =Resources.getResourceAsStream("mybatis-config.xml"); // 读取配置文件的输入流
			f = new SqlSessionFactoryBuilder().build(is); // 创建SqlSessionFactory对象
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 获得session的函数
	 */
	public static SqlSession getSession() {
		return f.openSession(); // 打开session并返回
	}
	
	/*
	 * 关闭session的函数
	 */
	public static void CloseSession(SqlSession session) {
		if(session != null) session.close();
	}
}
