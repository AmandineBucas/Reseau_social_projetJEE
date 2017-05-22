<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un message</title>
</head>
<body>
<fieldset>
        <p>Saisissez votre message</p>

        <label for="title">Titre <span class="obligatoire"></span></label>
        <input type="text" id="title" name="title"/>
        <br/>

        <label for="content">Contenu <span class="obligatoire"></span></label>
        <input type="text" id="content" name="content" value=""/>
        <br/>
        
        <select id="status" name="status">
        	<option value="1">Public</option>
        	<option value="2">Privé</option>
        	<option value="3">Archivé</option>
        </select>
        <br/>

        <input type="submit" value="Envoyer"/>
        <br/>
        
</fieldset>
</body>
</html>