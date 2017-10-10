package com.bits.cms.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;

import com.bits.cms.entity.Deadline;
import com.bits.cms.entity.Events;
import com.bits.cms.entity.Paper;
import com.bits.cms.entity.Reviewer;
import com.bits.cms.entity.Speaker;
import com.bits.cms.entity.Keydates;
import com.bits.cms.helper.CmsConnectToDB;

public class CmsDAO {
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparestatement = null;
	private ResultSet resultSet = null;
	
public String getUserDetails(String _username, String _password) throws ClassNotFoundException, SQLException {
		
		/**
		//String loginQuery = "select * from userDetails where username = "+_username+" and password = "+_password;
		String loginQuery = "select * from userDetails";
		//String loginQuery = "insert into userDetails values(?,?)";
		//String loginQuery = "INSERT INTO userDetails" + "(username, password) VALUES" + "(?,?)";
		
		connection = CmsConnectToDB.createConnection();
		statement = connection.createStatement();
		//preparestatement = connection.prepareStatement(loginQuery);
	    //preparestatement.setString(1, "Pallavi");
		//preparestatement.setString(2,"root");
		resultSet = statement.executeQuery(loginQuery);
		//preparestatement.executeUpdate(loginQuery);
		//System.out.println(resultSet.first());
		while(resultSet.next()){
			System.out.println("IN WHILE");
			System.out.println("IN RESULTSET WHILE LOOP"+resultSet.getString(1));
			flag = true;
		}
		
		//System.out.println("OUTSIDE WHILE");
		/*
		if(resultSet.next()){
			flag = true;
		}
		else{
			flag = false;
		}
		*/
		//Boolean flag = false;
	
		String role = "";
		String loginQuery = "select * from userDetails where username='" + _username + "' and password='" + _password + "'";
		
		connection = CmsConnectToDB.createConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(loginQuery);
		if(resultSet.next()){
			 role = resultSet.getString("role");
		
			//flag = true;
		}
		//System.out.println("IN CMSDAO, flag = "+flag);
		CmsConnectToDB.closeConnection();
		
		return role;	
	}
	
	public ArrayList<Paper> showPaperList() throws ClassNotFoundException,
SQLException {
	  String paperListQry = "select * from paper";
	connection = CmsConnectToDB.createConnection();
	statement = connection.prepareStatement(paperListQry);
	
	resultSet=statement.executeQuery(paperListQry);
		
		ArrayList<Paper> paperList = new ArrayList<Paper>();
		while (resultSet.next()) {
			 Paper paper = new Paper();
			  paper.setPaperid(resultSet.getInt("paperid"));
			  paper.setDescription(resultSet.getString("description"));
			  paper.setSubjectarea(resultSet.getString("subjectarea"));
		      paper.setTitle(resultSet.getString("title"));
		      paperList.add(paper);
		//	System.out.println("Reviewer List"+reviewerList.toString());
		}
		resultSet.close();
		CmsConnectToDB.closeConnection();
		return paperList;
}
	public Boolean setAssignReviewerStatus(String _paperTitle, String _reviewerUsername) throws ClassNotFoundException, SQLException {
		Boolean flag = false;
		int check = 0;
		 String assignqry = " update paper set assignedreviewer1='"+_reviewerUsername+"'where title='"+_paperTitle+"'";
		 System.out.println("papertitle in cms dao"+_paperTitle);
			connection = CmsConnectToDB.createConnection();
			statement = connection.createStatement();
			check = statement.executeUpdate(assignqry);
			System.out.println("check value "+check);
			  connection.close();
			if(check == 1){
				flag = true;
			}
			return flag;
		}

	public Boolean getRegistered(String _firstname, String _lastname, String _phonenumber, String _emailaddress,
			String _qualification, String _city, String _country, String _pincode, String _username, String _password,
			String _role) throws ClassNotFoundException, SQLException {
		
		Boolean flag = false;
		int check = 0;
		String registerQuery = "insert into userDetails values('"+_firstname+"','"+_lastname+"','"+_phonenumber+"','"+_emailaddress+"','"+_qualification+"','"+_city+"','"+_country+"',"+_pincode+",'"+_username+"','"+_password+"','"+_role+"','computer science')";
		
		connection = CmsConnectToDB.createConnection();
		statement = connection.createStatement();
		
		System.out.println("Request to execute query");
		check = statement.executeUpdate(registerQuery);
		System.out.println("Request to execute query successful, check value is "+check);
		if(check == 1){
			flag = true;
		}
		
		return flag;
	}

