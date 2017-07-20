<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %> 

 <my:base>
<jsp:body> 
<h3>Userliste</h3>
		<table class="table table-hover">
		<thead>
			<tr>		
				<th>eMail</th>
				<th>Username</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${personlist}" var="p">
				<tr>
					<td>${p.email}</td>
					<td>${p.username}</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
	</jsp:body>
</my:base>