package com.gms.servlet.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.gms.dao.admin.EmpGrievanceCaseViewDAO;
import com.gms.model.admin.EmployeeGrievanceCaseView;

@WebServlet("/EmpGrievanceCaseView")
public class EmpGrievanceCaseView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(EmpGrievanceCaseView.class.getName());
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		logger.info("Inside the processRequest() method");
		String jsonResponse = null;
        JSONObject jsonObject = new JSONObject();
		String EmpGrvCase = request.getParameter("empCase");
		String ZONE_CODE = request.getParameter("ZONE_CODE");
		String BRANCH_CODE = request.getParameter("BRANCH_CODE");
		String EMP_TYPE = request.getParameter("EMP_TYPE");
		String REGION_CODE = request.getParameter("REGION_CODE");
		String STATUSID = request.getParameter("STATUSID");
		String EmployeeID = request.getParameter("EmployeeID");
		String empType = "A";
		int REGION_ID=0;
		String Inv_List="";
		String Comp_List="";
		
		HashMap<String,String> errors = new HashMap<String, String>();
        HttpSession session =  request.getSession();
	        if(!REGION_CODE.isEmpty()) {
	        	REGION_ID=Integer.parseInt(REGION_CODE);
	        }
	        
	        if(EmpGrvCase.equals("A")){
	    	EmployeeGrievanceCaseView empGrievanceCaseView = new EmployeeGrievanceCaseView();
	        empGrievanceCaseView.setEMP_TYPE(EmpGrvCase);
	        empGrievanceCaseView.setZONE_CODE(ZONE_CODE);
	        empGrievanceCaseView.setEMP_TYPE(EMP_TYPE);
	        empGrievanceCaseView.setBRANCH_CODE(BRANCH_CODE);
	        empGrievanceCaseView.setREGION_ID(REGION_ID);
	        empGrievanceCaseView.setSTATUSID(STATUSID);
	        empGrievanceCaseView.setEmployeeID(EmployeeID);
	        List<EmployeeGrievanceCaseView> list = EmpGrievanceCaseViewDAO.getInvList(empGrievanceCaseView);
	        if(list != null && list.size() >0) {
	    		int i =1;
	    		for(EmployeeGrievanceCaseView item : list) {
	    			Inv_List+="<tr class=\"CaseRow\" data-key1='"+item.getINVESTIGATOR_EMPLOYEE_ID()+"' style=\"cursor: pointer\">";	
	    			Inv_List+="<td>"+i+"</td>";
	    			Inv_List+="<td>"+item.getINVESTIGATOR_ID()+"</td>";
	    			Inv_List+="<td>"+item.getINVESTIGATOR_EMPLOYEE_NAME()+"</td>";
	    			Inv_List+="<td>"+item.getINVESTIGATOR_EMPLOYEE_ID()+"</td>";
	    			Inv_List+="<td>"+item.getHIERCODE()+"</td>";
	    			Inv_List+="<td>"+item.getDEPARTMENT()+"</td>";
	    			Inv_List+="<td>"+(item.getREGION_NAME() != null?item.getREGION_NAME():"")+"</td>";
	    			Inv_List+="<td>"+item.getZONE_NAME()+"</td>";
	    			Inv_List+="<td>"+(item.getIS_ACTIVE().equalsIgnoreCase("Y")?"YES":"NO")+"</td>";
	    			Inv_List+="</tr>";	
	    			i++;
	    			}
		    		if(Inv_List.equals("")) {
		            	Inv_List = "<tr><td colspan=\"12\">No detail found</td></tr>";
		            }
	    		jsonObject.put("data", Inv_List);
	    		}
	        } else {
	        	EmployeeGrievanceCaseView empGrievanceCaseView = new EmployeeGrievanceCaseView();
		        empGrievanceCaseView.setEMP_TYPE(empType);
		        empGrievanceCaseView.setZONE_CODE(ZONE_CODE);
		        empGrievanceCaseView.setEMP_TYPE(EMP_TYPE);
		        empGrievanceCaseView.setBRANCH_CODE(BRANCH_CODE);
		        empGrievanceCaseView.setREGION_ID(REGION_ID);
		        empGrievanceCaseView.setSTATUSID(STATUSID);
		        empGrievanceCaseView.setEmployeeID(EmployeeID);
	        	List<EmployeeGrievanceCaseView> Complist = EmpGrievanceCaseViewDAO.getCompList(empGrievanceCaseView);
	        	if(Complist != null && Complist.size() >0) {
	         		int i =1;
	         		for(EmployeeGrievanceCaseView item : Complist) {
	         			Comp_List+="<tr class=\"CaseRow\" style=\"cursor: pointer\" data-key2='"+item.getGRVID()+"'>";	
	         			Comp_List+="<td>"+i+"</td>";
	         			Comp_List+="<td>"+item.getGrvDate()+"</td>";
	         			Comp_List+="<td>"+item.getGRVID()+"</td>";
	         			Comp_List+="<td>"+item.getGRVNUMBER()+"</td>";
	         			Comp_List+="<td>"+item.getCOMPLIANT_EMPLOYEE_ID()+"</td>";
	         			Comp_List+="<td>"+item.getNAME()+"</td>";
	         			Comp_List+="<td>"+item.getEMP_TYPE()+"</td>";
	         			Comp_List+="<td>"+(item.getGROUP_COMPLIANT().equalsIgnoreCase("Y")?"Group":"Single")+"</td>";
	         			Comp_List+="<td>"+(item.getIS_ACTIVE().equalsIgnoreCase("Y")?"YES":"NO")+"</td>";
	         			Comp_List+="</tr>";	
	         			i++;
	         			}
		         		if(Comp_List.equals("")) {
		         			Comp_List = "<tr><td colspan=\"12\">No detail found</td></tr>";
			            }
	         		jsonObject.put("data", Comp_List);
	         		}
	        	
	        }
        jsonObject.put("status", 200);
		jsonResponse = jsonObject.toString();
        response.setContentType("application/json");
		response.getWriter().write(jsonResponse);
		logger.info("Leaving the processRequest() method");
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(EmpGrievanceCaseView.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(EmpGrievanceCaseView.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}
}