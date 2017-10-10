package com.bits.cms.entity;

import java.util.Date;

public class Deadline {
	private String importantEvents; 
	private Date deadline;
	/**
	 * @return the importantEvents
	 */
	public String getImportantEvents() {
		return importantEvents;
	}
	/**
	 * @param importantEvents the importantEvents to set
	 */
	public void setImportantEvents(String importantEvents) {
		this.importantEvents = importantEvents;
	}
	/**
	 * @return the deadline
	 */
	public Date getDeadline() {
		return deadline;
	}
	/**
	 * @param deadline the deadline to set
	 */
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	
}
