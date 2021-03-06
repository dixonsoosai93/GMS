<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gms.model.masters.HolidayMasterModel" %>
<%@ page import="com.gms.dao.masters.HolidayMasterDAO"%>
<%@ page import="java.util.List" %>
<%@ page import="com.gms.model.user.Admin" %>
<%@ page import="com.gms.commons.Common" %>
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
                           		<h4 class="card_title text-center text-uppercase mb-0">Holiday Master</h4>
                            </div>
                            <div class="btnPosi">
                            	<div class="rightpageBtn">
                            		<a style="position: relative;" href="#" data-toggle="modal" data-target="#exampleModalCenter">
										<span title="" data-toggle="popover"  data-trigger="hover" data-content="Add Holiday Master">
											<i class="fa fa-plus-circle"></i>
										</span>
									</a>
								</div>
							</div>
                          <div class="table-responsive datatable-primary">
			    			<table style="width:100%;"  id="dataTable2" class="text-center table" style="width:100%;">
                              <thead class="text-uppercase">
                                <tr>
                                    <th scope="col">Sno</th>
                                    <th>Holiday ID</th>
                                    <th>State ID</th>
                                    <th>State Name</th>
                                    <th>Holiday Date</th>
                                    <th>Day Of Week</th>
                                    <th>Holiday Description</th>
                                    <th>IS ACTIVE</th>
                                    <th>Created Date</th>
                                    <th class="sorting_none">Action</th>
                                  </tr>
                                </thead>
                                <tbody>
                                      <%
                                        int i=1;
                                        List<HolidayMasterModel> list= HolidayMasterDAO.getHolidayMaster();
                                        if(list !=null){
                                        	for(HolidayMasterModel item :list){
                                        %>
		                                <tr>
		                                  <td><%=i%></td>
		                                  <td><%=item.getHOLIDAY_ID()%></td>
		                                  <td><%=item.getSTATE_CODE()%></td>
		                                  <td><%=item.getSTATE_NAME()%></td>
		                                  <td><%=Common.StringToDate(item.getHOLIDAYDATE())%></td>
		                                  <td><%=item.getHOLIDAY()%></td>
		                                  <td><%=item.getHOLIDAYNAME()%></td>
		                                  <td><% if(item.getIS_ACTIVE().equalsIgnoreCase("Y")){ %>Yes<% } else { %>No <% } %></td>
		                                  <td><%=item.getDATE_CREATED()%></td>
		                                  <td>
		                                      <ul class="d-flex justify-content-center">
										         <li class="mr-3"><button type="button" class="btn btn-inverse-secondary edit" data-toggle="modal" data-target="#exampleModalCenter2"><i class="fa fa-edit"></i></button></li>
										         <li class="mr-3"><button type="button" class="btn btn-inverse-danger delete"  onclick='functionConfirm(this)' data-key="<%=item.getHOLIDAY_ID() %>"><i class="ti-trash"></i></button></li>   
                                              </ul>
		                                  </td>
										</tr>
										<%
										i++;
                                        	}}
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
           <form id="addHolidayMaster" action="CreateHolidayMaster" method="post">
              <div class="modal-header">
                <h5 class="modal-title">ADD HOLIDAY MASTER</h5>
              </div>
		      <div class="modal-body">
				<div class="form-group">
					<label class="col-form-label" for="STATE_CODE">SELECT STATE NAME</label>
					<select class="js-select2 form-control" name="STATE_CODE" id="STATE_CODE" aria-hidden="true">
						<option selected="selected" value="-1" disabled>Choose State Name</option>
						<%
	           			int j=1;
						List<HolidayMasterModel> holidayMaster =  HolidayMasterDAO.getState();
                       	if(holidayMaster != null){
                       	for(HolidayMasterModel item : holidayMaster){
	       				%>
	   					<option value="<%=item.getSTATE_CODE()%>"><%=item.getSTATE_NAME()%></option>
						<%
							j++;
						}}
				 		%>
  					</select>
  					<span style="color: indianred; float: right;"> *</span>
				</div>
				<div class="form-group">
					<label for="investigatorValidTill" class="col-form-label">HOLIDAY DATE</label>
                 	<input class="form-control datepicker" type="text"  id="HOLIDAYDATE" name="HOLIDAYDATE" readonly data-date-format="dd-mm-yyyy" placeholder="dd-mm-yyyy">
                	<span style="color: indianred; float: right;"> *</span>
                </div>
			    <div class="form-group">
					<label class="col-form-label" for="HOLIDAY">DAY OF WEEK</label>
                  	<input type="text" name="HOLIDAY" class="form-control" id="HOLIDAY" disabled>
                	<span style="color: indianred; float: right;"> *</span>
                </div>
                <div class="form-group">
                    <label class="col-form-label" for="HOLIDAYNAME">HOLIDAY DESCRIPTION</label>
                    <textarea class="form-control" name="HOLIDAYNAME" id="HOLIDAYNAME" placeholder="holiday description" required></textarea>
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
       <form id="editHolidayMaster" action="EditHolidayMaster" method="post">
          <div class="modal-header">
               <h5 class="modal-title">EDIT HOLIDAY MASTER</h5>
          </div>
          <div class="modal-body">
	             <div class="form-group">
	                  <label class="col-form-label" for="EHOLIDAYID">HOLIDAY ID</label>
	                   <input type="text" name="EHOLIDAYID" class="form-control" id="EHOLIDAYID" readonly required>
	              </div>
		          <div class="form-group">
						<label class="col-form-label" for="ESTATE_CODE">SELECT STATE NAME</label>
						<select class="js-select2 form-control" name="ESTATE_CODE" id="ESTATE_CODE" aria-hidden="true">
							<option  disabled>Choose State Name</option>
							<%
	           				int k=1;
								List<HolidayMasterModel> editHolidayMaster =  HolidayMasterDAO.getState();
                             	if(editHolidayMaster != null){
                             	for(HolidayMasterModel item : holidayMaster){
	        				%>
	      					<option value="<%=item.getSTATE_CODE()%>"><%=item.getSTATE_NAME()%></option>
							<%
				             k++;
				         	} 
                            }
				 			%>
  						</select>
  						<span style="color: indianred; float: right;"> *</span>
                   </div>
                  <div class="form-group">
                     <label for="EHOLIDAYDATE" class="col-form-label">HOLIDAY DATE</label>
                     <input class="form-control datepicker" type="text"  id="EHOLIDAYDATE" name="EHOLIDAYDATE" readonly data-date-format="dd-mm-yyyy" placeholder="dd-mm-yyyy">
                 	 <span style="color: indianred; float: right;"> *</span>
                 </div>
			     <div class="form-group">
                  <label class="col-form-label" for="EHOLIDAY">DAY OF WEEK</label>
                  <input type="text" name="EHOLIDAY" class="form-control" id="EHOLIDAY" disabled>
                 </div>
                 <div class="form-group">
                         <label class="col-form-label" for="EHOLIDAYNAME">HOLIDAY DESCRIPTION</label>
                         <textarea class="form-control" name="EHOLIDAYNAME" id="EHOLIDAYNAME" placeholder="holiday description" required></textarea>
                 		<span style="color: indianred; float: right;"> *</span>
                 </div>
                 <div class="form-group">
                  <label class="col-form-label" for="EIS_ACTIVE">IS ACTIVE</label>
                    <select class="custom-select" id="EIS_ACTIVE" name="EIS_ACTIVE">
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
	$(function(){
		$('body').addClass('slim__theme');
	});
	$('.edit').on('click',function(){
		$tr=$(this).closest('tr');
		var data=$tr.children('td').map(function(){
			return $(this).text();
		}).get();
		$('#EHOLIDAYID').val(data[1]);
		$('#ESTATE_CODE').select2("trigger", "select", {data: { id: data[2], text: data[3]}});
		$('#EHOLIDAYDATE').val(data[4]);
		$('#EHOLIDAY').val(data[5]);
		$('#EHOLIDAYNAME').val(data[6]);
		var status = data[7];
		if(status=="Yes"){
			$('#EIS_ACTIVE').val("Y");
		}else{
			$('#EIS_ACTIVE').val("N");
		}
	});
	var confirmBox = $("#confirm");
	function functionConfirm(e) {
		HOLIDAY_ID = $(e).data('key');
		 if(confirm("Are you sure to delete "+HOLIDAY_ID+"?")){
			 location.href ="DeleteHolidayMaster?HOLIDAY_ID="+HOLIDAY_ID;	
		 } else{
			 return false;
		 }
	}
