<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des messages</title>
</head>
<body>
<a href="/fr/epsi/myEpsi/Pages/AddMessages.jsp">Ajouter un message</a>

	List<Message> messages = (List<Message>) request.getSession().getAttribute("messages");
	User user = (User) request.getSession().getAttribute("user");

	for(Message message : messages){
		out.println(message.getTitle());
		out.println(message.getContent());
	}
	
	if (user.getId() == message.getAuthor().getId()){
		out.println("<a href='/fr.epsi.myEpsi/DeleteMessages?id=" + message.getId() +"'>Supprimer le message</a>") ;
	}
	
</body>
</html>
