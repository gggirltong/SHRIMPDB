package com.shrimpdb.entity;
import java.io.Serializable;
public class SampleMount extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long   id;	//��Ʒ������
	private String mountname;  //��Ʒ���
	private String mountimg_url;  // ������
	private Long makeid;    // ������λ
	private String makedate;    // ����ʱ��
	private Long   testid;
	private String testdate;
	private String processdate;    // ����ʱ��
	private Long   flag;
	private String opfile;
	private String remarka;    // ����ʱ��
	private String remarkb;
	private String remarkc;
	private String remarkd;
	private String remarke;
	private String remarkf;	
	private String makename;
	private String testname;
	public String getMakename() {
		return makename;
	}
	public void setMakename(String makename) {
		this.makename = makename;
	}
	public String getTestname() {
		return testname;
	}
	public void setTestname(String testname) {
		this.testname = testname;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMountname() {
		return mountname;
	}
	public void setMountname(String mountname) {
		this.mountname = mountname;
	}
	public String getMountimg_url() {
		return mountimg_url;
	}
	public void setMountimg_url(String mountimg_url) {
		this.mountimg_url = mountimg_url;
	}
	public Long getMakeid() {
		return makeid;
	}
	public String getMakedate() {
		return makedate;
	}
	public void setMakeid(Long makeid) {
		this.makeid = makeid;
	}
	public void setMakedate(String makedate) {
		this.makedate = makedate;
	}
	public Long getTestid() {
		return testid;
	}
	public void setTestid(Long testid) {
		this.testid = testid;
	}
	public String getTestdate() {
		return testdate;
	}
	public void setTestdate(String testdate) {
		this.testdate = testdate;
	}
	public String getProcessdate() {
		return processdate;
	}
	public void setProcessdate(String processdate) {
		this.processdate = processdate;
	}
	public Long getFlag() {
		return flag;
	}
	public void setFlag(Long flag) {
		this.flag = flag;
	}
	public String getOpfile() {
		return opfile;
	}
	public void setOpfile(String opfile) {
		this.opfile = opfile;
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
	public String getRemarke() {
		return remarke;
	}
	public void setRemarke(String remarke) {
		this.remarke = remarke;
	}
	public String getRemarkf() {
		return remarkf;
	}
	public void setRemarkf(String remarkf) {
		this.remarkf = remarkf;
	}	
}