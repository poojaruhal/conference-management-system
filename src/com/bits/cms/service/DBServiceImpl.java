package com.bits.cms.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;

import com.bits.cms.dao.CmsDAO;
import com.bits.cms.entity.Deadline;
import com.bits.cms.entity.Events;
import com.bits.cms.entity.Keydates;
import com.bits.cms.entity.Paper;
import com.bits.cms.entity.Reviewer;
import com.bits.cms.entity.Speaker;

public class DBServiceImpl implements DBFacade{

	@Override
	public String checkUserDetails(String _username, String _password) throws ClassNotFoundException, SQLException {
		//Boolean flag = false;
		String role = "";
		
		CmsDAO cmsdao = new CmsDAO();
		role = cmsdao.getUserDetails(_username, _password);
		//System.out.println("IN DBSERVICEIMPL, flag = "+flag);
		
		return role;
	}

	@Override
	public Boolean registerUser(String _firstname, String _lastname, String _phonenumber, String _emailaddress,
			String _qualification, String _city, String _country, String _pincode, String _username, String _password,
			String _role) throws ClassNotFoundException, SQLException {
		Boolean flag = false;
		
		//System.out.println("Calling getRegistered");
		CmsDAO cmsdao = new CmsDAO();
		flag = cmsdao.getRegistered(_firstname, _lastname, _phonenumber, _emailaddress, _qualification, _city, _country, _pincode, _username, _password, _role);
		//System.out.println("Calling getRegistered successful, flag value is "+flag);
		
		return flag;
	}
	
	@Override
	public Boolean uploadPaper(String _title, String _subjectarea, String _description,
			String _coauthor, String _authorname) throws ClassNotFoundException, SQLException, IOException {
		
		Boolean flag = false;
		
		CmsDAO cmsdao = new CmsDAO();
		flag = cmsdao.uplaodPaperDetails(_title, _subjectarea, _description, _coauthor, _authorname);
		System.out.println("Calling uploadPaper successful, flag value is "+flag);
		
		return flag;
	}

	@Override
	public ArrayList<Events> getAllEvents() throws ClassNotFoundException, SQLException {
		ArrayList<Events> showEvents = new ArrayList<Events>();
		
		CmsDAO cmsdao = new CmsDAO();
		showEvents = cmsdao.showEvents();
		
		return showEvents;
	}
	
	@Override
	public ArrayList<Keydates> getEventDates() throws ClassNotFoundException, SQLException {
		ArrayList<Keydates> keydateEvents = new ArrayList<Keydates>();
		
		CmsDAO cmsdao = new CmsDAO();
		keydateEvents = cmsdao.getEventKeydates();
		
		return keydateEvents;
	}
	
	@Override
	public Boolean registerForEvents(String eventname, String username) throws ClassNotFoundException, SQLException {
		
		Boolean flag = false;
		
		CmsDAO cmsdao = new CmsDAO();
		flag = cmsdao.registerAttendeeForEvent(eventname, username);
		
		return flag;
	}

	@Override
	public ArrayList<Paper> getPapers(String username) throws SQLException, ClassNotFoundException {
		ArrayList<Paper> showPapers = new ArrayList<Paper>();
		
		CmsDAO cmsdao = new CmsDAO();
		showPapers = cmsdao.showSubmitedPapers(username);
		
		return showPapers;
	}

	@Override
	public Boolean createConference(String _name, String _description, String _startdate, String _starttime, String _enddate,
			String _endtime, String _subject1, String _subject2, String _subject3, String _subject4, String _subject5,
			String _venuename, String _city, String _country, String _pincode) throws ClassNotFoundException, SQLException {
		
		Boolean flag = false;
		
		CmsDAO cmsdao = new CmsDAO();
		flag = cmsdao.createConf(_name,_description,_startdate,_starttime,_enddate,_endtime,_subject1,_subject2,_subject3,_subject4,_subject5,_venuename,_city,_country,_pincode);
		
		
		return flag;
	}

	@Override
	public Boolean addReviewer(String _firstname, String _lastname, int _phonenumber, String _emailaddress,
			String _qualification,String _city,String _country,int _pincode, String _username, String _password, String _role,  String _expertarea) throws ClassNotFoundException, SQLException {
		Boolean flag = false;
		
		System.out.println("Calling  reviewer getRegistered");
		CmsDAO cmsdao = new CmsDAO();
		flag = cmsdao.addReviewer(_firstname, _lastname, _phonenumber, _emailaddress, _qualification,_city,_country,_pincode, _username, _password, _role, _expertarea);
		System.out.println(" Reviewer : Calling getRegistered successful, flag value is "+flag);
		
		return flag;
	
	}
	
	@Override
	public ArrayList<Speaker> getspeakers() throws ClassNotFoundException, SQLException {
		
		ArrayList<Speaker> speakerList = new ArrayList<Speaker>();
		
		//System.out.println("Calling  reviewer getRegistered");
		CmsDAO cmsdao = new CmsDAO();
		speakerList = cmsdao.getExistingSpeakers();
		//System.out.println(" Reviewer : Calling getRegistered successful, flag value is "+flag);
		
		return speakerList;
	}

	@Override
	public Boolean withdrawPaper(String username, String title) throws ClassNotFoundException, SQLException {
		Boolean flag = false;
		CmsDAO cmsdao = new CmsDAO();
		flag = cmsdao.withdrawPaper(username,title);
		return flag;
	}

	@Override
	public String trackPaper(String username, String title) throws ClassNotFoundException, SQLException {
		String status;
		CmsDAO cmsdao = new CmsDAO();
		status = cmsdao.trackPaper(username,title);
		return status;
	}
	

