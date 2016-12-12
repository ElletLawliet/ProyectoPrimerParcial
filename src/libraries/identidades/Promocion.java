/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.identidades;

/**
 *
 * @author Ellet
 */
public class Promocion {
    private int id_promociones;
    private String codigo_promocion;
    private String nombre_promocion;
    private String descripcion;
    private String tipo;

    public Promocion(int id_promociones, String codigo_promocion, String nombre_promocion, String descripcion, String tipo) {
        this.id_promociones = id_promociones;
        this.codigo_promocion = codigo_promocion;
        this.nombre_promocion = nombre_promocion;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public Promocion(String codigo_promocion, String nombre_promocion, String descripcion, String tipo) {
        this.codigo_promocion = codigo_promocion;
        this.nombre_promocion = nombre_promocion;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }
    
    
    public Promocion(){
        
    }

    public int getId_promociones() {
        return id_promociones;
    }

    public void setId_promociones(int id_promociones) {
        this.id_promociones = id_promociones;
    }

    public String getCodigo_promocion() {
        return codigo_promocion;
    }

    public void setCodigo_promocion(String codigo_promocion) {
        this.codigo_promocion = codigo_promocion;
    }

    public String getNombre_promocion() {
        return nombre_promocion;
    }

    public void setNombre_promocion(String nombre_promocion) {
        this.nombre_promocion = nombre_promocion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString(){
        return this.nombre_promocion;
    }
    
}
