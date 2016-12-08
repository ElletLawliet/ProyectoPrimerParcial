/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.identidades;

import java.sql.Date;

/**
 *
 * @author Ellet
 */
public class VentaRecarga {
    private int id_venta_recargas;
    private Date fecha;
    private String cliente;
    private String numero;
    private int monto;
    private Empleado empleado;
    private Promocion promocion;
    private double total;

    public VentaRecarga() {
    }

    public VentaRecarga(int id_venta_recargas, Date fecha, String cliente, String numero, int monto, Empleado empleado, Promocion promocion, double total) {
        this.id_venta_recargas = id_venta_recargas;
        this.fecha = fecha;
        this.cliente = cliente;
        this.numero = numero;
        this.monto = monto;
        this.empleado = empleado;
        this.promocion = promocion;
        this.total = total;
    }

    public VentaRecarga(Date fecha, String cliente, String numero, int monto, Empleado empleado, Promocion promocion, double total) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.numero = numero;
        this.monto = monto;
        this.empleado = empleado;
        this.promocion = promocion;
        this.total = total;
    }
    
    

    public int getId_venta_recargas() {
        return id_venta_recargas;
    }

    public void setId_venta_recargas(int id_venta_recargas) {
        this.id_venta_recargas = id_venta_recargas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
