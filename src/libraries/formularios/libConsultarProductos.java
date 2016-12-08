/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.formularios;

import Formularios.Inventario.ConsultarProducto;

import java.awt.print.PrinterException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import libraries.colas.ColasConsultaProducto;
import libraries.conexion.Conexion;

/**
 *
 * @author Ellet
 */
public class libConsultarProductos {
    public void Sql(){
        String sql = "";
        if(ConsultarProducto.cbcategoria.getSelectedIndex() == 0){
            sql = "SELECT inventario.*,proveedores.nombre_proveedores FROM inventario "
                    + "INNER JOIN proveedores ON inventario.id_proveedor = proveedores.id_proveedores "
                    + "WHERE nombre_producto LIKE '" + ConsultarProducto.txtbusqueda.getText().toUpperCase()+ "%'";
        }
        else{
            if(ConsultarProducto.cbcategoria.getSelectedIndex() == 1){
                sql = "SELECT inventario.*,proveedores.nombre_proveedores FROM inventario "
                        + "INNER JOIN proveedores ON inventario.id_proveedor = proveedores.id_proveedores "
                        + "WHERE proveedores.nombre_proveedores LIKE '" + ConsultarProducto.txtbusqueda.getText().toUpperCase()+ "%'";
            }
            else{
                if(ConsultarProducto.cbcategoria.getSelectedIndex() == 3){
                    sql = "SELECT inventario.*,proveedores.nombre_proveedores FROM inventario "
                            + "INNER JOIN proveedores ON inventario.id_proveedor = proveedores.id_proveedores "
                            + "WHERE tipo = '" + ConsultarProducto.txtbusqueda.getText().toUpperCase()+ "%'";
                }
                else{
                    if(ConsultarProducto.txtbusqueda.getText().isEmpty()){
                        sql = "SELECT inventario.*,proveedores.nombre_proveedores FROM inventario "
                                + "INNER JOIN proveedores ON inventario.id_proveedor = proveedores.id_proveedores";
                    }
                }
            }
        }
        Busqueda(sql);
        
    }
    
    public void Busqueda(String sql){
        ColasConsultaProducto cola = new ColasConsultaProducto();
        DefaultTableModel model = (DefaultTableModel) ConsultarProducto.tablaconsultaproductos.getModel();
        model.setRowCount(0);
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall(sql,1004,1007);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                rs.beforeFirst();
                while(rs.next()){
                    cola.InsertarNodo(rs.getString(2),rs.getString(3) ,rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getInt(7), rs.getString(9));
                }
                ConsultarProducto.tablaconsultaproductos.setModel(cola.LlenarArray());
            }
            else{
                JOptionPane.showMessageDialog(null,"NO SE ENCONTRO REGISTROS","NOT FOUND",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void Imprimir(){
        MessageFormat hf = new MessageFormat("Productos");
        MessageFormat ff = new MessageFormat("");
        try{
            ConsultarProducto.tablaconsultaproductos.print(JTable.PrintMode.FIT_WIDTH,hf,ff);
        }
        catch(PrinterException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING!",JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    
    
    
    
    
    public void Limpiar(){
        DefaultTableModel modelo = (DefaultTableModel) ConsultarProducto.tablaconsultaproductos.getModel();
        modelo.setRowCount(0);
        ConsultarProducto.tablaconsultaproductos.setModel(modelo);
        ConsultarProducto.txtbusqueda.setText("");
        
    }
}
