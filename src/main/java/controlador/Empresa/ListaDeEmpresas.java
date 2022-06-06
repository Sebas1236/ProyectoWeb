package controlador.Empresa;

import controlador.Usuario.ListaDeUsuarios;
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
import modelo.dao.EmpresaDAO;
import modelo.dto.EmpresaDTO;

@WebServlet(name = "ListaDeEmpresas", urlPatterns = {"/ListaDeEmpresas"})
public class ListaDeEmpresas extends HttpServlet {
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
            out.println("</head>");
            out.println("<body>");
                        out.println("<a href='nuevaEmpresa.html'>Agregar Empresa</a>");
            out.println("<table class='table align-middle mb-0 bg-white'>");
            out.println("<thead class='bg-light'>");
            out.println("<tr>");
            out.println("<th>Clave Empresa</th>");
            out.println("<th>Nombre Empresa</th>");
            out.println("<th>Eliminar</th>");
            out.println("<th>Actualizar</th>");
            out.println("</tr>");
            out.println("</thead>");

            EmpresaDAO dao = new EmpresaDAO();
            try{
                List lista = dao.readAll();
                for(int i=0;i<lista.size();i++)
                {
                    
                    EmpresaDTO dto = (EmpresaDTO)lista.get(i);
                    out.println("<form method='POST'>");
                    out.println("<tbody>");
                    out.println("<tr>");
                    out.println("<td><input style='border:0' type='text' id='idUsuario' name='id' value='"+dto.getEntidad().getIdEmpresa()+"' readonly/></td>");
                    out.println("<td><input style='border:0' type='text' id='idUsuario' name='nombreEmpresa' value='"+dto.getEntidad().getNombreEmp()+"' readonly/></td>");
                    out.println("<td>"
                            + "<button type='submit' formaction='EliminarEmpresa' class='btn btn-link btn-rounded btn-sm fw-bold' data-mdb-ripple-color='dark'>"
                            + "Eliminar</button></td>");
                    out.println("<td>"
                    + "<button type='submit' formaction='ActualizarEmpresa' class='btn btn-link btn-rounded btn-sm fw-bold' data-mdb-ripple-color='dark'>"
                    + "Actualizar</button></td>");
                    out.println("</tr>");
                    out.println("</tbody>");
                    out.println("</form>");
                }
            }catch(SQLException | ClassNotFoundException ex)
            {
                Logger.getLogger(ListaDeEmpresas.class.getName()).log(Level.SEVERE,null,ex);
            }
            out.println("</table>");
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
