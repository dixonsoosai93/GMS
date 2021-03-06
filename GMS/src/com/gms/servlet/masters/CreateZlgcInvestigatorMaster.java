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

import com.gms.dao.masters.ZlgcInvestigatorDAO;
import com.gms.model.masters.ZlgcInvestigatorMasterModel;

@WebServlet("/CreateZlgcInvestigatorMaster")
public class CreateZlgcInvestigatorMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CreateZlgcInvestigatorMaster.class.getName());
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Inside the processReuest() method");
		String ZONE_CODE =request.getParameter("ZONE_CODE");
		int INVESTIGATOR_EMPLOYEE_ID=Integer.parseInt(request.getParameter("INVESTIGATOR_EMPLOYEE_ID"));
		String IS_HR=request.getParameter("IS_HR");
		String IS_ACTIVE=request.getParameter("IS_ACTIVE");
		
		HashMap<String,String> errors = new HashMap<String, String>();
        HttpSession session =  request.getSession();
        
        ZlgcInvestigatorMasterModel ZlgcInvestigatorMaster= new ZlgcInvestigatorMasterModel();
        ZlgcInvestigatorMaster.setZONE_CODE(ZONE_CODE);
        ZlgcInvestigatorMaster.setINVESTIGATOR_EMPLOYEE_ID(INVESTIGATOR_EMPLOYEE_ID);
        ZlgcInvestigatorMaster.setIS_HR(IS_HR);
        ZlgcInvestigatorMaster.setIS_ACTIVE(IS_ACTIVE);
        try {
            boolean success = ZlgcInvestigatorDAO.insertZlgcInv(ZlgcInvestigatorMaster);
            String url;
            if(success) {
                url = "ZlgcInvestigatorList.jsp";
                session.setAttribute("success-message", "Data submitted successfully");
            } else {
                url = "ZlgcInvestigatorList.jsp";
                session.setAttribute("authError", "Error in insert Case Status Master");
            }
            response.sendRedirect(url);
        } catch (Exception ex) {
        	ex.printStackTrace();
        	logger.info("Exception Inside the processReuest() method Exception "+ex.getMessage());
        	Logger.getLogger(CreateZlgcInvestigatorMaster.class.getName()).log(Level.SEVERE, null, ex);
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