	@Override
	public ArrayList<Reviewer> getAllreviewer() throws ClassNotFoundException, SQLException {
		CmsDAO dao = new CmsDAO();
		ArrayList<Reviewer> showReviewerList = new ArrayList<Reviewer>();
		
			showReviewerList = dao.showReviewerList();
	
		
		return showReviewerList;
	}
	
	@Override
	public ArrayList<Deadline> getAlldeadlines() {
		CmsDAO dao = new CmsDAO();
		ArrayList<Deadline> deadlinesList = new ArrayList<Deadline>();
		try {
			deadlinesList = dao.showDeadlinesList();
	
		} catch (ClassNotFoundException exception) {
			System.out.println(exception.getMessage());
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		return deadlinesList;
	}
	
	

	@Override
	public boolean deleteReviwer(String username) {
		CmsDAO dao = new CmsDAO();
		Boolean flag = false;
		try {
			flag = dao.deleteReviewer(username);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public boolean delDeadlines(String importantevents) {
		CmsDAO dao = new CmsDAO();
		Boolean flag = false;
		try {
			flag = dao.delDeadlines(importantevents);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
		@Override
	public Boolean adddeadlines(String _importantevents, Date _deadline) throws ClassNotFoundException, SQLException {
		System.out.println("Calling  addkey dates");
		Boolean flag = false;
		 java.sql.Date deadline = new java.sql.Date(_deadline.getTime());
    	
		
		CmsDAO cmsdao = new CmsDAO();
		flag = cmsdao.adddeadlines(_importantevents,deadline);
		System.out.println(" deadline Calling getRegistered successful, flag value is "+flag);
		
		return flag;

	}

		@Override
		public ArrayList<Paper> getPapers() throws ClassNotFoundException, SQLException {
			ArrayList<Paper> showPapers = new ArrayList<Paper>();
			
			CmsDAO cmsdao = new CmsDAO();
			showPapers = cmsdao.showSubmitedPapers();
			
			return showPapers;
		}

		@Override
		public Boolean evaluatePaper(String title, String status) throws ClassNotFoundException, SQLException {
			
			Boolean flag = false;
			CmsDAO cmsdao = new CmsDAO();
			flag = cmsdao.evalPaper(title,status);
			
			return flag;

		}

		@Override
		public Boolean finalpaperuploading(String filename, String filePath, String _title) throws ClassNotFoundException, SQLException {
			Boolean flag = false;
			CmsDAO cmsdao = new CmsDAO();
			flag = cmsdao.finaluploading(filename , filePath, _title);
			return flag;
		}

		@Override
		public Boolean setRating(String rating, String comment, String title) throws ClassNotFoundException, SQLException {
			Boolean flag = false;
			CmsDAO cmsdao = new CmsDAO();
			flag = cmsdao.setReviewerRating(rating, comment, title);
			return flag;
		}

		@Override
		public ArrayList<Paper> getAllPapers() throws SQLException, ClassNotFoundException {
			ArrayList<Paper> showPapers = new ArrayList<Paper>();
			
			CmsDAO cmsdao = new CmsDAO();
			showPapers = cmsdao.showPaperList();
			
			return showPapers;
		}
		
		@Override
		public Boolean setPaperReviewer(String _paperTitle, String _reviewerUsername) throws ClassNotFoundException, SQLException{
			
			Boolean flag = false;
			CmsDAO cmsdao = new CmsDAO();
			System.out.println("calling cmsdao fn");
			flag = cmsdao.setAssignReviewerStatus(_paperTitle,_reviewerUsername);
			System.out.println(" deadline Calling getRegistered successful, flag value is "+flag);
			
			return flag;
	}
	
/*
	@Override
	public Boolean uploadPaper(byte[] bytes, String _title, String _subjectarea, String _description, String _coauthor,
			String _authorname) throws ClassNotFoundException, SQLException {
		
		Boolean flag = false;
		
		
		CmsDAO cmsdao = new CmsDAO();
		flag = cmsdao.uplaodPaperDetails(bytes, _title, _subjectarea, _description, _coauthor, _authorname);
		System.out.println("Calling uploadPaper successful, flag value is "+flag);
		
		return flag;
	}
	

	@Override
	public Boolean uploadPaper(InputStream inputStream, String _title, String _subjectarea, String _description,
			String _coauthor, String _authorname) throws ClassNotFoundException, SQLException {
		Boolean flag = false;
		
		
		CmsDAO cmsdao = new CmsDAO();
		flag = cmsdao.uplaodPaperDetails(inputStream, _title, _subjectarea, _description, _coauthor, _authorname);
		System.out.println("Calling uploadPaper successful, flag value is "+flag);
		
		return flag;
	}
	
	

	@Override
	public Boolean uploadPaper(Part _paperfile, String _title, String _subjectarea, String _description,
			String _coauthor, String _authorname) throws ClassNotFoundException, SQLException, IOException {
		
		Boolean flag = false;
				
		CmsDAO cmsdao = new CmsDAO();
		flag = cmsdao.uplaodPaperDetails(_paperfile, _title, _subjectarea, _description, _coauthor, _authorname);
		System.out.println("Calling uploadPaper successful, flag value is "+flag);
		
		return flag;
	}
	
	

	@Override
	public Boolean uploadPaper(FileItem file, String _title, String _subjectarea, String _description, String _coauthor,
			String _authorname) throws ClassNotFoundException, SQLException, IOException {
		
		Boolean flag = false;
		
		CmsDAO cmsdao = new CmsDAO();
		flag = cmsdao.uplaodPaperDetails(file, _title, _subjectarea, _description, _coauthor, _authorname);
		System.out.println("Calling uploadPaper successful, flag value is "+flag);
		
		return flag;
		
	}

	
	*/

	


	
	
	
}
