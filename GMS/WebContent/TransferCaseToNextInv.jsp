<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.gms.model.masters.ManpowerModel"%>
	<% ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
 	if (Manpower == null) {
        Manpower = new ManpowerModel();
        response.sendRedirect("login.jsp");
    }%>
    <% String GRVDETID = request.getParameter("GRVDETID") != null? request.getParameter("GRVDETID"):""; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TATA AIA GMS</title>
<jsp:include page="head.jsp"></jsp:include> 
</head>
<body class="slim__theme">
<div class="vz_main_sec">
		<jsp:include page="sidebar.jsp"></jsp:include>
		<jsp:include page="header.jsp"></jsp:include>
		<div class="vz_main_container">
			<div class="vz_main_content">
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-body">
									<div class = "heading__prdu mb-1">
	                           		<h4 class="card_title text-center mb-0">TRANSFER CASE TO NEXT REDRESSAL AUTHORITY</h4>
                                     </div>
                                <jsp:include page="GrievanceDetails.jsp"></jsp:include>
                                <jsp:include page="GridCaseTransferCase.jsp"></jsp:include>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
		<jsp:include page="footerList.jsp"></jsp:include>
	</div>
<div class="col-lg-6 stretched_card" style="display:none">
 <button type="button" class="btn btn-success mt-2 sweet_success_btn">Success Message</button>
</div> 
	<script>
	 $(function() {
		 $('body').addClass('slim__theme');
		 });
	</script>
<script>
	$( "#search" ).click(function() {
      var GRVDETID =$("#GRVDETID").val();
      if(GRVDETID==""){
    	  alert("Please enter GRVDETID");
    	  return false;
      }
      $.ajax({
  	    type:'post',
  	    url : 'TransferCaseGrievanceDesc',
  	    data : {GRVDETID:GRVDETID},
  	    dataType : 'JSON',
  	    success : function(result)
  	    {
  	    	if(result.status == 200){
  	    		$("#grid_case").html(result.data);
  	    		$("#gridCase").DataTable();
  	    		$("#GRVID").val(result.GRVID);
  	    		$("#CASEID").val(result.CASEID);
  	    		$("#CASENO").val(result.CASENUMBER);
  	    		$("#MAIN_CATEGORY_CODE").val(result.MAIN_CATEGORY_CODE);
  	    		$("#MAIN_CATEGORY_NAME").val(result.MAIN_CATEGORY_NAME);
  	    		$("#SUB_CATEGORY_CODE").val(result.SUB_CATEGORY_CODE);
  	    		$("#SUB_CATEGORY_NAME").val(result.SUB_CATEGORY_NAME);
  	    		$("#NAME").val(result.NAME);
  	    		$("#COMPLIANT_EMPLOYEE_ID").val(result.COMPLIANT_EMPLOYEE_ID);
  	    		$("#GROUP_COMPLIANT").val(result.GROUP_COMPLIANT);
  	    		$("#COMPLAINT_DESC").val(result.COMPLAINT_DESC);
  	    		$("#RESPONDENT_EMPLOYEE_ID").val(result.RESPONDENT_EMPLOYEE_ID);
  	    		$("#RESPONDENT_EMPLOYEE_NAME").val(result.RESPONDENT_EMPLOYEE_NAME);
  	    	} else {
  	    		$("#grid_case").html("");
  	    	}
  	    }
  	}); 	
	});
</script>
<script type="text/javascript">
$(document).ready(function() {
    var GRVDETID = <%=GRVDETID%>
    if(GRVDETID=="" || GRVDETID== null){
  	  //alert("Please enter GRVDETID");
  	  return false;
    }
    $.ajax({
	    type:'post',
	    url : 'TransferCaseGrievanceDesc',
	    data : {GRVDETID:GRVDETID},
	    dataType : 'JSON',
	    success : function(result)
	    {
	    	if(result.status == 200){
	    		$("#grid_case").html(result.data);
	    		$("#gridCase").DataTable();
	    		$("#GRVID").val(result.GRVID);
	    		$("#CASEID").val(result.CASEID);
	    		$("#CASENO").val(result.CASENUMBER);
	    		$("#MAIN_CATEGORY_CODE").val(result.MAIN_CATEGORY_CODE);
	    		$("#MAIN_CATEGORY_NAME").val(result.MAIN_CATEGORY_NAME);
	    		$("#SUB_CATEGORY_CODE").val(result.SUB_CATEGORY_CODE);
	    		$("#SUB_CATEGORY_NAME").val(result.SUB_CATEGORY_NAME);
	    		$("#NAME").val(result.NAME);
	    		$("#COMPLIANT_EMPLOYEE_ID").val(result.COMPLIANT_EMPLOYEE_ID);
	    		$("#GROUP_COMPLIANT").val(result.GROUP_COMPLIANT);
	    		$("#COMPLAINT_DESC").val(result.COMPLAINT_DESC);
	    		$("#RESPONDENT_EMPLOYEE_ID").val(result.RESPONDENT_EMPLOYEE_ID);
	    		$("#RESPONDENT_EMPLOYEE_NAME").val(result.RESPONDENT_EMPLOYEE_NAME);
	    	} else {
	    		$("#grid_case").html("");
	    	}
	    }
	}); 	
	});
</script>	
<script>
$(document).ready(function(){
	$("#submit").prop("disabled",true);
});
</script>
<script>
	$("body").on("click", "#nextInv", function () {
		var HIREORDER = $(this).data('key1');
		var GRVDETID = $("#GRVDETID").val();
		var Remark= $("#Remark").val();
		if(Remark  == null || Remark == ""){
			alert("Please enter remark to submit");
			$("#Remark-error").css('display','block');
			return false;
		}
		else{
			console.log("HIREORDER :"+HIREORDER+"GRVDETID :"+GRVDETID);
			$("#submit").prop("disabled",false);
			$( "#submit" ).click(function() {
			    $.ajax({
			  	    type:'post',
			  	    url : 'NextInvestigatorAssignment',
			  	    data : {GRVDETID:GRVDETID,HIREORDER:HIREORDER,Remark:Remark},
			  	    dataType : 'JSON',
			  	    success : function(result){
			  	    	if(result.status == 200){
			  	    		window.location = "TransferCaseToNextInv.jsp?GRVDETID="+GRVDETID;
			  	    	} else {
			  	    		window.location = "TransferCaseToNextInv.jsp";
			  	    	}
			  	    }
			  	});
	 		});
		}
	});
</script>
<script>
<% 
String success_message = (String)session.getAttribute("success-message"); 
if(success_message != null && !success_message.isEmpty()) { 
session.removeAttribute("success-message");
%>
$( document ).ready(function() {
$('.sweet_success_btn').trigger('click');
$('#swal2-content').text("<%= success_message %>");
});
<% 
} 
%>
</script>	
</body>
</html>