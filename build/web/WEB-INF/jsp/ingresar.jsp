<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!<!-- Establecer nombre -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Ingresar" />
<!<!-- Incluir layout -->
<%@ include file="layout.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--Formulario de registro-->
    <div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <br>
            <br>
             <%-- Informar error --%>
                <c:if test="${not empty error}">
                    <div class="alert alert-danger" role="alert">
                        ${error}
                    </div>
                </c:if>
            <div class="card">
                <div class="card-header custom-header fw-bold fs-5">Iniciar sesion</div>
                <div class="card-body custom-card text-white">
                    <form action="/ev3/inicio" method="POST">
                        <div class="form-group">
                            <label for="username">Nombre de usuario:</label>
                            <input type="text" class="form-control" name="username" required>
                        </div>      
                        <div class="form-group">
                            <label for="password">Contraseña:</label>
                            <input type="text" class="form-control" name="password" required>
                        </div>
                        <br>
                        <button type="submit" class="btn text-white fw-bold custom-button">Finalizar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
        
    </body>
</html>
