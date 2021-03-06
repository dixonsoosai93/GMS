package com.gms.servlet.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gms.dao.admin.ReopenAttachmentDao;
import com.gms.model.admin.ReopenAttachment;

@WebServlet("/ReopenAttachmentDownload")
public class ReopenAttachmentDownload extends HttpServlet {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ReopenAttachmentDownload.class.getName());
	private static final long serialVersionUID = 1L;
       
    public ReopenAttachmentDownload() {
        super();
    }
    /*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {  
    	int attachmentId = Integer.parseInt(request.getParameter("ATTACHID"));
		ReopenAttachment attachmentFile = ReopenAttachmentDao.reopenFileDownLoad(attachmentId);
		int fileLength = attachmentFile.getFileLength();
		String filename = attachmentFile.getFileNameExtns();
		System.out.println(" ReopenAttachmentDownload filename "+filename);
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
		byte[] buffer = new byte[2048];
		//outStream.write(inputStream.read(buffer));
		int bytesRead = -1;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		inputStream.close();
		outStream.close(); 
    	
            /*  InputStream in = blob.getBinaryStream();
                int fLength = (int) blob.length();
                reAttach.setFileLength(fLength);
                reAttach.setFileNameExtns(fName);
                //byte[] buff = blob.getBytes(1, (int)blob.getLength());
                OutputStream out = new FileOutputStream(fName);
                byte[] buff = new byte[4096];  // how much of the blob to read/write at a time
                while ((fLength = in.read(buff)) != -1) {
                    out.write(buff, 0, fLength);
                }
                
                out.write(buff);
                out.close();
			}*/
        
   // }*/
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {  
    
    	int attachmentId = Integer.parseInt(request.getParameter("ATTACHID"));
    	
    	if(attachmentId != 0) {
			ReopenAttachment attachmentFile = ReopenAttachmentDao.reopenFileDownLoad(attachmentId);
			
			int fileLength = attachmentFile.getFileLength();
			String filename = attachmentFile.getFILEPATH();
			System.out.println("filename 1 "+filename);
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
			byte[] buffer = new byte[2048];
			int bytesRead = -1;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
			inputStream.close();
			outStream.close(); 
    	}
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

}
