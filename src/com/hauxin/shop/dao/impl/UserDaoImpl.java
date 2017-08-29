package com.hauxin.shop.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.hauxin.shop.dao.UserDao;
import com.hauxin.shop.entity.User;
import com.hauxin.shop.util.MybatisUtil;
import com.hauxin.shop.util.Pager;
/**
 * @author @DT人 2017年7月13日 下午5:12:17
 *
 */
public class UserDaoImpl implements UserDao {

	@Override
	public User load(Integer id) {
		SqlSession session = null;
		User user = null;
		try {
			session = MybatisUtil.getSession();
			user = session.selectOne(User.class.getName()+".load", id);
		} finally {
			MybatisUtil.CloseSession(session);
		}
		return user;
	}

	@Override
	public void add(User user) {
		SqlSession session = null;
		try {
			User u = this.getUserByUserName(user.getUserName());
			if(u != null) throw new RuntimeException(user.getUserName()+"用户已存在!");
			session = MybatisUtil.getSession();
			session.insert(User.class.getName()+".add", user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			MybatisUtil.CloseSession(session);
		}
	}

	@Override
	public void update(User user) {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			session.update(User.class.getName()+".update", user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			MybatisUtil.CloseSession(session);
		}
	}

	@Override
	public void delete(Integer id) {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			session.delete(User.class.getName()+".delete", id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			MybatisUtil.CloseSession(session);
		}
	}

	@Override
	public List<User> list() {
		SqlSession session = null;
		List<User> users = null;
		try {
			session = MybatisUtil.getSession();
			users = session.selectList(User.class.getName()+".list");
		} finally {
			MybatisUtil.CloseSession(session);
		}
		return users;
	}

	@Override
	public User getUserByUserName(String username) {
		SqlSession session = null;
		User user = null;
		try {
			session = MybatisUtil.getSession();
			user = session.selectOne(User.class.getName()+".getUserByUserName", username);
		} finally {
			MybatisUtil.CloseSession(session);
		}
		return user;
	}

	@Override
	public Pager<User> find(String condition, int currentPage, int pageSize) {
		SqlSession session = null;
		Pager<User> page = new Pager<User>();
		try {
			session = MybatisUtil.getSession();
			Map<String, Object> params = new HashMap<String, Object>(); // 参数集合
			if(currentPage <= 0) currentPage = 1; // 至少要保证当前页为1
			int offset = (currentPage - 1) * pageSize; // 计算分页的起始位置
			params.put("condition", "%"+condition+"%"); // 拼接模糊查询的条件
			params.put("offset", offset);
			params.put("pageSize", pageSize);
			List<User> users = session.selectList(User.class.getName()+".find", params);// 参数传的Map
			int totalRecord = this.recordCount(condition);
			int totalPage = (totalRecord - 1) / pageSize + 1; // 计算总页数
			// 给分页对象设值
			page.setCurrentPage(currentPage);
			page.setPageSize(pageSize);
			page.setTotalRecord(totalRecord);
			page.setTotalPage(totalPage);
			page.setDatas(users);
		} finally {
			MybatisUtil.CloseSession(session);
		}
		return page;
	}
	/*
	 * 查询记录数的方法
	 */
	private int recordCount(String condition) {
		SqlSession session = null;
		int n = 0;
		try {
			session = MybatisUtil.getSession();
			n = session.selectOne(User.class.getName()+".recordCount", condition);
		} finally {
			MybatisUtil.CloseSession(session);
		}
		return n;
	}
}
