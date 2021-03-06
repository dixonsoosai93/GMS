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
          <div class="col-lg-12">
            <div class="card textCard2 textCard2">
              <div class="card-body">
                <h1 class="text-center mb-4">STANDARD OPERATING PROCEDURE</h1>
                <h4 class="mb-3 text-center text-uppercase">HANDLING OF GRIEVNACES</h4>
                <div class="mb-4">
                  <h4 class="card_title text-center">-TABLE OF CONTENTS-</h4>
                  <div class="single-table">
                    <div class="table-responsive">
                      <table class="table table-bordered">
                        <thead class="text-uppercase">
                          <tr>
                            <th scope="col">Sr. N0</th>
                            <th scope="col">Contents</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <th scope="row">1</th>
                            <td>INTRODUCTION</td>
                          </tr>
                          <tr>
                            <th scope="row">2</th>
                            <td>GRIEVANCE APPROCHES</td>
                          </tr>
                          <tr>
                            <th scope="row">2.1</th>
                            <td>Resolving Grievance Mutually</td>
                          </tr>
                          <tr>
                            <th scope="row">2.2</th>
                            <td>Formal Redressal Mechanism</td>
                          </tr>
                          <tr>
                            <th scope="row">3</th>
                            <td>PRINCIPLE FOR HANDLING GRIEVNACE</td>
                          </tr>
                          <tr>
                            <th scope="row">4</th>
                            <td>GRIEVANCE HANDLING PROCEDURE</td>
                          </tr>
                          <tr>
                            <th scope="row">5</th>
                            <td>ROLES AND RESPONSIBILITIES</td>
                          </tr>
                          <tr>
                            <th scope="row">5.1</th>
                            <td>Supervisor/Department Head</td>
                          </tr>
                          <tr>
                            <th scope="row">5.2</th>
                            <td>Zonal Grievance Committee</td>
                          </tr>
                          <tr>
                            <th scope="row">5.3</th>
                            <td>Central Grievance Committee</td>
                          </tr>
                          <tr>
                            <th scope="row">6</th>
                            <td>RECORDS</td>
                          </tr>
                          <tr>
                            <th scope="row">7</th>
                            <td>MALICIOUS OR FALSE GRIEVNACE</td>
                          </tr>
                          <tr>
                            <th scope="row">8</th>
                            <td>CONFINDETIALITY AND DISCLOSER</td>
                          </tr>
                          <tr>
                            <th scope="row">91</th>
                            <td>GENERAL GUIDELINES FOLLWOWED DURING GRIEVANCE REDRESSAL</td>
                          </tr>
                          <tr>
                            <th scope="row">10</th>
                            <td>FRUEQANTLY ASKED QUESTION</td>
                          </tr>
                        </tbody>
                    	</table>
                    </div>
                  </div>
                </div>
                <ol class="listStyle1">
                  <li>
                    <h5>GUIDELINES /SOP FOR GRIEVANCE HANDLING</h5>
                    <p><strong>Preface</strong></p>
                		<p>It is necessary to distinguish a complaint from grievance. A grievance/ complaint is an indication of employee dissatisfaction.</p>
                		<p>Grievances are symptoms of conflicts in an organisation. Therefore, we should be concerned with both complaints and grievances, because both may be important indicators of potential problems within the workforce. Without a grievance procedure, management may be unable to respond to employee concerns since managers are unaware of them. Therefore, a formal grievance procedure is a valuable communication tool for the organization.</p>
                  </li>
                  <li>
                    <h5>GRIEVANCE APPROACHES</h5>
                    <p>The company recognises that formal grievances can be a stressful and upsetting experience for all parties involved, whether grievances are upheld or not. The purpose of the Grievance Procedure is to resolve issues in the workplaces quickly and fairly to minimise any stress caused during the process.</p>
                    <ol class="listStyle2">
                      <li>
                        <p><strong>Resolving Grievance Mutually</strong></p>
                        <p>Most grievances are best resolved mutually. If an employee has a complaint relating to their work, he/she should first speak to their line manager, or if the complaint relates to the line manager, then with skip level senior manager. The complaint does not need to be submitted in writing on system and it will not be recorded with Human Resources. At the meeting, both the employee and the manager will explore in confidence how the matter could be resolved mutually, and both parties will agree on any actions to be taken and dates by when actions will be taken.</p>
                        <p>A written note of the date and nature of the matter together with any agreed outcome should be kept in confidence by the manager and copied to the employee.</p>
                        <p>If the employees grievance is not getting redressed he can raise his grievance on system.</p>
                      </li>
                      <li>
                        <p><strong>Formal Redressal Mechanism</strong></p>
                        <p>At all times the grievance shall be dealt with as tactfully as possible and the requirements of confidentiality must be fully observed. If an employee wishes to raise a formal grievance, the employee should put their grievance in writing on GMS (Grievance Management System)/GRS( Grievance Redressal System). This written statement should set out clearly the nature of the grievance, with supporting evidence where appropriate. These grievances will be dealt as per the companies laid down policies.</p>
                      </li>
                    </ol>
                  </li>
                  <li>
                    <h5>PRINCIPLE’S FOR HANDLING GRIEVANCE</h5>
                    <p>The Grievance handling authority / Committee shall be responsible to ensure that grievances are dealt with effectively in accordance with the Grievance Procedures set out for the implementation of Grievance Handling Policy.</p>
                    <p>In doing so, the Committee shall adhere to the following principles. Take grievances seriously taking on board why the employee feels aggrieved, unhappy or dissatisfied,</p>
                    <ol class="listStyle3">
                      	<li>Establish whether the grievance needs to be resolved formally or informally.</li>
                      	<li>Choose an appropriate manager to deal with the grievance.</li>
						<li>Investigate the facts and surrounding circumstances, and showing the employees
						that this been done thoroughly and sensitively,</li>
						<li>Carry out a full investigation and gather all relevant evidence, sending it to the
						employee in advance of the meeting.</li>
						<li>Arrange the grievance meeting, inviting the employee.</li>
						<li>Actively look for a solution that will satisfy the employee, where practical, without
						causing disproportionate difficulty for the organization or the Employee’s
						colleagues,</li>
						<li>Provide feedback to the employee about what can, and cannot be done to resolve
						the grievance,</li>
						<li>Make sure accurate notes are taken throughout by a HR person.</li>
						<li>Give the employee the opportunity to explain the details of their grievance and
						what they would like the outcome to be.</li>
						<li>Adjourn the meeting consider the evidence before making a decision.</li>
						<li>Inform the employee in writing of the decision, explaining how and why the
						decision was reached.</li>
						<li>Notify the employee of their right to appeal against the outcome of the grievance
						procedure.</li>
						<li>Take necessary follow-up action.</li>
                    </ol>
                  </li>
                  <li>
                    <h5>GRIEVANCE HANDLING PROCEDUR</h5>
                    	<p>State the time, date and location of the hearing, and the attendees (the committee members who will hear the case, the relevant Human Resources Partner who will be in attendance, and a note taker, also in attendance);</p>
                   		<ul class="listStyleSQ">
                    		<li>Inform the employee that he or she has the right to be accompanied along with his colleague only at the hearing, and that Human Resources should be informed of the name of this work colleagues prior to the hearing;</li>
							<li>Ask whether any reasonable adjustments are required for either the employee or companion;</li>
							<li>Inform the employee that if they have any documentation they wish to use during the hearing, they should submit this, prior to the hearing, to Human Resources.</li>
 						</ul>
						<p>The hearing should be held without unreasonable delay after a grievance is received. If, for genuine reasons, either the employee, respondent, or witness cannot attend on the date of the hearing, the hearing will be postponed to another date and time within five working days of the original date.</p>
						<p>The grievance hearing can be adjourned at any stage during the proceedings if this appears necessary, for example, to investigate any claim made.</p>
						<p>Minutes of the hearing will state the nature of the grievance, what was decided and actions to be taken, and the reasons for the actions. A copy of the minutes will be given to the employee. The employee will be asked to check if the document is an accurate summary of the discussion and then sign it.</p>
						<p>Following the hearing, if the grievance is against another employee (the ‘respondent’), the committee must arrange to speak directly with the respondent to make them aware that they are the subject of a grievance. It is important this is done in person, where possible, due to the sensitivity of the matter and due to the potential distress this may cause. This should be followed up in writing to let them know a grievance has been submitted, enclosing all the evidence being considered and informing them of the time, date and location of a meeting where they can respond to the grievance against them. The respondent also has a right to be accompanied by a work colleague.</p>
						<p>The Grievance handling committee may wish to interview other employees about the grievance and this will be done through separate meetings. If interviews with others are to take place following the hearing, the employee should be informed of this and of when they might reasonably expect a decision.</p>
						<p>Where the grievance has been raised collectively (by more than one person), the above process may be followed for each individual employee who has raised the grievance. Equally, it may be appropriate for all employees to attend the hearing together; or for one person to be appointed “spokesperson” by the others depending on the nature of the grievance.</p>
						<p>After the Hearing the Grievance handling committee, where possible, within five working days of the hearing and any subsequent investigation, reply in writing to the employee advising of the outcome of the hearing, and of the right of appeal.</p>
	              </li>
                  <li>
                    <h5>ROLES AND RESPONSIBILITIES</h5>
                    <ol class="listStyle2">
                    	<li>
		                    <p><strong>Supervisor/ Department Head:</strong> Is the most important person as the grievance can be redressed at this stage. The supervisor shall act in the following manner to resolve the concerns:</p>
		                    <ul class="listStyleNm">
		                    	<li>Carefully listen to the grievance and acknowledging it.</li>
								<li>Gathering the information – all facts and figures.</li>
								<li>Offering the best solution.</li>
								<li>Follow up.</li>
								<li>Supervisor/ Department Head should execute the decision quickly, ignoring the fact, that it may or may not hurt the employees concerned. After implementing the decision, it would be ideally good to keep a follow-up must be there to ensure that the grievance does not reoccur.</li>
								<li>All the proceeding notes should be capture in GMS/ Grievance Redressal System</li>
							</ul>
						</li>
						<li>
		                    <p><strong>Regional and Zonal Grievance Committee:</strong> is responsible for handling the grievance which is unresolved with Department Head.</p>
		                    <ul class="listStyleNm">
		                    	<li>To advice the line people about the importance of sound grievance handling system and its implementation.</li>
								<li>To train staff people, especially the front-line supervisors, in effective grievance handling and in counselling skills.
								<li>To maintain records of activity of the grievance committee such as meeting held, action taken and implemented.
								<li>Committee shall in identifying the areas of improvement and taking the required actions.
								<li>HR should take notes of proceedings and should be capture in GMS/ Grievance Redressal System</li>
							</ul>
						</li>
						<li>
                 			<p><strong>Central Grievance Committee:</strong> Central grievance committee will be at the apex level of grievance redressal procedure. Central committee shall act as un Appellate Authority in case un employee is not satisfied with decision of the Zonal grievance committee and if the grievance related to against Zonal grievance committee.</p>
                 			<ul class="listStyleNm">
                 				<li>Committee shall develop the trust amongst employees in the organization </li>
								<li>Committee is responsible for handling all anonymous grievance as well as grievance raised against the management including the above manager.</li>
								<li>Result of the grievance should be prompt, well defined, simple and time bound.</li>
								<li>To take necessary follow up action, review the procedure, and if necessary, modify the existing procedure to suit the changing circumstances and to follow up individual cases of grievance settled and identify its effect on the concerned individual employee and its impact on other employee of the organization.</li>
								<li>Committee Shall responsible for formation of Zonal grievance committee and appointment of its chairperson.</li>
								<li>HR should take notes of proceedings and should be capture in GMS/ Grievance Redressal System</li>
							</ul>
						</li>
					</ol>
             	</li>
                  <li>
                    <h5>RECORDS</h5>
                    <p>The Committee should ensure that the following minimal set of records is kept for matters attended by the Committee. The Human Resources department shall be the responsible unit that ensures the filing and safekeeping of the records on system.</p>
                    <ul class="listStyleDS">
                    	<li>The nature of the grievance.</li>
                    	<li>Written grievance statement.</li>
                    	<li>Action taken with reasons for it to be taken.</li>
                    	<li>A written statement and all records shall be stored / captured on GMS/GRS.</li>
                    </ul>
                  </li>
                  <li>
                    <h5>MALICIOUS OR FALSE GRIEVANCE</h5>
                    <p>All grievance is treated by seriously. It should therefore be noted that anyone found to be making a mischievous or malicious complaint we will have appropriate action taken against them, which may include disciplinary action. Should a complaint not be upheld, this will not, of itself, be evidence of a malicious or mischievous complaint.</p>
                  </li>
                  <li>
                    <h5>CONFIDENTIALITY AND DISCLOSER</h5>
                    <p>Grievances are of a confidential nature and should be treated as such. Those against whom a grievance is made shall have a right to see and respond to statements made about them in a grievance. The person bringing the grievance has a right to see such responses. If confidentiality is broken by any party involved in the grievance, appropriate action could be taken against them as per company rules and regulation.</p>
                  </li>
                  <li>
                    <h5>GENERAL GUIDELINES FOLLWOWED DURING GRIEVANCE REDRESSAL</h5>
                    <p>The Grievance Managing Committee should take care of following aspects to develop a culture of trust and confidence upon the employees. It is the responsibility of Managers, Supervisors and Department representative to ensure that:</p>
		             <ul class="listStyleDS">
		             	<li>They identify, prevent and address potential problems before they become formal grievances;</li>
		             	<li>Any grievance is to be handled in the most appropriate manner at the earliest opportunity.</li>
		             	<li>Ongoing support and guidance is provided to all employees in relation to employment and communication issues.</li>
						<li>Conduct the meeting in private</li>
						<li>Listen carefully with sincere interest without interruption or arguments.</li>
						<li>Provide a timeline for the solution and act within it – don’t delay.</li>
						<li>Always ensure that the managers involved in the grievance handling procedures have a quiet place to meet with the complainant.</li>
						<li>Do use a positive, friendly ways to resolve the crisis than punitive steps, which disturb the system.</li>
						<li>Do remain calm, cool, collected during the meeting.</li>
						<li>Always focus on the subject of the grievance than allied issues.</li>
						<li>Be aware of the staff member's potential concerns to the possible repercussions of raising a grievance.</li>
						<li>Don't become angry, belligerent, or hostile during grievance handling procedure.</li>
						<li>Do listen for the main point of arguments and any possible avenue to resolve the grievance.</li>
						<li>Listen and respond sensitively to any distress exhibited by the employees.</li>
						<li>Ensure effective, sensitive and confidential communication between all involved.</li>
						<li>Take all possible steps to ensure that no victimization occurs as a result of the grievance being raised.</li>
						<li>The investigator or decision maker acts impartially, which means they must exclude themselves if there is any bias or conflict of interest.</li>
						<li>All parties are heard and those who have had complaints made against others are given an opportunity to respond.</li>
						<li>Consider all relevant information in the investigation process.</li>
						<li>Ask the employee their preferred resolution option, although it is important to make it clear that this may not be a possible outcome.</li>
						<li>Be aware of the limits of authority of the person who involved in the grievance handling procedures.</li>
						<li>If the manager feels that he/she is not the appropriate person (senior manager) to deal with the issue refer the complainant to the appropriate person as soon as possible.</li>
						<li>Try to get a better idea of whether the alleged discrimination or harassment happened or didn't happen.</li>
						<li>It is the responsibility of the Human Resources Department to ensure that: all managers, supervisors, employees and committee members are aware of their obligations and responsibilities in relation to communication and information sharing with their employees;</li>
		             </ul>
                  </li>
                  <li>
                    <h5>FREQUENTLY ASK QUESTION</h5>
                    <div class="faqList">
	                    <div class="countfaq">
	                    	<h3>What is the difference between the Grievance Procedure and other procedures such as the Disciplinary Procedure?</h3>
	                    	<p>Ans: - The aim of the Grievance Procedure is to resolve workplace issue and concerns, whereas the Disciplinary Procedure exists to manage misconduct.</p>
	                    </div>
	                    <div class="countfaq">
	                    	<h3>How do I raise a concern my grievance?</h3>
	                    	<p>Ans: It is good practice to first speak to your supervisor or line manager informally regarding your concern as soon as possible. There will be occasion where the grievance is not redressed informally, the employee can raise his grievance on GMS/ GRS.</p>
	                    </div>
	                    <div class="countfaq">
	                    	<h3>After redress, can the grievance be re-opened?</h3>
	                    	<p>Ans: No. In such situation, employee will have to lodge a fresh grievance giving reference of previous grievance.</p>
	                    </div>
	                    <div class="countfaq">
	                    	<h3>Can I bring someone to the meeting?</h3>
	                    	<p>Ans: -You can bring a work colleague or representative of a Staff Association to any formal meeting.</p>
	                    </div>
	                    <div class="countfaq">
	                    	<h3>What is the role of my work colleague or representative at the grievance meeting?</h3>
	                    	<p>Ans: They can put your case forward; sum up the grievance; respond on your behalf to any views expressed at the meeting; and confer with you. However, they cannot answer questions on your behalf.</p>
	                    </div>
	                    <div class="countfaq">
	                    	<h3>What happens if meeting cancel or committee members not available in the meeting?</h3>
	                    	<p>Ans. In such case the meeting will be rearranged to an agreed time or date normally within seven working days of the original date.</p>
	                    </div>
	                    <div class="countfaq">
	                    	<h3>Can I withdraw a formal grievance?</h3>
	                    	<p>Ans: Yes. Request must be given in writing the reason to Grievance committee members.</p>
	                    </div>
	                    <div class="countfaq">
	                    	<h3>Who will know that I have raised a problem or concern?</h3>
	                    	<p>Ans: Only those involved or who need to know. If the problem is to do with a colleague, they will be made aware of the issue.</p>
	                    </div>
	                    <div class="countfaq">
	                    	<h3>Can I log a grievance against entities which are outside of the company?</h3>
	                    	<p>Ans: Yes, only to the extent of partner and advisors. Grievance can be redress concerning work environment and work related issues.</p>
	                    </div>
	                    <div class="countfaq">
	                    	<h3>Will my grievance be handled confidentially?</h3>
	                    	<p>Ans: Yes.</p>
	                    </div>
	                    <div class="countfaq">
	                    	<h3>Can I edit/modify my grievance after it has been submitted?</h3>
	                    	<p>Ans: Yes, only if the essence of the original grievance is not altered.</p>
	                    </div>
	                  </div>
                  </li>
                </ol>
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
<style type="text/css">
	.faqList { counter-reset: section; margin-bottom: 0 0 15px; }
	.countfaq h3 {font-size: 18px; font-weight: bold; color: #000;}
	.countfaq h3::before {counter-increment: section;content: counter(section);display: inline-block; margin-right: 5px;width: 25px;}
	
	.listStyle1 { counter-reset: item; margin-bottom: 0 0 15px; }
	.listStyle1 > li {list-style: none;}
	.listStyle1 li h5::before {counter-increment: item;content: counters(item, "") ".";display: inline-block; margin-left: -25px;width: 25px;}
	
	.textCard2 p { text-align:justify; }
	.textCard2 ul, .textCard2 ol { margin: 0 0 20px 30px; }
	.textCard2 ul li, .textCard2 ol li { font-size: 14px; font-weight: 400; line-height: 25px; }
	.textCard2 h5 { margin: 0 0 15px; color: #000; }
	.listStyle3 li { margin:0 0 10px; }
	
	ul.listStyleNm li { list-style: lower-roman; margin:0 0 5px; }
	ul.listStyleDS li { list-style: disc; margin:0 0 5px; }
	ul.listStyleSQ li { list-style: square; margin:0 0 5px; }
<script>
	 $('#back').click(function(){
			location.href ="DailyDairyUpdationList.jsp";			
	 });
</script>
</body>
</html>