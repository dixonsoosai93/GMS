package com.gms.servlet.dashboard;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.gms.dao.dashboard.Graph;

/**
 * Servlet implementation class GetHierCodeData
 */
@WebServlet("/GetHierCodeData")
public class GetHierCodeData extends HttpServlet {
	static Logger logger = Logger.getLogger(GetHierCodeData.class.getName());
	private static final long serialVersionUID = 1L;
    
    public GetHierCodeData() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		logger.info("Inside processRequest() method");
    	String jsonResponse = null;
        JSONObject jsonObject = new JSONObject();
        int days = Integer.parseInt(request.getParameter("days"));
        try {
        	if(days != 0) {
        		JSONArray jArray = Graph.getHierCode(days);
        		jsonObject.put("data", jArray);
        		jsonObject.put("status", 200);
        	}
        } catch (Exception ex) {
        	ex.printStackTrace();
        	jsonObject.put("status",201);
        	logger.info("Exception in processReuest() method Exception :"+ex.getMessage());
        }
		jsonResponse = jsonObject.toString();
        response.setContentType("application/json");
    	response.getWriter().write(jsonResponse);
    	logger.info("Leaving processRequest() method");
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ServletException | IOException | ParseException e) {
			e.printStackTrace();
			logger.info("Exception in doGet method Exception :"+e.getMessage());
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ServletException | IOException | ParseException e) {
			e.printStackTrace();
			logger.info("Exception in doPost method Exception :"+e.getMessage());
		}
	}
}
