package com.gms.servlet.grievance;

import java.awt.BufferCapabilities.FlipContents;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonSerializer;

@WebServlet("/GetEmployeeList")
public class GetEmployeeList extends HttpServlet {
	static Logger logger = Logger.getLogger(GetEmployeeList.class.getName());
	private static final long serialVersionUID = 1L;
   
    public GetEmployeeList() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	
    	String jsonResponse = null;
        JSONObject jsonObject = new JSONObject();
        JSONObject filtereData = new JSONObject(request.getParameter("data"));
        System.out.println(" filtereData "+filtereData);
        String id = filtereData.getString("NTID") != null?filtereData.getString("NTID"): "";
        String name = filtereData.getString("Name") != null?filtereData.getString("Name"):"";
        String branch = filtereData.getString("tbranchCode") != null?filtereData.getString("tbranchCode"):"";
        String designation = filtereData.getString("tdesignation") != null?filtereData.getString("tdesignation"): "";
        String department = filtereData.getString("tDepartment") != null?filtereData.getString("tDepartment"):"";
        String jobFunction = filtereData.getString("tJobFun") != null?filtereData.getString("tJobFun"):"";
        JSONArray resultArray = null;
		ArrayList<JSONObject> arrayList = new ArrayList<JSONObject>();
			resultArray = filtereData.getJSONArray("groupListArr");
			for(int i = 0; i < resultArray.length(); i++) {
				arrayList.add(resultArray.getJSONObject(i));
			}
		System.out.println(" List :"+arrayList);
        System.out.println(" id "+id+" name "+name+" branch "/*+branch*/+" designation "+designation+" department "+department+" jobFunction "+jobFunction+" arrayList "+arrayList);
        //String pageName = objcet.getJSONObject("pageInfo").getString("pageName");
        /*
		  JSONArray arr = objcet.getJSONArray("posts"); // notice that `"posts": [...]`
		  for (int i = 0; i < arr.length(); i++) { 
		  String post_id =
		  arr.getJSONObject(i).getString("post_id"); ...... 
		  }
		 /
        /*
        	{ 	"tbranchCode":null, 
        		"tdesignation":null,
        	  	"tJobFun":"DB",
        	  	"tDepartment":null,
        	  	"NTID":"",
        	  	"Name":"",
        	  	"groupListArr":[
        	                {
        	                  "EMPLOYEE_ID":"127"
        	                },
        	                {
        	                  "EMPLOYEE_ID":"128"
        	                }
        	              ]
        	}
        */

        
        //JSONObject jsonData =JsonParser.parseString​(data).getAsJsonObject();// (JSONObject) JSONValue.parse(json);
		/*
		 * JSONObject jsonObj = (JSONObject) JsonParser();
		 * String data = request.getParameter("data"); String grouplist =
		 * request.getParameter("grouplist"); String GRVDATE =
		 * request.getParameter("GRVDATE"); String GROUP_COMPLAINT =
		 * request.getParameter("GROUP_COMPLAINT").equalsIgnoreCase("true")?"Y":"N"; int
		 * COMPLIANT_EMPLOYEE_ID =
		 * Integer.parseInt(request.getParameter("COMPLIANT_EMPLOYEE_ID"));
		 * 
		 * HttpSession session = request.getSession(); HdGrievanceModel
		 * HdGrievanceMasterModel= new HdGrievanceModel();
		 * HdGrievanceMasterModel.setGRVDATE(GRVDATE);
		 * HdGrievanceMasterModel.setGROUP_COMPLAINT(GROUP_COMPLAINT);
		 * HdGrievanceMasterModel.setCOMPLIANT_EMPLOYEE_ID(COMPLIANT_EMPLOYEE_ID);
		 * 
		 * ArrayList<DtGrievanceModel> list = DtGrievanceModel.getAllArrayList(data);
		 * ArrayList<DtCaseEmpModel> Dtlist = DtCaseEmpModel.getAllArrayList(grouplist);
		 * 
		 * try { Boolean success =
		 * EmployeeGrievanceDAO.insertHdGrievance(HdGrievanceMasterModel, list, Dtlist);
		 * if(success) { session.setAttribute("success-message",
		 * "Data submitted successfully"); jsonObject.put("status",200); }else {
		 * session.setAttribute("authError", "Error in insert Employee Grievance "); } }
		 * catch (Exception ex) { ex.printStackTrace();
		 * logger.info("Exception Inside the processReuest() method Exception "+ex.
		 * getMessage()); jsonObject.put("status",201);
		 * Logger.getLogger(CreateEmployeeGrievance.class.getName()).log(Level.SEVERE,
		 * null, ex); }
		 */ 
		  jsonResponse = jsonObject.toString();
		  response.setContentType("application/json");
		  response.getWriter().write(jsonResponse);
		  logger.info("Leaving the processReuest() method");
		 /* 
		 * String girdManpowerList = ""; try { String tbranchCode =
		 * request.getParameter("tbranchCode"); String tdesignation =
		 * request.getParameter("tdesignation"); String tJobFun =
		 * request.getParameter("tJobFun"); String tDepartment =
		 * request.getParameter("tDepartment"); String NTID =
		 * request.getParameter("NTID"); String Name = request.getParameter("Name");
		 * String groupListToExclude = request.getParameter("grouplistArray");
		 * ArrayList<DtCaseEmpModel> list =
		 * DtCaseEmpModel.getAllArrayList(groupListToExclude);
		 * System.out.println("GetEmployeeSearchList list  : "+list );
		 * List<ManpowerModel> mPow =
		 * HrcMasterDAO.getManpowerListEmployeeGriv(tbranchCode, tdesignation, tJobFun,
		 * tDepartment, NTID, Name, list); if(mPow != null && mPow.size() > 0){ int i
		 * =1; for(ManpowerModel item : mPow) { girdManpowerList+="<tr class='main'>";
		 * girdManpowerList+="<td>"+"<label class=\"custom_check_label\">" +
		 * "<input type=\"checkbox\" class=\"custom_check_input\" id=\"empCheck\">"
		 * +"</td>"; girdManpowerList+="<td>"+i+"</td>";
		 * girdManpowerList+="<td>"+item.getEMPLOYEE_ID()+"</td>";
		 * girdManpowerList+="<td>"+item.getTITLE()+"</td>";
		 * girdManpowerList+="<td>"+item.getNAME()+"</td>";
		 * girdManpowerList+="<td>"+item.getDOB()+"</td>";
		 * girdManpowerList+="<td>"+item.getGENDER()+"</td>";
		 * girdManpowerList+="<td>"+item.getDESIGNATION()+"</td>";
		 * girdManpowerList+="<td>"+item.getJOB_FUNCTION()+"</td>";
		 * girdManpowerList+="<td>"+item.getDEPARTMENT()+"</td>";
		 * girdManpowerList+="<td>"+item.getBRANCH_NAME()+"</td>";
		 * girdManpowerList+="<td>"+item.getSUPERVISIOR_ID()+"</td>";
		 * girdManpowerList+="<td>"+(item.getIS_ACTIVE().equalsIgnoreCase("Y")?"Yes":
		 * "No")+"</td>"; girdManpowerList+="<td>"+item.getDATE_CREATED()+"</td>";
		 * girdManpowerList+="</tr>"; i++; } } } catch (Exception ex) {
		 * ex.printStackTrace();
		 * Logger.getLogger(GetEmpSearchList.class.getName()).log(Level.SEVERE, null,
		 * ex); } jsonObject.put("status", 200); jsonObject.put("data",
		 * girdManpowerList); jsonResponse = jsonObject.toString();
		 * response.setContentType("application/json");
		 * response.getWriter().write(jsonResponse);
		 */
		}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
