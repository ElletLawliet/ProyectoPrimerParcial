/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.formularios;


import Formularios.Principal.Principal;
import Formularios.Ventas.AñadirProducto;
import Formularios.Ventas.VentaProducto;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Calendar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import libraries.conexion.Conexion;

/**
 *
 * @author Ellet
 */
public class libVentaProductos {
    
    public void InicializarPopUp(){
        JMenuItem ieliminar = new JMenuItem("ELIMINAR");
        ieliminar.addMouseListener(new libVentaProductos().pml);
        VentaProducto.PopEliminar.add(ieliminar);
        VentaProducto.tbventas.setComponentPopupMenu(VentaProducto.PopEliminar);
        VentaProducto.tbventas.addMouseListener(new libVentaProductos().ml);
    }
    
    public void SeleccionarFila(MouseEvent evt){
        Point punto = evt.getPoint();
        int columnaactual = VentaProducto.tbventas.rowAtPoint(punto);
        VentaProducto.tbventas.setRowSelectionInterval(columnaactual, columnaactual);
        
    }
    
    public void EliminarFila(){
        DefaultTableModel modelo = (DefaultTableModel) VentaProducto.tbventas.getModel();
        modelo.removeRow(VentaProducto.tbventas.getSelectedRow());
        VentaProducto.tbventas.setModel(modelo);
        
    }
    
    public MouseListener ml = new MouseListener(){
        @Override
        public void mousePressed(MouseEvent evt){
            if(SwingUtilities.isRightMouseButton(evt)){
                SeleccionarFila(evt);
                
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
    };
    
    public MouseListener pml = new MouseListener(){
        @Override
        public void mousePressed(MouseEvent evt){
            if(SwingUtilities.isLeftMouseButton(evt)){
                    ModificarCantidadMas();
                    EliminarFila();
                    new libAñadirProducto().CalcularSubtotal();
                }
            
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
    };
    
    public void GuardarDatosFactura(){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("INSERT INTO ventas_general(nombre_cliente,id_empleado,fecha,cedula_cliente,total) VALUES(?,?,?,?,?)");
            pst.setString(1,VentaProducto.txtnombrecliente.getText().toUpperCase());
            pst.setDate(3, ObtenerFecha());
            pst.setInt(2, CargarIdEmpleado());
            pst.setString(4, VentaProducto.txtcedulacliente.getText());
            pst.setDouble(5, Double.parseDouble(VentaProducto.txttotal.getText()));
            pst.executeUpdate();
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null, exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public int CargarIdEmpleado(){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT id_empleado FROM empleados WHERE nombres_empleado='" + VentaProducto.lbnombreempleado.getText()+ "'");
            ResultSet rs = pst.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null, exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
    
    public java.sql.Date ObtenerFecha(){
        Calendar cal = Calendar.getInstance();
        java.sql.Date fecha = new java.sql.Date(cal.getTime().getTime());
        return fecha;
    }
    
    public void GuardarVentasProducto(){
        int c = 0;
        
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("INSERT INTO ventas_producto(cantidad,fecha,codigo_producto,nombre_producto,precio_unitario,total,id_ventas_general) VALUES(?,?,?,?,?,?,?)");
            while(c < VentaProducto.tbventas.getRowCount()){
                pst.setInt(1, Integer.parseInt(VentaProducto.tbventas.getValueAt(c, 4).toString()));
                pst.setDate(2, ObtenerFecha());
                pst.setString(3, VentaProducto.tbventas.getValueAt(c, 0).toString().toUpperCase());
                pst.setString(4, VentaProducto.tbventas.getValueAt(c, 1).toString().toUpperCase());
                pst.setDouble(5, Double.parseDouble(VentaProducto.tbventas.getValueAt(c, 3).toString()));
                pst.setDouble(6, Double.parseDouble(VentaProducto.tbventas.getValueAt(c, 5).toString()));
                pst.setInt(7, CargarIdVentas());
                pst.executeUpdate();
                c++;
            }
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null, exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public int CargarIdVentas(){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT id_venta_general FROM ventas_general",1004,1007);
            ResultSet rs = pst.executeQuery();
            rs.last();
            return rs.getInt(1);
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null, exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
    public void ModificarCantidadEspecifica(){
        int cantidad = Integer.parseInt(AñadirProducto.contadorproductos.getValue().toString());
        String parametro = AñadirProducto.cbnombre.getSelectedItem().toString().toUpperCase();
        int c = 0;
        while(c < VentaProducto.simulacion.getRowCount()){
            if(parametro.equals(VentaProducto.simulacion.getValueAt(c,1))){
                int cantidadactual = Integer.parseInt(VentaProducto.simulacion.getValueAt(c,4).toString());
                VentaProducto.simulacion.setValueAt(cantidadactual-cantidad,c,4);
            }
            c++;
        }
    }
    public void ModificarCantidadMenos(){
        int c = 0;
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            while(c < VentaProducto.tbventas.getRowCount()){
                String cantidad = VentaProducto.tbventas.getValueAt(c, 4).toString();
                String parametro = VentaProducto.tbventas.getValueAt(c, 0).toString();
                PreparedStatement pst = conex.prepareStatement("UPDATE inventario SET cantidad = cantidad - "+ cantidad + " WHERE codigo_producto = '" + parametro + "'");
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
    
    public void ModificarCantidadMas(){
        int cantidad = Integer.parseInt(VentaProducto.tbventas.getValueAt(VentaProducto.tbventas.getSelectedRow(),4).toString());
        String parametro = VentaProducto.tbventas.getValueAt(VentaProducto.tbventas.getSelectedRow(),1).toString().toUpperCase();
        int c = 0;
        while(c < VentaProducto.simulacion.getRowCount()){
            if(parametro.equals(VentaProducto.simulacion.getValueAt(c,1))){
                int cantidadactual = Integer.parseInt(VentaProducto.simulacion.getValueAt(c,4).toString());
                VentaProducto.simulacion.setValueAt(cantidadactual+cantidad,c,4);
            }
            c++;
        }
    }
    
    public void CargarDatosEmpleado(){
        VentaProducto.lbnombreempleado.setText(Principal.lbnombres.getText());
        VentaProducto.lbapellidoempleado.setText(Principal.lbapellidos.getText());
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT cedula FROM empleados WHERE nombres_empleado = '" + VentaProducto.lbnombreempleado.getText().toUpperCase()+"'");
            ResultSet rs = pst.executeQuery();
            rs.next();
            VentaProducto.lbcedulaempleado.setText(rs.getString(1));
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null, exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean ValidarEspaciosFacturar(){
        boolean espacios = false;
        if(VentaProducto.txtnombrecliente.getText().replaceAll("\\s", "").equals("")){
            espacios = true;
        }
        if(VentaProducto.txtcedulacliente.getText().replaceAll("\\s","").equals("")){
            espacios = true;
        }
        if(VentaProducto.txtiva.getText().replaceAll("\\s","").equals("")){
            espacios = true;
        }
        if(VentaProducto.txtsubtotal.getText().replaceAll("\\s","").equals("")){
            espacios = true;
        }
        if(VentaProducto.txttotal.getText().replaceAll("\\s","").equals("")){
            espacios = true;
        }
        if(VentaProducto.tbventas.getRowCount() == 0){
            espacios = true;
        }
        if(VentaProducto.txtcedulacliente.getText().length() <= 9){
            espacios = true;
        }
        return espacios;
    }
    
    
    
    
}
