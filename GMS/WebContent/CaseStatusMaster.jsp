<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gms.model.masters.CaseStatusMasterModel" %>
<%@page import="com.gms.dao.masters.CaseStatusMasterDAO"%>
<%@ page import="java.util.*" %>
<%@ page import="com.gms.model.user.Admin" %>
<%@page import="com.gms.model.masters.ManpowerModel"%>
  <%@page import="com.gms.model.masters.ManpowerModel"%>
<% ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
 if (Manpower == null) {
        Manpower = new ManpowerModel();
        response.sendRedirect("login.jsp");
    }%>
<% 
    HashMap<String,String> errors = (HashMap)session.getAttribute("errors");
%>
<!DOCTYPE html>
<html>
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
                          <div class="btnPosi">
							  	<div >
							  		<a style="position: relative;" id="btnExport" >
										<span title="" data-toggle="popover" data-trigger="hover" data-content="Download Excel">
											<i class="fa fa-file-excel-o"></i>
										</span>
									</a>
								</div>
							</div>
                          <div class = "heading__prdu mb-1">
                           		<h4 class="card_title text-center text-uppercase mb-0">Case Status Master</h4>
                          </div>
							<div class="btnPosi">
							  	<div class="rightpageBtn">
							  		<a style="position: relative;"  href="#" data-toggle="modal" data-target="#exampleModalCenter">
										<span title="" data-toggle="popover" data-trigger="hover" data-content="Add Case Status Master">
											<i class="fa fa-plus-circle"></i>
										</span>
									</a>
								</div>
							</div>
							<div class="table-responsive datatable-primary">
								<table style="width:100%;"  id="dataTable2" class="text-center table">
									<thead class="text-uppercase">
				                        <tr>
				                            <th scope="col">Sno</th>
				                            <th>Case Status ID</th>
				                            <th>Case Status Name</th>
				                            <th>IS ACTIVE</th>
				                            <th>Created Date</th>
				                            <th class="sorting_none">Action</th>
				                        </tr>
									</thead>
                                <tbody>
								<%
                             	int i = 1;
                             	List<CaseStatusMasterModel> listComplainStatus =  CaseStatusMasterDAO.getComplaintStatus();
                             	if(listComplainStatus != null){
                             	for(CaseStatusMasterModel item : listComplainStatus){
                             	%>
                                <tr>
                                  <td><%=i%></td>
                                  <td><%=item.getSTATUSID()%></td>
                                  <td class="text-left"><%=item.getSTATUSNAME() %></td>
                                  <td><% if(item.getIS_ACTIVE().equalsIgnoreCase("Y")){ %>Yes<% } else { %>No <% } %></td>
                                  <td><%=item.getDATE_CREATED() %></td> 
                                  <td>
                                      <ul class="d-flex justify-content-center" id="btnExport">
										<li class="mr-3"><button type="button"  class="btn btn-inverse-secondary edit" data-toggle="modal" data-target="#exampleModalCenter2"><i class="fa fa-edit"></i></button></li> 
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
<div class="modal fade show" id="exampleModalCenter" style="display:none; padding-right: 17px;">       
  <div class="modal-dialog modal-md modal-dialog-centered" role="document">
       <div class="modal-content">
           <form id="addCaseStatusMaster" action="CreateCaseStatusMaster" method="post">
              <div class="modal-header">
                <h5 class="modal-title">Add Case Status Master</h5>
              </div>
		          <div class="modal-body">
		           <% if(errors!=null && errors.containsKey("error")){ 
		        	   out.println("<div style=\"color:#cd5c5c ;font-size: 12px\">"+errors.get("error")+"</div>");
		              }
		        	   %>
			          <div class="form-group">
                  <label class="col-form-label" for="STATUSNAME">Case Status Name</label>
                  <input type="text" name="STATUSNAME" class="form-control" id="STATUSNAME" placeholder="Enter Case Status Name" required>
                  <span style="color: indianred; float: right;"> *</span>
                </div>
                <div class="form-group">
                  <label class="col-form-label" for="IS_ACTIVE">IS ACTIVE</label>
                  <select class="custom-select" id="IS_ACTIVE" name="IS_ACTIVE">
                    <option value="Y">Yes</option>
                    <option value="N">No</option>
                  </select>
                </div>
                <div class="form-group row">
                  <div class="col-sm-12 text-right">
                  <button type="submit" class="btn btn-primary">Submit</button>
                  <button type="button" id="cancel" class="btn btn-light" data-dismiss="modal">Cancel</button>
                  </div>
                </div>
              </div>    
           </form>
       </div>     
  </div>    
</div>
<div class="modal fade show" id="exampleModalCenter2" style="display:none; padding-right: 17px;">       
  <div class="modal-dialog modal-md modal-dialog-centered" role="document">
     <div class="modal-content">
       <form id="editCaseStatusMaster" action="EditCaseStatusMaster" method="post">
          <div class="modal-header">
               <h5 class="modal-title">Edit Case Status Master</h5>
          </div>
          <div class="modal-body">
          	<div class="form-group">
              <label class="col-form-label" for="STATUSID">Case Status ID</label>
              <input type="text" name="EDIT_STATUSID" class="form-control" id="EDIT_STATUSID" placeholder="Enter Case Status ID" readonly required>
            </div>
	        <div class="form-group">
              <label class="col-form-label" for="STATUSNAME">Case Status Name</label>
              <input type="text" name="EDIT_STATUSNAME" class="form-control" id="EDIT_STATUSNAME" placeholder="Enter Case Status Name" required>
              <span style="color: indianred; float: right;"> *</span>
            </div>
            <div class="form-group">
              <label class="col-form-label" for="IS_ACTIVE">IS ACTIVE</label>
              <select class="custom-select" name="EDIT_IS_ACTIVE" id="EDIT_IS_ACTIVE">
                <option value="Y">Yes</option>
                <option value="N">No</option>
              </select>
            </div>
            <div class="form-group row">
              <div class="col-sm-12 text-right">
              		<button type="submit" class="btn btn-primary">Submit</button>
                  	<button type="button" class="btn btn-light" data-dismiss="modal">Cancel</button>
              </div>
            </div>
          </div>    
       </form>
     </div>     
  </div>    
</div>
<div class="col-lg-6 stretched_card" style="display:none">
     <button type="button" class="btn btn-success mt-2 sweet_success_btn">Success Message</button>
</div>
<script>
	$(function() {
		$('body').addClass('slim__theme');
	});
	$('.edit').on('click',function(){
		$tr=$(this).closest('tr');
		var data=$tr.children('td').map(function(){
			return $(this).text();
		}).get();
		$('#EDIT_STATUSID').val(data[1]);
		$('#EDIT_STATUSNAME').val(data[2]);
		var status = data[3];
		if(status=="Yes"){
			$('#EDIT_IS_ACTIVE').val("Y");
		}else{
			$('#EDIT_IS_ACTIVE').val("N");
		}
	});
	$('#cancel').on('click',function(){
		$('#STATUSNAME').val("");
	});
</script>
<script type="text/javascript">
	/* $(document).ready(function() {
	    var table = $('#dataTable2').DataTable( {
	        lengthChange: false,
	        buttons: [ 'excel']
	    } );
	 
	    table.buttons().container()
	        .appendTo( '#example_wrapper .col-md-6:eq(0)' );
	} );*/
	$(document).ready(function() {
		$(function (){
			var table = $('#dataTable2').DataTable();
				$("#btnExport").click(function(e){
					table.page.len( -1 ).draw();
				    window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#dataTable2').parent().html()));
				    	setTimeout(function(){
				      		table.page.len(10).draw();
				      	}, 1000)
			});
		});
	});
</script>
</body>
</html>
