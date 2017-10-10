<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.sql.*" %>
    <%@ page import = "com.bits.cms.helper.*" %>
    <%@ page import = "java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
//String query = "select * from fileuplaod";
String path = "";
String name ="";
  //Connection conn = CmsConnectToDB.createConnection();
  //Statement statement = conn.createStatement();
  //ResultSet resultSet = statement.executeQuery(query);
	//if(resultSet.next()){
		// path = resultSet.getString("filepath");
	    // name = resultSet.getString("filename");
		//flag = true;
	//}
	
  //String filename = "ECCV10_GSRC-Yale B DB.pdf";   
  //String filepath = "F:\\new\\";  
	path = (String)session.getAttribute("FILEPATH");
	name = (String)session.getAttribute("FILENAME");
	String filepath = path + File.separator + name;
  System.out.println("Path " +filepath);
  System.out.println("Name " +name);
  response.setContentType("APPLICATION/OCTET-STREAM");   
  response.setHeader("Content-Disposition","attachment; filename=\"" + name + "\"");   
  
  File downloadFile = new File(filepath);
  if(downloadFile.exists()){


      int length   = 0;


      ServletContext context = getServletContext();
      // gets MIME type of the file
      String mimeType = context.getMimeType(filepath);
      if (mimeType == null) {        
          // set to binary type if MIME mapping not found
          mimeType = "application/octet-stream";
      }
      System.out.println("MIME type: " + mimeType);

      // modifies response
      response.setContentType(mimeType);
      response.setContentLength((int) downloadFile.length());

      // forces download
      String headerKey = "Content-Disposition";
      String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
      response.setHeader(headerKey, headerValue);
      //OutputStream outStream = response.getOutputStream();
      //DataInputStream in = new DataInputStream(new FileInputStream(downloadFile));
      ServletOutputStream outStream = response.getOutputStream();
      FileInputStream in = new FileInputStream(downloadFile);
      byte[] buffer = new byte[4096];
      //int bytesRead = -1;

      int i;   
      while ((in != null) && ((length = in.read(buffer)) != -1))
      {
          outStream.write(buffer,0,length);
      }
          in.close();
          outStream.flush();
          outStream.close();
      //out.close(); 
        response.sendRedirect("navReviewer.jsp");

  }else{
      System.out.println("File does not exist at location "+downloadFile.getAbsolutePath());
  }
%>   
</body>
</html>