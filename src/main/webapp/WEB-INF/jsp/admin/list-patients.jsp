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
$(document).ready(function() {
    $('#grid').DataTable();
    
    $(".remove-link").click(function(){
    	
    	if(confirm("Are you sure to remove this customer?")){
    		
    		var id = $(this).attr("rel");
    		
    		$.ajax({
    			url: 'remove-patient?id=' + id,
    			type: 'get',
    			success: function(result){
    				if(result=="removed")
    					location.reload();
    			}
    		});
    	}
    });
} );
</script>

</head>
<body class=" theme-blue">

	<jsp:include page="includes/header.jsp" />

	<jsp:include page="includes/menu.jsp" />

	<div class="content">
		<div class="main-content">

			<h2>Listing patients</h2> <br/>

			<c:if test="${patients ne null}">

				<table id="grid" class="display" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Name</th>
							<th>Email</th>
							<th>Contact Number</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="patient" items="${patients}">

							<tr>
								<td>${patient.patientName}</td>
								<td>${patient.email}</td>
								<td>${patient.mobileNo}</td>
								<td>
									<a href="view-patient?id=${patient.PATIENT_ID}" target="_blank">View</a>
								</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>

			</c:if>

			<jsp:include page="includes/footer.jsp"/>
		</div>
	</div>

</body>
</html>
