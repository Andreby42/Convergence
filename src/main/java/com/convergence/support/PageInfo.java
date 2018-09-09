package com.convergence.support;

import java.util.List;

public class PageInfo<T> {

	private int totalPages;
	private int number;
	private int pages;
	private List<T> content;
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public List<T> getContent() {
		return content;
	}
	public void setContent(List<T> content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "PageInfo [totalPages=" + totalPages + ", number=" + number + ", pages=" + pages + ", content=" + content
				+ "]";
	}

}
