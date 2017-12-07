<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>TODOC투닥</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link href='http://fonts.googleapis.com/css?family=Questrial'
		rel='stylesheet' type='text/css'>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/skel-panels.min.js"></script>
<script src="js/init.js"></script>
</head>
<style>
.loginForm {
    border: 3px solid #f1f1f1;
}

.loginInput {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #808080;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #b3b3b3;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.loginContainer {
    padding: 300px;
    background-color: white;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
<body>
	<!-- Header -->
	<div id="header">
		<div id="logo-wrapper">
			<div class="container">

				<!-- Logo -->
				<div id="logo">
					<h1>
						<a href="index.jsp">TODOC</a>
					</h1>
				</div>

			</div>
		</div>

	</div>
	<!-- Header -->

	<!-- login form -->
	<form action="login.do" class="loginForm" method="post">
		<div class="loginContainer">
			<label><b>UserID</b></label> 
			<input type="text" class="loginInput"
					placeholder="Enter UserID" name="hosCode" required> 
			<label><b>Password</b></label>	
			<input type="password" class="loginInput"
					placeholder="Enter Password" name="hosPassword" required>

			<button type="submit">Login</button>
			<!-- <input type="checkbox" checked="checked"> Remember me -->
		</div>	
	</form>
	<!-- login form -->
	
</body>
</html>