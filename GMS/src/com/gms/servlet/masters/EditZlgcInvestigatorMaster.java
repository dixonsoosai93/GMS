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

@WebServlet("/EditZlgcInvestigatorMaster")
public class EditZlgcInvestigatorMaster extends HttpServlet {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(EditZlgcInvestigatorMaster.class.getName());
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Inside the processRequest() method");
		int EZLGC=Integer.parseInt(request.getParameter("EZLGC"));
		String EZONE_CODE =request.getParameter("EZONE_CODE");
		int EINVESTIGATOR_EMPLOYEE_ID=Integer.parseInt(request.getParameter("EINVESTIGATOR_EMPLOYEE_ID"));
		String EIS_HR=request.getParameter("EIS_HR");
		String EIS_ACTIVE=request.getParameter("EIS_ACTIVE");
		
		HashMap<String,String> errors = new HashMap<String, String>();
        HttpSession session =  request.getSession();
        
        ZlgcInvestigatorMasterModel ZlgcInvestigatorMaster= new ZlgcInvestigatorMasterModel();
        ZlgcInvestigatorMaster.setZLGCID(EZLGC);
        ZlgcInvestigatorMaster.setZONE_CODE(EZONE_CODE);
        ZlgcInvestigatorMaster.setINVESTIGATOR_EMPLOYEE_ID(EINVESTIGATOR_EMPLOYEE_ID);
        ZlgcInvestigatorMaster.setIS_HR(EIS_HR);
        ZlgcInvestigatorMaster.setIS_ACTIVE(EIS_ACTIVE);
	        try {
	            boolean success = ZlgcInvestigatorDAO.updateZlgcInv(ZlgcInvestigatorMaster);
	            String url;
	            if(success) {
	                url = "ZlgcInvestigatorList.jsp";
	                session.setAttribute("success-message", "Data updated successfully");
	            }else {
	
	                url = "ZlgcInvestigatorList.jsp";
	                session.setAttribute("authError", "Error in Zlgc Investigator Master");
	            }
	            response.sendRedirect(url);
	        } catch (Exception ex) {
	        	ex.printStackTrace();
	        	logger.info("Exception the processRequest() method Exception "+ex.getMessage());
	        	Logger.getLogger(EditZlgcInvestigatorMaster.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        logger.info("Leaving the processRequest() method");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
