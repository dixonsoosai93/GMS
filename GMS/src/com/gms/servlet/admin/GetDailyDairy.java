package com.gms.servlet.admin;

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

import com.gms.dao.admin.EmpGrievanceCaseViewDAO;
import com.gms.model.investigator.DtDailyDairy;

@WebServlet("/GetDailyDairy")
public class GetDailyDairy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(GetDailyDairy.class.getName());
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		logger.info("Inside the processRequest() method");
		String jsonResponse = null;
        JSONObject jsonObject = new JSONObject();
        String dairy_List = "";
        try {
        	int CASEID = Integer.parseInt(request.getParameter("CASEID"));
	    	List<DtDailyDairy> dailyDairy = EmpGrievanceCaseViewDAO.getDailyDairy(CASEID);
	    	
	    	if(dailyDairy != null && dailyDairy.size() >0) {
	    		int i =1;
	    		for(DtDailyDairy item : dailyDairy) {
	    			dairy_List+="<tr>";		
	    			dairy_List+="<td>"+i+"</td>";
	    			dairy_List+="<td>"+item.getCASEID()+"</td>";
	    			dairy_List+="<td>"+item.getEMPLOYEE_ID()+"</td>";
	    			dairy_List+="<td>"+item.getNAME()+"</td>";
	    			dairy_List+="<td>"+item.getHIRECODE()+"</td>";
	    			dairy_List+="<td>"+item.getDAIRYID()+"</td>";
	    			dairy_List+="<td>"+item.getDAIRY_DATE()+"</td>";
	    			dairy_List+="<td>"+item.getDAIRY_DETAILS()+"</td>";
	    			dairy_List+="<td><button type=\"button\" class=\"btn btn-inverse-secondary attach\"><i class=\"fa fa-folder-open-o\"></i></button></td>";
	    			dairy_List+="<td>"+item.getENTRY_EMPLOYEE_ID()+"</td>";
	    			dairy_List+="<td>"+item.getNAME1()+"</td>";
	    			dairy_List+="</tr>";
	    			i++;
	    			}
	    		}
	    	else {
	    		dairy_List = "<tr><td colspan=\"12\">No detail found</td></tr>";
	    	}
	    	} catch (Exception ex) {
	    		ex.printStackTrace();
	    		logger.info("Exception Inside the processRequest() method Exception "+ex.getMessage());
	    		Logger.getLogger(GetDailyDairy.class.getName()).log(Level.SEVERE, null, ex);
	    	}
	        jsonObject.put("status", 200);
			jsonObject.put("data", dairy_List);
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
