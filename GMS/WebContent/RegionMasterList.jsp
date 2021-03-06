<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.gms.model.user.Admin" %>
<%@ page import="com.gms.model.masters.HdRegionModel" %>
<%@ page import="com.gms.dao.masters.RegionMasterDAO" %>
  <%@page import="com.gms.model.masters.ManpowerModel"%>
<% ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
 if (Manpower == null) {
        Manpower = new ManpowerModel();
        response.sendRedirect("login.jsp");
    }%>
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
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                        <h4 class="card_title text-center text-uppercase mb-0">Region Master</h4>
	                         <div class="btnPosi">
	                          	<div class="rightpageBtn">
	                          		<a style="position: relative;" href="#" id="addRegion">
									<span title="" data-toggle="popover" data-trigger="hover" data-content="Add Region Master">
										<i class="fa fa-plus-circle"></i>
									</span>
								</a>
							   </div>
							 </div>
                            <div class="single-table">
								<div class="table-responsive datatable-primary table_setp" id="regionDt">
							     	<table style="width:100%;"  id="dataTable" class="text-center mt-0 mx-0 w-100">
                                      	<thead class="text-uppercase">
                                            <tr>
                                            <th>Sno</th>
		                                    <th>Region ID</th>
		                                    <th>Region Code (TALIC)</th>
		                                    <th>Region Name</th>
		                                    <th>Region Description</th>
		                                    <th>Region HR - Employee ID</th>
		                                    <th>Region HR - Employee Name</th>
		                                    <th>IS ACTIVE</th>
		                                    <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <% 
                                        int i=1;
                                        List<HdRegionModel> list= RegionMasterDAO.getHdRegion();
                                        if(list !=null){
                                        	for(HdRegionModel item :list){
                                        %>
		                                <tr>
		                                  <td><%=i%></td>
		                                  <td class="regionId" style="text-decoration: underline;cursor: pointer;" data-id="<%=item.getREGION_ID()%>"><a data-toggle="popover" data-trigger="hover" data-content="Click on the Region ID to get the details"><%=item.getREGION_ID()%></a></td>
		                                  <td><%=item.getREGION_CODE()%></td>
		                                  <td><%=item.getREGION_NAME()%></td>
		                                  <td><%=item.getREGION_DESC()%></td>
		                                  <td><%=item.getEMPLOYEE_ID()%></td>
		                                  <td><%=item.getNAME()%></td>
		                                  <td><% if(item.getIS_ACTIVE().equalsIgnoreCase("Y")){ %>Yes<% } else { %>No <% } %></td>
		                                  <td>
		                                      <ul class="d-flex justify-content-center">
												 <li class="mr-3"><button type="button" class="btn btn-inverse-secondary edit" keys="<%=item.getREGION_ID()%>"><i class="fa fa-edit"></i></button></li> 
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
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            <div class="single-table">
								<div class="table-responsive datatable-primary table_setp">
								<div class="d-flex align-items-center mb-4">
	                                <div class="grid-col px-4 py-2 m-0"> Region ID </div>
	                                <div class="border px-4 py-2">
	                                    <input type=text id="dataId" size="2" disabled>
                                    </div>
                               </div>
							     	<table style="width:100%;"  id="xyz" class="text-center mt-0 mx-0 w-100">
                                      	<thead class="text-uppercase">
                                            <tr>
                                                <th>S.No</th>
												<th>Region Detail ID</th>
												<th>City ID</th>
												<th>City Name</th>
												<th>State Name</th>
												<th>Zone Name</th>
												<th>Branch ID</th>
												<th>Branch Name</th>
												<th>IS ACTIVE</th>
                                            </tr>
                                        </thead>
                                        <tbody id="region-dt">  
                                        </tbody>
                                    </table>
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
<script>
    $("#regionDt").on('click','.regionId', function() {
	        var REGIONID = $(this).data('id');
	        $("#dataId").val(REGIONID);
	        $.ajax({
	            type:'post',
	            url : 'GetRegionDt',
	            data : {REGIONID:REGIONID},
	            dataType : 'JSON',
	            success : function(result)
	            {
	            	if(result.status == 200){
	            		$("#region-dt").html(result.data);
	            		$("#xyz").DataTable();
	            	} else {
	            		$("#region-dt").html("");
	            	}
	            }
	        });  
    });
</script>
<script type="text/javascript">
 document.getElementById("addRegion").onclick = function(){
 location.href ="RegionMaster.jsp";
 };
 $(function() {
 $('body').addClass('slim__theme');
 });
</script>
<script>
$('.edit').click(function(){
	 var REGIONID= $(this).attr('keys');
	 location.href ="EditRegion.jsp?REGIONID="+REGIONID; 
	 });
</script>
<script type="text/javascript">
    $('.regionId').click(function () {
        $('html, body').animate({scrollTop:$(document).height()}, 'slow');
    });	
</script>
</body>
</html>
