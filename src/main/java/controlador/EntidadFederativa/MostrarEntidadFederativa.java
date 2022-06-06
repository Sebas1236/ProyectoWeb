/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.EntidadFederativa;

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
import modelo.dao.EntidadFederativaDAO;
import modelo.dto.EntidadFederativaDTO;

/**
 *
 * @author Sebastián
 */
@WebServlet(name = "MostrarEntidadFederativa", urlPatterns = {"/MostrarEntidadFederativa"})
public class MostrarEntidadFederativa extends HttpServlet {

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
            out.println("<title>Servlet MostrarEntidadFederativa</title>");            
            out.println("</head>");
            out.println("<body>");
            EntidadFederativaDAO dao = new EntidadFederativaDAO();
            EntidadFederativaDTO dto = new EntidadFederativaDTO();
            dto.getEntidad().setIdEnt(Integer.parseInt(request.getParameter("idUsuario")));
            try {
                dao.read(dto);
                out.println("<b>Los datos de la entidad federativa son </b><br/>");
                out.println("<i>Clave : "+dto.getEntidad().getIdEnt()+"</i><br/>");
                out.println("<i>Nombre : "+dto.getEntidad().getNombreEnt()+"</i><br/>");
                out.println("<a href='ListaDeEntidadesFederativas'>Lista de entidades federativas</a>");
                out.println("");
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(MostrarEntidadFederativa.class.getName()).log(Level.SEVERE, null, ex);
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
