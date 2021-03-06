package com.gms.servlet.admin;

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

import com.gms.dao.admin.ReopenCaseDAO;
import com.gms.model.admin.GridCase;


@WebServlet("/ReopenCaseStatus")
public class ReopenCaseStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(ReopenCaseStatus.class.getName());
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Inside the processRequest() method ");
		int CASEID =Integer.parseInt(request.getParameter("CASEID"));
		int GRVDETID=Integer.parseInt(request.getParameter("GRVDETID"));
		String REOPEN_DATE=request.getParameter("REOPEN_DATE");
		int REOPEN_HIERORDER=Integer.parseInt(request.getParameter("REOPEN_HIERORDER"));
		String REOPEN_REASON=request.getParameter("REOPEN_REASON");
		
		HashMap<String,String> errors = new HashMap<String, String>();
        HttpSession session =  request.getSession();
        
        GridCase gridCase= new GridCase();
        gridCase.setCASEID(CASEID);
        gridCase.setGRVDETID(GRVDETID);
        gridCase.setHIERORDER(REOPEN_HIERORDER-1);
        gridCase.setREOPEN_DATE(REOPEN_DATE);
        gridCase.setREOPEN_HIERORDER(REOPEN_HIERORDER);
        gridCase.setREOPEN_REASON(REOPEN_REASON);
        String url = "ReopenClosed.jsp?GRVDETID="+GRVDETID;
        try {
            boolean success = ReopenCaseDAO.reopenCaseStatus(gridCase);
            if(success) {
                session.setAttribute("success-message", "Case Reopened  successfully");
                session.setAttribute("GRVDETID",GRVDETID);
                url = "ReopenClosed.jsp?GRVDETID="+GRVDETID;
            } else {
                url = "ReopenClosed.jsp";
                session.setAttribute("authError", "Error in case reopen ");
            }
            response.sendRedirect(url);
        } catch (Exception ex) {
        	ex.printStackTrace();
    		logger.info("Exception inside the processRequest() method Exception : "+ ex.getMessage());
        	Logger.getLogger(ReopenCaseStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
		logger.info("Leaving the processRequest() method ");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);

	}


}