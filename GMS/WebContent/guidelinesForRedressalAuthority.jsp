<%@page import="com.gms.model.masters.ManpowerModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
 if (Manpower == null) {
        Manpower = new ManpowerModel();
        response.sendRedirect("login.jsp");
    } 
  %>
<head>
 <title>TATA AIA GMS</title>
     <jsp:include page="head.jsp"></jsp:include>
</head>
<div class="vz_main_sec">
	<jsp:include page="InvSidebar.jsp"></jsp:include>
    <jsp:include page="headerRedressalAuthority.jsp"></jsp:include>
    <div class="vz_main_container">
        <div class="vz_main_content">
    <div class="row">
        <div class="col-12">
            <div class="card">
				<div class="card textCard">
	              <div class="card-body">
	                <h1 class="text-center mb-4">TATA AIA LIFE INSURANCE COMPANY LTD.</h1>
	                <h4 class="mb-3">General Guidelines for Redressing Authority</h4>
	                <p class=" mb-4">The Grievance Redressing authority should take care of following aspects into consideration while redressing a grievance.</p>
	                <p class=" mb-4">Identify, prevent and address potential grievances/ concerns/problems before they become formal grievances.</p>
	                <p class=" mb-4">To develop a culture of trust and confidence with the subordinates/aggrieved employees.</p>
	                <p class=" mb-4">Redressing authority should Carefully Read/ listen to the grievance and acknowledge the facts and concerns raised by the employee. Listen carefully with sincere interest without interruption or arguments.</p>
	                <p class=" mb-4">Redressing authority should Gathering the information – all facts and figures.</p>
					<p class=" mb-4"> Always ensure that the managers involved in the grievance handling should conduct meeting with the complainant in a meeting room.</p>
					<p class=" mb-4"> Do use a positive, friendly ways to resolve the crisis than punitive steps, which disturb the system.</p>
					<p class=" mb-4"> Do remain calm, cool, collected during the meeting.</p>
					<p class=" mb-4"> Always focus on the subject of the grievance than allied issues.</p>
					<p class=" mb-4"> Don't become angry, belligerent, or hostile during grievance handling procedure.</p>
					<p class=" mb-4"> Do listen for the main point of submission/arguments and any possible avenue to resolve the grievance.</p>
					<p class=" mb-4"> Ensure effective, sensitive and confidential communication between all involved. </p>
					<p class=" mb-4"> The Redressal or decision maker acts impartially, which means they must exclude themselves if there is any bias or conflict of interest. </p>
					<p class=" mb-4"> Consider all relevant information in the investigation process.</p>
					<p class=" mb-4"> Try to get a better idea of whether the alleged discrimination or harassment shappened or didn't happen.</p>
					<p class=" mb-4"> They must Offering the best solution.</p>
					<p class=" mb-4"> Conduct the meeting in private.</p>
					<p class=" mb-4"> Maintain confidentiality of the concerns shared by the employee and should not retaliate.</p>
					<p class=" mb-4"> Provide a timeline for the solution and act within it – don’t delay.</p>
					<h4 class="mb-3">Timelines for respective redressing authority</h4>
	                <p class=" mb-4"><strong>Immediate Supervisor: - </strong> should answer the grievance within 48 hours</p>
	                <p class=" mb-4"><strong>Regional Head/RHR: - </strong> should answer the grievance within 3 days</p>
	                <p class=" mb-4"><strong>ZHR/Zonal Committee: - </strong> should answer the grievance within 7 days</p>
	                <p class=" mb-4"><strong>Central Committee: - </strong> should answer the grievance within 7 days</p>
	                <h4 class="mb-3">FOR CLARIFICATION AND SUPPORT PLEASE CONNECT WITH LOCAL HUMAN RESOURCES</h4>
	                <div class="form-group col-md-12 col-lg-12 text-right">
	                  <button type="button" class="btn btn-light" id="back" style="margin-top: 10px;">Back</button>
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
<script>
	 $('#back').click(function(){
			location.href ="DailyDairyUpdationList.jsp";			
	 });
</script>
</body>
</html>