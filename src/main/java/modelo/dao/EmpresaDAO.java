package modelo.dao;

import datos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dto.EmpresaDTO;
import modelo.entidades.Empresa;

public class EmpresaDAO {
    
    private static final String SQL_INSERT = "insert into Empresa(nombreEmp, logoEmp, esloganEmp, descripcionEmp,idUsuarioEmp) values (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "update Empresa set nombreEmp = ?, logoEmp = ?, esloganEmp = ?, descripcionEmp = ? where idEmpresa=?";
    private static final String SQL_DELETE = "delete from Empresa where idEmpresa = ?";
    private static final String SQL_READ = "select * from Empresa where idEmpresa = ?";
    private static final String SQL_READ_ALL = "select * from Empresa";
    private Connection conexion;

    public void create(EmpresaDTO dto) throws SQLException, ClassNotFoundException {
        conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombreEmp());
            ps.setString(2, dto.getEntidad().getLogoEmp());
            ps.setString(3, dto.getEntidad().getEsloganEmp());
            ps.setString(4, dto.getEntidad().getDescripcionEmp());
            ps.setInt(5, dto.getEntidad().getIdUsuarioEmp());
            ps.executeUpdate();
        } finally {
                Conexion.close(ps);
                Conexion.close(conexion);
        }
    }

    public void update(EmpresaDTO dto) throws SQLException, ClassNotFoundException {
        conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombreEmp());
            ps.setString(2, dto.getEntidad().getLogoEmp());
            ps.setString(3, dto.getEntidad().getEsloganEmp());
            ps.setString(4, dto.getEntidad().getDescripcionEmp());
            ps.setInt(5, dto.getEntidad().getIdEmpresa());
            ps.executeUpdate();
        } finally {
                Conexion.close(ps);
                Conexion.close(conexion);
        }
    }

    public void delete(EmpresaDTO dto) throws SQLException, ClassNotFoundException {
        conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdEmpresa());
            ps.executeUpdate();
        } finally {
                Conexion.close(ps);
                Conexion.close(conexion);
        }
    }

    public EmpresaDTO read(EmpresaDTO dto) throws SQLException, ClassNotFoundException {
        conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdEmpresa());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (EmpresaDTO) resultados.get(0);
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
    public List<Empresa> listar() throws SQLException, ClassNotFoundException {
        conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Empresa empresa = null;
        List<Empresa> empresas = new ArrayList<>();
        try {
            ps = conexion.prepareStatement(SQL_READ_ALL);
            rs = ps.executeQuery();
            while(rs.next())
            {
                int idEmpresa = rs.getInt("idEmpresa");
                String nombreEmp = rs.getString("nombreEmp");
                String logoEmp = rs.getString("logoEmp");
                String esloganEmp = rs.getString("esloganEmp");
                String descripcionEmp = rs.getString("descripcionEmp");
                int idusuarioEmp = rs.getInt("idusuarioEmp");
                empresa = new Empresa(idEmpresa, nombreEmp, logoEmp, esloganEmp, descripcionEmp, idusuarioEmp);
                empresas.add(empresa);
            }

        } finally {
                Conexion.close(ps);
                Conexion.close(conexion);
                Conexion.close(rs);
        }
        return empresas;
    }
    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultado = new ArrayList();
        while (rs.next()) {
            EmpresaDTO dto = new EmpresaDTO();
            dto.getEntidad().setIdEmpresa(rs.getInt("idEmpresa"));
            dto.getEntidad().setNombreEmp(rs.getString("nombreEmp"));
            dto.getEntidad().setLogoEmp(rs.getString("logoEmp"));
            dto.getEntidad().setEsloganEmp(rs.getString("esloganEmp"));
            dto.getEntidad().setDescripcionEmp(rs.getString("descripcionEmp"));
            dto.getEntidad().setIdUsuarioEmp(rs.getInt("idusuarioEmp"));
            resultado.add(dto);
        }
        return resultado;
    }
}
/*
    public static void main(String[] args) throws ClassNotFoundException {
        EmpresaDTO dto = new EmpresaDTO();
        dto.getEntidad().setNombreEmp("Coca Cola");
        dto.getEntidad().setLogoEmp("Logo");
        dto.getEntidad().setDescripcionEmp("Empresa coca cola xd");
        
        //dto.getEntidad().setNombreEstado("escom");
//    private static final String SQL_INSERT = "insert into Empresa(nombreEmp, logoEmp, esloganEmp, descripcionEmp,idUsuarioEmp) values (?, ?, ?, ?, ?)";
        EmpresaDAO dao = new EmpresaDAO();
        try {
            dao.create(dto);
            //dao.update(dto);
            //dao.delete(dto);
            //System.out.println(dao.read(dto));
            //System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}*/

