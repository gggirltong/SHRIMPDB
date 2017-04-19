package com.shrimpdb.entity;
import java.io.Serializable;
public class Process extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long   id;
	private Long   sampleid;
	private String spotname;
	private String common206pb;
	private String U;	
	private String Th;
	private String ThU;
	private String radio206pb;
	private String discondant;
	private String total86;
	private String t_err86;
	private String total76;
	private String t_err76;
	private String four_age68;
	private String four_age68_err;
	private String four_age76;
	private String four_age76_err;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSampleid() {
		return sampleid;
	}
	public void setSampleid(Long sampleid) {
		this.sampleid = sampleid;
	}
	public String getSpotname() {
		return spotname;
	}
	public void setSpotname(String spotname) {
		this.spotname = spotname;
	}
	public String getCommon206pb() {
		return common206pb;
	}
	public void setCommon206pb(String common206pb) {
		this.common206pb = common206pb;
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
	public String getThU() {
		return ThU;
	}
	public void setThU(String thU) {
		ThU = thU;
	}
	public String getDiscondant() {
		return discondant;
	}
	public void setDiscondant(String discondant) {
		this.discondant = discondant;
	}
	public String getTotal86() {
		return total86;
	}
	public void setTotal86(String total86) {
		this.total86 = total86;
	}
	public String getT_err86() {
		return t_err86;
	}
	public void setT_err86(String t_err86) {
		this.t_err86 = t_err86;
	}
	public String getTotal76() {
		return total76;
	}
	public void setTotal76(String total76) {
		this.total76 = total76;
	}
	public String getT_err76() {
		return t_err76;
	}
	public void setT_err76(String t_err76) {
		this.t_err76 = t_err76;
	}
	public String getFour_age68() {
		return four_age68;
	}
	public void setFour_age68(String four_age68) {
		this.four_age68 = four_age68;
	}
	public String getFour_age68_err() {
		return four_age68_err;
	}
	public void setFour_age68_err(String four_age68_err) {
		this.four_age68_err = four_age68_err;
	}
	public String getFour_age76() {
		return four_age76;
	}
	public void setFour_age76(String four_age76) {
		this.four_age76 = four_age76;
	}
	public String getFour_age76_err() {
		return four_age76_err;
	}
	public void setFour_age76_err(String four_age76_err) {
		this.four_age76_err = four_age76_err;
	}
	public String getFour_age82() {
		return four_age82;
	}
	public void setFour_age82(String four_age82) {
		this.four_age82 = four_age82;
	}
	public String getFour_age82_err() {
		return four_age82_err;
	}
	public void setFour_age82_err(String four_age82_err) {
		this.four_age82_err = four_age82_err;
	}
	public String getFour_concen86() {
		return four_concen86;
	}
	public void setFour_concen86(String four_concen86) {
		this.four_concen86 = four_concen86;
	}
	public String getFour_concen86_err() {
		return four_concen86_err;
	}
	public void setFour_concen86_err(String four_concen86_err) {
		this.four_concen86_err = four_concen86_err;
	}
	public String getFour_concen76() {
		return four_concen76;
	}
	public void setFour_concen76(String four_concen76) {
		this.four_concen76 = four_concen76;
	}
	public String getFour_concen75() {
		return four_concen75;
	}
	public void setFour_concen75(String four_concen75) {
		this.four_concen75 = four_concen75;
	}
	public String getFour_concen75_err() {
		return four_concen75_err;
	}
	public void setFour_concen75_err(String four_concen75_err) {
		this.four_concen75_err = four_concen75_err;
	}
	public String getFour_concen68() {
		return four_concen68;
	}
	public void setFour_concen68(String four_concen68) {
		this.four_concen68 = four_concen68;
	}
	public String getFour_concen68_err() {
		return four_concen68_err;
	}
	public void setFour_concen68_err(String four_concen68_err) {
		this.four_concen68_err = four_concen68_err;
	}
	public String getFour_err_corr() {
		return four_err_corr;
	}
	public void setFour_err_corr(String four_err_corr) {
		this.four_err_corr = four_err_corr;
	}
	public String getSeven_age68() {
		return seven_age68;
	}
	public void setSeven_age68(String seven_age68) {
		this.seven_age68 = seven_age68;
	}
	public String getSeven_age68_err() {
		return seven_age68_err;
	}
	public void setSeven_age68_err(String seven_age68_err) {
		this.seven_age68_err = seven_age68_err;
	}
	public String getEight_age68() {
		return eight_age68;
	}
	public void setEight_age68(String eight_age68) {
		this.eight_age68 = eight_age68;
	}
	public String getEight_age68_err() {
		return eight_age68_err;
	}
	public void setEight_age68_err(String eight_age68_err) {
		this.eight_age68_err = eight_age68_err;
	}
	public String getEight_concen86() {
		return eight_concen86;
	}
	public void setEight_concen86(String eight_concen86) {
		this.eight_concen86 = eight_concen86;
	}
	public String getEight_concen86_err() {
		return eight_concen86_err;
	}
	public void setEight_concen86_err(String eight_concen86_err) {
		this.eight_concen86_err = eight_concen86_err;
	}
	public String getEight_concen76() {
		return eight_concen76;
	}
	public void setEight_concen76(String eight_concen76) {
		this.eight_concen76 = eight_concen76;
	}
	public String getEight_concen76_err() {
		return eight_concen76_err;
	}
	public void setEight_concen76_err(String eight_concen76_err) {
		this.eight_concen76_err = eight_concen76_err;
	}
	public String getEight_concen75() {
		return eight_concen75;
	}
	public void setEight_concen75(String eight_concen75) {
		this.eight_concen75 = eight_concen75;
	}
	public String getEight_concen75_err() {
		return eight_concen75_err;
	}
	public void setEight_concen75_err(String eight_concen75_err) {
		this.eight_concen75_err = eight_concen75_err;
	}
	public String getEight_concen68() {
		return eight_concen68;
	}
	public void setEight_concen68(String eight_concen68) {
		this.eight_concen68 = eight_concen68;
	}
	public String getEight_concen68_err() {
		return eight_concen68_err;
	}
	public void setEight_concen68_err(String eight_concen68_err) {
		this.eight_concen68_err = eight_concen68_err;
	}
	public String getEight_err_corr() {
		return eight_err_corr;
	}
	public void setEight_err_corr(String eight_err_corr) {
		this.eight_err_corr = eight_err_corr;
	}
	public String getRadio206pb() {
		return radio206pb;
	}
	public void setRadio206pb(String radio206pb) {
		this.radio206pb = radio206pb;
	}
	private String four_age82;
	private String four_age82_err;
	private String four_concen86;
	private String four_concen86_err;
	private String four_concen76;
	private String four_concen75;
	private String four_concen75_err;
	private String four_concen68;
	private String four_concen68_err;
	private String four_err_corr;
	private String seven_age68;
	private String seven_age68_err;
	private String eight_age68;
	private String eight_age68_err;
	private String eight_concen86;
	private String eight_concen86_err;
	private String eight_concen76;
	private String eight_concen76_err;
	private String eight_concen75;
	private String eight_concen75_err;
	private String eight_concen68;
	private String eight_concen68_err;
	private String eight_err_corr;
}