/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.formularios;


import Formularios.Ventas.VentaProductos;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import libraries.conexion.Conexion;
import libraries.identidades.Inventario;
import libraries.identidades.VentaGeneral;
import libraries.identidades.VentaProducto;

/**
 *
 * @author Ellet
 */
public class libVentaProductos {
       
    public void GuardarDatosFactura(VentaGeneral venta){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("INSERT INTO ventas_general(nombre_cliente,id_empleado,fecha,cedula_cliente,total) VALUES(?,?,?,?,?)");
            pst.setString(1,venta.getNombre_cliente().toUpperCase());
            pst.setDate(3, ConvertirFechaSql(venta.getFecha()));
            pst.setInt(2, venta.getEmpleado().getId_empleado());
            pst.setString(4, venta.getCedulaCliente());
            pst.setDouble(5, venta.getTotal());
            pst.executeUpdate();
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null, exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public java.util.Date ObtenerFecha(){
        Calendar cal = Calendar.getInstance();
        java.util.Date fecha = new java.util.Date(cal.getTime().getTime());
        return fecha;
    }
    
    public void GuardarVentasProducto(VentaProducto venta){
        
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("INSERT INTO ventas_producto(cantidad,fecha,codigo_producto,nombre_producto,precio_unitario,total,id_ventas_general) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, venta.getCantidad());
            pst.setDate(2, ConvertirFechaSql(venta.getFecha()));
            pst.setString(3, venta.getCodigo_producto().toUpperCase());
            pst.setString(4, venta.getNombre_producto().toUpperCase());
            pst.setDouble(5, venta.getPrecio_unitario());
            pst.setDouble(6, venta.getTotal());
            pst.setInt(7, venta.getVentageneral().getId_venta_general());
            pst.executeUpdate();
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null, exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
        
    public double CalcularSubtotal(ArrayList subtotales){
        double suma = 0;
        int c = 0;
        while(c < subtotales.size()){
            suma += Double.parseDouble(subtotales.get(c).toString());
            c++;
        }
        return suma;        
    }
    
    public double calcularIva(double subtotal){
        return subtotal * 0.14d;
    }
    
    public double total(double subtotal, double iva){
        return subtotal + iva;
    }
    
    public String ConvertirFormatear(double decimal){
        BigDecimal bg = new BigDecimal(decimal);
        bg = bg.setScale(2,BigDecimal.ROUND_HALF_UP);
        return bg.toString();
    }
    
    public java.sql.Date ConvertirFechaSql(java.util.Date fecha ){
        java.sql.Date date = new Date(fecha.getTime());
        return date;
    }
    
    public String calcularSubtotalProducto(double precio, int cantidad){
        return ConvertirFormatear(precio*cantidad);
    }
      
    public List<Inventario> ModificarCantidadEspecifica(int cantidad,Inventario producto,List<Inventario> productos){
        int c = 0;
        for(Inventario inventario : productos){
            if(producto.getNombre_producto().equals(inventario.getNombre_producto())){
                inventario.setCantidad(inventario.getCantidad()-cantidad);
                productos.set(c, inventario);
            }
            c++;
        }
        return productos;
    }
    public void ModificarCantidadMenos(ArrayList codigo, ArrayList cantidad){
        int c = 0;
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            while(c < codigo.size()){
                PreparedStatement pst = conex.prepareStatement("UPDATE inventario SET cantidad = cantidad - ? WHERE codigo_producto = ?");
                pst.setInt(1,(Integer)cantidad.get(c));
                pst.setString(2, codigo.get(c).toString());
                pst.executeUpdate();
                c++;
            }
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null, exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void EjecutarActualizacionInventario(){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("DELETE FROM inventario WHERE cantidad < 1");
            pst.executeUpdate();
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null, exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public List<Inventario> ModificarCantidadMas(int cantidad, String nombre, List<Inventario> productos){
        int c = 0;
        for(Inventario inventario : productos){
            if(nombre.equals(inventario.getNombre_producto())){
                inventario.setCantidad(inventario.getCantidad()+cantidad);
                productos.set(c, inventario);
            }
            c++;
        }
        return productos;
    }
    
    public int CargarIdFactura(){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("SELECT id_venta_general FROM ventas_general",1004,1007);
            ResultSet rs = pst.executeQuery();
            rs.last();
            return rs.getInt(1);
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null, exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
    
    
   
    
    
    
    
    
    
}
