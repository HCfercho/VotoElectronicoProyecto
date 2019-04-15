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
import javax.swing.JOptionPane;

/**
 *
 * @author Primario
 */
public class SqlVotante extends Conexion{
    public boolean registrar(Votante vot) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "insert into votante(idVotante,nombre_votante,apellido_votante,tipo_id,carrera_votante,nivel_votante,Usuario,contraseña) \n" +
"values (?,?,?,?,?,?,?,?);";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(vot.getIdentificacion()));
            ps.setString(2, vot.getNombre());
            ps.setString(3, vot.getApellido());
            ps.setString(4, vot.getTipo_id());
            ps.setString(5, vot.getCarrera());
            ps.setString(6, String.valueOf(vot.getNivel()));
            ps.setString(7, vot.getNombre() + " " + vot.getApellido());
            ps.setString(8, String.valueOf(vot.getIdentificacion()));
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
    
    public boolean eliminar(Votante vot) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "delete * from votante where idVotante=?;";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(vot.getIdentificacion()));
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
    
    public void buscar(Votante vot){
        try{
            Connection con = getConexion();
            PreparedStatement pst = con.prepareStatement("select * from votante where idVotante = ?");
            pst.setString(1, String.valueOf(vot.getIdentificacion()));
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                vot.setNombre(rs.getString("nombre_votante"));
                vot.setApellido(rs.getString("apellido_votante"));
                vot.setIdentificacion(rs.getInt("idVotante"));
                vot.setTipo_id(rs.getString("tipo_id"));
                vot.setCarrera(rs.getString("carrera_votante"));
                vot.setNivel(rs.getInt("nivel_votante"));
            } else {
                JOptionPane.showMessageDialog(null, "Votante no registrado!");
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
}
