/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.identidades;

import java.util.Date;

/**
 *
 * @author Ellet
 */
public class VentaProducto {
    private int id_ventas_producto;
     private int cantidad;
    private Date fecha;
    private String codigo_producto;
    private String nombre_producto;
    private double precio_unitario;
    private double total;
    private VentaGeneral ventageneral;

    public VentaProducto() {
    }

    public VentaProducto(int id_ventas_producto, int cantidad, Date fecha, String codigo_producto, String nombre_producto, double precio_unitario, double total, VentaGeneral ventageneral) {
        this.id_ventas_producto = id_ventas_producto;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.codigo_producto = codigo_producto;
        this.nombre_producto = nombre_producto;
        this.precio_unitario = precio_unitario;
        this.total = total;
        this.ventageneral = ventageneral;
    }

    public VentaProducto(int cantidad, Date fecha, String codigo_producto, String nombre_producto, double precio_unitario, double total, VentaGeneral ventageneral) {
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.codigo_producto = codigo_producto;
        this.nombre_producto = nombre_producto;
        this.precio_unitario = precio_unitario;
        this.total = total;
        this.ventageneral = ventageneral;
    }
    
    

    public VentaGeneral getVentageneral() {
        return ventageneral;
    }

    public void setVentageneral(VentaGeneral ventageneral) {
        this.ventageneral = ventageneral;
    }

    public int getId_ventas_producto() {
        return id_ventas_producto;
    }

    public void setId_ventas_producto(int id_ventas_producto) {
        this.id_ventas_producto = id_ventas_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
}
