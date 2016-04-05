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
				url: 'update-password',
				data: frm,
				type: 'post',
				success: function(result){
					
					if(result=="updated")
						$("#message").html("Password updated");
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

			<h2>Change your password</h2> <br/>

			<div class="" style="width:70%">
				<div class="panel panel-default">
					<p class="panel-heading no-collapse">Administrator login</p>
					<div class="panel-body">
						<form id="frm">
							<div class="form-group">
								<label>New Password</label> <input type="password" name="password"
									class="form-control span12 form-control">
							</div>
							<div class="form-group">
								<label>Confirm Password</label> <input type="password" name="confirm_password"
									class="form-control span12 form-control">
							</div>
							<a href="" class="btn btn-primary pull-right">Update Password</a>
							<div class="clearfix"></div>
							<span id="message"></span>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>

</body>
</html>
