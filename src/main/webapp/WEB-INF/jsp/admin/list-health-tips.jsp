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
});
</script>

</head>
<body class=" theme-blue">

	<jsp:include page="includes/header.jsp" />

	<jsp:include page="includes/menu.jsp" />

	<div class="content">
		<div class="main-content">

			<h2>Listing Health Tips</h2> <br/>

			<br/><a href="create-health-tip">Create health tip</a><br/><br/>

			<c:if test="${healthTips ne null}">

				<table id="grid" class="display" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Doctor</th>
							<th>Specialty</th>
							<th></th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="healthTip" items="${healthTips}">

							<tr>
								<td>${healthTip.doctor.name}</td>
								<td>${healthTip.specialty.displayName}</td>
								<td><a href="view-health-tip" target="_blank">View</a></td>
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
