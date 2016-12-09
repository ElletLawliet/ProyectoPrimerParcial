/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios.Inventario;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import libraries.formularios.libConsultarProductos;
import libraries.identidades.ConsultaProducto;
/**
 *
 * @author Ellet
 */
public class ConsultarProducto extends javax.swing.JFrame {
    libConsultarProductos lcp = new libConsultarProductos();
    /**
     * Creates new form ConsultarProducto
     */
    public ConsultarProducto() {
        initComponents();
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

        cbcategoria = new javax.swing.JComboBox<>();
        botonconsultar = new javax.swing.JButton();
        botonsalir = new javax.swing.JButton();
        botonimprimir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaconsultaproductos = new javax.swing.JTable();
        txtbusqueda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setTitle("SDMT - CONSULTA DE PRODUCTOS");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbcategoria.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        cbcategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NOMBRE", "PROVEEDOR", "TIPO" }));
        cbcategoria.setSelectedIndex(-1);
        cbcategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbcategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(cbcategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 88, 149, -1));

        botonconsultar.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        botonconsultar.setText("CONSULTAR");
        botonconsultar.setEnabled(false);
        botonconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonconsultarActionPerformed(evt);
            }
        });
        getContentPane().add(botonconsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 88, 144, 64));

        botonsalir.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        botonsalir.setText("SALIR");
        botonsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonsalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 449, 144, 55));

        botonimprimir.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        botonimprimir.setText("IMPRIMIR");
        botonimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonimprimirActionPerformed(evt);
            }
        });
        getContentPane().add(botonimprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 449, 144, 55));

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel2.setText("CATEGORIA:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 91, -1, -1));

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel1.setText("CONSULTA DE PRODUCTOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 23, -1, -1));

        tablaconsultaproductos.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        tablaconsultaproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "DESCRIPCION", "TIPO", "PRECIO UNITARIO", "CANTIDAD", "PROVEEDOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaconsultaproductos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaconsultaproductos);
        if (tablaconsultaproductos.getColumnModel().getColumnCount() > 0) {
            tablaconsultaproductos.getColumnModel().getColumn(0).setResizable(false);
            tablaconsultaproductos.getColumnModel().getColumn(2).setResizable(false);
            tablaconsultaproductos.getColumnModel().getColumn(3).setResizable(false);
            tablaconsultaproductos.getColumnModel().getColumn(6).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 194, 768, 204));

        txtbusqueda.setEnabled(false);
        getContentPane().add(txtbusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 89, 136, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/rsz_muñequito_invisible.jpg"))); // NOI18N
        jLabel3.setText(" ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonsalirActionPerformed
        Limpiar();
        this.setVisible(false);
    }//GEN-LAST:event_botonsalirActionPerformed

    private void botonconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonconsultarActionPerformed
        tablaconsultaproductos.setModel(LlenarModelo());
        cbcategoria.setSelectedIndex(-1);
        txtbusqueda.setText("");
        txtbusqueda.setEnabled(false);
        botonconsultar.setEnabled(false);
        
    }//GEN-LAST:event_botonconsultarActionPerformed

    private void botonimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonimprimirActionPerformed
        Imprimir();
        Limpiar();
    }//GEN-LAST:event_botonimprimirActionPerformed

    private void cbcategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcategoriaActionPerformed
        txtbusqueda.setEnabled(true);
        botonconsultar.setEnabled(true);
    }//GEN-LAST:event_cbcategoriaActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonconsultar;
    private javax.swing.JButton botonimprimir;
    private javax.swing.JButton botonsalir;
    private javax.swing.JComboBox<String> cbcategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaconsultaproductos;
    private javax.swing.JTextField txtbusqueda;
    // End of variables declaration//GEN-END:variables
    
    public void Imprimir(){
        MessageFormat hf = new MessageFormat("Productos");
        MessageFormat ff = new MessageFormat("");
        try{
            tablaconsultaproductos.print(JTable.PrintMode.FIT_WIDTH,hf,ff);
        }
        catch(PrinterException exc){
            JOptionPane.showMessageDialog(null,exc.getMessage(),"WARNING!",JOptionPane.ERROR_MESSAGE);
        }   
    }
    public void Limpiar(){
        DefaultTableModel modelo = (DefaultTableModel) tablaconsultaproductos.getModel();
        modelo.setRowCount(0);
        tablaconsultaproductos.setModel(modelo);
        txtbusqueda.setText("");
        
    }
    
    public DefaultTableModel LlenarModelo(){
        List<ConsultaProducto> productos = lcp.Busqueda(txtbusqueda.getText(),cbcategoria.getSelectedIndex());
        DefaultTableModel dtm = (DefaultTableModel)tablaconsultaproductos.getModel();
        dtm.setRowCount(0);
        Object fila [] = new Object[tablaconsultaproductos.getColumnCount()];
        if(!productos.isEmpty()){
            for(ConsultaProducto producto : productos){
                fila[0] = producto.getCodigo();
                fila[1] = producto.getNombreProducto();
                fila[2] = producto.getDescripcion();
                fila[3] = producto.getTipo();
                fila[4] = producto.getPrecioUnitario();
                fila[5] = producto.getCantidad();
                fila[6] = producto.getProveedor();
                dtm.addRow(fila);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"NO SE ENCONTRO REGISTROS","NOT FOUND",JOptionPane.INFORMATION_MESSAGE);
        }
        return dtm;
    }




}
