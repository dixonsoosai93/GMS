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

import com.gms.dao.masters.MainCategoryDAO;
import com.gms.model.masters.MainCategoryModel;

@WebServlet("/CreateMainCategory")
public class CreateMainCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CreateMainCategory.class.getName());
     
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String MAIN_CATEGORY_CODE = request.getParameter("MAIN_CATEGORY_CODE");	
	String MAIN_CATEGORY_NAME = request.getParameter("MAIN_CATEGORY_NAME");
	String iS_ACTIVE = request.getParameter("IS_ACTIVE");
	
	HashMap<String,String> errors = new HashMap<String, String>();
    HttpSession session =  request.getSession();
    
    if(MAIN_CATEGORY_NAME != null && MAIN_CATEGORY_NAME.isEmpty()) {
        errors.put("actionName", "main category code required");
    }
    if(iS_ACTIVE != null && iS_ACTIVE.isEmpty()) {
        errors.put("isActive", "Status required");
    } 
    
    if(!errors.isEmpty()) { 
        session.setAttribute("errors", errors);
        response.sendRedirect("CaseStatusMaster.jsp");
        return;
    }
    
    MainCategoryModel maincategory= new MainCategoryModel();
    maincategory.setMAIN_CATEGORY_CODE(MAIN_CATEGORY_CODE);
    maincategory.setMAIN_CATEGORY_NAME(MAIN_CATEGORY_NAME);
    maincategory.setIS_ACTIVE(iS_ACTIVE);

    try {
        boolean success = MainCategoryDAO.insertMainCategory(maincategory);
        String url;
        if(success) {
            url = "MainCategoryMaster.jsp";
            session.setAttribute("success-message", "Data submitted successfully");
        }else {
            session.setAttribute("authError", "Error in insert Case Status Master");
            url = "MainCategoryMaster.jsp";
        }
        response.sendRedirect(url);
    } catch (Exception ex) {
    	ex.printStackTrace();
    	Logger.getLogger(CreateMainCategory.class.getName()).log(Level.SEVERE, null, ex);
    }

}
   
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	processRequest(request, response);
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	processRequest(request, response);
	
}

}
