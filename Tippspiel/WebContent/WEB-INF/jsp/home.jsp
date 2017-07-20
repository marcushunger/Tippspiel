<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %> 
<my:base>
<jsp:body>

	<c:forEach items="${errors}" var="e">
	    <div class="alert alert-danger">${e.message }</div>
	</c:forEach>
	
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

	<h2>${hform.auswahlgruppe.bezeichnung}</h2>
	<table class="table table-hover">
		<thead>
			<tr>		
				<th>eMail</th>
				<th>Username</th>
				<th>Abweichungen</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${hform.listuser}" var="g">
			<td>${g.id}</td>
			<td>${g.email}</td>
			<td>${g.summe}</td>
			</c:forEach>
		</tbody>
		</table>

</jsp:body>
</my:base>