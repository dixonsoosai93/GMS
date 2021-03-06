<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gms.model.masters.OrganisationHierarchyMasterModel" %>
<%@page import="com.gms.dao.masters.OrganisationHierarchyMasterDAO"%>
<%@ page import="com.gms.model.masters.GrievanceHandlingTatModel" %>
<%@page import="com.gms.dao.masters.GrievanceHandlingTatMasterDAO"%>
<%@ page import="java.util.List" %>
<%@ page import="com.gms.model.user.Admin" %>
<%@page import="com.gms.model.masters.ManpowerModel"%>
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
    <jsp:include page="sidebar.jsp"></jsp:include>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="vz_main_container">
        <div class="vz_main_content">
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-body">
                            <div class="heading__prdu mb-1">
                            	<h4 class="card_title text-center text-uppercase mb-2">Grievance Handling TAT</h4>
                            </div>
                            <div class="btnPosi">
                            	<div class="rightpageBtn">
                            		<a style="position: relative;" href="#" id="addZn" data-toggle="modal" data-target="#exampleModalCenter">
										<span title="" data-toggle="popover" data-trigger="hover" data-content="Add Grievance Handling TAT">
											<i class="fa fa-plus-circle"></i>
										</span>
									</a>
								</div>
							</div>
                            <div class="table-responsive datatable-primary">
		           				<table style="width:100%;"  id="dataTable2" class="text-center">
                                    <thead class="text-uppercase">
                                        <tr>
                                        	<th scope="col">S.No.</th>
                                        	<th scope="col">TAT ID</th>
                                        	<th scope="col">HIER ID</th>
                                        	<th scope="col">HIER CODE</th>                                 	
                                            <th scope="col">HIER NAME</th>
                                         	<th scope="col">TAT DAYS</th>
                                            <th scope="col">BUFFER DAYS</th>                                         
                                            <th scope="col">IS ACTIVE</th>
                                            <th scope="col">CREATED DATE</th>
                                            <th class="sorting_none">ACTION</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%
		                             	int i = 1;
		                             	List<GrievanceHandlingTatModel> listGrvHandling =  GrievanceHandlingTatMasterDAO.getGrvHandling();
		                             	if(listGrvHandling != null){
		                             	for(GrievanceHandlingTatModel item : listGrvHandling){
		                             	%>
		                                <tr>
		                                  <td><%=i%></td>
		                                  <td><%=item.getTATID()%></td>
		                                  <td><%=item.getHIERID()%></td>
		                                  <td><%=item.getHIERCODE()%></td>
		                                  <td><%=item.getHIERNAME()%></td>
		                                  <td><%=item.getTATDAYS()%></td>
		                                  <td><%=item.getBUFFERDAYS()%></td>
		                                  <td><% if(item.getIS_ACTIVE().equalsIgnoreCase("Y")){ %>Yes<% } else { %>No <% } %></td>
		                                  <td><%=item.getDATE_CREATED() %></td> 
		                                  <td>
		                                      <ul class="d-flex justify-content-center">
												<li class="mr-3"><button type="button" class="btn btn-inverse-secondary edit" data-toggle="modal" data-target="#exampleModalCenter2"><i class="fa fa-edit"></i></button></li> 
		                                      </ul>
		                                  </td>
										</tr>
		                              	<%
		                                i++;
			                          	} }
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
<div class="modal fade show" id="exampleModalCenter" style="display: none; padding-right: 17px;">                        
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
          	<form id="addGrievanceHandlingTatMaster" action="CreateGrievanceHandlingTatMaster" method="post">
				<div class="modal-header">
                   <h5 class="modal-title text-right">ADD Grievance Handling TAT</h5>
              	</div>
				<div class="modal-body">
                   	<div class="form-group">
						<label class="col-form-label" for="HIERCODE">SELECT HIER CODE</label>
						<select class="js-select2 form-control" name="HIERID" id="HIERID" aria-hidden="true">
							<option selected="selected" value="-1" disabled>Choose Hier Code</option>
							<%
	           				int j = 1;
								List<OrganisationHierarchyMasterModel> listOrgHierarchy =  OrganisationHierarchyMasterDAO.getOrgHierarchy();
                             	if(listOrgHierarchy != null){
                             	for(OrganisationHierarchyMasterModel item : listOrgHierarchy){
	        				%>
	      					<option value="<%=item.getHIERID()%>"><%=item.getHIERCODE()%></option>
							<%
				             j++;
				         	} 
                            }
				 			%>
  						</select>
  						<span style="color: indianred; float: right;"> *</span>
                   </div>
       	           <div class="form-group">
                     <label class="col-form-label" for="TATDAYS">TAT DAYS</label>
                        <input type="text" name="TATDAYS" class="form-control" id="TATDAYS"  placeholder="Enter Tat Days">
                        <span style="color: indianred; float: right;"> *</span>
                   </div>
                   <div class="form-group">
                     <label class="col-form-label" for="BUFFERDAYS">BUFFER DAYS</label>
                        <input type="text" name="BUFFERDAYS" value="0" class="form-control" id="BUFFERDAYS"  placeholder="Enter Buffer Days">
                        <span style="color: indianred; float: right;"> *</span>
                   </div>
                   <div class="form-group">
                       <label class="col-form-label" for="IS_ACTIVE">IS ACTIVE</label>
                       <select class="custom-select" id="IS_ACTIVE" name="IS_ACTIVE">
                           <option value="Y">Yes</option>
                           <option value="N">No</option>
                       </select>
                   </div>
               </div>
               <div class="modal-footer">
                   <button type="submit" class="btn btn-primary">SUBMIT</button>
                   <button type="button" id="cancel" class="btn btn-light" data-dismiss="modal">CANCEL</button>
               </div>
			</form>    
		</div>
	</div>
