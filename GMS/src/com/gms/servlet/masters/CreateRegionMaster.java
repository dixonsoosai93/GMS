package com.gms.servlet.masters;

import java.io.IOException;
import java.text.ParseException;
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

import com.gms.dao.masters.RegionMasterDAO;
import com.gms.model.masters.DtRegionModel;
import com.gms.model.masters.HdRegionModel;


@WebServlet("/CreateRegionMaster")
public class CreateRegionMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CreateRegionMaster.class.getName());
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		String jsonResponse = null;
        JSONObject jsonObject = new JSONObject();
        String data = request.getParameter("data");
		String REGION_CODE=request.getParameter("REGION_CODE");
		String REGION_NAME=request.getParameter("REGION_NAME");
		String REGION_DESC=request.getParameter("REGION_DESC");
		String EMPLOYEE_ID=request.getParameter("EMPLOYEE_NAME");
		String HD_IS_ACTIVE=request.getParameter("HD_IS_ACTIVE");
		
        HttpSession session =  request.getSession();
        HdRegionModel HdRegion= new HdRegionModel();
        HdRegion.setREGION_CODE(REGION_CODE);
        HdRegion.setREGION_NAME(REGION_NAME);
        HdRegion.setREGION_DESC(REGION_DESC);
        HdRegion.setEMPLOYEE_ID(EMPLOYEE_ID);
        HdRegion.setIS_ACTIVE(HD_IS_ACTIVE);
        
        ArrayList<DtRegionModel> list=DtRegionModel.getAllArrayList(data);
        try {
            Boolean success = RegionMasterDAO.insertHdRegion(HdRegion,list);
            if(success) {
                session.setAttribute("success-message", "Data submitted successfully");
            }else {
                session.setAttribute("authError", "Error in insert Employee Grievance ");
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
        	Logger.getLogger(CreateRegionMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        jsonObject.put("status",200);
		jsonResponse = jsonObject.toString();
        response.setContentType("application/json");
    	response.getWriter().write(jsonResponse);

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
