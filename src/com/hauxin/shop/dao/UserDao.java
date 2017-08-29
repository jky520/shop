package com.hauxin.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hauxin.shop.entity.User;
import com.hauxin.shop.util.Pager;

/**
 * @author @DT人 2017年7月13日 下午2:02:08
 *
 */
public interface UserDao {
	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	User load(Integer id);
	
	User getUserByUserName(String userName);
	
	void add(User user);
	
	void update(User user);
	
	void delete(Integer id);
	
	List<User> list();
	
	/**
	 * 分页查询方法
	 * 
	 * @param condition 查询条件
	 * @param curentPage 当前页
	 * @param pageSize 每页显示多少条数据
	 * @return
	 */
	Pager<User> find(String condition, int curentPage, int pageSize);
	
	/*@Select("select * from t_user where id = #{id}")
	User load(Integer id);
	
	@Insert("insert into t_user(user_name,pass_word,nick_name,email) values(#{userName},#{passWord},#{nickName},#{email})")
	void add(User user);
	
	@Update("update t_user set user_name = #{userName}, pass_word=#{passWord}, nick_name=#{nickName},email=#{email} where id=#{id}")
	void update(User user);
	
	@Delete("delete from t_user where id = #{id}")
	void delete(Integer id);
	
	@Select("select * from t_user")
	List<User> list();*/
}