	public Boolean uplaodPaperDetails(String _title, String _subjectarea, String _description,
			String _coauthor, String _authorname) throws ClassNotFoundException, SQLException, IOException {
		connection = CmsConnectToDB.createConnection();
		Random rand = new Random();
		int max = 100;
		int min = 1;
		int paperid = rand.nextInt((max - min) + 1) + min;
		Boolean flag = false;
		int check = 0;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		java.util.Date date = new java.util.Date();
	    long currentdate = date.getTime();
	    java.sql.Date sqlDate = new java.sql.Date(currentdate);
	    	    
//	    System.out.println("ID: "+paperid);
//	    System.out.println("Title: "+_title);
//	    System.out.println("subjectarea: "+_subjectarea);
//	    System.out.println("desc: "+_description);
//	    System.out.println("co author: "+_coauthor);
//	    System.out.println("author: "+_authorname);
//	    System.out.println("date: "+sqlDate);
	    
	    String paperQuery = "insert into paper values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    preparestatement = connection.prepareStatement(paperQuery);
	   
	    preparestatement.setInt(1, paperid);
	    preparestatement.setInt(2, 0);
	    preparestatement.setInt(3, 0);
	    preparestatement.setInt(4, 0);
	    preparestatement.setString(5, _title);
	    preparestatement.setString(6, _subjectarea);
	    preparestatement.setString(7, _description);
	    preparestatement.setString(8, _coauthor);
	    preparestatement.setString(9, _authorname);
	    preparestatement.setString(10, "EMPTY");
	    preparestatement.setString(11, "EMPTY");
	    preparestatement.setString(12, "EMPTY");
	    preparestatement.setDate(13, sqlDate);
	    preparestatement.setString(14, "EMPTY");
	    preparestatement.setString(15, "EMPTY");
	    preparestatement.setString(16, "EMPTY");
	    preparestatement.setString(17, "Submitted");
	    preparestatement.setString(18, "EMPTY");
	    preparestatement.setString(19, "EMPTY");
	    //System.out.println(sqlDate);
	    
	    check = preparestatement.executeUpdate();
	    if(check == 1){
			flag = true;
		}
	    CmsConnectToDB.closeConnection();
	    return flag;
	    
	    //9829556088
	    
	    /*
		String registerQuery = "insert into paper values("+paperid+",'"+inputStream+"',0,'"+_title+"','"+_subjectarea+"','"+_description+"','"+_coauthor+"','"+_authorname+"','null',to_date('"+sqlDate+"','yyyy/MM/dd'),'null','null','null','null')";
	  
		connection = CmsConnectToDB.createConnection();
		statement = connection.createStatement();
		check = statement.executeUpdate(registerQuery);
		System.out.println("Request to execute query successful, check value is "+check);
		if(check == 1){
			flag = true;
		}
		return flag;
		*/
		/*
		Boolean flag = false;
		int check = 0;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date = new java.util.Date();
	    long currentdate = date.getTime();
	    java.sql.Date sqlDate = new java.sql.Date(currentdate);
		//String registerQuery = "insert into paper values('"+bytes+"',-1,'"+_title+"','"+_subjectarea+"','"+_description+"','"+_coauthor+"','"+_authorname+"','null','"+sqlDate+"','null','null','null','null'";
	    String registerQuery = "insert into ";
		connection = CmsConnectToDB.createConnection();
		statement = connection.createStatement();
		check = statement.executeUpdate(registerQuery);
		System.out.println("Request to execute query successful, check value is "+check);
		if(check == 1){
			flag = true;
		}
		return flag;
		*/
	}

