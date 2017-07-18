<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %> 
<my:base>
	<jsp:attribute name="title">
	Aendern der eigenen Daten
	</jsp:attribute>
	<jsp:attribute name="headline">
	Daten ändern
	</jsp:attribute>
	<jsp:body>
	<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">  
        <!-- Bootstrap core CSS -->
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
	 </head>

  <body>
	
	<div class="container">
    <div class="row">
<div class="col-sm-6">


		<form method="post" action="j_change_user">
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
		
    <div class="alert alert-danger">
	${errors.message}
	</div>
	
		<div style="color: #FF0000;">${errors.message}<br/></div>
		
	</body>
</html>
 		</jsp:body>
</my:base>