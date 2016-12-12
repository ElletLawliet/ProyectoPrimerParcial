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
public class VentaGeneral{
    private int id_venta_general;
    private String nombre_cliente;
    private Empleado empleado;
    private Date fecha;
    private String cedulaCliente;
    private double total;

    public VentaGeneral() {
    }

    public VentaGeneral(int id_venta_general, String nombre_cliente, Empleado empleado, Date fecha, String cedulaCliente, double total) {
        this.id_venta_general = id_venta_general;
        this.nombre_cliente = nombre_cliente;
        this.empleado = empleado;
        this.fecha = fecha;
        this.cedulaCliente = cedulaCliente;
        this.total = total;
    }

    public VentaGeneral(String nombre_cliente, Empleado empleado, Date fecha, String cedulaCliente, double total) {
        this.nombre_cliente = nombre_cliente;
        this.empleado = empleado;
        this.fecha = fecha;
        this.cedulaCliente = cedulaCliente;
        this.total = total;
    }
    
    

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId_venta_general() {
        return id_venta_general;
    }

    public void setId_venta_general(int id_venta_general) {
        this.id_venta_general = id_venta_general;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }
    
    
    
    
}



