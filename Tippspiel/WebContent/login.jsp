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


   <style type="text/css">
	   body {
		  padding-top: 40px;
		  padding-bottom: 40px;
		  background-color: #eee;
		}
		
		.form-signin, .form-signup{
		  max-width: 330px;
		  padding: 0px;
		  margin: 0 auto;
		}
		
		.form-signin .form-signin-heading,
		.form-signup .form-signup-heading,
		.form-signin .checkbox {
		  margin-bottom: 10px;
		}
		.form-signin .checkbox {
		  font-weight: normal;
		}
		.form-signin .form-control,
		.form-signup .form-control {
		  position: relative;
		  height: auto;
		  -webkit-box-sizing: border-box;
		     -moz-box-sizing: border-box;
		          box-sizing: border-box;
		  padding: 10px;
		  font-size: 16px;
		}
		.form-signin .form-control:focus {
		  z-index: 2;
		}
		.form-signin input[type="email"]{
		  margin-bottom: -1px;
		  border-bottom-right-radius: 0;
		  border-bottom-left-radius: 0;
		}
		.form-signin input[type="password"],
		.form-signup input[type="password"]{
		  margin-bottom: 10px;
		  border-top-left-radius: 0;
		  border-top-right-radius: 0;
		}
		
		.form-signup input[type="email"]{
		  margin-bottom: -1px;
		  margin-bottom: -1px;
		  border-top-left-radius: 0;
		  border-top-right-radius: 0;
		  border-bottom-right-radius: 0;
		  border-bottom-left-radius: 0;
		}
		
		.form-signup input[type="text"]{
		  margin-bottom: -1px;
		  border-bottom-right-radius: 0;
		  border-bottom-left-radius: 0;
		}
   </style>
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
      <form class="form-signin" method="post" action="j_security_check">
      	<!-- <div class="alert alert-danger">
  			<strong>Danger!</strong> Indicates a dangerous or potentially negative action.
		</div> -->
		
        <h2 class="form-signin-heading">Login</h2>
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
      <form class="form-signup" method="post" action="j_register_user">
      	<!-- <div class="alert alert-danger">
  			<strong>Danger!</strong> Indicates a dangerous or potentially negative action.
		</div> -->
		
        <h2 class="form-signup-heading">Register</h2>
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
