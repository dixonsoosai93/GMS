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
import com.gms.model.admin.GridCase;
import com.gms.model.investigator.DtVerdict;

@WebServlet("/GetFinalAndHirarchyDetails")
public class GetFinalAndHirarchyDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(GetFinalAndHirarchyDetails.class.getName());
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		logger.info("Inside the processRequest() method");
		String jsonResponse = null;
        JSONObject jsonObject = new JSONObject();
        String final_List = "";
        String hierarchy_List = "";
        try {
        	String GRVDETID = request.getParameter("GRVDETID");
	    	List<DtVerdict> dtVerdict = EmpGrievanceCaseViewDAO.getFinalVerdict(GRVDETID);
	    	if(dtVerdict != null && dtVerdict.size() >0) {
	    		int i =1;
	    		for(DtVerdict item : dtVerdict) {
	    			final_List+="<tr>";		
	    			final_List+="<td>"+i+"</td>";
	    			final_List+="<td>"+item.getGRVDETID()+"</td>";
	    			final_List+="<td>"+item.getCASENUMBER()+"</td>";
	    			final_List+="<td>"+item.getVERDICTID()+"</td>";
	    			final_List+="<td>"+item.getVERDICT_REPORT_DATE()+"</td>";
	    			final_List+="<td>"+item.getVERDICT_REPORT_CONTENT()+"</td>";
	    			final_List+="</tr>";
	    			i++;
	    			}
	    		} else {
	    		final_List = "<tr><td colspan=\"12\">No detail found</td></tr>";
	    	}
	    	
	    	List<GridCase> gridCase = EmpGrievanceCaseViewDAO.getHierarchyWiseDetail(GRVDETID);
		    	if(gridCase != null && gridCase.size() >0) {
		    		int i =1;
		    		for(GridCase item : gridCase) {
		    			hierarchy_List+="<tr class=\"dailyRow\" data-key1='"+item.getCASEID()+"' style=\"cursor: pointer\">";		
		    			hierarchy_List+="<td>"+i+"</td>";
		    			hierarchy_List+="<td>"+item.getCASEID()+"</td>";
		    			hierarchy_List+="<td>"+item.getGRVDETID()+"</td>";
		    			hierarchy_List+="<td>"+item.getCASENUMBER()+"</td>";
		    			hierarchy_List+="<td>"+item.getMAIN_CATEGORY_CODE()+"</td>";
		    			hierarchy_List+="<td>"+item.getSUB_CATEGORY_CODE()+"</td>";
		    			hierarchy_List+="<td>"+item.getHIERCODE()+"</td>";
		    			hierarchy_List+="<td>"+item.getHIERORDER()+"</td>";
		    			hierarchy_List+="<td>"+item.getTAT_START_DATE()+"</td>";
		    			hierarchy_List+="<td>"+item.getTAT_ACTUAL_END_DATE()+"</td>";
		    			hierarchy_List+="<td>"+(item.getTAT_EXTENDED().equalsIgnoreCase("Y")?"Yes":"No")+"</td>";
		    			hierarchy_List+="<td>"+item.getTAT_EXTENDED_EMPLOYEE_ID()+"</td>";
		    			hierarchy_List+="<td>"+item.getTAT_END_DATE()+"</td>";
		    			hierarchy_List+="<td>"+(item.getINVESTIGATOR_NEEDED().equalsIgnoreCase("Y")?"Yes":"No")+"</td>";
		    			hierarchy_List+="<td>"+(item.getINVESTIGATOR_ASSIGNED().equalsIgnoreCase("Y")?"Yes":"No")+"</td>";
		    			hierarchy_List+="<td>"+(item.getDECISION_ARRIVED().equalsIgnoreCase("Y")?"Yes":"No")+"</td>";
		    			hierarchy_List+="<td>"+item.getREASON_NO_DECISION()+"</td>";
		    			hierarchy_List+="<td>"+(item.getDECISION_REPORT().equalsIgnoreCase("Y")?"Yes":"No")+"</td>";
		    			hierarchy_List+="<td>"+(item.getDECISION_SIGNATURE().equalsIgnoreCase("Y")?"Yes":"No")+"</td>";
		    			hierarchy_List+="<td>"+(item.getEMP_ACCEPT_DECISION().equalsIgnoreCase("Y")?"Yes":"No")+"</td>";
		    			hierarchy_List+="<td>"+(item.getEMP_NOT_ACCEPT_REASON().equalsIgnoreCase("Y")?"Yes":"No")+"</td>";
		    			hierarchy_List+="<td>"+(item.getCURRENT_ROW_COMPLETED().equalsIgnoreCase("Y")?"Yes":"No")+"</td>";
		    			hierarchy_List+="<td>"+(item.getCURRENT_ROW_ACTIVE().equalsIgnoreCase("Y")?"Yes":"No")+"</td>";
		    			hierarchy_List+="<td>"+(item.getIS_ACTIVE().equalsIgnoreCase("Y")?"Yes":"No")+"</td>";
		    			hierarchy_List+="<td>"+item.getINVESTIGATOR_EMPLOYEE_ID()+"</td>";
		    			hierarchy_List+="<td>"+item.getDECISION_REPORT_DATE()+"</td>";
		    			hierarchy_List+="<td>"+item.getDECISION_REPORT_CONTENT()+"</td>";
		    			hierarchy_List+="</tr>";
		    			i++;
		    			}
		    		}
		    	else {
		    		hierarchy_List = "<tr><td colspan=\"12\">No detail found</td></tr>";
		    	}
	    	} catch (Exception ex) {
	    		ex.printStackTrace();
	    		logger.info("Exception Inside the processRequest() method Exception "+ex.getMessage());
	    		Logger.getLogger(GetFinalAndHirarchyDetails.class.getName()).log(Level.SEVERE, null, ex);
	    	}
	        jsonObject.put("status", 200);
			jsonObject.put("finalList", final_List);
			jsonObject.put("hierarchyList", hierarchy_List);
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
