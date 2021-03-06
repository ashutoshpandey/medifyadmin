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
    
    $("input[name='type']").click(function(){
		$("#frm").submit();    	
    });
} );
</script>

</head>
<body class=" theme-blue">

	<jsp:include page="includes/header.jsp" />

	<jsp:include page="includes/menu.jsp" />

	<div class="content">
		<div class="main-content">

			<form id="frm" action="list-queries">
				<a href="list-queries?type=pending">Pending</a> &nbsp;&nbsp;&nbsp;
				<a href="list-queries?type=replied">Replied</a>
				<!--  
				<label><input type="radio" name="type" value="new" checked="checked"/> Pending</label> &nbsp;
				<label><input type="radio" name="type" value="old"/> Replied</label>
				-->
			</form>

			<br/>

			<h2>Listing Customer Queries</h2> <br/>

			<c:if test="${queries ne null}">

				<table id="grid" class="display" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Question</th>
							<th>By</th>
							<th></th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="query" items="${queries}">

							<tr>
								<td>${query.publicQuestion.problem}</td>
								<td>${query.patientDetail.patientName}</td>
								<td><a href="view-query?id=${query.publicQuestion.QUESTION_ID}" target="_blank">View</a></td>
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
