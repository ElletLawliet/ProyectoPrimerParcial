/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.formularios;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import libraries.conexion.Conexion;
import libraries.identidades.Proveedor;

/**
 *
 * @author Ellet
 */
public class dbProveedores {
    
    
    
    public void IngresarRegistros(Proveedor proveedor){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("INSERT INTO proveedores(codigo_proveedores,nombre_proveedores,tipo_producto) VALUES(?,?,?)");
            pst.setString(1,proveedor.getCodigo_proveedores().toUpperCase());
            pst.setString(2,proveedor.getNombre_proveedores().toUpperCase());
            pst.setString(3,proveedor.getTipo_producto().toUpperCase());
            pst.executeUpdate();
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Proveedor ConsultarRegistro(String parametro){
        Conexion con = new Conexion();
        Proveedor proveedor = null;
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT * FROM proveedores WHERE codigo_proveedores = ?");
            pst.setString(1, parametro.toUpperCase());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                proveedor = new Proveedor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
            else{
                JOptionPane.showMessageDialog(null,"NO SE ENCONTRO PROVEEDOR CON EL CODIGO ESPECIFICADO","VALUE NOT FOUND",JOptionPane.ERROR_MESSAGE);
            }
            return proveedor;
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
        
    public void ModificarRegistros(Proveedor proveedor){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("UPDATE proveedores SET codigo_proveedores=?,nombre_proveedores=?,tipo_producto=? WHERE id_proveedores= ? ");
            pst.setInt(4, proveedor.getId_proveedores());
            pst.setString(1,proveedor.getCodigo_proveedores().toUpperCase());
            pst.setString(2,proveedor.getNombre_proveedores().toUpperCase());
            pst.setString(3,proveedor.getTipo_producto().toUpperCase());
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
            PreparedStatement pst = conex.prepareStatement("DELETE FROM proveedores WHERE id_proveedores = ? ");
            pst.setInt(1, val);
            pst.executeUpdate();    
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }       
    }
    
    public List<Proveedor> CargarProveedores(String parametro){
        Conexion con = new Conexion();
        List<Proveedor> proveedores = new ArrayList<Proveedor>();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT * FROM proveedores WHERE tipo_producto = ? ORDER BY  id_proveedores  ASC");
            pst.setString(1, parametro.toUpperCase());
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Proveedor proveedor = new Proveedor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                proveedores.add(proveedor);
            }
            return proveedores;
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE); 
            return null;
        }
    }
    
    /*public Proveedor getProveedorByNombre(String parametro){
        Conexion con = new Conexion();
        Proveedor proveedor = null;
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("SELECT * FROM proveedores WHERE nombre_proveedores = ?");
            pst.setString(1, parametro.toUpperCase());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                
            }
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE); 
            return null;
        }
    }*/

    
}


