/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.dao.EstadoDAO;
import modelo.dto.EstadoDTO;
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

/**
 *
 * @author Sebastián
 */
@WebServlet(name = "ActualizarEstado", urlPatterns = {"/ActualizarEstado"})
public class ActualizarEstado extends HttpServlet {

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
            out.println("<title>Servlet ActualizarEstado</title>");            
            out.println("</head>");
            out.println("<body>");
            EstadoDAO dao = new EstadoDAO();
            EstadoDTO dto = new EstadoDTO();
            dto.getEntidad().setIdEstado(Integer.parseInt(request.getParameter("id")));
            try{
                dao.read(dto);
                /*
                out.println("<b>Los datos del Estado son </b><br/>");
                out.println("<i>Clave : "+dto.getEntidad().getIdEstado()+"</i><br/>");
                out.println("<i>Nombre : "+dto.getEntidad().getNombreEstado()+"</i><br/>");
                out.println("<a href='ListaDeEstados'>Lista de Estados</a>");*/
                out.println("<form name='datos' method='post' action='AlmacenarActualizacion'>");
                out.println("<label for=''>Clave estado</label><br/>");
                out.println("<input type='text' id='id' name='id' value='/>"+dto.getEntidad().getIdEstado()+"' readonly<br/>");
                //out.println("<label >"+dto.getEntidad().getIdEstado()+"</label><br/>");
                out.println("<label for='txtNombre'>Nombre estado</label><br/>");
                out.println("<input type='text' id='txtNombre' name='txtNombre' value='/>"+dto.getEntidad().getNombreEstado()+"'<br/>");
                out.println("<input type = 'submit' value='Actualizar' name='btnActualizar'/");
                out.println("</form>");
             }catch(SQLException ex)
            {
                Logger.getLogger(ListaDeEstados.class.getName()).log(Level.SEVERE,null,ex);
            }
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
