package com.shrimpdb.entity;

import java.io.Serializable;

public class QueryResult extends Base implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;//sample_detailÀïµÄid
	private Long sample_id;
	private String mountname;
	private String spotname;
	private String age204;
	private String err204;
	private String age208;
	private String err208;
	private String U;
	private String Th;
	private String UTh;
	private String fileop;
	private String code;
	private String lithologic;
	private String postion;
	private String operator;
	private String operate_time;
	private String LonEW;
	private String LonDeg;
	private String LonMin;
	private String LonSec;	
	private String LatNS;
	private String LatDeg;
	private String LatMin;
	private String LatSec;
	private String instrument;
	private Long flag;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSample_id() {
		return sample_id;
	}
	public void setSample_id(Long sample_id) {
		this.sample_id = sample_id;
	}
	public String getMountname() {
		return mountname;
	}
	public void setMountname(String mountname) {
		this.mountname = mountname;
	}
	public String getSpotname() {
		return spotname;
	}
	public void setSpotname(String spotname) {
		this.spotname = spotname;
	}
	public String getAge204() {
		return age204;
	}
	public void setAge204(String age204) {
		this.age204 = age204;
	}
	public String getErr204() {
		return err204;
	}
	public void setErr204(String err204) {
		this.err204 = err204;
	}
	public String getAge208() {
		return age208;
	}
	public void setAge208(String age208) {
		this.age208 = age208;
	}
	public String getErr208() {
		return err208;
	}
	public void setErr208(String err208) {
		this.err208 = err208;
	}
	public String getU() {
		return U;
	}
	public void setU(String u) {
		U = u;
	}
	public String getTh() {
		return Th;
	}
	public void setTh(String th) {
		Th = th;
	}
	public String getUTh() {
		return UTh;
	}
	public void setUTh(String uTh) {
		UTh = uTh;
	}
	public String getFileop() {
		return fileop;
	}
	public void setFileop(String fileop) {
		this.fileop = fileop;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLithologic() {
		return lithologic;
	}
	public void setLithologic(String lithologic) {
		this.lithologic = lithologic;
	}
	public String getPostion() {
		return postion;
	}
	public void setPostion(String postion) {
		this.postion = postion;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getOperate_time() {
		return operate_time;
	}
	public void setOperate_time(String operate_time) {
		this.operate_time = operate_time;
	}
	public String getLonEW() {
		return LonEW;
	}
	public void setLonEW(String lonEW) {
		LonEW = lonEW;
	}
	public String getLonDeg() {
		return LonDeg;
	}
	public void setLonDeg(String lonDeg) {
		LonDeg = lonDeg;
	}
	public String getLonMin() {
		return LonMin;
	}
	public void setLonMin(String lonMin) {
		LonMin = lonMin;
	}
	public String getLonSec() {
		return LonSec;
	}
	public void setLonSec(String lonSec) {
		LonSec = lonSec;
	}
	
	public String getLatNS() {
		return LatNS;
	}
	public void setLatNS(String latNS) {
		LatNS = latNS;
	}
	public String getLatDeg() {
		return LatDeg;
	}
	public void setLatDeg(String latDeg) {
		LatDeg = latDeg;
	}
	public String getLatMin() {
		return LatMin;
	}
	public void setLatMin(String latMin) {
		LatMin = latMin;
	}
	public String getLatSec() {
		return LatSec;
	}
	public void setLatSec(String latSec) {
		LatSec = latSec;
	}
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	public Long getFlag() {
		return flag;
	}
	public void setFlag(Long flag) {
		this.flag = flag;
	}
	

}
