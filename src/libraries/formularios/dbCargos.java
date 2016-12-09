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
import libraries.identidades.Cargo;

/**
 *
 * @author Ellet
 */
public class dbCargos {
    
    public void IngresoRegistros(Cargo cargo){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("INSERT INTO cargos(nombre_cargo) VALUES(?)");
            pst.setString(1,cargo.getNombre_cargos().toUpperCase());
            pst.executeUpdate();
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Cargo ConsultarRegistros(String parametro){
        Conexion con = new Conexion();
        Cargo cargo = null;
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT * FROM cargos WHERE nombre_cargo = ?");
            pst.setString(1, parametro.toUpperCase());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                cargo = new Cargo(rs.getInt(1),rs.getString(2));
            }
            else{
                JOptionPane.showMessageDialog(null,"NO SE ENCONTRO CARGO CON ESE NOMBRE","VALUE NOT FOUND",JOptionPane.ERROR_MESSAGE);
            }
            return cargo;
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    
    
    public void ModificarRegistros(Cargo cargo){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("UPDATE cargos SET nombre_cargo = ? WHERE id_cargo = ? ");
            pst.setInt(2, cargo.getId_cargos());
            pst.setString(1,cargo.getNombre_cargos().toUpperCase());
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
            PreparedStatement pst = conex.prepareStatement("DELETE FROM cargos WHERE id_cargo = ? ");
            pst.setInt(1,val);
            pst.executeUpdate();
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public List<Cargo> CargarCargos(){
        Conexion con = new Conexion();
        List<Cargo> cargos = new ArrayList<Cargo>();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("SELECT * FROM cargos ORDER BY id_cargo ASC");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Cargo cargo = new Cargo(rs.getInt(1),rs.getString(2));
                cargos.add(cargo);
            }
            return cargos;
        }
        catch(SQLException exc){
             JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
             return null;
        }
    }
    
    
    
}
