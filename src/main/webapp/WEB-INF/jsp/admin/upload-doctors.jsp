<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>

<jsp:include page="includes/head_css_js.jsp" />

<link type="text/css" rel="stylesheet"
	href="//cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" />
<script type="text/javascript"
	src="//cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
var uploading = false;
$(document).ready(function() {
    $('#grid').DataTable();
    
    $("#ifr").load(function(){
    	
    	if(uploading){
    		endUpload();
    	}
    });
    
    $(".remove-link").click(function(){
    	
    	if(confirm("Are you sure to remove this doctor?")){
    		
    		var id = $(this).attr("rel");
    		
    		$.ajax({
    			url: 'remove-doctor?id=' + id,
    			type: 'get',
    			success: function(result){
    				if(result=="removed")
    					location.reload();
    			}
    		});
    	}
    });
} );

function startUpload(){
	uploading = true;
	
	$("#message").html("Uploading...");
}

function endUpload(){
	$.ajax({
		url: 'upload-doctor-status',
		type: 'get',
		success: function(result){
			$("#message").html(result);
			
			uploading = false;
		}
	});
}
</script>

</head>
<body class=" theme-blue">

	<jsp:include page="includes/header.jsp" />

	<jsp:include page="includes/menu.jsp" />

	<div class="content">
		<div class="main-content">

		<h2>Upload doctors</h2><br/><br/>

		<form method="post" enctype="multipart/form-data" target="ifr" action="upload-doctors-now" onsubmit="startUpload()">
			Choose file : <input type="file" name="file" style="display:inline"/> &nbsp; <input type="submit" value="Upload"/>		
		</form>
		<iframe id="ifr" name="ifr" style="width:1px;height:1px;visibility:hidden"></iframe>
		<br/><span id="message"></span>

		<br/><br/>
		<a href="download-sample?file=sample.xls">Download sample file</a>

			<footer>
				<hr>

				<!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
				<p class="pull-right">
					A <a href="http://www.portnine.com/bootstrap-themes"
						target="_blank">Free Bootstrap Theme</a> by <a
						href="http://www.portnine.com" target="_blank">Portnine</a>
				</p>
				<p>
					© 2014 <a href="http://www.portnine.com" target="_blank">Portnine</a>
				</p>
			</footer>
		</div>
	</div>

</body>
</html>