/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.formularios;


import Formularios.Ventas.ConsultaVenta;
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

import libraries.colas.ColasConsultaVentas;
import libraries.conexion.Conexion;

/**
 *
 * @author Ellet
 */
public class libConsultarVentaProducto {
    
    public void SQL(){
        String sql= "";
        if(ConsultaVenta.txtbusqueda.getText().equals("")){
            sql ="SELECT ventas_producto.*,ventas_general.nombre_cliente FROM ventas_producto "
                    + "INNER JOIN ventas_general ON (ventas_producto.id_ventas_general = ventas_general.id_venta_general)";
        }
        else{
            if(ConsultaVenta.cbcategoria.getSelectedIndex() == 1){
                sql ="SELECT ventas_producto.*,ventas_general.nombre_cliente FROM ventas_producto "
                        + "INNER JOIN ventas_general ON (ventas_producto.id_ventas_general = ventas_general.id_venta_general) "
                        + "WHERE nombre_producto LIKE '%"+ ConsultaVenta.txtbusqueda.getText().toUpperCase() +"%'";
            }
            else{
                if(ConsultaVenta.cbcategoria.getSelectedIndex() == 0){
                    sql = "SELECT ventas_producto.*,ventas_general.nombre_cliente FROM ventas_producto "
                            + "INNER JOIN ventas_general ON (ventas_producto.id_ventas_general = ventas_general.id_venta_general) "
                            + "WHERE ventas_producto.fecha = '"+ ConsultaVenta.txtbusqueda.getText().toUpperCase() +"'";
                }
            }
        }
        Busqueda(sql);
    }
    
    public void Busqueda(String sql){
        DefaultTableModel model = (DefaultTableModel) ConsultaVenta.tablaconsultaventasproducto.getModel();
        model.setRowCount(0);
        ColasConsultaVentas colas = new ColasConsultaVentas();
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall(sql,1004,1007);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
               rs.beforeFirst();
               while(rs.next()){
                   colas.InsertarCola(rs.getInt(8),rs.getString(3),rs.getString(9), rs.getString(4), rs.getString(5), rs.getDouble(6),
                           rs.getInt(2), rs.getDouble(7));
               }
               ConsultaVenta.tablaconsultaventasproducto.setModel(colas.LlenarArray());
            }
            else{
                JOptionPane.showMessageDialog(null,"NO SE ENCONTRO REGISTROS CON EL PARAMETRO ESPECIFICADO", "NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(), "NOT FOUND", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void Imprimir(){
        MessageFormat hf = new MessageFormat("Ventas");
        MessageFormat ff = new MessageFormat(ConsultaVenta.lbtotalesconsulta.getText()+ "  " + ConsultaVenta.lbtotales.getText());
        try{
            ConsultaVenta.tablaconsultaventasproducto.print(JTable.PrintMode.FIT_WIDTH,hf,ff);
        }
        catch(PrinterException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING!",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public BigDecimal ConvertirFormatear(double decimal){
        BigDecimal bg = new BigDecimal(decimal);
        bg = bg.setScale(2,BigDecimal.ROUND_HALF_UP);
        return bg;
    }
    
    
    public void SumaTotalesConsulta(){
        int c = 0;
        double totales = 0;
        while(c < ConsultaVenta.tablaconsultaventasproducto.getRowCount()){
            totales += ConvertirFormatear(Double.parseDouble(ConsultaVenta.tablaconsultaventasproducto.getValueAt(c, 7).toString())).doubleValue();
            c++;
        }
        if(ConsultaVenta.tablaconsultaventasproducto.getRowCount() > 0){
            ConsultaVenta.lbtotales.setText("$ " + Double.toString(totales));
        }
    }
    
    public void Limpiar(){
        DefaultTableModel modelo = (DefaultTableModel) ConsultaVenta.tablaconsultaventasproducto.getModel();
        modelo.setRowCount(0);
        ConsultaVenta.tablaconsultaventasproducto.setModel(modelo);
        ConsultaVenta.txtbusqueda.setText("");
        ConsultaVenta.lbtotales.setText(" ");
    }
}

