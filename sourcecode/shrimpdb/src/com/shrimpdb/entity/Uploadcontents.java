package com.shrimpdb.entity;
import java.io.Serializable;
//s.id,s.code,s.lithologic,s.postion,s.operator,s.operate_time,s.LonEW,s.LonDeg,s.LonMin,s.LonSec,s.LatNS,s.LatDeg,s.LatMin,s.LatSec,s.instrument ";
public class Uploadcontents extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
	// sample_detail data
	private   Long id;
	private   String main;
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
	private Long flag;
	private Long dataid;
	private Long remarkbb;
	private Long remarkaa;
	private Long remarkee;
	private Long testid;
	//project data
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
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String number2) {
		this.main = number2;
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
	public void setLonlat(double longetitude) {
		this.lonlat = longetitude;
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
	public void setLatitude(double latitude2) {
		this.latitude = latitude2;
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
	public String getSystemid() {
		return systemeid;
	}
	public void setSystemid(String number2) {
		this.systemeid = number2;
	}
	public Long getFlag() {
		// TODO Auto-generated method stub
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
	public Long getRemarkbb() {
		return remarkbb;
	}
	public void setRemarkbb(Long remarkbb) {
		this.remarkbb = remarkbb;
	}
	public Long getRemarkaa() {
		return remarkaa;
	}
	public void setRemarkaa(Long remarkaa) {
		this.remarkaa = remarkaa;
	}
	public Long getRemarkee() {
		return remarkee;
	}
	public void setRemarkee(Long remarkee) {
		this.remarkee = remarkee;
	}
	public Long getTestid() {
		return testid;
	}
	public void setTestid(Long testid) {
		this.testid = testid;
	}
}