	public ArrayList<Events> showEvents() throws ClassNotFoundException, SQLException {
		
		connection = CmsConnectToDB.createConnection();
		String eventsQuery = "select eventname, eventtype from event";
		statement = connection.prepareStatement(eventsQuery);
		resultSet = statement.executeQuery(eventsQuery);
		ArrayList<Events> eventList = new ArrayList<Events>();

		while (resultSet.next()) {
			Events events = new Events();
			
			//events.setEventid(resultSet.getInt("eventid"));
			events.setEventname(resultSet.getString("eventname"));
			events.setEventtype(resultSet.getString("eventtype"));
			//events.setStarttime(resultSet.getString("starttime"));
			//events.setEndtime(resultSet.getString("endtime"));
			//events.setStartdate(resultSet.getString("startdate"));
			//events.setEnddate(resultSet.getString("enddate"));
			eventList.add(events);
		}
		resultSet.close();
		CmsConnectToDB.closeConnection();
		return eventList;
		
	}
	
public ArrayList<Keydates> getEventKeydates() throws ClassNotFoundException, SQLException {
		
		connection = CmsConnectToDB.createConnection();
		//String keydateQuery = "select startdate, starttime, enddate, endtime from keydates where keydates.eventname = event.eventname";
		String keydateQuery = "select * from keydates, event where keydates.eventname like event.eventname";
		statement = connection.prepareStatement(keydateQuery);
		resultSet = statement.executeQuery(keydateQuery);
		ArrayList<Keydates> kd = new ArrayList<Keydates>();
		while (resultSet.next()) {
			Keydates keydates = new Keydates();
			keydates.setKeydateid(resultSet.getInt("keydateid"));
			keydates.setStartdate(resultSet.getDate("startdate"));
			keydates.setStarttime(resultSet.getString("starttime"));
			keydates.setEnddate(resultSet.getDate("enddate"));
			keydates.setEndtime(resultSet.getString("endtime"));
			keydates.setEventname(resultSet.getString("eventname"));
			kd.add(keydates);
		}
		resultSet.close();
		
		CmsConnectToDB.closeConnection();
		return kd;
	}

	public Boolean registerAttendeeForEvent(String eventname, String username) throws ClassNotFoundException, SQLException {
		Boolean flag = false;
		int check = 0;
		String checkRegisterEventQuery = "select * from registerevent where (eventname ='"+eventname+"' and attendeename='"+username+"')";
		String registerEventQuery = "insert into registerevent values('"+username+"','"+eventname+"')";
		
		connection = CmsConnectToDB.createConnection();
		statement = connection.createStatement();
		
		resultSet = statement.executeQuery(checkRegisterEventQuery);
		if(!resultSet.next()){
			flag = true;
			System.out.println("FlG after checkRegistr=" +flag);
		}
		if(flag){
			check = statement.executeUpdate(registerEventQuery);
			
			if(check == 1){
				flag = true;
			}
		}
		CmsConnectToDB.closeConnection();
		return flag;
	}

	public ArrayList<Paper> showSubmitedPapers(String username) throws SQLException, ClassNotFoundException {
		
		//String showPapersQuery = "select * from paper, reviewer where paper.assignedreviewer1 = reviewer.username or paper.assignedreviewer2 = reviewer.username or paper.assignedreviewer3 = reviewer.username";
		String showPapersQuery = "select * from paper where assignedreviewer1 = '"+username+"' or assignedreviewer2 = '"+username+"' or assignedreviewer3 = '"+username+"'";
		connection = CmsConnectToDB.createConnection();
		statement = connection.prepareStatement(showPapersQuery);
		resultSet = statement.executeQuery(showPapersQuery);
		ArrayList<Paper> releventPapers = new ArrayList<Paper>();
		//Blob paperblob;
		//byte[] var = null;
		while (resultSet.next()) {
			Paper paper = new Paper();
			
			//paper.setPaperid(resultSet.getInt("paperid"));
			//paper.setRating1(resultSet.getInt("rating1"));
//			paper.setRating2(resultSet.getInt("rating2"));
//			paper.setRating3(resultSet.getInt("rating3"));
			paper.setTitle(resultSet.getString(5));
			paper.setSubjectarea(resultSet.getString(6));
			paper.setDescription(resultSet.getString(7));
//			paper.setCoauthor(resultSet.getString("coauthor"));
//			paper.setAuthorname(resultSet.getString("authorname"));
//			paper.setComment1(resultSet.getString("comment1"));
//			paper.setComment2(resultSet.getString("comment2"));
//			paper.setComment3(resultSet.getString("comment3"));
//			paper.setSubmissiondate(resultSet.getDate("submissiondate"));
//			paper.setAssignedreviewer1(resultSet.getString("assignedreviewer1"));
//			paper.setAssignedreviewer2(resultSet.getString("assignedreviewer2"));
//			paper.setAssignedreviewer3(resultSet.getString("assignedreviewer3"));
//			paper.setStatus(resultSet.getString("status"));
//			paper.setPaperblob(resultSet.getBlob(18));
			paper.setFilename(resultSet.getString("filename"));
			paper.setFilepath(resultSet.getString("filepath"));
			releventPapers.add(paper);
			/*
			events.setEventid(resultSet.getInt("eventid"));
			events.setEventname(resultSet.getString("eventname"));
			events.setEventtype(resultSet.getString("eventtype"));
			events.setStarttime(resultSet.getString("starttime"));
			events.setEndtime(resultSet.getString("endtime"));
			events.setStartdate(resultSet.getString("startdate"));
			events.setEnddate(resultSet.getString("enddate"));
			eventList.add(events);
			*/
			
		}
		resultSet.close();
		CmsConnectToDB.closeConnection();
		return releventPapers;
	}

