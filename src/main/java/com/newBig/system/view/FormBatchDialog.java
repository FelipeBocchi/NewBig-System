/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.newBig.system.view;

import com.newBig.system.model.entity.Batch;
import com.newBig.system.model.entity.Product;
import com.newBig.system.model.service.BatchService;
import com.newBig.system.model.service.HelpService;
import com.newBig.system.model.service.ProductService;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bocchi
 */
public class FormBatchDialog extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormBatchDialog.class.getName());
    private HelpService helpService;
    public Batch newBatch;
    /**
     * Creates new form FormBatchDialog
     */
    public FormBatchDialog(java.awt.Frame parent, boolean modal, HelpService helpService) {
        super(parent, modal);
        initComponents();
        this.helpService = helpService;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        HeaderFormBatch = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtSerieBatch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtProductBatch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtQuantityBatch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        BtnSalveDialogBatch = new javax.swing.JButton();
        TxtValidatyBatch = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 249, 249));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HeaderFormBatch.setBackground(new java.awt.Color(248, 174, 176));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ENTRADA DE LOTE");

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

        TxtSerieBatch.setPreferredSize(new java.awt.Dimension(100, 24));
        jPanel1.add(TxtSerieBatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 430, 30));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Serie");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("ID Produto");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));
        jPanel1.add(TxtProductBatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 430, 30));

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Quatidade");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));
        jPanel1.add(TxtQuantityBatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 430, 30));

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Validade");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 249, 249));
        jButton1.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("CANCELAR");
        jButton1.addActionListener(this::jButton1ActionPerformed);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, 130, 40));

        BtnSalveDialogBatch.setBackground(new java.awt.Color(248, 174, 176));
        BtnSalveDialogBatch.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        BtnSalveDialogBatch.setForeground(new java.awt.Color(255, 255, 255));
        BtnSalveDialogBatch.setText("SALVAR");
        BtnSalveDialogBatch.addActionListener(this::BtnSalveDialogBatchActionPerformed);
        jPanel1.add(BtnSalveDialogBatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 130, 40));
        jPanel1.add(TxtValidatyBatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 430, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BtnSalveDialogBatchActionPerformed(java.awt.event.ActionEvent evt) {                                                    

        try {
            //  = Coleta os dados da interface
            Batch newBatch = new Batch();  //   = criamos um lote vazio para irmos preenchendo com base das informações o user
            String textoSerie = TxtSerieBatch.getText();
            if (!textoSerie.isEmpty()) {
                newBatch.setSeries(textoSerie.charAt(0));
            } else {
                // Caso o usuário não digite nada, você pode definir um padrão
                newBatch.setSeries('A');
            }

            ProductService productService = helpService.getProductService();
            List<Product> product = productService.searchByBarcode(Integer.parseInt(TxtProductBatch.getText()));
            newBatch.setProduct(product.get(0));
            
            newBatch.setAmount(Integer.parseInt(TxtQuantityBatch.getText()));

            Date dataDoFront = TxtValidatyBatch.getDate();
            if (dataDoFront == null) {
                JOptionPane.showMessageDialog(null, "Por favor, selecione uma data!");
                return;
            }
            LocalDate dataConvertida = dataDoFront.toInstant()
                    .atZone(java.time.ZoneId.systemDefault())
                    .toLocalDate();
            newBatch.setValidity(dataConvertida);

            // Chama CRUD
            BatchService batchService = helpService.getBatchService();
            batchService.arrivalBatch(newBatch.getProduct(), newBatch.getValidity(), newBatch.getAmount(), newBatch.getSeries());

            this.newBatch = newBatch;
            //  = Escreve na tabela para não precisar fazer outra chamada no banco
            //DefaultTableModel tableModel = (DefaultTableModel)

            JOptionPane.showMessageDialog(this, "Lote salvo com sucesso!");
            this.dispose(); // Fecha apenas a janelinha de cadastro

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage());
        }

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
                FormBatchDialog dialog = new FormBatchDialog(new javax.swing.JFrame(), true, null);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSalveDialogBatch;
    private javax.swing.JPanel HeaderFormBatch;
    private javax.swing.JTextField TxtProductBatch;
    private javax.swing.JTextField TxtQuantityBatch;
    private javax.swing.JTextField TxtSerieBatch;
    private com.toedter.calendar.JDateChooser TxtValidatyBatch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
