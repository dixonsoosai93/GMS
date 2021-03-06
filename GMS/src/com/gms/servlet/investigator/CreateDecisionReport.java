package com.gms.servlet.investigator;

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

import com.gms.dao.investigator.DailyProofUploadDAO;
import com.gms.model.investigator.DecisionReport;
import com.gms.servlet.AdminLogin;

@WebServlet("/CreateDecisionReport")
public class CreateDecisionReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CreateDecisionReport.class.getName());
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String DECISION_CASEID = request.getParameter("CASEID");
		String DECISION_REPORT_DATE = request.getParameter("DECISION_REPORT_DATE");
		String DECISION_REPORT_CONTENT = request.getParameter("DECISION_REPORT_CONTENT");
		int CASEID=0;
		
		HashMap<String,String> errors = new HashMap<String, String>();
        HttpSession session =  request.getSession();
        if(DECISION_REPORT_DATE.isEmpty()) {
            errors.put("error", "Decision report date is required");
        }
        else if(DECISION_REPORT_CONTENT.isEmpty()) {
            errors.put("error", "Decision report content is required");
        }else if(DECISION_CASEID.isEmpty()) {
        	 errors.put("error", "Decision case id is required");
        }
        else {
        	  CASEID = Integer.parseInt(DECISION_CASEID);
        }
        
        if(!errors.isEmpty()) {
            session.setAttribute("errors", errors);
            response.sendRedirect("DailyDairyUpdationList.jsp");
            return;
        }
        DecisionReport DecisionReport= new DecisionReport();
        DecisionReport.setCASEID(CASEID);
        DecisionReport.setDECISION_REPORT_DATE(DECISION_REPORT_DATE);
        DecisionReport.setDECISION_REPORT_CONTENT(DECISION_REPORT_CONTENT);
        try {
            boolean success = DailyProofUploadDAO.updateDecision(DecisionReport);
            String url;
            if(success) {
                url = "DailyDairyUpdationList.jsp";
                session.setAttribute("success-message", "Data Submitted successfully");
            }else {
                session.setAttribute("authError", "Error in update case");
                url = "DailyDairyUpdationList.jsp";
            }
            response.sendRedirect(url);
        } catch (Exception ex) {
        	ex.printStackTrace();
        	Logger.getLogger(CreateDecisionReport.class.getName()).log(Level.SEVERE, null, ex);
        }

	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		
	}

}
