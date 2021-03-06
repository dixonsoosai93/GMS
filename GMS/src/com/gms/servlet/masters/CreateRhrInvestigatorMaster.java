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

/**
 * Servlet implementation class CreateRhrInvestigatorMaster
 */
@WebServlet("/CreateRhrInvestigatorMaster")
public class CreateRhrInvestigatorMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CreateRhrInvestigatorMaster.class.getName());
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String REGION_CODE =request.getParameter("REGION_CODE");
		int INVESTIGATOR_EMPLOYEE_ID=Integer.parseInt(request.getParameter("INVESTIGATOR_EMPLOYEE_ID"));
		String IS_HR=request.getParameter("IS_HR");
		String IS_ACTIVE=request.getParameter("IS_ACTIVE");
		
		
		
		HashMap<String,String> errors = new HashMap<String, String>();
        HttpSession session =  request.getSession();
        
        RhrInvestigatorMasterModel RhrInvestigatorMaster= new RhrInvestigatorMasterModel();
        RhrInvestigatorMaster.setREGION_CODE(REGION_CODE);
        RhrInvestigatorMaster.setINVESTIGATOR_EMPLOYEE_ID(INVESTIGATOR_EMPLOYEE_ID);
        RhrInvestigatorMaster.setIS_HR(IS_HR);
        RhrInvestigatorMaster.setIS_ACTIVE(IS_ACTIVE);
        try {
            boolean success = RhrInvestigatorDAO.insertRhrInv(RhrInvestigatorMaster);
            String url;
            if(success) {
                url = "RhrInvestigatorList.jsp";
                session.setAttribute("success-message", "Data submitted successfully");
            }else {

                url = "RhrInvestigatorList.jsp";
                session.setAttribute("authError", "Error in rhr investigator Master");
            }
            response.sendRedirect(url);
        } catch (Exception ex) {
        	ex.printStackTrace();
        	Logger.getLogger(CreateRhrInvestigatorMaster.class.getName()).log(Level.SEVERE, null, ex);
        }

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);

	}


}
