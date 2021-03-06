package com.gms.servlet.masters;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gms.dao.masters.CaseStatusMasterDAO;

@WebServlet("/DeleteCaseStatusMaster")
public class DeleteCaseStatusMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DeleteCaseStatusMaster.class.getName());
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
    	logger.info("Inside the processReuest() method");
    	int STATUSID = Integer.parseInt(request.getParameter("STATUSID"));
    	System.out.println(STATUSID);
    	HttpSession session =  request.getSession();
		System.out.println(STATUSID);
		try {
            boolean success = CaseStatusMasterDAO.deleteComplaintStatus(STATUSID);
            String url;
            if(success) {
            	session.setAttribute("success-message", "Case Status Master deleted.");
                url = "CaseStatusMaster.jsp";
            }else {
                session.setAttribute("authError", "Error in Delete Case Status Master");
                url = "CaseStatusMaster.jsp";
            }
            response.sendRedirect(url);
        } catch (Exception ex) {
        	ex.printStackTrace();
        	logger.info("Exception Inside the processReuest() method Exception "+ex.getMessage());
        	Logger.getLogger(DeleteCaseStatusMaster.class.getName()).log(Level.SEVERE, null, ex);
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
