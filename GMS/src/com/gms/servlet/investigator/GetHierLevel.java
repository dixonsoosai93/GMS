package com.gms.servlet.investigator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.gms.dao.investigator.DailyProofUploadDAO;
import com.gms.model.investigator.DailyDairyProof;

/**
 * Servlet implementation class GetHierLevel
 */
@WebServlet("/GetHierLevel")
public class GetHierLevel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHierLevel() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String jsonResponse = null;
        JSONObject jsonObject = new JSONObject();
        DailyDairyProof dailyDairyProof = null;
        try {
        	String invId = request.getParameter("invId");
        	dailyDairyProof = DailyProofUploadDAO.getHierLevel(invId);
        		jsonObject.put("status", 200);
	    	} catch (Exception ex) {
	    		ex.printStackTrace();
	    		jsonObject.put("status", 201);
	    	} 
			jsonObject.put("HierarchyLevel", dailyDairyProof.getHIRECODE());
			jsonResponse = jsonObject.toString();
			response.setContentType("application/json");
			response.getWriter().write(jsonResponse);
		}

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
