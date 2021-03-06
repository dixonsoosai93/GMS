<%@page import="com.gms.dao.admin.ReopenAttachmentDao"%>
<%@page import="com.gms.model.admin.ReopenAttachment"%>
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
    int GRVDETID= request.getParameter("GRVDETID") != null?Integer.parseInt(request.getParameter("GRVDETID")):0; 
    %>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
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
                   	<div class = "heading__prdu mb-1">
                           		<h4 class="card_title text-center mb-0">REOPEN CLOSED CASE ATTACHMENT</h4>                     
						 </div>
                       	 <div class="card-body">
                       	<form method="post" action="ReopenClosedAttachment" enctype="multipart/form-data">  		                      
	                            <div class="form-group">
	                                <label class="col-form-label" for="GRVDETID">GRVDET ID</label>
	                                <input type="text" name="GRVDETID" class="form-control" id="GRVDETID" value="<%=request.getParameter("GRVDETID")%>" >
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="GRVID">GRV ID</label>
	                                <input type="text" name="GRVID" class="form-control" id="GRVID" value="<%=request.getParameter("CASEID")%>" readonly>
	                            </div>	
	                            <div class="form-group">
	                                <label class="col-form-label" for="ATTACH_REMARKS">ATTACHMENT REMARKS</label>
	                                <textarea name="ATTACH_REMARKS" class="form-control" placeholder="Enter Remarks" id="ATTACH_REMARKS" ></textarea>
	                            	<span style="color: indianred; float: right;"> *</span>
	                            </div>			                      
                                <div class="form-group">
                                    <label class="col-form-label" for="filePath">File Path</label>
                                  <div class="upload_file">
										<input type="file" id="FILEPATH" name="FILEPATH" class="inputfile inputfile-6" accept=".xlsx,.xls,image/*,.doc,audio/*,.docx,video/*,.ppt,.pptx,.txt,.pdf" required>
										<label for="FILEPATH"> <strong> Upload File</strong><span>No file chosen...</span></label>
									</div>
									<span style="color: indianred; float: right;"> *</span>
									<div id="uploadEmpty" class="invalid-feedback" style="display:none">Please choose a file.</div>
			                    </div> 
	                            <div class="form-group">
			                        <label class="col-form-label" for="FILENAME">File Name</label>
			                        <input type="text"  class="form-control" id="FILENAME" name="FILENAME" placeholder="Enter File Name" required>
		                      		<span style="color: indianred; float: right;"> *</span>
		                      	</div>
		                      	<div class="form-group">
                                    <label class="col-form-label" for="IS_ACTIVE">IS ACTIVE</label>
                                    <select class="custom-select" name="IS_ACTIVE">
                                        <option value="Y">Yes</option>
                                        <option value="N">No</option>
                                    </select>
                                </div>  
	                            <div class="form-group row">
	                                <div class="col-sm-12 text-right">
	                                    <button type="submit" class="btn btn-primary">Submit</button>
	                                    <button type="button" id= "back" class="btn btn-light cancel">Back</button>
	                                </div>
	                            </div>  
	                          </form>
                          </div> 
                    </div>
	            </div>
	        </div>
	        <div class="row">
				<div class="col-12 mt-4">
					<div class="card">
						<div class="card-body">
                    		<div class = "heading__prdu mb-1">
                           		<h4 class="card_title text-center mb-0">REOPEN ATTACHMENTS LIST</h4>
                            </div>
							<div class="table-responsive datatable-primary">
								<table style="width:100%;"  id="dataTable2" class="text-center">
									<thead class="text-capitalize">
										<tr>
	                                    	<th>S.No.</th>
	                                    	<th>ATTACHMENT ID</th>
	                                    	<th>GRVDET ID</th>
	                                    	<th>GRV ID</th>
	                                    	<th>ATTACH_REMARKS</th>
	                                    	<th>FILEPATH</th>
	                                    	<th>FILE NAME</th>
	                                    	<th>IS_ACTIVE</th>
	                                    	<th>DATE CREATED</th>
	                                    	<th>COMPLIANT EMPLOYEE ID</th>
	                                    	<th>NAME</th>
	                                    	<th class="sorting_none">ACTION</th>
	                                  	</tr>
	                              	</thead>
	                              	<tbody>
	                               	<% 
	                               	List<ReopenAttachment> reopenAttachmentList = ReopenAttachmentDao.getComplaintAttachment(GRVDETID);
	                               	if(reopenAttachmentList != null && reopenAttachmentList.size() > 0){
	                               	int i=1;
	                            		for(ReopenAttachment item : reopenAttachmentList) {
	                            		%>
	                            		<tr>
	                            	   		<td><%=i++ %></td>
		                                    <td><%=item.getATTACHID() %></td>
		                                    <td><%=item.getGRVDETID() %></td>
		                                    <td><%=item.getGRVID() %></td>
		                                    <td><%=item.getATTACH_REMARKS()%></td>
		                                    <td><%=item.getFILEPATH() != null?item.getFILEPATH():""%></td>
		                                    <td><%=item.getFILENAME()%></td>
		                                    <td><%=item.getIS_ACTIVE()%></td>
		                                    <td><%=item.getDATE() %></td>
		                                    <td><%=item.getCOMPLIANT_EMPLOYEE_ID() %></td>
		                                    <td><%=item.getNAME() != null?item.getNAME():""%></td>
		                                    <td>
		                                    	<ul class="d-flex justify-content-center">
		                                    		<li class="mr-3"><button type="button" id="downloadAttach" class="btn btn-inverse-secondary download" onclick='functionDownload(this)' data-key1="<%=item.getATTACHID() %>"><i class="fa fa-download"></i></button></li>
		                                    		<div id="confirm">Are you sure to delete?<div class="message"></div><button class="yes btn btn-primary">Yes</button><button class="no  btn btn-light">No</button></div>
                                                    <li class="mr-3"><button type="button" class="btn btn-inverse-danger delete" data-key2="<%=item.getATTACHID()%>"  onclick='functionConfirm(this)'><i class="ti-trash"></i></button></li>
		                                    	</ul>	
		                                    </td>
		                                </tr>
		                            	<%
		                            } 	} 
		                            %>
									</tbody>
								</table>
							</div>
						</div> 
					</div>
				</div>
			</div>
	    </div>    
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<jsp:include page="footerList.jsp"></jsp:include>
</div>
<script type="text/javascript">
	$(function() {
		$('body').addClass('slim__theme');
	});
</script>
<script>
	$('.download').click(function(){
	 	var ATTACHID = $("#downloadAttach").data('key1');
	 	console.log(" ATTACHID :"+ATTACHID);
	 	window.open("ReopenCaseFileDownload?ATTACHID="+ATTACHID,'_blank');
	});
</script>
<script>
	var complaintId =  null;
	var confirmBox = $("#confirm");
	function functionConfirm(e){
		attachId = $(e).data('key2');
		if(confirm("Are you sure to delete "+attachId+"?")){
			location.href ="ReopenClosedAttachDelete?attachId="+attachId;	
    	} else{
    		return false;
    	}
	}
</script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#back').click(function(){
			location.href = "ReopenClosed.jsp?GRVDETID="+<%=request.getParameter("GRVDETID")%>;
		})
	});
</script>
<script type="text/javascript" src="js/custom-file-input.js"></script>
</body>
</html>
