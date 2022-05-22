package modelo.dao;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dto.UsuarioDTO;

public class UsuarioDAO {
        
    private static final String SQL_INSERT = "insert into Usuario(nombreUsu, passwordUsu) values (?, ?)";
    private static final String SQL_UPDATE = "update Usuario set nombreUsu = ? where idUsu = ?";
    private static final String SQL_DELETE = "delete from Usuario where idUsu = ?";
    private static final String SQL_READ = "select * from Usuario where idUsu = ?";
    private static final String SQL_READ_ALL = "select * from Usuario";
    private Connection conexion;

    public void create(UsuarioDTO dto) throws SQLException, ClassNotFoundException {
        conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombreUsu());
            ps.setString(2, dto.getEntidad().getPasswordUsu());
            ps.executeUpdate();
        } finally {
                Conexion.close(ps);
                Conexion.close(conexion);
        }
    }

    public void update(UsuarioDTO dto) throws SQLException, ClassNotFoundException {
        conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombreUsu());
            ps.setInt(2, dto.getEntidad().getIdUsu());
            ps.executeUpdate();
        } finally {
                Conexion.close(ps);
                Conexion.close(conexion);
        }
    }

    public void delete(UsuarioDTO dto) throws SQLException, ClassNotFoundException {
        conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdUsu());
            ps.executeUpdate();
        } finally {
                Conexion.close(ps);
                Conexion.close(conexion);
        }
    }

    public UsuarioDTO read(UsuarioDTO dto) throws SQLException, ClassNotFoundException {
        conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdUsu());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (UsuarioDTO) resultados.get(0);
            } else {
                return null;
            }
        } finally {
                Conexion.close(ps);
                Conexion.close(conexion);
                Conexion.close(rs);
        }
    }
    public List readAll() throws SQLException, ClassNotFoundException {
        conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ_ALL);
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados;
            } else {
                return null;
            }
        } finally {
                Conexion.close(ps);
                Conexion.close(conexion);
                Conexion.close(rs);
        }
    }

    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultado = new ArrayList();
        while (rs.next()) {
            UsuarioDTO dto = new UsuarioDTO();
            dto.getEntidad().setIdUsu(rs.getInt("idUsu"));
            dto.getEntidad().setNombreUsu(rs.getString("nombreUsu"));
            resultado.add(dto);
        }
        return resultado;
    }
/*
    public static void main(String[] args) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.getEntidad().setNombreUsu("usuario");
        dto.getEntidad().setPasswordUsu("CONTRASEÑaaa");
        //dto.getEntidad().setNombreEstado("escom");
        //private static final String SQL_INSERT = "insert into Usuario(nombreUsu, passwordUsu) values (?, ?)";
        UsuarioDAO dao = new UsuarioDAO();
        try {
            dao.create(dto);
            //dao.update(dto);
            //dao.delete(dto);
            //System.out.println(dao.read(dto));
            //System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

}
