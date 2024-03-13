<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!<!-- Establecer nombre -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Inicio" />
<!<!-- Incluir layout -->
<%@ include file="layout.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
    </head>

    <body>
        <!--Formularios-->
    <div class="container"> 
        <br>
        <br>
        <%-- Informar error --%>
                <c:if test="${not empty error}">
                    <div class="alert alert-danger" role="alert">
                        ${error}
                    </div>
                </c:if>
          <div class="row row-cols-1 row-cols-md-2 g-2 justify-content-center">
          <!--Calcular-->    
          <div class="col">
            <div class="card">
              <div class="card-header custom-header fw-bold fs-5">Calcular</div>
                <div class="card-body custom-card text-white">
                    <form action="/ev3/resultado" method="POST">
                    
                        <div class="form-group">
                            <label for="peso">Peso(kg):</label>
                            <input type="number" class="form-control" name="peso" step="0.01" min="1.00" required>
                        </div>
                        <div class="form-group">
                            <label for="estatura">Estatura(m):</label>
                            <input type="number" class="form-control" name="estatura" step="0.01" min="1.00" max="2.50" required>
                        </div>
                        <br>
                        <button type="submit" class="btn text-white fw-bold custom-button">Continuar</button>
                    </form>
                </div>
            </div>
            </div>
          <!--Ver registro-->
          
          <div class="col">
              
            <div class="card">
              <div class="card-header custom-header fw-bold fs-5">Ver registro</div>
                <div class="card-body custom-card text-white">
                    <form action="/ev3/registros" method="POST">
                        
                        <br>
                        <button type="submit" class="btn text-white fw-bold custom-button">Ver</button>
                    </form>
                </div>
            </div>
          </div>  
          </div>
        
    </div>        
        
    </body>
</html>
