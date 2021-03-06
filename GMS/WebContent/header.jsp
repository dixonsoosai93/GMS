<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.gms.model.masters.ManpowerModel"%>
  <%ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
     if (Manpower == null) {
        Manpower = new ManpowerModel();
        response.sendRedirect("login.jsp");
    }
    %>
	<header class="vz_main_header flex-grow-1 top_nav">
        <div class="container-fluid d-flex flex-row h-100 align-items-center">
            <div class="text-center rt_nav_wrapper d-flex align-items-center">
                <a class="nav_logo rt_logo" href="dashboard.jsp"><img src="images/tata-aia-logo.png" alt="logo"/></a>
                <a class="nav_logo nav_logo_mob" href="dashboard.jsp"><img src="images/tata-aia-logo.png" alt="logo"/></a>
            </div>
            <div class="nav_wrapper_main d-flex align-items-center justify-content-between flex-grow-1">
                <ul class="navbar-nav navbar-nav-right mr-0 ml-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link count-indicator dropdown-toggle" id="notificationDropdown" href="#"
                           data-toggle="dropdown">
                            <i class="feather ft-bell"></i>
                            <span class="count"></span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right navbar-dropdown rt-notification-list"
                             aria-labelledby="notificationDropdown">
                             <div class="dropdown-item">
                                <p class="mb-0 font-weight-normal float-left">You have 1 new notification</p>
                                <a href="#" class="view_btn">view</a>
                            </div>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item rt-notification-item">
                                <div class="rt-notification-item-content">
                                    <h6 class="rt-notification-subject text-info font-weight-normal mb-1">HELLO,<span><%=Manpower.getNAME()%></span></h6>
                                    <p class="font-weight-light small-text mb-0">
                                        30 sec Ago
                                    </p>
                                </div>
                            </a>
                        </div>
                    </li>
                    <li class="nav-item nav-profile dropdown">
                        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" id="profileDropdown">
                            <span class="profile_sec">

                                <span class="profile_name">
                                    <span class="hi_name">Hello,</span>
                                    <span><%=Manpower.getNAME()%></span>
                                     <i class="feather ft-chevron-down"></i>
                                </span>
                                <img src="images/user.jpg" alt="profile"/>
                            </span>
                        </a>
<!--                         <div class="dropdown-menu dropdown-menu-right navbar-dropdown pt-2" -->
<!--                              aria-labelledby="profileDropdown"> -->
<!--                             <a class="dropdown-item" href="SendEmail" > -->
<!--                                 <i class="fa fa-envelope-o text-dark mr-3" ></i> Send Email -->
<!--                             </a> -->
<!--                         </div> -->
                    </li>
                    <li class="nav-item d_none_sm">
                        <a class="nav-link logout_link" href="AdminLogout">
                            Logout <i class="feather ft-power"></i>
                        </a>
                    </li>
                </ul>
                <span class="d-none">
                    <a class="vz_mobile_menu_icon ml-3" id="vz_mobileCollapseIconMobile" href="javascript:"><span></span></a>
                </span>
            </div>
        </div>
    </header>
