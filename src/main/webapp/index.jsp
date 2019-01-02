<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin LogIn</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" id="bootstrap-css">
</head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<body background="black">

<a href="home.html"><img src="/resources/images/logo-nav.png" alt=""></a>

	<div class="container">
    <div class="row">
    <div class="col-sm-4">
			 </div>
		<div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  	<div class="panel-heading">
			    	<h3 class="panel-title">Admin LogIn</h3>
			 	</div>
			  	<div class="panel-body">
			    	<form accept-charset="UTF-8" role="form" action="login" method="POST">
                    <fieldset>
			    	  	<div class="form-group">
			    		    <input class="form-control" placeholder="User" name="user" type="text" required>
			    		</div>
			    		<div class="form-group">
			    			<input class="form-control" placeholder="Password" name="password" type="password" value="" required>
			    		</div>
			    		<div class="checkbox">
			    	    	<label>
			    	    		<input name="remember" type="checkbox" value="Remember Me"> Remember Me
			    	    	</label>
			    	    </div>
			    		<input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
			    	</fieldset>
			      	</form>
			    </div>
			    <h4>user: Ale</h4>
			    <h4>pass: qwerty</h4>
			</div>
			<div class="col-sm-4">
			 </div>
		</div>
	</div>
</div>


</body>
</html>