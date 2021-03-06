package com.gms.servlet.admin;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.gms.dao.admin.ReopenAttachmentDao;
import com.gms.model.admin.ReopenAttachment;
import com.gms.servlet.investigator.DairyAttachment;

@WebServlet("/ReopenClosedAttachment")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)   // 50MB
public class ReopenClosedAttachment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    static Logger logger = Logger.getLogger(DairyAttachment.class.getName());
	private static final String SAVE_DIR = "/uploadedFiles";
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ParseException, SQLException {
		logger.info("Inside the processRequest() method ");
		HttpSession session =  request.getSession();
        if(!ServletFileUpload.isMultipartContent(request)){
			throw new ServletException("Content type is not multipart/form-data");
		}
        
        String fileName = "";
        String fileNameWithExtn = "";
        String path = "";
        int GRVDETID = Integer.parseInt(request.getParameter("GRVDETID"));
        int GRVID = Integer.parseInt(request.getParameter("GRVID"));
        String ATTACH_REMARKS = request.getParameter("ATTACH_REMARKS");
        String IS_ACTIVE = request.getParameter("IS_ACTIVE");
        String FILENAME = request.getParameter("FILENAME");
        
        String appPath = request.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + SAVE_DIR;

        File fileSaveDir = new File(savePath);
        if(!fileSaveDir.exists()) {
        	fileSaveDir.mkdir();
        }
        fileSaveDir.canWrite();
        fileSaveDir.setExecutable(true);
        fileSaveDir.setReadable(true, false);
        fileSaveDir.setExecutable(true, false);
        
        for (Part part : request.getParts()) {
            fileName = extractFileName(part);
            if(fileName != "") {
            	fileName = new File(fileName).getName().replace(" ","");
            	fileNameWithExtn = new File(fileName).getName().replace(" ","");
            	path = savePath + File.separator + fileName;
            	part.write(savePath + File.separator + fileName);
            }
        }
        
        ReopenAttachment reAttach = new ReopenAttachment();
        reAttach.setGRVDETID(GRVDETID);
       	reAttach.setGRVID(GRVID);
       	reAttach.setATTACH_REMARKS(ATTACH_REMARKS);
       	reAttach.setIS_ACTIVE(IS_ACTIVE);
       	reAttach.setFILENAME(FILENAME);
       	reAttach.setFILEPATH(path);
       	reAttach.setFileNameExtns(fileNameWithExtn);
        try {
            boolean success = ReopenAttachmentDao.insertReopenAttachment(reAttach);
            String url;
            if(success) {
                url ="ReopenClosed.jsp?GRVDETID="+GRVDETID; 
                session.setAttribute("success-message", "Document Uploaded successfully");
            }else {
                session.setAttribute("authError", "Error in uploading document");
                url = "ReopenClosedAttachment.jsp?CASEID="+GRVID+"&GRVDETID="+GRVDETID;
            }
            response.sendRedirect(url);
        } catch (Exception ex) {
        	ex.printStackTrace();
    		logger.info("Exception inside the processRequest() method Exception : "+ ex.getMessage());
        	Logger.getLogger(DairyAttachment.class.getName()).log(Level.SEVERE, null, ex);
        }
		logger.info("Leaving the processRequest() method ");
	}
	            
	private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			Logger.getLogger(DairyAttachment.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			Logger.getLogger(DairyAttachment.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
	}
}
