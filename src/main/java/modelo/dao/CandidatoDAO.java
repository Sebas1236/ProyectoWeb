/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import modelo.dto.CandidatoDTO;

/**
 *
 * @author Sebastián
 */
public class CandidatoDAO {
            
    private static final String SQL_INSERT = "insert into Candidato(nombreCan, fechanacCan, curriculumCan"
            + ",idOcupabilidadCan, EntidadFederativa_idEnt, idusuarioCan) values (?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "update Candidato set nombreCan = ?, fechanacCan = ? "
            + "curriculumCan = ? where idCan = ?";
    private static final String SQL_DELETE = "delete from Candidato where idCan = ?";
    private static final String SQL_READ = "select * from Candidato where idCan = ?";
    private static final String SQL_READ_ALL = "select * from Candidato";
    private Connection conexion;

    public void create(CandidatoDTO dto) throws SQLException , ClassNotFoundException{
        conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombreCan());
            ps.setDate(2, dto.getEntidad().getFechaNacCan());
            ps.setString(3, dto.getEntidad().getCurriculumCan());
            ps.setInt(4, dto.getEntidad().getIdOcupabilidadCan());
            ps.setInt(5, dto.getEntidad().getIdEntFed());
            ps.setInt(6, dto.getEntidad().getIdUsuarioCan());
            ps.executeUpdate();
        } finally {
                Conexion.close(ps);
                Conexion.close(conexion);
        }
    }

    public void update(CandidatoDTO dto) throws SQLException , ClassNotFoundException{
        conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombreCan());
            ps.setDate(2, dto.getEntidad().getFechaNacCan());
            ps.setString(3, dto.getEntidad().getCurriculumCan());
            ps.setInt(4, dto.getEntidad().getIdCan());
            ps.executeUpdate();
        } finally {
                Conexion.close(ps);
                Conexion.close(conexion);
        }
    }

    public void delete(CandidatoDTO dto) throws SQLException , ClassNotFoundException{
        conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdCan());
            ps.executeUpdate();
        } finally {
                Conexion.close(ps);
                Conexion.close(conexion);
        }
    }

    public CandidatoDTO read(CandidatoDTO dto) throws SQLException , ClassNotFoundException{
        conexion = Conexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdCan());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (CandidatoDTO) resultados.get(0);
            } else {
                return null;
            }
        } finally {
                Conexion.close(ps);
                Conexion.close(conexion);
                Conexion.close(rs);
        }
    }
    public List readAll() throws SQLException , ClassNotFoundException{
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
            CandidatoDTO dto = new CandidatoDTO();
            dto.getEntidad().setIdCan(rs.getInt("idCan"));
            dto.getEntidad().setNombreCan(rs.getString("nombreCandidato"));
            resultado.add(dto);
        }
        return resultado;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        CandidatoDTO dto = new CandidatoDTO();
        dto.getEntidad().setIdCan(4);
        //dto.getEntidad().setNombreEstado("escom");

        CandidatoDAO dao = new CandidatoDAO();
        try {
            //dao.create(dto);
            //dao.update(dto);
            //dao.delete(dto);
            //System.out.println(dao.read(dto));
            System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
