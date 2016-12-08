/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.formularios;

import Formularios.Ventas.AñadirProducto;
import Formularios.Ventas.VentaProducto;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import libraries.conexion.Conexion;

/**
 *
 * @author Ellet
 */
public class libAñadirProducto {
    
    
    public void CargarProductos(){
        int c = 0;
        while(c < VentaProducto.simulacion.getRowCount()){
            if(Integer.parseInt(VentaProducto.simulacion.getValueAt(c, 4).toString()) > 0){
                AñadirProducto.cbnombre.addItem(VentaProducto.simulacion.getValueAt(c,1).toString());
            }
            c++;
        }
        AñadirProducto.cbnombre.setSelectedIndex(-1);
    }
    
    public void SetMaxValue(){
        SpinnerNumberModel spmodel = (SpinnerNumberModel) AñadirProducto.contadorproductos.getModel();
        int c = 0;
        while(c <VentaProducto.simulacion.getRowCount()){
            if(VentaProducto.simulacion.getValueAt(c, 1).toString().equals(AñadirProducto.cbnombre.getSelectedItem().toString())){
                spmodel.setMaximum(Integer.parseInt(VentaProducto.simulacion.getValueAt(c, 4).toString()));
            }
            c++;
        }
        AñadirProducto.contadorproductos.setModel(spmodel);
    }
    
    public void AñadirProductoTabla(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CODIGO");
        modelo.addColumn("PRODUCTO");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("PRECIO UNITARIO");
        modelo.addColumn("CANTIDAD");
        Object tabla [] = new Object[modelo.getColumnCount()];
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT * FROM inventario");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                tabla[0] = rs.getString(2);
                tabla[1] = rs.getString(3);
                tabla[2] = rs.getString(4);
                tabla[3] = rs.getString(6);
                tabla[4] = rs.getInt(7);
                modelo.addRow(tabla);
            }
            VentaProducto.simulacion.setModel(modelo);
        }
        catch(SQLException exc){
             JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    public void CalcularSubtotal(){
        DefaultTableModel modelo = (DefaultTableModel) VentaProducto.tbventas.getModel();
        int c = 0;
        double subtotal = 0, iva, total;
        while(c < modelo.getRowCount()){
            subtotal += Double.parseDouble(modelo.getValueAt(c, 5).toString());
            c++;
        }
        iva = subtotal * 0.14d;
        total = subtotal + iva;
        VentaProducto.txtsubtotal.setText(ConvertirFormatear(subtotal).toString());
        VentaProducto.txtiva.setText(ConvertirFormatear(iva).toString());
        VentaProducto.txttotal.setText(ConvertirFormatear(total).toString());
    }
    
    public BigDecimal ConvertirFormatear(double decimal){
        BigDecimal bg = new BigDecimal(decimal);
        bg = bg.setScale(2,BigDecimal.ROUND_HALF_UP);
        return bg;
    }
    
    public void CargarTablaVentas(){
        DefaultTableModel modelo = (DefaultTableModel) VentaProducto.tbventas.getModel();
        int c = 0, d = 0;
        Object tabla[] = new Object[VentaProducto.tbventas.getColumnCount()];
        while(c < VentaProducto.simulacion.getRowCount()){
            if(VentaProducto.simulacion.getValueAt(c, 1).toString().equals(AñadirProducto.cbnombre.getSelectedItem().toString())){
                tabla[0] = VentaProducto.simulacion.getValueAt(c,0);
                tabla[1] = VentaProducto.simulacion.getValueAt(c,1);
                tabla[2] = VentaProducto.simulacion.getValueAt(c,2);
                tabla[3] =  VentaProducto.simulacion.getValueAt(c,3);
                tabla[4] = AñadirProducto.contadorproductos.getValue();
                tabla[5] = ConvertirFormatear(Double.parseDouble(tabla[3].toString())* Double.parseDouble(tabla[4].toString()));
                modelo.addRow(tabla);
            }
            c++;
        }
        VentaProducto.tbventas.setModel(modelo);
        
    }
    
    public boolean VerificarEspaciosAñadir(){
        boolean espacio = false;
        SpinnerNumberModel spm = (SpinnerNumberModel) AñadirProducto.contadorproductos.getModel();
        if(AñadirProducto.cbnombre.getSelectedIndex() == -1){
            espacio = true;
        }
        if(Integer.parseInt(spm.getValue().toString()) > Integer.parseInt(spm.getMaximum().toString())){
            espacio = true; 
        }
        return espacio;
    }
}

