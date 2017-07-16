<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="my" tagdir="/WEB-INF/tags" %> 


 <my:base>
	<jsp:attribute name="title">
	Groups
	</jsp:attribute>
	<jsp:attribute name="headline">
	Gruppenmenü
	</jsp:attribute>
	<jsp:body> 
		<table class="table table-hover">
		<thead>
			<tr>		
				<th><fmt:message key="GruppenId"/>GruppenId</th>
				<th><fmt:message key="Bezeichnung"/>Bezeichnung</th>
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
		 <form class="form-signin" method="post" action="j_change_groups">
		
        <h2 class="form-signin-heading">Neue Gruppe</h2>
        <label for="inputBezeichnung" class="sr-only">Bezeichnung</label>
        <input type="text" name="j_bezeichnung" id="bezeichnung" class="form-control" placeholder="Name" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Gruppe anlegen</button>
      </form>
	</jsp:body>
</my:base>