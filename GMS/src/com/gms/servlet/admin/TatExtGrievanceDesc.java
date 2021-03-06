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

import com.gms.dao.admin.TatExtensionDAO;
import com.gms.model.admin.GridCase;
import com.gms.model.admin.GrievanceDesc;


@WebServlet("/TatExtGrievanceDesc")
public class TatExtGrievanceDesc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TatExtGrievanceDesc.class.getName());
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		logger.info("Inside the processReuest() method");
		String jsonResponse = null;
        JSONObject jsonObject = new JSONObject();
        String grid_case = "";
        try {
	    	int GRVDETID = Integer.parseInt(request.getParameter("GRVDETID"));
	    	GrievanceDesc grievanceDesc=TatExtensionDAO.getGrievanceDesc(GRVDETID);
	    	List<GridCase> gridCase=TatExtensionDAO.getGridCase(GRVDETID);
	    	
	    	if(grievanceDesc != null) {
	    		jsonObject.put("CASEID", grievanceDesc.getCASEID());
	    		jsonObject.put("CASENUMBER", grievanceDesc.getCASENUMBER());
	    		jsonObject.put("MAIN_CATEGORY_CODE", grievanceDesc.getMAIN_CATEGORY_CODE());
	    		jsonObject.put("MAIN_CATEGORY_NAME", grievanceDesc.getMAIN_CATEGORY_NAME());
	    		jsonObject.put("SUB_CATEGORY_CODE", grievanceDesc.getSUB_CATEGORY_CODE());
	    		jsonObject.put("SUB_CATEGORY_NAME", grievanceDesc.getSUB_CATEGORY_NAME());
	    		jsonObject.put("NAME", grievanceDesc.getNAME());
	    		jsonObject.put("COMPLAINT_DESC", grievanceDesc.getCOMPLAINT_DESC());
	    		jsonObject.put("RESPONDENT_EMPLOYEE_ID", grievanceDesc.getRESPONDENT_EMPLOYEE_ID());
	    		jsonObject.put("GRVID", grievanceDesc.getGRVID());
	    		jsonObject.put("COMPLIANT_EMPLOYEE_ID", grievanceDesc.getCOMPLIANT_EMPLOYEE_ID());
	    		jsonObject.put("GROUP_COMPLIANT", (grievanceDesc.getGROUP_COMPLIANT().equals("Y")?"Group":"Single"));
	    		jsonObject.put("COMPLAINT_DESC", grievanceDesc.getCOMPLAINT_DESC());
	    		jsonObject.put("RESPONDENT_EMPLOYEE_NAME", grievanceDesc.getRESPONDENT_EMPLOYEE_NAME());
	    	}
	    	
	    	if(gridCase != null && gridCase.size() >0) {
	    		int i =1;
	    		for(GridCase item : gridCase) {
	    			grid_case+="<tr>";	
	    			grid_case+="<td>"+i+"</td>";
	    			grid_case+="<td>"+item.getCASEID()+"</td>";
	    			grid_case+="<td>"+item.getHIERCODE()+"</td>";
	    			grid_case+="<td>"+item.getHIERORDER()+"</td>";
	    			grid_case+="<td>"+item.getTAT_START_DATE()+"</td>";
	    			grid_case+="<td>"+item.getTAT_ACTUAL_END_DATE()+"</td>";
	    			grid_case+="<td>"+(item.getCURRENT_ROW_COMPLETED().equals("Y")?"Yes":"No")+"</td>";
	    			grid_case+="<td>"+(item.getCURRENT_ROW_ACTIVE().equals("Y")?"Yes":"No")+"</td>";
	    			grid_case+="<td>"+(item.getIS_ACTIVE().equals("Y")?"Active":"InActive")+"</td>";
	    			grid_case+="<td>"+item.getINVESTIGATOR_EMPLOYEE_ID()+"</td>";
	    			grid_case+="<td>"+(item.getNAME()==null?"":item.getNAME())+"</td>";
	    			grid_case+="<td>"+item.getBUFFERDAYS()+"</td>";
	    			grid_case+="<td>"+(item.getTATEXT_REASON() != null?item.getTATEXT_REASON():"")+"</td>";
	    			grid_case+="<td>"+((item.getCURRENT_ROW_COMPLETED().equals("N")) && (item.getCURRENT_ROW_ACTIVE().equals("Y"))==true? "<button type=\"button\" data-key1='"+item.getBUFFERDAYS()+"' data-key2='"+item.getINVESTIGATOR_EMPLOYEE_ID()+"' data-key3='"+item.getCASEID()+"' data-key4='"+GRVDETID+"' class=\"btn btn-primary extendTat\">Extend TAT</button>":"")+"</td>";
	    			i++;
	    			}
	    		}
	    	
	    	} catch (Exception ex) {
	    		ex.printStackTrace();
	    		logger.info("Exception Inside the processReuest() method Exception "+ex.getMessage());
	    		grid_case = "<tr><td colspan=\"12\">No detail found</td></tr>";
	    		Logger.getLogger(TatExtGrievanceDesc.class.getName()).log(Level.SEVERE, null, ex);
	    	}
	        if(grid_case.equals("")) {
	        	grid_case = "<tr><td colspan=\"12\">No detail found</td></tr>";
	        }
	        jsonObject.put("status", 200);
			jsonObject.put("data", grid_case);
			jsonResponse = jsonObject.toString();
	        response.setContentType("application/json");
			response.getWriter().write(jsonResponse);
			logger.info("Leaving the processReuest() method");
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}


}
