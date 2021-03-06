package com.gms.servlet.grievance;

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

@WebServlet("/GetSubCategoryCode")
public class GetSubCategoryCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(GetSubCategoryCode.class.getName());
       
    public GetSubCategoryCode() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Inside the doPost() method");
		String jsonResponse = null;
        JSONObject jsonObject = new JSONObject();
        String optSubCategory = "<option selected=\"selected\" disabled>Choose Grievance Sub-Category</option>";
        try {
			String MAIN_CATEGORY_CODE = request.getParameter("MAIN_CATEGORY_CODE");
			List<GrievanceCategoryHierarchyModel> grievanceCategoryHierarchy = GrievanceCategoryHierarchyDAO.getSubGrid(MAIN_CATEGORY_CODE);
			if(grievanceCategoryHierarchy != null && grievanceCategoryHierarchy.size() > 0) {
				for(GrievanceCategoryHierarchyModel item: grievanceCategoryHierarchy) {
					optSubCategory += "<option value='"+item.getSUB_CATEGORY_NAME()+"' data-key1='"+item.getHIERCODE()+"' data-key2='"+item.getSUB_CATEGORY_CODE()+"'>"+item.getSUB_CATEGORY_NAME()+"</option>";
				}
			}
        }  catch(Exception ex) {
        	logger.info("Exception Inside the doPost() method Exception"+ ex.getMessage());
        	ex.printStackTrace();
        	Logger.getLogger(GetSubCategoryCode.class.getName()).log(Level.SEVERE, null, ex);
        }
        jsonObject.put("status", 200);
		jsonObject.put("data", optSubCategory);
		jsonResponse = jsonObject.toString();
        response.setContentType("application/json");
    	response.getWriter().write(jsonResponse);
    	logger.info("Leaving the doPost() method");
	}
	
}

