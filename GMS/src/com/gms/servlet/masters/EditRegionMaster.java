package com.gms.servlet.masters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import com.gms.dao.masters.RegionMasterDAO;
import com.gms.model.masters.DtRegionModel;


@WebServlet("/EditRegionMaster")
public class EditRegionMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(EditRegionMaster.class.getName());
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Inside the processRequest() method");
		String jsonResponse = null;
		JSONObject jsonObject = new JSONObject();
		HashMap<String,String> errors = new HashMap<String, String>();
		HttpSession session =  request.getSession();
		String data = request.getParameter("data");
		ArrayList<DtRegionModel> list=DtRegionModel.getAllArrayList(data);
		try {
			int success = RegionMasterDAO.updateRegion(list);
			if(success>0) {
				session.setAttribute("success-message", "Data updated successfully");
			}else {
				session.setAttribute("authError", "Error in updating Employee Grievance ");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.info("Exception the processRequest() method Exception "+ex.getMessage());
		}
		jsonObject.put("status",200);
		jsonResponse = jsonObject.toString();
		response.setContentType("application/json");
		response.getWriter().write(jsonResponse);
		logger.info("Leaving the processRequest() method");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);

	} 

}

