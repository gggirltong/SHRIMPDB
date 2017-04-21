package com.shrimpdb.entity;

import java.io.Serializable;

public class Base implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String qtype;//页面参数
	private String query; 
	private Integer page;
	private Integer rp;
	private String sortname;
	private String sortorder;
	
	public String getQtype() {
		return qtype;
	}
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRp() {
		return rp;
	}
	public void setRp(Integer rp) {
		this.rp = rp;
	}
	public String getSortname() {
		return sortname;
	}
	public void setSortname(String sortname) {
		this.sortname = sortname;
	}
	public String getSortorder() {
		return sortorder;
	}
	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}
}
