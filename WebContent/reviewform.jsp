<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bits.cms.entity.Paper"%>
<%@page import=" java.io.InputStream"%>
<%@page import=" java.io.OutputStream"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>BITScon</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<!--GOOGLE FONT -->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css'>
<!--BOOTSTRAP MAIN STYLES -->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!--FONTAWESOME MAIN STYLE -->
<link href="assets/css/font-awesome.min.css" rel="stylesheet" />
<!--CUSTOM STYLE -->
<link href="assets/css/style.css" rel="stylesheet" />
<link href="assets/css/header.css" rel="stylesheet" />
</head>
<body>
	<div class="loader"></div>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container" style="width: 100%">
			<div class="navbar-header">
				<%
					String userName = (String) session.getAttribute("username");
					if (userName == null) {
				%>
				<a class="navbar-brand" href="#">Welcome Guest</a>
				<%
					} else {
				%>
				<a class="navbar-brand" href="#">Welcome, <%=userName%>
				</a>
				<%
					}
				%>
			</div>
			<div class="menu-wrap">
				<div class="menu">
					<ul class="clearfix">
						<%
							if (userName != null) {
						%>
						<li><a href="logout.jsp">LOGOUT</a></li>
						<%
							}
						%>
						<li><a href="venue.jsp">VENUE</a></li>
						<li><a href="#">PROGRAMME <span class="arrow">&#9660;</span>
						</a>
							<ul class="sub-menu">
								<li><a href="workshop.jsp">WORKSHOPS</a></li>
							</ul></li>
						<li><a href="#">CONFERENCE <span class="arrow">&#9660;</span>
						</a>
							<ul class="sub-menu">
								<li><a href="subjects.jsp">SUBJECTS</a></li>
								<li><a href="speaker.jsp">SPEAKERS</a></li>
								<li><a href="events.jsp">EVENTS</a></li>
							</ul></li>
						<li><a href="#">REVIEWER <span class="arrow">&#9660;</span>
						</a>
							<ul class="sub-menu">
								<li onclick="show('reviewpaperform')"><a href="#">REVIEW
										PAPER</a></li>
							</ul></li>
						<li><a href="index.jsp">HOME</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- HEADER SECTION -->
	<div id="header-section">
		<div class="container">
			<div class="row text-center">
				<div class="col-md-10 col-md-offset-1 col-sm-12">
					<h1>
						<strong>BITScon</strong>
					</h1>
					<br /> <br /> <br />
					<h2></h2>
					<br />
					<h3>
						EXPLORE <a href="#about-section"> <i
							class="fa fa-flask down-icon"></i>
						</a> INNOVATE

					</h3>
					<br /> <br />
				</div>
			</div>
		</div>
	</div>
	<!--END HEADER SECTION -->
	<!-- BASIC INFO SECTION -->
	<div class="row main-low-margin text-center">
		<% String title = (String)session.getAttribute("ASSIGNRATINGTOPAPER"); %>
				<form method = "post" action="ReviewerServlet">
				<input type="hidden" value="reviewselectedpaper" name="action">
				<table border="2" align="center">
				<tr><td><label>RATING FOR PAPER</label></td>
					<td><input type="text" name="rating"></td></tr>
				<tr><td><label>COMMENT FOR PAPER</label></td>
					<td><input type="text" name="comment"></td></tr>
				<tr><td colspan = "2"><input type="submit" value="SUBMIT RATING"></td></tr>
				</table>
				</form>
	</div>
	<!--END BASIC INFO SECTION -->
	<!--FOOTER SECTION -->
	<div id="footer"><%@ include file="footer.jsp"%>
	</div>
	<!--END FOOTER SECTION -->
	<!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
	<!-- CORE JQUERY LIBRARY -->
	<script src="assets/js/jquery.js"></script>
	<!-- CORE BOOTSTRAP LIBRARY -->
	<script src="assets/js/bootstrap.min.js"></script>
	<!-- CUSTOM SCRIPT-->
	<script src="assets/js/custom.js"></script>
</body>
</html>