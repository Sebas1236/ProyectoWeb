package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
        private static final String usuario = "root";
        private static final String clave = "root";
        private static final String url = "jdbc:mysql://localhost:3306/proyectoWeb";
        //?serverTimezone=America/Mexico_City&allowPublicKeyRetrieval=true&useSSL=false
        private static final String driver = "com.mysql.cj.jdbc.Driver";
        
        
        public static Connection getConnection() throws SQLException, ClassNotFoundException{
            Class.forName(driver);
            return DriverManager.getConnection(url, usuario, clave);
        }   
        public static void close(ResultSet rs) throws SQLException
        {
            rs.close();
        }
        public static void close(Statement smtm) throws SQLException
        {
            smtm.close();
        }
        public static void close(PreparedStatement smtm) throws SQLException
        {
            smtm.close();
        }
        public static void close(Connection conn) throws SQLException
        {
            conn.close();
        }
}
