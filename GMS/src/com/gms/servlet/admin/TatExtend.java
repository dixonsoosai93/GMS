package com.gms.servlet.admin;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.gms.dao.admin.TatExtensionDAO;
import com.gms.model.admin.GridCase;


@WebServlet("/TatExtend")
public class TatExtend extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TatExtend.class.getName());
       
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		 logger.info("Inside the processReuest() method");
			String jsonResponse = null;
	        JSONObject jsonObject = new JSONObject();
	        int BUFFERDAYS = Integer.parseInt(request.getParameter("BUFFERDAYS"));
	        int CASEID=Integer.parseInt(request.getParameter("CASEID"));
	        int INVESTIGATOR_EMPLOYEE_ID=Integer.parseInt(request.getParameter("INVESTIGATOR_EMPLOYEE_ID"));
			String TAT_EXTEND_REASON = request.getParameter("Remark");		
	        HttpSession session =  request.getSession();
	        GridCase gridCase= new GridCase();
	        gridCase.setCASEID(CASEID);
	        gridCase.setBUFFERDAYS(BUFFERDAYS);
	        gridCase.setINVESTIGATOR_EMPLOYEE_ID(INVESTIGATOR_EMPLOYEE_ID);
	        gridCase.setTATEXT_REASON(TAT_EXTEND_REASON);
	        try {
	        	GridCase success = TatExtensionDAO.tatExtend(gridCase);
	            System.out.println("success :" +success);
	            if(success.getBUFFERDAYS() >0 ) {
	            	session.setAttribute("BUFFERDAYS", success.getBUFFERDAYS());
	            	session.setAttribute("IsTat", success.getIsTatExtn());
	                session.setAttribute("success-message", "Tat extended successfully");
	            }else {
	                session.setAttribute("authError", "Error in Tat extention ");
	            }
	        } catch (Exception ex) {
	        	ex.printStackTrace();
	        	logger.info("Exception Inside the processReuest() method Exception "+ex.getMessage());
	        	Logger.getLogger(TatExtend.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        jsonObject.put("status",200);
			jsonResponse = jsonObject.toString();
	        response.setContentType("application/json");
	    	response.getWriter().write(jsonResponse);
	    	logger.info("Leaving the processReuest() method");
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
