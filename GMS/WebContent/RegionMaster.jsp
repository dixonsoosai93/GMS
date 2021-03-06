<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.gms.model.user.Admin" %>
<%@ page import="com.gms.model.masters.ManpowerModel" %>
<%@ page import="com.gms.model.masters.CityModel" %>
<%@ page import="com.gms.model.masters.BranchModel" %>
<%@page import="com.gms.dao.masters.HrcMasterDAO"%>
<%@page import="com.gms.dao.masters.RegionMasterDAO"%>
<%@ page import="com.gms.model.masters.ALBranch"%>
<%@ page import="com.gms.model.masters.ALDesignation"%>
<%@ page import="com.gms.model.masters.ALJobFunction"%>
<%@ page import="com.gms.model.masters.ALDepartment"%>
<%@ page import="com.gms.model.masters.ComplaintEmpSelect"%>
<% ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
 if (Manpower == null) {
        Manpower = new ManpowerModel();
        response.sendRedirect("login.jsp");
    }%>
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
                       <h4 class="card_title text-right">ADD Region</h4>
                       <form id="addRegion"  method="post">
                          <div class="row mb-4">
                             <div class="col-md-6 border-right">
	                             <div class="form-group">
		                                <label class="col-form-label" for="REGION_CODE">Region Code (TALIC)</label>
		                                <input type="text" name="REGION_CODE" class="form-control" id="REGION_CODE" placeholder="Enter Region Code">
		                                <span style="color: indianred; float: right;"> *</span>
		                            </div>  
		                             <div class="form-group">
		                                <label class="col-form-label" for="REGION_NAME">Region Name</label>
		                                <input type="text" name="REGION_NAME" class="form-control" id="REGION_NAME" placeholder="Enter Region Name">
		                            	<span style="color: indianred; float: right;"> *</span>
		                            </div>
		                            <div class="form-group">
		                                <label class="col-form-label" for="REGION_DESC">Region Description</label>
		                                <textarea class="form-control" name="REGION_DESC" id="REGION_DESC" placeholder="Enter Region Description"></textarea>
		                            	<span style="color: indianred; float: right;"> *</span>
		                            </div>
		                            <div class="form-group">
									   <label class="col-form-label" for="EMPLOYEE_NAME">Region HR - Employee Name</label>
									     <div class="d-flex">
										<select class="js-select2 form-control" name="EMPLOYEE_NAME" id="EMPLOYEE_NAME" aria-hidden="true">
											<option selected="selected" value="-1" disabled>Choose Employee Name</option>
											<%
					           				    int j = 1;
												List<ManpowerModel> listManpower =  RegionMasterDAO.getManpowerRegion();
				                             	if(listManpower != null){
				                             	for(ManpowerModel item : listManpower){
					        				 %>
					      					<option value="<%=item.getEMPLOYEE_ID()%>" data-key1 ='<%=item.getDESIGNATION() %>' data-key2 ='<%=item.getDEPARTMENT()%>' data-key3='<%=item.getBRANCH_NAME()%>'><%=item.getNAME()%></option>
											<%
								               j++;
								         	   } 
				                               }
								 			%>
				  						</select>
				  						<span style="color: indianred; float: right;"> *</span>
				  						<div class="flex-fill">
				  						<button type="button" class="btn btn-inverse-secondary ml-3" data-toggle="modal" data-target="#exampleModalCenter"><i class="fa fa-search"></i></button>
				  						</div>
				                      </div>
				                     </div> 
		                            <div class="form-group">
		                                <label class="col-form-label" for="EMPLOYEE_ID">Region HR - Employee ID</label>
		                                <input type="text" name="EMPLOYEE_ID" class="form-control" id="EMPLOYEE_ID" disabled>
		                            	<span style="color: indianred; float: right;"> *</span>
		                            </div>
		                            <div class="form-group">
		                                <label class="col-form-label" for="EMPLOYEE_DESIGNATION">Region HR - Employee Designation</label>
		                                <input type="text" name="EMPLOYEE_DESIGNATION" class="form-control" id="EMPLOYEE_DESIGNATION" disabled>
		                            	<span style="color: indianred; float: right;"> *</span>
		                            </div>
		                            <div class="form-group">
		                                <label class="col-form-label" for="EMPLOYEE_DEPARTMENT">Region HR - Employee Department</label>
		                                <input type="text" name="EMPLOYEE_DEPARTMENT" class="form-control" id="EMPLOYEE_DEPARTMENT" disabled>
		                            	<span style="color: indianred; float: right;"> *</span>
		                            </div>	
		                            <div class="form-group">
		                                <label class="col-form-label" for="EMPLOYEE_BRANCH">Region HR - Employee Branch</label>
		                                <input type="text" name="EMPLOYEE_BRANCH" class="form-control" id="EMPLOYEE_BRANCH" disabled>
		                            	<span style="color: indianred; float: right;"> *</span>
		                            </div>
	                                <div class="form-group">
	                                    <label class="col-form-label" for="HD_IS_ACTIVE">IS ACTIVE</label>
	                                    <select class="custom-select" name="HD_IS_ACTIVE" id="HD_IS_ACTIVE" >
	                                        <option value="Y">Yes</option>
	                                        <option value="N">No</option>
	                                    </select>
	                                </div>
	                             </div>
	                          <div class="col-md-6 border-left">    
                                <div class="form-group">
                                    <label class="col-form-label" for="CITY_NAME" >Select City</label>
                                     <select class="js-select2"  id="CITY_NAME" aria-hidden="true" name="CITY_NAME">
                                       <option selected="selected" value="-1" disabled>Choose City Name</option>
                                       <%
					           				    j = 1;
												List<CityModel> cityList =  RegionMasterDAO.getCityList();
				                             	if(cityList != null){
				                             	for(CityModel item : cityList){
					        				 %>
					      					<option value="<%=item.getCITY_CODE()%>" data-key1 ='<%=item.getSTATE_NAME() %>' data-key2 ='<%=item.getZONE_NAME()%>'><%=item.getCITY_NAME()%></option>
											<%
								               j++;
								         	   } 
				                               }
								 			%>
	                                </select>
	                                <span style="color: indianred; float: right;"> *</span>
	                                <div id="citySelect" class="invalid-feedback" style="display:none">Please Choose city name</div>
                                </div>
                                <div class="form-group">
                                    <label class="col-form-label" for="CITY_CODE">City Code</label>
                                    <input class="form-control" type="text"  id="CITY_CODE"  disabled>
                                </div>
                                <div class="form-group">
                                    <label class="col-form-label" for="ZONE_NAME">Zone Name</label>
                                    <input class="form-control" type="text"  id="ZONE_NAME"  disabled>
                                </div>
                                <div class="form-group">
                                    <label class="col-form-label" for="STATE_NAME">State Name</label>
                                    <input class="form-control" type="text" id="STATE_NAME" disabled> 
                                </div>
                                <div class="form-group">
                                    <label class="col-form-label" for="BRANCH_NAME">Branch Name</label>
                                     <select class="js-select2"  id="BRANCH_NAME" aria-hidden="true" name="BRANCH_NAME">
                                       <option selected="selected" value="-1" disabled>Choose Branch Name</option>
                                       <%
					           				    j = 1;
												List<BranchModel> branchList =  RegionMasterDAO.getBranchList();
				                             	if(branchList != null){
				                             	for(BranchModel item : branchList){
					        			%>
					      				<option value="<%=item.getBRANCH_CODE()%>"><%=item.getBRANCH_NAME()%></option>
										<%
								               j++;
								         	   } }
								 		%>
	                                </select>
	                                <span style="color: indianred; float: right;"> *</span>
	                                <div id="branchSelect" class="invalid-feedback" style="display:none">Please Choose branch name</div>
                                </div>
                                <div class="form-group">
                                    <label class="col-form-label" for="BRANCH_CODE">Branch Code</label>
                                    <input class="form-control" type="text"  id="BRANCH_CODE"  disabled>
                                </div>
                                <div class="form-group">
                                    <label class="col-form-label" for="IS_ACTIVE">IS ACTIVE</label>
                                    <select class="custom-select" name="IS_ACTIVE" id="IS_ACTIVE">
                                        <option value="Y">Yes</option>
                                        <option value="N">No</option>
                                    </select>
                                </div>
                                <div class="form-group row">
	                                <div class="col-sm-12 text-right">
	                                    <button type="button" id="regionButton"  class="btn btn-primary">Add Region</button>
	                                </div>
	                            </div>    
                                </div>
	                          </div>   
		                      <div class="table-responsive datatable-primary">
					    		  <table style="width:100%;"  id="dataTable" class="text-center">
		                           <thead class="text-uppercase">
		                           <tr>
                                   <th>Sno</th>
                                   <th>City ID</th>
                                   <th>City Name</th>
                                   <th>Branch ID</th>
                                   <th>Branch Name</th>
                                   <th>IS ACTIVE</th>
                                   <th>ACTION</th>
                                   </tr>
                                  </thead>
                                  <tbody id="RegionSubGrid">
                                  <tr></tr>
                                   </tbody>
		                           </table>
		                        </div>
		                       	   <div class="form-group row" style="margin-top:20px;">
	                                <div class="col-sm-12 text-right">
	                                    <button type="submit" id="Save" class="btn btn-primary">Submit</button>
	                                    <button type="button" class="btn btn-light cancel">Cancel</button>
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
   <jsp:include page="footer.jsp"></jsp:include>
   <jsp:include page="footerList.jsp"></jsp:include>    
