package com.hc.travelers.bean;

public class Bus {
	private Integer busId;
	private String busCityline;
	private String busNo;
	private String busBusline;
	private String busRuntime;
	private String busPrice;
	public Integer getBusId() {
		return busId;
	}
	public void setBusId(Integer busId) {
		this.busId = busId;
	}
	public String getBusCityline() {
		return busCityline;
	}
	public void setBusCityline(String busCityline) {
		this.busCityline = busCityline;
	}
	public String getBusNo() {
		return busNo;
	}
	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}
	public String getBusBusline() {
		return busBusline;
	}
	public void setBusBusline(String busBusline) {
		this.busBusline = busBusline;
	}
	public String getBusRuntime() {
		return busRuntime;
	}
	public void setBusRuntime(String busRuntime) {
		this.busRuntime = busRuntime;
	}
	public String getBusPrice() {
		return busPrice;
	}
	public void setBusPrice(String busPrice) {
		this.busPrice = busPrice;
	}
	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busCityline=" + busCityline + ", busNo=" + busNo + ", busBusline="
				+ busBusline + ", busRuntime=" + busRuntime + ", busPrice=" + busPrice + "]";
	}
	
}
