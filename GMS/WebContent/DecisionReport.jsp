<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@page import="com.gms.dao.masters.HrcMasterDAO"%>
<%@page import="com.gms.dao.investigator.DailyProofUploadDAO"%>
<%@ page import="com.gms.model.investigator.DecisionReport"%>
  <%@page import="com.gms.model.masters.ManpowerModel"%>
<% ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
 if (Manpower == null) {
        Manpower = new ManpowerModel();
        response.sendRedirect("login.jsp");
    }%>
    <% String Report_Type = request.getParameter("Report_Type") != null?request.getParameter("Report_Type"):"";%> 
<head>
	<title>TATA AIA GMS</title>
	<jsp:include page="head.jsp"></jsp:include>
</head>
<body class="slim__theme">
<div class="vz_main_sec">
    <jsp:include page="InvSidebar.jsp"></jsp:include>
    <jsp:include page="header.jsp"></jsp:include>
    <!-- Text-->
    <div class="vz_main_container">
        <div class="vz_main_content">
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card_title text-right">Decision Report</h4>
                            <%
	                            int Id = Integer.parseInt(request.getParameter("CASEID"));
                            DecisionReport decisionReport =  DailyProofUploadDAO.getDecisionReport(Id);
	                         	 %> 
                            <form id="DecisionReport" action="CreateDecisionReport" method="post">
	                             <div class="form-group">
								   <label class="col-form-label" for="GRVDETID">Employee Grievance Ref No</label>
									<input type="text" name="GRVDETID" class="form-control" id="GRVDETID" value="<%=request.getParameter("GRVDETID") %>" disabled >
			                      </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="CASEID">Case No</label>
	                                <input type="text" name="CASEID" class="form-control" id="CASEID" value="<%=request.getParameter("CASEID")%>" readonly>
	                            </div>			                      
	                            
	                            <div class="form-group">
	                                <label class="col-form-label" for="EMPLOYEE_ID">Employee ID</label>
	                                <input type="text" name="EMPLOYEE_ID" class="form-control" id="EMPLOYEE_ID" value="<%=Manpower.getEMPLOYEE_ID() %>" disabled>
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="EMPLOYEE_NAME">Employee Name</label>
	                                <input type="text" name="EMPLOYEE_NAME" class="form-control" id="EMPLOYEE_NAME" value="<%=Manpower.getNAME()%>" disabled>
                               </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for=DECISION_REPORT_DATE>Decision Dairy Date</label>
	                                 <input type="text" name="DECISION_REPORT_DATE" class="form-control datepicker" id="DECISION_REPORT_DATE" readonly data-date-format="dd-mm-yyyy">
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" >Decision Report Details</label>
	                                <textarea class="form-control" name="DECISION_REPORT_CONTENT" id="DECISION_REPORT_CONTENT" placeholder="Enter Decision Report Content"><%if(decisionReport.getDECISION_REPORT_CONTENT()!=null){ out.println(decisionReport.getDECISION_REPORT_CONTENT());} System.out.println(decisionReport.getDECISION_REPORT_CONTENT()); %></textarea>
	                            	<span style="color: indianred; float: right;"> *</span>
	                            </div>                           
	                            <div class="form-group row">
	                                <div class="col-sm-12 text-right">
	                                    <button type="submit" class="btn btn-primary">Submit</button>
	                                    <button type="button" id="back" class="btn btn-light cancel">Cancel</button>
	                                </div>
	                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>    
    <div class="col-lg-6 stretched_card" style="display:none">
     <button type="button" class="btn btn-success mt-2 sweet_success_btn">Success Message</button>
</div>
    <jsp:include page="footer.jsp"></jsp:include>
<script>
	$(function() {
		$('body').addClass('slim__theme');
	});
    $(document).ready(function() {
      $(".js-select2").select2();
      $(".js-select2-multi").select2();
	});
</script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#back').click(function(){
		 	let reportType = "<%=Report_Type%>";
		 	console.log(reportType);
			location.href ="DailyDairyUpdationList.jsp?Report_Type="+reportType;			
	 	});
	});
</script>
<script>
	/*var today = new Date();
	var dd = String(today.getDate()).padStart(2, '0');
	var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
	var yyyy = today.getFullYear();
	today = dd + '-' + mm + '-' + yyyy;*/
		//$('#DECISION_REPORT_DATE').val(today);
		$('#DECISION_REPORT_DATE').datepicker('setEndDate', 'now');
		$('#DECISION_REPORT_DATE').datepicker('setDate', 'now');
		$("#DECISION_REPORT_DATE").datepicker('setStartDate', 'now');
</script>
</body>
</html>