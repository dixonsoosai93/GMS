
package com.gms.servlet.investigator;

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

import com.gms.dao.investigator.DailyProofUploadDAO;
import com.gms.model.investigator.DailyDairyProof;

@WebServlet("/GetInvReport")
public class GetInvReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(GetInvReport.class.getName());
	  
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	logger.info("Inside the processRequest() method");
		String jsonResponse = null;
        JSONObject jsonObject = new JSONObject();
        String report_list = "";
        String flag = "";
        String isCompletedDairyDairy = "";
        String isCompletedDecisonReport = "";
        try {
	    	String Report_Type = request.getParameter("Report_Type");
	    	int Investigator_Id = Integer.parseInt(request.getParameter("Investigator_Id"));
	    	List<DailyDairyProof> dailyProof = DailyProofUploadDAO.getInvReport(Report_Type, Investigator_Id);
	    	if(dailyProof != null && dailyProof.size() >0) {
	    		int i =1;
	    		for(DailyDairyProof item : dailyProof) {
	    			report_list+="<tr>";	
	    			report_list+="<td>"+i+"</td>";
	    			report_list+="<td>"+item.getGRVDATE()+"</td>";
	    			report_list+="<td>"+item.getGRVID()+"</td>";
	    			report_list+="<td>"+item.getGRVDETID()+"</td>";
	    			report_list+="<td style=\"display:none\">"+item.getGRVNUMBER()+"</td>";
	    			report_list+="<td>"+item.getCOMPLIANT_EMPLOYEE_ID()+"</td>";
	    			report_list+="<td>"+item.getNAME()+"</td>";
	    			report_list+="<td>"+item.getRESPONDENT_EMPLOYEE_ID()+"</td>";
	    			report_list+="<td>"+item.getRESPONDENT_EMPLOYEE_NAME()+"</td>";
	    			report_list+="<td>"+item.getTAT_START_DATE()+"</td>";
	    			report_list+="<td>"+item.getTAT_END_DATE()+"</td>";
	    			report_list+="<td>"+item.getEMP_TYPE()+"</td>";
	    			report_list+="<td>"+item.getCOMPLAINT_DESC()+"</td>";
	    			report_list+="<td>"+item.getCASEID()+"</td>";
	    			flag = item.getFLAG();
	    			isCompletedDairyDairy = item.getIsCompleted();
	    			isCompletedDecisonReport = item.getDecisionReportFlag();
	    			report_list+="<td>"+
								"<ul class=\"d-flex justify-content-center\">\r\n" + 
								(Report_Type.equalsIgnoreCase("A")?"<li class=\"mr-3\"><button type=\"button\" onclick=\"location.href ='ViewCaseRecord.jsp?CASEID="+item.getCASEID()+"&GRVID="+item.getGRVID()+"&GRVDETID="+item.getGRVDETID()+"&Report_Type="+Report_Type+"'\" class=\"btn btn-inverse-secondary \"><i class=\"fa fa-file\"></i></button></li> \r\n":"") + 
								"</ul>\r\n" + 
	    					"</td>\r\n" + 
	    					"";
	    			report_list+="<td><ul class=\"d-flex justify-content-center\">\r\n" + 
	    					(isCompletedDairyDairy.equalsIgnoreCase("Y")?"<li class=\"mr-3\"><button type=\"button\" onclick=\"location.href = 'DecisionReport.jsp?CASEID="+item.getCASEID()+"&GRVDETID="+item.getGRVDETID()+"&Report_Type="+Report_Type+"'\" class=\"btn btn-inverse-secondary \"><i class=\"fa fa-file\"></i></button></li> \r\n":"") + 
	    					"</ul>\r\n" + 
	    					"</td>\r\n" + 
	    					"";
	    			report_list+="<td><ul class=\"d-flex justify-content-center\">\r\n" + 
	    					(isCompletedDecisonReport.equalsIgnoreCase("Y")?"<li class=\"mr-3\"><button type=\"button\" onclick=\"location.href = 'FinalVerdict.jsp?CASEID="+item.getCASEID()+"&GRVDETID="+item.getGRVDETID()+"&Report_Type="+Report_Type+"'\" class=\"btn btn-inverse-secondary \"><i class=\"fa fa-file\"></i></button></li> \r\n":"") + 
	    					"</ul>\r\n" + 
	    					"</td>\r\n" + "";
	    			report_list+="</tr>";
	    			i++;
	    			}
	    		}
	    	else {
	    		report_list = "<tr><td colspan=\"17\">No detail found</td></tr>";
	    	}
	    	} catch (Exception ex) {
	    		ex.printStackTrace();
	    		logger.info("Exception the processRequest() method Exception "+ex.getMessage());
	    		Logger.getLogger(GetInvReport.class.getName()).log(Level.SEVERE, null, ex);
	    	}
	        jsonObject.put("status", 200);
			jsonObject.put("data", report_list);
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
