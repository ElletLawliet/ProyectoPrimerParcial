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
import javax.swing.JOptionPane;
import libraries.conexion.Conexion;
import libraries.identidades.Cargo;
import libraries.identidades.Empleado;
import libraries.identidades.User;
/**
 *
 * @author Ellet
 */
public class libLogin {
    
    
    public boolean ComprobarLogin(String username, String password){
        Conexion con = new Conexion();
        boolean log = false;
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT username,password FROM users");
            ResultSet rs = pst.executeQuery();
            while(rs.next() && log == false){
                if(username.equals(rs.getString(1)) && password.equals(rs.getString(2))){
                    log = true;
                }
            }
            return log;
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            return log;
        }
    }
    
    
    
    public Empleado CargarDatos(String parametro){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT cargos.*,users.*,empleados.* FROM empleados "
                + "INNER JOIN users ON (users.id_user = empleados.id_user) "
                + "INNER JOIN cargos ON (cargos.id_cargo = empleados.id_cargo) "
                + "WHERE users.username = ? ");
            pst.setString(1, parametro);
            ResultSet rs = pst.executeQuery();
            rs.next();
            Cargo cargo = new Cargo(rs.getInt(1),rs.getString(2));
            User user = new User(rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6));
            Empleado empleado = new Empleado(rs.getInt(7),rs.getString(8),rs.getString(9),
                    rs.getString(10),rs.getString(11),rs.getString(12),
                    rs.getString(13),cargo,user,rs.getDate(16));
            return empleado;
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    
}
