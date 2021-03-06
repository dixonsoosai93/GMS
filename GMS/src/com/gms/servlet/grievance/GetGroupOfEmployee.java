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
import com.gms.model.masters.ManpowerModel;

@WebServlet("/GetGroupOfEmployee")
public class GetGroupOfEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(GetGroupOfEmployee.class.getName());
       

    public GetGroupOfEmployee() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Inside the doPost() method");
		String jsonResponse = null;
        JSONObject jsonObject = new JSONObject();
        String groupEmp = "";
        try {
			int GRVID = Integer.parseInt(request.getParameter("GRVID"));
			List<ManpowerModel> GroupEmp = EmployeeGrievanceDAO.getGroupEmployee(GRVID);
			if(GroupEmp != null && GroupEmp.size() > 0) { 
				int i=1;
				for(ManpowerModel item: GroupEmp) {
					groupEmp += "<tr>";
					groupEmp += "<td>"+i+"</td>";
					groupEmp += "<td>"+item.getEMPLOYEE_ID()+"</td>";
					groupEmp += "<td>"+item.getNAME()+"</td>";
					groupEmp += "<td>"+item.getDESIGNATION()+"</td>";
					groupEmp += "<td>"+item.getDEPARTMENT()+"</td>";
					groupEmp += "</tr>";
					i++;
				}
			}
        }  catch(Exception ex) {
        	ex.printStackTrace();
        	logger.info("Exception Inside the doPost() method Exception "+ex.getMessage());
        	Logger.getLogger(GetGroupOfEmployee.class.getName()).log(Level.SEVERE, null, ex);
        	groupEmp = "<tr><td colspan=\"12\">No detail found</td></tr>";
        } 
        if(groupEmp.equals("")) {
        	groupEmp = "<tr><td colspan=\"12\">No detail found</td></tr>";
        }
        jsonObject.put("status", 200);
		jsonObject.put("data", groupEmp);
		jsonResponse = jsonObject.toString();
        response.setContentType("application/json");
    	response.getWriter().write(jsonResponse);
    	logger.info("Leaving the doPost() method");
	}

}