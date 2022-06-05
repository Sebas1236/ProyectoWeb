package login.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import login.bean.LoginBean;
import datos.Conexion;
import java.sql.PreparedStatement;

public class LoginDAO {
private static final String SQL_LOGIN= "select nombreUsu,passwordUsu,correoUsu, role from usuario";
private Connection conexion;
private String usuarioBD = "";
private String passwordBD = "";
private String rolBD = "";
private String correoBD;
public String authenticateUser(LoginBean loginBean) throws SQLException, ClassNotFoundException
{
 String userName = loginBean.getUserName();
 String password = loginBean.getPassword();
 String correoUsu = loginBean.getCorreoUsu();

 conexion = Conexion.getConnection();
 PreparedStatement ps = null;
 ResultSet rs = null;
 try
 {
  ps = conexion.prepareStatement(SQL_LOGIN);
  rs = ps.executeQuery();

  while(rs.next())
  {
   usuarioBD = rs.getString("nombreUsu");
   passwordBD = rs.getString("passwordUsu");
   rolBD = rs.getString("role");
   correoBD = rs.getString("correoUsu");

   if((correoUsu.equals(correoBD) || userName.equals(usuarioBD)) && password.equals(passwordBD) && rolBD.equals("Admin"))
        return "Admin_Role";
   else if((correoUsu.equals(correoBD) || userName.equals(usuarioBD)) && password.equals(passwordBD) && rolBD.equals("Editor"))
        return "Editor_Role";
   else if((correoUsu.equals(correoBD) || userName.equals(usuarioBD)) && password.equals(passwordBD) && rolBD.equals("User"))
        return "User_Role";
  }
 }
 catch(SQLException e)
 {
  e.printStackTrace();
 }
 return "Invalid user credentials";
}
}