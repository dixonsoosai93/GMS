<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.gms.model.masters.ComplaintEmpSelect"%>
<%@ page import="com.gms.model.masters.ManpowerModel"%>
<%@ page import="com.gms.model.masters.ALBranch"%>
<%@ page import="com.gms.model.masters.ALDesignation"%>
<%@ page import="com.gms.model.masters.ALJobFunction"%>
<%@ page import="com.gms.model.masters.ALDepartment"%>
<%@page import="com.gms.dao.masters.HrcMasterDAO"%>
<%@ page import="java.util.List" %>
<div class="modal fade show" id="exampleModalCenter" style="display:none; padding-right: 17px;">       
    <div class="modal-dialog modal-xl modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">MANPOWER LIST</h5>
	                <button type="button" class="btn btn-light" id="select" style="margin-left: auto; margin-right: 10px;" data-dismiss="modal" >Select</button>
    	            <button type="button" class="btn btn-light" id="cancel" data-dismiss="modal" >Cancel</button>
            </div>
      		<div class="modal-body">
				<div class="row">
                <div class="col-12">
                   <div class="card">
                       <div class="card-body">
                       		<form id="scManpowerPopup" action="" method="post">
                       			<div class="row align-items-end">
				                     <div class="form-group col-lg-3"  style="margin-bottom: auto;">
				            			<label class="col-form-label" for="NTID">NT ID</label>
				            			<input type="text" class="form-control" placeholder ="Enter NT ID" id="NTID" class="NTID">
				        			</div>
				        			<div class="form-group col-lg-3"  style="margin-bottom: auto;">
				            			<label class="col-form-label" for="Name">Name</label>
				            			<input type="text" class="form-control" placeholder ="Enter Name" id="Name" name="Name">
				        			</div>
				        			<div class="form-group col-lg-3">
	                                    <label class="col-form-label" for="tdesignation">Select Designation</label>
	                                    <select class="js-select2 res" id="tdesignation" name="tdesignation">
	                                        <option selected="selected" value="-1" disabled>Choose Designation</option>
	                                        <%
								 			int tl = 1;
	                                    	ComplaintEmpSelect filter =  HrcMasterDAO.getFilterList();
								 			List<ALDesignation> tDesignation =  filter.gettDesignation();
					     					if(tDesignation != null){
					          				for(ALDesignation item : tDesignation) { 
					        				%>
					        				<option value="<%=item.getDesignationCode()%>"><%=item.getDesignationName() %></option>
											<%
								             tl++;
								         	} }
								 			%>
	                                    </select>
	                                </div>
	                                <div class="form-group col-lg-3">
				            			<label class="col-form-label" for="tDepartment">Select Department</label>
				            			<select class="js-select2 res" id="tDepartment" name="tDepartment">
				             				<option selected="selected" value="-1" disabled>Choose Department Name</option>
					         		  		<%
					           				int td = 1;
					          				List<ALDepartment> tDepartment =  filter.gettDepartment();
					     					if(tDepartment != null){
					          				for(ALDepartment item : tDepartment) { 
					        				%>
					      					<option value="<%=item.getDepartmentCode() %>"><%=item.getDepartment() %></option>
											<%
								             td++;
								         	} }
								 			%>
				       					</select>
				        			</div>
				        			<div class="form-group col-lg-3">
				            			<label class="col-form-label" for="tJobFun">Select Job Function</label>
				            			<select class="js-select2 res" id="tJobFun" name="tJobFun">
				             				<option selected="selected" value="-1" disabled>Choose Job Function</option>
					         		  		<%
											int tj = 1;
								 			List<ALJobFunction> tJobFunction =  filter.gettJobFUnction();
					     					if(tJobFunction != null){
					          				for(ALJobFunction item : tJobFunction) { 
					        				%>
					      					<option value="<%=item.getJobFunctionCode()%>"><%=item.getJobFunction() %></option>
											<%
								             tj++;
								         	} }
								 			%>
				       					</select>
				        			</div>
				        			<div class="form-group col-lg-3">
				            			<label class="col-form-label" for="tbranchCode">Select Branch</label>
				            			<select class="js-select2 res" id="tbranchCode" name="tbranchCode">
				             				<option selected="selected" value="-1" disabled>Choose Branch Name</option>
								 			<%
								 			int ti = 1;
								 			List<ALBranch> tbranch =  filter.gettBranch();
					     					if(tbranch != null){
					          				for(ALBranch item : tbranch) { 
					        				%>
					      					<option value="<%=item.getBranchCode()%>"><%=item.getBranchName() %></option>
											<%
								             ti++;
								         	} }
								 			%>
				       					</select>
				        			</div>
				        			<a type="button" class="btn form-group btn-inverse-secondary ml-3" id="getTable" style="margin-bottom: 32px;"><i class="fa fa-search"></i></a>
                       				<button type="button" class="btn form-group btn-inverse-secondary ml-3" id="reset" style="margin-bottom: 32px;"><i class="fa fa-refresh"></i></button>
                       				<div id='dispMessage' class="invalid-feedback" style="display:none">Please Choose any of the above dropdown / Enter NTID or Name.</div>
                       			</div>
                       		</form>	
                           <div class="table-responsive datatable-primary">
								<table style="width:100%;"  id="EmpSearch" class="text-center">
                                     <thead class="text-uppercase">
                                        <tr>
                                        	<th scope="col" class="sorting_none">Choose Employee</th>
                                         	<th scope="col">S.No.</th>
                                         	<th scope="col">MANPOWER ID</th>
                                         	<th scope="col">TITLE</th>
                                            <th scope="col">NAME</th>
                                            <th scope="col">DOB</th>
                                            <th scope="col">GENDER</th>
                                            <th scope="col">DESIGNATION</th>
                                            <th scope="col">JOB FUNCTION</th>
                                            <th scope="col">DEPARTMENT</th>
                                            <th scope="col">BRANCH</th>
                                            <th scope="col">SUPERVISOR ID</th>
                                            <th scope="col">STATUS</th>
                                            <th scope="col">DATE</th>
                                        </tr>
                                     </thead>
                                     <tbody id="manpower-list-string">
                                     </tbody> 
                               </table>
                           </div>    
                       </div>
                   </div>
                </div>    
            </div>
            <jsp:include page="footerList.jsp"></jsp:include> 
            </div>    
        </div>     
    </div>     
</div>