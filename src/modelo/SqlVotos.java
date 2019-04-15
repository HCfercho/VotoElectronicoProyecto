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
public class SqlVotos extends Conexion{
    public boolean registrar(Votos votos){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql ="insert into votos(idVotos,voto,Candidato_idCandidato,en_blanco) values (?,?,?,?);";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(votos.getIdVotos()));
            ps.setString(2, String.valueOf(votos.getVoto()));
            ps.setString(3, String.valueOf(votos.getIdCandidato()));
            ps.setString(4, String.valueOf(votos.getBlanco()));
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
    
    public int votosTotales(Votos votos){
        try {
            Connection con = getConexion();
            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery("select count(voto) as num_votos from votos where voto = 1 ;");
            if(rs.next()){
                votos.setNumVotantes(Integer.parseInt(rs.getString("num_votos")));
                return votos.getNumVotantes();
            }else{
                JOptionPane.showMessageDialog(null, "No se han registrado votos");
                return 0;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return 0;
        }
        
    }
    
    public int votosEnBlanco(Votos votos){
        try {
            Connection con = getConexion();
            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery("select count(en_blanco) as num_blancos from votos where en_blanco = 1 ;");
            if(rs.next()){
                votos.setNumBlancos(Integer.parseInt(rs.getString("num_blancos")));
                return votos.getNumBlancos();
            }else{
                JOptionPane.showMessageDialog(null, "No se han registrado votos en blanco");
                return 0;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return 0;
        }
    }
    
    public int contarVotosCandidato(Votos votos){
        try{
            Connection con = getConexion();
            PreparedStatement pst = con.prepareStatement("select count(*) as votos from votos where Candidato_idCandidato=? and voto = 1;");
            pst.setString(1, String.valueOf(votos.getIdCandidato()));
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                votos.setNumVotantes(rs.getInt("votos"));
                return votos.getNumVotantes();
                
            } else {
                JOptionPane.showMessageDialog(null, "No existen registros de votos");
                return 0;
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
            return 0;
        }
    }
}
