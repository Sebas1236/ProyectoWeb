package controlador.EntidadFederativa;

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
import modelo.dao.EntidadFederativaDAO;
import modelo.dto.EntidadFederativaDTO;
import modelo.entidades.EntidadFederativa;

@WebServlet(name = "ServletControladorEF", urlPatterns = {"/ServletControladorEF"})
public class ServletControladorEF extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarEF(request, response);
                    break;
                case "eliminar":
                    this.eliminarEF(request, response);
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
            List<EntidadFederativa> efs = new EntidadFederativaDAO().listar();
            HttpSession sesion = request.getSession();
            sesion.setAttribute("efs", efs);
            
            sesion.setAttribute("totalEntidadesFederativas", efs.size());
            response.sendRedirect("entidadesFederativas.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorEF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void editarEF(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idEnt
        int idEnt = Integer.parseInt(request.getParameter("idEnt"));
        System.out.println("id editar: "+ idEnt);
        EntidadFederativaDTO dto = new EntidadFederativaDTO();
        EntidadFederativaDAO dao = new EntidadFederativaDAO();
        dto.getEntidad().setIdEnt(idEnt);
        try {
            dto = dao.read(dto);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorEF.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        request.setAttribute("ef", dto.getEntidad());
        String jspEditar = "/WEB-INF/paginas/entidadFederativa/editarEF.jsp";
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
                    this.insertarEF(request, response);
                    break;
                case "modificar":
                    this.modificarEF(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
        private void insertarEF(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            EntidadFederativaDTO dto = new EntidadFederativaDTO();
            dto.getEntidad().setNombreEnt(request.getParameter("nombreEnt"));
            //Inserta la EF
            EntidadFederativaDAO dao = new EntidadFederativaDAO();
                try {
                    dao.create(dto);
                } catch (SQLException ex) {
                    System.out.println("Excepcion");
                    Logger.getLogger(ServletControladorEF.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServletControladorEF.class.getName()).log(Level.SEVERE, null, ex);
            }

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
        
    private void modificarEF(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            EntidadFederativaDAO dao = new EntidadFederativaDAO();
            EntidadFederativaDTO dto = new EntidadFederativaDTO();
            dto.getEntidad().setNombreEnt(request.getParameter("nombreEnt"));
            dto.getEntidad().setIdEnt(Integer.parseInt(request.getParameter("idEnt")));
            try{      
                dao.update(dto);      
                System.out.println("EF actualizada!");
            }catch(SQLException | ClassNotFoundException ex)
            {
                Logger.getLogger(ServletControladorEF.class.getName()).log(Level.SEVERE,null,ex);
            }

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
            
    private void eliminarEF(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            EntidadFederativaDTO dto = new EntidadFederativaDTO();
            EntidadFederativaDAO dao = new EntidadFederativaDAO();
            int id = Integer.parseInt(request.getParameter("idEnt"));
            dto.getEntidad().setIdEnt(id);
            try{
                dto = dao.read(dto);
                dao.delete(dto);
            }catch(SQLException | ClassNotFoundException ex)
            {
                Logger.getLogger(ServletControladorEF.class.getName()).log(Level.SEVERE,null,ex);
            }
        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }

}
