<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
    	
   		var id = $(this).attr("rel");
   		
   		$.ajax({
   			url: 'remove-promo-code?id=' + id,
   			type: 'get',
   			success: function(result){
   				if(result=="removed")
   					location.reload();
   			}
   		});
    });
} );
</script>

</head>
<body class=" theme-blue">

	<jsp:include page="includes/header.jsp" />

	<jsp:include page="includes/menu.jsp" />

	<div class="content">
		<div class="main-content">

			<h2>Listing Re-Schedule Requests</h2> <br/>

			<br/><a href="create-promo-code">Create new promo code</a><br/><br/>

			<c:if test="${promoCodes ne null}">

				<table id="grid" class="display" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Code</th>
							<th>Amount</th>
							<th>Date</th>
							<th>Usage Count</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="promoCode" items="${promoCodes}">

							<fmt:formatDate pattern="dd-MMM-yyyy" value="${promoCode.startDate}" var="startDate" />
							<fmt:formatDate pattern="dd-MMM-yyyy" value="${promoCode.endDate}" var="endDate" />

							<tr>
								<td>${promoCode.code}</td>
								<td>${promoCode.amount}</td>
								<td>${startDate} &nbsp;&nbsp;<b> To </b>&nbsp;&nbsp; ${endDate}</td>
								<td>${promoCode.usageCount}</td>
								<td>
									<a class="link edit-link" href="edit-promo-code?id=${promoCode.id}">Edit</a>&nbsp;&nbsp; <span class="link remove-link" rel="${promoCode.id}">Remove</span></td>
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
