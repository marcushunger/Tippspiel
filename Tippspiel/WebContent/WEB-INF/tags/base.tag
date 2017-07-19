<%@tag description="page template" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="de">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="<c:url value="/css/tippspiel.css"/>" rel="stylesheet">
    <!-- jQuery -->
    <script src="<c:url value="/js/jquery.js"/>"></script>

  </head>

  <body>
  	<!-- Menü -->
	<t:menu/>

    <!-- Content -->
    <div class="container">
      <jsp:doBody/>
    </div>

	<!-- Footer -->
    <footer class="footer">
      <div class="container">
	      <div class="row">
		      <div class="col-sm-4 text-muted">eMail: ${user.email}</div>
		      <div class="col-sm-4 text-muted">Username: ${user.username}</div>
		      <div class="col-sm-4 text-muted"><a href="<c:url value="/impressum.html"/>">Impressum</a></div>
	      </div>
      </div>
    </footer>
    
    <!-- Bootstrap core JavaScript-->
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>

  </body>
</html>