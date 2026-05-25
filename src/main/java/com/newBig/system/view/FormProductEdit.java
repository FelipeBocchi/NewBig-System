/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.newBig.system.view;

import java.text.SimpleDateFormat;
import com.newBig.system.model.Product;
import com.newBig.system.model.Product.ProductType;
import com.newBig.system.model.Product.UnitType;
import com.newBig.system.service.HelpService;
import javax.swing.JOptionPane;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * 
 */
public class FormProductEdit extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormProductEdit.class.getName());
    private Product product;

    public FormProductEdit(java.awt.Frame parent, boolean modal,Product productEdit) {
        super(parent, modal);
        initComponents();
        this.product = productEdit;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        HeaderFormBatch = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnSaveActionPerformed = new javax.swing.JButton();
        txtPrice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCategory = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 249, 249));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HeaderFormBatch.setBackground(new java.awt.Color(248, 174, 176));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EDIT PRODUCT");

        javax.swing.GroupLayout HeaderFormBatchLayout = new javax.swing.GroupLayout(HeaderFormBatch);
        HeaderFormBatch.setLayout(HeaderFormBatchLayout);
        HeaderFormBatchLayout.setHorizontalGroup(
            HeaderFormBatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderFormBatchLayout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeaderFormBatchLayout.setVerticalGroup(
            HeaderFormBatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderFormBatchLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(HeaderFormBatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 70));

        txtProductName.setPreferredSize(new java.awt.Dimension(100, 24));
        txtProductName.addActionListener(this::txtProductNameActionPerformed);
        jPanel1.add(txtProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 430, 30));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("PRODUCT");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("CODE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        txtCode.addActionListener(this::txtCodeActionPerformed);
        jPanel1.add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 430, 30));

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("PRICE");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 249, 249));
        jButton1.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("CANCELAR");
        jButton1.addActionListener(this::jButton1ActionPerformed);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, 130, 40));

        btnSaveActionPerformed.setBackground(new java.awt.Color(248, 174, 176));
        btnSaveActionPerformed.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        btnSaveActionPerformed.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveActionPerformed.setText("SALVAR");
        btnSaveActionPerformed.addActionListener(this::btnSaveActionPerformed);
        jPanel1.add(btnSaveActionPerformed, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 130, 40));
        jPanel1.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 430, 30));

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("CATEGORY");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        txtCategory.addActionListener(this::txtCategoryActionPerformed);
        jPanel1.add(txtCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 430, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductNameActionPerformed

    private void txtCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

    
    try {
        // 1. Campos recebidos da interface gráfica (JTextFields)
        product.setProductName(txtProductName.getText());
        product.setCategory(txtCategory.getText());
        product.setSalePrice(new java.math.BigDecimal(txtPrice.getText()));
        

        product.setBarcode(Integer.parseInt(txtCode.getText()));

helpService.getProductService().update(
    product
);
        
        JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");
        dispose(); // Fecha o formulário dialog
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Erro de validação: Verifique se o preço foi digitado corretamente.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao salvar no banco de dados: " + e.getMessage());
    }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoryActionPerformed

    public void preencherCampos( String serie, String product, String quatity, String validity) {

        //txtProductName.setText(serie);
       // txtCode.setText(product);

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FormProductEdit dialog = new FormProductEdit(new javax.swing.JFrame(), true,null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

private HelpService helpService;

public FormProductEdit(java.awt.Frame parent, boolean modal, HelpService helpService, Product product) {
    super(parent, modal);
    initComponents();
    this.helpService = helpService;
    this.product = product;

    if (product != null) {
        fillFields(); // Método para colocar os dados do produto nos campos de texto
    }
}

private void fillFields() {
    // Esse método serve para pegar os dados do "product" e colocar nos inputs quando for EDITAR
    txtProductName.setText(product.getProductName());
    txtPrice.setText(String.valueOf(product.getSalePrice()));
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HeaderFormBatch;
    private javax.swing.JButton btnSaveActionPerformed;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProductName;
    // End of variables declaration//GEN-END:variables
}


