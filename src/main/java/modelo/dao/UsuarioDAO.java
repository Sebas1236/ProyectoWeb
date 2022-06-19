package modelo.dao;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.UsuarioDTO;
import modelo.entidades.Usuario;

public class UsuarioDAO {
        
    private static final String SQL_INSERT = "insert into Usuario(nombreUsu, passwordUsu, correoUsu) values (?, ?, ?)";
    private static final String SQL_UPDATE = "update Usuario set nombreUsu = ?, correoUsu = ? where idUsu = ?";
    private static final String SQL_DELETE = "delete from Usuario where idUsu = ?";
    private static final String SQL_READ = "select * from Usuario where idUsu = ?";
    private static final String SQL_READ_ALL = "select * from Usuario";
    private static final String SQL_LOGIN = "select * from Usuario where (nombreUsu = ? or correoUsu = ?) and passwordUsu = ?";
    private Connection conexion;

    public void create(UsuarioDTO dto) throws SQLException, ClassNotFoundException {
        conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombreUsu());
            ps.setString(2, dto.getEntidad().getPasswordUsu());
            ps.setString(3, dto.getEntidad().getCorreoUsu());
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
            ps.setString(2, dto.getEntidad().getCorreoUsu());
            ps.setInt(3, dto.getEntidad().getIdUsu());
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
    public List<Usuario> listar() throws SQLException, ClassNotFoundException {
        conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            ps = conexion.prepareStatement(SQL_READ_ALL);
            rs = ps.executeQuery();
            while(rs.next())
            {
                int idUsu = rs.getInt("idUsu");
                String nombreUsu = rs.getString("nombreUsu");
                String correousu = rs.getString("correoUsu");
                String role = rs.getString("role");
                usuario = new Usuario(idUsu, nombreUsu, correousu,role);
                usuarios.add(usuario);
            }

        } finally {
                Conexion.close(ps);
                Conexion.close(conexion);
                Conexion.close(rs);
        }
        return usuarios;
    }
    
    public Boolean login(UsuarioDTO dto) throws SQLException, ClassNotFoundException
    {
        conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            ps = conexion.prepareStatement(SQL_LOGIN);
            ps.setString(1, dto.getEntidad().getNombreUsu());
            ps.setString(2, dto.getEntidad().getCorreoUsu());
            ps.setString(3, dto.getEntidad().getPasswordUsu());
            rs = ps.executeQuery();
            return rs.next();
        }finally
        {
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
            dto.getEntidad().setCorreoUsu(rs.getString("correoUsu"));
            dto.getEntidad().setRole(rs.getString("role"));
            //System.out.println("Correo: " + rs.getString("correoUsu"));
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
