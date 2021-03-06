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

import com.gms.dao.admin.AlternateInvReAssignDAO;
import com.gms.model.masters.CentralCommitteeInvestigatorModel;
import com.gms.model.masters.RhrInvestigatorMasterModel;
import com.gms.model.masters.ZlgcInvestigatorMasterModel;

@WebServlet("/HierarchySelectList")
public class HierarchySelectList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(GrievanceCaseList.class.getName());
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("Inside the processRequest() method");	
			String jsonResponse = null;
	        JSONObject jsonObject = new JSONObject();
	        String rhr_List = "";
	        String zlgc_List = "";
	        String centcom_List = "";
	        try {
	        	String HIREORDER = request.getParameter("HIREORDER");
	        	String REGION_CODE = request.getParameter("REGION_CODE");
	        	String ZONE_CODE = request.getParameter("ZONE_CODE");
	        	
	        	if(HIREORDER.equals("4")) {
	        		logger.info("Inside the processRequest() method where HIREORDER equals 4");	
	        		List<CentralCommitteeInvestigatorModel> centralInv = AlternateInvReAssignDAO.getCentralCommitteeList();
			    	if(centralInv != null && centralInv.size() >0) {
			    		int i =1;
			    		for(CentralCommitteeInvestigatorModel item : centralInv) {
			    			centcom_List+="<tr>";
			    			centcom_List+="<td>"+"<input type=\"radio\" name=\"rhr\" class=\"selectRow\" id=\"emp\" data-key1='"+item.getINVESTIGATOR_EMPLOYEE_ID()+"'>"+"</td>";
			    			centcom_List+="<td>"+i+"</td>";
			    			centcom_List+="<td>"+item.getCENTRALID()+"</td>";
			    			centcom_List+="<td>"+item.getNAME()+"</td>";
			    			centcom_List+="<td>"+item.getINVESTIGATOR_EMPLOYEE_ID()+"</td>";
			    			centcom_List+="<td>"+item.getDESIGNATION()+"</td>";
			    			centcom_List+="<td>"+item.getDEPARTMENT()+"</td>";
			    			centcom_List+="<td>"+(item.getIS_HR().equalsIgnoreCase("Y")?"Yes":"No")+"</td>";
			    			centcom_List+="</tr>";
			    			i++;
			    			}
			    	} else {
			    		centcom_List = "<tr><td colspan=\"12\">No detail found</td></tr>";
			    	}
			    	jsonObject.put("data", centcom_List);
			    	logger.info("Leaving the processRequest() method where HIREORDER equals 4");
	        	} else if(HIREORDER.equals("2")) {
	        		logger.info("Inside the processRequest() method where HIREORDER equals 2");
	        		List<RhrInvestigatorMasterModel> rhrInv = AlternateInvReAssignDAO.getRhrList(REGION_CODE);
			    	if(rhrInv != null && rhrInv.size() >0) {
			    		int i =1;
			    		for(RhrInvestigatorMasterModel item : rhrInv) {
			    			rhr_List+="<tr>";
			    			rhr_List+="<td>"+"<input type=\"radio\" name=\"rhr\" class=\"selectRow\" id=\"rhrRadio\" data-key1='"+item.getINVESTIGATOR_EMPLOYEE_ID()+"'>"+"</td>";
			    			rhr_List+="<td>"+i+"</td>";
			    			rhr_List+="<td>"+item.getRHRID()+"</td>";
			    			rhr_List+="<td>"+item.getREGION_CODE()+"</td>";
			    			rhr_List+="<td>"+item.getREGION_NAME()+"</td>";
			    			rhr_List+="<td>"+item.getNAME()+"</td>";
			    			rhr_List+="<td>"+item.getINVESTIGATOR_EMPLOYEE_ID()+"</td>";
			    			rhr_List+="<td>"+item.getDESIGNATION()+"</td>";
			    			rhr_List+="<td>"+item.getDEPARTMENT()+"</td>";
			    			rhr_List+="<td>"+(item.getIS_HR().equalsIgnoreCase("Y")?"Yes":"No")+"</td>";
			    			rhr_List+="</tr>";
			    			i++;
			    			}
			    		} else {
			    			rhr_List = "<tr><td colspan=\"12\">No detail found</td></tr>";
			    		}
		    	     jsonObject.put("data", rhr_List);
		    	     logger.info("Leaving the processRequest() method where HIREORDER equals 2");
	        	} else if(HIREORDER.equals("3")) {
	        		logger.info("Inside the processRequest() method where HIREORDER equals 3");
	        		List<ZlgcInvestigatorMasterModel> zlgcInv = AlternateInvReAssignDAO.getZlgcInvestigator(ZONE_CODE);
	        		if(zlgcInv != null && zlgcInv.size() >0) {
			    		int i =1;
			    		for(ZlgcInvestigatorMasterModel item : zlgcInv) {
			    			zlgc_List+="<tr>";
			    			zlgc_List+="<td>"+"<input type=\"radio\" name=\"rhr\" class=\"selectRow\" id=\"rhrRadio\" data-key1='"+item.getINVESTIGATOR_EMPLOYEE_ID()+"' >"+"</td>";
			    			zlgc_List+="<td>"+i+"</td>";
			    			zlgc_List+="<td>"+item.getZLGCID()+"</td>";
			    			zlgc_List+="<td>"+item.getZONE_CODE()+"</td>";
			    			zlgc_List+="<td>"+item.getZONE_NAME()+"</td>";
			    			zlgc_List+="<td>"+item.getNAME()+"</td>";
			    			zlgc_List+="<td>"+item.getINVESTIGATOR_EMPLOYEE_ID()+"</td>";
			    			zlgc_List+="<td>"+item.getDESIGNATION()+"</td>";
			    			zlgc_List+="<td>"+item.getDEPARTMENT()+"</td>";
			    			zlgc_List+="<td>"+(item.getIS_HR().equalsIgnoreCase("Y")?"Yes":"No")+"</td>";
			    			zlgc_List+="</tr>";
			    			i++;
			    			}
			    		} else {
			    			zlgc_List = "<tr><td colspan=\"12\">No detail found</td></tr>";
			    		}
		    	     jsonObject.put("data", zlgc_List);
		    	     logger.info("Leaving the processRequest() method where HIREORDER equals 3");
	        	}else {
	        	}
		    	} catch (Exception ex) {
		    		ex.printStackTrace();
		    		logger.info("Exception Inside the processRequest() method Exception"+ex.getMessage());
		    		Logger.getLogger(GrievanceCaseList.class.getName()).log(Level.SEVERE, null, ex);
		    	}
		        jsonObject.put("status", 200);
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
