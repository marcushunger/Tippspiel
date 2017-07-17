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
		  <body>
	<c:forEach items="${errors}" var="e">
	${e.message }<br/>
	</c:forEach>


		<form method="post" action="j_change_groups">
			<input type="hidden" name="id" value="">
			
			<p><label for="bez">username</label><br/>
			<input type="text" name="bez" id="bez" value="Bezeichnung"></p>
			
			
		<p>* required</p>
		<input type="submit" class="btn btn-default" value="Gruppe Anlegen" name="groups">
		</form>
	</body>
</html>
	</jsp:body>
</my:base>