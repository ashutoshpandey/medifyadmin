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
				url: 'update-doctor',
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

			<h2>Edit Doctor</h2> <br/>

			<div class="" style="width:70%">
				<div class="panel panel-default">
					<p class="panel-heading no-collapse">Editing doctor...</p>
					<div class="panel-body">
						<form id="frm">
							<div class="form-group">
								<label>First name</label> <input type="text" name="firstName" value="${doctor.firstName}"
									class="form-control span12">
							</div>
							<div class="form-group">
								<label>Last name</label> <input type="text" name="lastName" value="${doctor.lastName}"
									class="form-control span12 form-control">
							</div>
							<div class="form-group">
								<label>Last name</label> <input type="text" name="contactNumber" value="${doctor.contactNumber}"
									class="form-control span12 form-control">
							</div>
							<div class="form-group">
								<label>Last name</label> <input type="text" name="emailID" value="${doctor.emailID}"
									class="form-control span12 form-control">
							</div>
							<div class="form-group">
								<label>Gender</label><br/> <label><input type="radio" name="gender" value="male" checked="checked"> Male</label>
									<label><input type="radio" name="gender" value="female"> Female</label>
							</div>
							<div class="form-group">
								<label>Address</label> <input type="text" name="address" value="${doctor.address}"
									class="form-control span12 form-control">
							</div>
							<div class="form-group">
								<label>City</label> <input type="text" name="city" value="${doctor.city}"
									class="form-control span12 form-control">
							</div>
							<div class="form-group">
								<label>State</label> <input type="text" name="state" value="${doctor.state}"
									class="form-control span12 form-control">
							</div>
							<div class="form-group">
								<label>Country</label> <input type="text" name="country" value="${doctor.country}"
									class="form-control span12 form-control">
							</div>
							<div class="form-group">
								<label>Pin</label> <input type="text" name="zipCode" value="${doctor.zipCode}"
									class="form-control span12 form-control">
							</div>
							<a href="" class="btn btn-primary pull-right">Update Doctor</a>
							<div class="clearfix"></div>
							<span id="message"></span>
						</form>
					</div>
				</div>
				<p class="pull-right" style="">
					<a href="http://www.portnine.com" target="blank"
						style="font-size: .75em; margin-top: .25em;">Design by
						Portnine</a>
				</p>
				<p>
					<a href="reset-password.html">Forgot your password?</a>
				</p>
			</div>

		</div>
	</div>

</body>
</html>
