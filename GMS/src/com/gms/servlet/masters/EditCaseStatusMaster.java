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

import com.gms.dao.masters.CaseStatusMasterDAO;
import com.gms.model.masters.CaseStatusMasterModel;

@WebServlet("/EditCaseStatusMaster")
public class EditCaseStatusMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(EditCaseStatusMaster.class.getName());
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Inside the processReuest() method");
		String sTATUSID = request.getParameter("EDIT_STATUSID");
		String sTATUSNAME = request.getParameter("EDIT_STATUSNAME");
		String iS_ACTIVE = request.getParameter("EDIT_IS_ACTIVE");
		
		HashMap<String,String> errors = new HashMap<String, String>();
        HttpSession session =  request.getSession();
        
        if(sTATUSNAME != null && sTATUSNAME.isEmpty()) {
            errors.put("actionName", "Case Status Name required");
        }
        if(iS_ACTIVE != null && iS_ACTIVE.isEmpty()) {
            errors.put("isActive", "Status required");
        } 
        
        if(!errors.isEmpty()) { 
            session.setAttribute("errors", errors);
            response.sendRedirect("CaseStatusMaster.jsp");
            return;
        }

        CaseStatusMasterModel complaintStatus= new CaseStatusMasterModel();
        complaintStatus.setSTATUSID(sTATUSID);
        complaintStatus.setSTATUSNAME(sTATUSNAME);
        complaintStatus.setIS_ACTIVE(iS_ACTIVE);
        try {
            boolean success = CaseStatusMasterDAO.updateComplaintStatus(complaintStatus);
            String url;
            if(success) {
                url = "CaseStatusMaster.jsp";
                session.setAttribute("success-message", "Data updated successfully");
            }else {
            	session.setAttribute("danger-message", "Duplicate Entry Not Allowed.");
                url = "CaseStatusMaster.jsp";
            }
            response.sendRedirect(url);
        } catch (Exception ex) {
        	ex.printStackTrace();
        	logger.info("Exception Inside the processReuest() method Exception "+ex.getMessage());
        	Logger.getLogger(EditCaseStatusMaster.class.getName()).log(Level.SEVERE, null, ex);
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
