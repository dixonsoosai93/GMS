<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.gms.model.masters.ManpowerModel"%>
<%@ page import="com.gms.model.investigator.DtDailyDairy"%>
<%@ page import="com.gms.dao.investigator.DailyDairyDAO"%>
<% ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
 if (Manpower == null) {
        Manpower = new ManpowerModel();
        response.sendRedirect("login.jsp");
    }
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
    <jsp:include page="header.jsp"></jsp:include>
    <div class="vz_main_container">
        <div class="vz_main_content">
            <div class="row">
                <div class="col-12">
                   	<div class="card">
                       	<div class="card-body">
	                       <div class = "heading__prdu mb-1">
                           		<h4 class="card_title text-center mb-0 ">ALL FILES UPLOADED FOR THIS AGGRIEVED EMPLOYEE</h4>
                            </div>     
                           <div class="table-responsive datatable-primary">
								<table style="width:100%;"  id="dataTable2" class="text-center">
                                      <thead class="text-uppercase">
                                        <tr>
                                           	<th>S.No.</th>
                                           	<th>ATTACHMENT ID</th>
                                            <th>DAIRY ID</th>
                                            <th>CASE ID</th>
                                            <th>FILE NAME</th>
                                            <th>Aggrieved Employee EMPLOYEE ID</th>
                                            <th>Aggrieved Employee EMPLOYEE NAME</th>
                                            <th>IS ACTIVE</th>
                                            <th>ACTION</th>
                                          </tr>  
                                      </thead>     
                                      <tbody>
                                       <%
										int i=1;
                                       	int DAIRYID= Integer.parseInt(request.getParameter("DAIRYID"));
                                       	List<DtDailyDairy> list= DailyDairyDAO.getDailyDairyAttach(DAIRYID);
                                       	if(list !=null){
                                        	for(DtDailyDairy item :list){
                                        	%>
											<tr>
											    <td><%=i%></td>
												<td><%=item.getATTACHID()%></td>
												<td><%=item.getDAIRYID()%></td>
												<td><%=item.getCASEID()%></td>
												<td><%=item.getFILENAME()%></td>
												<td><%=item.getEMPLOYEE_ID()%></td>
												<td><%=item.getNAME()%></td>
												<td><% if(item.getIS_ACTIVE().equalsIgnoreCase("Y")){ %>Yes<% } else { %>No <% } %></td>
											   	<td>
													<ul class="d-flex justify-content-center">
											   			<li class="mr-3"><button type="button" id="download" class="btn btn-inverse-secondary download" keys="<%=item.getATTACHID()%>" id="downloadAttchFile"><i class="fa fa-download"></i></button></li>
														<div id="confirm"><div class="message">Are you sure to delete?</div><button class="yes btn btn-primary">Yes</button><button class="no btn btn-light">No</button></div>
											            <li class="mr-3"><button type="button" class="btn btn-inverse-danger delete" data-key1="<%=item.getATTACHID() %>" data-key2="<%=item.getDAIRYID() %>" onclick='functionConfirm(this)'><i class="ti-trash"></i></button></li>
											    	</ul>	
												</td>	
											</tr>
                                      		<%
											i++;
                                        	} }
										%>
										</tbody>
                                  </table>
                                  <div class="form-group row">
	                                <div class="col-sm-12 text-right">
	                                    <button type="button" onclick="window.history.back();" class="btn btn-light cancel">Cancel</button>
	                                </div>
	                            </div>
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
<div class="col-lg-6 stretched_card" style="display:none">
 <button type="button" class="btn btn-success mt-2 sweet_success_btn">Success Message</button>
</div> 
<script type="text/javascript">
 $(function() {
 $('body').addClass('slim__theme');
 });
</script>
<script>
 
 $('.download').click(function(){
 	var ATTACHID = $(this).attr('keys'); 
 	console.log(" ATTACHID :"+ATTACHID);
 	window.open("DairyDownload?ATTACHID="+ATTACHID,'_blank');
});
</script>
<script type="text/javascript">
	var attachId = null;
	var confirmBox = $("#confirm");
	function functionConfirm(e) {
		attachId = $(e).data('key1');
		dairyId = $(e).data('key2');
		console.log(attachId+dairyId);
			if(confirm("Are you sure to delete"+ attachId +"?")){
		   		location.href ="DeleteAttachment?attachId="+attachId+"&dairyId="+dairyId;			
			} else{
				return false;
			}
	}
</script>
</body>
</html>
                                      