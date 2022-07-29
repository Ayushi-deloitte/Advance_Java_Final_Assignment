<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Complaint</title>
</head>
<body>
<h1><center>Assign Electrician!!!</center></h1>

<form method="post" action="assignElectrician" class="register-form" id="login-form" style="margin: auto;width:220px;">
<div class="form-group">
<label for="id"></label> <input type="Number" name="id" id="id" placeholder="Electrician_id" />				
</div>
<br/>
<div class="form-group">
<label for="name"></label> <input type="text" name="name" id="name" placeholder="name" />				
</div>
<br/>

<div class="form-group">
<label for="mobile_number"></label> <input type="text" name="mobile_number" id="mobile_number" placeholder="mobile_number" />				
</div>
<br/>
<div class="form-group form-button">
<input type="submit" name="signin" id="signin"
class="form-submit" value="Assign" />
</div>

</form>


</body>
</html>