<jsp:include page="ManpowerList.jsp"></jsp:include>
<script>
	$(function() {
		$('body').addClass('slim__theme');
	});
    $(document).ready(function() {
      $(".js-select2").select2();
      $(".js-select2-multi").select2();
    });
    $('.cancel').click(function(){
   	 	location.href ="RegionMasterList.jsp"; 
   	});
</script>
<script>
	$('#EMPLOYEE_NAME').change(function(){
		 var EMPLOYEE_ID =$("#EMPLOYEE_NAME").val();
		 $('#EMPLOYEE_ID').val(EMPLOYEE_ID);
		var designation = $(this).find('option:selected').data('key1');
		var department = $(this).find('option:selected').data('key2');
		var branchCode = $(this).find('option:selected').data('key3');
		$('#EMPLOYEE_DESIGNATION').val(designation);
		$('#EMPLOYEE_DEPARTMENT').val(department);
		$('#EMPLOYEE_BRANCH').val(branchCode);
		$('#EMPLOYEE_NAME-error').css('display','none');
		
	});
	$('#CITY_NAME').change(function(){
		var CITY_CODE =$("#CITY_NAME").val();
		 $('#CITY_CODE').val(CITY_CODE);
		var state = $(this).find('option:selected').data('key1');
		var zone = $(this).find('option:selected').data('key2');
		$('#STATE_NAME').val(state);
		$('#ZONE_NAME').val(zone);
		$('#citySelect').css('display','none');
		
	});
	$('#BRANCH_NAME').change(function(){
		var BRANCH_CODE =$("#BRANCH_NAME").val();
		 $('#BRANCH_CODE').val(BRANCH_CODE);
		 $('#branchSelect').css('display','none');
	});
