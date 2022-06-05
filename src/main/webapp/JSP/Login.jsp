<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Iniciar Sesión</title>
                <!-- CSS Bootstrap-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="text-center">
<form class="form-signin" action="<%=request.getContextPath()%>/LoginServlet" method="POST">
      <img class="mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Porfavor inicie sesión</h1>
            <label for="inputUsuario" class="sr-only">Usuario</label>
      <input name="txtUsuario" type="text" id="inputUsuario" class="form-control" placeholder="Usuario" required autofocus>
      <label for="inputEmail" class="sr-only">Correo electrónico</label>
      <input type="email" name="correoUsu" id="inputEmail" class="form-control" placeholder="Correo electrónico" required autofocus>
      <label for="inputPassword" class="sr-only">Contraseña</label>
      <input name="txtPassword" type="password" id="inputPassword" class="form-control" placeholder="Contraseña" required>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Recuérdame
        </label>
      </div>
      <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Iniciar Sesión</button>
      <p class="mt-5 mb-3 text-muted">© 2022</p>
    </form>
    </body>
    <!--
</html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Login</title>
 </head>
 <body>
  <form name="form" action="<%=request.getContextPath()%>/LoginServlet" method="post">

  <table align="center">
  <tr>
  <td>Username</td>
  <td><input type="text" name="username" /></td>
  </tr>
  <tr>
  <td>Password</td>
  <td><input type="text" name="password" /></td>
  </tr>
  <tr>
  <td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span></td>
  </tr>
  <tr>
  <td></td>
  <td><input type="submit" value="Login"></input><input type="reset" value="Reset"></input></td>
  </tr>
  </table>
  </form>
 </body>
</html>-->
