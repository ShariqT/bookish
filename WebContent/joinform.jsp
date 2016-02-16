<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<title>Bookish -- Join Us</title>
<%@ include file="components/assets.jsp" %>
</head>
<body>
<%@ include file="components/main_menu.jsp" %>
<div class="container">
	<div class="row">
		<div class="col s12"><h3>Joining Bookish</h3></div>
		<p>We only need an email address and a password for you to begin using Bookish.</p>
		<s:if test="joinerrors.contains('dberror')">
			<p style="color:red"><s:property value="errormsg" /></p>
		</s:if>
	</div>
	<div class="row">
		<form action="joining" method="post" class="col s12">
			<div class="row">
				<div class="input-field col s12">
					<s:if test="joinerrors.contains('username')">
						<input id="username" type="text" name="username" value="${param['username']}" class="validate invalid" />
					</s:if>
					<s:else>
						<input id="username" type="text" name="username" value="${param['username']}" class="validate" />
					</s:else>
					<label for="username">Username</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12">
					<s:if test="joinerrors.contains('password')">
						<input id="password" type="password" name="password" class="validate invalid" />
					</s:if>
					<s:else>
						<input id="password" type="password" name="password" class="validate" />
					</s:else>
					<label for="password">Password</label>
				</div>
			</div>
			<input type="submit" class="btn" />
		</form>
	</div>
</div>
</body>
</html>