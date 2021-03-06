<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String success_message = (String)session.getAttribute("success-message"); 
	if(success_message != null && !success_message.isEmpty()) { 
		session.removeAttribute("success-message");
	} 
%>
<div class="swal2-container swal2-center swal2-fade swal2-shown danger-message"
	style="overflow-y: auto; display: none;">
	<div aria-labelledby="swal2-title" aria-describedby="swal2-content"
		class="swal2-popup swal2-modal swal2-show" tabindex="-1" role="dialog"
		aria-live="assertive" aria-modal="true" style="display: flex;">
		<div class="swal2-header">
			<div class="swal2-icon swal2-error swal2-animate-error-icon"
				style="display: flex;">
				<span class="swal2-x-mark"><span
					class="swal2-x-mark-line-left"></span><span
					class="swal2-x-mark-line-right"></span></span>
			</div>
			<h2 class="swal2-title" id="swal2-title" style="display: flex;">Error!</h2>
		</div>
		<div class="swal2-content">
			<div id="swal2-content" style="display: block;">Duplicate Entry
				Not Allowed.</div>
		</div>
		<div class="swal2-actions" style="display: flex;">
			<button type="button" class="swal2-confirm btn btn-danger"
				aria-label="">Dismiss</button>
		</div>
	</div>
</div>
<div class="swal2-container swal2-center swal2-fade swal2-shown success-message" style="overflow-y: auto; display: none;">
	<div aria-labelledby="swal2-title" aria-describedby="swal2-content" class="swal2-popup swal2-modal swal2-show" tabindex="-1" role="dialog" aria-live="assertive" aria-modal="true" style="display: flex;">
		<div class="swal2-header">
			
			<div class="swal2-icon swal2-success swal2-animate-success-icon" style="display: flex;">
				<div class="swal2-success-circular-line-left" style="background-color: rgb(255, 255, 255);"></div>
				<span class="swal2-success-line-tip"></span> 
				<span class="swal2-success-line-long"></span>
				<div class="swal2-success-ring"></div>
				<div class="swal2-success-fix" style="background-color: rgb(255, 255, 255);"></div>
				<div class="swal2-success-circular-line-right" style="background-color: rgb(255, 255, 255);"></div>
			</div>
			<h2 class="swal2-title" id="swal2-title" style="display: flex;">Success!</h2>
		</div>
		<div class="swal2-content">
			<div id="swal2-content" style="display: block;"><%=success_message %></div>
			
		</div>
		<div class="swal2-actions" style="display: flex;">
			<button type="button" class="swal2-confirm btn btn-success" aria-label="">OK</button>
			<button type="button" class="swal2-cancel" aria-label="" style="display: none;">Cancel</button>
		</div>
	</div>
</div>
<script type="text/javascript">
	<%
	if(success_message != null && !success_message.isEmpty()) { 
	%>
		$(document).ready(function() {
			$('#swal2-content').text('<%=success_message%>');
			$('.success-message').fadeIn();
		});
	<%
	}
	%>
	$(".swal2-confirm").click(function(){
	  $(".swal2-container").fadeOut();
	});
</script>
<script type="text/javascript">
	<% 
		String danger_message = (String)session.getAttribute("danger-message"); 
		if(danger_message != null && !danger_message.isEmpty()) { 
		session.removeAttribute("danger-message");
		%>
		$( document ).ready(function() {
		$('#swal2-content').text("<%=danger_message%>");
		$('.danger-message').fadeIn();
		});
		<% 
		} 
	%>
	$(".swal2-confirm").click(function(){
		  $(".swal2-container").fadeOut();
	});
</script>
	
	<link rel="stylesheet" href="data-table/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="data-table/css/jquery.dataTables.css">
    <link rel="stylesheet" href="data-table/css/responsive.bootstrap.min.css">
    <link rel="stylesheet" href="data-table/css/responsive.jqueryui.min.css">
	<script src="data-table/js/jquery.dataTables.js"></script>
	<script src="data-table/js/jquery.dataTables.min.js"></script>
	<script src="data-table/js/dataTables.bootstrap4.min.js"></script>
	<script src="data-table/js/dataTables.responsive.min.js"></script>
	<script src="data-table/js/responsive.bootstrap.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.4/moment.min.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/plug-ins/1.10.21/sorting/datetime-moment.js"></script>
	<script src="js/init/data-table.js"></script>
	
