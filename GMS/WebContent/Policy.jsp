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
            <div class="card">
				<div class="card textCard">
	              <div class="card-body">
	                <h1 class="text-center mb-4">TATA AIA LIFE INSURANCE COMPANY LTD.</h1>
	                <h4 class="mb-3">GENERAL GUIDELINES FOR ALL</h4>
	                <p class=" mb-4">All employees shall provide accurate details regarding their personal information and documents presented during the hiring process and employment.</p>
	                <p class=" mb-4">Employees should act with integrity, comply with the Code of Conduct, Anti Money Laundering Guidelines, Local laws, Company policies and maintain a professional work environment.</p>
	                <p class=" mb-4">All employees shall update their personal and family details (Name, and Contact number of immediate dependents) on EMPOWER.</p>
	                <p class=" mb-4">All employees should attend company orientation, Induction Process (Chrysalis).</p>
	                <p class=" mb-4">All employees are expected to be punctual, mark their attendance daily through different touchpoints like EMPOWER, Alt Worklife, Good Buddy, Talicnet, etc. Employees are expected to perform their job responsibilities by meeting specific goals set by the organization in accordance to the company standards, meant to ensure job sustainability, and by demonstrating respect and trustworthy behavior.</p>
	                <p class=" mb-4">Adhere to the guidelines under Work from Home.</p>
	                <p class=" mb-4">All Employees must ensure that their appearance is neat, clean, and appropriate for work as per company dress code policy and ensure their workspaces are clean, safe & hygienic. Further, all confidential material is locked in safe before leaving the office premises.</p>
	                <p class=" mb-4">Employees wishing to proceed on leave must inform their supervisors in adherence to the leave guidelines. Unavoidable absenteeism from work due to sickness or any other reason, the employee should notify their manager (or appropriate in charge) promptly (preferably before their regular starting time) and indicate their likely return to work.</p>
	                <p class=" mb-4">Every employee must use the company’s assets & infrastructure such as computers & communication systems, financial information, business strategy, technology, intellectual property, brands, trademarks, or any other non-public information appropriately, ethically, and in a secure manner.</p>
	                <p class=" mb-4">Employees shall keep the information of the following: pre-defined Internet logins, Intranet logins, NT Id, Passwords, salary, Performance Ratings, receiving incentives and remittance, confidential.</p>
	                <p class=" mb-4">Employee must claim all their expenses incurred towards official / business purpose within timelines along with all relevant supporting like documents like DSR, Prism, original and genuine bills related to Food, Lodging and Travel as per their eligibility mentioned in Travel policy.”</p>
	                <p class=" mb-4">The company recognizes and respects the right of every employee. Hence all employees are expected to maintain co-operation and healthy relations towards their work colleagues and superiors; without biases towards any sex, color, age, caste, religious, and national identity and are expected to treat everyone respectfully, and with dignity. Supervisors or senior employees must use a good tone while advising their subordinates.</p>
	                <p class=" mb-4">All employees are advised to behave lawfully, harmoniously, and orderly during company organized events or functions, shall demonstrate good behavior with colleagues’ wife or husband outside company premises or at company organized events or functions.</p>
	                <p class=" mb-4">All employees must treat colleagues with respect and dignity, especially female colleagues, and behave in such manner to provide them a safe and secure place for employment (Kindly refer to the Women Safety Policy ). The company has zero tolerance towards any ill-treatment or unwarranted behavior (verbal or Physical) with female colleagues and has a policy in place under The Sexual Harassment of Women at Workplace Act,2013.</p>
	                <p class=" mb-4">Consumption of tobacco, alcohol, smoking, or any substance abuse and possession of armament at the workplace, is strictly prohibited.</p>
	                <p class=" mb-4">All employees are expected to conduct duties in the best interest of the company acting within the code of conduct and must comply with the spirit of any applicable law.</p>
	                <p class=" mb-4">Be certain that a position held with TATA AIA is never used to obtain unauthorized, illegal, or questionable benefits/gifts of any kind that are offered by vendors, suppliers, organizations, customers, potential vendors, or any individual, no matter the value. Thereby ensuring, there is no conflict of interest.</p>
	                <p class=" mb-4">Each employee must report an actual or potential violation of this code of conduct or applicable laws to the Head - Human Resources or Company’s Ethics Officer.</p>
	                <p class=" mb-4">The company recognizes that customers, vendors, and other business partners play a crucial role in the success of the company. Hence all employees are expected to demonstrate the highest standards of ethics, honesty, integrity in their conduct, and maintain a cordial relationship at all times while representing the company, ensuring the brand value of the company protected.</p>
	                <p class=" mb-4">The company believes in doing things right, the first time, and has a First Time Right policy in place. Hence employees must provide customers with products matching their requirements, listing correct benefits of products, and ensure the policy is issued.</p>
	                <p class=" mb-4">All employees should ensure that the customers submit valid and authentic documents as per Company policy, including AML Policy (inter-alia Age proof, Income proof, residence proof, Photograph, KYC details any other documents supporting the Proposal Form) Any correction, overwriting, cancellation, use of whitener on the form should be avoided and, if required, should be countersigned by the customer.</p>
	                <p class=" mb-4">Ensure that all forms (i.e., Application form, Direct Debit Authorization form, Renewal ECS form, Health Declaration form, General Amendment Form, NEFT details) are filled completely (for ALL cases), signed by the Insured/ Proposer or both (if Insured & Proposer differ), and relevant proofs are submitted. Complete details disclosed should be captured in the application form. Existing insurance details opted with other insurance companies should be submitted.</p>
	                <p class=" mb-4">All employees are required to update customer’s personal and critical information (i.e., Mailing Residential address, Email Address, Mobile /Telephone numbers required for PSC and future communications, Education, Age, Income and Financial Evidences, Information regarding his/her personal or /and family health, habits, illnesses that are not visible/invisible, VPSC (Video Pre-Submission Call)) accurately. This also includes educating the customer that concealing information would impact in underwriting of the policy.</p>
	                <p class=" mb-4">For submission of NRI cases, check the customer’s country of residence (COR), and transact for selected countries only. Ensure the NRI Questionnaire is filled and signed by the insured and proposer. All documentation and sales process should be completed when the customer is in India, and relevant documents must be collected as per FATF guidelines.</p>
	                <p class=" mb-4">Employees should avoid engaging in any malpractices, including offering/accepting bribes or kickbacks or any other kind of improper/unwarranted payments, including paying premium on behalf of customer, demanding incentives from colleagues, sharing incentives, indulging in fraud, embezzling funds, indulging in any personal money transactions with fellow colleagues, vendors or suppliers.</p>
	
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