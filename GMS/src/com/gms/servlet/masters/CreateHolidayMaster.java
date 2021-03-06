package com.gms.servlet.masters;

import java.io.IOException;
import java.text.ParseException;
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
@WebServlet("/CreateHolidayMaster")
public class CreateHolidayMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CreateHolidayMaster.class.getName());
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		String STATE_CODE  = request.getParameter("STATE_CODE");
		String HOLIDAYDATE = request.getParameter("HOLIDAYDATE");
		String HOLIDAYNAME = request.getParameter("HOLIDAYNAME");
		String IS_ACTIVE = request.getParameter("IS_ACTIVE");
		
		
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
            response.sendRedirect("CaseStatusMaster.jsp");
            return;
        }
        
        HolidayMasterModel holidayMasterModel= new HolidayMasterModel();
        holidayMasterModel.setSTATE_CODE(STATE_CODE);
        holidayMasterModel.setHOLIDAYDATE(HOLIDAYDATE);
        holidayMasterModel.setHOLIDAYNAME(HOLIDAYNAME);
        holidayMasterModel.setIS_ACTIVE(IS_ACTIVE);
        try {
            boolean success = HolidayMasterDAO.insertholidayMaster(holidayMasterModel);
            String url;
            if(success) {
                url = "HolidayList.jsp";
                session.setAttribute("success-message", "Data submitted successfully");
            }else {
            	session.setAttribute("danger-message", "Duplicate Entry Not Allowed.");
                //session.setAttribute("authError", "Error in insert Case Status Master");
                url = "HolidayList.jsp";
            }
            response.sendRedirect(url);
        } catch (Exception ex) {
        	ex.printStackTrace();
        	Logger.getLogger(CreateHolidayMaster.class.getName()).log(Level.SEVERE, null, ex);
        }

	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
