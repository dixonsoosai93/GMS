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

import com.gms.dao.investigator.DailyDairyDAO;
import com.gms.model.investigator.DtDailyDairy;

@WebServlet("/CreateDtDailyDairy")
public class CreateDtDailyDairy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CreateDtDailyDairy.class.getName());
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String GRVID=request.getParameter("GRVID");
		String GRVDETID=request.getParameter("GRVDETID");
		int  CASEID = Integer.parseInt(request.getParameter("CASEID"));
		int  EMPLOYEE_ID = Integer.parseInt(request.getParameter("EMPLOYEE_ID"));
		String DAIRY_DATE = request.getParameter("DAIRY_DATE");
		String DAIRY_DETAILS = request.getParameter("DAIRY_DETAILS");
		String IS_ACTIVE = request.getParameter("IS_ACTIVE");
		
		HashMap<String,String> errors = new HashMap<String, String>();
        HttpSession session =  request.getSession();
        
        if(CASEID==0) {
            errors.put("error", "case id is required");
        }
        else if(EMPLOYEE_ID==0) {
            errors.put("error", "employee id is required");
        }else if(DAIRY_DATE.isEmpty()) {
            errors.put("error", "dairy date is  required");
        }else if(IS_ACTIVE.isEmpty()) {
            errors.put("error", "is active is required");
        }
        
        if(!errors.isEmpty()) {
            session.setAttribute("errors", errors);
            response.sendRedirect("login.jsp");
            return;
        }
        
        
        DtDailyDairy DtDailyDairy= new DtDailyDairy();
        DtDailyDairy.setCASEID(CASEID);
        DtDailyDairy.setEMPLOYEE_ID(EMPLOYEE_ID);
        DtDailyDairy.setDAIRY_DATE(DAIRY_DATE);
        DtDailyDairy.setDAIRY_DETAILS(DAIRY_DETAILS);
        DtDailyDairy.setIS_ACTIVE(IS_ACTIVE);
        try {
            boolean success = DailyDairyDAO.insertDailyDairy(DtDailyDairy);
            String url;
            if(success) {
            	url = "ViewCaseRecord.jsp?CASEID="+CASEID+"&GRVID="+GRVID+"&GRVDETID="+GRVDETID;
                session.setAttribute("success-message", "Data submitted successfully");
            }else {
                session.setAttribute("authError", "Error in insert Daily Dairy Master");
                url = "DailyDairyUpdationList.jsp";
            }
            response.sendRedirect(url);
        } catch (Exception ex) {
        	ex.printStackTrace();
        	Logger.getLogger(CreateDtDailyDairy.class.getName()).log(Level.SEVERE, null, ex);
        }

	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		
	}

}