</script>
<script type="text/javascript">
$('.datepicker').on('click',function(){
	$('.datepicker').on('change',function(){
	 	var date = $(this).datepicker('getDate');
	 	if(date!=null){
			 var holidayDate = new Date(date);
			 var day = holidayDate.getDay();
			 var weekday=new Array(7);
			 weekday[0]="Sunday";
			 weekday[1]="Monday";
			 weekday[2]="Tuesday";
			 weekday[3]="Wednesday";
			 weekday[4]="Thursday";
			 weekday[5]="Friday";
			 weekday[6]="Saturday";
	 	}
		 	var hol= $('#HOLIDAYDATE').val();
		 	if(hol!=""){
		 		$('#HOLIDAY').val(weekday[day]);
		 	}
		 	else{
		 		$('#EHOLIDAY').val(weekday[day]);
		 	}
 	});
});
</script>
<script>
    $(document).ready(function() {
      $(".js-select2").select2();
      $(".js-select2-multi").select2();
    });
</script>
<script type="text/javascript">
	$('.modal').on('hidden.bs.modal', function(){
	    $(this).find('form')[0].reset();
	    $("form").each(function(){
	        $(this).validate().resetForm();
	    });
	    $('#STATE_CODE').select2("trigger", "select", {data: { id: -1, text: "Choose State Name"}});
	});
//$("#GRVDATE").datepicker('setStartDate', 'now');
$('#HOLIDAYDATE').datepicker('setDate', 'now');
$("#HOLIDAYDATE").datepicker('setStartDate', 'now');
$("#EHOLIDAYDATE").datepicker('setStartDate', 'now');
</script>
</body>
</html>
