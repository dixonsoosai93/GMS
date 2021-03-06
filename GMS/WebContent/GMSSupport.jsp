<%@page import = "java.io.File" %>
<%@page import = "com.gms.commons.Constants" %>
<%
String dirName = Constants.DOWNLOAD_PATH;
%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TATA AIA GMS</title>
    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link href="css/feather.css" rel="stylesheet"/>
    <link rel="stylesheet" href="css/slicknav.min.css">
    <script src="js/modernizr-2.8.3.min.js"></script>
    <link rel="stylesheet" href="css/metisMenu.css">
    <link rel="stylesheet" href="css/perfect-scrollbar.min.css">
    <link rel="stylesheet" href="css/slicknav.min.css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:100,200,300,400,500,600,700,800,900" rel="stylesheet">
</head>

<body class="slim__theme">
<div class="vz_main_sec">
	<jsp:include page="header.jsp"></jsp:include>
    <div class="vz_main_container1">
        <div class="vz_main_content" style = "background:none">
			<table id = "fileList" class = "table table-hover table-striped">
				<thead>
					<tr>
						<th width = 10%>Sr no</th>
						<th>File Name</th>
						<th width = 10%>Action</th>
					</tr>					
				</thead>
				<tbody>
					<% File filelist = new File(dirName);
						if(filelist.exists())
						{
							int i = 1;
							for(File item:filelist.listFiles())
							{
								if(item.isFile())
								{
					%>
									<tr>
										<td><%=i %></td>
										<td><%=item.getName() %></td>
										<td><a href = "#"><i class="fas fa-download pr-1"></i>Download</a></td>
									</tr>
					<%
									i++;
								}							
							}
						}
					%>
				</tbody>
			</table>
		
        </div>
    </div>
  <jsp:include page="footer.jsp"></jsp:include>
</div>
<script>
$(function(){
	$("#fileList").DataTable();
})
$("#fileList tbody tr").on("click","a",function()
	{
	let filename = $(this).parent().parent().children().eq(1).text();
	console.log(filename);
	let fileDir = $("#fileDir").val();
	window.location.href = "${pageContext.request.contextPath}/DownloadFile?filename=" + filename;	
	});
</script>
</body>
</html>