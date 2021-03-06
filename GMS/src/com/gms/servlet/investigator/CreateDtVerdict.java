package com.gms.servlet.investigator;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gms.dao.investigator.DailyProofUploadDAO;
import com.gms.model.investigator.DtVerdict;


@WebServlet("/CreateDtVerdict")
public class CreateDtVerdict extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CreateDtVerdict.class.getName());
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Report_Type  = request.getParameter("Report_Type");
		
		String VERDICTID=request.getParameter("VERDICTID");
		int  CASEID = Integer.parseInt(request.getParameter("CASEID"));
		int  GRVDETID = Integer.parseInt(request.getParameter("GRVDETID"));
		String VERDICT_REPORT_DATE = request.getParameter("VERDICT_REPORT_DATE");
		String VERDICT_REPORT_CONTENT = request.getParameter("VERDICT_REPORT_CONTENT");
		String IS_ACTIVE = request.getParameter("IS_ACTIVE");
		
		HashMap<String,String> errors = new HashMap<String, String>();
        HttpSession session =  request.getSession();
        
        DtVerdict DtVerdict= new DtVerdict();
        DtVerdict.setCASEID(CASEID);
        DtVerdict.setGRVDETID(GRVDETID);
        DtVerdict.setVERDICT_REPORT_DATE(VERDICT_REPORT_DATE);
        DtVerdict.setVERDICT_REPORT_CONTENT(VERDICT_REPORT_CONTENT);
        DtVerdict.setIS_ACTIVE(IS_ACTIVE);
        int verdictId=Integer.parseInt(VERDICTID);
        try {
        	if(verdictId!=0)
        	{
        		DtVerdict.setVERDICTID(verdictId);
        		boolean success = DailyProofUploadDAO.updateFinalVerdict(DtVerdict);
        		String url;
                if(success) {
                	url = "DailyDairyUpdationList.jsp?Report_Type="+Report_Type;
                    session.setAttribute("success-message", "Data Updated successfully");
                }else {
                    session.setAttribute("authError", "Error in insert final verdict");
                    url = "DailyDairyUpdationList.jsp?Report_Type="+Report_Type;
                }
                response.sendRedirect(url);
        	}
        	else {
            boolean success = DailyProofUploadDAO.insertDtVerdict(DtVerdict);
            String url;
            if(success) {
                url = "DailyDairyUpdationList.jsp";
                session.setAttribute("success-message", "Data submitted successfully");
            }else {
                session.setAttribute("authError", "Error in insert final verdict");
                url = "DailyDairyUpdationList.jsp";
            }
            response.sendRedirect(url);
        } }catch (Exception ex) {
        	ex.printStackTrace();
        	Logger.getLogger(CreateDtVerdict.class.getName()).log(Level.SEVERE, null, ex);
        }

	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		
	}

}