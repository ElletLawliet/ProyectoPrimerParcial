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
public class Proveedor {
    int id_proveedores;
    String codigo_proveedores;
    String nombre_proveedores;
    String tipo_producto;
    

    public Proveedor(int id_proveedores, String codigo_proveedores, String nombre_proveedores, String tipo_producto) {
        this.id_proveedores = id_proveedores;
        this.codigo_proveedores = codigo_proveedores;
        this.nombre_proveedores = nombre_proveedores;
        this.tipo_producto = tipo_producto;
       
    }

    public Proveedor(String codigo_proveedores, String nombre_proveedores, String tipo_producto) {
        this.codigo_proveedores = codigo_proveedores;
        this.nombre_proveedores = nombre_proveedores;
        this.tipo_producto = tipo_producto;
    }
    
    
    
    public Proveedor(){
        
    }

    public int getId_proveedores() {
        return id_proveedores;
    }

    public void setId_proveedores(int id_proveedores) {
        this.id_proveedores = id_proveedores;
    }

    public String getCodigo_proveedores() {
        return codigo_proveedores;
    }

    public void setCodigo_proveedores(String codigo_proveedores) {
        this.codigo_proveedores = codigo_proveedores;
    }

    public String getNombre_proveedores() {
        return nombre_proveedores;
    }

    public void setNombre_proveedores(String nombre_proveedores) {
        this.nombre_proveedores = nombre_proveedores;
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    @Override
    public String toString(){
        return this.nombre_proveedores;
    }
    
    
    
}
