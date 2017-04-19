package com.shrimpdb.entity;
import java.io.Serializable;
//s.id,s.code,s.lithologic,s.postion,s.operator,s.operate_time,s.LonEW,s.LonDeg,s.LonMin,s.LonSec,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.instrument ";
public class Project extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String systemeid;
	private Long userid;
	private String person;
	private String name;
	private String samplename;
	private String projectcode;
	private String source;
	private String number;
	private String sampling_date;	
	private String method;
	private String remarka;
	private String remarkb;
	private String remarkc;
	private String remarkd;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSamplename() {
		return samplename;
	}
	public void setSamplename(String samplename) {
		this.samplename = samplename;
	}
	public String getProjectcode() {
		return projectcode;
	}
	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSampling_date() {
		return sampling_date;
	}
	public void setSampling_date(String sampling_date) {
		this.sampling_date = sampling_date;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
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
	public String getRemarkd() {
		return remarkd;
	}
	public void setRemarkd(String remarkd) {
		this.remarkd = remarkd;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getSystemeid() {
		return systemeid;
	}
	public void setSystemeid(String systemeid) {
		this.systemeid = systemeid;
	}
}