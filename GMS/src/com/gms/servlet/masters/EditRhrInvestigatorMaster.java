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

import com.gms.dao.masters.RhrInvestigatorDAO;
import com.gms.model.masters.RhrInvestigatorMasterModel;

@WebServlet("/EditRhrInvestigatorMaster")
public class EditRhrInvestigatorMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(EditRhrInvestigatorMaster.class.getName());
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Inside the processRequest() method");
		int ERHRID=Integer.parseInt(request.getParameter("ERHRID"));
		String EREGION_CODE =request.getParameter("EREGION_CODE");
		int EINVESTIGATOR_EMPLOYEE_ID=Integer.parseInt(request.getParameter("EINVESTIGATOR_EMPLOYEE_ID"));
		String EIS_HR=request.getParameter("EIS_HR");
		String EIS_ACTIVE=request.getParameter("EIS_ACTIVE");
		
		HashMap<String,String> errors = new HashMap<String, String>();
        HttpSession session =  request.getSession();
        
        RhrInvestigatorMasterModel RhrInvestigatorMaster= new RhrInvestigatorMasterModel();
        RhrInvestigatorMaster.setRHRID(ERHRID);
        RhrInvestigatorMaster.setREGION_CODE(EREGION_CODE);
        RhrInvestigatorMaster.setINVESTIGATOR_EMPLOYEE_ID(EINVESTIGATOR_EMPLOYEE_ID);
        RhrInvestigatorMaster.setIS_HR(EIS_HR);
        RhrInvestigatorMaster.setIS_ACTIVE(EIS_ACTIVE);
        try {
            boolean success = RhrInvestigatorDAO.updateRhrInv(RhrInvestigatorMaster);
            String url;
            if(success) {
                url = "RhrInvestigatorList.jsp";
                session.setAttribute("success-message", "Data updated successfully");
            }else {

                url = "RhrInvestigatorList.jsp";
                session.setAttribute("authError", "Error in update RHR Investigator Master");
            }
            response.sendRedirect(url);
        } catch (Exception ex) {
        	ex.printStackTrace();
        	logger.info("Exception the processRequest() method Exception "+ex.getMessage());
        	Logger.getLogger(EditRhrInvestigatorMaster.class.getName()).log(Level.SEVERE, null, ex);
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
