<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${promoCode.startDate}" var="startDate" />
<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${promoCode.startDate}" var="endDate" />

<!doctype html>
<html lang="en">
<head>

<jsp:include page="includes/head_css_js.jsp" />

<script type="text/javascript">
$(function(){
	
	$(".btn").click(function(e){
		e.preventDefault();
		
		var frm = $("#frm").serialize();
		
		$.ajax({
			url: 'update-promo-code',
			data: frm,
			type: 'post',
			success: function(result){
				
				if(result=="updated")
					$("#message").html("Record updated!");
				else
					$("#message").html(result);
			}
		});
	});
});
</script>

</head>
<body class=" theme-blue">

	<jsp:include page="includes/header.jsp" />

	<jsp:include page="includes/menu.jsp" />

	<div class="content">
		<div class="main-content">

			<h2>Edit Promo Code</h2> <br/>

			<a href="list-promo-codes">Existing promo codes</a> <br/><br/>

			<div class="" style="width:70%">
				<div class="panel panel-default">
					<p class="panel-heading no-collapse">Edit this promo code</p>
					<div class="panel-body">
						<form id="frm">
							<div class="form-group">
								<label>Code</label> <input type="text" name="code"
									class="form-control span12" value="${promoCode.code}">
							</div>
							<div class="form-group">
								<label>Amount</label> <input type="text" name="amount"
									class="form-control span12 form-control" value="${promoCode.amount}">
							</div>
							<div class="form-group">
								<label>Start Date ( yyyy-mm-dd hh:mm )</label> <input type="text" name="startDate"
									class="form-control span12 form-control" value="${startDate}">
							</div>
							<div class="form-group">
								<label>End Date ( yyyy-mm-dd hh:mm )</label> <input type="text" name="endDate"
									class="form-control span12 form-control" value="${endDate}">
							</div>
							<div class="form-group">
								<label>Usage Count</label> <input type="text" name="usageCount"
									class="form-control span12 form-control" value="${promoCode.usageCount}">
							</div>
							<a href="" class="btn btn-primary pull-right">Update</a>
							<div class="clearfix"></div>
							<span id="message"></span>
						</form>
					</div>
				</div>
				<jsp:include page="includes/footer.jsp"/>
			</div>

		</div>
	</div>

</body>
</html>