</script>
<script>
	$('#regionButton').click(function(){
		var CITY_CODE = document.getElementById("CITY_NAME").value;
		var BRANCH_CODE = document.getElementById("BRANCH_NAME").value;
		  if (CITY_CODE ==-1) {
			  $('#citySelect').css('display','block');
			  return false;
		  }
		  if(BRANCH_CODE ==-1){
			  $('#branchSelect').css('display','block');
			  return false;
		  }
		 
	  else{
		  
		    $.ajax({
		         type:'post',
		         url : 'CheckBranch',
		         data : {BRANCH_CODE:BRANCH_CODE},
		         dataType : 'JSON',
		         success : function(result)
		         {
		         	if(result.status == 200){
	                    if(result.data==true){
	                    	alert("Branch Already Exist");
	                    }
	                    else{
	                    	add();	
	                    }
		         	}
		         }
		         
		     });
		}
	});
</script>
<script>
	function add(){
		var CITY_CODE = document.getElementById("CITY_NAME").value;
		var BRANCH_CODE = document.getElementById("BRANCH_NAME").value;
		var regionDatavalues = []; 
		$("#dataTable TBODY TR").each(function () {
		       var row = $(this);
		       var regionData= row.find("TD").eq(3).html(); 
		        regionDatavalues.push(regionData);
	
		    });
		    for (var i = 1; i < regionDatavalues.length; i++) {
		    if(regionDatavalues[i] == BRANCH_CODE){
		    	alert("Branch Already Exist");
		    	return false;
		    	}
		    }
		 var row_count = $('#RegionSubGrid tr').length;
		 var i=(row_count);
		 var Sno=i;
		 var CITY_NAME = document.getElementById("CITY_NAME");
		 var optCITY_NAME=CITY_NAME.options[CITY_NAME.selectedIndex].text;
		 var BRANCH_NAME = document.getElementById("BRANCH_NAME");
		 var optBRANCH_NAME=BRANCH_NAME.options[BRANCH_NAME.selectedIndex].text;
		 var IS_ACTIVE = document.getElementById("IS_ACTIVE").value;
		 var table=document.getElementById("dataTable");
		 var row=table.insertRow(-1);
		 var cell1=row.insertCell(0);
		 var cell2=row.insertCell(1);
		 var cell3=row.insertCell(2);
		 var cell4=row.insertCell(3);
		 var cell5=row.insertCell(4);
		 var cell6=row.insertCell(5);
		 var cell7=row.insertCell(6);
		 cell1.innerHTML=Sno;
		 cell2.innerHTML=CITY_CODE;
		 cell3.innerHTML=optCITY_NAME;
		 cell4.innerHTML=BRANCH_CODE;        
		 cell5.innerHTML=optBRANCH_NAME;
		 if(IS_ACTIVE=='Y'){
		 cell6.innerHTML="YES";}
		 else{cell6.innerHTML="NO";}
		 i++;
		 cell7.innerHTML= "<td>\r\n" + 
			"<ul class=\"d-flex justify-content-center\">\r\n" + 
			" <li class=\"mr-3\"><button type=\"button\" class=\"btn btn-inverse-danger delete\"><i class=\"ti-trash\"></i></button></li> \r\n" +
			"</ul>\r\n" + 
			"</td>";
			$('#BRANCH_NAME').select2("trigger", "select", {data: { id: -1, text: "Choose Branch Name"}});
		 $("#BRANCH_CODE").val("");
		 alert("You have added a new region, please click on submit button");
	}
