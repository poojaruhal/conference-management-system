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
						<li><a href="index.jsp">HOME</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- HEADER SECTION -->
	<!--END HEADER SECTION -->
	<!-- BASIC INFO SECTION -->
		<div id="found-section" >
        <div class="container" >
            <div class="row main-top-margin text-center">
                <div class="col-md-8 col-md-offset-2 " >
 
				<%
                	ArrayList<Paper> releventPaper = new ArrayList<Paper>();
                	releventPaper = (ArrayList<Paper>) session.getAttribute("ASSIGNPAPERLIST");
                %>
				<table border="2" align="center">
					<tr>
						<th>Paper ID</th>
						<th>Title</th>
						<th>Subject Area</th>
						<th>Description</th>
						<th>Assign </th>
					</tr>
					<%
						for (Paper paper : releventPaper) {
					%>
					<tr>
						<td align="center"><%=paper.getPaperid()%></td>
						<td align="center"><%=paper.getTitle()%></td>
						<td align="center"><%=paper.getSubjectarea()%></td>
						<td align="center"><%=paper.getDescription()%></td>		
						<td align="center">
							<form method ="post" action="EditorServlet">
								<input type="hidden" name="action" value="paperassignedreviewer">
								 <%session.setAttribute("ASSIGNPAPERTITLE", paper.getTitle());
								 %>
								<input type = "submit" align="center" value="SHOW REVIEWER">
								</form>
						</td>
				</tr>
					<%
						}
					
					%>
					
				</table>
	</div>
	</div>
	</div>
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