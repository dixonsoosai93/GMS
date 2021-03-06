package com.gms.servlet.grievance;

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

import com.gms.dao.grievance.EmployeeGrievanceDAO;

/**
 * Servlet implementation class GrvEmpReopen
 */
@WebServlet("/GrvEmpReopen")
public class GrvEmpReopen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(GrvEmpReopen.class.getName());

       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		logger.info("Inside the processRequest() method");
		String jsonResponse = null;
        JSONObject jsonObject = new JSONObject();
        int GRVDETID = Integer.parseInt(request.getParameter("detId"));
        HttpSession session =  request.getSession();
        String url = "";
        try {
            Boolean success = EmployeeGrievanceDAO.getGrvEmpReopen(GRVDETID);
            if(success) {
                session.setAttribute("success-message", "Case Reopened successfully");
                url = "EmployeeGrievanceList.jsp";
            }else {
                url = "EmployeeGrievanceList.jsp";
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
        	logger.info("Exception Inside the processRequest() method Exception"+ex.getMessage());
        	Logger.getLogger(GrvEmpReopen.class.getName()).log(Level.SEVERE, null, ex);
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
			Logger.getLogger(GrvEmpReopen.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
			Logger.getLogger(GrvEmpReopen.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}

}
