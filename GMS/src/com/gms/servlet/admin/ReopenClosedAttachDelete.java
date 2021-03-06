package com.gms.servlet.admin;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gms.dao.admin.ReopenAttachmentDao;

@WebServlet("/ReopenClosedAttachDelete")
public class ReopenClosedAttachDelete extends HttpServlet {
	static Logger logger = Logger.getLogger(ReopenClosedAttachDelete.class.getName());
	private static final long serialVersionUID = 1L;
    
    public ReopenClosedAttachDelete() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
		logger.info("Inside the processRequest() method ");
    	int attachId = Integer.parseInt(request.getParameter("attachId"));
    	HttpSession session =  request.getSession();
		try {
            boolean success = ReopenAttachmentDao.deleteAttachment(attachId);
            String url;
            if(success) {
            	session.setAttribute("success-message", "Attachment deleted.");
                url = "ReopenClosed.jsp";
            }else {
                session.setAttribute("authError", "Error in Deleting Attachment");
                url = "ReopenClosed.jsp";
            }
            response.sendRedirect(url);
        } catch (Exception ex) {
    		logger.info("Exception inside the processRequest() method Exception : "+ ex.getMessage());
        	ex.printStackTrace();
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
