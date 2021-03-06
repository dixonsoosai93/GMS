package com.gms.servlet.investigator;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gms.dao.investigator.DailyDairyDAO;

/**
 * Servlet implementation class DeleteAttachment
 */
@WebServlet("/DeleteAttachment")
public class DeleteAttachment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAttachment() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException ,IOException{
		
    	int attachId = Integer.parseInt(request.getParameter("attachId"));
    	int dairyId = Integer.parseInt(request.getParameter("dairyId"));
    	System.out.println(attachId);
    	HttpSession session =  request.getSession();
		try {
            boolean success = DailyDairyDAO.deleteDownloadCaseAttcah(attachId);
            String url;
            if(success) {
                url = "DownloadCaseAttach.jsp?DAIRYID="+dairyId;
                session.setAttribute("success-message", "Data deleted successfully");
            }else {
                session.setAttribute("authError", "Error in Delete  Deleete Attachment code");
                url = "DownloadCaseAttach.jsp?DAIRYID="+dairyId;;
            }
            response.sendRedirect(url);
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
