/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.formularios;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import libraries.conexion.Conexion;
import libraries.identidades.ConsultaVentaProducto;

/**
 *
 * @author Ellet
 */
public class libConsultarVentaProducto {
    
    public String SQL(String parametro, int indice){
        String sql= "";
        if(parametro.equals("")){
            sql ="SELECT ventas_producto.*,ventas_general.nombre_cliente FROM ventas_producto "
                    + "INNER JOIN ventas_general ON (ventas_producto.id_ventas_general = ventas_general.id_venta_general)";
        }
        else{
            if(indice == 1){
                sql ="SELECT ventas_producto.*,ventas_general.nombre_cliente FROM ventas_producto "
                        + "INNER JOIN ventas_general ON (ventas_producto.id_ventas_general = ventas_general.id_venta_general) "
                        + "WHERE nombre_producto LIKE '%"+ parametro.toUpperCase() +"%'";
            }
            else{
                if(indice == 0){
                    sql = "SELECT ventas_producto.*,ventas_general.nombre_cliente FROM ventas_producto "
                            + "INNER JOIN ventas_general ON (ventas_producto.id_ventas_general = ventas_general.id_venta_general) "
                            + "WHERE ventas_producto.fecha = '"+ parametro.toUpperCase() +"'";
                }
            }
        }
        return sql;
    }
    
    public List<ConsultaVentaProducto> Busqueda(String parametro,int indice){
        String sql = SQL(parametro,indice);
        List <ConsultaVentaProducto> ventas = new ArrayList<ConsultaVentaProducto>();
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                ConsultaVentaProducto venta = new ConsultaVentaProducto(rs.getInt(8),ConvertirFechaUtil(rs.getDate(3)),rs.getString(9),
                                                                        rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getInt(2),
                                                                        rs.getDouble(7));
                ventas.add(venta);
               }
            return ventas;
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(), "NOT FOUND", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    
    
    public BigDecimal ConvertirFormatear(double decimal){
        BigDecimal bg = new BigDecimal(decimal);
        bg = bg.setScale(2,BigDecimal.ROUND_HALF_UP);
        return bg;
    }
    
    
    public String SumaTotalesConsulta(double [] totales){
        int c = 0;
        double total = 0;
        while(c < totales.length){
            total += totales[c];
            c++;
        }
        return ConvertirFormatear(total).toString();
    }
    
    
    
    public java.util.Date ConvertirFechaUtil(java.sql.Date fecha){
        java.util.Date date = new Date(fecha.getTime());
        return date;
    }
}

