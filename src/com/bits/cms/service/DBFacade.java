package com.bits.cms.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;

import com.bits.cms.entity.Deadline;
import com.bits.cms.entity.Events;
import com.bits.cms.entity.Keydates;
import com.bits.cms.entity.Paper;
import com.bits.cms.entity.Reviewer;
import com.bits.cms.entity.Speaker;

public interface DBFacade {

	String checkUserDetails(String _username, String _password) throws ClassNotFoundException, SQLException;

	Boolean registerUser(String _firstname, String _lastname, String _phonenumber, String _emailaddress,
			String _qualification, String _city, String _country, String _pincode, String _username, String _password,
			String _role) throws ClassNotFoundException, SQLException;

	//Boolean uploadPaper(FileItem file, String _title, String _subjectarea, String _description, String _coauthor,
			//String _authorname) throws ClassNotFoundException, SQLException, IOException;

	Boolean uploadPaper(String _title, String _subjectarea, String _description, String _coauthor,
			String _authorname) throws ClassNotFoundException, SQLException, IOException;

	ArrayList<Events> getAllEvents() throws ClassNotFoundException, SQLException;

	Boolean registerForEvents(String eventname, String username) throws ClassNotFoundException, SQLException;

	ArrayList<Paper> getPapers(String username) throws SQLException, ClassNotFoundException;

	Boolean createConference(String _name,String _description, String _startdate, String _starttime, String _enddate, String _endtime,
			String _subject1, String _subject2, String _subject3, String _subject4, String _subject5, String _venuename,
			String _city, String _country, String _pincode) throws ClassNotFoundException, SQLException;
	Boolean addReviewer(String _firstname, String _lastname, int _phonenumber, String _emailaddress,
			String _qualification,String _city,String _country,int _pincode, String _username, String _password, String _role, String _expertarea) throws ClassNotFoundException, SQLException;

	ArrayList<Speaker> getspeakers() throws ClassNotFoundException, SQLException;

	ArrayList<Keydates> getEventDates() throws ClassNotFoundException, SQLException;

	Boolean withdrawPaper(String username, String title) throws ClassNotFoundException, SQLException;

	String trackPaper(String username, String title) throws ClassNotFoundException, SQLException;
	
	boolean deleteReviwer(String username);
	
	boolean delDeadlines(String importantevents);

	
	ArrayList<Reviewer> getAllreviewer() throws ClassNotFoundException, SQLException;
	
	ArrayList<Deadline> getAlldeadlines();

	Boolean adddeadlines(String _importantevents, java.util.Date _deadline) throws ClassNotFoundException, SQLException;

	ArrayList<Paper> getPapers() throws ClassNotFoundException, SQLException;

	Boolean evaluatePaper(String title, String status) throws ClassNotFoundException, SQLException;

	Boolean finalpaperuploading(String filename, String filePath, String _title) throws ClassNotFoundException, SQLException;

	Boolean setRating(String rating, String comment, String title) throws ClassNotFoundException, SQLException;

	ArrayList<Paper> getAllPapers() throws SQLException, ClassNotFoundException;
	
	Boolean setPaperReviewer(String paperTitle,String reviewerUsername)throws ClassNotFoundException, SQLException;
}
