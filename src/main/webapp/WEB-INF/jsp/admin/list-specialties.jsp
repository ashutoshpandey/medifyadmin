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
    	
    	if(confirm("Are you sure to remove this specialty?")){
    		
    		var id = $(this).attr("rel");
    		
    		$.ajax({
    			url: 'remove-specialty?id=' + id,
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

			<h2>Listing Specialties</h2> <br/>

			<br/><a href="create-specialty">Create new specialty</a><br/><br/>

			<c:if test="${found}">

				<table id="grid" class="display" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Name</th>
							<th>Display Name</th>
							<th></th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="specialty" items="${specialties}">

							<tr>
								<td>${specialty.specialityName}</td>
								<td>${specialty.displayName}</td>
								<td>
								<a class="link edit-link" href="edit-specialty?id=${specialty.id}">Edit</a>&nbsp;&nbsp; <span
									class="link remove-link" rel="${specialty.id}">Remove</span>
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
