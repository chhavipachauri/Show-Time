 <%@ page import="com.example.demo.*" %>
    <%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
@keyframes color {
  0%   { background: #33CCCC; }
  20%  { background: #33CC36; }
  40%  { background: #B8CC33; }
  60%  { background: #FCCA00; }
  80%  { background: #33CC36; }
  100% { background: #33CCCC; }
}
</style>
<meta charset="ISO-8859-1">
<title>LIST</title>
</head>
<style>
body {
  background: #33CCCC; /* Fallback */
  animation: color 9s infinite linear;
  text-align: center;
  padding: 2em;
}
 #submit:hover{
    background-color: #F29393;
    }

</style>

<center>
<%List<Movie> list=(List<Movie>)request.getAttribute("list");  %>
 <table border="1" cellpadding = "10" cellspacing = "10" bordercolor = "red" bgcolor = "BlanchedAlmond" width="80%">
 <tr>
 	<th>ID</th>
 	<th>Movie Name</th>
 	<th>Date</th>
 	<th>Price</th>
 	<th>Action</th>
 </tr>
<% for(Movie s:list){%>
 <tr>
    <td><%=s.getId() %></td>
    <td><%=s.getName() %></td>
    <td><%=s.getDate()%></td>
    <td><%=s.getPrice()%></td>
    <td><a href="addtocart?id=<%=s.getId()%>">Buy Now</a></td>
 </tr>
<%}%> <br><br>
</table><br><br>

</form>
</center>
</body>
</html>