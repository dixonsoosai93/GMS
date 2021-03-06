<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gms.model.masters.MainCategoryModel" %>
<%@page import="com.gms.dao.masters.MainCategoryDAO"%>
<%@ page import="java.util.List" %>
<%@ page import="com.gms.model.user.Admin" %>
<%@page import="com.gms.model.masters.ManpowerModel"%>
<% ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
 if (Manpower == null) {
        Manpower = new ManpowerModel();
        response.sendRedirect("login.jsp");
    }%>
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
                          <div class = "heading__prdu mb-1">
                           		<h4 class="card_title text-center text-uppercase mb-0">Hierarchy's Main Catergory</h4>
                            </div>
                            <div class="btnPosi">
                            	<div class="rightpageBtn">
                            		<a style="position: relative;" href="#" data-toggle="modal"  data-target="#exampleModalCenter">
										<span title="" data-toggle="popover" data-trigger="hover" data-content="Add Hierarchy's Main Catergory">
											<i class="fa fa-plus-circle"></i>
										</span>
									</a>
								</div>
							</div>
                          <div class="table-responsive datatable-primary">
			    			<table style="width:100%;"  id="dataTable2" class="text-center display">
                              <thead class="text-uppercase">
                                <tr>
                                    <th>Sno</th>
                                    <th>Main Catergory Code</th>
                                    <th>Main Catergory Name</th>
                                    <th>IS ACTIVE</th>
                                    <th>Created Date</th>
                                    <th class="sorting_none">Action</th>
                                  </tr>
                                </thead>
                                <tbody>
								<%
                             	int i = 1;
                             	List<MainCategoryModel> MainCategory =  MainCategoryDAO.getMainCategory();
                             	if(MainCategory != null){
                             	for(MainCategoryModel item : MainCategory){
                             	%>
                                <tr>
                                  <td><%=i%></td>
                                  <td><%=item.getMAIN_CATEGORY_CODE()%></td>
                                  <td><%=item.getMAIN_CATEGORY_NAME()%></td>
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
<div class="modal fade show" id="exampleModalCenter" style="display:none; padding-right: 17px;">       
  <div class="modal-dialog modal-md modal-dialog-centered" role="document">
       <div class="modal-content">
           <form id="addMainCategory" action="CreateMainCategory" method="post">
              <div class="modal-header">
                <h5 class="modal-title">Add Hierarchy's Main Catergory</h5>
               </div>
		        <div class="modal-body">
		        <div class="form-group">
	              <label class="col-form-label" for="MAIN_CATEGORY_CODE">Main Catergory Code</label>
	              <input type="text" name="MAIN_CATEGORY_CODE" class="form-control" id="MAIN_CATEGORY_CODE" placeholder="Enter Main Catergory Code">
	              <span style="color: indianred; float: right;"> *</span>
	            </div>
                <div class="form-group">
					<label class="col-form-label" for="MAIN_CATEGORY_NAME">Main Catergory Name</label>
	                <input type="text" name="MAIN_CATEGORY_NAME" class="form-control" id="MAIN_CATEGORY_NAME" placeholder="Enter Main Catergory Name" required>
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
       <form id="editMainCategory" action="EditMainCategory" method="post">
          <div class="modal-header">
               <h5 class="modal-title">Edit Hierarchy's Main Catergory</h5>
          </div>
          <div class="modal-body">
          	<div class="form-group">
              <label class="col-form-label" for="EMAIN_CATEGORY_CODE">Main Catergory Code</label>
              <input type="text" name="EMAIN_CATEGORY_CODE" class="form-control" id="EMAIN_CATEGORY_CODE" placeholder="Enter Main Catergory Code" readonly required>
              <span style="color: indianred; float: right;"> *</span>
            </div>
	        <div class="form-group">
              <label class="col-form-label" for="EMAIN_CATEGORY_NAME">Main Catergory Name</label>
              <input type="text" name="EMAIN_CATEGORY_NAME" class="form-control" id="EMAIN_CATEGORY_NAME" placeholder="Enter Main Catergory Name" required>
              <span style="color: indianred; float: right;"> *</span>
            </div>
            <div class="form-group">
              <label class="col-form-label" for="IS_ACTIVE">IS ACTIVE</label>
              <select class="custom-select" name="EIS_ACTIVE" id="EIS_ACTIVE">
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
		$('#EMAIN_CATEGORY_CODE').val(data[1]);
		$('#EMAIN_CATEGORY_NAME').val(data[2]);
		var status = data[3];
		if(status=="Yes"){
			$('#EIS_ACTIVE').val("Y");
		}else{
			$('#EIS_ACTIVE').val("N");
		}
	});
	$('#cancel').on('click',function(){
		$('#MAIN_CATEGORY_CODE').val("");
		$('#MAIN_CATEGORY_NAME').val("");
	});
</script>

</body>
</html>
