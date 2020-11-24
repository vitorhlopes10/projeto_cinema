package view_controller_service;

import model.Indicacao;
import model.Filme;
import model.IndicacaoFilme;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import repository.FilmeRepository;
import repository.IndicacaoFilmeRepository;
import repository.IndicacaoRepository;

public class IndicacaoFilmeViewController extends javax.swing.JFrame {

    FilmeRepository filmeRepository; 
    IndicacaoRepository indicacaoRepository;
    IndicacaoFilmeRepository indicacaoFilmeRepository; 
    
    public IndicacaoFilmeViewController() throws SQLException {
        initComponents();
        filmeRepository = new FilmeRepository();
        indicacaoRepository = new IndicacaoRepository();
        indicacaoFilmeRepository = new IndicacaoFilmeRepository();
        PopularGrid();
        PreencherDrops();
    }

    private void PreencherDrops() throws SQLException {
        try {
            ArrayList<Indicacao> indicacoes = indicacaoRepository.List();
            for (Indicacao IndicacoesAux : indicacoes) {
                drpIndicacao.addItem(IndicacoesAux.toString());
            }

            ArrayList<Filme> filmes = filmeRepository.List();
            for (Filme filmeAux : filmes) {
                drpFilmes.addItem(filmeAux.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnIncluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListagem = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        drpFilmes = new javax.swing.JComboBox<>();
        drpIndicacao = new javax.swing.JComboBox<>();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manter Indicações Filmes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 102, 255))); // NOI18N

        jLabel1.setText("Indicação:");

        btnIncluir.setText("INCLUIR");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnAlterar.setText("ALTERAR");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnDeletar.setText("EXCLUIR");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        tblListagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Indicação", "Filme"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListagemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListagem);
        if (tblListagem.getColumnModel().getColumnCount() > 0) {
            tblListagem.getColumnModel().getColumn(0).setResizable(false);
            tblListagem.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel2.setText("Filme");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(41, 41, 41)
                                .addComponent(drpFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnIncluir)
                                .addGap(48, 48, 48)
                                .addComponent(btnAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDeletar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(drpIndicacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(125, 125, 125)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(drpIndicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(drpFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIncluir)
                    .addComponent(btnAlterar)
                    .addComponent(btnDeletar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblListagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListagemMouseClicked
        try {
            Indicacao indicacao = new Indicacao();
            indicacao.setId(RecuperarValueTexto(tblListagem.getValueAt(tblListagem.getSelectedRow(), 0).toString()));
            indicacao = indicacaoRepository.ReadDb(indicacao.getId());
            drpIndicacao.setSelectedItem(indicacao.toString());

            Filme filme = new Filme();
            filme.setId(RecuperarValueTexto(tblListagem.getValueAt(tblListagem.getSelectedRow(), 1).toString()));
            filme = filmeRepository.ReadDb(filme.getId());
            drpFilmes.setSelectedItem(filme.toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tblListagemMouseClicked

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        try {
            IndicacaoFilme indicacao_filme = new IndicacaoFilme();

            Indicacao indicacao = new Indicacao();
            indicacao.setId(RecuperarValueTexto(drpFilmes.getSelectedItem().toString()));
            indicacao = indicacaoRepository.ReadDb(indicacao.getId());
            indicacao_filme.setIndicacao(indicacao);

            Filme filme = new Filme();
            filme.setId(RecuperarValueTexto(drpFilmes.getSelectedItem().toString()));
            filme = filmeRepository.ReadDb(filme.getId());
            indicacao_filme.setFilme(filme);

            if (indicacaoFilmeRepository.Insert(indicacao_filme)) {
                LimparCampos();
                JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            IndicacaoFilme indicacao_filme = new IndicacaoFilme();

            Indicacao indicacao = new Indicacao();
            indicacao.setId(RecuperarValueTexto(drpFilmes.getSelectedItem().toString()));
            indicacao = indicacaoRepository.ReadDb(indicacao.getId());
            indicacao_filme.setIndicacao(indicacao);

            Filme filme = new Filme();
            filme.setId(RecuperarValueTexto(drpFilmes.getSelectedItem().toString()));
            filme = filmeRepository.ReadDb(filme.getId());
            indicacao_filme.setFilme(filme);

            if (indicacaoFilmeRepository.Update(filme.getId(), indicacao.getId())) {
                LimparCampos();
                JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        try {
            IndicacaoFilme indicacao_filme = new IndicacaoFilme();

            Indicacao indicacao = new Indicacao();
            indicacao.setId(RecuperarValueTexto(drpFilmes.getSelectedItem().toString()));
            indicacao = indicacaoRepository.ReadDb(indicacao.getId());
            indicacao_filme.setIndicacao(indicacao);

            Filme filme = new Filme();
            filme.setId(RecuperarValueTexto(drpFilmes.getSelectedItem().toString()));
            filme = filmeRepository.ReadDb(filme.getId());
            indicacao_filme.setFilme(filme);

            if (indicacaoFilmeRepository.Delete(filme.getId(), indicacao.getId())) {
                LimparCampos();
                JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IndicacaoFilmeViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IndicacaoFilmeViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IndicacaoFilmeViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IndicacaoFilmeViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new IndicacaoFilmeViewController().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(IndicacaoFilmeViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void Salvar() {

    }

    public void PopularGrid() throws SQLException {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tblListagem.getModel();
            modelo.setNumRows(0);

            tblListagem.setRowSorter(new TableRowSorter(modelo));

            Object colunas[] = new Object[2];

            IndicacaoFilme indicacao_filme = new IndicacaoFilme();
            ArrayList<IndicacaoFilme> listIndicacoesFilmes = new ArrayList<IndicacaoFilme>();
            listIndicacoesFilmes = indicacaoFilmeRepository.List();

            for (int i = 0; i < listIndicacoesFilmes.size(); i++) {
                indicacao_filme = listIndicacoesFilmes.get(i);
                colunas[0] = indicacao_filme.getIndicacao().toString();
                colunas[1] = indicacao_filme.getFilme().toString();
                modelo.addRow(colunas);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void LimparCampos() throws SQLException {
        drpFilmes.setSelectedIndex(0);
        drpIndicacao.setSelectedIndex(0);
        PopularGrid();
    }

    public int RecuperarValueTexto(String texto) {
        try {
            int posicao = texto.indexOf(")");
            return Integer.parseInt(texto.substring(0, posicao));
        } catch (Exception e) {
            return 0;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JComboBox<String> drpFilmes;
    private javax.swing.JComboBox<String> drpIndicacao;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListagem;
    // End of variables declaration//GEN-END:variables
}
