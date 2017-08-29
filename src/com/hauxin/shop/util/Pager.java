package com.hauxin.shop.util;

import java.util.List;

/**
 * 分页器的实现
 * 
 * @author @DT人 2017年7月17日 上午10:24:49
 *
 */
public class Pager<E> {
	/*
	 * 当前页
	 */
	private Integer currentPage;
	/*
	 * 每页显示多少条
	 */
	private Integer pageSize;
	/*
	 * 总共有多少条记录数
	 */
	private Integer totalRecord;
	/*
	 * 一共又多少页
	 */
	private Integer totalPage;
	/*
	 * 存放具体的数据列表
	 */
	private List<E> datas;
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<E> getDatas() {
		return datas;
	}
	public void setDatas(List<E> datas) {
		this.datas = datas;
	}
	@Override
	public String toString() {
		return "Pager [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalRecord=" + totalRecord
				+ ", totalPage=" + totalPage + ", datas=" + datas + "]";
	}
	
}
