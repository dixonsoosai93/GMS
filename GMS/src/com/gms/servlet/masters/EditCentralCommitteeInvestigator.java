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

import com.gms.dao.masters.CentralCommitteeInvestigatorDAO;
import com.gms.model.masters.CentralCommitteeInvestigatorModel;


@WebServlet("/EditCentralCommitteeInvestigator")
public class EditCentralCommitteeInvestigator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(EditCentralCommitteeInvestigator.class.getName());
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Inside the processReuest() method");
		int ECENTRALID=Integer.parseInt(request.getParameter("ECENTRALID"));
		int EINVESTIGATOR_EMPLOYEE_ID=Integer.parseInt(request.getParameter("EINVESTIGATOR_EMPLOYEE_ID"));
		String EIS_HR=request.getParameter("EIS_HR");
		String EIS_ACTIVE=request.getParameter("EIS_ACTIVE");
		
		HashMap<String,String> errors = new HashMap<String, String>();
        HttpSession session =  request.getSession();
        
        CentralCommitteeInvestigatorModel CentralInvestigator= new CentralCommitteeInvestigatorModel();
        CentralInvestigator.setCENTRALID(ECENTRALID);
        CentralInvestigator.setINVESTIGATOR_EMPLOYEE_ID(EINVESTIGATOR_EMPLOYEE_ID);
        CentralInvestigator.setIS_HR(EIS_HR);
        CentralInvestigator.setIS_ACTIVE(EIS_ACTIVE);
        try {
            boolean success = CentralCommitteeInvestigatorDAO.updateCentralCommittee(CentralInvestigator);
            String url;
            if(success) {
                url = "CentralCommitteeInvestigatorList.jsp";
                session.setAttribute("success-message", "Data updated successfully");
            }else {

                url = "CentralCommitteeInvestigatorList.jsp";
                session.setAttribute("authError", "Error in update Central Committee Investigators Master");
            }
            response.sendRedirect(url);
        } catch (Exception ex) {
        	ex.printStackTrace();
        	logger.info("Exception Inside the processReuest() method Exception "+ex.getMessage());
        	Logger.getLogger(EditCentralCommitteeInvestigator.class.getName()).log(Level.SEVERE, null, ex);
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