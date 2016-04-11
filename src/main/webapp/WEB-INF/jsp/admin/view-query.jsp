<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:if test="${query!=null}">

	<table>
		<tr>
			<td>Posted by</td>
			<td>${query.patientDetail.patientName}</td>
		</tr>
		<tr>
			<td>Problem</td>
			<td>${query.publicQuestion.problem}</td>
		</tr>
		<tr>
			<td>Posted date</td>
			<td>${query.publicQuestion.postedAt}</td>
		</tr>
		<tr>
			<td>Replied by</td>
			<td>${query.doctorInfo.name}</td>
		</tr>
		<tr>
			<td>Reply</td>
			<td>${query.publicQuestion.questionReply}</td>
		</tr>
	</table>

</c:if>
<c:if test="${query==null}">
	Invalid query
</c:if>

</body>
</html>