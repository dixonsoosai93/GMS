<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.gms.model.masters.RhrInvestigatorMasterModel" %>
<%@page import="com.gms.dao.masters.RhrInvestigatorDAO"%>
<%@ page import="com.gms.model.masters.ManpowerModel" %>
  <% ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
 if (Manpower == null) {
        Manpower = new ManpowerModel();
        response.sendRedirect("login.jsp");
    }%>  
    <%
    String GRVID= request.getParameter("GRVID") != null?request.getParameter("GRVID"):""; 
    String GRVDETID= request.getParameter("GRVDETID") != null?request.getParameter("GRVDETID"):""; 
    %>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
	<title>TATA AIA GMS</title>
	<jsp:include page="head.jsp"></jsp:include>   
</head>
<body class="slim__theme">
<div class="vz_main_sec">
	<jsp:include page="InvSidebar.jsp"></jsp:include>
    <jsp:include page="headerRedressalAuthority.jsp"></jsp:include>
    <div class="vz_main_container">
        <div class="vz_main_content">
            <div class="row">
                <div class="col-12">
                   	<div class="card">
                   	<div class = "heading__prdu mb-1">
                          		<h4 class="card_title text-center mb-0">DAILY DAIRY ATTACHMENT (Multiple file Upload)</h4>                     
					 </div>
                   	<div class="card-body">
	                   	<form method="post" action="DairyAttachment" enctype="multipart/form-data">  		                      
	                         <div class="form-group">
	                             <label class="col-form-label" for="CASEID">CASE ID</label>
	                             <input type="text" name="CASEID" class="form-control" id="CASEID" value="<%=request.getParameter("CASEID")%>" readonly>
	                         </div>	
	                         <input type="hidden" value="<%=request.getParameter("GRVID")%>" name="GRVID" >		
	                         <input type="hidden" value="<%=request.getParameter("GRVDETID")%>" name="GRVDETID" >	
	                         <div class="form-group">
	                             <label class="col-form-label" for="DAIRYID">DAIRY ID</label>
	                             <input type="text" name="DAIRYID" class="form-control" id="DAIRYID" value="<%=request.getParameter("DAIRYID")%>" >
	                         </div>			                      
	                         <div class="form-group">
	                             <label class="col-form-label" for=DAIRY_DATE>DAIRY_DATE</label>
	                             <input type="text" name="DAIRY_DATE" class="form-control" id="DAIRY_DATE" data-date-format="dd-mm-yyyy" readonly>
	                         </div>                      
	                         <div class="form-group">
	                         	<label class="col-form-label" for="filePath">File Path</label>
	                            <div class="upload_file">
									<input type="file" id="FILEPATH" name="FILEPATH" class="inputfile inputfile-6" accept=".xlsx,.xls,image/*,.doc,audio/*,.docx,video/*,.ppt,.pptx,.txt,.pdf" required>
									<label for="FILEPATH"><strong> Upload File</strong><span>No file chosen...</span></label>
								</div>
								<span style="color: indianred; float: right;"> *</span>
								<div id="uploadEmpty" class="invalid-feedback" style="display:none">Please choose a file.</div>
	                   		</div> 
	                        <div class="form-group">
	                       		<label class="col-form-label" for="FILENAME">File Name</label>
	                       		<input type="text"  class="form-control" id="FILENAME" name="FILENAME" placeholder="Enter File Name" required>
	                     		<span style="color: indianred; float: right;"> *</span>
	                      	</div> 
	                        <div class="form-group row">
								<div class="col-sm-12 text-right">
								    <button type="submit" class="btn btn-primary">Submit</button>
								    <button type="button" onclick="window.history.back();" class="btn btn-light cancel">Cancel</button>
								</div>
	                        </div>  
	                       </form>
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
<script type="text/javascript">
	document.getElementById("dailydiary").onclick = function() {
		location.href = "DailyDiaryUpdation.jsp";
	};
	$(function() {
		$('body').addClass('slim__theme');
	});
</script>
<script>
$("#DAIRY_DATE").datepicker('setStartDate', 'now');
$("#DAIRY_DATE").datepicker('setEndDate', 'now');
$('#DAIRY_DATE').datepicker('setDate', 'now');
</script>
<script type="text/javascript" src="js/custom-file-input.js"></script>
</body>
</html>
