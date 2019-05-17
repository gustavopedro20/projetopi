<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
    <%
    session.removeAttribute("alunoLogado");
    session.removeAttribute("profLogado");
    session.removeAttribute("admLogado");
    session.removeAttribute("userLogado");
    %>
    <c:redirect url="index.jsp" />
</body>

</html>