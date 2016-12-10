package com.louiema1n.crm.page;

import java.util.List;

public class PageBean<T> {
	/**
	 * ��ҳʵ����ز���(�����ð�װ��,Ĭ��Ϊ0)
	 */
	private int pageNum;		//��ǰҳ
	private int pageSize;		//��ҳ��С
	private int totalRecord;	//�ܼ�¼��(��ѯ���)

	private int startIndex;		//��ʼ����(����)
	private int totalPage;		//��ҳ��(����)
	
	private List<T> page;		//��ҳ����
	
	
	//ʹ�ù��췽����newʱ��pageNum,pageSize,totalRecord���ݹ�������startIndex,totalPage
	public PageBean(int pageNum, int pageSize, int totalRecord) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		
		//����startIndex,totalPage
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
