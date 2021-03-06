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

import com.gms.dao.admin.ReopenCaseDAO;
import com.gms.model.admin.GridCase;

/**
 * Servlet implementation class ReopenCaseLevel
 */
@WebServlet("/ReopenCaseLevel")
public class ReopenCaseLevel extends HttpServlet {
	static Logger logger = Logger.getLogger(ReopenCaseLevel.class.getName());
	private static final long serialVersionUID = 1L;
       
    public ReopenCaseLevel() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		logger.info("Inside the processRequest() method ");
    	String jsonResponse = null;
        JSONObject jsonObject = new JSONObject();
        String grid_case = "";
        try {
	    	int GRVDETID = Integer.parseInt(request.getParameter("GRVDETID"));
	    	List<GridCase> gridCase=ReopenCaseDAO.getCaseReopenLevel(GRVDETID);
	    	System.out.println(gridCase.toString());
	    	if(gridCase != null && gridCase.size() >0) {
	    		int i =1;
	    		for(GridCase item : gridCase) {
	    			grid_case+="<tr>";	
	    			grid_case+="<td>"+i+"</td>";
	    			grid_case+="<td>"+item.getHIERORDER()+"</td>";
	    			grid_case+="</tr>";	
	    			i++;
	    			}
	    		}
	    	
	    	
	    	} catch (Exception ex) {
	    		ex.printStackTrace();
	    		logger.info("Exception inside the processRequest() method Exception : "+ ex.getMessage());
	    		Logger.getLogger(ReopenCase.class.getName()).log(Level.SEVERE, null, ex);
	    		grid_case = "<tr><td colspan=\"2\">No detail found</td></tr>";
	    	}
	        if(grid_case.equals("")) {
	        	grid_case = "<tr><td colspan=\"2\">No detail found</td></tr>";
	        }
	        jsonObject.put("status", 200);
			jsonObject.put("data", grid_case);
			jsonResponse = jsonObject.toString();
	        response.setContentType("application/json");
			response.getWriter().write(jsonResponse);
		logger.info("Leaving the processRequest() method ");
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
