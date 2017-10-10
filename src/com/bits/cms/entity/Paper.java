package com.bits.cms.entity;

import java.sql.Blob;
import java.sql.Date;

public class Paper {
	//paper blob
	private int paperid;
	private int rating1;
	private int rating2;
	private int rating3;
	private String title;
	private String subjectarea;
	private String description;
	private String coauthor;
	private String authorname;
	private String comment1;
	private String comment2;
	private String comment3;
	private Date submissiondate;
	private String assignedreviewer1;
	private String assignedreviewer2;
	private String assignedreviewer3;
	private String status;
	//private Blob paperblob;
	private String filename;
	private String filepath;
	
	public int getPaperid() {
		return paperid;
	}
	public void setPaperid(int paperid) {
		this.paperid = paperid;
	}
	public int getRating1() {
		return rating1;
	}
	public void setRating1(int rating1) {
		this.rating1 = rating1;
	}
	public int getRating2() {
		return rating2;
	}
	public void setRating2(int rating2) {
		this.rating2 = rating2;
	}
	public int getRating3() {
		return rating3;
	}
	public void setRating3(int rating3) {
		this.rating3 = rating3;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubjectarea() {
		return subjectarea;
	}
	public void setSubjectarea(String subjectarea) {
		this.subjectarea = subjectarea;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCoauthor() {
		return coauthor;
	}
	public void setCoauthor(String coauthor) {
		this.coauthor = coauthor;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public String getComment1() {
		return comment1;
	}
	public void setComment1(String comment1) {
		this.comment1 = comment1;
	}
	public String getComment2() {
		return comment2;
	}
	public void setComment2(String comment2) {
		this.comment2 = comment2;
	}
	public String getComment3() {
		return comment3;
	}
	public void setComment3(String comment3) {
		this.comment3 = comment3;
	}
	public Date getSubmissiondate() {
		return submissiondate;
	}
	public void setSubmissiondate(Date submissiondate) {
		this.submissiondate = submissiondate;
	}
	public String getAssignedreviewer1() {
		return assignedreviewer1;
	}
	public void setAssignedreviewer1(String assignedreviewer1) {
		this.assignedreviewer1 = assignedreviewer1;
	}
	public String getAssignedreviewer2() {
		return assignedreviewer2;
	}
	public void setAssignedreviewer2(String assignedreviewer2) {
		this.assignedreviewer2 = assignedreviewer2;
	}
	public String getAssignedreviewer3() {
		return assignedreviewer3;
	}
	public void setAssignedreviewer3(String assignedreviewer3) {
		this.assignedreviewer3 = assignedreviewer3;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
//	public Blob getPaperblob() {
//		return paperblob;
//	}
//	public void setPaperblob(Blob paperblob) {
//		this.paperblob = paperblob;
//	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
}
