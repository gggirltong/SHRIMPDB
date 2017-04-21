package com.shrimpdb.entity;
import java.io.Serializable;
//s.id,s.code,s.lithologic,s.postion,s.operator,s.operate_time,s.LonEW,s.LonDeg,s.LonMin,s.LonSec,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.instrument ";
public class Sample_detail extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
	private  Long id;
	private  Long main;
	private String code;
	private String lithologic;
	private String postion;
	private double lonlat;
	private String operate_time;
	private String last_operator;	
	private String last_operate_time;
	private String LonEW;
	private String LonDeg;
	private String operator;
	private String LonMin;
	private String LonSec;
	private double latitude;
	private String LatNS;
	private String LatDeg;
	private String LatMin;
	private String LatSec;
	private String age;
	private String instrument;
	private Long    flag;
	private Long   dataid;
	private String   systemid;
	private Long   userid;
	private Long   testid;
	private String   remarkaa;
	private String   remarkbb;
	private String   remarkee;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMain() {
		return main;
	}
	public void setMain(Long main) {
		this.main = main;
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
	public double getLonlat() {
		return lonlat;
	}
	public void setLonlat(double lonlat2) {
		this.lonlat = lonlat2;
	}
	public String getOperate_time() {
		return operate_time;
	}
	public void setOperate_time(String operate_time) {
		this.operate_time = operate_time;
	}
	public String getLast_operator() {
		return last_operator;
	}
	public void setLast_operator(String last_operator) {
		this.last_operator = last_operator;
	}
	public String getLast_operate_time() {
		return last_operate_time;
	}
	public void setLast_operate_time(String last_operate_time) {
		this.last_operate_time = last_operate_time;
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
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
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
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
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
	public Long getDataid() {
		return dataid;
	}
	public void setDataid(Long dataid) {
		this.dataid = dataid;
	}
	public String getSystemid() {
		return systemid;
	}
	public void setSystemid(String systemid) {
		this.systemid = systemid;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getTestid() {
		return testid;
	}
	public void setTestid(Long testid) {
		this.testid = testid;
	}
	public String getRemarkaa() {
		return remarkaa;
	}
	public void setRemarkaa(String string) {
		this.remarkaa = string;
	}
	public String getRemarkbb() {
		return remarkbb;
	}
	public void setRemarkbb(String remarkbb) {
		this.remarkbb = remarkbb;
	}
	public String getRemarkee() {
		return remarkee;
	}
	public void setRemarkee(String remarkee) {
		this.remarkee = remarkee;
	}
	
	
	
}