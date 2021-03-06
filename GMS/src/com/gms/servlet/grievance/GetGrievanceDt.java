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

import com.gms.dao.grievance.EmployeeGrievanceDAO;
import com.gms.model.grievance.DtGrievanceModel;

@WebServlet("/GetGrievanceDt")
public class GetGrievanceDt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(GetGrievanceDt.class.getName());
	
    public GetGrievanceDt() {
        super();}
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		response.getWriter().append("Served at: ").append(request.getContextPath());
    	}

    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		logger.info("Inside the doPost() method");
    		String jsonResponse = null;
            JSONObject jsonObject = new JSONObject();
            String grievanceGridList = "";
            try {
    			int GRVID = Integer.parseInt(request.getParameter("GRVID"));
    			List<DtGrievanceModel> DtGrievance = EmployeeGrievanceDAO.getGrievanceDt(GRVID);
    			if(DtGrievance != null && DtGrievance.size() > 0) { 
    				int i=1;
    				for(DtGrievanceModel item: DtGrievance) {
    					grievanceGridList += "<tr>";
    					grievanceGridList += "<td>"+i+"</td>";
    					grievanceGridList += "<td>"+item.getGRVID()+"</td>";
    					grievanceGridList += "<td>"+item.getGRVDETID()+"</td>";
    					grievanceGridList += "<td>"+item.getMAIN_CATEGORY_CODE()+"</td>";
    					grievanceGridList += "<td>"+item.getSUB_CATEGORY_CODE()+"</td>";
    					grievanceGridList += "<td>"+item.getMainCategoryName()+"</td>";
    					grievanceGridList += "<td>"+item.getSubCategoryName()+"</td>";
    					grievanceGridList += "<td>"+item.getEMPLOYEETYPE()+"</td>";
    					grievanceGridList += "<td>"+item.getRESPONDENT_EMPLOYEE_ID()+"</td>";
    					grievanceGridList += "<td>"+item.getRESPONDENT_EMPLOYEE_NAME()+"</td>";
    					grievanceGridList += "<td>"+item.getCOMPLAINT_DESC()+"</td>";
    					grievanceGridList += "<td>"+item.getCASENUMBER()+"</td>";
    					grievanceGridList += "<td>"+item.getDEFAULT_HIERCODE()+"</td>";
    					grievanceGridList += "<td>"+item.getDEFAULT_HIERCODE()+"</td>";
    					grievanceGridList += "<td>"+item.getSTATUSID()+"</td>";
    					grievanceGridList += "<td>"+((item.getREOPEN_FLAG().equals("Y")) ==true? "<button type=\"button\" data-key1='"+item.getGRVDETID()+"' class=\"btn btn-primary reopenCase\">Reopen</button>":"")+"</td>";
    					grievanceGridList += "</tr>";
    					i++;
    				}
    			}
            }  catch(Exception ex) {
            	ex.printStackTrace();
            	logger.info("Exception Inside the doPost() method Exception "+ ex.getMessage());
            	Logger.getLogger(GetGrievanceDt.class.getName()).log(Level.SEVERE, null, ex);
            	grievanceGridList = "<tr><td colspan=\"12\">No detail found</td></tr>";
            } 
            if(grievanceGridList.equals("")) {
            	grievanceGridList = "<tr><td colspan=\"12\">No detail found</td></tr>";
            }
            jsonObject.put("status", 200);
    		jsonObject.put("data", grievanceGridList);
    		jsonResponse = jsonObject.toString();
            response.setContentType("application/json");
        	response.getWriter().write(jsonResponse);
        	logger.info("Leaving the doPost() method");
    	}

    }
