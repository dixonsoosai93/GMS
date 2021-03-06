package com.gms.servlet.masters;

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

import com.gms.dao.masters.HrcMasterDAO;
import com.gms.model.masters.ManpowerModel;

@WebServlet("/GetEmpSelectList")
public class GetEmpSelectList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(GetEmpSelectList.class.getName());
    
    public GetEmpSelectList() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	logger.info("Inside the processRequest() method");
    	String jsonResponse = null;
        JSONObject jsonObject = new JSONObject();
        String girdManpowerList = "";
        try {
        	String tbranchCode = request.getParameter("tbranchCode");
	    	String tdesignation = request.getParameter("tdesignation");
	    	String tJobFun = request.getParameter("tJobFun");
	    	String tDepartment = request.getParameter("tDepartment");
	    	String NTID = request.getParameter("NTID");
	    	String Name = request.getParameter("Name");
	    	List<ManpowerModel> mPow = HrcMasterDAO.getManpowerListScr(tbranchCode, tdesignation, tJobFun, tDepartment, NTID, Name);
	    	
	    	if(mPow != null && mPow.size() >0) {
	    		int i =1;
	    		for(ManpowerModel item : mPow) {
	    			girdManpowerList+="<tr class='main'>";
	    			girdManpowerList+="<td>"+"<input type=\"radio\" name=\"customRadio\" data-key1='"+item.getEMPLOYEE_ID()+"' id=\"emp\">"+"</td>";
	    			girdManpowerList+="<td>"+i+"</td>";
	    			girdManpowerList+="<td>"+item.getEMPLOYEE_ID()+"</td>";
	    			girdManpowerList+="<td>"+item.getTITLE()+"</td>";
	    			girdManpowerList+="<td>"+item.getNAME()+"</td>";
	    			girdManpowerList+="<td>"+item.getDOB()+"</td>";
	    			girdManpowerList+="<td>"+item.getGENDER()+"</td>";
	    			girdManpowerList+="<td>"+item.getDESIGNATION()+"</td>";
	    			girdManpowerList+="<td>"+item.getJOB_FUNCTION()+"</td>";
	    			girdManpowerList+="<td>"+item.getDEPARTMENT()+"</td>";
	    			girdManpowerList+="<td>"+item.getBRANCH_NAME()+"</td>";
	    			girdManpowerList+="<td>"+item.getSUPERVISIOR_ID()+"</td>";
	    			girdManpowerList+="<td>"+(item.getIS_ACTIVE().equalsIgnoreCase("Y")?"Yes":"No")+"</td>";
	    			girdManpowerList+="<td>"+item.getDATE_CREATED()+"</td>";
	    			girdManpowerList+="</tr>";
	    			i++;
	    			}
	    		}
	    	} catch (Exception ex) {
	    		ex.printStackTrace();
	    		logger.info("Exception Inside the processRequest() method Exception "+ex.getMessage());
	    		Logger.getLogger(GetEmpSelectList.class.getName()).log(Level.SEVERE, null, ex);
	    	}
	        jsonObject.put("status", 200);
			jsonObject.put("data", girdManpowerList);
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
