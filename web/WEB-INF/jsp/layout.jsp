<!-- Layout principal -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>${title}</title>
  </head>
  <body>
    <!-- Navbar -->
       <nav class="navbar navbar-expand-lg navbar-dark custom-navbar">
  <div class="container-fluid">
    <a class="navbar-brand fs-3 fw-bold" href="#">Calculadora de IMC</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ms-auto fs-5">
        
        <li class="nav-item">
            <a class="nav-link" href="/ev3/ingresar">
                <c:choose>
                <c:when test="${title eq 'Ingresar'|| title eq 'Registrate'}">
                  Ingresar
                </c:when>
                <c:otherwise>
                  Salir
                </c:otherwise>
              </c:choose>
            </a>
        </li>
        <c:if test="${title eq 'Ingresar'|| title eq 'Registrate'}">
          <li class="nav-item">
            <a class="nav-link" href="/ev3/registrate">Registrate</a>
          </li>
        </c:if>
      </ul>
    </div>
  </div>
</nav>
    
    
    <!-- Colores y estilos -->
    <style>
        .custom-navbar {
        background-color: #8C52FF; /* Morado */
        }
        .custom-header {
        background-color: #BFDB38; /* Verde  */
        }
        .custom-card {
        background-color: #393E46; /* gris  */
        }
        .custom-button {
            background-color: #FF914D; /* naranja  */
        }
        
    </style>
    
    <!-- Popper y Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
  </body>
</html>