</script>
<script>
	$(document).ready(function(){
		$("#getTable").on('click', function() {
			$('#EmpSearch').dataTable().fnClearTable();
			$('#EmpSearch').dataTable().fnDestroy();
			var tbranchCode = $('#tbranchCode').val();
			var tdesignation = $('#tdesignation').val();
			var tJobFun = $('#tJobFun').val();
			var tDepartment = $('#tDepartment').val();
			var NTID = $('#NTID').val();
			var Name = $('#Name').val();
			var data = [tbranchCode, tdesignation, tJobFun, tDepartment, NTID, Name];
			if(tbranchCode == null  && tdesignation== null  && tJobFun == null && tDepartment == null && NTID == "" && Name =="" ){
				$('#dispMessage').css('display','block');
			}
			else{
				$('#dispMessage').css('display','none');
		        $.ajax({
		            type:'post',
		            url : 'GetEmpSelectList',
		            data : {'tbranchCode':tbranchCode,'tdesignation':tdesignation,'tJobFun':tJobFun,'tDepartment':tDepartment, 'NTID':NTID, 'Name':Name},
		            dataType : 'JSON',
		            success : function(result){
		            	if(result.status == 200){
		            		$("#manpower-list-string").html("");
		            		$("#manpower-list-string").html(result.data);
		            		$("#EmpSearch").DataTable();
		            	} else {
		            		$("#manpower-list-string").html("");
		            	}
		            }
		        }); 
			}
		});
	});
