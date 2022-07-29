<%
	if(session.getAttribute("name")==null)
	{
		response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Freelancer - Start Bootstrap Theme</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/index-styles.css" rel="stylesheet" />
</head>
<body >
<h1><center>Register Complain!!!</center></h1>

			<form method="post" action="complaint" class="register-form" style="margin: auto;width:220px;"
			id="register-form">
			<br/>
			<div>
			<label for="pole_id"></label> <input
				type="Number" name="pole_id" id="pole_id" placeholder="Pole_id" />
			</div>
			<br/>
			
			<div>
			<label for="Address"></label> <input
				type="text" name="Address" id="Address" placeholder="Address" />
			</div>
			<br/>
			<div>
			<label for="City"></label> <input
				type="text" name="City" id="City" placeholder="City" />
			</div>
			<br/>
			<div>
			<label for="Pin_code"></label> <input
				type="Number" name="Pin_code" id="Pin_code" placeholder="Pin_code" />
			</div>
			<br/>
			<div>
			<label for="Mobile"></label> <input
				type="Number" name="Mobile" id="Mobile" placeholder="Mobile_Number" />
			</div>
			<br/>
			
			
				
			<div>
			<input type="submit" name="complain" id="complain" align="center"
			class="form-submit" value="submit" />
			</div>
			</form>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
