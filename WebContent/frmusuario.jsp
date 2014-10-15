<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="css/login.css" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>Lista de Usuarios</title>
<title>Cadastro de Usuario</title>
</head>
<body>

	<form action="usucontroler.do" method="post">
		<div id="logo">
			<div id="rede">
				<img id="rede" src="img/rede.png" />
			</div>
			<div id="rede2">
				<img id="rede" src="img/redeCon.png" />
			</div>
			<img src="img/logo_ifgoiano.png" />

		</div>
		<div class="margin">
			<!-- <label>ID :</label> -->
			<!-- <input type="text" readonly="readonly" name="txtid" size="1" value="${requestScop.usuario.id }"/>-->

			<label>Nome :</label> <input type="text" name="txtname" size="20"
				value="${requestScop.usuario.nome }" />
		</div>
		<div class="margin">
			<label>Login :</label> <input type="text" name="txtlogin" size="8"
				value="${requestScop.usuario.login }" />
		</div>
		<div class="margin">
			<label>Senha :</label> <input type="password" name="txtsenha"
				maxlength="8" value="${requestScop.usuario.senha }" />
		</div>
		<div class="margin">
			<label>Confirmar Senha :</label> <input type="password"
				name="txtsenha" maxlength="8" value="${requestScop.usuario.senha }" />
			<input id="btn" type="submit" value="Salvar" />
		</div>
		<c:import url="includes/menu.jsp"></c:import>
	</form>


</body>
</html>