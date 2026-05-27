/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.newBig.system.view;


import com.newBig.system.model.entity.Batch;
import com.newBig.system.model.service.HelpService;
import com.newBig.system.model.service.Login;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 *
 * @author bocchi
 */
public class ArrivalBatchView extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ArrivalBatchView.class.getName());
    Login login = new Login();
    private HelpService helpService;

    public ArrivalBatchView(HelpService helpService) {
        initComponents();
        this.helpService = helpService;
        logoUsuario();
        logoNewBig();
        LgNome.setText(login.nomeLog());
        LgAcesso.setText(login.acessoLog());

        // Inicia a configuração do filtro
        setupTableFilter();

        // Carrega os dados na tabela ao abrir a tela
        loadBatchTable();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        menuLateral = new javax.swing.JPanel();
        NBLogo = new javax.swing.JLabel();
        menuLTitulo = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();
        btnFuncionarios = new javax.swing.JButton();
        btnCaixa = new javax.swing.JButton();
        btnClientes1 = new javax.swing.JButton();
        btnVenda = new javax.swing.JButton();
        btnProduto = new javax.swing.JButton();
        btnLote = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        LgNome = new javax.swing.JLabel();
        LgAcesso = new javax.swing.JLabel();
        MainPanel = new javax.swing.JPanel();
        Batch = new javax.swing.JPanel();
        filter = new javax.swing.JPanel();
        FilterBatch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        TableBatch = new javax.swing.JScrollPane();
        TblBatch = new javax.swing.JTable();
        Button = new javax.swing.JPanel();
        BtnAddBatch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Batch");

        Background.setBackground(new java.awt.Color(242, 242, 200));

        menuLateral.setBackground(new java.awt.Color(251, 227, 228));

        NBLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        NBLogo.setMaximumSize(new java.awt.Dimension(80, 80));
        NBLogo.setPreferredSize(new java.awt.Dimension(80, 80));

        menuLTitulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        menuLTitulo.setText("NewBig-System");

        btnInicio.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        btnInicio.setText("Inicio");
        btnInicio.addActionListener(this::btnInicioActionPerformed);

        btnFuncionarios.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        btnFuncionarios.setText("Funcionarios");
        btnFuncionarios.addActionListener(this::btnFuncionariosActionPerformed);

        btnCaixa.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        btnCaixa.setText("Caixa");
        btnCaixa.addActionListener(this::btnCaixaActionPerformed);

        btnClientes1.setBackground(new java.awt.Color(253, 238, 239));
        btnClientes1.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        btnClientes1.setText("Clientes");
        btnClientes1.addActionListener(this::btnClientes1ActionPerformed);

        btnVenda.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        btnVenda.setText("Venda");
        btnVenda.addActionListener(this::btnVendaActionPerformed);

        btnProduto.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        btnProduto.setText("Produtos");
        btnProduto.addActionListener(this::btnProdutoActionPerformed);

        btnLote.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        btnLote.setText("Lote");
        btnLote.addActionListener(this::btnLoteActionPerformed);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/avatar.png"))); // NOI18N
        logo.setMaximumSize(new java.awt.Dimension(40, 40));
        logo.setPreferredSize(new java.awt.Dimension(40, 40));

        LgNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LgNome.setText("Mourvan");

        LgAcesso.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        LgAcesso.setText("Administrador");

        javax.swing.GroupLayout menuLateralLayout = new javax.swing.GroupLayout(menuLateral);
        menuLateral.setLayout(menuLateralLayout);
        menuLateralLayout.setHorizontalGroup(
            menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLateralLayout.createSequentialGroup()
                .addGap(0, 53, Short.MAX_VALUE)
                .addComponent(menuLTitulo)
                .addGap(47, 47, 47))
            .addGroup(menuLateralLayout.createSequentialGroup()
                .addGroup(menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLateralLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(NBLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLateralLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(menuLateralLayout.createSequentialGroup()
                                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LgAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LgNome, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnFuncionarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCaixa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnClientes1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLote, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuLateralLayout.setVerticalGroup(
            menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLateralLayout.createSequentialGroup()
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
                .addGroup(menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(menuLateralLayout.createSequentialGroup()
                        .addComponent(LgNome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LgAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        MainPanel.setBackground(new java.awt.Color(242, 200, 242));
        MainPanel.setLayout(new java.awt.CardLayout());

        Batch.setBackground(new java.awt.Color(255, 249, 249));

        filter.setBackground(new java.awt.Color(255, 249, 249));

        FilterBatch.setText("Search something");
        FilterBatch.addActionListener(this::FilterBatchActionPerformed);

        jLabel1.setFont(new java.awt.Font("FreeSerif", 0, 24)); // NOI18N
        jLabel1.setText("Lotes");

        javax.swing.GroupLayout filterLayout = new javax.swing.GroupLayout(filter);
        filter.setLayout(filterLayout);
        filterLayout.setHorizontalGroup(
            filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filterLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 314, Short.MAX_VALUE)
                .addComponent(FilterBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        filterLayout.setVerticalGroup(
            filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filterLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FilterBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(15, 15, 15))
        );

        TblBatch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Serie", "Produto", "Quantidade", "Validade"
            }
        ));
        TableBatch.setViewportView(TblBatch);

        Button.setBackground(new java.awt.Color(255, 249, 249));

        BtnAddBatch.setText("Add");
        BtnAddBatch.addActionListener(this::BtnAddBatchActionPerformed);

        javax.swing.GroupLayout ButtonLayout = new javax.swing.GroupLayout(Button);
        Button.setLayout(ButtonLayout);
        ButtonLayout.setHorizontalGroup(
            ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonLayout.createSequentialGroup()
                .addComponent(BtnAddBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ButtonLayout.setVerticalGroup(
            ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(BtnAddBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout BatchLayout = new javax.swing.GroupLayout(Batch);
        Batch.setLayout(BatchLayout);
        BatchLayout.setHorizontalGroup(
            BatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BatchLayout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
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
                .addComponent(TableBatch, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
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
                .addContainerGap()
                .addComponent(menuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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



    private void FilterBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterBatchActionPerformed

    }//GEN-LAST:event_FilterBatchActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        TelaInicio tela = new TelaInicio(helpService);
        dispose();
        tela.setVisible(true);
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionariosActionPerformed
        TelaFuncionario telaFuncionario = new TelaFuncionario(this.helpService);
        dispose();
        telaFuncionario.setVisible(true);
    }//GEN-LAST:event_btnFuncionariosActionPerformed

    private void btnCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaixaActionPerformed
        TelaCaixa telaCaixa = new TelaCaixa(this.helpService);
        dispose();
        telaCaixa.setVisible(true);
    }//GEN-LAST:event_btnCaixaActionPerformed

    private void btnClientes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientes1ActionPerformed
        TelaCliente telaCliente = new TelaCliente(this.helpService);
        dispose();
        telaCliente.setVisible(true);
    }//GEN-LAST:event_btnClientes1ActionPerformed

    private void btnVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendaActionPerformed
        SalesView salesView = new SalesView(this.helpService);
        dispose();
        salesView.setVisible(true);
    }//GEN-LAST:event_btnVendaActionPerformed

    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed
        ProductView productView = new ProductView(this.helpService);
        dispose();
        productView.setVisible(true);
    }//GEN-LAST:event_btnProdutoActionPerformed

    private void btnLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoteActionPerformed

        ArrivalBatchView arrivalBatchView = new ArrivalBatchView(helpService);
        dispose();
        arrivalBatchView.setVisible(true);

    }//GEN-LAST:event_btnLoteActionPerformed

    private void BtnEditBatchActionPerformed(java.awt.event.ActionEvent evt) {

        int linhaSelecionada = TblBatch.getSelectedRow();

        //  = Verificar se o usuário realmente selecionou algo (-1 significa que nada foi selecionado)
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione uma linha para editar.");
            return;
        }

        //  = Pegar os dados da tabela (substitua os índices das colunas conforme o seu projeto)
        int linhaModelo = TblBatch.convertRowIndexToModel(linhaSelecionada);
        String id = TblBatch.getModel().getValueAt(linhaModelo, 0).toString();
        String serie = TblBatch.getModel().getValueAt(linhaModelo, 1).toString();
        String product = TblBatch.getModel().getValueAt(linhaModelo, 2).toString();
        String quantity = TblBatch.getModel().getValueAt(linhaModelo, 3).toString();
        String validity = TblBatch.getModel().getValueAt(linhaModelo, 4).toString();

        //  = Abrir o Dialog passando esses dados
        FormBatchEditDialog dialog = new FormBatchEditDialog(this, true);
        dialog.setLocationRelativeTo(this);
        dialog.preencherCampos(serie,product, quantity, validity);
        dialog.setVisible(true);

        loadBatchTable();

    }

    private void BtnDeleteBatchActionPerformed(java.awt.event.ActionEvent evt) {

        int linhaSelecionada = TblBatch.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione uma linha para deletar.");
            return;
        }

        try {
            int linhaModelo = TblBatch.convertRowIndexToModel(linhaSelecionada);
            Long batchId = Long.valueOf(TblBatch.getModel().getValueAt(linhaModelo, 0).toString());

            Batch batch = helpService.getBatchService().searchById(batchId);

            if (batch.getAmount() != 0) {
                JOptionPane.showMessageDialog(this, "Esse lote não está zerado! Logo, não pode ser deletado.");
            } else {
                helpService.getBatchService().deleteZero(batch);
                JOptionPane.showMessageDialog(this, "Lote deletado com sucesso!");
                loadBatchTable();
            }

        } catch (Exception e) {
            // Se o JPA estourar um erro (como chave estrangeira), ele cai aqui!
            e.printStackTrace(); // Mostra o erro vermelho no console do NetBeans/IDE
            JOptionPane.showMessageDialog(this,
                    "Não foi possível deletar o lote.\nMotivo: Pode haver movimentações de estoque vinculadas a ele.",
                    "Erro de Exclusão",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

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

        FormBatchDialog dialog = new FormBatchDialog(this, true, helpService);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

        loadBatchTable();
    }

    // Método para configurar o filtro na tabela
    private void setupTableFilter() {
        DefaultTableModel model = (DefaultTableModel) TblBatch.getModel();
        javax.swing.table.TableRowSorter<DefaultTableModel> sorter = new javax.swing.table.TableRowSorter<>(model);
        TblBatch.setRowSorter(sorter);

        // Adiciona um ouvinte para filtrar enquanto o usuário digita
        FilterBatch.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) { applyFilter(sorter); }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) { applyFilter(sorter); }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) { applyFilter(sorter); }
        });
    }

    // Método que aplica a regra do texto digitado
    private void applyFilter(javax.swing.table.TableRowSorter<DefaultTableModel> sorter) {
        String text = FilterBatch.getText();

        // Se o texto for igual ao placeholder padrão ou estiver vazio, remove o filtro
        if (text.trim().isEmpty() || text.equals("Search something")) {
            sorter.setRowFilter(null);
        } else {
            // O "(?i)" torna a busca case-insensitive (ignora maiúsculas e minúsculas)
            sorter.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + text));
        }
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
/*
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
*/

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ArrivalBatchView(new HelpService()).setVisible(true));


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JPanel Batch;
    private javax.swing.JButton BtnAddBatch;
    private javax.swing.JPanel Button;
    private javax.swing.JTextField FilterBatch;
    private javax.swing.JLabel LgAcesso;
    private javax.swing.JLabel LgNome;
    private javax.swing.JPanel MainPanel;
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
    private javax.swing.JLabel logo;
    private javax.swing.JLabel menuLTitulo;
    private javax.swing.JPanel menuLateral;
    // End of variables declaration//GEN-END:variables
}
