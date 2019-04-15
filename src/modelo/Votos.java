/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Primario
 */
public class Votos {
    private int idVotos;
    private char voto;
    private char blanco;
    private int idCandidato;
    private int numCandiatos;
    private int numVotantes;
    private int numBlancos;

    public int getNumBlancos() {
        return numBlancos;
    }

    public void setNumBlancos(int numBlancos) {
        this.numBlancos = numBlancos;
    }

    public char getBlanco() {
        return blanco;
    }

    public void setBlanco(char blanco) {
        this.blanco = blanco;
    }

    public int getNumCandiatos() {
        return numCandiatos;
    }

    public void setNumCandiatos(int numCandiatos) {
        this.numCandiatos = numCandiatos;
    }

    public int getNumVotantes() {
        return numVotantes;
    }

    public void setNumVotantes(int numVotantes) {
        this.numVotantes = numVotantes;
    }
    
    public int getIdVotos() {
        return idVotos;
    }

    public char getVoto() {
        return voto;
    }

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdVotos(int idVotos) {
        this.idVotos = idVotos;
    }

    public void setVoto(char voto) {
        this.voto = voto;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }
    
    
}
