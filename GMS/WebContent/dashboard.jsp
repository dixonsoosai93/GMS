<%@page import="com.gms.dao.dashboard.Graph"%>
<%@page import="com.gms.model.dashboard.Status"%>
<%@page import="com.gms.model.masters.ManpowerModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
 	if (Manpower == null) {
        Manpower = new ManpowerModel();
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TATA AIA GMS</title>
<jsp:include page="head.jsp"></jsp:include> 
</head>
<body class="slim__theme">
<div class="vz_main_sec">
		<jsp:include page="sidebar.jsp"></jsp:include>
		<jsp:include page="header.jsp"></jsp:include>
	    <div class="vz_main_container">
	        <div class="vz_main_content">
	        <h4 class="card_title px-2 text-center" style="background-color: #3E194B; color: white; ">GMS DASHBOARD</h4>
		        <div class="row">
		        	
		        	<div class="col-md-6">
			            <div class="form-group">
		                    <label class="col-form-label" for="days">Number of Day's</label>
		                    <select class="custom-select" name="days" id="days" >
		                        <option selected disabled>Please choose No. of days</option>
		                        <option value="7">7</option>
		                        <option value="30">30</option>
		                        <option value="90">90</option>
		                        <option value="180">180</option>
		                        <option value="270">270</option>
		                        <option value="365">365</option>
		                    </select>
		                </div>
		            </div>
		            <div class="col-md-6">
			            <div class="form-group">
		                    <label class="col-form-label" for="years">Year</label>
		                    <input type="text" class="form-control datepicker" id="datepicker" data-date-format="yyyy" placeholder="Please Choose Year"/>
		                </div>
		            </div>
		        </div>
	            <div class="row">
	                <div class="col-lg-6">
	                    <div class=" p-3 border mb-3">
	                        <div id="status"></div>
	                    </div>
	                </div>
	                <div class="col-lg-6">
	                    <div class=" p-3 border mb-3">
	                        <div id="zone"></div>
	                    </div>
	                </div>
                	<div class="col-lg-6">
	                    <div class=" p-3 border mb-3">
	                        <div id="quater"></div>
	                    </div>
	                </div>
	                <div class="col-lg-6">
	                    <div class=" p-3 border mb-3">
	                         <div id="satge" ></div>
	                     </div>
	                </div>
	                <div class="col-lg-6">
	                    <div class=" p-3 border mb-3">
	                        <div id="subCategory"> </div>
	                    </div>
	                </div>
	                <div class="col-lg-6">
	                    <div class=" p-3 border mb-3">
	                        <div id="departmentWise"> </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</div>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-more.js"></script>
<script src="vendors/highcharts/modules/exporting.js"></script>
<script src="vendors/highcharts/modules/export-data.js"></script>
<script src="vendors/highcharts/modules/accessibility.js"></script>
<script type="text/javascript">
	var dataValues = [];
	var chart1 = new Highcharts.chart('status', {
	    chart: {
	        type: 'column'
	    },
	    title: {
	        text: 'Current Status'
	    },
	    xAxis: {
	        type: 'category'
	    },
	    
	    yAxis: {
	        title: {
	            text: 'Total Grievance Count'
	        }
	    },
	    legend: {
	        enabled: false
	    },
	    plotOptions: {
	        series: {
	            borderWidth: 0,
	            dataLabels: {
	                enabled: true,
	                format: '{point.y:.0f}'
	            }
	        }
	    },
	
	    tooltip: {
	        headerFormat:'<span style="font-size:11px">{series.name}</span><br>',
	        pointFormat:'<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.0f}</b> of total<br/>'
	    },
 	    series: [
	        {	name: "Count",
	            colorByPoint: true,
	            data: dataValues
	        }
	    ]
	    
	});
</script>
<script type="text/javascript">
	var chart2 = new Highcharts.chart('zone', {
	    chart: {
	        type: 'column',
	        inverted: true
	    },
	    title: {
	        text: 'Zone'
	    },
	    xAxis: {
	        type: 'category'
	    },
	    yAxis: {
	        title: {
	            text: 'Total Grievance Count'
	        }
	    },
	    legend: {
	        enabled: false
	    },
	    plotOptions: {
	        series: {
	            borderWidth: 0,
	            dataLabels: {
	                enabled: true,
	                format: '{point.y:.0f}'
	            }
	        }
	    },
	
	    tooltip: {
	        headerFormat:'<span style="font-size:11px">{series.name}</span><br>',
	        pointFormat:'<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.0f}</b> of total<br/>'
	    },
	
	    series: [
	        {	name: "Count",
	            data: dataValues
	        }
	    ]
	    
	});
</script>
<script type="text/javascript">
	var chart3 = new Highcharts.chart('quater', {
	    chart: {
	        type: 'waterfall',
	        inverted: true
	    },
	    title: {
	        text: 'Quater Wise Griveance Count'
	    },
	    xAxis: {
	        type: 'category'
	    },
	    yAxis: {
	        title: {
	            text: 'Count'
	        }
	    },
	    legend: {
	        enabled: false
	    },
	    tooltip: {
	        pointFormat: '<b>{point.y}</b>'
	    },
	    series: [{
	        data: dataValues,
	        pointPadding: 0
	    }]
	});
</script>
<script type="text/javascript">
	var chart4 = new Highcharts.chart('satge', {
	    chart: {
	        type: 'pie'
	    },
	    title: {
	        text: 'Satge Wise Griveance Ressolved.'
	    },
	    tooltip: {
	        headerFormat: '',
	        pointFormat: '<span style="color:{point.color}">\u25CF</span><b>{point.name}</b><br/>' +
	            'Grievance Ressolved: <b>{point.y}</b><br/>'
	    },
	    series: [{
	        minPointSize: 10,
	        innerSize: '60%',
	        data: dataValues
	    }]
	});
</script>
<script type="text/javascript">
	var chart5 = new Highcharts.chart('subCategory', {
	    chart: {
	        type: 'column',
	        inverted: true
	    },
	    title: {
	        text: 'Category Wise Griveance'
	    },
	    xAxis: {
	        type: 'category',
	        labels: {
	            style: {
	                fontSize: '13px',
	                fontFamily: 'Verdana, sans-serif'
	            }
	        }
	    },
	    yAxis: {
	        min: 0,
	        title: {
	            text: 'Count'
	        }
	    },
	    legend: {
	        enabled: false
	    },
	    tooltip: {
	        pointFormat: '<b>{point.y}</b>'
	    },
	    series: [{
	        name: 'Count',
	        data: dataValues
	    }]
	});
</script>
<script type="text/javascript">
	var chart6 = new Highcharts.chart('departmentWise', {
	    chart: {
	        type: 'column'
	    },
	    title: {
	        text: 'Department Wise Grievance'
	    },
	    xAxis: {
	        type: 'category'
	    },
	    yAxis: {
	        title: {
	            text: 'Total Grievance Count'
	        }
	    },
	    legend: {
	        enabled: false
	    },
	    plotOptions: {
	        series: {
	            borderWidth: 0,
	            dataLabels: {
	                enabled: true,
	                format: '{point.y:.0f}'
	            }
	        }
	    },
	    tooltip: {
	        headerFormat:'<span style="font-size:11px">{series.name}</span><br>',
	        pointFormat:'<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.0f}</b> of total<br/>'
	    },
	    series: [
	        {	name: "Count",
	            colorByPoint: true,
	            data: dataValues
	        }
	    ]
	});
</script>
<script>
	$(document).ready( function(){
		var days = 7;
    	$.ajax({
			type : 'post',
			url : 'GetStatusData',
			data : {'days':days},
			dataType : 'JSON',
			success : function(result) {
				if(result.status == 200) {
					chart1.update({
			            series: [{name: "Count", colorByPoint: true, data: result.data}]
			          }, true, true);
				} else{
					window.location = "dashboard.jsp";
				}
			}
		});
    	return false;
	});
	
	$("#days").change(function() {
       	var days = $("#days").val();
    	$.ajax({
			type : 'post',
			url : 'GetStatusData',
			data : {'days':days},
			dataType : 'JSON',
			success : function(result) {
				if(result.status == 200) {
					chart1.update({
			            series: [{name: "Count", colorByPoint: true, data: result.data}]
			          }, true, true);
				} else{
					window.location = "dashboard.jsp";
				}
			}
		});
    	return false;
	});
</script>
<script>
	$(document).ready( function(){
		var days = 7;
		$.ajax({
			type : 'post',
			url : 'GetZoneData',
			data : {'days':days},
			dataType : 'JSON',
			success : function(result) {
				if(result.status == 200) {
					chart2.update({
						series: [{ name: "Count", data: result.data }]
					}, true, true);
				} else{
					window.location = "dashboard.jsp";
				}
			}
		});
		return false;
	});
	$("#days").change(function() {
       	var days = $("#days").val();
    	$.ajax({
			type : 'post',
			url : 'GetZoneData',
			data : {'days':days},
			dataType : 'JSON',
			success : function(result) {
				if(result.status == 200) {
					chart2.update({
						series: [{ name: "Count", data: result.data }]
					}, true, true);
				} else{
					window.location = "dashboard.jsp";
				}
			}
		});
    	return false;
	});
</script>
<script>
	$(document).ready( function(){
		var year = 2021;
		$.ajax({
			type : 'post',
			url : 'GetQuaterData',
			data : {'year':year},
			dataType : 'JSON',
			success : function(result) {
				if(result.status == 200) {
					chart3.update({
						series: [{ name: "Count", data: result.data }]
					}, true, true);
				} else{
					window.location = "dashboard.jsp";
				}
			}
		});
		return false;
	});
	$("#datepicker").change(function() {
       	var year = $("#datepicker").val();
       	console.log("year :"+year);
       	$.ajax({
			type : 'post',
			url : 'GetQuaterData',
			data : {'year':year},
			dataType : 'JSON',
			success : function(result) {
				if(result.status == 200) {
					chart3.update({
						series: [{ name: "Count", data: result.data }]
					}, true, true);
				} else{
					window.location = "dashboard.jsp";
				}
			}
		});
    	return false;
	});
</script>
<script>
	$(document).ready( function(){
		var days = 7;
		$.ajax({
			type : 'post',
			url : 'GetHierCodeData',
			data : {'days':days},
			dataType : 'JSON',
			success : function(result) {
				if(result.status == 200) {
					chart4.update({
						series: [{ name: "Count", data: result.data }]
					}, true, true);
				} else{
					window.location = "dashboard.jsp";
				}
			}
		});
		return false;
	});
	$("#days").change(function() {
       	var days = $("#days").val();
    	$.ajax({
			type : 'post',
			url : 'GetHierCodeData',
			data : {'days':days},
			dataType : 'JSON',
			success : function(result) {
				if(result.status == 200) {
					chart4.update({
						series: [{ name: "Count", data: result.data }]
					}, true, true);
				} else{
					window.location = "dashboard.jsp";
				}
			}
		});
    	return false;
	});
</script>
<script>
	$(document).ready( function(){
		var days = 7;
		$.ajax({
			type : 'post',
			url : 'GetSubCategoryData',
			data : {'days':days},
			dataType : 'JSON',
			success : function(result) {
				if(result.status == 200) {
					chart5.update({
						series: [{ name: "Count", color: '#8B0000' ,data: result.data }]
					}, true, true);
				} else{
					window.location = "dashboard.jsp";
				}
			}
		});
		return false;
	});
	$("#days").change(function() {
       	var days = $("#days").val();
    	$.ajax({
			type : 'post',
			url : 'GetSubCategoryData',
			data : {'days':days},
			dataType : 'JSON',
			success : function(result) {
				if(result.status == 200) {
					chart5.update({
						series: [{ name: "Count", color: '#8B0000' ,data: result.data }]
					}, true, true);
				} else{
					window.location = "dashboard.jsp";
				}
			}
		});
    	return false;
	});
</script>
<script>
	$(document).ready( function(){
		var days = 7;
		$.ajax({
			type : 'post',
			url : 'GetDepartmentData',
			data : {'days':days},
			dataType : 'JSON',
			success : function(result) {
				if(result.status == 200) {
					chart6.update({
						series: [{ name: "Count", data: result.data }]
					}, true, true);
				} else{
					window.location = "dashboard.jsp";
				}
			}
		});
		return false;
	});
	$("#days").change(function() {
       	var days = $("#days").val();
    	$.ajax({
			type : 'post',
			url : 'GetDepartmentData',
			data : {'days':days},
			dataType : 'JSON',
			success : function(result) {
				if(result.status == 200) {
					chart6.update({
						series: [{ name: "Count", data: result.data }]
					}, true, true);
				} else{
					window.location = "dashboard.jsp";
				}
			}
		});
    	return false;
	});
</script>
<script>
	$("#datepicker").datepicker( {
	    format: " yyyy", // Notice the Extra space at the beginning
	    viewMode: "years", 
	    minViewMode: "years"
	});
</script>
</body>
</html>
