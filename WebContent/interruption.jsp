<%@ page import="com.interruptionService"%>
<%@ page import="model.interruption"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Interruption Management</title>

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Componets/jquery-3.2.1.min.js"></script>
<script src="Componets/interruption.js"></script>
 


</head>
<body>
<h1>Interruption Management</h1>
   <form id="formItem" name="formItem" method="post" action="interruption.jsp">
   
 
		 interruptionID:
		<input id="ID" name="ID" type="text"
		 class="form-control form-control-sm">
		<br> interruptionName:
		<input id="Name" name="Name" type="text"
		 class="form-control form-control-sm">
		<br> interruptionDate:
		<input id="Date" name="Date" type="text"
		 class="form-control form-control-sm">
		<br> interruption Address:
		<input id="Add" name="Add" type="text"
		 class="form-control form-control-sm">
		<br>
		<input id="btnSave" name="btnSave" type="button" value="Save"
		 class="btn btn-primary">
		<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
  </form>

	<div id="alertSuccess" class="alert alert-success"></div>
    <div id="alertError" class="alert alert-danger"></div>
	
		<br> 
		<div id="divItemsGrid">
		 <%
		 
		 interruption itemObj = new interruption();
		 out.print(itemObj.readInterruptions());
		 
		 %>
		</div>

 
 
 
    </div>

</div>

<% out.print(session.getAttribute("statusMsg")); %>
</body>
</html>
