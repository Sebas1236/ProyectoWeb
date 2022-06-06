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
@WebServlet(name = "RegistrarEmpresa", urlPatterns = {"/RegistrarEmpresa"})
public class RegistrarEmpresa extends HttpServlet {

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
            out.println("<title>Servlet RegistrarEmpresa</title>");            
            out.println("</head>");
            out.println("<body>");
            EmpresaDTO dto = new EmpresaDTO();
            dto.getEntidad().setNombreEmp(request.getParameter("txtNombreEmpresa"));
            dto.getEntidad().setLogoEmp(request.getParameter("txtLogoEmpresa"));
            dto.getEntidad().setEsloganEmp(request.getParameter("txtEslogan"));
            dto.getEntidad().setDescripcionEmp(request.getParameter("txtDescripcion"));
            dto.getEntidad().setIdUsuarioEmp(Integer.parseInt(request.getParameter("idUsuarioEmp")));
            //Inserta la empresa
            EmpresaDAO dao = new EmpresaDAO();
                try {
                    dao.create(dto);
                } catch (SQLException ex) {
                    System.out.println("Excepcion");
                    Logger.getLogger(RegistrarEmpresa.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                Logger.getLogger(RegistrarEmpresa.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("Ok");
            out.println("<h1>Servlet RegistrarEmpresa at " + request.getContextPath() + "</h1>");
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
