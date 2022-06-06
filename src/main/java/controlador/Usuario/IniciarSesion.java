package controlador.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.UsuarioDAO;
import modelo.dto.UsuarioDTO;

@WebServlet(name = "IniciarSesion", urlPatterns = {"/IniciarSesion"})
public class IniciarSesion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //usuario y contraseña
        UsuarioDTO dto = new UsuarioDTO();
        dto.getEntidad().setNombreUsu(request.getParameter("txtUsuario"));
        dto.getEntidad().setPasswordUsu(request.getParameter("txtPassword"));
        dto.getEntidad().setCorreoUsu(request.getParameter("correoUsu"));
        UsuarioDAO dao = new UsuarioDAO();
        ResultSet rs = null;
        try {
            if(dao.login(dto))
                response.sendRedirect("home.html");
            else
                out.println("Usuario o contraseña incorrectos");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
