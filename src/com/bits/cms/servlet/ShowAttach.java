package com.bits.cms.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowAttach
 */

@WebServlet("/ShowAttach")
public class ShowAttach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAttach() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
			showAttach(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    private static final int DEFAULT_BUFFER_SIZE = 102400;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.setContentType("text/html");
//		HttpSession session = request.getSession();
//		String title = (String) session.getAttribute("PAPERTITLE");
//		Blob paperfile = (Blob) session.getAttribute("PAPERFILE");
//		try {
//			InputStream content = paperfile.getBinaryStream();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//OutputStream outputpdf = response.getOutputStream();
//		response.getOutputStream().write(baos.toByteArray(), 0, (int)newattachobj.getContentLength());
//		session.setAttribute("OUTPUTFILE", outputpdf);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/review.jsp");
//		dispatcher.forward(request, response);
		try {
			showAttach(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public void showAttach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		 
		 
        
        try {
        	
        	HttpSession session = request.getSession();
            Blob paperfile = (Blob) session.getAttribute("PAPERFILE");
            InputStream content = paperfile.getBinaryStream();
            OutputStream outputpdf = response.getOutputStream();
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            
            response.setContentType("application/pdf");
            response.setContentLength(buffer.length);				
            response.getOutputStream().write(buffer, 0, buffer.length);
            
            int length;
            while ((length = content.read(buffer)) > 0) {
                outputpdf.write(buffer, 0, length);
            }
        }
        finally {
            // Gently close streams.
            
        }
//            
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            byte[] buffer;
//            int inputStreamLength = 0;
//            int length = 0;
//            while ((length = newattachobj.getAttach().read(buffer)) > 0) {
//                inputStreamLength += length;
//                baos.write(buffer, 0, length);
//            }
//
//            if (inputStreamLength > newattachobj.getContentLength()) {
//                newattachobj.setContentLength(inputStreamLength);
//            }
//
//            if (response instanceof HttpServletResponse) {
//                HttpServletResponse httpResponse = (HttpServletResponse) response;
//                httpResponse.reset();
//                httpResponse.setHeader("Content-Type", "application/pdf");
//                httpResponse.setHeader("Content-Length", String.valueOf(newattachobj.getContentLength()));
//                httpResponse.setHeader("Content-Disposition", "inline; filename=\"" + newattachobj.getFilename() + "\"");
//            }
//
//            response.getOutputStream().write(baos.toByteArray(), 0, (int)newattachobj.getContentLength());
//
//            //finally
//            response.getOutputStream().flush();
//
//            //clear
//            baos = null;
//
//            System.out.println(newattachobj.getFilename());
//        } finally {
//            // TODO Auto-generated catch block
//            close(response.getOutputStream());
//            close(newattachobj.getAttach());
//        }
//
//    }
//
//    private void close(Closeable resource) throws IOException {
//        if (resource != null) {
//            resource.close();
//        }
//    }
	
	 }
}
