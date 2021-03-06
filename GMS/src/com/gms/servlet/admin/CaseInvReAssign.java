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
import com.gms.dao.admin.AlternateInvReAssignDAO;
import com.gms.model.admin.GridCase;

@WebServlet("/CaseInvReAssign")
public class CaseInvReAssign extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(CaseInvReAssign.class.getName());
       
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
			logger.info("Inside the processRequest() method");
			String jsonResponse = null;
	        JSONObject jsonObject = new JSONObject();
	        String GRVDETID = request.getParameter("GRVDETID");
	        int CASEID=Integer.parseInt(request.getParameter("CASEID"));
	        int INVESTIGATOR_EMPLOYEE_ID=Integer.parseInt(request.getParameter("INVESTIGATOR_EMPLOYEE_ID"));
	        String TATEXT_REASON = request.getParameter("Remark");
	        HttpSession session =  request.getSession();
	        GridCase gridCase= new GridCase();
	        gridCase.setCASEID(CASEID);
	        gridCase.setINVESTIGATOR_EMPLOYEE_ID(INVESTIGATOR_EMPLOYEE_ID);
	        gridCase.setTATEXT_REASON(TATEXT_REASON);
	        String url = "AlternateInvReAssignment.jsp";
	        try {
	            Boolean success = AlternateInvReAssignDAO.caseInvReAssign(gridCase);
	            if(success) {
	                session.setAttribute("success-message", "Redressal Authority ReAssigned successfully");
	                session.setAttribute("GRVDETID", GRVDETID);
	                url = "AlternateInvReAssignment.jsp?GRVDETID="+GRVDETID;
	            }else {
	                session.setAttribute("authError", "Error in Investigator ReAssign ");
	                url = "AlternateInvReAssignment.jsp?GRVDETID="+GRVDETID;
	            }
	        } catch (Exception ex) {
	        	ex.printStackTrace();
	        	logger.info("Exception Inside the processRequest() method Exception "+ ex.getMessage());
	        	Logger.getLogger(CaseInvReAssign.class.getName()).log(Level.SEVERE, null, ex);
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
				Logger.getLogger(CaseInvReAssign.class.getName()).log(Level.SEVERE, null, e);
			}
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				processRequest(request, response);
			} catch (ParseException e) {
				e.printStackTrace();
				Logger.getLogger(CaseInvReAssign.class.getName()).log(Level.SEVERE, null, e);
			}
			
		}


	}
