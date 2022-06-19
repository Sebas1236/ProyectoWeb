package controlador.Empresa;

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
import modelo.dao.EmpresaDAO;
import modelo.dao.UsuarioDAO;
import modelo.dto.EmpresaDTO;
import modelo.dto.UsuarioDTO;
import modelo.entidades.Empresa;
import modelo.entidades.Usuario;

@WebServlet(name = "ServletControladorEmpresa", urlPatterns = {"/ServletControladorEmpresa"})
public class ServletControladorEmpresa extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarEmpresa(request, response);
                    break;
                case "eliminar":
                    this.eliminarEmpresa(request, response);
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
            List<Empresa> empresas = new EmpresaDAO().listar();
            HttpSession sesion = request.getSession();
            sesion.setAttribute("empresas", empresas);

            List<Usuario> usuarios = new UsuarioDAO().listar();
            sesion.setAttribute("usuarios", usuarios);
            
            sesion.setAttribute("totalEmpresas", empresas.size());
            response.sendRedirect("empresas.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void editarEmpresa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idEnt
        int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
        System.out.println("id editar: "+ idEmpresa);
        EmpresaDTO dto = new EmpresaDTO();
        EmpresaDAO dao = new EmpresaDAO();
        dto.getEntidad().setIdEmpresa(idEmpresa);
        try {
            dto = dao.read(dto);
            System.out.println(dao);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        request.setAttribute("empresa", dto.getEntidad());
        String jspEditar = "/WEB-INF/paginas/empresa/editarEmpresa.jsp";
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
                    this.insertarEmpresa(request, response);
                    break;
                case "modificar":
                    this.modificarEmpresa(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
        private void insertarEmpresa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            EmpresaDTO dto = new EmpresaDTO();
            dto.getEntidad().setNombreEmp(request.getParameter("nombreEmp"));
            dto.getEntidad().setDescripcionEmp(request.getParameter("descripcionEmp"));
            dto.getEntidad().setEsloganEmp(request.getParameter("esloganEmp"));
            dto.getEntidad().setLogoEmp(request.getParameter("logoEmp"));
            dto.getEntidad().setIdUsuarioEmp(Integer.parseInt(request.getParameter("idusuarioEmp")));
            //Inserta la Empresa
            EmpresaDAO dao = new EmpresaDAO();
                try {
                    dao.create(dto);
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(ServletControladorEmpresa.class.getName()).log(Level.SEVERE, null, ex);
                }

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
        
    private void modificarEmpresa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            EmpresaDAO dao = new EmpresaDAO();
            EmpresaDTO dto = new EmpresaDTO();
            dto.getEntidad().setNombreEmp(request.getParameter("nombreEmp"));
            dto.getEntidad().setDescripcionEmp(request.getParameter("descripcionEmp"));
            dto.getEntidad().setEsloganEmp(request.getParameter("esloganEmp"));
            dto.getEntidad().setLogoEmp(request.getParameter("logoEmp"));
            //dto.getEntidad().setIdUsuarioEmp(Integer.parseInt(request.getParameter("idusuarioEmp")));
            dto.getEntidad().setIdEmpresa(Integer.parseInt(request.getParameter("idEmpresa")));
            try{      
                dao.update(dto);      
                System.out.println("Empresa actualizada!");
            }catch(SQLException | ClassNotFoundException ex)
            {
                Logger.getLogger(ServletControladorEmpresa.class.getName()).log(Level.SEVERE,null,ex);
            }

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
            
    private void eliminarEmpresa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            EmpresaDTO dto = new EmpresaDTO();
            EmpresaDAO dao = new EmpresaDAO();
            int id = Integer.parseInt(request.getParameter("idEmpresa"));
            dto.getEntidad().setIdEmpresa(id);
            try{
                dto = dao.read(dto);
                dao.delete(dto);
            }catch(SQLException | ClassNotFoundException ex)
            {
                Logger.getLogger(ServletControladorEmpresa.class.getName()).log(Level.SEVERE,null,ex);
            }
        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
}
