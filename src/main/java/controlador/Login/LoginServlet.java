/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import login.bean.LoginBean;
import login.dao.LoginDAO;

/**
 *
 * @author Sebastián
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
    
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
 String userName = request.getParameter("txtUsuario");
 String password = request.getParameter("txtPassword");
 String correoUsu = request.getParameter("correoUsu");

 LoginBean loginBean = new LoginBean();

 loginBean.setUserName(userName);
 loginBean.setPassword(password);
 loginBean.setCorreoUsu(correoUsu);

 LoginDAO loginDao = new LoginDAO();

 try
 {
  String userValidate = loginDao.authenticateUser(loginBean);

  if(userValidate.equals("Admin_Role"))
  {
   System.out.println("Admin's Home");

   HttpSession session = request.getSession(); //Creating a session
   session.setAttribute("Admin", userName); //setting session attribute
   request.setAttribute("userName", userName);

   request.getRequestDispatcher("/JSP/Admin.jsp").forward(request, response);
  }
  else if(userValidate.equals("Editor_Role"))
  {
   System.out.println("Editor's Home");

   HttpSession session = request.getSession();
   session.setAttribute("Editor", userName);
   request.setAttribute("userName", userName);

   request.getRequestDispatcher("/JSP/Editor.jsp").forward(request, response);
  }
  else if(userValidate.equals("User_Role"))
  {
   System.out.println("User's Home");

   HttpSession session = request.getSession();
   session.setMaxInactiveInterval(10*60);
   session.setAttribute("User", userName);
   request.setAttribute("userName", userName);

   request.getRequestDispatcher("/JSP/Usuario.jsp").forward(request, response);
  }
  else
  {
   System.out.println("Error message = "+userValidate);
   request.setAttribute("errMessage", userValidate);

   request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
  }
 }
 catch (IOException e1)
 {
  e1.printStackTrace();
 }
 catch (Exception e2)
 {
  e2.printStackTrace();
 }
} //End of doPost()

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
























