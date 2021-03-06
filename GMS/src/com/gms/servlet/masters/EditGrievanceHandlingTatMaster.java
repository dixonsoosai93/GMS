package com.gms.servlet.masters;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.gms.dao.masters.GrievanceHandlingTatMasterDAO;
import com.gms.model.masters.GrievanceHandlingTatModel;
@WebServlet("/EditGrievanceHandlingTatMaster")
public class EditGrievanceHandlingTatMaster extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(EditGrievanceHandlingTatMaster.class.getName());
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Inside the processReuest() method");
		int TATID=Integer.parseInt(request.getParameter("ETATID"));
		int HIERID =Integer.parseInt(request.getParameter("EHIERID"));
		int TATDAYS=Integer.parseInt(request.getParameter("ETATDAYS"));
		int BUFFERDAYS=Integer.parseInt(request.getParameter("EBUFFERDAYS"));
		String IS_ACTIVE=request.getParameter("EIS_ACTIVE");
		
		HashMap<String,String> errors = new HashMap<String, String>();
        HttpSession session =  request.getSession();
        
		GrievanceHandlingTatModel grievanceHandlingTatModel= new GrievanceHandlingTatModel();
		grievanceHandlingTatModel.setTATID(TATID);
		grievanceHandlingTatModel.setHIERID(HIERID);
		grievanceHandlingTatModel.setTATDAYS(TATDAYS);
		grievanceHandlingTatModel.setBUFFERDAYS(BUFFERDAYS);
		grievanceHandlingTatModel.setIS_ACTIVE(IS_ACTIVE);
        try {
            boolean success = GrievanceHandlingTatMasterDAO.updateGrvHandling(grievanceHandlingTatModel);
            String url;
            if(success) {
                url = "GrievanceHandlingTat.jsp";
                session.setAttribute("success-message", "Data updated successfully");
            }else {

                url = "GrievanceHandlingTat.jsp";
                session.setAttribute("authError", "Error in update Grievance Handling Tat Master");
            }
            response.sendRedirect(url);
        } catch (Exception ex) {
        	ex.printStackTrace();
        	logger.info("Exception Inside the processReuest() method Exception "+ex.getMessage());
        	Logger.getLogger(EditGrievanceHandlingTatMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        logger.info("Leaving the processReuest() method");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		
	}

}
