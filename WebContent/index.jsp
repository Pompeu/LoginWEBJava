<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="css/login.css" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>Lista de Usuarios</title>
<title>Logado no sistema</title>
</head>
<body>
	<div id="logo">
		<div id="rede">
			<img id="rede" src="img/rede.png" />
		</div>
		<div id="rede2">
			<img id="rede" src="img/redeCon.png" />
		</div>
		<img src="img/logo_ifgoiano.png" />
	</div>

	<p>Seja Bem Vindo ${sessionScope.usuLogado.nome}</p>

	<c:import url="includes/menu.jsp"></c:import>
</body>
</html>