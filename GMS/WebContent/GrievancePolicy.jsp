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
    <nav class="vz_navbar navbar-collapsed">
	        <div class="navbar-wrapper">
	            <div class="navbar-content scroll-div">
	                <div class="vz_navigation">
	                    <ul class="sidebar nav flex-column">
	                        <li class="active"><a class="nav-link text-center" href="EmployeeGLP.jsp" data-nav="staffConduct"><span>Employee Grievance</span></a></li>
	                    </ul>
	                </div>
	            </div>
	        </div>
	    </nav>
    <jsp:include page="headerEmployeeGrivence.jsp"></jsp:include>
    <div class="vz_main_container">
        <div class="vz_main_content">
    	<div class="row">
        	<div class="col-12">
	            <div class="card textCard textCard2">
	              <div class="card-body">
	                <h1 class="text-center mb-4">TATA AIA LIFE INSURANCE COMPANY LTD.</h1>
	                <h4 class="mb-3 text-uppercase">Employee Grievance Handling Policy</h4>
	                <ul class="listing1">
	                  <li>
	                    <h5>CONTEXT</h5>
	                    <p>We are committed to ensuring a positive and effective working environment where people are treated fairly and with respect, in line with our values. We recognise that there may be occasions where employees may have concerns about their work, working environment, relationships with their colleagues or behaviour of others towards them. We encourage employees to resolve issues mutually in the first instance through discussions with their Immediate Supervisor. If an employee feels unable to approach their Supervisor directly. Where attempts to resolve the matter mutually have been unsuccessful or if the matter is so serious, it may be appropriate for a formal grievance to be raised under this policy. We are committed to ensuring that employees have an opportunity to raise concerns relating to their employment and that matters are dealt with efficiently and effectively.</p>
	                  </li>
	                  <li>
	                    <h5>​DEFINITIONS:</h5>
	                    <ul class="listing2">
	                      <li>
	                        <p><span>Central Grievance Committee:</span> is the Representative from central office, Head Employee relation, HR representative. Committee responsible for redressing the grievances which cases are failed to resolve under Regional/Zonal grievance committee.</p>
	                      </li>
	                      <li>
	                        <p><span>Employee:</span> Employee means a person wholly or principally employed, with Tata AIA and includes an apprentice, but does not include Agents or Intermediators.</p>
	                      </li>
	                      <li>
	                        <p><span>Grievance:</span> We define grievance as any complaint, concern related to work or the work environment, regarding their workplace, job or co-Employee relationships. It may be about an act or expression of arrived feeling arising out of anything connected with the company, any discontent or dissatisfaction, omission, situation, or decision that the Employee thinks to be unfair, discriminatory, or unjustified or inequitable.<br><strong>It does not include</strong>: Staff conduct, POSH Issue and Day to day general employment queries which are handled by HR Administrative like delaying in salary, attendance not marked, notice period waive off or reduction in Notice period etc.</p>
	                      </li>
	                      <li>
	                        <p><span>Regional Grievance Committee:</span> Representative Constituting of the Regional committee.</p>
	                        <ul class="listing3">
	                          <li>Senior most Resource from the Region /Location of the respective channel.</li>
	                          <li>Regional HR Resources</li>
	                          <li>Regional Support</li>
	                          <li>Committee shall consist of equal number of members representing the supervisors and the subordinates. The chairperson of the committee shall be selected by Human Resources The total number of members of the Grievance Redressal Committee shall not exceed ten.</li>
	                        </ul>
	                      </li>
	                      <li>
	                        <p><span>Zonal Grievance Committee:</span> Constitution of Zonal Committee.</p>
	                        <ul class="listing3">
	                          <li>HOD / Zonal Business Head of the function that the employee is from</li>
	                          <li>Zonal HR Head</li>
	                          <li>Zonal Ops Head</li>
	                          <li>Any other Senior Resource</li>
	                        </ul>
	                        <p>Selection would be done by the Zonal HR Head. Committee shall consist of equal number of members representing the supervisors and the subordinates. The chairperson of the committee shall be selected by Human Resources The total number of members of the Grievance Redressal Committee shall not exceed ten.</p>
	                        <p><span>Supervisor:</span> means who is employed in a supervisory capacity either by the nature of duties attached to the office or by reason of the power vested in him, function mainly of managerial nature. Authority granted the person who’s handling grievance in First step under the Grievance Redressal Process.</p>
	                      </li>
	                    </ul>
	                  </li>
	
	                  <li>
	                    <h5>SCOPE</h5>
	                    <p>This Policy and supporting procedures apply to all employees and are designed to ensure that the approach to dealing with grievances is fair and consistent. The Policy will not cover matters of Employment that has a separate appeals process through other established Policies. I.e. Staff Conduct and POSH.</p>
	                    <p>The initial approach to settling any issue is open communication. Employees are encouraged to speak with their Supervisor to resolve their problems. An employee should first seek to resolve any grievance with his/her immediate supervisor through discussion.  If such discussion does not resolve the matter and the employee believes that his/her concerns rises to the level of a grievance, then the employee may initiate a grievance as described in this policy in an effort to seek an equitable solution.</p>
	                    <p>There is no binding requirement to deal with grievances raised by ex-employees, however the organisation will consider a grievance raised by a former employee provided it is received within 100 days of the end of employment. This will not consider employees terminated on the grounds of Absconding / termination of any reason or disciplinary actions. Former employee can be use web base grievance application. The former employees should contact their respective Zonal HR. Post sharing his concern the zonal Hr will share link with him on is registered email address as per records. The former employee can raise his grievance through the link provided.</p>
	                    <p>Employees grievances may be grouped into Policy, working environment, supervision, work group and work organization.</p>
	                    <ul class="listing2">
	                      <li>
	                        <p><span>Grievance resulting from policies include:</span></p>
	                        <ul class="listing4">
	                          <li>Leave applications not approved/denied.</li>
	                          <li>Product and sales training not provided – can be raised within 30 days.</li>
	                          <li>Genuine Business Travel Claims not approved/ denied.</li>
	                          <li>Late working hour’s reimbursement</li>
	                          <li>Compensatory off not provided (Not Valid for Sales/MT Employees)</li>
	                          <li>Birthday / Wedding Anniversary not allowed to be utilised.</li>
	                          <li>Confirmation not done by supervisor thereby not able to take Vacation Leave.</li>
	                          <li>Aggrieved with Annual ratings – (Functional heads)</li>
	                          <li>Not released for interdepartmental position through IJP.</li>
	                          <li>Forced to work on declared mandatory holidays and Sundays.</li>
	                          <li>Administratively Women Safety concern – Late sitting.</li>
	                          <li>Medi-claim not settled.</li>
	                          <li>COCP – Mobile Corporate Plan.</li>
	                          <li>Dress Code Policy not adhered.</li>
	                        </ul>
	                      </li>
	                      <li>
	                        <p><span>Grievance resulting from working conditions include:</span></p>
	                        <ul class="listing4">
	                          <li>IT system Tab/ laptop not received within 15 days.</li>
	                          <li>Unsafe and Unhygienic conditions of work place.</li>
	                          <li>Disturbing office decorum by action/ noise /loud conversation.</li>
	                        </ul>
	                      </li>
	                      <li>
	                        <p><span>Grievance resulting from inter-personal factors include:</span></p>
	                        <ul class="listing4">
	                          <li>Poor relationships with team members, peers, colleagues and seniors.</li>
	                          <li>Leadership style of superiors perceived notion of favouritism, bias.</li>
	                          <li>Highhandedness – by leader/ partners / colleague</li>
	                          <li>Hostile working conditions – bullying, forced to do personal work.</li>
	                          <li>Misuse of position.</li>
	                          <li>Using Abusive language.</li>
	                          <li>Demeaning colleagues.</li>
	                          <li>Tagging unkindly pictures on any Social Media.</li>
	                        </ul>
	                        <p>If a grievance is filed, it will be evaluated, whether it shall be redressed under the Grievances policy or code of conduct/ disciplinary process and accordingly dealt with intimation to the aggrieved person.</p>
	                        <p><strong>This Grievance Policy shall not redress grievances related to separation/ termination /dismissal, demotion, suspension or other disciplinary measure executed under Code of Conduct &amp; POSH.</strong></p>
	                      </li>
	                    </ul>
	                  </li>
	                  <li>
	                    <h5>TIME LIMITATIONS</h5>
	                    <p>Any grievance shall be heard and redressed by respective concerned authority / representative / committee post receiving the concern/grievance through Grievance Management system within the stipulated time as mentioned in Grievance Process Flow Chart. Grievances should be resolved in 30 days.</p>
	                  </li>
	                  <li>
	                    <h5>GENERAL PRINCIPLE</h5>
	                    <p>We aim to provide a fair, equitable and productive work environment for all employees. This policy seeks to support the achievement of this goal by providing a transparent and consistent process for resolving grievances.</p>
	                    <p>Negotiated solutions will aim to address the key issues and be acceptable to all individuals or parties involved without ascribing blame, victimisation or discrimination. Complainants will not suffer any disadvantage, victimisation or discrimination as a result of raising a grievance, with minimum stress and maximum protection for all concerned.</p>
	                    <p>Every Supervisor and subordinate has a responsibility to comply with this policy and to treat everyone who works here with dignity and respect. Seeking redress of a trivial/ unimportant or vexatious/ annoying issue through a grievance procedure will not be tolerated and may result in disciplinary action.</p>
	                    <p>All employees have the right to:</p>
	                    <ul class="listing4">
	                      <li>Raise their concerns / grievances without fear of victimisation through GMS (Grievance Management system) be treated with respect and impartiality and provided with support throughout the process</li>
	                      <li>no undue delay in investigations and proceedings.</li>
	                    </ul>
	                    <p>It is the responsibility of all parties involved in a grievance to participate fully in the resolution process in good faith. Confidentiality must be respected and maintained at all times within the constraints of the need to fully investigate the matter, subject to any legal requirements for disclosure and consistent with the principles of natural justice.</p>
	                  </li>
	                  <li>
	                    <h5>MALICIOUS OR FALSE GRIEVANCE</h5>
	                    <p>All grievance is treated by seriously. It should therefore be noted that anyone found to be making a mischievous or malicious complaint we will have appropriate action taken against them, which may include disciplinary action.</p>
	                  </li>
	
	                  <li>
	                    <h5>GRIEVANCE PROCEDURE:</h5>
	                    <p class="stageNum"><span>Stage 1:</span> Aggrieved employee should put his grievance in writing on Grievance Management System (GMS), without unreasonable delay, and send it to his immediate Supervisor. If the grievance involves your immediate Supervisor, then he should send his grievance to a skip level senior Manager. Immediate supervisor should try to resolve any grievance as quickly as possible, he must redress the grievance within 48 hours from the receipt of grievance. If the resolution is provided and the aggrieved person is not satisfied, then it may proceed to next stage.</p>
	
	                    <p class="stageNum"><span>Stage 2:</span> If the grievant is not satisfied with the answer or does not receive the answer within 48 hours, he or she shall, then, present the grievance to the Regional Head of the Department and Regional Human Resources. He may accompany with Department colleague. Department head will arrange the meeting with grievant and discuss the grievance. The head must give his or her reply within three days of the presentation of the grievance. If grievance is heading toward redressal at this stage or due to some unexpected event redressal is getting delayed in such circumstances days for arriving at redressal can be extended to up to 2 days.</p>
	
	                    <p class="stageNum"><span>Stage 3:</span> If the aggrieved employee is still not satisfied with the decision of Regional Head of the Department and Regional Human Resources or does not response within the stipulated period, aggrieved employee may appeal the grievance to the Zonal Grievance Committee. Zonal Grievance Committee will arrange a meeting with aggrieved employee to redress the grievance. Zonal grievance committee will listen carefully and understand what is complaint with discussing the matter thoroughly. Zonal grievance committee shall undertake an investigation the grievance and identifying the facts.</p>
	                    <p>After investigation of the grievance, Regional grievance committee must give its recommendation in seven day. The Regional Department Head and Regional Human Resources must communicate the decision to the grievant employee. If grievance is heading toward redressal at this stage or due to some unexpected event redressal is getting delayed in such circumstances days for arriving at redressal can be extended to up to 5 days.</p>
	
	                    <p class="stageNum"><span>Stage 4:</span> If the employees is not satisfied either with the decision made by Zonal grievance committee or does not receive decision from the Zonal grievance committee, he/ she may appeal the to the Central grievance committee.</p>
	                    <p>Central grievance committee shall consider the matter and redress the issue. The decision of Central Grievance Committee shall be final. If Employee still not happy with outcome, he may have the right to appeal for arbitration revision of decision.</p>
	
	                    <p class="stageNum"><span>Stage 5:</span> If the employees does not agree with the decision of the Central grievance committee, He may make appeal his/her grievance to Head of Human Resources. Head of Human Resources have power as Arbitrator. He/she shall consider the appeal if justified The Head Human Resources will review the matter and convey the final decision to the aggrieved employee. Head of Human Resources decision will be final &amp; its final step in disposing of unsettle grievance.</p>
	                    <p>If the grievance against Zonal Head, then aggrieved employee shall present his grievance to Central Grievance Committee.</p>
	                    <p>If grievance related to Annual rating, it will be redressed directly by the Function Head.</p>
	                  </li>
	
	                  <li>
	                    <h5>POSSIBLE OUTCOMES:</h5>
	                    <p>The outcome will depend upon the nature of the grievance and the procedure followed to address the grievance. Where an investigation results in the finding that a person has engaged in misconduct, that person may be disciplined. The type and severity of disciplinary action will depend upon the nature of grievance and other relevant factors.</p>
	                    <p>The company may take a range of other non-disciplinary outcomes to resolve a grievance.</p>
	                    <ul class="listing4">
	                      <li>Training</li>
	                      <li>Counselling</li>
	                      <li>Requiring an apology or an undertaking that certain behaviour steps;</li>
	                      <li>Change work conditions.</li>
	                      <li>Reinstating a benefit that was denied; and/or</li>
	                      <li>Action of a Verbal caution, Written Mail Caution /Advisory, Warning letter or Transfer/ Separation.</li>
	                    </ul>
	                    <p>All the above decisions taken to redress the grievances shall be monitored closely by the respective grievance handling authority i.e. supervisor, department head Zonal Grievance committee etc.<br>Strict action would be taken if there are repeated grievances against any specific supervisor.</p>
	                    <p>Any action above warning letter will be dealt in sync with Staff Conduct process and Investigation Report with proper reasoning needs to be provided by the committee.
	                  </li>
	                  <li>
	                    <h5>CONFIDENTIALITY</h5>
	                    <p>The Reporting Manager/ HR /Grievance committee will endeavour to maintain confidentiality in relation to complaints received under this policy as far as reasonably possible. However, it may be necessary to speak with other employees to determine what happened, to afford fairness to those against whom the complaint has been made and to resolve the grievance.</p>
	                    <p>All employees who are involved in the grievance are required to maintain confidentiality including the employee who lodges a complaint. If the person breaches the confidentiality, he/she may be disciplined.</p>
	                  </li>
	                  <li>
	                    <h5>DECISIONS</h5>
	                    <p>The decisions of the Head Human Resources acting in capacity of Arbitrator shall be final in all escalated grievances.</p>
	                  </li>
	                  <li>
	                    <h5>GRIEVANCE PROCESS FLOW CHART</h5>
	                  </li>
	                </ul>
	                <div class="">
	                	<img src="images/grivPolicy.png" class="w-100" />
	                </div>
	                
	
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
<jsp:include page="footer.jsp"></jsp:include>
<script>
	$(document).ready(function() {
		$(".js-select2").select2();
		$(".js-select2-multi").select2();
	});
	$('#back').click(function(){
		location.href ="EmployeeGLP.jsp";			
	});
</script>
</body>
</html>