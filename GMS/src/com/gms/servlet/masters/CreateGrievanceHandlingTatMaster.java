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

@WebServlet("/CreateGrievanceHandlingTatMaster")
public class CreateGrievanceHandlingTatMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CreateGrievanceHandlingTatMaster.class.getName());
    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int HIERID =Integer.parseInt(request.getParameter("HIERID"));
		int TATDAYS=Integer.parseInt(request.getParameter("TATDAYS"));
		int BUFFERDAYS=Integer.parseInt(request.getParameter("BUFFERDAYS"));
		String IS_ACTIVE=request.getParameter("IS_ACTIVE");
		
		HashMap<String,String> errors = new HashMap<String, String>();
        HttpSession session =  request.getSession();
        
		GrievanceHandlingTatModel grievanceHandlingTatModel= new GrievanceHandlingTatModel();
		grievanceHandlingTatModel.setHIERID(HIERID);
		grievanceHandlingTatModel.setTATDAYS(TATDAYS);
		grievanceHandlingTatModel.setBUFFERDAYS(BUFFERDAYS);
		grievanceHandlingTatModel.setIS_ACTIVE(IS_ACTIVE);
        System.out.println("Insert Data:"+grievanceHandlingTatModel.toString());
        try {
            boolean success = GrievanceHandlingTatMasterDAO.insertGrvHandlingTat(grievanceHandlingTatModel);
            String url;
            if(success) {
                url = "GrievanceHandlingTat.jsp";
                session.setAttribute("success-message", "Data submitted successfully");
            }else {

                url = "GrievanceHandlingTat.jsp";
                session.setAttribute("authError", "Error in insert Case Status Master");
            }
            response.sendRedirect(url);
        } catch (Exception ex) {
        	ex.printStackTrace();
        	Logger.getLogger(CreateGrievanceHandlingTatMaster.class.getName()).log(Level.SEVERE, null, ex);
        }

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);

	}


}
