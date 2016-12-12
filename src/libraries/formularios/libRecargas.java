/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.formularios;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import libraries.conexion.Conexion;
import libraries.identidades.VentaRecarga;

/**
 *
 * @author Ellet
 */
public class libRecargas {
    
    
    
    
    
    
    
    public void RealizarRecarga(VentaRecarga recarga){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("INSERT INTO ventas_recargas(fecha,cliente,numero,monto,id_empleado,id_promociones,total) VALUES(?,?,?,?,?,?,?)");
            pst.setDate(1, recarga.getFecha());
            pst.setString(2, recarga.getCliente());
            pst.setString(3, recarga.getNumero());
            pst.setDouble(4, recarga.getMonto());
            pst.setInt(5, recarga.getEmpleado().getId_empleado());
            pst.setInt(6, recarga.getPromocion().getId_promociones());
            pst.setDouble(7, recarga.getTotal());
            pst.executeUpdate();
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
    public double AumentoPromocion(double monto, String parametro){
        if(parametro.equals("WHATSAPP ILIMITADO") || parametro.equals("FACEBOOK ILIMITADO")){
            monto = monto + 1.00d;
        }
        else{
            if(parametro.equals("REDES SOCIALES ILIMITADAS")){
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
    
    public java.sql.Date ObtenerFecha(){
        Calendar cal = Calendar.getInstance();
        java.sql.Date fecha = new java.sql.Date(cal.getTime().getTime());
        return fecha;
    }
    
    public double Monto(String parametro){
        double monto = 0;
        if(parametro.equals("$ 1")){
            monto = 1d;
        }
        else{
            if(parametro.equals("$ 3")){
                monto = 3d;
            }
            else{
                if(parametro.equals("$ 6")){
                     monto = 6d;
                }
            }
        }
        return monto;
    }
    
    
   
}
