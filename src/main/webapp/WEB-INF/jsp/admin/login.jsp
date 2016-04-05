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
				url: 'is-valid-admin',
				data: frm,
				type: 'post',
				success: function(result){
					
					if(result=="correct")
						location.replace("admin-section");
					else if(result=="wrong")
						$("#message").html("Invalid username or password");
					else
						$("#message").html(result);
				}
			});
		});
	});
</script>

</head>
<body class=" theme-blue">

	<div class="content">
		<div class="main-content">

			<h2>Administrator Login</h2> <br/>

			<div class="" style="width:70%">
				<div class="panel panel-default">
					<p class="panel-heading no-collapse">Administrator login</p>
					<div class="panel-body">
						<form id="frm">
							<div class="form-group">
								<label>Username</label> <input type="text" name="userName"
									class="form-control span12">
							</div>
							<div class="form-group">
								<label>Password</label> <input type="password" name="password"
									class="form-control span12 form-control">
							</div>
							<a href="" class="btn btn-primary pull-right">Login</a>
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
