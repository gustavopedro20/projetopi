<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <c:import url="common/meta-link.jsp" />
    <title>USJT - PI</title>
</head>

<body class="text-center">
    <div id="main" class="form-signin">
        <form action="controller.do" method="post">
            <!-- method="post" -->
            <form class="form-signin" autocomplete="off" name="user">
                <img class="mb-4 img-login" src="assets/logo-usjt.png" alt="" width="72" height="72">

            </form>
        </form>

        <footer>
            <c:import url="common/footer.jsp" />
        </footer>
    </div>
</body>

</html>