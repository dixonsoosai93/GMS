package com.gms.servlet.masters;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.gms.dao.masters.RegionMasterDAO;

@WebServlet("/CheckBranch")
public class CheckBranch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CheckBranch.class.getName());
	
       
    public CheckBranch() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	 
		String jsonResponse = null;
        JSONObject jsonObject = new JSONObject();
        boolean check=false;
        try {
			String BRANCH_CODE = request.getParameter("BRANCH_CODE");
			 check = RegionMasterDAO.checkBranch(BRANCH_CODE);
        }  catch(Exception ex) {
        	ex.printStackTrace();
        	Logger.getLogger(CheckBranch.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        jsonObject.put("status", 200);
		jsonObject.put("data", check);
		jsonResponse = jsonObject.toString();
        response.setContentType("application/json");
    	response.getWriter().write(jsonResponse);
	}

}
