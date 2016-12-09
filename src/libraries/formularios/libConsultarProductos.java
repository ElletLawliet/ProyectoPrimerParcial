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
import libraries.identidades.ConsultaProducto;

/**
 *
 * @author Ellet
 */
public class libConsultarProductos {
    public String Sql(String parametro, int indice){
        String sql = "";
        if(indice == 0){
            sql = "SELECT inventario.*,proveedores.nombre_proveedores FROM inventario "
                    + "INNER JOIN proveedores ON inventario.id_proveedor = proveedores.id_proveedores "
                    + "WHERE nombre_producto LIKE '" + parametro.toUpperCase()+ "%'";
        }
        else{
            if(indice == 1){
                sql = "SELECT inventario.*,proveedores.nombre_proveedores FROM inventario "
                        + "INNER JOIN proveedores ON inventario.id_proveedor = proveedores.id_proveedores "
                        + "WHERE proveedores.nombre_proveedores LIKE '" + parametro.toUpperCase()+ "%'";
            }
            else{
                if(indice == 3){
                    sql = "SELECT inventario.*,proveedores.nombre_proveedores FROM inventario "
                            + "INNER JOIN proveedores ON inventario.id_proveedor = proveedores.id_proveedores "
                            + "WHERE tipo = '" + parametro.toUpperCase()+ "%'";
                }
                else{
                    if(parametro.equals("")){
                        sql = "SELECT inventario.*,proveedores.nombre_proveedores FROM inventario "
                                + "INNER JOIN proveedores ON inventario.id_proveedor = proveedores.id_proveedores";
                    }
                }
            }
        }
        return sql;
    }
    
    public List<ConsultaProducto> Busqueda(String parametro, int indice){
        String sql = Sql(parametro,indice);
        List<ConsultaProducto> productos = new ArrayList<ConsultaProducto>();
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                ConsultaProducto producto = new ConsultaProducto(rs.getString(2),rs.getString(3),rs.getString(4),
                                                                 rs.getString(5),rs.getDouble(6),rs.getInt(7),
                                                                 rs.getString(9));
                productos.add(producto);
            }
            return productos;
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    
}
