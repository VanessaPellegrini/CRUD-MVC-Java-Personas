
<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <%
                    PersonaDAO dao = new PersonaDAO();
                    int id = Integer.parseInt((String) request.getAttribute("idper"));
                    Persona p = (Persona) dao.list(id);
                %>
                <h1>Modificar Persona</h1>
                <form action="Controlador">
                    Nombres: <br>
                    <input class="form-control" type="text" name="txtNom" value="<%= p.getNom()%>"><br>
                    Apellido: <br>
                    <input class="form-control" type="text" name="txtApe" value="<%= p.getApellido()%>"><br>
                    Edad: <br>
                    <input class="form-control" type="text" name="txtEdad" value="<%= p.getEdad()%>"><br>
                    Sexo: <br>
                    <br />
                    M <input type="radio" name="txtSexo" value="M" class="form-check-input" required/>
                    F <input type="radio" name="txtSexo" value="F" class="form-check-input" required/> <br />
                    <br>
                    <br>
                    <input type="hidden" name="txtid" value="<%= p.getId()%>">
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                    <a href="Controlador?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
