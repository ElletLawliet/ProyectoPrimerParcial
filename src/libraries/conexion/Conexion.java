/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ellet
 */
public class Conexion {
    public Connection Conectar(){
        Connection conex = null;
        try{
            Class.forName("org.postgresql.Driver");
            conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SDMT","Ellet","1234");
        }
        catch(SQLException | ClassNotFoundException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return conex;
    }
}
