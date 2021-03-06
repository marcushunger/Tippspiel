<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %> 

<my:base>
<jsp:body> 	
<h3>Gruppen</h3>
			
				<c:forEach items="${errors}" var="e">
	    			<div class="alert alert-danger">${e.message }</div>
				</c:forEach>
    			<div class="row">
					<div class="col-sm-6">
						<h4>Gruppe anlegen</h4>
						<form method="post" action="j_change_groups">
							<!-- <input type="hidden" name="id" value=""> -->
							<label for="bez" class="sr-only">Gruppenname</label>
							<input class="form-control" type="text" name="bez" id="bez" placeholder="Gruppenname">
							<select name="studiengang" id="studiengang" class="form-control">
								<option value="">Studiengang ausw�hlen</option>
								<c:forEach items="${gform.studiengaenge}" var="s">
								<option value="${s.id}">${s.bezeichnung}</option>
								</c:forEach>
							</select>
							<br>
							<input type="hidden" name="action" value="actionanlegen">
							<input type="submit" class="btn btn-lg btn-primary btn-block" value="Gruppe Anlegen" name="groups">
						</form>
					</div>
					<div class="col-sm-6">
						<h4>Gruppe beitreten</h4>
						<form method="post" action="j_change_groups">
							<input type="hidden" name="actiongruppe" value="gruppebeitreten">
							<select name="allegruppen" id="allegruppen" class="form-control">
								<option value="">Gruppe beitreten</option>
								<c:forEach items="${gform.allegruppen}" var="e">
								<option value="${e.id}">${e.bezeichnung}</option>
								</c:forEach>
							</select>
							<br>
							
							<input type="hidden" name="action" value="actionbeitritt">
							<input type="submit" class="btn btn-lg btn-primary btn-block" value="Gruppe Beitreten" name="groups">
						</form>
					</div>
				</div>
				<br>
				<table class="table table-hover">
				<thead>
					<tr>		
						<th>Gruppenid</th>
						<th>Gruppenname</th>
						<th>Studiengang</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${gform.gruppenlist}" var="g">
						<tr>
							<td>${g.id}</td>
							<td>${g.bezeichnung}</td>
							<td>${g.studiengang.bezeichnung}</td>
						</tr>
					</c:forEach>
				</tbody>
				</table>
	
</jsp:body>
</my:base>