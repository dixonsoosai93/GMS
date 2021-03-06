<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.gms.model.user.Admin" %>
<%@ page import="com.gms.model.masters.OrganisationHierarchyMasterModel" %>
<%@page import="com.gms.dao.masters.OrganisationHierarchyMasterDAO"%>
<%@ page import="com.gms.model.masters.MainCategoryModel" %>
<%@page import="com.gms.dao.masters.MainCategoryDAO"%>
<%@ page import="com.gms.model.masters.GrievanceCategoryHierarchyModel" %>
<%@page import="com.gms.dao.masters.GrievanceCategoryHierarchyDAO"%>
<%@page import="com.gms.model.masters.ManpowerModel"%>
<% ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
 if (Manpower == null) {
        Manpower = new ManpowerModel();
        response.sendRedirect("login.jsp");
    }%>
<head>
	<title>Grievance Category Hierarchy</title>
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
                       <h4 class="card_title text-right">Edit Grievance Category Hierarchy</h4>
                               <%
	                            int Id = Integer.parseInt(request.getParameter("FLOWID"));
                                GrievanceCategoryHierarchyModel grievanceCategory =  GrievanceCategoryHierarchyDAO.getgrievanceCategory(Id);
	                           	if(grievanceCategory != null){
	                         	 %> 
                               <form id="addGrievanceCategory"  method="post">
                               <div class="form-group">
	                                <label class="col-form-label" for="FLOWID">FLOW ID</label>
	                                <input type="text" name="FLOWID" class="form-control" id="FLOWID" value="<%=request.getParameter("FLOWID")%>" readonly required placeholder="Enter Main Category Name">
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="MAIN_CATEGORY_CODE">Main Category Code</label>
	                                   <select class="js-select2 form-control" name="MAIN_CATEGORY_CODE" id="MAIN_CATEGORY_CODE" aria-hidden="true">
							               <option selected="selected" value="-1" disabled>Choose Main Category Code</option>
							               <%
			                             	int i = 1;
			                             	List<MainCategoryModel> MainCategory =  MainCategoryDAO.getMainCategory();
			                             	if(MainCategory != null){
			                             	for(MainCategoryModel item : MainCategory){
			                             	%>
			                             	<option value="<%=item.getMAIN_CATEGORY_CODE()%>" <% if(item.getMAIN_CATEGORY_CODE().equals(grievanceCategory.getMAIN_CATEGORY_CODE())) { %>selected<% } %> data-key1='<%=item.getMAIN_CATEGORY_NAME()%>'><%=item.getMAIN_CATEGORY_CODE()%></option>
			                             		<%
			                                i++;
				                          	} }
			                      			%>
  						               </select>
	                             </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="MAIN_CATEGORY_NAME">Main Category Name</label>
	                                <input type="text" name="MAIN_CATEGORY_NAME" class="form-control" id="MAIN_CATEGORY_NAME" value="<%=grievanceCategory.getMAIN_CATEGORY_NAME()%>" disabled placeholder="Enter Main Category Name">
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="SUB_CATEGORY_CODE">SUB CATEGORY CODE</label>
	                                <input type="text" name="SUB_CATEGORY_CODE" class="form-control" id="SUB_CATEGORY_CODE" value="<%=grievanceCategory.getSUB_CATEGORY_CODE()%>" placeholder="Enter Sub Category Code">
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="SUB_CATEGORY_NAME">SUB CATEGORY NAME</label>
	                                <input type="text" name="SUB_CATEGORY_NAME" class="form-control" id="SUB_CATEGORY_NAME"  value="<%=grievanceCategory.getSUB_CATEGORY_NAME()%>" placeholder="Enter Sub Category Name">
	                            </div>
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
				      					<option value="<%=item.getHIERID()%>"  <%if(item.getHIERID()==grievanceCategory.getHIERID()) { %>selected<% } %> ><%=item.getHIERCODE()%></option>
										<%
							               j++;
							         	   } 
			                               }
							 			%>
			  						</select>
			                      </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="CATEGORY_ORDER">CATEGORY ORDER</label>
	                                <input type="text" name="CATEGORY_ORDER" class="form-control" id="CATEGORY_ORDER" value="<%=grievanceCategory.getCATEGORY_ORDER()%>"  placeholder="Enter Category Order">
	                            </div>
                                <div class="form-group">
                                    <label class="col-form-label" for="IS_ACTIVE">IS ACTIVE</label>
                                    <select class="custom-select" name="IS_ACTIVE" id="IS_ACTIVE" >
                                        <option value="Y" <% if(grievanceCategory.getIS_ACTIVE().equalsIgnoreCase("Y")){ %> Selected <% } %>>Yes</option>
                                        <option value="N" <% if(!grievanceCategory.getIS_ACTIVE().equalsIgnoreCase("Y")){ %> Selected <% } %>>No</option>
                                    </select>
                                </div>   
	                            <div class="form-group row">
	                                <div class="col-sm-12 text-right">
	                                    <button type="reset" onClick="add();" value="Reset" id="preview" class="btn btn-primary">Preview Add</button>
	                                </div>
	                            </div>
                            </form>
                            <% } %>
		                     <div class="table-responsive datatable-primary">
		                     <form action="CreateGrievanceCategoryHierarchy" method="post">
					    		  <table style="width:100%;"  id="results" class="text-center">
		                           <thead class="text-uppercase">
		                           <tr>
                                   <th scope="col">Sno</th>
                                   <th>FLOW ID</th>
                                   <th>MAIN CATEGORY CODE</th>
                                   <th>MAIN CATEGORY NAME</th>
                                   <th>SUB CATEGORY CODE</th>
                                   <th>SUB CATEGORY NAME</th>
                                   <th>HIER ID</th>
                                   <th>HIER CODE</th>
                                   <th>CATEGORY ORDER</th>
                                   <th>IS ACTIVE</th>
                                   </tr>
                                  </thead>
                                  <tbody>
                                  <tr>
                                  </tr>
                                   </tbody>
		                           </table>
		                           </form>
		                       </div>
                            </div>
                            <div class="form-group row">
	                                <div class="col-sm-12 text-right">
	                                    <button type="submit" id="Save" class="btn btn-primary"  >Submit</button>
	                                    <button type="button" class="btn btn-light cancel">Cancel</button>
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
<script>
	$('#MAIN_CATEGORY_CODE').change(function(){
		let categoryCode = $(this).find('option:selected').data('key1');
		$('#MAIN_CATEGORY_NAME').val(categoryCode);
		
	});
	$("#Save").prop('disabled', true);
	$("#preview").on('click', function(){
		//$("#Save").css("display", "block");
		$("#Save").prop('disabled', false);
	});
