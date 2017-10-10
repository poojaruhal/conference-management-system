package com.bits.cms.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bits.cms.service.DBFacade;
import com.bits.cms.service.DBServiceImpl;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "F:/new";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//process only if its multipart content
				HttpSession session = request.getSession();
				String name = "";
		        if(ServletFileUpload.isMultipartContent(request)){
		         
		                List<FileItem> multiparts = null;
						try {
							multiparts = new ServletFileUpload(
							                         new DiskFileItemFactory()).parseRequest(request);
						} catch (FileUploadException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		              
		                for(FileItem item : multiparts){
		                    if(!item.isFormField()){
		                         name = new File(item.getName()).getName();
		                        try {
									item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
		                    }
		                }
		           String filename = name;
		           String filePath = UPLOAD_DIRECTORY;
		           String _title = (String) session.getAttribute("PAPERTOBESUBMITTED");
		           System.out.println(filename);
		           System.out.println(filePath);
		           Boolean flag = false;
		           DBFacade facade = new DBServiceImpl();
		           try {
		        	   System.out.println("CALLING UPLOAD METHOD");
					flag = facade.finalpaperuploading(filename, filePath, _title);
					System.out.println("CALLED UPLOAD METHOD");
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           System.out.println("!!!!!!!!!!!!!!!!!!!!!!!1FLAG VALUE"+flag);
		           //String query = "insert into fileuplaod values('"+filename+"','"+filePath+"')";
//		           String query = "update paper set filename = '"+filename+"' and set filepath = '"+filePath+"' where title = '"+_title+"'";
//		           Connection connection = CmsConnectToDB.createConnection();
//		           Statement statement = connection.createStatement();
//		           int check = statement.executeUpdate(query);
//		           System.out.println("###########CHECK IS "+check);
//		           if(check > 0)
//		           {
//		               //File uploaded successfully
//		               request.setAttribute("message", "File Uploaded Successfully");
//		           }
		                
		            if(flag){
				        request.getRequestDispatcher("/navAuthor.jsp").forward(request, response);
				        }
		        }
		        
		     
			}
	}

