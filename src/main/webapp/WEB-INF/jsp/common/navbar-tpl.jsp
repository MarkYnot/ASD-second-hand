<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<div class="navbar navbar-default el-navbar">
	<div class="container">
		<div class="navbar-header">
			<a href="/">
				<img alt="Brand" src="/images/logo.png">
			</a>
		</div>
		<ul class="nav navbar-nav">
			<li id="index"><a href="/index.do">é¦é¡µ</a></li>
			<li id="invest"><a href="/invest.do">æè¦æèµ</a></li>
			<li id="borrow"><a href="/borrow.do">æè¦åæ¬¾</a></li>
			<li id="personal"><a href="/personal.do">ä¸ªäººä¸­å¿</a></li>
			<li><a href="#">æ°ææå¼</a></li>
			<li><a href="#">å³äºæä»¬</a></li>
		</ul>
	</div>
</div>

<#if currentNav??>
<script type="text/javascript">
	$("#"+"${currentNav}").addClass("active");
</script>
</#if>