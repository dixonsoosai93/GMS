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

/**
 * Servlet implementation class EditMainCategory
 */
@WebServlet("/EditMainCategory")
public class EditMainCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(EditMainCategory.class.getName());
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Inside the processReuest() method");
		String EMAIN_CATEGORY_CODE = request.getParameter("EMAIN_CATEGORY_CODE");
		String EMAIN_CATEGORY_NAME = request.getParameter("EMAIN_CATEGORY_NAME");
		String EIS_ACTIVE = request.getParameter("EIS_ACTIVE");
		HashMap<String,String> errors = new HashMap<String, String>();
	    HttpSession session =  request.getSession();
	    
	    if(EMAIN_CATEGORY_CODE != null && EMAIN_CATEGORY_CODE.isEmpty()) {
	        errors.put("actionName", "main category code required");
	    }
	    if(EIS_ACTIVE != null && EIS_ACTIVE.isEmpty()) {
	        errors.put("isActive", "Status required");
	    } 
	    
	    if(!errors.isEmpty()) { 
	        session.setAttribute("errors", errors);
	        response.sendRedirect("CaseStatusMaster.jsp");
	        return;
	    }
	    
	    MainCategoryModel maincategory= new MainCategoryModel();
	    maincategory.setMAIN_CATEGORY_CODE(EMAIN_CATEGORY_CODE);
	    maincategory.setMAIN_CATEGORY_NAME(EMAIN_CATEGORY_NAME);
	    maincategory.setIS_ACTIVE(EIS_ACTIVE);

	    try {
	        boolean success = MainCategoryDAO.updateMainCategory(maincategory);
	        String url;
	        if(success) {
	            url = "MainCategoryMaster.jsp";
	            session.setAttribute("success-message", "Data updated successfully");
	        }else {
	            session.setAttribute("authError", "Error in update Main Category Master");
	            url = "MainCategoryMaster.jsp";
	        }
	        response.sendRedirect(url);
	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    	logger.info("Exception Inside the processReuest() method Exception "+ex.getMessage());
	    	Logger.getLogger(EditMainCategory.class.getName()).log(Level.SEVERE, null, ex);
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
