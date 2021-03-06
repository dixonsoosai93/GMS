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

import com.gms.dao.masters.HolidayMasterDAO;

@WebServlet("/DeleteHolidayMaster")
public class DeleteHolidayMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DeleteHolidayMaster.class.getName());
    
   protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
	    logger.info("Inside the processReuest() method");
    	int HOLIDAY_ID = Integer.parseInt(request.getParameter("HOLIDAY_ID"));
    	HttpSession session =  request.getSession();
		try {
            boolean success = HolidayMasterDAO.deleteHoliday(HOLIDAY_ID);
            String url;
            if(success) {
            	session.setAttribute("success-message", "Holiday Master deleted.");
                url = "HolidayList.jsp";
            }else {
                session.setAttribute("authError", "Error in Delete Holiday Master");
                url = "HolidayList.jsp";
            }
            response.sendRedirect(url);
        } catch (Exception ex) {
        	ex.printStackTrace();
        	logger.info("Exception Inside the processReuest() method Exception "+ex.getMessage());
        	Logger.getLogger(DeleteHolidayMaster.class.getName()).log(Level.SEVERE, null, ex);
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
