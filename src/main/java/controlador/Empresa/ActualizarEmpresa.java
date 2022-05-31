/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Empresa;

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
import modelo.dao.EmpresaDAO;
import modelo.dto.EmpresaDTO;

/**
 *
 * @author Sebastián
 */
@WebServlet(name = "ActualizarEmpresa", urlPatterns = {"/ActualizarEmpresa"})
public class ActualizarEmpresa extends HttpServlet {

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
            out.println("<title>Servlet ActualizarEmpresa</title>");            
            out.println("</head>");
            out.println("<body>");
            EmpresaDAO dao = new EmpresaDAO();
            EmpresaDTO dto = new EmpresaDTO();
            dto.getEntidad().setIdEmpresa(Integer.parseInt(request.getParameter("id")));
            dto.getEntidad().setNombreEmp(request.getParameter("nombreUsuario"));
            try{
                dao.read(dto);
                out.println("<form name='datos' method='post' action='AlmacenarActualizacionEmpresa'>");
                out.println("<label for=''>Clave empresa</label><br/>");
                System.out.println("Valor: "+dto.getEntidad().getIdEmpresa());
                out.println("<input type='text' id='idUsuario' name='idUsuario' value='"+dto.getEntidad().getIdEmpresa()+"' readonly/><br/>");
                out.println("<label for='txtNombre'>Nombre empresa</label><br/>");
                out.println("<input type='text' id='txtNombre' name='txtNombre' value='"+dto.getEntidad().getNombreEmp()+"'/><br/>");
                out.println("<br>");
                out.println("<button type = 'submit' name='btnActualizar'> Actualizar</button>");
                out.println("</form>");
             }catch(SQLException ex)
            {
                Logger.getLogger(ListaDeEmpresas.class.getName()).log(Level.SEVERE,null,ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ActualizarEmpresa.class.getName()).log(Level.SEVERE, null, ex);
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
