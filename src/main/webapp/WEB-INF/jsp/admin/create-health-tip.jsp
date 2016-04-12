<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>

<jsp:include page="includes/head_css_js.jsp" />

<script type="text/javascript">
	$(function(){
		
		$("#speciality").change(getDoctorsInSpeciality);
		
		getDoctorsInSpeciality();
		
		$(".btn").click(function(e){
			e.preventDefault();
			
			var frm = $("#frm").serialize();
			
			$.ajax({
				url: 'add-health-tip',
				data: frm,
				type: 'post',
				success: function(result){
					
					if(result=="created"){
						$("#message").html("Health tip created!");
						$("input[type='text']").val("");
						$("textarea").val("");
					}
					else
						$("#message").html(result);
				}
			});
		});
	});

	function getDoctorsInSpeciality(){
		
		var frm = "id=" + $("#speciality").val();
		
		$("#doctor").find('option').remove();
		
		$.ajax({
			url: 'get-doctors-in-speciality',
			data: frm,
			type: 'get',
			success: function(result){
				
				if(result.length>0){
					
					for(var i=0;i<result.length;i++){
						var doctor = result[i];
						
						var str = "<option value='" + doctor.id + "'>" + doctor.name + "</option>";
						
						$("#doctor").append(str);
					}
				}
			}
		});		
	}
	
</script>

</head>
<body class=" theme-blue">

	<jsp:include page="includes/header.jsp" />

	<jsp:include page="includes/menu.jsp" />

	<div class="content">
		<div class="main-content">

			<h2>Create Health Tip</h2> <br/>

			<a href="list-health-tips">Existing health tips</a> <br/><br/>

			<div class="" style="width:70%">
				<div class="panel panel-default">
					<p class="panel-heading no-collapse">Create a new health tip</p>
					<div class="panel-body">
						<form id="frm">
							<div class="form-group">
								<label>Speciality</label> 
								<select name="speciality.id" id="speciality" class="form-control">
									<c:forEach var="speciality" items="${specialities}">
										<option value="${speciality.id}">${speciality.displayName}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label>Doctor</label> 
								<select name="doctor.id" id="doctor" class="form-control"></select>
							</div>
							<div class="form-group">
								<label>Topic</label> <input type="text" name="topic"
									class="form-control">
							</div>
							<div class="form-group">
								<label>Content</label> <textarea name="content" class="form-control"></textarea>
							</div>
							<a href="" class="btn btn-primary pull-right">Create</a>
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
