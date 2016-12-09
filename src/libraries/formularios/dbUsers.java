/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.formularios;
import Formularios.Mantenimiento.MantenimientoUsuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import libraries.conexion.Conexion;
import libraries.identidades.User;
/**
 *
 * @author Ellet
 */
public class dbUsers {
    
    public void IngresarRegistros(User user){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("INSERT INTO users(username,password,nivel) VALUES(?,?,?)");
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getNivel());
            pst.executeUpdate();
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public User BuscarUserPorId(int id){
        Conexion con = new Conexion();
        User user = null;
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT * FROM users WHERE id_user = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            return user;
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public void ModificarRegistros(User user){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("UPDATE users SET username =?,password =?,nivel=? WHERE id_user = ?");
            pst.setInt(4, user.getId_user());
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getNivel());
            pst.executeUpdate();
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void EliminarRegistros(int val){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareStatement("DELETE FROM users WHERE id_user = ?");
            pst.setInt(1, val);
            pst.executeUpdate();
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public User ConsultarRegistros(String parametro){
        Conexion con = new Conexion();
        User user = null;
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT * FROM users WHERE username = ?");
            pst.setString(1,parametro);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
            else{
                JOptionPane.showMessageDialog(null,"NO SE ENCONTRO USUARIO CON ESE NOMBRE","VALUE NOT FOUND",JOptionPane.ERROR_MESSAGE);
            }
            return user;
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    
}
