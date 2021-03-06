<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="modal fade show" id="hierarchyModal" style="display:none; padding-right: 17px;">       
    <div class="modal-dialog modal-xl modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title text-uppercase" id="rhr" style="display:none">SELECT RHR Redressal Authority</h5>
               <h5 class="modal-title text-uppercase" id="zlgc" style="display:none">SELECT ZLGC Redressal Authority</h5>
               <h5 class="modal-title text-uppercase" id="centCom" style="display:none">SELECT CENTCOM Redressal Authority</h5>
                <button type="button" class="btn btn-primary select" style="margin-left: auto; margin-right: 10px;">Submit</button>
   	            <button type="button" class="btn btn-light" id="cancel" data-dismiss="modal" >Cancel</button>
            </div>
      		<div class="modal-body">
				<div class="row">
                <div class="col-12">
                   <div class="card">
                       <div class="card-body">
                           <div class="table-responsive datatable-primary" style="display:none" id="RHR">
								<table style="width:100%;"  id="rhrDataTable" class="text-center">
                                     <thead class="text-uppercase">
                                        <tr>
                                        	<th scope="col">Select</th>
                                         	<th scope="col">Sno</th>
                                         	<th scope="col">RHR Redressal Authority ID</th>
                                         	<th scope="col">Region ID</th>
                                            <th scope="col">Region Name</th>
                                            <th scope="col">Redressal Authority Employee Name</th>
                                            <th scope="col">Redressal Authority Employee ID</th>
                                            <th scope="col">Redressal Authority Employee Designation</th>
                                            <th scope="col">Redressal Authority Employee Department</th>
                                            <th scope="col">Redressal Authority HR</th>
                                        </tr>
                                     </thead>
                                     <tbody id="rhr-list">
                                     </tbody> 
                               </table>
                             </div>
                             <div class="table-responsive datatable-primary" style="display:none" id="ZLGC">
                               <table style="width:100%;"  id="zlgcDataTable" class="text-center">
                                     <thead class="text-uppercase">
                                        <tr>
                                        	<th scope="col">Select</th>
                                         	<th scope="col">Sno</th>
                                         	<th scope="col">ZLGC Redressal Authority ID</th>
                                         	<th scope="col">Zone ID</th>
                                            <th scope="col">Zone Name</th>
                                            <th scope="col">Redressal Authority Employee Name</th>
                                            <th scope="col">Redressal Authority Employee ID</th>
                                            <th scope="col">Redressal Authority Employee Designation</th>
                                            <th scope="col">Redressal Authority Employee Department</th>
                                            <th scope="col">Redressal Authority HR</th>  
                                        </tr>
                                     </thead>
                                     <tbody id="zlgc-list">
                                     </tbody> 
                               </table>
                            </div>
                            <div class="table-responsive datatable-primary" style="display:none" id="CENTCOM">   
                               <table style="width:100%;"  id="centcomDataTable" class="text-center">
                                     <thead class="text-uppercase">
                                        <tr>
                                        	<th scope="col">Select</th>
                                         	<th scope="col">Sno</th>
                                         	<th scope="col">CC Redressal Authority ID</th>
                                         	<th scope="col">Redressal Authority Employee Name</th>
                                            <th scope="col">Redressal Authority Employee ID</th>
                                            <th scope="col">Redressal Authority Employee Designation</th>
                                            <th scope="col">Redressal Authority Employee Department</th>
                                            <th scope="col">Redressal Authority HR (Y/N)</th>
                                            
                                        </tr>
                                     </thead>
                                     <tbody id="centcom-list">
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
</div>