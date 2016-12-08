/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.formularios;

import Formularios.Principal.Principal;
import Formularios.Ventas.FacturaRecargas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import libraries.conexion.Conexion;

/**
 *
 * @author Ellet
 */
public class libFacturaRecargas {
    
    public void CargarDatosEmpleados(){
        FacturaRecargas.lbnombreempleado.setText(Principal.lbnombres.getText());
        FacturaRecargas.lbapellidoempleado.setText(Principal.lbapellidos.getText());
    }
    
    public void CargarValoresFactura(){
        Conexion con = new Conexion();
        try{
            Connection conex = con.Conectar();
            PreparedStatement pst = conex.prepareCall("SELECT * FROM ventas_recargas",1004,1007);
            ResultSet rs = pst.executeQuery();
            rs.last();
            FacturaRecargas.lbfecha.setText(rs.getString(2));
            FacturaRecargas.lbnumero.setText(rs.getString(4));
            FacturaRecargas.lbmonto.setText(rs.getString(5));
            FacturaRecargas.lbtotal.setText(rs.getString(8));
            FacturaRecargas.lbrecargo.setText(Integer.toString(rs.getInt(8)-rs.getInt(5)));
        }
        catch(SQLException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING",JOptionPane.ERROR_MESSAGE);
        }
    }
}
