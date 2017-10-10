<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bits.cms.entity.Paper"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BITScon</title>
<script type="text/javascript">
	function show(target) {
		if (target == 'selectpapersform') {
			document.getElementById('selectpapersform').style.display = "block";
			document.getElementById('modifyreviewersform').style.display = "none";
			document.getElementById('modifysubjectsform').style.display = "none";
			document.getElementById('modifyspeakersform').style.display = "none";
			document.getElementById('createconferenceform').style.display = "none";
			document.getElementById('addreviewerform').style.display = "none";
			document.getElementById('deletereviewerform').style.display = "none";
			document.getElementById('adddeadlinesform').style.display = "none";
			document.getElementById('deldeadlinesform').style.display = "none";
			document.getElementById('evaluatepaperform').style.display = "none";
		
		} else if (target == 'modifyreviewersform') {
			document.getElementById('selectpapersform').style.display = "none";
			document.getElementById('modifyreviewersform').style.display = "block";
			document.getElementById('modifysubjectsform').style.display = "none";
			document.getElementById('modifyspeakersform').style.display = "none";
			document.getElementById('createconferenceform').style.display = "none";
			document.getElementById('addreviewerform').style.display = "none";
			document.getElementById('deletereviewerform').style.display = "none";
			document.getElementById('adddeadlinesform').style.display = "none";
			document.getElementById('deldeadlinesform').style.display = "none";
			document.getElementById('evaluatepaperform').style.display = "none";
			
		} else if (target == 'modifysubjectsform') {
			document.getElementById('selectpapersform').style.display = "none";
			document.getElementById('modifyreviewersform').style.display = "none";
			document.getElementById('modifysubjectsform').style.display = "block";
			document.getElementById('modifyspeakersform').style.display = "none";
			document.getElementById('createconferenceform').style.display = "none";
			document.getElementById('addreviewerform').style.display = "none";
			document.getElementById('deletereviewerform').style.display = "none";
			document.getElementById('deldeadlinesform').style.display = "none";
			document.getElementById('adddeadlinesform').style.display = "none";
			document.getElementById('evaluatepaperform').style.display = "none";
		} else if (target == 'adddeadlinesform') {
			document.getElementById('selectpapersform').style.display = "none";
			document.getElementById('modifyreviewersform').style.display = "none";
			document.getElementById('modifysubjectsform').style.display = "none";
			document.getElementById('adddeadlinesform').style.display = "block";
			document.getElementById('modifyspeakersform').style.display = "none";
			document.getElementById('createconferenceform').style.display = "none";
			document.getElementById('addreviewerform').style.display = "none";
			document.getElementById('deletereviewerform').style.display = "none";
			document.getElementById('deldeadlinesform').style.display = "none";
			document.getElementById('evaluatepaperform').style.display = "none";
		} else if (target == 'deldeadlinesform') {
			document.getElementById('selectpapersform').style.display = "none";
			document.getElementById('modifyreviewersform').style.display = "none";
			document.getElementById('modifysubjectsform').style.display = "none";
			document.getElementById('adddeadlinesform').style.display = "none";
			document.getElementById('deldeadlinesform').style.display = "block";
			document.getElementById('modifyspeakersform').style.display = "none";
			document.getElementById('createconferenceform').style.display = "none";
			document.getElementById('addreviewerform').style.display = "none";
			document.getElementById('deletereviewerform').style.display = "none";
			document.getElementById('evaluatepaperform').style.display = "none";
		} else if (target == 'modifyspeakersform') {
			document.getElementById('selectpapersform').style.display = "none";
			document.getElementById('modifyreviewersform').style.display = "none";
			document.getElementById('modifysubjectsform').style.display = "none";
			document.getElementById('modifyspeakersform').style.display = "block";
			document.getElementById('createconferenceform').style.display = "none";
			document.getElementById('addreviewerform').style.display = "none";
			document.getElementById('deletereviewerform').style.display = "none";
			document.getElementById('adddeadlinesform').style.display = "none";
			document.getElementById('deldeadlinesform').style.display = "none";
			document.getElementById('evaluatepaperform').style.display = "none";
		} else if (target == 'createconferenceform') {
			document.getElementById('selectpapersform').style.display = "none";
			document.getElementById('modifyreviewersform').style.display = "none";
			document.getElementById('modifysubjectsform').style.display = "none";
			document.getElementById('modifyspeakersform').style.display = "none";
			document.getElementById('createconferenceform').style.display = "block";
			document.getElementById('addreviewerform').style.display = "none";
			document.getElementById('deletereviewerform').style.display = "none";
			document.getElementById('adddeadlinesform').style.display = "none";
			document.getElementById('deldeadlinesform').style.display = "none";
			document.getElementById('evaluatepaperform').style.display = "none";
		} else if (target == 'addreviewerform') {
			document.getElementById('selectpapersform').style.display = "none";
			document.getElementById('modifyreviewersform').style.display = "none";
			document.getElementById('modifysubjectsform').style.display = "none";
			document.getElementById('modifyspeakersform').style.display = "none";
			document.getElementById('createconferenceform').style.display = "none";
			document.getElementById('addreviewerform').style.display = "block";
			document.getElementById('deletereviewerform').style.display = "none";
			document.getElementById('adddeadlinesform').style.display = "none";
			document.getElementById('deldeadlinesform').style.display = "none";
			document.getElementById('evaluatepaperform').style.display = "none";
		} else if (target == 'deletereviewerform') {
			document.getElementById('selectpapersform').style.display = "none";
			document.getElementById('modifyreviewersform').style.display = "none";
			document.getElementById('modifysubjectsform').style.display = "none";
			document.getElementById('modifyspeakersform').style.display = "none";
			document.getElementById('createconferenceform').style.display = "none";
			document.getElementById('addreviewerform').style.display = "none";
			document.getElementById('deletereviewerform').style.display = "block";
			document.getElementById('adddeadlinesform').style.display = "none";
			document.getElementById('deldeadlinesform').style.display = "none";
			document.getElementById('evaluatepaperform').style.display = "none";
		}
		else if (target == 'evaluatepaperform') {
			document.getElementById('selectpapersform').style.display = "none";
			document.getElementById('modifyreviewersform').style.display = "none";
			document.getElementById('modifysubjectsform').style.display = "none";
			document.getElementById('modifyspeakersform').style.display = "none";
			document.getElementById('createconferenceform').style.display = "none";
			document.getElementById('addreviewerform').style.display = "none";
			document.getElementById('deletereviewerform').style.display = "none";
			document.getElementById('adddeadlinesform').style.display = "none";
			document.getElementById('deldeadlinesform').style.display = "none";
			document.getElementById('evaluatepaperform').style.display = "block";
		}
	}
