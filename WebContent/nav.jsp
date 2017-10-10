<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>BITScon</title>
        </head>
        <body>
            <div class="navbar navbar-inverse navbar-fixed-top">
                <div class="container" style="width: 100%">
                    <div class="navbar-header"><% String userName = (String) session.getAttribute("username"); 
					if(userName == null){
					%>
                        <a class="navbar-brand" href="#">Welcome Guest</a><% 
					}
					else{
					%>
                        <a class="navbar-brand" href="#">Welcome, <%= userName %>
                        </a><% } %>
                    </div>
                    <div class="menu-wrap">
                        <div class="menu">
                            <ul class="clearfix"><% if(userName !=  null) { %>
                                <li>
                                    <a href="logout.jsp">LOGOUT</a>
                                </li><% } %>
                                <li>
                                    <a href="venue.jsp">VENUE</a>
                                </li>
                                <li>
                                    <a href="#">PROGRAMME
                                        <span class="arrow">&#9660;</span>
                                    </a>
                                    <ul class="sub-menu">
                                        <li>
                                            <a href="workshop.jsp">WORKSHOPS</a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="#">CONFERENCE
                                        <span class="arrow">&#9660;</span>
                                    </a>
                                    <ul class="sub-menu">
                                        <li>
                                            <a href="subjects.jsp">SUBJECTS</a>
                                        </li>
                                        <li>
                                            <a href="speaker.jsp">SPEAKERS</a>
                                        </li>
                                        <li>
                                            <a href="events.jsp">EVENTS</a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="index.jsp">HOME</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </body>
    </html>