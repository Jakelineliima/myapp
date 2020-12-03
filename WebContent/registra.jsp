<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="ControllerRegistra" method="POST">
		<p>
			Nome <input type="text" name="nome"/>
		</p>
		<p>
			Email <input type="text" name="email"/>
		</p>
		<p>
			Senha <input type="password" name="senha"/>
		</p>
		<p>
			Celular <input type="text" name="celular"/>
		</p>
		<input type="submit" name="botao"  value="registrar"/>
	</form>

</body>
</html>