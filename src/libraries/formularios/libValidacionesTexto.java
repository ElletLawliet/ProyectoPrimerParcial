/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries.formularios;

import Formularios.Mantenimiento.MantenimientoCargos;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Ellet
 */
public class libValidacionesTexto {
    public void ValidacionTexto(KeyEvent evt){
        char c = evt.getKeyChar();
        if(!(c < '0' || c >'9')){
            evt.consume();
        }
    }
    
    public void ValidacionNumerica(KeyEvent evt){
        char c = evt.getKeyChar();
        if(c < '0' || c >'9'){
            evt.consume();
        }
    }
    
    public void ValidarNumeroPunto(KeyEvent evt){
        int c = evt.getKeyChar();
        char d = evt.getKeyChar();
        if((d < '0' || d > '9') && c != 46 ){
            evt.consume();
        }
    }
    
    public void ValidarLetrasYNumeros(KeyEvent evt){
        int c = evt.getKeyChar();
        char d = evt.getKeyChar();
        if((d < '0' || d > '9') && (c < 97 || c > 122) && (c< 65 || c > 90)){
            evt.consume();
        }
    }
    
    public void ValidacionesCaracteresEspeciales(KeyEvent evt){
        int c = evt.getKeyChar();
        if((c > 32 && c < 39) || (c > 39 && c < 48) || (c > 57 && c < 65) || (c > 90 && c < 96) || (c > 122 && c < 128) || (c > 47 && c < 58)){
            evt.consume();
        }
    }
    
    public void ValidarLongitudCedula(KeyEvent evt, int longitud){
        if(longitud >= 10){
            evt.consume();
        }
    }
    
    public void ValidarLongitudUsuarios(KeyEvent evt, int longitud){
        if(longitud >= 16){
            evt.consume();
        }
    }
    
    public boolean ValidarLongitudMinimaCedula(int longitud){
        if(longitud < 10){
            JOptionPane.showMessageDialog(null,"LA CEDULA DEBE TENER 10 DIGITOS","WARNING",JOptionPane.ERROR_MESSAGE);
            return true;
        }
        else{
            return false;
        }
    }
    
    public void ValidacionesCodigoEmpleado(KeyEvent evt, int longitud){
        if(longitud >= 8){
            evt.consume();
        }
    }
    
    public void ValidacionesCodigoInventario(KeyEvent evt, int longitud){
        if(longitud >= 6){
            evt.consume();
        }
    }
    
    public void ValidacionesCodigoPromociones(KeyEvent evt, int longitud){
        if(longitud >= 7){
            evt.consume();
        }
    }
    
    public void ValidacionesCodigoProveedores(KeyEvent evt, int longitud){
        if(longitud >= 8){
            evt.consume();
        }
    }
    
    public boolean ValidarLongitudMinimaNumero(int longitud){
        if(longitud < 10){
            JOptionPane.showMessageDialog(null,"EL NUMERO DEBE TENER 10 DIGITOS","WARNING",JOptionPane.ERROR_MESSAGE);
            return true;
        }
        else{
            return false;
        }
    }
    
    public void ValidarLongitudNumero(KeyEvent evt, int longitud){
        if(longitud >= 10){
            evt.consume();
        }
    }
    
    
}