	public Boolean createConf(String _name, String _description, String _startdate, String _starttime, String _enddate, String _endtime,
			String _subject1, String _subject2, String _subject3, String _subject4, String _subject5, String _venuename,
			String _city, String _country, String _pincode) throws ClassNotFoundException, SQLException {
		
		Random rand = new Random();
		int max = 100;
		int min = 1;
		int conferenceid = rand.nextInt((max - min) + 1) + min;
		int venueid = rand.nextInt((max - min) + 1) + min;
		int keydateid = rand.nextInt((max - min) + 1) + min;
		Boolean flag = false;
		int check1 = 0;
		int check2 = 0;
		int check3 = 0;
		String eventname = "conference";
		String keydateQuery = "insert into keydates values("+keydateid+",to_date('"+_startdate+"','dd/mm/yyyy'),'"+_starttime+"',to_date('"+_enddate+"','dd/mm/yyyy'),'"+_endtime+"','"+eventname+"')";
		String conferenceQuery = "insert into conference values("+conferenceid+",'"+_name+"','"+_description+"','"+_subject1+"','"+_subject2+"','"+_subject3+"','"+_subject4+"','"+_subject5+"',"+keydateid+")";
		//'"+_startdate+"','"+_starttime+"','"+_enddate+"','"+_endtime+"',
		String venueQuery = "insert into venue values("+venueid+",'"+_venuename+"','"+_city+"','"+_country+"','"+_pincode+"')";

		connection = CmsConnectToDB.createConnection();
		statement = connection.createStatement();
		check3 = statement.executeUpdate(keydateQuery);
		check1 = statement.executeUpdate(conferenceQuery);
		check2 = statement.executeUpdate(venueQuery);

		//System.out.println("Request to execute query successful, check value is "+check);
		if(check1 == 1 && check2 == 1 && check3 == 1){
			flag = true;
		}
		
		return flag;
	}	
	
	public Boolean addReviewer(String _firstname, String _lastname, int _phonenumber, String _emailaddress,
			String _qualification,String _city,String _country,int _pincode, String _username, String _password, String _role,  String _expertarea) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	
		Boolean flag = false;
		int check = 0;
		String registerQuery = "insert into userdetails values('"+_firstname+"','"+_lastname+"',"+_phonenumber+",'"+_emailaddress+"','"+_qualification+"','"+_city+"','"+_country+"',"+_pincode+",'"+_username+"','"+_password+"','"+_role+"','"+_expertarea+"')";
		
		connection = CmsConnectToDB.createConnection();
		statement = connection.createStatement();
		System.out.println(" Reviewer Request to execute query");
		check = statement.executeUpdate(registerQuery);
		System.out.println(" Reviewer Request to execute query successful, check value is "+check);
		if(check == 1){
			flag = true;
		}
		
