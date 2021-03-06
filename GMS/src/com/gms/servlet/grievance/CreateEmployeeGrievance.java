package com.gms.servlet.grievance;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.gms.dao.grievance.EmployeeGrievanceDAO;
import com.gms.model.grievance.DtCaseEmpModel;
import com.gms.model.grievance.DtGrievanceModel;
import com.gms.model.grievance.HdGrievanceModel;

@WebServlet("/CreateEmployeeGrievance")
public class CreateEmployeeGrievance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(CreateEmployeeGrievance.class.getName());
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		logger.info("Inside the processReuest() method");
		String jsonResponse = null;
        JSONObject jsonObject = new JSONObject();
        
        String data = request.getParameter("data");
        String grouplist = request.getParameter("grouplist");
		String GRVDATE = request.getParameter("GRVDATE");
		String GROUP_COMPLAINT = request.getParameter("GROUP_COMPLAINT").equalsIgnoreCase("true")?"Y":"N";
		int COMPLIANT_EMPLOYEE_ID  = Integer.parseInt(request.getParameter("COMPLIANT_EMPLOYEE_ID"));
        
		HttpSession session =  request.getSession();
        HdGrievanceModel HdGrievanceMasterModel= new HdGrievanceModel();
        HdGrievanceMasterModel.setGRVDATE(GRVDATE);
        HdGrievanceMasterModel.setGROUP_COMPLAINT(GROUP_COMPLAINT);
        HdGrievanceMasterModel.setCOMPLIANT_EMPLOYEE_ID(COMPLIANT_EMPLOYEE_ID);
        
        ArrayList<DtGrievanceModel> list = DtGrievanceModel.getAllArrayList(data);
        System.out.println("Create Employee Grivenece "+data.toString());
        ArrayList<DtCaseEmpModel> Dtlist = DtCaseEmpModel.getAllArrayList(grouplist); 
	        try {
	        	Boolean success = EmployeeGrievanceDAO.insertHdGrievance(HdGrievanceMasterModel, list, Dtlist);
	        	if(success) {
				    session.setAttribute("success-message", "Data submitted successfully");
				    jsonObject.put("status",200);
				}else {
				    session.setAttribute("authError", "Error in insert Employee Grievance ");
				}
	        } catch (Exception ex) {
	        	ex.printStackTrace();
	        	logger.info("Exception Inside the processReuest() method Exception "+ex.getMessage());
	        	jsonObject.put("status",201);
	        	Logger.getLogger(CreateEmployeeGrievance.class.getName()).log(Level.SEVERE, null, ex);
	        }
		jsonResponse = jsonObject.toString();
        response.setContentType("application/json");
    	response.getWriter().write(jsonResponse);
    	logger.info("Leaving the processReuest() method");
	}
     
	public static java.util.Date convertStringToDate(String str_date) {
	    try {
	    	java.util.Date date=new SimpleDateFormat("dd/MM/yyyy").parse(str_date);
	    	java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());   
	    	return sqlStartDate;
	    } catch (ParseException e) {
	    	System.out.println("Exception :" + e);
	      return null;
	    }
	  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}


}
