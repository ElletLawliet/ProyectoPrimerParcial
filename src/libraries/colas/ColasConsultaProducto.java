/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.colas;

import Formularios.Inventario.ConsultarProducto;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ellet
 */
public class ColasConsultaProducto {
    class Nodo{
        private String codigo;
        private String nombre;
        private String descripcion;
        private String tipo;
        private double precio;
        private int cantidad;
        private String proveedor;
        private Nodo siguiente;

        public Nodo(String codigo, String nombre, String descripcion, String tipo, double precio, int cantidad, String proveedor, Nodo siguiente) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.tipo = tipo;
            this.precio = precio;
            this.cantidad = cantidad;
            this.proveedor = proveedor;
            this.siguiente = siguiente;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
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

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public String getProveedor() {
            return proveedor;
        }

        public void setProveedor(String proveedor) {
            this.proveedor = proveedor;
        }
    }
    
    Nodo inicio,fondo;
    public ColasConsultaProducto(){
        inicio = null;
        fondo = null;
    }
    
    public void InsertarNodo(String codigo,String nombre,String descripcion,String tipo, double precio, int cantidad, String proveedor){
        Nodo nuevo = new Nodo(codigo,nombre,descripcion,tipo,precio,cantidad,proveedor,null);
        if(inicio == null){
            inicio = nuevo;
            fondo = nuevo;
        }
        else{
            fondo.setSiguiente(nuevo);
            fondo = nuevo;
        }
    }
    
    public DefaultTableModel LlenarArray(){
        Object tabla [] = new Object[ConsultarProducto.tablaconsultaproductos.getColumnCount()];
        DefaultTableModel   model = (DefaultTableModel) ConsultarProducto.tablaconsultaproductos.getModel();
        Nodo temp = inicio;
        while(temp != null){
            tabla[0] = temp.codigo;
            tabla[1] = temp.nombre;
            tabla[2] = temp.descripcion;
            tabla[3] = temp.tipo;
            tabla[4] = temp.precio;
            tabla[5] = temp.cantidad;
            tabla[6] = temp.proveedor;
            model.addRow(tabla);
            temp = temp.getSiguiente();
        }
        return model;
    }
    
}
