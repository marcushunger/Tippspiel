<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="my" tagdir="/WEB-INF/tags" %> 


 <my:base>
	<jsp:attribute name="title">
	Person List
	</jsp:attribute>
	<jsp:attribute name="headline">
	Deine Noten
	</jsp:attribute>
	<jsp:body> 
	
	<div class="container">
    <div class="row">
	<div class="col-sm-6">
      <form class="form-signin" method="post" action="j_noten_user">
      	
        <h3 class="form-signin-heading">Tipp</h3>
        
        		
			<select name="noten" id="noten" class="form-control">
				<option value="">Modul auswählen</option>
				<c:forEach items="${noteeintragen}" var="e">
					<option value="${e.id}">${e.bezeichnung}</option>
				</c:forEach>
			</select>
			<br>
			<select name="notenliste" id="notenliste" class="form-control">
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
      	<h3 class="form-signin-heading">Echte Note</h3>
        
     
			<select name="noten" id="noten" class="form-control">
				<option value="">Modul auswählen</option>
				<c:forEach items="${noteeintragen}" var="e">
					<option value="${e.id}">${e.bezeichnung}</option>
				</c:forEach>
			</select>	
			<br>
			<select name="notenliste" id="notenliste" class="form-control">
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
    </div> <!-- /container -->
		<!-- 
		<table class="table table-hover">
		<thead>
			<tr>		
				<th><fmt:message key="GruppenId"/></th>
				<th><fmt:message key="Bezeichnung"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${noteeintragen}" var="n">
				<tr>
					<td><a href="<c:url value="/noteeintragen.html?id=${n.id}"/>">${n.id}</a></td>
					<td><a href="<c:url value="/noteeintragen.html?id=${n.id}"/>">${n.bezeichnung}</a></td>

				</tr>
			</c:forEach>
		</tbody>
		</table>
		 -->
		<br>
		<h3>Übersicht Noten</h3>	
			<table class="table table-hover">
		<thead>
			<tr>		
				<th><fmt:message key="GruppenId"/></th>
				<th><fmt:message key="Modul"/></th>
				<th><fmt:message key="Notentipp"/></th>
				<th><fmt:message key="Note"/></th>
				<th><fmt:message key="Abweichung"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${nform.listeusermodule}" var="u">
				<tr>
					<!-- <td>${u.id}</td> -->
					<td>${u.modul.bezeichnung}</td>
					<td>${u.notetipp}</td>
					<td>${u.notereal}</td>
					<!-- Problem das abweichung nicht in der liste --><td>${nform.abweichung}</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
		
	</jsp:body>
</my:base>