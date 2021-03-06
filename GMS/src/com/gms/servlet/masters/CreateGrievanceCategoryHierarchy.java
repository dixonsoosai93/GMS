package com.gms.servlet.masters;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.gms.dao.masters.GrievanceCategoryHierarchyDAO;
import com.gms.model.masters.GrievanceCategoryHierarchyModel;
import com.gms.model.masters.GrievanceCategorySubCatgeoryAddUpdateModel;

@WebServlet("/CreateGrievanceCategoryHierarchy")
public class CreateGrievanceCategoryHierarchy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CreateGrievanceCategoryHierarchy.class.getName());
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String jsonResponse = null;
	        JSONObject jsonObject = new JSONObject();
			HashMap<String,String> errors = new HashMap<String, String>();
	        HttpSession session =  request.getSession();
	        String data = request.getParameter("data");
	         GrievanceCategorySubCatgeoryAddUpdateModel list=GrievanceCategoryHierarchyModel.getAllArrayList(data);
	         int success = GrievanceCategoryHierarchyDAO.insertGrievanceCategory(list.getAdd());
	         int editSuccess = GrievanceCategoryHierarchyDAO.updategrievanceCategory(list.getEdit());
	         String url;
	         if(success>0) {
	             session.setAttribute("success-message", "Data submitted successfully");
	         }else {
	
	             session.setAttribute("authError", "Error in insert Case Status Master");
	         }
	         jsonObject.put("status",200);
	 		 jsonResponse = jsonObject.toString();
	         response.setContentType("application/json");
	     	 response.getWriter().write(jsonResponse);
	} catch (Exception ex) {
    	ex.printStackTrace();
    	Logger.getLogger(CreateGrievanceCategoryHierarchy.class.getName()).log(Level.SEVERE, null, ex);
    }
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);

	} 

}
