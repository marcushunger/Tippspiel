<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="my" tagdir="/WEB-INF/tags" %> 


 <my:base>
	<jsp:attribute name="title">
	Groups
	</jsp:attribute>
	<jsp:attribute name="headline">
	Gruppen
	</jsp:attribute>
	<jsp:body> 	
		  <body>
		  <div class="container">
    <div class="row">
<div class="col-sm-6">

	<div style="color: #FF0000;">${errors.message}</div>

		<h3>Neue Gruppe</h3>
		<form method="post" action="j_change_groups">
			<input type="hidden" name="id" value="">
			
			<p><label for="bez" class="sr-only">username</label><br/>
			<input class="form-control" type="text" name="bez" id="bez" value="Bezeichnung" placeholder="Gruppenname"></p>
	
		<input type="submit" class="btn btn-lg btn-primary btn-block" value="Gruppe Anlegen" name="groups">
		</form>
		</div>
		</div>
		
		<br>
		<table class="table table-hover">
		<thead>
			<tr>		
				<th>Gruppenid</th>
				<th>Gruppenname</th>
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
		</div>
	</body>
</html>
	</jsp:body>
</my:base>