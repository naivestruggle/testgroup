package com.hc.travelers.bean;

public class Site {
	private Integer siteId;
	private Integer siteBusId;
	private Integer siteNo;
	private String siteName;
	private Integer siteReturn;
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	public Integer getSiteBusId() {
		return siteBusId;
	}
	public void setSiteBusId(Integer siteBusId) {
		this.siteBusId = siteBusId;
	}
	public Integer getSiteNo() {
		return siteNo;
	}
	public void setSiteNo(Integer siteNo) {
		this.siteNo = siteNo;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public Integer getSiteReturn() {
		return siteReturn;
	}
	public void setSiteReturn(Integer siteReturn) {
		this.siteReturn = siteReturn;
	}
	@Override
	public String toString() {
		return "Site [siteId=" + siteId + ", siteBusId=" + siteBusId + ", siteNo=" + siteNo + ", siteName=" + siteName
				+ ", siteReturn=" + siteReturn + "]";
	}
	
}
