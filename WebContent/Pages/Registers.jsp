<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REGISTERS</title>
</head>
<body>

<form method="post= action="register">
	<fieldset>
		<h1> Inscription </h1>
		
		<p> Veuillez saisir votre adresse email et votre mot de passe. </p>
		
		<label for="id"> ID <span class="obligatoire"></span></label>
		<input type="text" id="id" name="id"/>
		
		<label for="password"> Mot de passe <span class="obligatoire"></span></label>		
		<input type="password" id="password" name="password" value=""/>
		
		<input type="submit" value="Inscription"/>
		
	</fieldset>
</form>

</body>
</html>
