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
import libraries.identidades.Promocion;

/**
 *
 * @author Ellet
 */
public class dbPromociones {
    
    public void IngresarRegistros(Promocion promocion){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("INSERT INTO promociones(codigo_promocion,nombre_promocion,descripcion,tipo) VALUES(?,?,?,?)");
            pst.setString(1,promocion.getCodigo_promocion().toUpperCase());
            pst.setString(2,promocion.getNombre_promocion().toUpperCase());
            pst.setString(3,promocion.getDescripcion().toUpperCase());
            pst.setString(4,promocion.getTipo().toUpperCase());
            pst.executeUpdate();
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Promocion ConsultarRegistros(String parametro){
        Conexion con = new Conexion();
        Promocion promocion = null;
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT * FROM promociones WHERE codigo_promocion =  ? ");
            pst.setString(1,parametro.toUpperCase());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                promocion = new Promocion(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            }
            else{
                JOptionPane.showMessageDialog(null,"NO SE PUDO ENCONTRAR PROMOCION CON ESE CODIGO","VALUE NOT FOUND",JOptionPane.ERROR_MESSAGE);
            }
            return promocion;
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public void ModificarRegistros(Promocion promocion){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("UPDATE promociones SET codigo_promocion=?,nombre_promocion=?,descripcion=?,tipo=? WHERE id_promociones =  ? ");
            pst.setInt(5, promocion.getId_promociones());
            pst.setString(1,promocion.getCodigo_promocion().toUpperCase());
            pst.setString(2,promocion.getNombre_promocion().toUpperCase());
            pst.setString(3,promocion.getDescripcion().toUpperCase());
            pst.setString(4,promocion.getTipo().toUpperCase());
            pst.executeUpdate();
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void EliminarRegistros(int val){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("DELETE FROM promociones WHERE id_promociones =  ?");
            pst.setInt(1, val);
            pst.executeUpdate();
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public List<Promocion> CargarPromociones(){
        Conexion con = new Conexion();
        List<Promocion> promociones = new ArrayList<Promocion>();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT * FROM promociones");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Promocion promocion = new Promocion(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                promociones.add(promocion);
            }
            return promociones;
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    
    
} 