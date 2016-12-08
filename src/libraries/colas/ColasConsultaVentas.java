/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.colas;

import Formularios.Ventas.ConsultaVenta;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ellet
 */
public class ColasConsultaVentas {
    class Nodo{
        private int codigoventa;
        private String fecha;
        private String nombrecliente;
        private String codigoproducto;
        private String nombreproducto;
        private double preciounitario;
        private int cantidad;
        private double total;
        private Nodo Siguiente;

        public Nodo(int codigoventa,String fecha, String nombrecliente, String codigoproducto, String nombreproducto, 
                double preciounitario, int cantidad, double total,Nodo Siguiente) {
            this.codigoventa = codigoventa;
            this.fecha = fecha;
            this.nombrecliente = nombrecliente;
            this.codigoproducto = codigoproducto;
            this.nombreproducto = nombreproducto;
            this.preciounitario = preciounitario;
            this.cantidad = cantidad;
            this.total = total;
           
            this.Siguiente = Siguiente;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public String getNombrecliente() {
            return nombrecliente;
        }

        public void setNombrecliente(String nombrecliente) {
            this.nombrecliente = nombrecliente;
        }

        public String getCodigoproducto() {
            return codigoproducto;
        }

        public void setCodigoproducto(String codigoproducto) {
            this.codigoproducto = codigoproducto;
        }

        public String getNombreproducto() {
            return nombreproducto;
        }

        public void setNombreproducto(String nombreproducto) {
            this.nombreproducto = nombreproducto;
        }

        public double getPreciounitario() {
            return preciounitario;
        }

        public void setPreciounitario(double preciounitario) {
            this.preciounitario = preciounitario;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public Nodo getSiguiente() {
            return Siguiente;
        }

        public void setSiguiente(Nodo Siguiente) {
            this.Siguiente = Siguiente;
        }

        public int getCodigoventa() {
            return codigoventa;
        }

        public void setCodigoventa(int codigoventa) {
            this.codigoventa = codigoventa;
        }

        
        
        
        
        
    }
    
    Nodo inicio,fondo;

    public ColasConsultaVentas( ) {
        inicio = null;
        fondo = null;
    }
        
    public void InsertarCola(int codigoventa,String fecha, String nombrecliente, String codigoproducto,
            String nombreproducto, double preciounitario, int cantidad, double total){
        Nodo nuevo = new Nodo(codigoventa,fecha,nombrecliente,codigoproducto,nombreproducto,preciounitario,cantidad,total,null);
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
        DefaultTableModel model = (DefaultTableModel) ConsultaVenta.tablaconsultaventasproducto.getModel();
        Object []tabla = new Object[ConsultaVenta.tablaconsultaventasproducto.getColumnCount()];
        Nodo temp = inicio;
        while(temp != null){
            tabla[0] =  temp.codigoventa;
            tabla[1] =  temp.fecha;
            tabla[2] =  temp.nombrecliente;
            tabla[3] =  temp.codigoproducto;
            tabla[4] =  temp.nombreproducto;
            tabla[5] =  temp.preciounitario;
            tabla[6] =  temp.cantidad;
            tabla[7] =  temp.total;
            temp = temp.getSiguiente();
            model.addRow(tabla);
        }
        return model;
    }
    
    
}