</div>
<div class="modal fade show" id="exampleModalCenter2" style="display: none; padding-right: 17px;">                        
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
        	<form id="editGrievanceHandlingTatMaster" action="EditGrievanceHandlingTatMaster" method="post">
				<div class="modal-header">
                   <h5 class="modal-title text-right">Edit Grievance Handling TAT</h5>
              	</div>
				<div class="modal-body">
				<div class="form-group">
                 <label class="col-form-label" for="ETATID">TAT ID</label>
				 <input type="text" id="ETATID" class="form-control" name="ETATID" readonly>
				</div>
                   	<div class="form-group">
						<label class="col-form-label" for="EHIERID">SELECT HIER CODE</label>
						<select class="js-select2 form-control" name="EHIERID" id="EHIERID" aria-hidden="true">
							<option  disabled>Choose Hier Code</option>
							<%
	           				int K = 1;
								List<OrganisationHierarchyMasterModel> listOrgHierarchy1 =  OrganisationHierarchyMasterDAO.getOrgHierarchy();
                             	if(listOrgHierarchy1 != null){
                             	for(OrganisationHierarchyMasterModel item : listOrgHierarchy){
	        				%>
	      					<option value="<%=item.getHIERID()%>"><%=item.getHIERCODE()%></option>
							<%
				             K++;
				         	} 
                            }
				 			%>
  						</select>
  						<span style="color: indianred; float: right;"> *</span>
                   </div>
       	           <div class="form-group">
                     <label class="col-form-label" for="ETATDAYS">TAT DAYS</label>
                     <input type="text" name="ETATDAYS" class="form-control" id="ETATDAYS"  placeholder="Enter Tat Days">
                   	 <span style="color: indianred; float: right;"> *</span>
                   </div>
                   <div class="form-group">
                     <label class="col-form-label" for="EBUFFERDAYS">BUFFER DAYS</label>
                     <input type="text" name="EBUFFERDAYS" class="form-control" id="EBUFFERDAYS"  placeholder="Enter Buffer Days">
                   	 <span style="color: indianred; float: right;"> *</span>
                   </div>
                   <div class="form-group">
                       <label class="col-form-label" for="EIS_ACTIVE">IS ACTIVE</label>
                       <select class="custom-select" id="EIS_ACTIVE" name="EIS_ACTIVE">
                           <option value="Y">Yes</option>
                           <option value="N">No</option>
                       </select>
                   </div>
               </div>
               <div class="modal-footer">
                   <button type="submit" class="btn btn-primary">SUBMIT</button>
                   <button type="button" class="btn btn-light" data-dismiss="modal">Cancel</button>
               </div>
			</form>    
       </div>
    </div>
</div>
<div class="col-lg-6 stretched_card" style="display:none">
     <button type="button" class="btn btn-success mt-2 sweet_success_btn">Success Message</button>
</div>       
<script>
    $(document).ready(function() {
      $(".js-select2").select2();
      $(".js-select2-multi").select2();
    });
</script>    
<script>
$(function() {
	$('body').addClass('slim__theme');
});

	$('.edit').on('click',function(){
		$tr=$(this).closest('tr');
		var data=$tr.children('td').map(function(){
			return $(this).text();
		}).get();
		$('#ETATID').val(data[1]);
		$('#EHIERID').select2("trigger", "select", {data: { id: data[2], text: data[3]}});
		$('#ETATDAYS').val(data[5]);
		$('#EBUFFERDAYS').val(data[6]);
		var status = data[7];
		if(status=="Yes"){
			$('#EIS_ACTIVE').val("Y");
		}else{
			$('#EIS_ACTIVE').val("N");
		}
	});
	$(function() {
		  $('body').addClass('slim__theme');
		});
	$('#cancel').on('click',function(){
		$('#HIERID').select2("trigger", "select", {data: { id: -1, text: "Choose Hier Code"}});
		$('#TATDAYS').val("");
		$('#BUFFERDAYS').val("0");
	});
</script>
</body>
</html>