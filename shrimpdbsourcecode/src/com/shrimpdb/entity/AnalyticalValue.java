package com.shrimpdb.entity;
import java.io.Serializable;
public class AnalyticalValue extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long sample_id;
	private String mountname;
	private String spotname;
	private double age204;
	private double err204;
	private double age208;
	private double err208;
	private double U;
	private double Th;
	private double UTh;
	private String fileop;
	private String testdate;
	private String testtime;
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
	public double getAge204() {
		return age204;
	}
	public void setAge204(double age204l) {
		this.age204 = age204l;
	}
	public double getErr204() {
		return err204;
	}
	public void setErr204(double err204) {
		this.err204 = err204;
	}
	public double getAge208() {
		return age208;
	}
	public void setAge208(double age208) {
		this.age208 = age208;
	}
	public double getErr208() {
		return err208;
	}
	public void setErr208(double err208) {
		this.err208 = err208;
	}
	public double getU() {
		return U;
	}
	public void setU(double u) {
		U = u;
	}
	public double getTh() {
		return Th;
	}
	public void setTh(double th) {
		Th = th;
	}
	public double getUTh() {
		return UTh;
	}
	public void setUTh(double uTh) {
		UTh = uTh;
	}
	public String getFileop() {
		return fileop;
	}
	public void setFileop(String fileop) {
		this.fileop = fileop;
	}
	public String getTestdate() {
		return testdate;
	}
	public void setTestdate(String testdate) {
		this.testdate = testdate;
	}
	public String getTesttime() {
		return testtime;
	}
	public void setTesttime(String testtime) {
		this.testtime = testtime;
	}


}