<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="css/login.css"/>
<title>Lista de Usuarios</title>
<script type="text/javascript">
	
	function confirmaExclusao(id){		
		if(window.confirm("Tem Certeza que deseja excluir o Registro"+id)){
			location.href = "usucontroler.do?acao=exc&id="+id;
		}
	}

</script>

</head>
<body>
	<c:import url="includes/menu.jsp"></c:import>
	
	<table border="1">
		<tr bgcolor="#EAEAEA">
			<!--<th>ID</th>--><th>nome</th><th>Login</th><!--<th>Senha</th>--><th>Ação</th>
		</tr>
<c:forEach items="${requestScope.lista}" var="usu">
			<tr>
				<!--<td>${usu.id}</td>-->
				<td>${usu.nome}</td>
				<td>${usu.login}</td>
				<!--<td>${usu.senha}</td>-->
				<td><a href="javascript:confirmaExclusao(${usu.id})" >Excluir</a>
				|
				<a href="usucontroler.do?acao=alt&id=${usu.id}" >Alterar</a></td>				
			</tr>	
</c:forEach>
	</table>
	
	
	
</body>
</html>