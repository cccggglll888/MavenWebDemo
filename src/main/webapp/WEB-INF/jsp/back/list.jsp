<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<%=basePath %>List.action" method="post">


this is jsp
<img alt="img" src="<%=basePath%>resources/img/img.jpg" height="100px" width="100px">

<div>cola:</div>
<input name="cola" type="text" value="${cola }" />
<button type="submit" >submit</button>



<c:forEach items="${tablealist}" var="tablea" varStatus="status">
	<c:if test="${status.index % 2 != 0 }">XXX</c:if>
	
	<p>${status.index + 1}</p>
	<p>${tablea.cola}</p>
	<p>${tablea.colb}</p>
	<p>${tablea.colc}</p>
	<p>${tablea.cold}</p>
	<hr>
</c:forEach>




</form>
</body>
</html>