package com.gms.servlet.masters;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gms.dao.masters.CaseStatusMasterDAO;
import com.gms.model.masters.CaseStatusMasterModel;

@WebServlet("/CreateCaseStatusMaster")
public class CreateCaseStatusMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CreateCaseStatusMaster.class.getName());
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException , NamingException{
		String sTATUSNAME = request.getParameter("STATUSNAME");
		String iS_ACTIVE = request.getParameter("IS_ACTIVE");
		
		HashMap<String,String> errors = new HashMap<String, String>();
        HttpSession session =  request.getSession();
        if(sTATUSNAME.isEmpty()) {
            errors.put("error", "status name required");
        }
        else if(iS_ACTIVE.isEmpty()){
        	errors.put("error", "is active required");
        }
        
        if(!errors.isEmpty()) {
            session.setAttribute("errors", errors);
            response.sendRedirect("CaseStatusMaster.jsp");
            return;
        }
        
        CaseStatusMasterModel complaintStatusModel= new CaseStatusMasterModel();
        complaintStatusModel.setSTATUSNAME(sTATUSNAME);
        complaintStatusModel.setIS_ACTIVE(iS_ACTIVE);
        try {
            boolean success = CaseStatusMasterDAO.insertComplaintStatus(complaintStatusModel);
            String url;
            if(success) {
                url = "CaseStatusMaster.jsp";
                session.setAttribute("success-message", "Data submitted successfully");
            }else {
            	session.setAttribute("danger-message", "Duplicate Entry Not Allowed.");
                //session.setAttribute("authError", "Error in insert Case Status Master");
                url = "CaseStatusMaster.jsp";
            }
            response.sendRedirect(url);
        } catch (Exception ex) {
        	ex.printStackTrace();
        	Logger.getLogger(CreateCaseStatusMaster.class.getName()).log(Level.SEVERE, null, ex);
        }

	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
	            processRequest(request, response);
	        } catch (NamingException ex) {
	        	ex.printStackTrace();
	        	logger.info("Exception in the doPost() method  Exception : "+ ex.getMessage());
	           
	            Logger.getLogger(CreateCaseStatusMaster.class.getName()).log(Level.SEVERE, null, ex);
	        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
	            processRequest(request, response);
	        } catch (NamingException ex) {
	        	ex.printStackTrace();
	        	logger.info("Exception in the doPost() method  Exception : "+ ex.getMessage());
	           
	            Logger.getLogger(CreateCaseStatusMaster.class.getName()).log(Level.SEVERE, null, ex);
	        }
		
	}

}
