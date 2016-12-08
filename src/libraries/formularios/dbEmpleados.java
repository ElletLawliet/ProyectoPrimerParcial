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
import libraries.identidades.Empleado;

/**
 *
 * @author Ellet
 */
public class dbEmpleados {
    
    public void IngresarIdentidades(){
        Empleado id = new Empleado();
        id.setCodigo_empleado(MantenimientoEmpleados.txtcodigo.getText());
        id.setCedula(MantenimientoEmpleados.txtcedula.getText());
        id.setNombres_empleado(MantenimientoEmpleados.txtnombre.getText());
        id.setApellidos_empleado(MantenimientoEmpleados.txtapellido.getText());
        id.setFechanacimiento(ConvertirFecha());
        id.setDireccion(MantenimientoEmpleados.txtdireccion.getText());
        id.setTelefono(MantenimientoEmpleados.txttelefono.getText());
        id.setId_cargo(IdCargo());
        id.setId_user(Integer.parseInt(MantenimientoEmpleados.txtiduser.getText()));
        IngresarRegistros(id);
    }
    public void IngresarRegistros(Empleado id){
        
        
        //LLENAR TABLA EMPLEADO
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("INSERT INTO empleados(codigo_empleado,cedula,nombres_empleado,apellidos_empleado,direccion,telefono,id_cargo,id_user,fechanacimiento) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, id.getCodigo_empleado().toUpperCase());
            pst.setString(2, id.getCedula());
            pst.setString(3, id.getNombres_empleado().toUpperCase());
            pst.setString(4, id.getApellidos_empleado().toUpperCase());
            pst.setString(5, id.getDireccion().toUpperCase());
            pst.setString(6, id.getTelefono());
            pst.setInt(7, id.getId_cargo());
            pst.setInt(8, id.getId_user());
            pst.setDate(9, id.getFechanacimiento());
            pst.executeUpdate();
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public Date ConvertirFecha(){
        Date date = new Date(MantenimientoEmpleados.txtfechanacimiento.getDate().getTime());
        return date;
    }
    
    public int IdCargo(){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT id_cargo FROM cargos WHERE nombre_cargo = '" + MantenimientoEmpleados.cbcargo.getSelectedItem().toString().toUpperCase()+ "'");
            ResultSet rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
    
    public void ModificarIdentidades(){
        Empleado id = new Empleado();
        id.setCodigo_empleado(MantenimientoEmpleados.txtcodigo.getText());
        id.setCedula(MantenimientoEmpleados.txtcedula.getText());
        id.setNombres_empleado(MantenimientoEmpleados.txtnombre.getText());
        id.setApellidos_empleado(MantenimientoEmpleados.txtapellido.getText());
        id.setFechanacimiento(ConvertirFecha());
        id.setDireccion(MantenimientoEmpleados.txtdireccion.getText());
        id.setTelefono(MantenimientoEmpleados.txttelefono.getText());
        id.setId_cargo(IdCargo());
        id.setId_user(Integer.parseInt(MantenimientoEmpleados.txtiduser.getText()));
        ModificarRegistros(id);
    }
    
    public void ModificarRegistros(Empleado id){
        Conexion con = new Conexion();
        String sentencia = "UPDATE empleados SET codigo_empleado=?,cedula=?,nombres_empleado=?,apellidos_empleado=?,direccion=?,telefono=?,id_cargo=?,id_user=?,fechanacimiento=? WHERE id_empleado ="+ MantenimientoEmpleados.txtidempleado.getText(); 
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement(sentencia);
            pst.setString(1, id.getCodigo_empleado().toUpperCase());
            pst.setString(2, id.getCedula());
            pst.setString(3, id.getNombres_empleado().toUpperCase());
            pst.setString(4, id.getApellidos_empleado().toUpperCase());
            pst.setString(5, id.getDireccion().toUpperCase());
            pst.setString(6, id.getTelefono().toUpperCase());
            pst.setInt(7, id.getId_cargo());
            pst.setInt(8, id.getId_user());
            pst.setDate(9, id.getFechanacimiento());
            pst.executeUpdate();
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void ConsultarRegistros(){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT empleados.*,cargos.nombre_cargo FROM empleados INNER JOIN cargos ON empleados.id_cargo = cargos.id_cargo WHERE codigo_empleado = '" + MantenimientoEmpleados.txtcodigo.getText().toUpperCase()+ "'");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                MantenimientoEmpleados.txtidempleado.setText(rs.getString(1));
                MantenimientoEmpleados.txtcodigo.setText(rs.getString(2));
                MantenimientoEmpleados.txtcedula.setText(rs.getString(3));
                MantenimientoEmpleados.txtnombre.setText(rs.getString(4));
                MantenimientoEmpleados.txtapellido.setText(rs.getString(5));
                MantenimientoEmpleados.txtdireccion.setText(rs.getString(6));
                MantenimientoEmpleados.txttelefono.setText(rs.getString(7));
                MantenimientoEmpleados.txtiduser.setText(rs.getString(9));
                MantenimientoEmpleados.txtfechanacimiento.setDate(rs.getDate(10)); 
                MantenimientoEmpleados.cbcargo.setSelectedItem(rs.getString(11));
            }
            else{
                JOptionPane.showMessageDialog(null,"NO SE ENCONTRO EMPLEADO CON ESE CODIGO","VALUE NOT FOUND",JOptionPane.ERROR_MESSAGE);
            }
            
            
        }
        catch(SQLException exc){
             JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void EliminarRegistros(){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("DELETE FROM empleados WHERE id_empleado = "+ MantenimientoEmpleados.txtidempleado.getText());
            pst.executeUpdate();
        }
        catch(SQLException exc){
             JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void CargarCargos(){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT nombre_cargo FROM cargos");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                MantenimientoEmpleados.cbcargo.addItem(rs.getString(1));
            }
            MantenimientoEmpleados.cbcargo.setSelectedIndex(-1);
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void Limpiar(){
        MantenimientoEmpleados.txtidempleado.setText("");
        MantenimientoEmpleados.txtcodigo.setText("");
        MantenimientoEmpleados.txtcedula.setText("");
        MantenimientoEmpleados.txtnombre.setText("");
        MantenimientoEmpleados.txtapellido.setText("");
        MantenimientoEmpleados.txtfechanacimiento.setDate(null);
        MantenimientoEmpleados.txtdireccion.setText("");
        MantenimientoEmpleados.txttelefono.setText("");
        MantenimientoEmpleados.txtiduser.setText("");
        MantenimientoEmpleados.cbcargo.setSelectedIndex(-1);
    }

    public boolean ValidacionEspaciosGuardar(){
        boolean espacio = false;
        if(MantenimientoEmpleados.txtnombre.getText().replaceAll("\\s", "").equals("")){
            espacio = true;
        }
        if(MantenimientoEmpleados.txtapellido.getText().replaceAll("\\s", "").equals("")){
            espacio = true;
        }
        if(MantenimientoEmpleados.txtcedula.getText().replaceAll("\\s", "").equals("")){
            espacio = true;
        }if(MantenimientoEmpleados.txtcodigo.getText().replaceAll("\\s", "").equals("")){
            espacio = true;
        }
        if(MantenimientoEmpleados.txtdireccion.getText().replaceAll("\\s", "").equals("")){
            espacio = true;
        }
        if(MantenimientoEmpleados.txtfechanacimiento.getDate() == null){
            espacio = true;
        }
        if(MantenimientoEmpleados.txttelefono.getText().replaceAll("\\s", "").equals("")){
            espacio = true;
        }
        if(MantenimientoEmpleados.cbcargo.getSelectedIndex() == -1){
            espacio = true;
        }
        if(MantenimientoEmpleados.txtiduser.getText().replaceAll("\\s", "").equals("")){
            espacio = true;
        }
        return espacio;
    }
    
    public boolean ValidacionEspaciosModificar(){
         boolean espacio = false;
        if(MantenimientoEmpleados.txtnombre.getText().replaceAll("\\s", "").equals("")){
            espacio = true;
        }
        if(MantenimientoEmpleados.txtapellido.getText().replaceAll("\\s", "").equals("")){
            espacio = true;
        }
        if(MantenimientoEmpleados.txtcedula.getText().replaceAll("\\s", "").equals("")){
            espacio = true;
        }
        if(MantenimientoEmpleados.txtcodigo.getText().replaceAll("\\s", "").equals("")){
            espacio = true;
        }
        if(MantenimientoEmpleados.txtdireccion.getText().replaceAll("\\s", "").equals("")){
            espacio = true;
        }
        if(MantenimientoEmpleados.txtfechanacimiento.getDate() == null){
            espacio = true;
        }
        if(MantenimientoEmpleados.txttelefono.getText().replaceAll("\\s", "").equals("")){
            espacio = true;
        }
        if(MantenimientoEmpleados.cbcargo.getSelectedIndex() == -1){
            espacio = true;
        }
        if(MantenimientoEmpleados.txtiduser.getText().replaceAll("\\s", "").equals("")){
            espacio = true;
        }
        if(MantenimientoEmpleados.txtidempleado.getText().replaceAll("\\s", "").equals("")){
            espacio = true;
        }
        return espacio;
    }
    
    public boolean ValidacionEspaciosEliminar(){
        boolean espacio = false;
        if(MantenimientoEmpleados.txtidempleado.getText().replaceAll("\\s", "").equals("")){
            espacio = true;
        }
        return espacio;
    }
}