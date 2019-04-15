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
public class Estudiante {
    private int identificacion;
    private String nombre;
    private String apellido;
    private String tipo_id;
    private String carrera;
    private int nivel;

    public int getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTipo_id() {
        return tipo_id;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getNivel() {
        return nivel;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTipo_id(String tipo_id) {
        this.tipo_id = tipo_id;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
    
    
}
