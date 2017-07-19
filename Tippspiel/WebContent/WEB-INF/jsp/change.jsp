<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %> 
<my:base>
<jsp:body>

<div class="container">
<div class="row">
<c:forEach items="${errors}" var="e">
<div class="alert alert-danger">${e.message }</div>
</c:forEach>
<div class="col-sm-6">

		<form class="formEigen" method="post" action="j_change_user">
			<input type="hidden" name="id" value="${cform.id}">
			<input class="form-control" type="email" name="emailalt" id="emailalt" value="${cform.email}">
			<br>
			<input class="form-control" type="text" name="usernamealt" id="usernamealt" value="${cform.username}" placeholder="Username">
			<br>
			<input class="form-control" type="password" name="passphrasealt" id="passphrasealt" placeholder="Passowort alt">
			<br>
			<input class="form-control" type="password" name="passphraseneu" id="passphraseneu" placeholder="Passowort neu">
			<br>
			<input type="submit" class="btn btn-lg btn-primary btn-block" value="Daten speichern" name="change">
		</form>
		</div>
		</div>
		</div>

</jsp:body>
</my:base>