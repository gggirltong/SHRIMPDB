package com.shrimpdb.entity;

import java.io.Serializable;

public class User extends Base implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;	
	private String username;  //�û���
	private String name;  // ��ʵ����
	private String password;    // ����
	private String pinyin;    // ����ƴ��
	private String phone;	// �绰
	private String email;	//����
	private String unit;    //��λ
	private String department;    //����
	private String degree;    //ѧ��
	private String address;    //��λ��ַ
	private Long   type;    //�û�����
	private String login_date;    //��¼ʱ��
	private String create_date;   //����ʱ��
	private String expire_date;//����ʱ��
	private String remarks;//��ע
	private Long   del_flag;//ɾ�����
	private String imag;//����ͼ��
	private String papera;//����a����
	private String paperb;//����b����
	private String paperc;//����c����
	private String remarka;  // ��չa
	private String remarkb;  // ��չb
	private String remarkc;  // ��չc
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
