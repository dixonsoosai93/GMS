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

import com.gms.dao.masters.OrganisationHierarchyMasterDAO;
import com.gms.model.masters.OrganisationHierarchyMasterModel;

@WebServlet("/EditOrganisationHierarchyMaster")
public class EditOrganisationHierarchyMaster extends HttpServlet {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(EditOrganisationHierarchyMaster.class.getName());
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Inside the processReuest() method");
		int	HIERID=Integer.parseInt(request.getParameter("HIERID"));
		String HIERCODE = request.getParameter("HIERCODE");
		String CLIENTCAPTION = request.getParameter("CLIENTCAPTION");
		String HIERNAME=request.getParameter("HIERNAME");
		String HIERDESIGNATIONID=request.getParameter("HIERDESIGNATIONID");
		int HIERORDER=Integer.parseInt(request.getParameter("HIERORDER"));
		int HIERCAP=Integer.parseInt(request.getParameter("HIERCAP"));
		String INVESTIGATOR_NEEDED=request.getParameter("INVESTIGATOR_NEEDED");
		String IS_ACTIVE=request.getParameter("IS_ACTIVE");
		
		HashMap<String,String> errors = new HashMap<String, String>();
        HttpSession session =  request.getSession();
        
		OrganisationHierarchyMasterModel organisationHierarchyMasterModel= new OrganisationHierarchyMasterModel();
		organisationHierarchyMasterModel.setHIERID(HIERID);
		organisationHierarchyMasterModel.setHIERCODE(HIERCODE);
		organisationHierarchyMasterModel.setCLIENTCAPTION(CLIENTCAPTION);
		organisationHierarchyMasterModel.setHIERNAME(HIERNAME);
		organisationHierarchyMasterModel.setHIERDESIGNATIONID(HIERDESIGNATIONID);
		organisationHierarchyMasterModel.setHIERORDER(HIERORDER);
		organisationHierarchyMasterModel.setHIERCODE(HIERCODE);
		organisationHierarchyMasterModel.setHIERCAP(HIERCAP);
		organisationHierarchyMasterModel.setINVESTIGATOR_NEEDED(INVESTIGATOR_NEEDED);
		organisationHierarchyMasterModel.setIS_ACTIVE(IS_ACTIVE);
        try {
            boolean success = OrganisationHierarchyMasterDAO.updateOrgHierarchy(organisationHierarchyMasterModel);
            String url;
            if(success) {
                url = "OrganisationHierarchyList.jsp";
                session.setAttribute("success-message", "Data updated successfully");
            }else {
            	session.setAttribute("authError", "Error in update Organisation Hierarchy Master");
                url = "OrganisationHierarchyList.jsp";
            }
            response.sendRedirect(url);
        } catch (Exception ex) {
        	ex.printStackTrace();
        	logger.info("Exception Inside the processReuest() method Exception "+ex.getMessage());
        	Logger.getLogger(EditOrganisationHierarchyMaster.class.getName()).log(Level.SEVERE, null, ex);
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
