<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.bits.cms.entity.Deadline"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
	<%ArrayList<Deadline> keydateList = new ArrayList<Deadline>();
                	keydateList = (ArrayList<Deadline>)session.getAttribute("DEADLINESLIST");
                %>
            
<table border="2">
					<tr>
						<th> ImportantEventsName</th>
						<th>Deadline</th>
					</tr>
					<%
					
						for (Deadline rev : keydateList) {
					
					%>
					<tr>
						<td align="center"><%=rev.getImportantEvents()%></td>
						<td align="center"><%=rev.getDeadline()%></td>
						<td align="center">
						
							
						<a href="EditorServlet?importantEvents=<%=rev.getImportantEvents()%>&delete=importantevents">Delete Deadline </a>
						</td>
					</tr>
					<%
						}
					
					%>
					
				</table>
		</form>		
</body>
</html>