</script>
</head>
<body>
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
						<li><a href="#">EDITORS <span class="arrow">&#9660;</span>
						</a>
							<ul class="sub-menu">
								<li><a href="#" onclick="show('createconferenceform')">CREATE
										CONFERENCE </a></li>
								<li><a href="#" onclick="show('selectpapersform')">SELECT
										PAPERS</a></li>
								<li><a href="#">MODIFY REVIEWERS<span class="arrow">&#9660;</span></a>
									<ul class="subsub-menu">
										<li><a href="#" onclick="show('addreviewerform')">ADD
												REVIEWER</a></li>
										<li><a href="#" onclick="show('deletereviewerform')">DELETE
												REVIEWER</a></li>
									</ul></li>
								<li><a href="#" onclick="show('modifysubjectsform')">MODIFY
										SUBJECTS</a></li>
								<li><a href="#">MODIFY KEY DATES<span class="arrow">&#9660;</span></a>
										<ul class="subsub-menu">
										<li><a href="#" onclick="show('adddeadlinesform')">ADD
												DEADLINES</a></li>
										<li><a href="#" onclick="show('deldeadlinesform')">DELETE
												DEADLINES</a></li>
									</ul></li>
										<li><a href="#" onclick="show('modifyspeakersform')">MODIFY
										SPEAKERS<span class="arrow">&#9660;</span></a>
										<ul class="subsub-menu">
											<li><a href="#" onclick="show('addreviewerform')">ADD
												SPEAKERS</a></li>
											<li><a href="#" onclick="show('deletereviewerform')">DELETE
												SPEAKERS</a></li>
										</ul></li>
							</ul></li>
							<li><a href="#" onclick="show('evaluatepaperform')">EVALUATE PAAER</a></li>
						<li><a href="#">CONFERENCE <span class="arrow">&#9660;</span>
						</a>
							<ul class="sub-menu">
								<li><a href="subjects.jsp">SUBJECTS</a></li>
								<li><a href="speaker.jsp">SPEAKERS</a></li>
								<li><a href="events.jsp">EVENTS</a></li>
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
	<div id="basic-info">
		<div class="container">
			<div class="row main-low-margin text-center">
				<%
                	ArrayList<Paper> releventPaper = new ArrayList<Paper>();
                	releventPaper = (ArrayList<Paper>) session.getAttribute("ALLCONFERENCEPAPERS");
                %>
				<table border="2" align="center">
					<tr>
						<th>Title</th>
						<th>Subject Area</th>
						<th>Description</th>
						<th>Author</th>
						<th>Co-Author</th>
						<th>Comment1</th>
						<th>Comment2</th>
						<th>Comment3</th>
						<th>Rating1</th>
						<th>Rating2</th>
						<th>Rating3</th>
						<th>Status</th>
						<th>Evaluate</th>
					</tr>
					<%
						for (Paper paper : releventPaper) {
					%>
					<tr>
						<td align="center"><%=paper.getTitle()%></td>
						<td align="center"><%=paper.getSubjectarea()%></td>
						<td align="center"><%=paper.getDescription()%></td>
						<td align="center"><%=paper.getAuthorname()%></td>
						<td align="center"><%=paper.getCoauthor()%></td>
						<td align="center"><%=paper.getComment1()%></td>
						<td align="center"><%=paper.getComment2()%></td>
						<td align="center"><%=paper.getComment3()%></td>
						<td align="center"><%=paper.getRating1()%></td>
						<td align="center"><%=paper.getRating2()%></td>
						<td align="center"><%=paper.getRating3()%></td>
						<td align="center"><%=paper.getStatus()%></td>
						<td>
							<form method ="post" action="EditorServlet">
								<input type="hidden" name="action" value="evaluateselectedpaper">
								<label>Enter Status(accepted/rejected)</label>
								<input type="text" name="status" >
								 <%session.setAttribute("PAPTITLE", paper.getTitle());
								 	//session.setAttribute("PAPERFILE",paper.getPaperblob());	
								 %>
								<input type = "submit" value="EVALUATE">
							</form>
						</td>

						
					</tr>
					<%
						}
					
					%>
					
				</table>
				
			</div>
			<div class="col-md-8 col-sm-8   text-justify">
				<h3>ABOUT CONFERENCE</h3>
				<p>This conference provides platform for students, teachers,
					Researchers to present their knowledge.</p>
			</div>
			<div class="col-md-3  ">
				<img class="img-circle" src="assets/img/team/team1.png" alt="">
				<h4>
					<strong>Organizer</strong>
				</h4>
				<p>Email : abc@gmail.com</p>
				<p>
					<a href="#"> <i
						class="fa fa-facebook-square fa-2x color-facebook"></i>
					</a> <a href="#"> <i
						class="fa fa-twitter-square fa-2x color-twitter"></i>
					</a> <a href="#"> <i
						class="fa fa-google-plus-square fa-2x color-google-plus"></i>
					</a> <a href="#"> <i
						class="fa fa-linkedin-square fa-2x color-linkedin"></i>
					</a> <a href="#"> <i
						class="fa fa-pinterest-square fa-2x color-pinterest"></i>
					</a>
				</p>
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