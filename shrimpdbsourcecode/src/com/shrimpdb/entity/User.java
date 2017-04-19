package com.shrimpdb.entity;

import java.io.Serializable;

public class User extends Base implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;	
	private String username;  //用户名
	private String name;  // 真实姓名
	private String password;    // 密码
	private String pinyin;    // 姓名拼音
	private String phone;	// 电话
	private String email;	//邮箱
	private String unit;    //单位
	private String department;    //部门
	private String degree;    //学历
	private String address;    //单位地址
	private Long   type;    //用户级别
	private String login_date;    //登录时间
	private String create_date;   //创建时间
	private String expire_date;//到期时间
	private String remarks;//备注
	private Long   del_flag;//删除标记
	private String imag;//个人图像
	private String papera;//文章a连接
	private String paperb;//文章b连接
	private String paperc;//文章c连接
	private String remarka;  // 扩展a
	private String remarkb;  // 扩展b
	private String remarkc;  // 扩展c
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getType() {
		return type;
	}
	public void setType(Long type) {
		this.type = type;
	}
	public String getLogin_date() {
		return login_date;
	}
	public void setLogin_date(String login_date) {
		this.login_date = login_date;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getExpire_date() {
		return expire_date;
	}
	public void setExpire_date(String expire_date) {
		this.expire_date = expire_date;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Long getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(Long del_flag) {
		this.del_flag = del_flag;
	}
	public String getImag() {
		return imag;
	}
	public void setImag(String imag) {
		this.imag = imag;
	}
	public String getPapera() {
		return papera;
	}
	public void setPapera(String papera) {
		this.papera = papera;
	}
	public String getPaperb() {
		return paperb;
	}
	public void setPaperb(String paperb) {
		this.paperb = paperb;
	}
	public String getPaperc() {
		return paperc;
	}
	public void setPaperc(String paperc) {
		this.paperc = paperc;
	}
	public String getRemarka() {
		return remarka;
	}
	public void setRemarka(String remarka) {
		this.remarka = remarka;
	}
	public String getRemarkb() {
		return remarkb;
	}
	public void setRemarkb(String remarkb) {
		this.remarkb = remarkb;
	}
	public String getRemarkc() {
		return remarkc;
	}
	public void setRemarkc(String remarkc) {
		this.remarkc = remarkc;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	   // 
	
	
	
}
