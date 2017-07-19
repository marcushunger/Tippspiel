<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %> 

<my:base>
<jsp:body> 
	<h3>Noten eintragen</h3>
    <div class="row">
    <c:forEach items="${errors}" var="e">
	<div class="alert alert-danger">${e.message }</div>
	</c:forEach>
	<div class="col-sm-6">
      <form class="form-signin" method="post" action="j_noten_user">
      	
        <h4 class="form-signin-heading">Tipp</h4>
        
        		
			<select name="modultipp" id="modultipp" class="form-control">
				<option value="">Modul auswählen</option>
				<c:forEach items="${nform.listmodule}" var="e">
					<option value="${e.id}">${e.bezeichnung}</option>
				</c:forEach>
			</select>
			<br>
			<select name="notetipp" id="notetipp" class="form-control">
				<option value="">Notentipp auswählen</option>
				<c:forEach items="${nform.noten}" var="noten">
					<option value="${noten}">${noten}</option>
				</c:forEach>
			</select>
       <br>
       <input type="hidden" name="action" value="actiontipp"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Note tippen</button>
      </form>
</div>
   
   <div class="col-sm-6">
      <form class="form-signin" method="post" action="j_noten_user">
      	<h4 class="form-signin-heading">Echte Note</h4>
        
     
			<select name="modulreal" id="modulreal" class="form-control">
				<option value="">Modul auswählen</option>
				<c:forEach items="${nform.listusermodulem}" var="e">
					<option value="${e.id}">${e.modul.bezeichnung}</option>
				</c:forEach>
			</select>	
			<br>
			<select name="notereal" id="notereal" class="form-control">
				<option value="">Geschriebene Note eintragen</option>
				<c:forEach items="${nform.noten}" var="noten">
					<option value="${noten}">${noten}</option>
				</c:forEach>
			</select>
			<br>
			<input type="hidden" name="action" value="actionreal"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Note geschrieben</button>
      </form>
      </div>
</div>
		<br>
		<h3>Übersicht Noten</h3>	
			<table class="table table-hover">
		<thead>
			<tr>		
				<th>Tippid</th>
				<th>Modul</th>
				<th>Tipp</th>
				<th>Note</th>
				<th>Abweichung</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${nform.listusermodule}" var="u">
				<tr>
					<td>${u.id}</td>
					<td>${u.modul.bezeichnung}</td>
					<td>${u.notetipp}</td>
					<td>${u.notereal}</td>
					<td>${u.abweichung}</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
	</jsp:body>
</my:base>