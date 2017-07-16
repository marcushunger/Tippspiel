<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %> 
<my:base>
	<jsp:attribute name="title">
	Aendern der eigenen Daten
	</jsp:attribute>
	<jsp:attribute name="headline">
	Welche Daten sollen geaendert werden
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

    <title>User Ändern</title>

        <!-- Bootstrap core CSS -->
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
	 </head>

  <body>
	<c:forEach items="${errors}" var="e">
	${e.message }<br/>
	</c:forEach>


		<form method="post" action="j_change_user">
			<input type="hidden" name="id" value="${cform.id}">
			
			<p><label for="email">email*</label><br/>
			<%-- <input type="text" name="email" id="email" value="${form.email}" onblur="checkemail(this.value, '${form.id}')"> --%>
			<input type="text" name="email" id="email" value="${cform.email}">
			<img src="images/clear.gif" id="emailcheck"/>
			</p>
			
			<p><label for="username">username</label><br/>
			<input type="text" name="username" id="username" value="${cform.username}"></p>
			
			<p><label for="passphrase">passphrase</label><br/>
			<input type="text" name="passphrase" id="passphrase" value="${cform.passphrase}"></p>
			
			
		<p>* required</p>
		<input type="submit" class="btn btn-default" value="save" name="change">
		</form>
	</body>
</html>
 		</jsp:body>
</my:base>