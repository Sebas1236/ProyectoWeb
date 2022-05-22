/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "ListaDeUsuarios", urlPatterns = {"/ListaDeUsuarios"})
public class ListaDeUsuarios extends HttpServlet {

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
             out.println("<!-- CSS only -->\n" +
"<link href=\'https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css\' rel=\'stylesheet\' integrity=\'sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor\' crossorigin=\'anonymous\'>");
            out.println("<title>Servlet ListaDeUsuarios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<a href='nuevoUsuario.html'>Agregar Usuario</a>");
            out.println("<table class='table align-middle mb-0 bg-white'>");
            out.println("<thead class='bg-light'>");
            out.println("<tr>");
            out.println("<th>Clave Usuario</th>");
            out.println("<th>Nombre Usuario</th>");
            out.println("<th>Eliminar</th>");
            out.println("<th>Actualizar</th>");
            out.println("</tr>");
            out.println("</thead>");

            UsuarioDAO dao = new UsuarioDAO();
            try{
                List lista = dao.readAll();
                for(int i=0;i<lista.size();i++)
                {
                    
                    UsuarioDTO dto = (UsuarioDTO)lista.get(i);
                    out.println("<form method='POST'>");
                    out.println("<tbody>");
                    out.println("<tr>");
                    //out.println("<td><a href='MostrarUsuario?id="+dto.getEntidad().getIdUsu()+"'>"+dto.getEntidad().getIdUsu()+"</a></td>");
                    //out.println("<td><button type='submit' formaction='MostrarUsuario' class='btn btn-link btn-rounded btn-sm fw-bold' data-mdb-ripple-color='dark'>"
                      //      + "<input style='border:0' type='text' id='idUsuario' name='id' value='"+dto.getEntidad().getIdUsu()+"' readonly/></button></td>");
                    //out.println("<td>"+dto.getEntidad().getIdEstado()+"</td>");
                    //out.println("<td>"+dto.getEntidad().getNombreUsu()+"</td>");
                    out.println("<td><input style='border:0' type='text' id='idUsuario' name='id' value='"+dto.getEntidad().getIdUsu()+"' readonly/></td>");
                    out.println("<td><input style='border:0' type='text' id='idUsuario' name='nombreUsuario' value='"+dto.getEntidad().getNombreUsu()+"' readonly/></td>");
                    out.println("<td>"
                            + "<button type='submit' formaction='EliminarUsuario' class='btn btn-link btn-rounded btn-sm fw-bold' data-mdb-ripple-color='dark'>"
                            + "Eliminar</button></td>");
                    //out.println("<td><a href='EliminarUsuario?id="+dto.getEntidad().getIdUsu()+"'>Eliminar</a></td>");
                    //out.println("<td><a href='ActualizarUsuario?id="+dto.getEntidad().getIdUsu()+"&nombreUsuario="+dto.getEntidad().getNombreUsu()+"'>Actualizar</a></td>");
                    out.println("<td>"
                    + "<button type='submit' formaction='ActualizarUsuario' class='btn btn-link btn-rounded btn-sm fw-bold' data-mdb-ripple-color='dark'>"
                    + "Actualizar</button></td>");
                    out.println("</tr>");
                    out.println("</tbody>");
                    out.println("</form>");
                    //String nombre = dto.getEntidad().getNombreEstado();
                    //out.println(nombre);
                }
            }catch(SQLException | ClassNotFoundException ex)
            {
                Logger.getLogger(ListaDeUsuarios.class.getName()).log(Level.SEVERE,null,ex);
            }
            out.println("</table>");
            //out.println("<h1>Servlet ListaDeUsuarios at " + request.getContextPath() + "</h1>");
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
