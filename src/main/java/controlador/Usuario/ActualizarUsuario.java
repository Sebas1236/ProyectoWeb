/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import modelo.dao.UsuarioDAO;
import modelo.dto.UsuarioDTO;

/**
 *
 * @author Sebastián
 */
@WebServlet(name = "ActualizarUsuario", urlPatterns = {"/ActualizarUsuario"})
public class ActualizarUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ActualizarUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            UsuarioDAO dao = new UsuarioDAO();
            UsuarioDTO dto = new UsuarioDTO();
            dto.getEntidad().setIdUsu(Integer.parseInt(request.getParameter("id")));
            dto.getEntidad().setNombreUsu(request.getParameter("nombreUsuario"));
            dto.getEntidad().setCorreoUsu(request.getParameter("correoUsuario"));
            try{
                dao.read(dto);
                /*
                out.println("<b>Los datos del Estado son </b><br/>");
                out.println("<i>Clave : "+dto.getEntidad().getIdEstado()+"</i><br/>");
                out.println("<i>Nombre : "+dto.getEntidad().getNombreEstado()+"</i><br/>");
                out.println("<a href='ListaDeEstados'>Lista de Estados</a>");*/
                out.println("<form name='datos' method='post' action='AlmacenarActualizacionUsuario'>");
                out.println("<label for=''>Clave usuario</label><br/>");
                System.out.println("Valor: "+dto.getEntidad().getIdUsu());
                out.println("<input type='text' id='idUsuario' name='idUsuario' value='"+dto.getEntidad().getIdUsu()+"' readonly/><br/>");
                //out.println("<label >"+dto.getEntidad().getIdEstado()+"</label><br/>");
                out.println("<label for='txtNombre'>Nombre usuario</label><br/>");
                out.println("<input type='text' id='txtNombre' name='txtNombre' value='"+dto.getEntidad().getNombreUsu()+"'/><br/>");
                out.println("<label for='correoUsu'>Correo usuario</label><br/>");
                out.println("<input type='text' id='correoUsu' name='correoUsu' value='"+dto.getEntidad().getCorreoUsu()+"'/><br/>");
                out.println("<br>");
                out.println("<button type = 'submit' name='btnActualizar'> Actualizar</button>");
                out.println("</form>");
             }catch(SQLException ex)
            {
                Logger.getLogger(ListaDeUsuarios.class.getName()).log(Level.SEVERE,null,ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ActualizarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            //out.println("<h1>Servlet ActualizarUsuario at " + request.getContextPath() + "</h1>");
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
