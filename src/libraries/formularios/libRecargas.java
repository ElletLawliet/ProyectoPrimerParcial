/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.formularios;

import Formularios.Principal.Principal;
import Formularios.Ventas.Recargas;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import libraries.conexion.Conexion;

/**
 *
 * @author Ellet
 */
public class libRecargas {
    
    public void CargarPromociones(){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT nombre_promocion FROM promociones");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Recargas.cbpromociones.addItem(rs.getString(1));
            }
            Recargas.cbpromociones.setSelectedIndex(-1);
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public int CargarIdPromociones(){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT id_promociones FROM promociones WHERE nombre_promocion ='"+Recargas.cbpromociones.getSelectedItem().toString()+"'");
            ResultSet rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
    
    public int CargarIdEmpleado(){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT id_empleado FROM empleados WHERE nombres_empleado ='"+Principal.lbnombres.getText()+"'");
            ResultSet rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
    
    public void RealizarRecarga(){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("INSERT INTO ventas_recargas(fecha,cliente,numero,monto,id_empleado,id_promociones,total) VALUES(?,?,?,?,?,?,?)");
            pst.setDate(1, ConvertirFecha());
            pst.setString(2, "CONSUMIDOR FINAL");
            pst.setString(3, Recargas.txtnumero.getText());
            pst.setDouble(4, Monto());
            pst.setInt(5, CargarIdEmpleado());
            pst.setInt(6, CargarIdPromociones());
            pst.setDouble(7, ConvertirFormatear(AumentoPromocion(Monto())).doubleValue());
            pst.executeUpdate();
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public double AumentoPromocion(double monto){
        if(Recargas.cbpromociones.getSelectedItem().toString().equals("WHATSAPP ILIMITADO") || Recargas.cbpromociones.getSelectedItem().toString().equals("FACEBOOK ILIMITADO")){
            monto = monto + 1.00d;
        }
        else{
            if(Recargas.cbpromociones.getSelectedItem().toString().equals("REDES SOCIALES ILIMITADAS")){
                monto = monto + 1.50d; 
            }
        }
        return monto;
    }
    
    public BigDecimal ConvertirFormatear(double decimal){
        BigDecimal bg = new BigDecimal(decimal);
        bg = bg.setScale(2,BigDecimal.ROUND_HALF_UP);
        return bg;
    }
    
    public java.sql.Date ConvertirFecha(){
        Calendar cal = Calendar.getInstance();
        java.sql.Date fecha = new java.sql.Date(cal.getTime().getTime());
        return fecha;
    }
    
    public double Monto(){
        double monto = 0;
        if(Recargas.rb1.isSelected()){
            monto = 1d;
        }
        else{
            if(Recargas.rb3.isSelected()){
                monto = 3d;
            }
            else{
                if(Recargas.rb6.isSelected()){
                     monto = 6d;
                }
            }
        }
        return monto;
    }
    
    
    public void Limpiar(){
        Recargas.cbpromociones.setSelectedIndex(-1);
        Recargas.GrupoBotonRecarga.clearSelection();
        Recargas.txtnumero.setText("");
    }
    
    public boolean ValidarEspaciosRecargar(){
        boolean espacios = false;
        if(Recargas.txtnumero.getText().replaceAll("\\s", "").equals("")){
            espacios = true;
        }
        if(Recargas.cbpromociones.getSelectedIndex() == -1){
            espacios = true;
        }
        if(!(Recargas.rb1.isSelected() || Recargas.rb3.isSelected() || Recargas.rb6.isSelected())){
            espacios = true;
        }
        if(Recargas.txtnumero.getText().length() <= 9){
            espacios = true;
        }
        return espacios;
    }
}
