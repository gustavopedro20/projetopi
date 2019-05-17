<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<c:if test="${empty sessionScope['userLogado']}">
    <c:redirect url="index.jsp" />
</c:if> -->

<head>
    <c:import url="common/meta-link.jsp" />
    <title>USJT - PI</title>

</head>

<body class="text-center background-image">
    <header>
        <c:import url="common/menu.jsp" />
    </header>

    <img src="assets/background-usjt.png" alt="">

    <footer>
        <c:import url="common/footer.jsp" />
    </footer>
</body>

</html>