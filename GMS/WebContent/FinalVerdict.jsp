<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.gms.model.masters.ManpowerModel"%>
<%@page import="com.gms.dao.masters.HrcMasterDAO"%>
<%@page import="com.gms.dao.investigator.DailyProofUploadDAO"%>
<%@ page import="com.gms.model.investigator.DtVerdict"%>
<% ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
 if (Manpower == null) {
        Manpower = new ManpowerModel();
        response.sendRedirect("login.jsp");
    }
    %>
    <%
    String report_Type = request.getParameter("Report_Type") != null?request.getParameter("Report_Type"):"";
    %>
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
                            <h4 class="card_title text-right">Final Verdict</h4>
                            <%
	                            int Id = Integer.parseInt(request.getParameter("CASEID"));
                            
                            DtVerdict DtVerdict =  DailyProofUploadDAO.getDtVerdict(Id);
	                         	 %> 
                            <form id="CreateDtVerdict" action="CreateDtVerdict" method="post">
                            	<input type="hidden" value="<%=request.getParameter("Report_Type")%>" name="Report_Type">
                                 <div class="form-group">
									<input type="hidden" name="VERDICTID" class="form-control" id="VERDICTID" value="<%=DtVerdict.getVERDICTID()%>" readonly >
			                      </div>
	                             <div class="form-group">
								   <label class="col-form-label" for="GRVDETID">Employee Grievance Ref No</label>
									<input type="text" name="GRVDETID" class="form-control" id="GRVDETID" value="<%=request.getParameter("GRVDETID") %>" readonly >
			                      </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="CASEID">Case No</label>
	                                <input type="text" name="CASEID" class="form-control" id="CASEID" value="<%=request.getParameter("CASEID")%>" readonly>
	                            </div>			                      
	                            
	                            <div class="form-group">
	                                <label class="col-form-label" for="EMPLOYEE_ID">Employee ID</label>
	                                <input type="text" name="EMPLOYEE_ID" class="form-control" id="EMPLOYEE_ID" value="<%=Manpower.getEMPLOYEE_ID() %>" readonly>
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="EMPLOYEE_NAME">Employee Name</label>
	                                <input type="text" name="EMPLOYEE_NAME" class="form-control" id="EMPLOYEE_NAME" value="<%=Manpower.getNAME()%>" disabled>
                               </div>
	                            <div class="form-group">
	                            <% Date date = new Date();  
	                            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
	                            String strDate= formatter.format(date); 
	                            %>
	                                <label class="col-form-label" for=VERDICT_REPORT_DATE>Final Verdict Date</label>
	                               <input type="text" name="VERDICT_REPORT_DATE" class="form-control" id="VERDICT_REPORT_DATE" value="<%if(DtVerdict.getVERDICTID()==0){out.println(strDate);}else{ out.println(DtVerdict.getVERDICT_REPORT_DATE());}%>" readonly>
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" >Final Verdict Details</label>
	                                <textarea class="form-control" name="VERDICT_REPORT_CONTENT" id="VERDICT_REPORT_CONTENT" ><%if(DtVerdict.getVERDICTID()!=0){ out.println(DtVerdict.getVERDICT_REPORT_CONTENT());} %></textarea>
	                            	<span style="color: indianred; float: right;"> *</span>
	                            </div>
	                            <input type="hidden" name="IS_ACTIVE" value="Y">
                                <!-- <div class="form-group">
                                    <label class="col-form-label" for="IS_ACTIVE">STATUS</label>
                                    <select class="custom-select" name="IS_ACTIVE">
                                        <option value="Y">Yes</option>
                                        <option value="N">No</option>
                                    </select>
                                </div>  -->   
	                            <div class="form-group row">
	                                <div class="col-sm-12 text-right">
	                                    <button type="submit" id="submit" class="btn btn-primary">Submit</button>
	                                    <button type="button" id="back" class="btn btn-light">Cancel</button>
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
	 	let reportType = "<%=report_Type%>";
	 	console.log(reportType);
		location.href ="DailyDairyUpdationList.jsp?Report_Type="+reportType;			
 	});
});
</script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#submit').click(function(){
		 	if(confirm("Do you want to resolve and close case")){
		 	}	else{
		 		return false;
		 	}		
	 	});
	});
</script>
</body>
</html>