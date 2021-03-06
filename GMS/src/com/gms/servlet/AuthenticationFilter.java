package com.gms.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(false);
		
        String PATH = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        
        if (PATH.endsWith(".js") || PATH.endsWith(".css") || PATH.endsWith(".woff")
        		|| PATH.endsWith(".jpg") || PATH.endsWith(".png") ||PATH.endsWith(".map") 
        		|| PATH.endsWith(".gif") || PATH.endsWith(".svg") || PATH.endsWith(".ttf") 
        		|| PATH.endsWith(".eot") || PATH.endsWith(".woff2")|| PATH.endsWith(".MF")) {
            chain.doFilter(request, response);
            return;
        }
		
        boolean isLoggedIn = (session != null && session.getAttribute("manpower") != null);
        
        String loginURI = httpRequest.getContextPath() + "/Adminlogin";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");
        
        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeLogin.jsp");
            dispatcher.forward(request, response);
         
        }else if(((PATH.equals("/AdminLogin")) || (PATH.equals("/AdminLogout")) || (PATH.equals("/InvLogin")) || (PATH.equals("/EmployeeLogin")) || (PATH.equals("/")) || (PATH.equals("/login.jsp")) || (PATH.equals("/EmployeeLogin.jsp")))) {
        	httpResponse.setHeader("Cache-Control", "no-cache ,no-store");
    	    httpResponse.setHeader("Pragma", "no-cache");
    	    httpResponse.setHeader("Expires", "0");
            chain.doFilter(request, response);
 
        }else if(isLoggedIn){
        	httpResponse.setHeader("Cache-Control", "no-cache ,no-store");
    	    httpResponse.setHeader("Pragma", "no-cache");
    	    httpResponse.setHeader("Expires", "0");
        	chain.doFilter(request, response);
        }
        else {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);

        }
 
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
