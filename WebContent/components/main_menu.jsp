<%@ taglib prefix="s" uri="/struts-tags" %>
<nav>
	<div class="nav-wrapper">
		<a href="${pageContext.request.contextPath }/" class="brand-logo">Bookish</a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<s:if test="#session.LOGGEDIN != null">
				<li><a href=""><s:property value="#session.LOGGEDIN" /></a></li>
				<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
			</s:if>
			<s:else>
				<li><a href="${pageContext.request.contextPath}/login">Login</a></li>
				<li><a href="${pageContext.request.contextPath}/join">Join</a></li>
			</s:else>
		</ul>			
	</div>
</nav>