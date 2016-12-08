/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.formularios;

import Formularios.Mantenimiento.MantenimientoInventarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import libraries.conexion.Conexion;
import libraries.identidades.Inventario;
import libraries.identidades.Proveedor;

/**
 *
 * @author Ellet
 */
public class dbInventario {
    
    
    
    public void IngresarRegistros(Inventario inventario){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("INSERT INTO inventario(codigo_producto,nombre_producto,descripcion,tipo,precio_unitario,id_proveedor,cantidad) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1,inventario.getCodigo_producto().toUpperCase());
            pst.setString(2,inventario.getNombre_producto().toUpperCase());
            pst.setString(3,inventario.getDescripcion().toUpperCase());
            pst.setString(4,inventario.getTipo().toUpperCase());
            pst.setDouble(5,inventario.getPrecio_unitario());
            pst.setInt(6,inventario.getProveedor().getId_proveedores());
            pst.setInt(7,inventario.getCantidad());
            pst.executeUpdate();
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public int CargarIdProveedores(){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT id_proveedores FROM proveedores WHERE nombre_proveedores = '" + MantenimientoInventarios.cbproveedores.getSelectedItem().toString().toUpperCase() + "'");
            ResultSet rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
    
    public Inventario ConsultarRegistros(String parametro){
        Conexion con = new Conexion();
        Inventario inventario = null;
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT proveedores.*,inventario.* FROM inventario INNER JOIN proveedores ON inventario.id_proveedor = proveedores.id_proveedores WHERE codigo_producto= ? ");
            pst.setString(1, parametro.toUpperCase());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Proveedor proveedor = new Proveedor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                inventario = new Inventario(rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
                rs.getDouble(10),rs.getInt(11),proveedor);
            }
            else{
                JOptionPane.showMessageDialog(null,"NO SE ENCONTRO PRODUCTO CON EL CODIGO ESPECICADO", "VALUE NOT FOUND",JOptionPane.ERROR_MESSAGE);
            }
            return inventario;
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    
    
    public void ModificarRegistros(Inventario inventario){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("UPDATE inventario SET codigo_producto=?,nombre_producto=?,descripcion=?,tipo=?,precio_unitario=?,id_proveedor=?,cantidad=? WHERE id_inventario = ? ");
            pst.setInt(8,inventario.getId_inventario());
            pst.setString(1,inventario.getCodigo_producto().toUpperCase());
            pst.setString(2,inventario.getNombre_producto().toUpperCase());
            pst.setString(3,inventario.getDescripcion().toUpperCase());
            pst.setString(4,inventario.getTipo().toUpperCase());
            pst.setDouble(5,inventario.getPrecio_unitario());
            pst.setInt(6,inventario.getProveedor().getId_proveedores());
            pst.setInt(7,inventario.getCantidad());
            pst.executeUpdate();
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    public void EliminarRegistros(int val){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("DELETE FROM inventario WHERE id_inventario = ? ");
            pst.setInt(1, val);
            pst.executeUpdate();
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
        
    
}
