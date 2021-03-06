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

@WebServlet("/CreateOrganisationHierarchyMaster")
public class CreateOrganisationHierarchyMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CreateOrganisationHierarchyMaster.class.getName());
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		organisationHierarchyMasterModel.setHIERCODE(HIERCODE);
		organisationHierarchyMasterModel.setCLIENTCAPTION(CLIENTCAPTION);
		organisationHierarchyMasterModel.setHIERNAME(HIERNAME);
		organisationHierarchyMasterModel.setHIERDESIGNATIONID(HIERDESIGNATIONID);
		organisationHierarchyMasterModel.setHIERORDER(HIERORDER);
		organisationHierarchyMasterModel.setHIERCODE(HIERCODE);
		organisationHierarchyMasterModel.setHIERCAP(HIERCAP);
		organisationHierarchyMasterModel.setINVESTIGATOR_NEEDED(INVESTIGATOR_NEEDED);
		organisationHierarchyMasterModel.setIS_ACTIVE(IS_ACTIVE);
        System.out.println("Insert Data:"+organisationHierarchyMasterModel.toString());
        try {
            boolean success = OrganisationHierarchyMasterDAO.insertOrgHierarchy(organisationHierarchyMasterModel);
            String url;
            if(success) {
                url = "OrganisationHierarchyList.jsp";
                session.setAttribute("success-message", "Data Submitted successfully");
            }else {
            	session.setAttribute("authError", "Error in submit Case Status Master");
                url = "OrganisationHierarchyList.jsp";
            }
            response.sendRedirect(url);
        } catch (Exception ex) {
        	ex.printStackTrace();
        	Logger.getLogger(CreateOrganisationHierarchyMaster.class.getName()).log(Level.SEVERE, null, ex);
        }

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);

	}

}
