package controlador.Usuario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dao.UsuarioDAO;
import modelo.dto.UsuarioDTO;
import modelo.entidades.Usuario;
//if((request.getSession(false).getAttribute("Admin")== null) )
@WebServlet(name = "ServletControladorUsuario", urlPatterns = {"/ServletControladorUsuario"})
public class ServletControladorUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarUsuario(request, response);
                    break;
                case "eliminar":
                    this.eliminarUsuario(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if((request.getSession(false).getAttribute("Admin")== null) )
            response.sendRedirect("LoginServlet");
        try {
            List<Usuario> usuarios = new UsuarioDAO().listar();
            
            //System.out.println("USUARIO ES:  " + usuarios);
            //posible problema
            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuarios", usuarios);
            
            sesion.setAttribute("totalUsuarios", usuarios.size());
            response.sendRedirect("usuarios.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void editarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idCliente
        int idUsuario = Integer.parseInt(request.getParameter("idUsu"));
        System.out.println("id editar: "+ idUsuario);
        UsuarioDTO dto = new UsuarioDTO();
        UsuarioDAO dao = new UsuarioDAO();
        dto.getEntidad().setIdUsu(idUsuario);
        try {
            dto = dao.read(dto);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        request.setAttribute("usuario", dto.getEntidad());
        String jspEditar = "/WEB-INF/paginas/usuario/editarUsuario.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarUsuario(request, response);
                    break;
                case "modificar":
                    this.modificarUsuario(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
        private void insertarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            UsuarioDTO dto = new UsuarioDTO();
            dto.getEntidad().setNombreUsu(request.getParameter("nombreUsu"));
            dto.getEntidad().setPasswordUsu(request.getParameter("passwordUsu"));
            dto.getEntidad().setCorreoUsu(request.getParameter("correoUsu"));
            dto.getEntidad().setRole(request.getParameter("role"));
            System.out.println(dto.getEntidad().getRole());
            //Inserta el usuario
            UsuarioDAO dao = new UsuarioDAO();
                try {
                    dao.create(dto);
                } catch (SQLException ex) {
                    System.out.println("Excepcion");
                    Logger.getLogger(ServletControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServletControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
        
    private void modificarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            UsuarioDAO dao = new UsuarioDAO();
            UsuarioDTO dto = new UsuarioDTO();
            dto.getEntidad().setNombreUsu(request.getParameter("nombreUsu"));
            dto.getEntidad().setIdUsu(Integer.parseInt(request.getParameter("idUsu")));
            dto.getEntidad().setCorreoUsu(request.getParameter("correoUsu"));
            dto.getEntidad().setRole(request.getParameter("role"));
            try{      
                dao.update(dto);      
                System.out.println("Usuario actualizado!");
            }catch(SQLException | ClassNotFoundException ex)
            {
                Logger.getLogger(ServletControladorUsuario.class.getName()).log(Level.SEVERE,null,ex);
            }

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
            
    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            UsuarioDTO dto = new UsuarioDTO();
            UsuarioDAO dao = new UsuarioDAO();
            int id = Integer.parseInt(request.getParameter("idUsu"));
            dto.getEntidad().setIdUsu(id);
            try{
                dto = dao.read(dto);
                //out.println(dto.toString());
                dao.delete(dto);
                //response.sendRedirect("ListaDeUsuarios");
            }catch(SQLException | ClassNotFoundException ex)
            {
                Logger.getLogger(ServletControladorUsuario.class.getName()).log(Level.SEVERE,null,ex);
            }
        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
}
