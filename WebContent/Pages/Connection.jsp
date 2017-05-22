<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AUTHENTIFICATION DE L'UTILISATEUR</title>
</head>
<body>

<p> Veuillez saisir votre adresse email et votre mot de passe. </p>

<label for="id">Adresse email <span class="obligatoire"></span></label>
<input type="text" id="id" name="id" value="<c:out value="${user.id}"/>"/>
<br>

<label for="id">Mot de passe <span class="obligatoire"></span></label>
<input type="password" id="password" name="password" value=""/>
<br>

<input type="submit" value="Connexion"/>


</body>
</html>