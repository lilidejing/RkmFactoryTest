package com.csw.communication;

import android.graphics.drawable.Drawable;

public class WifiInfo {

	
	private String ssid;//热点名称
	private Drawable hotspotIcon;// 热点图片
	
	private int leved;//信号强度
	private String wifistatus;//热点连接状态
	private String diviceIp;//设备ip
	private String deviceMac;//设备mac
	
	
	private String wifisecurity;//加密
	private String wifiDb;//db
	private String wifiChanel;
	
	
	
	public WifiInfo(String ssid, String wifistatus) {
		super();
		this.ssid = ssid;
		this.wifistatus = wifistatus;
	}
	
	public WifiInfo(String ssid, Drawable hotspotIcon) {
		super();
		this.ssid = ssid;
		this.hotspotIcon = hotspotIcon;
	}

	public WifiInfo() {
		super();
	}
	public WifiInfo(String ssid, int leved, String wifistatus, String diviceIp,
			String deviceMac) {
		super();
		this.ssid = ssid;
		this.leved = leved;
		this.wifistatus = wifistatus;
		this.diviceIp = diviceIp;
		this.deviceMac = deviceMac;
	}
	public String getSsid() {
		return ssid;
	}
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	public int getLeved() {
		return leved;
	}
	public void setLeved(int leved) {
		this.leved = leved;
	}
	public String getWifistatus() {
		return wifistatus;
	}
	public void setWifistatus(String wifistatus) {
		this.wifistatus = wifistatus;
	}
	public String getDiviceIp() {
		return diviceIp;
	}
	public void setDiviceIp(String diviceIp) {
		this.diviceIp = diviceIp;
	}
	public String getDeviceMac() {
		return deviceMac;
	}
	public void setDeviceMac(String deviceMac) {
		this.deviceMac = deviceMac;
	}

	public Drawable getHotspotIcon() {
		return hotspotIcon;
	}

	public void setHotspotIcon(Drawable hotspotIcon) {
		this.hotspotIcon = hotspotIcon;
	}

	public String getWifisecurity() {
		return wifisecurity;
	}

	public void setWifisecurity(String wifisecurity) {
		this.wifisecurity = wifisecurity;
	}

	public String getWifiDb() {
		return wifiDb;
	}

	public void setWifiDb(String wifiDb) {
		this.wifiDb = wifiDb;
	}

	public String getWifiChanel() {
		return wifiChanel;
	}

	public void setWifiChanel(String wifiChanel) {
		this.wifiChanel = wifiChanel;
	}
	
	
	
	
	
	
}
