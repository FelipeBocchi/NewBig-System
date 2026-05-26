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
import com.newBig.system.service.*;
import jakarta.persistence.EntityManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;


public class ProductView extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ProductView.class.getName());
    Login login = new Login();
    private HelpService helpService;

    public ProductView(HelpService helpService) {
    initComponents();
    this.helpService = helpService;

    logoUsuario();
    logoNewBig();
    LgNome.setText(login.nomeLog());
    LgAcesso.setText(login.acessoLog());

    // Garante que os dados apareçam ao abrir a tela
    loadProductTable();
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
        menuLateral3 = new javax.swing.JPanel();
        NBLogo = new javax.swing.JLabel();
        menuLTitulo = new javax.swing.JLabel();
        btnCaixa = new javax.swing.JButton();
        btnFuncionarios = new javax.swing.JButton();
        btnClientes1 = new javax.swing.JButton();
        btnLote = new javax.swing.JButton();
        btnProduto = new javax.swing.JButton();
        btnVenda = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        LgNome = new javax.swing.JLabel();
        LgAcesso = new javax.swing.JLabel();
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
        MenuBarra = new javax.swing.JMenuBar();
        menuBar = new javax.swing.JMenu();
        menuLogin = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Batch");

        Background.setBackground(new java.awt.Color(242, 242, 200));

        menuLateral3.setBackground(new java.awt.Color(251, 227, 228));

        NBLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        NBLogo.setMaximumSize(new java.awt.Dimension(80, 80));
        NBLogo.setPreferredSize(new java.awt.Dimension(80, 80));

        menuLTitulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        menuLTitulo.setText("NewBig-System");

        btnCaixa.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        btnCaixa.setText("Caixa");
        btnCaixa.addActionListener(this::btnCaixaActionPerformed);

        btnFuncionarios.setBackground(new java.awt.Color(253, 238, 239));
        btnFuncionarios.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        btnFuncionarios.setText("Funcionarios");
        btnFuncionarios.addActionListener(this::btnFuncionariosActionPerformed);

        btnClientes1.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        btnClientes1.setText("Clientes");
        btnClientes1.addActionListener(this::btnClientes1ActionPerformed);

        btnLote.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        btnLote.setText("Lote");
        btnLote.addActionListener(this::btnLoteActionPerformed);

        btnProduto.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        btnProduto.setText("Produtos");
        btnProduto.addActionListener(this::btnProdutoActionPerformed);

        btnVenda.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        btnVenda.setText("Venda");
        btnVenda.addActionListener(this::btnVendaActionPerformed);

        btnInicio.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        btnInicio.setText("Inicio");
        btnInicio.addActionListener(this::btnInicioActionPerformed);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/avatar.png"))); // NOI18N
        logo.setMaximumSize(new java.awt.Dimension(40, 40));
        logo.setPreferredSize(new java.awt.Dimension(40, 40));

        LgNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LgNome.setText("Mourvan");

        LgAcesso.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        LgAcesso.setText("Administrador");

        javax.swing.GroupLayout menuLateral3Layout = new javax.swing.GroupLayout(menuLateral3);
        menuLateral3.setLayout(menuLateral3Layout);
        menuLateral3Layout.setHorizontalGroup(
            menuLateral3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLateral3Layout.createSequentialGroup()
                .addGap(0, 53, Short.MAX_VALUE)
                .addComponent(menuLTitulo)
                .addGap(47, 47, 47))
            .addGroup(menuLateral3Layout.createSequentialGroup()
                .addGroup(menuLateral3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLateral3Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(NBLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLateral3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(menuLateral3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(menuLateral3Layout.createSequentialGroup()
                                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(menuLateral3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LgAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LgNome, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(menuLateral3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnFuncionarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCaixa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnClientes1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLote, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuLateral3Layout.setVerticalGroup(
            menuLateral3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLateral3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NBLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuLTitulo)
                .addGap(18, 18, 18)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLote, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClientes1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuLateral3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(menuLateral3Layout.createSequentialGroup()
                        .addComponent(LgNome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LgAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
                "Code", "Produto Nome", "Categoria", "Preço", "Unit ", "Status"
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
                .addContainerGap(305, Short.MAX_VALUE))
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
                .addComponent(TableBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(BatchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BatchLayout.setVerticalGroup(
            BatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BatchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TableBatch, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        MainPanel.add(Batch, "Batch");

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addComponent(menuLateral3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuLateral3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menuBar.setText("Menu");

        menuLogin.setText("Login");
        menuLogin.addActionListener(this::menuLoginActionPerformed);
        menuBar.add(menuLogin);

        menuSair.setText("Sair");
        menuSair.addActionListener(this::menuSairActionPerformed);
        menuBar.add(menuSair);

        MenuBarra.add(menuBar);

        setJMenuBar(MenuBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void BtnEditBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditBatchActionPerformed
        int linhaSelecionada = TblBatch.getSelectedRow();
        
        int linhaModelo = TblBatch.convertRowIndexToModel(linhaSelecionada);

        //  Pegamos o código do produto (Barcode) que está na primeira coluna (índice 0) da tabela
        int barcode = Integer.parseInt(TblBatch.getModel().getValueAt(linhaModelo, 0).toString());

        //  Buscamos o produto usando o ProductService
        Product product = helpService.getProductService().findByBarcode(barcode);
        //  = Verificar se o usuário realmente selecionou algo (-1 significa que nada foi selecionado)
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione uma linha para editar.");
            return;
        }

        String Code = TblBatch.getModel().getValueAt(linhaModelo, 0).toString();
        String ProductName = TblBatch.getModel().getValueAt(linhaModelo, 1).toString();
        String Category = TblBatch.getModel().getValueAt(linhaModelo, 2).toString();
        String Price = TblBatch.getModel().getValueAt(linhaModelo, 3).toString();

        //  = Abrir o Dialog passando esses dados
        FormProductEdit dialog = new FormProductEdit(this, true,helpService,product);
        dialog.setLocationRelativeTo(this);
        dialog.preencherCampos(Code,ProductName, Category, Price);
        dialog.setVisible(true);

        //loadBatchTable();

    
    }//GEN-LAST:event_BtnEditBatchActionPerformed

    private void BtnDeleteBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteBatchActionPerformed
        int linhaSelecionada = TblBatch.getSelectedRow();

        // = Verificar se o usuário realmente selecionou algo
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um produto para deletar.");
            return;
        }

        int linhaModelo = TblBatch.convertRowIndexToModel(linhaSelecionada);

        //  Pegamos o código do produto (Barcode) que está na primeira coluna (índice 0) da tabela
        int barcode = Integer.parseInt(TblBatch.getModel().getValueAt(linhaModelo, 0).toString());

        //  Buscamos o produto usando o ProductService
        Product product = helpService.getProductService().findByBarcode(barcode); 
        // NOTA: Se o seu service buscar por ID em vez de Barcode, mude para:
        // Product product = helpService.getProductService().searchById(Long.valueOf(...));

        if (product == null) {
            JOptionPane.showMessageDialog(this, "Produto não encontrado no sistema.");
            return;
        }

        try {
            //  Executa o delete através do ProductService
            helpService.getProductService().delete(product);
            // helpService.getProductService().deleteByBarcode(barcode);

            JOptionPane.showMessageDialog(this, "Produto deletado com sucesso!");

            // 5. Atualiza a tabela de produtos para sumir com o registro deletado
            loadProductTable(); 

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao deletar produto: " + e.getMessage());
        }
        
    }//GEN-LAST:event_BtnDeleteBatchActionPerformed

    private void menuLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLoginActionPerformed
        Caixa caixa = new Caixa();
        TelaLogin telaLogin = new TelaLogin(this.helpService);
        if(caixa.verificarAbertura() != null){
            int resposta = JOptionPane.showConfirmDialog(
                this,
                "Possui um caixa em aberto, deseja trocar de Login?"
            );
            if(resposta == JOptionPane.YES_OPTION){
                dispose();
                telaLogin.setVisible(true);
            }
        }
        else{
            JOptionPane.showMessageDialog(
                this,
                "Encerrado login!!!"
            );
            dispose();
            telaLogin.setVisible(true);
        }
    }//GEN-LAST:event_menuLoginActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        Caixa caixa = new Caixa();
        if(caixa.verificarAbertura() != null){
            JOptionPane.showMessageDialog(
                this,
                "Não é possivel encerrar o sistema!! Caixa está aberto"
            );
            TelaCaixa telaCaixa = new TelaCaixa(this.helpService);
            dispose();
            telaCaixa.setVisible(true);
        }
        else{
            int resposta = JOptionPane.showConfirmDialog(
                this,
                "Deseja mesmo encerrar o sistema?"
            );
            if(resposta == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
    }//GEN-LAST:event_menuSairActionPerformed

    private void btnCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaixaActionPerformed
        TelaCaixa telaCaixa = new TelaCaixa(this.helpService);
        dispose();
        telaCaixa.setVisible(true);
    }//GEN-LAST:event_btnCaixaActionPerformed

    private void btnFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionariosActionPerformed
        TelaFuncionario telaFuncionario = new TelaFuncionario(this.helpService);
        dispose();
        telaFuncionario.setVisible(true);
    }//GEN-LAST:event_btnFuncionariosActionPerformed

    private void btnClientes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientes1ActionPerformed
        TelaCliente telaCliente = new TelaCliente(this.helpService);
        dispose();
        telaCliente.setVisible(true);
    }//GEN-LAST:event_btnClientes1ActionPerformed

    private void btnLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoteActionPerformed

        ArrivalBatchView arrivalBatchView = new ArrivalBatchView(helpService);
        dispose();
        arrivalBatchView.setVisible(true);
    }//GEN-LAST:event_btnLoteActionPerformed

    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed
        ProductView productView = new ProductView(this.helpService);
        dispose();
        productView.setVisible(true);
    }//GEN-LAST:event_btnProdutoActionPerformed

    private void btnVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendaActionPerformed
        SalesView salesView = new SalesView(this.helpService);
        dispose();
        salesView.setVisible(true);
    }//GEN-LAST:event_btnVendaActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        TelaInicio tela = new TelaInicio(this.helpService);
        dispose();
        tela.setVisible(true);
    }//GEN-LAST:event_btnInicioActionPerformed

    private void BtnAddBatchActionPerformed(java.awt.event.ActionEvent evt) {
    FormProductAdd dialog = new FormProductAdd(this, true, helpService, null);
    dialog.setLocationRelativeTo(this);
    dialog.setVisible(true);
    
    loadProductTable(); // Recarrega a tabela após fechar o dialog
}

    /*Funcões menu lateral*/

    public void logoUsuario(){
        ImageIcon icon = (ImageIcon) logo.getIcon();
        Image imagem = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        logo.setIcon(new ImageIcon(imagem));
    }

    public void logoNewBig(){
        ImageIcon icon = (ImageIcon) NBLogo.getIcon();
        Image imagem = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        NBLogo.setIcon(new ImageIcon(imagem));
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


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ProductView(new HelpService()).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JPanel Batch;
    private javax.swing.JButton BtnAddBatch;
    private javax.swing.JButton BtnDeleteBatch;
    private javax.swing.JButton BtnEditBatch;
    private javax.swing.JPanel Button;
    private javax.swing.JLabel LgAcesso;
    private javax.swing.JLabel LgNome;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JMenuBar MenuBarra;
    private javax.swing.JLabel NBLogo;
    private javax.swing.JScrollPane TableBatch;
    private javax.swing.JTable TblBatch;
    private javax.swing.JButton btnCaixa;
    private javax.swing.JButton btnClientes1;
    private javax.swing.JButton btnFuncionarios;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnLote;
    private javax.swing.JButton btnProduto;
    private javax.swing.JButton btnVenda;
    private javax.swing.JPanel filter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel logo;
    private javax.swing.JMenu menuBar;
    private javax.swing.JLabel menuLTitulo;
    private javax.swing.JPanel menuLateral3;
    private javax.swing.JMenuItem menuLogin;
    private javax.swing.JMenuItem menuSair;
    // End of variables declaration//GEN-END:variables
}
