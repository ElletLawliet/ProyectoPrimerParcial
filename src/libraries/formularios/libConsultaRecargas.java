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
import libraries.identidades.ConsultaRecarga;

/**
 *
 * @author Ellet
 */
public class libConsultaRecargas {
    
    public String SQL(String parametro,int indice){
        String sql= "";
        if(parametro.equals("")){
            sql ="SELECT ventas_recargas.*,empleados.nombres_empleado,empleados.apellidos_empleado,promociones.nombre_promocion FROM ventas_recargas "
                    + "INNER JOIN empleados ON (ventas_recargas.id_empleado = empleados.id_empleado) "
                    + "INNER JOIN promociones ON (ventas_recargas.id_promociones = promociones.id_promociones)";
        }
        else{
            if(indice == 0){
                sql ="SELECT ventas_recargas.*,empleados.nombres_empleado,empleados.apellidos_empleado,promociones.nombre_promocion FROM ventas_recargas "
                        + "INNER JOIN empleados ON (ventas_recargas.id_empleado = empleados.id_empleado) "
                        + "INNER JOIN promociones ON (ventas_recargas.id_promociones = promociones.id_promociones) "
                        + "WHERE ventas_recargas.fecha = '"+ parametro +"'";
            }
            else{
                if(indice == 1){
                    sql ="SELECT ventas_recargas.*,empleados.nombres_empleado,empleados.apellidos_empleado,promociones.nombre_promocion FROM ventas_recargas "
                            + "INNER JOIN empleados ON (ventas_recargas.id_empleado = empleados.id_empleado) "
                            + "INNER JOIN promociones ON (ventas_recargas.id_promociones = promociones.id_promociones) "
                            + "WHERE ventas_recargas.numero = '"+ parametro +"'";
                }
                else{
                    if(indice == 2){
                        sql ="SELECT ventas_recargas.*,empleados.nombres_empleado,empleados.apellidos_empleado,promociones.nombre_promocion FROM ventas_recargas "
                                + "INNER JOIN empleados ON (ventas_recargas.id_empleado = empleados.id_empleado) "
                                + "INNER JOIN promociones ON (ventas_recargas.id_promociones = promociones.id_promociones) "
                                + "WHERE empleados.nombres_empleado LIKE '%"+ parametro.toUpperCase() +"%'"; 
                    }
                }
            }
            
        }
        return sql;
    }
    
    public List<ConsultaRecarga> Busqueda(String parametro,int indice){
        String sql = SQL(parametro,indice);
        List<ConsultaRecarga> recargas = new ArrayList<ConsultaRecarga>();
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall(sql,1004,1007);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                ConsultaRecarga recarga = new ConsultaRecarga(rs.getInt(1),ConvertirFechaUtil(rs.getDate(2)),
                                                              rs.getString(4),rs.getDouble(5),
                                                              rs.getString(9) + " " + rs.getString(10),
                                                              rs.getString(11), rs.getDouble(8));
                recargas.add(recarga);
            }
            return recargas;
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
