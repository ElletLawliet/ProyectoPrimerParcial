/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.formularios;

import Formularios.Ventas.ConsultaRecargas;

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
import libraries.colas.ColasConsultaRecargas;

import libraries.conexion.Conexion;

/**
 *
 * @author Ellet
 */
public class libConsultaRecargas {
    
    public void SQL(){
        String sql= "";
        if(ConsultaRecargas.txtbusqueda.getText().equals("")){
            sql ="SELECT ventas_recargas.*,empleados.nombres_empleado,empleados.apellidos_empleado,promociones.nombre_promocion FROM ventas_recargas "
                    + "INNER JOIN empleados ON (ventas_recargas.id_empleado = empleados.id_empleado) "
                    + "INNER JOIN promociones ON (ventas_recargas.id_promociones = promociones.id_promociones)";
        }
        else{
            if(ConsultaRecargas.cbcategoria.getSelectedIndex() == 0){
                sql ="SELECT ventas_recargas.*,empleados.nombres_empleado,empleados.apellidos_empleado,promociones.nombre_promocion FROM ventas_recargas "
                        + "INNER JOIN empleados ON (ventas_recargas.id_empleado = empleados.id_empleado) "
                        + "INNER JOIN promociones ON (ventas_recargas.id_promociones = promociones.id_promociones) "
                        + "WHERE ventas_recargas.fecha = '"+ ConsultaRecargas.txtbusqueda.getText() +"'";
            }
            else{
                if(ConsultaRecargas.cbcategoria.getSelectedIndex() == 1){
                    sql ="SELECT ventas_recargas.*,empleados.nombres_empleado,empleados.apellidos_empleado,promociones.nombre_promocion FROM ventas_recargas "
                            + "INNER JOIN empleados ON (ventas_recargas.id_empleado = empleados.id_empleado) "
                            + "INNER JOIN promociones ON (ventas_recargas.id_promociones = promociones.id_promociones) "
                            + "WHERE ventas_recargas.numero = '"+ ConsultaRecargas.txtbusqueda.getText() +"'";
                }
                else{
                    if(ConsultaRecargas.cbcategoria.getSelectedIndex() == 2){
                        sql ="SELECT ventas_recargas.*,empleados.nombres_empleado,empleados.apellidos_empleado,promociones.nombre_promocion FROM ventas_recargas "
                                + "INNER JOIN empleados ON (ventas_recargas.id_empleado = empleados.id_empleado) "
                                + "INNER JOIN promociones ON (ventas_recargas.id_promociones = promociones.id_promociones) "
                                + "WHERE empleados.nombres_empleado LIKE '%"+ConsultaRecargas.txtbusqueda.getText().toUpperCase() +"%'"; 
                    }
                }
            }
            
        }
        Busqueda(sql);
        
    }
    
    public void Busqueda(String sql){
        DefaultTableModel model = (DefaultTableModel) ConsultaRecargas.tbconsultarecargas.getModel();
        model.setRowCount(0);
        ColasConsultaRecargas colas = new ColasConsultaRecargas();
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall(sql,1004,1007);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
               rs.beforeFirst();
               while(rs.next()){
                   colas.InsertarCola(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getDouble(5),rs.getString(9)+" "+rs.getString(10),
                           rs.getString(11),rs.getDouble(8));
               }
               ConsultaRecargas.tbconsultarecargas.setModel(colas.LlenarArray());
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
        MessageFormat hf = new MessageFormat("Recargas");
        MessageFormat ff = new MessageFormat(ConsultaRecargas.lbtotalesconsulta.getText()+ "  " + ConsultaRecargas.lbtotales.getText());
        try{
            ConsultaRecargas.tbconsultarecargas.print(JTable.PrintMode.FIT_WIDTH,hf,ff);
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
        while(c < ConsultaRecargas.tbconsultarecargas.getRowCount()){
            totales += ConvertirFormatear(Double.parseDouble(ConsultaRecargas.tbconsultarecargas.getValueAt(c, 6).toString())).doubleValue();
            c++;
        }
        if(ConsultaRecargas.tbconsultarecargas.getRowCount() > 0){
            ConsultaRecargas.lbtotales.setText("$ " + Double.toString(totales));
        }
    }
    
    public void Limpiar(){
        DefaultTableModel modelo = (DefaultTableModel) ConsultaRecargas.tbconsultarecargas.getModel();
        modelo.setRowCount(0);
        ConsultaRecargas.tbconsultarecargas.setModel(modelo);
        ConsultaRecargas.txtbusqueda.setText("");
        ConsultaRecargas.lbtotales.setText(" ");
    }
}