</script>
<script>
	var i=1;
	function  add(){
		var Sno=i;
		var FLOWID=document.getElementById("FLOWID").value;
	    var MAIN_CATEGORY_CODE = document.getElementById("MAIN_CATEGORY_CODE").value;
	    var MAIN_CATEGORY_NAME = document.getElementById("MAIN_CATEGORY_NAME").value;
	    var SUB_CATEGORY_CODE = document.getElementById("SUB_CATEGORY_CODE").value;
	    var SUB_CATEGORY_NAME = document.getElementById("SUB_CATEGORY_NAME").value;
	    var HIERID = document.getElementById("HIERID").value;
	    var HIERCODE = document.getElementById("HIERID");
	    var optHIERCODE=HIERCODE.options[HIERCODE.selectedIndex].text;
	    var CATEGORY_ORDER = document.getElementById("CATEGORY_ORDER").value;
	    var IS_ACTIVE = document.getElementById("IS_ACTIVE").value;
	    var table=document.getElementById("results");
	    var row=table.insertRow(-1);
	    var cell1=row.insertCell(0);
	    var cell2=row.insertCell(1);
	    var cell3=row.insertCell(2);
	    var cell4=row.insertCell(3);
	    var cell5=row.insertCell(4);
	    var cell6=row.insertCell(5);
	    var cell7=row.insertCell(6);
	    var cell8=row.insertCell(7);
	    var cell9=row.insertCell(8);
	    var cell10=row.insertCell(9);
	    cell1.innerHTML=Sno;
	    cell2.innerHTML=FLOWID;
	    cell3.innerHTML=MAIN_CATEGORY_CODE;
	    cell4.innerHTML=MAIN_CATEGORY_NAME;        
	    cell5.innerHTML=SUB_CATEGORY_CODE;
	    cell6.innerHTML=SUB_CATEGORY_NAME;
	    cell7.innerHTML=HIERID;
	    cell8.innerHTML=optHIERCODE;
	    cell9.innerHTML=CATEGORY_ORDER;
	    if(IS_ACTIVE=='Y'){
	    cell10.innerHTML="YES";}
	    else{cell10.innerHTML="NO";}
	    i++;
	}
</script>
<script>
	$( "#Save" ).click(function() {
	    var category = new Array();
	    $("#results TBODY TR").each(function () {
	        var row = $(this);
	        var categoryData = {};
	        categoryData.FLOWID = row.find("TD").eq(1).html();
	        categoryData.MAIN_CATEGORY_CODE = row.find("TD").eq(2).html();
	        categoryData.MAIN_CATEGORY_NAME = row.find("TD").eq(3).html();
	        categoryData.SUB_CATEGORY_CODE = row.find("TD").eq(4).html();
	        categoryData.SUB_CATEGORY_NAME = row.find("TD").eq(5).html();
	        categoryData.HIERID = row.find("TD").eq(6).html();
	        categoryData.HIERCODE = row.find("TD").eq(7).html();
	        categoryData.CATEGORY_ORDER = row.find("TD").eq(8).html();
	        categoryData.IS_ACTIVE = row.find("TD").eq(9).html();
	        category.push(categoryData);
	    });
	    $.ajax({
	        type: "GET",
	        url: "EditGrievanceCategoryHierarchy",
	        data: {"data":JSON.stringify(category)},
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        success: function (result) {
	        	if(result.status == 200){
	        		window.location = "GrievanceCategoryHierarchyList.jsp";
	        	} else {
	        		window.location = "EditGrievanceCategoryHierarchy.jsp";
	        	} 
	        }
	    });
	});
</script> 
<script>
	$(function() {
		$('body').addClass('slim__theme');
	});
    $(document).ready(function() {
      $(".js-select2").select2();
      $(".js-select2-multi").select2();
    });
    $('.cancel').click(function(){
   	 location.href ="GrievanceCategoryHierarchyList.jsp"; 
   	 }); 
</script>
</body>
</html>