		return flag;
	}

	public ArrayList<Speaker> getExistingSpeakers() throws ClassNotFoundException, SQLException {
		
		String getSpeakrsQuery = "select * from speakers";
		connection = CmsConnectToDB.createConnection();
		statement = connection.prepareStatement(getSpeakrsQuery);
		
		resultSet = statement.executeQuery(getSpeakrsQuery);
		System.out.println("QUERY EXECUTED");
		ArrayList<Speaker> speakerList = new ArrayList<Speaker>();

		while (resultSet.next()) {
			System.out.println("In result SET");
			Speaker speaker = new Speaker();
			//speaker.setSpeakerid(resultSet.getInt("speakerid"));
			speaker.setSpeakername(resultSet.getString("speakername"));
			speaker.setDesignation(resultSet.getString("designation"));
			System.out.println(resultSet.getInt("speakerid"));
			System.out.println(resultSet.getString("speakername"));
			System.out.println(resultSet.getString("designation"));
			speakerList.add(speaker);			
		}
		
		resultSet.close();
		CmsConnectToDB.closeConnection();
		return speakerList;
	}

	public Boolean withdrawPaper(String username, String title) throws SQLException, ClassNotFoundException {
		
		//String withdrawQuery = "delete * from paper where authorname = '"+username+"' and title like '"+title+'"';
		String withdrawQuery = "update paper set status = 'withdrawn' where authorname = '"+username+"' and title like '"+title+"'";
		connection = CmsConnectToDB.createConnection();
		Boolean flag = false;
		int check = 0;
		statement = connection.prepareStatement(withdrawQuery);
		check = statement.executeUpdate(withdrawQuery);
		if(check == 1){
			flag = true;
		}
		CmsConnectToDB.closeConnection();
		return flag;
	}

	public String trackPaper(String username, String title) throws ClassNotFoundException, SQLException {
		
		String trackQuery = "select status from paper where authorname = '"+username+"' and title like '"+title+"'";
		String status = null;
		connection = CmsConnectToDB.createConnection();
		statement = connection.prepareStatement(trackQuery);
		resultSet = statement.executeQuery(trackQuery);
		if (resultSet.next()) {
			System.out.println("In result SET");
			status = resultSet.getString("status");
					
		}
		
		return status;
	}
	
	public ArrayList<Reviewer> showReviewerList() throws ClassNotFoundException,
	SQLException {
		  String reviewerListQry = "select * from userDetails where role='reviewer'";
		connection = CmsConnectToDB.createConnection();
		statement = connection.prepareStatement(reviewerListQry);
		System.out.println(" @@@@@#######@@@@@#####");
		resultSet=statement.executeQuery(reviewerListQry);
			
			ArrayList<Reviewer> reviewerList = new ArrayList<Reviewer>();

			while (resultSet.next()) {
				Reviewer reviewer = new Reviewer();

				reviewer.setFirstname(resultSet.getString("firstname"));
				reviewer.setLastname(resultSet.getString("lastname"));
				reviewer.setPhonenumber(resultSet.getInt("phonenumber"));
				reviewer.setEmail(resultSet.getString("email"));
				reviewer.setQualification(resultSet.getString("qualification"));
				reviewer.setQualification(resultSet.getString("city"));
				reviewer.setQualification(resultSet.getString("country"));
				reviewer.setPhonenumber(resultSet.getInt("pincode"));
				reviewer.setUsername(resultSet.getString("username"));
				reviewer.setPassword(resultSet.getString("password"));
				reviewer.setRole(resultSet.getString("role"));
				reviewer.setExpertarea(resultSet.getString("expertarea"));

				reviewerList.add(reviewer);
				System.out.println("Reviewer List"+reviewerList.toString());
			}
			resultSet.close();
			CmsConnectToDB.closeConnection();
			return reviewerList;
	}
	
	
	
	public ArrayList<Deadline> showDeadlinesList() throws ClassNotFoundException,
	SQLException {
		  String deadlinesListQry = "select * from deadlines";
		connection = CmsConnectToDB.createConnection();
		statement = connection.prepareStatement(deadlinesListQry);
		System.out.println(" deadlines Request to execute query");
		resultSet=statement.executeQuery(deadlinesListQry);
			
			ArrayList<Deadline> deadlinesList = new ArrayList<Deadline>();

			while (resultSet.next()) {
				Deadline deadlines=new Deadline();

			
				deadlines.setImportantEvents(resultSet.getString("importantevents"));
				deadlines.setDeadline(resultSet.getDate("deadline"));
				deadlinesList.add(deadlines);
				
				System.out.println("deadlines List"+deadlinesList.toString());
			}
			resultSet.close();
			CmsConnectToDB.closeConnection();
			return deadlinesList;
	}
	
	public Boolean deleteReviewer(String username) throws ClassNotFoundException, SQLException {
		Boolean flag = false;
		int check = 0;
		 String reviewerListQry = "delete from userdetails where username='"+username+"'";
			connection = CmsConnectToDB.createConnection();
			statement = connection.createStatement();
			check = statement.executeUpdate(reviewerListQry);
			System.out.println(" Reviewer deleted");
			  connection.close();
			if(check == 1){
				flag = true;
			}
			return flag;
		}
	
	
	public Boolean adddeadlines(String _importantevents, java.sql.Date _deadline) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	
		Boolean flag = false;
		int check = 0;
		
		connection = CmsConnectToDB.createConnection();
		String registerQuery = "insert into deadlines(importantevents,deadline) values(?,?)";
		preparestatement = connection.prepareStatement(registerQuery);
		preparestatement.setString(1, _importantevents);
		preparestatement.setDate(2,_deadline);
		check = preparestatement.executeUpdate( );
		System.out.println(" keydate Request to execute query successful, check value is "+check);
		if(check == 1){
			flag = true;
		}
		
		return flag;
	}
		
	public Boolean delDeadlines(String importantevents) throws ClassNotFoundException, SQLException {
		Boolean flag = false;
		int check = 0;
		 String deadlinesListQry = "delete from deadlines where importantevents='"+importantevents+"'";
		 System.out.println("importantevents"+importantevents);
			connection = CmsConnectToDB.createConnection();
			statement = connection.createStatement();
			check = statement.executeUpdate(deadlinesListQry);
			System.out.println("check value "+check);
			System.out.println(" deadline deleted");
			  connection.close();
			if(check == 1){
				flag = true;
			}
			return flag;
		}

	public ArrayList<Paper> showSubmitedPapers() throws SQLException, ClassNotFoundException {
		String showPapersQuery = "select * from paper";
		connection = CmsConnectToDB.createConnection();
		statement = connection.prepareStatement(showPapersQuery);
		resultSet = statement.executeQuery(showPapersQuery);
		ArrayList<Paper> releventPapers = new ArrayList<Paper>();
		Blob paperblob;
		byte[] var = null;
		while (resultSet.next()) {
			Paper paper = new Paper();
			
			paper.setPaperid(resultSet.getInt(1));
			paper.setRating1(resultSet.getInt(2));
			paper.setRating2(resultSet.getInt(3));
			paper.setRating3(resultSet.getInt(4));
			paper.setTitle(resultSet.getString(5));
			paper.setSubjectarea(resultSet.getString(6));
			paper.setDescription(resultSet.getString(7));
			paper.setCoauthor(resultSet.getString(8));
			paper.setAuthorname(resultSet.getString(9));
			paper.setComment1(resultSet.getString(10));
			paper.setComment2(resultSet.getString(11));
			paper.setComment3(resultSet.getString(12));
			paper.setSubmissiondate(resultSet.getDate(13));
			paper.setAssignedreviewer1(resultSet.getString(14));
			paper.setAssignedreviewer2(resultSet.getString(15));
			paper.setAssignedreviewer3(resultSet.getString(16));
			paper.setStatus(resultSet.getString(17));
			//paper.setPaperblob(resultSet.getBlob(18));
			
			
			releventPapers.add(paper);
		}
		resultSet.close();
		CmsConnectToDB.closeConnection();
		return releventPapers;
	}

	public Boolean evalPaper(String title, String status) throws ClassNotFoundException, SQLException {
		Boolean flag = false;
		int check = 0;
		String evaluateQuery="update paper set status='"+status+"' where title='"+title+"'";
		
		connection = CmsConnectToDB.createConnection();
		statement = connection.createStatement();
		check = statement.executeUpdate(evaluateQuery);
		if(check == 1){
			flag = true;
		}
		return flag;
	}

	public Boolean finaluploading(String filename, String filePath, String _title) throws SQLException, ClassNotFoundException {
		Boolean flag = false;
		int check = 0;
		String uploadingQuery="update paper set filename = '"+filename+"' , filepath = '"+filePath+"' where title = '"+_title+"'";
		
		connection = CmsConnectToDB.createConnection();
		statement = connection.createStatement();
		check = statement.executeUpdate(uploadingQuery);
		if(check == 1){
			flag = true;
		}
		return flag;
	}

	public Boolean setReviewerRating(String rating, String comment, String title) throws ClassNotFoundException, SQLException {
		Boolean flag = false;
		int rat = Integer.parseInt(rating);
		int check = 0;
		String setRatingQuery="update paper set rating1 = "+rat+", comment1 = '"+comment+"', status = 'reviewed' where title = '"+title+"'";
		
		connection = CmsConnectToDB.createConnection();
		statement = connection.createStatement();
		check = statement.executeUpdate(setRatingQuery);
		if(check == 1){
			flag = true;
		}
		return flag;
	}
	
	
}
