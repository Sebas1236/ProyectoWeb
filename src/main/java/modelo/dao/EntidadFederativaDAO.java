package modelo.dao;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.EntidadFederativaDTO;
import modelo.entidades.EntidadFederativa;

public class EntidadFederativaDAO {
    private static final String SQL_INSERT = "insert into entidadfederativa(nombreEnt) values (?)";
    private static final String SQL_UPDATE = "update entidadfederativa set nombreEnt = ? where idEnt=?";
    private static final String SQL_DELETE = "delete from entidadfederativa where idEnt = ?";
    private static final String SQL_READ = "select * from entidadfederativa where idEnt = ?";
    private static final String SQL_READ_ALL = "select * from entidadfederativa";
    private Connection conexion;
        public void create(EntidadFederativaDTO dto) throws SQLException, ClassNotFoundException {
        conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombreEnt());
            ps.executeUpdate();
        } finally {
                Conexion.close(ps);
                Conexion.close(conexion);
        }
    }

    public void update(EntidadFederativaDTO dto) throws SQLException, ClassNotFoundException {
        conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombreEnt());
            ps.setInt(2, dto.getEntidad().getIdEnt());
            ps.executeUpdate();
        } finally {
                Conexion.close(ps);
                Conexion.close(conexion);
        }
    }

    public void delete(EntidadFederativaDTO dto) throws SQLException, ClassNotFoundException {
        conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdEnt());
            ps.executeUpdate();
        } finally {
                Conexion.close(ps);
                Conexion.close(conexion);
        }
    }

    public EntidadFederativaDTO read(EntidadFederativaDTO dto) throws SQLException, ClassNotFoundException {
        conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdEnt());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (EntidadFederativaDTO) resultados.get(0);
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
        public List<EntidadFederativa> listar() throws SQLException, ClassNotFoundException {
        conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        EntidadFederativa ef = null;
        List<EntidadFederativa> efs = new ArrayList<>();
        try {
            ps = conexion.prepareStatement(SQL_READ_ALL);
            rs = ps.executeQuery();
            while(rs.next())
            {
                int idEnt = rs.getInt("idEnt");
                String nombreEnt = rs.getString("nombreEnt");
                ef = new EntidadFederativa(idEnt, nombreEnt);
                efs.add(ef);
            }

        } finally {
                Conexion.close(ps);
                Conexion.close(conexion);
                Conexion.close(rs);
        }
        return efs;
    }

    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultado = new ArrayList();
        while (rs.next()) {
            EntidadFederativaDTO dto = new EntidadFederativaDTO();
            dto.getEntidad().setIdEnt(rs.getInt("idEnt"));
            dto.getEntidad().setNombreEnt(rs.getString("nombreEnt"));
            resultado.add(dto);
        }
        return resultado;
    }
    
}
