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
public class Empleado {
    private int id_empleado;
    private String codigo_empleado;
    private String cedula;
    private String nombres_empleado;
    private String apellidos_empleado;
    private String direccion;
    private String telefono;
    private Cargo cargo;
    private User user;
    private Date fechanacimiento;
    
    public Empleado(int id_empleado, String codigo_empleado, String cedula, String nombres_empleado, String apellidos_empleado, String direccion, String telefono, Cargo cargo, User user, Date fechanacimiento) {
        this.id_empleado = id_empleado;
        this.codigo_empleado = codigo_empleado;
        this.cedula = cedula;
        this.nombres_empleado = nombres_empleado;
        this.apellidos_empleado = apellidos_empleado;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cargo = cargo;
        this.user = user;
        this.fechanacimiento = fechanacimiento;
    }

    public Empleado(String codigo_empleado, String cedula, String nombres_empleado, String apellidos_empleado, String direccion, String telefono, Cargo cargo, User user, Date fechanacimiento) {
        this.codigo_empleado = codigo_empleado;
        this.cedula = cedula;
        this.nombres_empleado = nombres_empleado;
        this.apellidos_empleado = apellidos_empleado;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cargo = cargo;
        this.user = user;
        this.fechanacimiento = fechanacimiento;
    }

    
    
    public Empleado(){
        
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setCodigo_empleado(String codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres_empleado() {
        return nombres_empleado;
    }

    public void setNombres_empleado(String nombres_empleado) {
        this.nombres_empleado = nombres_empleado;
    }

    public String getApellidos_empleado() {
        return apellidos_empleado;
    }

    public void setApellidos_empleado(String apellidos_empleado) {
        this.apellidos_empleado = apellidos_empleado;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}