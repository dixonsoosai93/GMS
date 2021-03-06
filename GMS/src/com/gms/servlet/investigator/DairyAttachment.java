package com.gms.servlet.investigator;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
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

import com.gms.dao.investigator.DailyDairyDAO;
import com.gms.model.investigator.DtDailyDairy;


    @WebServlet("/DairyAttachment")
	@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
	maxFileSize=1024*1024*10,      // 10MB
	maxRequestSize=1024*1024*50)   // 50MB
public class DairyAttachment extends HttpServlet {
	   static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DairyAttachment.class.getName());
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ParseException, SQLException {
		HttpSession session =  request.getSession();
		HashMap<String,String> errors = new HashMap<String, String>();
        
	        if(!ServletFileUpload.isMultipartContent(request)){
				throw new ServletException("Content type is not multipart/form-data");
			}
	        
        	String fileNameWithExtn = "";
	        String fileName = "";
	        String path = "";
	        int CASEID = Integer.parseInt(request.getParameter("CASEID"));
	        int GRVID = Integer.parseInt(request.getParameter("GRVID"));
	        int GRVDETID = Integer.parseInt(request.getParameter("GRVDETID"));;
	        int DAIRYID = Integer.parseInt(request.getParameter("DAIRYID"));
	        String FILENAME = request.getParameter("FILENAME");
	        
	        if(FILENAME == null || FILENAME.isEmpty()) {
	        	System.out.println("File Name is reuired");
	        }
	        
	        String appPath = request.getServletContext().getRealPath("");
	        String savePath = appPath + File.separator;
	        File fileSaveDir = new File(savePath);
        	if (!fileSaveDir.exists()) {
        		fileSaveDir.mkdir();
        	}
        
        	for (Part part : request.getParts()) {
                fileName = extractFileName(part);
                if(fileName != "") {
                	fileName = new File(fileName).getName().replace(" ","");
                	fileNameWithExtn = new File(fileName).getName().replace(" ","");
                	path = savePath + File.separator + fileName;
                	part.write(savePath + File.separator + fileName);
                }
            }
		        	
            DtDailyDairy dailyDairy= new DtDailyDairy();
            dailyDairy.setDAIRYID(DAIRYID);
            dailyDairy.setCASEID(CASEID);
            dailyDairy.setFILENAME(FILENAME);
            dailyDairy.setFILEPATH(path);
            dailyDairy.setFileNameXtn(fileNameWithExtn);
            	try {
	                boolean success = DailyDairyDAO.insertDailyDairyAttach(dailyDairy);
	                String url;
	                if(success) {
	                    url = "ViewCaseRecord.jsp?CASEID="+CASEID+"&GRVID="+GRVID+"&GRVDETID="+GRVDETID;
	                    session.setAttribute("success-message", "Document Uploaded successfully");
	                }else {
	                    session.setAttribute("authError", "Error in uploading document");
	                    url = "DailyDairyUpdationList.jsp";
	                }
	                response.sendRedirect(url);
	            } catch (Exception ex) {
	            	ex.printStackTrace();
	            	Logger.getLogger(DairyAttachment.class.getName()).log(Level.SEVERE, null, ex);
	            }
	}
	            
	private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items){
            if (s.trim().startsWith("filename")){
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
