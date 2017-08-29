package com.hauxin.shop.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hauxin.shop.dao.DaoFactory;
import com.hauxin.shop.dao.UserDao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author @DT人 2017年7月18日 下午4:50:10
 *
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private UserDao userDao;
	public UserServlet() {
		userDao = DaoFactory.getUserDao();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		Map<String,String> map = new HashMap<String,String>();
		map.put("username", "张三");
		String id = req.getParameter("id");
		int uid = 0;
		if(id != null) uid = Integer.valueOf(id);
		System.out.println(uid);
		JSONArray json = JSONArray.fromObject(userDao.list());
		JSONObject jsonRes =  new JSONObject(); 
		jsonRes.put("name", "张三");
		PrintWriter out = resp.getWriter();
		out.write(map.toString());
	}
}
