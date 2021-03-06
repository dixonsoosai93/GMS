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

/**
 * Servlet implementation class GetSubCategoryCodeEdit
 */
@WebServlet("/GetSubCategoryCodeEdit")
public class GetSubCategoryCodeEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(GetSubCategoryCodeEdit.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSubCategoryCodeEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Inside the doPost() method");
		String jsonResponse = null;
        JSONObject jsonObject = new JSONObject();
        String getSubCategoryValue = request.getParameter("subCategoryCode");
        String mainCategoryCode = request.getParameter("mainCategoryCode");
        System.out.println("getSubCategoryValue :"+getSubCategoryValue+"mainCategoryCode :"+mainCategoryCode);
        String optSubCategory = "<option selected=\"selected\" >"+getSubCategoryValue+"</option>";
        try {
			List<GrievanceCategoryHierarchyModel> grievanceCategoryHierarchy = GrievanceCategoryHierarchyDAO.getSubGrid(mainCategoryCode);
			if(grievanceCategoryHierarchy != null && grievanceCategoryHierarchy.size() > 0) {
				for(GrievanceCategoryHierarchyModel item: grievanceCategoryHierarchy) {
					optSubCategory += "<option value='"+item.getSUB_CATEGORY_NAME()+"' data-key1='"+item.getHIERCODE()+"' data-key2='"+item.getSUB_CATEGORY_CODE()+"'>"+item.getSUB_CATEGORY_NAME()+"</option>";
				}
			}
        }  catch(Exception ex) {
        	ex.printStackTrace();
        	logger.info("Exception Inside the doPost() Exception "+ex.getMessage());
        	Logger.getLogger(GetSubCategoryCode.class.getName()).log(Level.SEVERE, null, ex);
        }
        jsonObject.put("status", 200);
		jsonObject.put("data", optSubCategory);
		jsonResponse = jsonObject.toString();
        response.setContentType("application/json");
    	response.getWriter().write(jsonResponse);
    	logger.info("Inside the doPost() method");
	}

}
