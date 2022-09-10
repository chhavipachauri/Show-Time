<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INSERTION</title>
<style>
table, th, td {
  border: none;
  border-collapse: collapse;
   margin-top: 100px;
}

body {
   background-color: #D9F8C4;
}

  #submit:hover{
    background-color: #F29393;
    }

</style>
</head>

<body>
<center>
<form action="insert">
 <table border="1" cellpadding = "10" cellspacing = "10" bordercolor = "red" bgcolor = "BlanchedAlmond" width="50%">
   <tr> <th colspan="2"><h3>MOVIE DETAILS</h3></th> </tr>
   <tr> <td>Id </td> <td><input type="text" name="id" placeholder="Enter ID"></td> </tr>
   <tr> <td>Name </td> <td><input type="text" name="name" placeholder="Enter movie"></td> </tr>
   <tr> <td>Date </td> <td><input type="date" name="date" placeholder="Enter date"></td> </tr>
   <tr> <td>Price </td> <td><input type="text" name="price" placeholder="Enter price"></td> </tr>

 </table>
 
   <br><br>
   <input id="submit" type="submit" value="Add Movie">
</form>

<form action="getall">
<br>
<input id="submit" type="submit" value="Show Movie">
</form>
</center>
</body>
</html>