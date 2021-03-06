/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios.Mantenimiento;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import libraries.formularios.dbInventario;
import libraries.formularios.dbProveedores;
import libraries.formularios.libValidacionesTexto;
import libraries.identidades.Inventario;
import libraries.identidades.Proveedor;


/**
 *
 * @author Ellet
 */
public class MantenimientoInventarios extends javax.swing.JFrame {
    dbInventario dbi = new dbInventario();
    dbProveedores dbp = new dbProveedores();
    DefaultListModel dlm = new DefaultListModel();
    /**
     * Creates new form MantenimientoInventario
     */
    public MantenimientoInventarios() {
        initComponents();
        lbidproducto.setVisible(false);
        txtidproducto.setVisible(false);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtadescripcion = new javax.swing.JTextArea();
        txtnombre = new javax.swing.JTextField();
        txtpreciounitario = new javax.swing.JTextField();
        spcantidad = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbproveedores = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbtipo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        botoncancelar = new javax.swing.JButton();
        botonnuevo = new javax.swing.JButton();
        botonmodificar = new javax.swing.JButton();
        botoneliminar = new javax.swing.JButton();
        botonconsultar = new javax.swing.JButton();
        botonguardar = new javax.swing.JButton();
        botonrealizarconsulta = new javax.swing.JButton();
        lbidproducto = new javax.swing.JLabel();
        txtidproducto = new javax.swing.JTextField();
        lbimagenfondo = new javax.swing.JLabel();

        setTitle("MANTENIMIENTO DE PRODUCTOS");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel6.setText("CODIGO:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 54, -1, -1));

        jLabel8.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel8.setText("DESCRIPCION:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 135, -1, -1));

        txtcodigo.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtcodigo.setEnabled(false);
        txtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigoKeyTyped(evt);
            }
        });
        getContentPane().add(txtcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 51, 200, -1));

        jScrollPane1.setEnabled(false);

        txtadescripcion.setColumns(20);
        txtadescripcion.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtadescripcion.setRows(5);
        txtadescripcion.setEnabled(false);
        jScrollPane1.setViewportView(txtadescripcion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 135, 200, -1));

        txtnombre.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtnombre.setEnabled(false);
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 94, 200, -1));

        txtpreciounitario.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtpreciounitario.setEnabled(false);
        txtpreciounitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpreciounitarioKeyTyped(evt);
            }
        });
        getContentPane().add(txtpreciounitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 285, 200, -1));

        spcantidad.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        spcantidad.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spcantidad.setEnabled(false);
        spcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                spcantidadKeyTyped(evt);
            }
        });
        getContentPane().add(spcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 367, 70, -1));

        jLabel5.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel5.setText("PROVEEDOR:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 329, -1, -1));

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel2.setText("NOMBRE:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 97, -1, -1));

        cbproveedores.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        cbproveedores.setEnabled(false);
        getContentPane().add(cbproveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 326, 200, -1));

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel3.setText("PRECIO UNITARIO:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 288, -1, -1));

        jLabel7.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel7.setText("TIPO:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 247, -1, -1));

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel4.setText("CANTIDAD:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 370, -1, -1));

        cbtipo.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        cbtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CHIP", "RECARGA" }));
        cbtipo.setSelectedIndex(-1);
        cbtipo.setEnabled(false);
        cbtipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbtipoItemStateChanged(evt);
            }
        });
        cbtipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtipoActionPerformed(evt);
            }
        });
        getContentPane().add(cbtipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 244, 200, -1));

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel1.setText("MANTENIMIENTO DE PRODUCTOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 11, -1, -1));

        botoncancelar.setText("CANCELAR");
        botoncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botoncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 569, 140, 40));

        botonnuevo.setText("NUEVO");
        botonnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonnuevoActionPerformed(evt);
            }
        });
        getContentPane().add(botonnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 453, 146, 40));

        botonmodificar.setText("MODIFICAR");
        botonmodificar.setEnabled(false);
        botonmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonmodificarActionPerformed(evt);
            }
        });
        getContentPane().add(botonmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 511, -1, 40));

        botoneliminar.setText("ELIMINAR");
        botoneliminar.setEnabled(false);
        botoneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoneliminarActionPerformed(evt);
            }
        });
        getContentPane().add(botoneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 511, 92, 40));

        botonconsultar.setText("CONSULTAR");
        botonconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonconsultarActionPerformed(evt);
            }
        });
        getContentPane().add(botonconsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 453, 146, 40));

        botonguardar.setText("GUARDAR");
        botonguardar.setEnabled(false);
        botonguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonguardarActionPerformed(evt);
            }
        });
        getContentPane().add(botonguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 511, 90, 40));

        botonrealizarconsulta.setText("...");
        botonrealizarconsulta.setEnabled(false);
        botonrealizarconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonrealizarconsultaActionPerformed(evt);
            }
        });
        getContentPane().add(botonrealizarconsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 51, 31, -1));

        lbidproducto.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lbidproducto.setText("ID PRODUCTO:");
        getContentPane().add(lbidproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 412, -1, -1));

        txtidproducto.setEditable(false);
        txtidproducto.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtidproducto.setEnabled(false);
        getContentPane().add(txtidproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 409, 70, -1));

        lbimagenfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/rsz_mantenimiento.jpg"))); // NOI18N
        lbimagenfondo.setText(" ");
        getContentPane().add(lbimagenfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -1, 430, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbtipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbtipoItemStateChanged
       
    }//GEN-LAST:event_cbtipoItemStateChanged

    private void cbtipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtipoActionPerformed
         if(cbtipo.getSelectedIndex() != -1){
            cbproveedores.removeAllItems();
            CargarProveedores();
        }
    }//GEN-LAST:event_cbtipoActionPerformed

    private void botoncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_botoncancelarActionPerformed

    private void botonnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonnuevoActionPerformed
        botonguardar.setEnabled(true);
        botonrealizarconsulta.setEnabled(false);
        botonmodificar.setEnabled(false);
        botoneliminar.setEnabled(false);
        lbidproducto.setVisible(false);
        txtidproducto.setVisible(false);
        HabilitarCampos();
        botonnuevo.setEnabled(false);
        botonconsultar.setEnabled(true);
        Limpiar();
    }//GEN-LAST:event_botonnuevoActionPerformed

    private void botoneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoneliminarActionPerformed
        if(ValidarEspaciosEliminar()){
            JOptionPane.showMessageDialog(null, "DEBE LLENAR LA ID DEL PRODUCTO A ELIMINAR", "WARNING",JOptionPane.ERROR_MESSAGE);
        }
        else{
            dbi.EliminarRegistros(Integer.parseInt(txtidproducto.getText()));
            DeshabilitarCampos();
            botonnuevo.setEnabled(true);
            botonconsultar.setEnabled(true);
            botonrealizarconsulta.setEnabled(false);
            botonmodificar.setEnabled(false);
            botoneliminar.setEnabled(false);
            botonguardar.setEnabled(false);
            Limpiar();
        }
        
    }//GEN-LAST:event_botoneliminarActionPerformed

    private void botonconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonconsultarActionPerformed
        botonguardar.setEnabled(false);
        botonrealizarconsulta.setEnabled(true);
        botonmodificar.setEnabled(true);
        botoneliminar.setEnabled(true);
        lbidproducto.setVisible(true);
        txtidproducto.setVisible(true);
        HabilitarCampos();
        botonconsultar.setEnabled(false);
        botonnuevo.setEnabled(true);
        Limpiar();
    }//GEN-LAST:event_botonconsultarActionPerformed

    private void botonguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonguardarActionPerformed
        if(ValidarEspaciosGuardar()){
            JOptionPane.showMessageDialog(null, "DEBE LLENAR TODOS LOS DATOS", "WARNING",JOptionPane.ERROR_MESSAGE);
        }
        else{
            Proveedor proveedor = (Proveedor) dlm.getElementAt(cbproveedores.getSelectedIndex());
            Inventario inventario = new Inventario(txtcodigo.getText(),txtnombre.getText(),
                txtadescripcion.getText(),cbtipo.getSelectedItem().toString(),Double.parseDouble(txtpreciounitario.getText()),
                (Integer)spcantidad.getValue(), proveedor);
            dbi.IngresarRegistros(inventario);
            botonconsultar.setEnabled(true);
            botonnuevo.setEnabled(true);
            botonrealizarconsulta.setEnabled(false);
            botonmodificar.setEnabled(false);
            botoneliminar.setEnabled(false);
            botonguardar.setEnabled(false);
            DeshabilitarCampos();
            Limpiar();
        }
            
        
    }//GEN-LAST:event_botonguardarActionPerformed

    private void botonrealizarconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonrealizarconsultaActionPerformed
        if(txtcodigo.getText().replaceAll("\\s","").equals("")){
            JOptionPane.showMessageDialog(null, "PORFAVOR LLENE PARAMETRO DE BUSQUEDA","WARNING",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
             Consultar();
        }
        
       
    }//GEN-LAST:event_botonrealizarconsultaActionPerformed

    private void botonmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonmodificarActionPerformed
        if(ValidarEspaciosModificar()){
            JOptionPane.showMessageDialog(null, "DEBE LLENAR TODOS LOS DATOS", "WARNING",JOptionPane.ERROR_MESSAGE);
        }
        else{
            Proveedor proveedor = (Proveedor) dlm.getElementAt(cbproveedores.getSelectedIndex());
            Inventario inventario = new Inventario(Integer.parseInt(txtidproducto.getText()),txtcodigo.getText(),txtnombre.getText(),
                txtadescripcion.getText(),cbtipo.getSelectedItem().toString(),Double.parseDouble(txtpreciounitario.getText()),
                (Integer)spcantidad.getValue(), proveedor);
            dbi.ModificarRegistros(inventario);
            DeshabilitarCampos();
            botonnuevo.setEnabled(true);
            botonconsultar.setEnabled(true);
            botonrealizarconsulta.setEnabled(false);
            botonmodificar.setEnabled(false);
            botoneliminar.setEnabled(false);
            botonguardar.setEnabled(false);
            Limpiar();
        }
        
    }//GEN-LAST:event_botonmodificarActionPerformed

    private void txtcodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyTyped
        new libValidacionesTexto().ValidacionesCodigoInventario(evt,txtcodigo.getText().length());
        new libValidacionesTexto().ValidarLetrasYNumeros(evt);
    }//GEN-LAST:event_txtcodigoKeyTyped

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        new libValidacionesTexto().ValidacionesCaracteresEspeciales(evt);
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtpreciounitarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpreciounitarioKeyTyped
        new libValidacionesTexto().ValidarNumeroPunto(evt);
    }//GEN-LAST:event_txtpreciounitarioKeyTyped

    private void spcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spcantidadKeyTyped
        new libValidacionesTexto().ValidacionNumerica(evt);
    }//GEN-LAST:event_spcantidadKeyTyped
    
    public void HabilitarCampos(){
        txtcodigo.setEnabled(true);
        txtnombre.setEnabled(true);
        txtadescripcion.setEnabled(true);
        cbtipo.setEnabled(true);
        txtpreciounitario.setEnabled(true);
        cbproveedores.setEnabled(true);
        spcantidad.setEnabled(true);
        txtidproducto.setEnabled(true);
    }
    
    public void DeshabilitarCampos(){
        txtcodigo.setEnabled(false);
        txtnombre.setEnabled(false);
        txtadescripcion.setEnabled(false);
        cbtipo.setEnabled(false);
        txtpreciounitario.setEnabled(false);
        cbproveedores.setEnabled(false);
        spcantidad.setEnabled(false);
        txtidproducto.setEnabled(false);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MantenimientoInventarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenimientoInventarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenimientoInventarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenimientoInventarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenimientoInventarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botoncancelar;
    private javax.swing.JButton botonconsultar;
    private javax.swing.JButton botoneliminar;
    private javax.swing.JButton botonguardar;
    private javax.swing.JButton botonmodificar;
    private javax.swing.JButton botonnuevo;
    private javax.swing.JButton botonrealizarconsulta;
    public static javax.swing.JComboBox<String> cbproveedores;
    public static javax.swing.JComboBox<String> cbtipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbidproducto;
    private javax.swing.JLabel lbimagenfondo;
    public static javax.swing.JSpinner spcantidad;
    public static javax.swing.JTextArea txtadescripcion;
    public static javax.swing.JTextField txtcodigo;
    public static javax.swing.JTextField txtidproducto;
    public static javax.swing.JTextField txtnombre;
    public static javax.swing.JTextField txtpreciounitario;
    // End of variables declaration//GEN-END:variables
    
    public void Consultar(){
        Inventario inventario = dbi.ConsultarRegistros(txtcodigo.getText());
        if(inventario != null){
            txtcodigo.setText(inventario.getCodigo_producto());
            txtnombre.setText(inventario.getNombre_producto());
            txtadescripcion.setText(inventario.getDescripcion());
            cbtipo.setSelectedItem(inventario.getTipo());
            cbproveedores.setSelectedItem(inventario.getProveedor().getNombre_proveedores());
            txtpreciounitario.setText(Double.toString(inventario.getPrecio_unitario()));
            spcantidad.setValue(inventario.getCantidad());
            txtidproducto.setText(Integer.toString(inventario.getId_inventario()));
        }
    }
    
    public void CargarProveedores(){
        List<Proveedor> proveedores = dbp.CargarProveedores(cbtipo.getSelectedItem().toString());
        dlm.removeAllElements();
        for(Proveedor proveedor : proveedores){
            cbproveedores.addItem(proveedor.getNombre_proveedores());
            dlm.addElement(proveedor);
        }
        cbproveedores.setSelectedIndex(-1);
    }
    
    public void Limpiar(){
        txtidproducto.setText("");
        txtcodigo.setText("");
        txtnombre.setText("");
        txtadescripcion.setText("");
        cbtipo.setSelectedIndex(-1);
        txtpreciounitario.setText("");
        cbproveedores.setSelectedIndex(-1);
        spcantidad.setValue(0);
        
    }
    
    public boolean ValidarEspaciosGuardar(){
        boolean espacio = false;
        if(txtcodigo.getText().replaceAll("\\s","").equals("")){
            espacio = true;
        }
        if(txtnombre.getText().replaceAll("\\s","").equals("")){
            espacio = true;
        }
        if(txtadescripcion.getText().replaceAll("\\s","").equals("")){
            espacio = true;
        }
        if(cbtipo.getSelectedIndex() == -1){
            espacio = true;
        }
        if(txtpreciounitario.getText().replaceAll("\\s","").equals("")){
            espacio = true;
        }
        if(cbproveedores.getSelectedIndex() == -1){
            espacio = true;
        }
        if(Integer.parseInt(spcantidad.getValue().toString()) == 0){
            espacio = true;
        }
        return espacio;
    }
    
    public boolean ValidarEspaciosModificar(){
        boolean espacio = false;
        if(txtcodigo.getText().replaceAll("\\s","").equals("")){
            espacio = true;
        }
        if(txtnombre.getText().replaceAll("\\s","").equals("")){
            espacio = true;
        }
        if(txtadescripcion.getText().replaceAll("\\s","").equals("")){
            espacio = true;
        }
        if(cbtipo.getSelectedIndex() == -1){
            espacio = true;
        }
        if(txtpreciounitario.getText().replaceAll("\\s","").equals("")){
            espacio = true;
        }
        if(cbproveedores.getSelectedIndex() == -1){
            espacio = true;
        }
        if(Integer.parseInt(spcantidad.getValue().toString()) == 0){
            espacio = true;
        }
        if(txtidproducto.getText().replaceAll("\\s","").equals("")){
            espacio = true;
        }
        return espacio;
    }
    
    public boolean ValidarEspaciosEliminar(){
        boolean espacio = false;
        if(txtidproducto.getText().replaceAll("\\s","").equals("")){
            espacio = true;
        }
        return espacio;
    }


}
