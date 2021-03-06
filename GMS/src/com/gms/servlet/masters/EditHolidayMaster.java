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

import com.gms.dao.masters.HolidayMasterDAO;
import com.gms.model.masters.HolidayMasterModel;

@WebServlet("/EditHolidayMaster")
public class EditHolidayMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(EditHolidayMaster.class.getName()); 
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Inside the processReuest() method");
		int HOLIDAYID  = Integer.parseInt(request.getParameter("EHOLIDAYID"));
		String STATE_CODE  = request.getParameter("ESTATE_CODE");
		String HOLIDAYDATE = request.getParameter("EHOLIDAYDATE");
		String HOLIDAYNAME = request.getParameter("EHOLIDAYNAME");
		String IS_ACTIVE = request.getParameter("EIS_ACTIVE");
		
		
		HashMap<String,String> errors = new HashMap<String, String>();
        HttpSession session =  request.getSession();
        
        if(STATE_CODE != null && STATE_CODE.isEmpty()) {
            errors.put("actionName", "Status Name required");
        }
        if(HOLIDAYDATE != null && HOLIDAYDATE.isEmpty()) {
            errors.put("actionName", "Holiday Date required");
        }
        if(HOLIDAYNAME != null && HOLIDAYNAME.isEmpty()) {
            errors.put("actionName", "Holiday description required");
        }
        if(IS_ACTIVE != null && IS_ACTIVE.isEmpty()) {
            errors.put("isActive", "Status required");
        } 
        
        if(!errors.isEmpty()) { 
            session.setAttribute("errors", errors);
            response.sendRedirect("Holiday.jsp");
            return;
        }
        
        HolidayMasterModel holidayMasterModel= new HolidayMasterModel();
        holidayMasterModel.setHOLIDAY_ID(HOLIDAYID);
        holidayMasterModel.setSTATE_CODE(STATE_CODE);
        holidayMasterModel.setHOLIDAYDATE(HOLIDAYDATE);
        holidayMasterModel.setHOLIDAYNAME(HOLIDAYNAME);
        holidayMasterModel.setIS_ACTIVE(IS_ACTIVE);
        try {
            boolean success = HolidayMasterDAO.updateHoliday(holidayMasterModel);
            String url;
            if(success) {
                url = "HolidayList.jsp";
                session.setAttribute("success-message", "Data updated successfully");
            }else {
            	session.setAttribute("danger-message", "Duplicate Entry Not Allowed.");
                url = "HolidayList.jsp";
            }
            response.sendRedirect(url);
        } catch (Exception ex) {
        	ex.printStackTrace();
        	logger.info("Exception Inside the processReuest() method Exception "+ex.getMessage());
        	Logger.getLogger(EditHolidayMaster.class.getName()).log(Level.SEVERE, null, ex);
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
