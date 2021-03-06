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

/**
 * Servlet implementation class CreateCentralCommitteeInvestigatorMaster
 */
@WebServlet("/CreateCentralCommitteeInvestigatorMaster")
public class CreateCentralCommitteeInvestigatorMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CreateCentralCommitteeInvestigatorMaster.class.getName());
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int INVESTIGATOR_EMPLOYEE_ID=Integer.parseInt(request.getParameter("INVESTIGATOR_EMPLOYEE_ID"));
		String IS_HR=request.getParameter("IS_HR");
		String IS_ACTIVE=request.getParameter("IS_ACTIVE");
		
		
		
		HashMap<String,String> errors = new HashMap<String, String>();
        HttpSession session =  request.getSession();
        
        CentralCommitteeInvestigatorModel CentralInvestigator= new CentralCommitteeInvestigatorModel();
        CentralInvestigator.setINVESTIGATOR_EMPLOYEE_ID(INVESTIGATOR_EMPLOYEE_ID);
        CentralInvestigator.setIS_HR(IS_HR);
        CentralInvestigator.setIS_ACTIVE(IS_ACTIVE);
        try {
            boolean success = CentralCommitteeInvestigatorDAO.insertCentralInv(CentralInvestigator);
            String url;
            if(success) {
                url = "CentralCommitteeInvestigatorList.jsp";
                session.setAttribute("success-message", "Data submitted successfully");
            }else {

                url = "CentralCommitteeInvestigatorList.jsp";
                session.setAttribute("authError", "Error in insert Case Status Master");
            }
            response.sendRedirect(url);
        } catch (Exception ex) {
        	ex.printStackTrace();
        	Logger.getLogger(CreateCentralCommitteeInvestigatorMaster.class.getName()).log(Level.SEVERE, null, ex);
        }

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);

	}

}
