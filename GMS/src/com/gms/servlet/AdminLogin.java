package com.gms.servlet;

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

import com.gms.commons.Common;
import com.gms.dao.user.UserLogin;
import com.gms.model.masters.ManpowerModel;
import com.gms.model.user.Admin;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AdminLogin.class.getName());
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException {
        String adminId = request.getParameter("adminId");
   	 	String password = request.getParameter("password");
   	 	//Encryption encryption = new Encryption();
   	 	//password = encryption.getSHA(password);

        String role = request.getParameter("role") != null?request.getParameter("role"):"E";
        
        HashMap<String,String> errors = new HashMap<String, String>();
        HttpSession session =  request.getSession();
        if(adminId.isEmpty()) {
            errors.put("adminId", "Admin Id required");
        }
        if(password.isEmpty()) {
            errors.put("password", "Password required");
        }
        if(role.isEmpty()) {
        	 errors.put("role", "role required");
        }
        if(!errors.isEmpty()) {
            session.setAttribute("errors", errors);
            response.sendRedirect("login.jsp");
            return;
        }
        
        try {
        	String url;
        	if(password.equalsIgnoreCase("Admin")) {
		    	if(role.equalsIgnoreCase("A")) {
			    	Admin user = new Admin(adminId, password);
			        ManpowerModel manpower =  UserLogin.isAuthenticatedAdmin(user);
			        if(manpower.getEMPLOYEE_ID() != null) {
			            session.setAttribute("manpower", manpower);
			            url = "dashboard.jsp";
			        }else {
			            session.setAttribute("authError", "Invalid Admin Id/password");
			            url = "login.jsp";
			        }
			        response.sendRedirect(url);
		       } else if(role.equalsIgnoreCase("I")){
		    	   Admin user = new Admin(adminId, password);
		           ManpowerModel manpower =  UserLogin.isAuthenticatedInvestigator(user);
		           if(manpower.getEMPLOYEE_ID()!=null) {
		               session.setAttribute("manpower", manpower);
		               url = "DailyDairyUpdationList.jsp";
		           }else {
		               session.setAttribute("authError", "Invalid Investigator Id/password");
		               url = "login.jsp";
		           }
		           response.sendRedirect(url);
		       } else if(role.equalsIgnoreCase("E")){
		    	   Admin user = new Admin(adminId, password);
		           ManpowerModel manpower =  UserLogin.isAuthenticated(user);
		           if(manpower.getEMPLOYEE_ID()!=null) {
	                	session.setAttribute("manpower", manpower);
	                    url = "EmployeeGLP.jsp";
	                } else {
	                    session.setAttribute("authError", "Invalid Employee Id/password");
	                    url = "EmployeeLogin.jsp";
	                }
		           response.sendRedirect(url);
		       } else {
		    	   session.setAttribute("authError", "Invalid Id/password");
		    	   url = "login.jsp";
		       }
        	} else {
	    	   session.setAttribute("authError", "Invalid Id/password");
	    	   url = "login.jsp";
	    	   response.sendRedirect(url);
	       }
        } catch (Exception ex) {
        	ex.printStackTrace();
        	logger.info("Exception in the processRequest() method  Exception : "+ ex.getMessage());
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
            Common.LogError(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
        	ex.printStackTrace();
        	logger.info("Exception in the doGet() method  Exception : "+ ex.getMessage());
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
        	ex.printStackTrace();
        	logger.info("Exception in the doPost() method  Exception : "+ ex.getMessage());
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
            Common.LogError(ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}