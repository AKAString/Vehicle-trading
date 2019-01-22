package com.qr.xxpt.entity;

import java.util.ArrayList;
import java.util.List;

public class BaseEntity<T> {

	private int perRow=5;
	private int startRow;
	private int endRow;
	private int pageNum=1;
	private int upPage;
	private int nextPage;
	private int totalPage;
	private boolean isPage=false;
	private List<T> list=new ArrayList<T>();
	public int getPerRow() {
		return perRow;
	}
	public void setPerRow(int perRow) {
		this.perRow = perRow;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = (this.pageNum-1)*this.perRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = this.startRow+this.perRow;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getUpPage() {
		return upPage;
	}
	public void setUpPage(int upPage) {
		this.upPage = this.pageNum-1;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = this.pageNum+1;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public boolean isPage() {
		return isPage;
	}
	public void setPage(boolean isPage) {
		this.isPage = isPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
