/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.colas;

import Formularios.Ventas.ConsultaRecargas;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ellet
 */
public class ColasConsultaRecargas {
    class Nodo{
        private int id_recarga;
        private String fecha;
        private String numero;
        private double monto;
        private String empleado;
        private String promocion;
        private double total;
        private Nodo siguiente;

        public Nodo(int id_recarga, String fecha, String numero, double monto, String empleado, String promocion, double total, Nodo siguiente) {
            this.id_recarga = id_recarga;
            this.fecha = fecha;
            this.numero = numero;
            this.monto = monto;
            this.empleado = empleado;
            this.promocion = promocion;
            this.total = total;
            this.siguiente = siguiente;
        }

        public int getId_recarga() {
            return id_recarga;
        }

        public void setId_recarga(int id_recarga) {
            this.id_recarga = id_recarga;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public String getNumero() {
            return numero;
        }

        public void setNumero(String numero) {
            this.numero = numero;
        }

        public double getMonto() {
            return monto;
        }

        public void setMonto(double monto) {
            this.monto = monto;
        }

        public String getEmpleado() {
            return empleado;
        }

        public void setEmpleado(String empleado) {
            this.empleado = empleado;
        }

        public String getPromocion() {
            return promocion;
        }

        public void setPromocion(String promocion) {
            this.promocion = promocion;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
        
        
        
    }  
    
    Nodo inicio,fondo;
    
    public ColasConsultaRecargas(){
        inicio = null;
        fondo = null;
    }
    
    public void InsertarCola(int id_recarga, String fecha, String numero, double monto, String empleado, String promocion, double total){
        Nodo nuevo = new Nodo(id_recarga,fecha,numero,monto,empleado,promocion,total,null);
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
        DefaultTableModel model = (DefaultTableModel) ConsultaRecargas.tbconsultarecargas.getModel();
        Object []tabla = new Object[ConsultaRecargas.tbconsultarecargas.getColumnCount()];
        Nodo temp = inicio;
        while(temp != null){
            tabla[0] =  temp.id_recarga;
            tabla[1] =  temp.fecha;
            tabla[2] =  temp.numero;
            tabla[3] =  temp.monto;
            tabla[4] =  temp.empleado;
            tabla[5] =  temp.promocion;
            tabla[6] =  temp.total;
            temp = temp.getSiguiente();
            model.addRow(tabla);
        }
        return model;
    }
    
    
    
}
