package com.gms.servlet.investigator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gms.dao.investigator.DailyDairyDAO;
import com.gms.model.investigator.DtDailyDairy;


@WebServlet("/DairyDownload")
public class DairyDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int BUFFER_SIZE = 4096; 
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DairyDownload.class.getName());
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException { 
//        int ATTACHID = Integer.parseInt(request.getParameter("ATTACHID"));
//        	DtDailyDairy dailyDairy= DailyDairyDAO.getDailyDairyAttachFile(ATTACHID);
//        	String filePath =dailyDairy.getFILEPATH();
//        	
//        	File downloadFile = new File(filePath);
//        	FileInputStream inStream = new FileInputStream(downloadFile);
//        		
//        		String relativePath = getServletContext().getRealPath("");
//        		
//	        		ServletContext context = getServletContext();
//	        		String mimeType = context.getMimeType(filePath);
//	        			if (mimeType == null) {        
//	        				mimeType = "application/octet-stream";
//	        			}
//	        			response.setContentType(mimeType);
//	        			response.setContentLength((int) downloadFile.length());
//	        
//	        		String headerKey = "Content-Disposition";
//	        		String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
//	        		response.setHeader(headerKey, headerValue);
//        
//	        	OutputStream outStream = response.getOutputStream();
//	        	byte[] buffer = new byte[4096];
//	        	int bytesRead = -1;
//	        	while ((bytesRead = inStream.read(buffer)) != -1) {
//	        		outStream.write(buffer, 0, bytesRead);
//	        	}
//	        inStream.close();
//	        outStream.close();  
		
		int attachmentId = Integer.parseInt(request.getParameter("ATTACHID"));
		DtDailyDairy attachmentFile = DailyDairyDAO.getDailyDairyAttachFile(attachmentId);
		
		int fileLength = attachmentFile.getCASEID();
		String filename = attachmentFile.getFILENAME();
		System.out.println("fileLength : "+fileLength+" filename : "+filename);
		
		File downloadFile = new File(filename);
		FileInputStream inputStream = new FileInputStream(downloadFile);
		ServletContext context = getServletContext();
		String mimeType = context.getMimeType(filename);
			
			if (mimeType == null) {        
				mimeType = "application/octet-stream";
			}
		response.setContentType(mimeType);
		response.setContentLength(fileLength);
		
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", filename);
		
		response.setHeader(headerKey, headerValue);
		OutputStream outStream = response.getOutputStream();
		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = -1;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}

		inputStream.close();
		outStream.close(); 
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			Logger.getLogger(DairyDownload.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			Logger.getLogger(DairyDownload.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
	}
}