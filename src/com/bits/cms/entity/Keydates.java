package com.bits.cms.entity;

import java.sql.Date;

public class Keydates {
	private int keydateid;
	private Date startdate;
	private String starttime;
	private Date enddate;
	private String endtime;
	private String eventname;
	
	public int getKeydateid() {
		return keydateid;
	}
	public void setKeydateid(int keydateid) {
		this.keydateid = keydateid;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
}
