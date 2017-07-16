<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="my" tagdir="/WEB-INF/tags" %> 


 <my:base>
	<jsp:attribute name="title">
	Person List
	</jsp:attribute>
	<jsp:attribute name="headline">
	Übersicht über die User
	</jsp:attribute>
	<jsp:body> 
		<table class="table table-hover">
		<thead>
			<tr>		
				<th><fmt:message key="i18n.email"/></th>
				<th><fmt:message key="i18n.email"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${personlist}" var="p">
				<tr>
					<td><a href="<c:url value="/register.html?id=${p.id}"/>">${p.email}</a></td>
					<td><a href="<c:url value="/register.html?id=${p.id}"/>">${p.username}</a></td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
		<table class="table table-hover">
		<thead>
			<tr>		
				<th><fmt:message key="GruppenId"/></th>
				<th><fmt:message key="Bezeichnung"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${gruppenlist}" var="g">
				<tr>
					<td><a href="<c:url value="/register.html?id=${g.id}"/>">${g.id}</a></td>
					<td><a href="<c:url value="/register.html?id=${g.id}"/>">${g.bezeichnung}</a></td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
	</jsp:body>
</my:base>