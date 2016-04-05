<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
				url: 'update-specialty',
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

			<h2>Edit Specialty</h2> <br/>

			<a href="list-specialties">Existing specialties</a> <br/><br/>

			<div class="" style="width:70%">
				<div class="panel panel-default">
					<p class="panel-heading no-collapse">Editing specialty...</p>
					<div class="panel-body">
						<form id="frm">
							<div class="form-group">
								<label>Name</label> <input type="text" name="name" value="${specialty.name}"
									class="form-control span12">
							</div>
							<div class="form-group">
								<label>Display name</label> <input type="text" name="displayName" value="${specialty.displayName}"
									class="form-control span12 form-control">
							</div>
							<a href="" class="btn btn-primary pull-right">Update Doctor</a>
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