</script>
<script>
	$("body").on("click", "#emp", function () {
		$tr=$(this).closest('tr');
		var row =$(this).closest('tr');
		var data=$tr.children('td').map(function(){
			return $(this).text();
		}).get();
			$("#select").click(function(){
			$("#dataTable2 TBODY TR").remove();
			$('#EMPLOYEE_NAME').select2("trigger", "select", {data: { id: data[2], text: data[4] }});
			$('#EMPLOYEE_ID').val(data[2]);
			$('#EMPLOYEE_DESIGNATION').val(data[7]);
			$('#EMPLOYEE_DEPARTMENT').val(data[9]);
			$('#EMPLOYEE_BRANCH').val(data[10]);
			$('#tbranchCode').select2("trigger", "select", {data: { id: -1, text: "Choose Branch Name"}});
			$('#tdesignation').select2("trigger", "select", {data: { id: -1, text: "Choose Designation"}});
			$('#tJobFun').select2("trigger", "select", {data: { id: -1, text: "Choose Job Function"}});
			$('#tDepartment').select2("trigger", "select", {data: { id: -1, text: "Choose Department Name"}});
			$('#NTID').val("");
			$('#Name').val("");
			$('#dispMessage').css('display','none');
			$('#EmpSearch').dataTable().fnClearTable();
			$('#EmpSearch').dataTable().fnDestroy();
		});
	});
</script>
<script>
	$( "#Save" ).click(function() {
		var a=$('#addRegion').valid();
		var row_count = $('#RegionSubGrid tr').length;
		    if(a==false){
		    return false;
		    }
		    if(row_count==1){
		    	alert("Please add city and branch");
		    	return false;
		    }
		 else{
		    var regionlist = new Array();
		    $("#dataTable TBODY TR").each(function () {
		        var row = $(this);
		        var regionData = {};
		        regionData.CITY_CODE = row.find("TD").eq(1).html();
		        regionData.BRANCH_CODE = row.find("TD").eq(3).html();
		        regionData.IS_ACTIVE = row.find("TD").eq(5).html();
		        regionlist.push(regionData);
		        
		    });
		    $( "form" ).submit(function( event ) {
		    	event.preventDefault();
		        url = "CreateRegionMaster";
		        var postData = $(this).serializeArray();
		        postData.push({name: 'data', value: JSON.stringify(regionlist)});
		        $.post(url, postData, function(result){
		        	if(result.status == 200){
		        		window.location = "RegionMasterList.jsp";
		        	} else {
		        		window.location = "RegionMasterList.jsp";
		        	} 
		        });
		        
		    });
		}
	});
</script>
<script>
	$("body").on("click", ".delete", function () {
		$tr=$(this).closest('tr');
		var row =$(this).closest('tr');
		var table = $("#dataTable")[0];
	    table.deleteRow(row[0].rowIndex);
	});
</script>
<script type="text/javascript">
	$('.modal').on('hidden.bs.modal', function(){
		$('#tbranchCode').val($('#tbranchCode option:first-child').val()).trigger('change');
		$('#tdesignation').val($('#tdesignation option:first-child').val()).trigger('change');
		$('#tJobFun').val($('#tJobFun option:first-child').val()).trigger('change');
		$('#tDepartment').val($('#tDepartment option:first-child').val()).trigger('change');
	    $('#NTID').val("");
		$('#Name').val("");
		$('#dispMessage').css('display','none');
		var dataTable = $('#EmpSearch').DataTable();
		dataTable.rows().remove().draw();
	});
	$("#reset").click(function(){
		$('#tbranchCode').select2("trigger", "select", {data: { id: -1, text: "Choose Branch Name"}});
		$('#tdesignation').select2("trigger", "select", {data: { id: -1, text: "Choose Designation"}});
		$('#tJobFun').select2("trigger", "select", {data: { id: -1, text: "Choose Job Function"}});
		$('#tDepartment').select2("trigger", "select", {data: { id: -1, text: "Choose Department Name"}});
		$('#NTID').val("");
		$('#Name').val("");
		$('#EmpSearch').dataTable().fnClearTable();
	});
</script>
</body>
</html>