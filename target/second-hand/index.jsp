<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Hello ${session_user.email}

<div class="el-header" >
		<div class="container" style="position: relative;">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/index.jsp">HomePage</a></li>
				<li><a href="/register.jsp">Sign-up</a></li>
				<li><a href="/login.jsp">Sign-in</a></li>
				<li><a href="/mLab.jsp">mLab</a></li>
			</ul>
		</div>
	</div>
</body>
</html>