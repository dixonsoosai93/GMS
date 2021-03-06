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

import com.gms.dao.masters.GrievanceCategoryHierarchyDAO;
import com.gms.model.masters.GrievanceCategoryHierarchyModel;
import com.gms.servlet.AdminLogin;

@WebServlet("/GrievanceCategoryHierarchySubGrid")
public class GrievanceCategoryHierarchySubGrid extends HttpServlet {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(GrievanceCategoryHierarchySubGrid.class.getName());
	private static final long serialVersionUID = 1L;
    public GrievanceCategoryHierarchySubGrid() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Inside the doPost() method");
		String jsonResponse = null;
        JSONObject jsonObject = new JSONObject();
        String SubGrid = "";
        try {
			String MAIN_CATEGORY_CODE = request.getParameter("MAIN_CATEGORY_CODE");
			String MAIN_CATEGORY_NAME = request.getParameter("categoryCode");
			List<GrievanceCategoryHierarchyModel> grievanceCategoryHierarchy = GrievanceCategoryHierarchyDAO.getSubGrid(MAIN_CATEGORY_CODE);
			if(grievanceCategoryHierarchy != null && grievanceCategoryHierarchy.size() > 0) { 
				int i=1;
				for(GrievanceCategoryHierarchyModel item: grievanceCategoryHierarchy) {
					SubGrid += "<tr>";
					SubGrid += "<td>"+i+"</td>";
					SubGrid += "<td style=\"display:none;\">"+item.getFLOWID()+"</td>";
					SubGrid += "<td>"+MAIN_CATEGORY_CODE+"</td>";
					SubGrid += "<td>"+MAIN_CATEGORY_NAME+"</td>";
					SubGrid += "<td>"+item.getSUB_CATEGORY_CODE()+"</td>";
					SubGrid += "<td>"+item.getSUB_CATEGORY_NAME()+"</td>";
					SubGrid += "<td>"+item.getHIERID()+"</td>";
					SubGrid += "<td>"+item.getHIERCODE()+"</td>";
					SubGrid += "<td>"+item.getCATEGORY_ORDER()+"</td>";
					SubGrid += "<td>"+(item.getIS_ACTIVE().equalsIgnoreCase("Y")?"YES":"NO")+"</td>";
					SubGrid += "<td>\r\n" + 
							"<ul class=\"d-flex justify-content-center\">\r\n" + 
							" <li class=\"mr-3\"><button type=\"button\" class=\"btn btn-inverse-secondary edit\" keys=\"<%=item.getFLOWID()%>\"><i class=\"fa fa-edit\"></i></button></li> \r\n" + 
							"</ul>\r\n" + 
							"</td>";
					SubGrid += "</tr>";
					i++;
				}
			}
        }  catch(Exception ex) {
        	ex.printStackTrace();
        	logger.info("Exception Inside the doPost() method Exception "+ex.getMessage());
        	Logger.getLogger(GrievanceCategoryHierarchySubGrid.class.getName()).log(Level.SEVERE, null, ex);
        	SubGrid = "<tr><td colspan=\"12\">No detail found</td></tr>";
        } 
        if(SubGrid.equals("")) {
        	SubGrid += "<tr><td colspan=\"12\">No detail found</td></tr>";
        	SubGrid += "<tr></tr>";
        }
        jsonObject.put("status", 200);
		jsonObject.put("data", SubGrid);
		jsonResponse = jsonObject.toString();
        response.setContentType("application/json");
    	response.getWriter().write(jsonResponse);
    	logger.info("Leaving the doPost() method");
	}
	
}


