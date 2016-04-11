<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

Status = ${uploadStatus} <br/><br/>

<!--  
<c:if test="${recordStatusList ne null}">
	
	<hr/>
	
	<c:forEach var="x" items="${recordStatusList}">
	${x}
	</c:forEach>
	
</c:if>
-->

<c:if test="${statusCountList ne null}">

	<hr/>
	
	<c:forEach var="x" items="${statusCountList}">
	${x}
	</c:forEach>

</c:if>