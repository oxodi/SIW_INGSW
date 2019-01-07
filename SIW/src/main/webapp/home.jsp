<html> 
<head> 
<title>Pagina JSP</title> 
</head > 
<body> 
<%
java.util.Date data_di_oggi = new java.util.Date();
out.println( String.valueOf( data_di_oggi ));
%>
<%= request.getRemoteHost() %>

</body> 
</html>