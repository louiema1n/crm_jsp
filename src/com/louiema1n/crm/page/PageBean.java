package com.louiema1n.crm.page;

import java.util.List;

public class PageBean<T> {
	/**
	 * 分页实现相关参数(不适用包装类,默认为0)
	 */
	private int pageNum;		//当前页
	private int pageSize;		//分页大小
	private int totalRecord;	//总记录数(查询获得)

	private int startIndex;		//开始索引(计算)
	private int totalPage;		//总页数(计算)
	
	private List<T> page;		//分页数据
	
	
	//使用构造方法在new时将pageNum,pageSize,totalRecord传递过来计算startIndex,totalPage
	public PageBean(int pageNum, int pageSize, int totalRecord) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		
		//计算startIndex,totalPage
		this.startIndex = (this.pageNum - 1) * this.pageSize;
		this.totalPage = (this.totalRecord +  this.pageSize - 1)/this.pageSize;
	}
	
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getPage() {
		return page;
	}

	public void setPage(List<T> page) {
		this.page = page;
	}
	
}
