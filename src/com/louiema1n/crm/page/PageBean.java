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
	
	//分页进度条
	private int start;
	private int end;
	
	//使用构造方法在new时将pageNum,pageSize,totalRecord传递过来计算startIndex,totalPage
	public PageBean(int pageNum, int pageSize, int totalRecord) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		
		//计算startIndex,totalPage
		this.startIndex = (this.pageNum - 1) * this.pageSize;
		this.totalPage = (this.totalRecord +  this.pageSize - 1)/this.pageSize;
		
		//初始化进度条
		this.start = 1;
		this.end = 10;
		
		if (this.totalPage < 10) {					//如果总页数小于10,则显示1-总页数
			this.end = this.totalPage;
		} else {									//如果总页数大于10
			this.start = this.pageNum - 4;			//显示当前页前4
			this.end = this.pageNum + 5;			//显示当前页后5
			
			if (this.start < 1) {					//当 减4后的 第一页小于1时,开始页从1开始,并显示到10
				this.start = 1;						
				this.end = 10;
			}
			if (this.end > this.totalPage) {		//当 加5后的最后一页大于总页数时,结束页从总页数开始,并显示前10
				this.end = this.totalPage;
				this.start = this.totalPage - 9;
			}
		}
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


	public int getStart() {
		return start;
	}


	public void setStart(int start) {
		this.start = start;
	}


	public int getEnd() {
		return end;
	}


	public void setEnd(int end) {
		this.end = end;
	}
	
	
	
}
