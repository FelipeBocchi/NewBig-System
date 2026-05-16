/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.newBig.system.view;


import com.newBig.system.model.Product;
import com.newBig.system.config.FlyWayConfig;
import com.newBig.system.model.Batch;
import com.newBig.system.repository.BatchRepository;
import com.newBig.system.repository.CustomizerFactory;
import com.newBig.system.repository.ProductRepository;
import com.newBig.system.repository.StockMovementRepository;
import com.newBig.system.service.BatchService;
import com.newBig.system.service.HelpService;
import com.newBig.system.service.ProductService;
import jakarta.persistence.EntityManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 *
 * @author bocchi
 */
public class ProductView extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ProductView.class.getName());
    private HelpService helpService;

    public ProductView(HelpService helpService) {
    initComponents();
    this.helpService = helpService;
    
    // TRECHO NOVO:
    loadProductTable(); // Garante que os dados apareçam ao abrir a tela
}
    
    private void loadProductTable() {
    DefaultTableModel tableModel = (DefaultTableModel) TblBatch.getModel();
    tableModel.setNumRows(0); 

    try {
        // REFATORADO: Agora chama getProductService()
        List<Product> listProducts = helpService.getProductService().findAll();

        for (Product p : listProducts) {
            tableModel.addRow(new Object[] {
                p.getBarcode(),        // Mudou de ID para Barcode
                p.getProductName(),    // Nome do Produto
                p.getCategory(),       // Categoria
                p.getSalePrice(),      // Preço de Venda
                p.getUnit(),           // Unidade (un, kg, etc)
                p.getType()            // Status/Tipo
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao carregar produtos: " + e.getMessage());
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        MenuBar = new javax.swing.JPanel();
        Dashbaord = new javax.swing.JButton();
        BtnSale = new javax.swing.JButton();
        BtnProduct = new javax.swing.JButton();
        BtnBatch = new javax.swing.JButton();
        MainPanel = new javax.swing.JPanel();
        Batch = new javax.swing.JPanel();
        filter = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        TableBatch = new javax.swing.JScrollPane();
        TblBatch = new javax.swing.JTable();
        Button = new javax.swing.JPanel();
        BtnAddBatch = new javax.swing.JButton();
        BtnEditBatch = new javax.swing.JButton();
        BtnDeleteBatch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Batch");

        Background.setBackground(new java.awt.Color(242, 242, 200));

        Dashbaord.setText("Products");
        Dashbaord.addActionListener(this::DashbaordActionPerformed);

        BtnSale.setText("Categories");
        BtnSale.addActionListener(this::BtnSaleActionPerformed);

        BtnProduct.setText("Units");
        BtnProduct.addActionListener(this::BtnProductActionPerformed);

        BtnBatch.setText("Add Product");
        BtnBatch.addActionListener(this::BtnBatchActionPerformed);

        javax.swing.GroupLayout MenuBarLayout = new javax.swing.GroupLayout(MenuBar);
        MenuBar.setLayout(MenuBarLayout);
        MenuBarLayout.setHorizontalGroup(
            MenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Dashbaord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BtnSale, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
            .addComponent(BtnProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
            .addComponent(BtnBatch, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );
        MenuBarLayout.setVerticalGroup(
            MenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuBarLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(Dashbaord, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnSale, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MainPanel.setBackground(new java.awt.Color(242, 200, 242));
        MainPanel.setLayout(new java.awt.CardLayout());

        Batch.setBackground(new java.awt.Color(255, 249, 249));

        filter.setBackground(new java.awt.Color(255, 249, 249));

        jTextField1.setText("Search product");

        jLabel1.setFont(new java.awt.Font("FreeSerif", 0, 24)); // NOI18N
        jLabel1.setText("Product");

        javax.swing.GroupLayout filterLayout = new javax.swing.GroupLayout(filter);
        filter.setLayout(filterLayout);
        filterLayout.setHorizontalGroup(
            filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        filterLayout.setVerticalGroup(
            filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filterLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(15, 15, 15))
        );

        TblBatch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Product Name", "Category", "Price", "Unit ", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableBatch.setViewportView(TblBatch);

        Button.setBackground(new java.awt.Color(255, 249, 249));

        BtnAddBatch.setText("Add");
        BtnAddBatch.addActionListener(this::BtnAddBatchActionPerformed);

        BtnEditBatch.setText("Edit");
        BtnEditBatch.addActionListener(this::BtnEditBatchActionPerformed);

        BtnDeleteBatch.setText("Delete");
        BtnDeleteBatch.addActionListener(this::BtnDeleteBatchActionPerformed);

        javax.swing.GroupLayout ButtonLayout = new javax.swing.GroupLayout(Button);
        Button.setLayout(ButtonLayout);
        ButtonLayout.setHorizontalGroup(
            ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonLayout.createSequentialGroup()
                .addComponent(BtnAddBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnEditBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnDeleteBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ButtonLayout.setVerticalGroup(
            ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAddBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEditBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnDeleteBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout BatchLayout = new javax.swing.GroupLayout(Batch);
        Batch.setLayout(BatchLayout);
        BatchLayout.setHorizontalGroup(
            BatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BatchLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(BatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(TableBatch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                        .addComponent(Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        BatchLayout.setVerticalGroup(
            BatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BatchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TableBatch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        MainPanel.add(Batch, "Batch");

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addComponent(MenuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DashbaordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashbaordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DashbaordActionPerformed

    private void BtnSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnSaleActionPerformed

    private void BtnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnProductActionPerformed

    private void BtnBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnBatchActionPerformed

    private void BtnEditBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditBatchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnEditBatchActionPerformed

    private void BtnDeleteBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteBatchActionPerformed
        int linhaSelecionada = TblBatch.getSelectedRow();

        // = Verificar se o usuário realmente selecionou algo
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um produto para deletar.");
            return;
        }

        int linhaModelo = TblBatch.convertRowIndexToModel(linhaSelecionada);

        // 1. Pegamos o código do produto (Barcode) que está na primeira coluna (índice 0) da tabela
        int barcode = Integer.parseInt(TblBatch.getModel().getValueAt(linhaModelo, 0).toString());

        // 2. Buscamos o produto usando o ProductService
        Product product = helpService.getProductService().findByBarcode(barcode); 
        // NOTA: Se o seu service buscar por ID em vez de Barcode, mude para:
        // Product product = helpService.getProductService().searchById(Long.valueOf(...));

        if (product == null) {
            JOptionPane.showMessageDialog(this, "Produto não encontrado no sistema.");
            return;
        }

        try {
            // 4. Executa o delete através do ProductService
            helpService.getProductService().delete(product); 
            // NOTA: Se o seu método do service deletar por código/ID direto, use:
            // helpService.getProductService().deleteByBarcode(barcode);

            JOptionPane.showMessageDialog(this, "Produto deletado com sucesso!");

            // 5. Atualiza a tabela de produtos para sumir com o registro deletado
            loadProductTable(); 

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao deletar produto: " + e.getMessage());
        }
        
    }//GEN-LAST:event_BtnDeleteBatchActionPerformed

    private void loadBatchTable() {

        DefaultTableModel tableModel = (DefaultTableModel) TblBatch.getModel();
        tableModel.setNumRows(0);

        try {

            List<Batch> listBatch = helpService.getBatchService().findAll();

            for (Batch b : listBatch) {
                tableModel.addRow( new Object[] {
                        b.getId(),
                        b.getSeries(),
                        b.getProduct().getProductName(),
                        b.getAmount(),
                        b.getValidity()
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar tabela: " + e.getMessage());
        }


    }

    private void BtnAddBatchActionPerformed(java.awt.event.ActionEvent evt) {
    FormProductDialog dialog = new FormProductDialog(this, true, helpService, null);
    dialog.setLocationRelativeTo(this);
    dialog.setVisible(true);
    
    loadProductTable(); // Recarrega a tabela após fechar o dialog
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

        // temporario
        //FlyWayConfig.migrate();
        //  = Conecção com o banco e inicialização
        EntityManager em = CustomizerFactory.getEntityManager();

        //  = repository
        ProductRepository productRepository = new ProductRepository(em);
        BatchRepository batchRepository = new BatchRepository(em);
        StockMovementRepository stockMovementRepository = new StockMovementRepository(em);

        //  = service
        ProductService productService = new ProductService(productRepository);
        BatchService batchService = new BatchService(batchRepository, productRepository,stockMovementRepository);

        HelpService helpService = new HelpService(productService, batchService);


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ProductView(helpService).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JPanel Batch;
    private javax.swing.JButton BtnAddBatch;
    private javax.swing.JButton BtnBatch;
    private javax.swing.JButton BtnDeleteBatch;
    private javax.swing.JButton BtnEditBatch;
    private javax.swing.JButton BtnProduct;
    private javax.swing.JButton BtnSale;
    private javax.swing.JPanel Button;
    private javax.swing.JButton Dashbaord;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel MenuBar;
    private javax.swing.JScrollPane TableBatch;
    private javax.swing.JTable TblBatch;
    private javax.swing.JPanel filter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
