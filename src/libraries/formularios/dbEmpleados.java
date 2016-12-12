/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.formularios;

import Formularios.Mantenimiento.MantenimientoEmpleados;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import libraries.conexion.Conexion;
import libraries.identidades.Cargo;
import libraries.identidades.Empleado;
import libraries.identidades.User;

/**
 *
 * @author Ellet
 */
public class dbEmpleados {
    
    
    public void IngresarRegistros(Empleado empleado){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("INSERT INTO empleados(codigo_empleado,cedula,nombres_empleado,apellidos_empleado,direccion,telefono,id_cargo,id_user,fechanacimiento) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, empleado.getCodigo_empleado().toUpperCase());
            pst.setString(2, empleado.getCedula());
            pst.setString(3, empleado.getNombres_empleado().toUpperCase());
            pst.setString(4, empleado.getApellidos_empleado().toUpperCase());
            pst.setString(5, empleado.getDireccion().toUpperCase());
            pst.setString(6, empleado.getTelefono());
            pst.setInt(7, empleado.getCargo().getId_cargos());
            pst.setInt(8, empleado.getUser().getId_user());
            pst.setDate(9, ConvertirFechaSql(empleado.getFechanacimiento()));
            pst.executeUpdate();
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public java.sql.Date ConvertirFechaSql(java.util.Date fecha ){
        java.sql.Date date = new Date(fecha.getTime());
        return date;
    }
    
    public java.util.Date ConvertirFechaUtil(java.sql.Date fecha){
        java.util.Date date = new Date(fecha.getTime());
        return date;
    }
            
    public void ModificarRegistros(Empleado empleado){
        Conexion con = new Conexion();
        String sentencia = "UPDATE empleados SET codigo_empleado=?,cedula=?,nombres_empleado=?,apellidos_empleado=?,direccion=?,telefono=?,id_cargo=?,id_user=?,fechanacimiento=? WHERE id_empleado = ?"; 
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement(sentencia);
            pst.setInt(10, empleado.getId_empleado());
            pst.setString(1, empleado.getCodigo_empleado().toUpperCase());
            pst.setString(2, empleado.getCedula());
            pst.setString(3, empleado.getNombres_empleado().toUpperCase());
            pst.setString(4, empleado.getApellidos_empleado().toUpperCase());
            pst.setString(5, empleado.getDireccion().toUpperCase());
            pst.setString(6, empleado.getTelefono().toUpperCase());
            pst.setInt(7, empleado.getCargo().getId_cargos());
            pst.setInt(8, empleado.getUser().getId_user());
            pst.setDate(9, ConvertirFechaSql(empleado.getFechanacimiento()));
            pst.executeUpdate();
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Empleado ConsultarRegistros(String parametro){
        Conexion con = new Conexion();
        Empleado empleado = null;
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT cargos.*,users.*,empleados.* FROM empleados " 
                                                      +"INNER JOIN cargos ON empleados.id_cargo = cargos.id_cargo "
                                                      +"INNER JOIN users ON empleados.id_user = users.id_user "
                                                      +"WHERE codigo_empleado = ?");
            pst.setString(1, parametro.toUpperCase());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Cargo cargo = new Cargo(rs.getInt(1),rs.getString(2));
                User user = new User(rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6));
                empleado = new Empleado(rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),
                                        rs.getString(11),rs.getString(12),rs.getString(13),cargo,user,
                                        ConvertirFechaUtil(rs.getDate(16)));
            }
            else{
                JOptionPane.showMessageDialog(null,"NO SE ENCONTRO EMPLEADO CON ESE CODIGO","VALUE NOT FOUND",JOptionPane.ERROR_MESSAGE);
            }
            return empleado;
            
        }
        catch(SQLException exc){
             JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
             return null;
        }
    }
    
    public void EliminarRegistros(int val){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("DELETE FROM empleados WHERE id_empleado = ?");
            pst.setInt(1, val);
            pst.executeUpdate();
        }
        catch(SQLException exc){
             JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
}
    
    
    