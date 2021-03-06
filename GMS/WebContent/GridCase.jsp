<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<div class="table-responsive datatable-primary">
	<table style="width:100%;"  id="gridCase" class="text-center">
		<thead class="text-uppercase">
			<tr>
				<th>Sno</th>
				<th>Case ID</th>
				<th>Hierarchy Code</th>
				<th>Hierarchy Order</th>
				<th>TAT Start Date</th>
				<th>TAT Actual End Date</th>
				<th>Redressal Authority Completed Status</th>
				<th>Current Active Heirarchy</th>
				<th>Status</th>
				<th>Redressal Authority Employee ID</th>
				<th>Redressal Authority Name</th>
				<th>TAT Buffer Days</th>
				<th>Remarks</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody id="grid_case">

		</tbody>
	</table>
</div>
<div class="form-group col-md-12 col-lg-12 text-right" style="margin-top: 20px;">
	<button type="submit" class="btn btn-primary" id="submit">Submit</button>
	<button type="button" class="btn btn-light" id="cancel">Cancel</button>
</div>