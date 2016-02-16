<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<title>Bookish -- Login</title>
<%@ include file="components/assets.jsp" %>
</head>
<body>
	<%@ include file="components/main_menu.jsp" %>
	<div class="container">
		<div class="row">
			<h3>Login</h3>
			<s:if test="loginerrors.size() > 0">
			<div class="col s12">
				<p>There were errors on this form. Required fields are outlined in red.</p>
			</div>
			</s:if>
		</div>
		<div class="row">
		<form method="post" action="${pageContext.request.contextPath}/process" class="col s12">
			<div class="row">
				<div class="col s12">
					<div class="input-field col s12">
						<s:if test="loginerrors.contains('username')">
						<input type="text" id="username" name="username" class="validate invalid" />
						</s:if>
						<s:else>
						<input type="text" id="username" name="username" class="validate" />
						</s:else>
						<label for="username">Username</label>
					</div>	
				</div>
			</div>
			<div class="row">
				<div class="col s12">
					<div class="input-field col s12">
						<s:if test="loginerrors.contains('password')">
							<input type="password" id="password" name="password" class="validate invalid" />
						</s:if>
						<s:else>
							<input type="password" id="password" name="password" class="validate" />
						</s:else>
						<label for="pass">Password</label>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col s12">
					<input type="submit" class="btn" value="Login" />
				</div>
			</div>
		</form>
		</div>
	</div>	
</body>
</html>