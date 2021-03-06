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
import com.gms.model.grievance.DtGrievanceModel;

@WebServlet("/GrievanceCaseList")
public class GrievanceCaseList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(GrievanceCaseList.class.getName());
       
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		 logger.info("Inside the processRequest() method");
		 	String jsonResponse = null;
	        JSONObject jsonObject = new JSONObject();
	        String case_List = "";
		        try {
		        	String INVESTIGATOR_EMPLOYEE_ID = request.getParameter("INVESTIGATOR_EMPLOYEE_ID");
			    	String GRVID = request.getParameter("GRVID");
			    	int grvid=0;
				    	if(GRVID!=null) {
				    		grvid=Integer.parseInt(GRVID);
				    	}
				    	List<DtGrievanceModel> caseList = EmpGrievanceCaseViewDAO.getGrvCaseList(INVESTIGATOR_EMPLOYEE_ID,grvid);
					    	if(caseList != null && caseList.size() >0) {
				    		int i =1;
				    		for(DtGrievanceModel item : caseList) {
				    			case_List+="<tr class=\"finalRow\" data-key1='"+item.getGRVDETID()+"' style=\"cursor: pointer\">";		
				    			case_List+="<td>"+i+"</td>";
				    			case_List+="<td>"+item.getGRVID()+"</td>";
				    			case_List+="<td>"+item.getGRVDETID()+"</td>";
				    			case_List+="<td>"+item.getCASENUMBER()+"</td>";
				    			case_List+="<td>"+item.getMAIN_CATEGORY_CODE()+"</td>";
				    			case_List+="<td>"+item.getSUB_CATEGORY_CODE()+"</td>";
				    			case_List+="<td>"+item.getEMPLOYEETYPE()+"</td>";
				    			case_List+="<td>"+item.getRESPONDENT_EMPLOYEE_ID()+"</td>";
				    			case_List+="<td>"+item.getRESPONDENT_EMPLOYEE_NAME()+"</td>";
				    			case_List+="<td>"+item.getCOMPLAINT_DESC()+"</td>";
				    			case_List+="<td>"+item.getDEFAULT_HIERCODE()+"</td>";
				    			case_List+="<td>"+item.getSTART_HIERCODE()+"</td>";
				    			case_List+="<td>"+item.getSTATUSNAME()+"</td>";
				    			case_List+="</tr>";
				    			i++;
				    			}
				    		}
				    	} catch (Exception ex) {
				    		ex.printStackTrace();
				    		logger.info("Exception Inside the processRequest() method Exception "+ex.getMessage());
				    		Logger.getLogger(GrievanceCaseList.class.getName()).log(Level.SEVERE, null, ex);
				    	}
		        jsonObject.put("status", 200);
				jsonObject.put("data", case_List);
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
