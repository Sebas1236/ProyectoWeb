package controlador.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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

/**
 *
 * @author Sebastián
 */
@WebServlet(name = "RegistrarUsuario", urlPatterns = {"/RegistrarUsuario"})
public class RegistrarUsuario extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<!-- CSS only -->\n" +
            "<link href=\'https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css\' rel=\'stylesheet\' integrity=\'sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor\' crossorigin=\'anonymous\'>");
            out.println("<title>Servlet RegistrarUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            UsuarioDTO dto = new UsuarioDTO();
            dto.getEntidad().setNombreUsu(request.getParameter("txtNombreUsuario"));
            dto.getEntidad().setPasswordUsu(request.getParameter("txtPasswordUsuario"));
            dto.getEntidad().setCorreoUsu(request.getParameter("correoUsu"));
            dto.getEntidad().setRole(request.getParameter("tipoUsuario"));
            //Inserta el usuario
            UsuarioDAO dao = new UsuarioDAO();
                try {
                    dao.create(dto);
                    if(request.getParameter("tipoUsuario")=="Admin"){
                        
                    }
                   else if(request.getParameter("tipoUsuario")=="Empresa"){
                      HttpSession session = request.getSession();
                      session.setMaxInactiveInterval(10*60);
                    session.setAttribute("Empresa", request.getParameter("txtNombreUsuario"));
                    request.setAttribute("userName", request.getParameter("txtNombreUsuario"));
                    request.getRequestDispatcher("/JSP/Empresa.jsp").forward(request, response);  
                   }
                   else if(request.getParameter("tipoUsuario")=="User"){
                   
                   }    
                } catch (SQLException ex) {
                    System.out.println("Excepcion");
                    Logger.getLogger(RegistrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                Logger.getLogger(RegistrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("Ok");
            out.println("<h1>Servlet RegistrarUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
