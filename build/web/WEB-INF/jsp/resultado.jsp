<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!<!-- Establecer nombre -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Resultado" />
<!<!-- Incluir layout -->
<%@ include file="layout.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--Resultado-->
    <div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <br>
            <br>
            <div class="card">
                <div class="card-header custom-header fw-bold fs-4">Tu IMC es</div>
                <div class="card-body custom-card text-white">
                    <form action="/ev3/inicio" method="GET">
                        <p class="fs-5">${imc}</p>
                        <br>
                        <button type="submit" class="btn text-white fw-bold custom-button">Regresar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
        
    </body>
</html>