package com.gms.servlet.admin;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.gms.dao.admin.TransferCaseDAO;
import com.gms.model.admin.GridCase;


@WebServlet("/NextInvestigatorAssignment")
public class NextInvestigatorAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(NextInvestigatorAssignment.class.getName());
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		logger.info("Inside the processRequest() method");	
		String jsonResponse = null;
        JSONObject jsonObject = new JSONObject();
        int GRVDETID = Integer.parseInt(request.getParameter("GRVDETID"));
        int HIREORDER=Integer.parseInt(request.getParameter("HIREORDER"));
		String Remark = request.getParameter("Remark");		
        HttpSession session =  request.getSession();
        GridCase gridCase= new GridCase();
        gridCase.setGRVDETID(GRVDETID);
        gridCase.setHIERORDER(HIREORDER);
        gridCase.setTATEXT_REASON(Remark);
	        try {
	            Boolean success = TransferCaseDAO.nextInvAssign(gridCase);
	            if(success) {
	                session.setAttribute("success-message", "Redressal Authority changed successfully");
	            }else {
	                session.setAttribute("authError", "Error in changing Investigator ");
	            }
	        } catch (Exception ex) {
	        	ex.printStackTrace();
	        	logger.info("Exception Inside the processRequest() method Exception "+ex.getMessage());	
	        	Logger.getLogger(NextInvestigatorAssignment.class.getName()).log(Level.SEVERE, null, ex);
	        }
        jsonObject.put("status",200);
		jsonResponse = jsonObject.toString();
        response.setContentType("application/json");
    	response.getWriter().write(jsonResponse);
    	logger.info("Leaving the processRequest() method");	
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
			Logger.getLogger(NextInvestigatorAssignment.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
			Logger.getLogger(NextInvestigatorAssignment.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}


}
