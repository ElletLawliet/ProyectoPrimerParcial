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
public class ConsultaRecarga {
    private int codigoRecarga;
    private Date fecha;
    private String numero;
    private double monto;
    private String empleado;
    private String promocion;
    private double total;

    public ConsultaRecarga(int codigoRecarga, Date fecha, String numero, double monto, String empleado, String promocion, double total) {
        this.codigoRecarga = codigoRecarga;
        this.fecha = fecha;
        this.numero = numero;
        this.monto = monto;
        this.empleado = empleado;
        this.promocion = promocion;
        this.total = total;
    }

    public int getCodigoRecarga() {
        return codigoRecarga;
    }

    public void setCodigoRecarga(int codigoRecarga) {
        this.codigoRecarga = codigoRecarga;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
    
    
}
