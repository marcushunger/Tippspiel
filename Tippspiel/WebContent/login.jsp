<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <title>FOM Webprogrammierung Login</title>

        <!-- Bootstrap core CSS -->
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">

	<link href="<c:url value="/css/tippspiel.css"/>" rel="stylesheet">
  
  </head>

  <body>
    <div class="container">
    <div class="text-center"><h1>Tippspiel</h1></div>
  <c:forEach items="${errors}" var="e">
    <div class="alert alert-danger">
	${e.message }
	</div>
	</c:forEach>
    <div class="row">
	<div class="col-sm-6">
      <form class="formEigen" method="post" action="j_security_check">
      	<!-- <div class="alert alert-danger">
  			<strong>Danger!</strong> Indicates a dangerous or potentially negative action.
		</div> -->
		
        <h2 class="formEigen-heading">Login</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" name="j_username" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="j_password" id="inputPassword" class="form-control" placeholder="Password" required>
        <!-- <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div> -->
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
</div>
   
   <div class="col-sm-6">
      <form class="formEigen" method="post" action="j_register_user">
      	<!-- <div class="alert alert-danger">
  			<strong>Danger!</strong> Indicates a dangerous or potentially negative action.
		</div> -->
		
        <h2 class="formEigen-heading">Register</h2>
        <label for="inputUsername" class="sr-only">Username</label>
        <input type="text" name="j_name" id="inputName" class="form-control" placeholder="Username" required>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" name="j_username" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="j_password" id="inputPassword" class="form-control" placeholder="Password" required>
        <!-- <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div> -->
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
      </form>
      </div>
</div>
    </div> <!-- /container -->
<h:messages globalOnly="true" />

    
  </body>
</html>
