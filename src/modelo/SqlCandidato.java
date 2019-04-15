/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Primario
 */
public class SqlCandidato extends Conexion{
    public boolean registrar(Candidato can) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "insert into candidato(idCandidato,nombre_candidato,apellido_candidato,carrera_candidato,nivel_candidato,tipo_id_candidato) \n" +
"values (?,?,?,?,?,?);";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(can.getIdentificacion()));
            ps.setString(2, can.getNombre());
            ps.setString(3, can.getApellido());
            ps.setString(4, can.getCarrera());
            ps.setString(5, String.valueOf(can.getNivel()));
            ps.setString(6, can.getTipo_id());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }
    
    public boolean eliminar(Candidato can) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "delete from candidato where idCandidato=?;";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(can.getIdentificacion()));
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }
    
    public void buscar(Candidato can){
        try{
            Connection con = getConexion();
            PreparedStatement pst = con.prepareStatement("select * from candidato where idCandidato = ?");
            pst.setString(1, String.valueOf(can.getIdentificacion()));
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                can.setNombre(rs.getString("nombre_candidato"));
                can.setApellido(rs.getString("apellido_candidato"));
                can.setIdentificacion(rs.getInt("idCandidato"));
                can.setTipo_id(rs.getString("tipo_id_candidato"));
                can.setCarrera(rs.getString("carrera_candidato"));
                can.setNivel(rs.getInt("nivel_candidato"));
            } else {
                JOptionPane.showMessageDialog(null, "Candidato no registrado!");
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    public int contarCandidatos(Votos votos){
        try {
            Connection con = getConexion();
            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery("select count(idCandidato) as num_candidatos from candidato;");
            if(rs.next()){
                votos.setNumCandiatos(Integer.parseInt(rs.getString("num_candidatos")));
                return votos.getNumCandiatos();
            }else{
                JOptionPane.showMessageDialog(null, "No se han ingresado candidatos");
                return 0;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return 0;
        }
    }
    
    public void buscarPorNombreApellido(Candidato can){
        try{
            Connection con = getConexion();
            PreparedStatement pst = con.prepareStatement("select * from candidato where nombre_candidato = ? and apellido_candidato=?");
            pst.setString(1, String.valueOf(can.getNombre()));
            pst.setString(2, String.valueOf(can.getApellido()));
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                can.setNombre(rs.getString("nombre_candidato"));
                can.setApellido(rs.getString("apellido_candidato"));
                can.setIdentificacion(rs.getInt("idCandidato"));
                can.setTipo_id(rs.getString("tipo_id_candidato"));
                can.setCarrera(rs.getString("carrera_candidato"));
                can.setNivel(rs.getInt("nivel_candidato"));
            } else {
                JOptionPane.showMessageDialog(null, "Candidato no registrado!");
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
}
