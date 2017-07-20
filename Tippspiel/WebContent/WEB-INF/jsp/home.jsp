<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %> 
<my:base>
<jsp:body>
	
<h3>Home</h3>
<form method="post" action="homegruppeuser.html">
<input type="hidden" name="showgroups" value="gruppenuseranzeigen">
<select name="gruppemitusern" id="gruppemitusern" class="form-control">
<option value="">Gruppe auswählen</option>
<c:forEach items="${hform.listgrupen}" var="h">
<option value="${h.id}">${h.bezeichnung}</option>
</c:forEach>
</select>
<br>	
<input type="submit" class="btn btn-lg btn-primary btn-block" value="Gruppe auswählen">
</form>
<c:forEach items="${hform.listgrupen}" var="g">
	<h2>${g.bezeichnung}</h2>
	<table class="table table-hover">
		<thead>
			<tr>		
				<th>eMail</th>
				<th>Username</th>
				<th>Punktzahl</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${g.user}" var="p">
				<tr>
					<td>${p.email}</td>
					<td>${p.username}</td>
					<td>${p.summe}</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
</c:forEach>
</jsp:body>
</my:base>