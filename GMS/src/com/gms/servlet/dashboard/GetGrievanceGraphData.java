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

@WebServlet("/GetGrievanceGraphData")
public class GetGrievanceGraphData extends HttpServlet {
	static Logger logger = Logger.getLogger(GetGrievanceGraphData.class.getName()); 
	private static final long serialVersionUID = 1L;
    
    public GetGrievanceGraphData() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
    	logger.info("Inside the processRequest() method ");
    	String jsonResponse = null;
        JSONObject jsonObject = new JSONObject();
        int days = Integer.parseInt(request.getParameter("days"));
        try {
        	if(days != 0) {
        		JSONArray jArray = Graph.getGrievanceGraph(days);
        		jsonObject.put("data", jArray);
        		jsonObject.put("status", 200);
        	}
        } catch (Exception ex) {
        	ex.printStackTrace();
        	logger.info("Exception inside the processRequest() method Exception : "+ ex.getMessage());
        	jsonObject.put("status",201);
        }
		jsonResponse = jsonObject.toString();
        response.setContentType("application/json");
    	response.getWriter().write(jsonResponse);
    	logger.info("Leaving the processRequest() method ");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ServletException | IOException | ParseException e) {
			e.printStackTrace();
			logger.info("Exception in the doGet() method Exception"+e.getMessage());
			Logger.getLogger(GetGrievanceGraphData.class.getName());
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ServletException | IOException | ParseException e) {
			e.printStackTrace();
			logger.info("Exception in the doPost() method Exception"+e.getMessage());
			Logger.getLogger(GetGrievanceGraphData.class.getName());
		}
	}

}
