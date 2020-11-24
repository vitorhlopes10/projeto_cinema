// Vitor Hugo Morais Lopes da Silva - 201802380485

package view_controller_service;

import model.Classificacao;
import model.Filme;
import model.Genero;
import model.Premiacao;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import repository.ClassificacaoRepository;
import repository.FilmeRepository;
import repository.GeneroRepository;
import repository.PremiacaoRepository;

public class FilmeViewController extends javax.swing.JFrame {

    GeneroRepository generoRepository;
    ClassificacaoRepository classificacaoRepository;
    PremiacaoRepository premiacaoRepository;
    FilmeRepository filmeRepository;

    public FilmeViewController() throws SQLException {
        initComponents();
        generoRepository = new GeneroRepository();
        classificacaoRepository = new ClassificacaoRepository();
        premiacaoRepository = new PremiacaoRepository();
        filmeRepository = new FilmeRepository();
        PreencherDrops();
        PopularGrid();
    }

    private void PreencherDrops() throws SQLException {
        try {
            ArrayList<Genero> generos = generoRepository.List();
            for (Genero genAux : generos) {
                drpGeneros.addItem(genAux.toString());
            }

            ArrayList<Classificacao> classificacoes = classificacaoRepository.List();
            for (Classificacao classifAux : classificacoes) {
                drpClassificacao.addItem(classifAux.toString());
            }

            ArrayList<Premiacao> premiacoes = premiacaoRepository.List();
            for (Premiacao premAux : premiacoes) {
                drpPremiacoes.addItem(premAux.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void PopularGrid() throws SQLException {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tblListagem.getModel();
            modelo.setNumRows(0);

            tblListagem.setRowSorter(new TableRowSorter(modelo));

            Object colunas[] = new Object[7];

            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

            Filme filmes = new Filme();
            ArrayList<Filme> listFilmes = new ArrayList<Filme>();
            listFilmes = filmeRepository.List();

            for (int i = 0; i < listFilmes.size(); i++) {
                filmes = listFilmes.get(i);
                colunas[0] = filmes.getId();
                colunas[1] = filmes.getNome();
                colunas[2] = df.format(filmes.getData_lancamento());
                colunas[3] = filmes.getDuracao();
                colunas[4] = filmes.getGenero().toString();
                colunas[5] = filmes.getClassificacao().toString();
                colunas[6] = filmes.getPremiacoes() != null ? filmes.getPremiacoes().toString() : "Sem Premiação";
                modelo.addRow(colunas);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtLancamento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDuracao = new javax.swing.JTextField();
        drpGeneros = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        drpPremiacoes = new javax.swing.JComboBox<>();
        btnIncluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListagem = new javax.swing.JTable();
        drpClassificacao = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MANTER FILMES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 153, 204))); // NOI18N

        labelNome.setText("Nome:");

        jLabel1.setText("Lançamento:");

        jLabel2.setText("Duração (h):");

        jLabel3.setText("Generos:");

        jLabel4.setText("Classificação: ");

        jLabel5.setText("Premiação:");

        btnIncluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnIncluir.setText("INCLUIR");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAlterar.setText("ALTERAR");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnDeletar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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
                "Id", "Nome", "Lançamento", "Duração", "Gênero", "Classificação", "Premiação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            tblListagem.getColumnModel().getColumn(2).setResizable(false);
            tblListagem.getColumnModel().getColumn(3).setResizable(false);
            tblListagem.getColumnModel().getColumn(4).setResizable(false);
            tblListagem.getColumnModel().getColumn(5).setResizable(false);
            tblListagem.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel6.setText("Id:");

        txtId.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(labelNome)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDuracao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnIncluir)
                                    .addComponent(drpClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAlterar)
                                .addGap(67, 67, 67)
                                .addComponent(btnDeletar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLancamento))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(15, 15, 15)
                                .addComponent(drpPremiacoes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(29, 29, 29)
                                .addComponent(drpGeneros, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(labelNome))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(19, 19, 19)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(drpClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(drpGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(drpPremiacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIncluir)
                    .addComponent(btnAlterar)
                    .addComponent(btnDeletar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        try {
            if (CadastroIsValid()) {
                Filme filme = new Filme();

                String dataString = txtLancamento.getText();
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = new java.sql.Date(fmt.parse(dataString).getTime());
                filme.setData_lancamento(data);
                filme.setNome(txtNome.getText());
                filme.setDuracao(Integer.parseInt(txtDuracao.getText()));

                Genero genero = new Genero();
                genero.setId(RecuperarValueTexto(drpGeneros.getSelectedItem().toString()));
                genero = generoRepository.ReadDb(genero.getId());
                filme.setGenero(genero);

                Classificacao classicacao = new Classificacao();
                classicacao.setId(RecuperarValueTexto(drpClassificacao.getSelectedItem().toString()));
                classicacao = classificacaoRepository.ReadDb(classicacao.getId());
                filme.setClassificacao(classicacao);

                Premiacao premiacao = new Premiacao();
                premiacao.setId(RecuperarValueTexto(drpPremiacoes.getSelectedItem().toString()));
                premiacao = premiacaoRepository.ReadDb(premiacao.getId());
                filme.setPremiacoes(premiacao);

                if (filmeRepository.Insert(filme)) {
                    LimparCampos();
                    JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Informe todos os Campos!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void tblListagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListagemMouseClicked
        try {
            txtId.setText(tblListagem.getValueAt(tblListagem.getSelectedRow(), 0).toString());
            txtNome.setText(tblListagem.getValueAt(tblListagem.getSelectedRow(), 1).toString());
            txtLancamento.setText(tblListagem.getValueAt(tblListagem.getSelectedRow(), 2).toString());
            txtDuracao.setText(tblListagem.getValueAt(tblListagem.getSelectedRow(), 3).toString());

            Genero genero = new Genero();
            genero.setId(RecuperarValueTexto(tblListagem.getValueAt(tblListagem.getSelectedRow(), 4).toString()));
            genero = generoRepository.ReadDb(genero.getId());
            drpGeneros.setSelectedItem(genero.toString());

            Classificacao classificacao = new Classificacao();
            classificacao.setId(RecuperarValueTexto(tblListagem.getValueAt(tblListagem.getSelectedRow(), 5).toString()));
            classificacao = classificacaoRepository.ReadDb(classificacao.getId());
            drpClassificacao.setSelectedItem(classificacao.toString());

            Premiacao premiacao = new Premiacao();
            premiacao.setId(RecuperarValueTexto(tblListagem.getValueAt(tblListagem.getSelectedRow(), 6).toString()));
            premiacao = premiacaoRepository.ReadDb(premiacao.getId());
            drpPremiacoes.setSelectedItem(premiacao.toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tblListagemMouseClicked

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            if (CadastroIsValid()) {
                Filme filme = new Filme();

                String dataString = txtLancamento.getText();
                DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = new java.sql.Date(fmt.parse(dataString).getTime());
                filme.setData_lancamento(data);
                filme.setNome(txtNome.getText());
                filme.setDuracao(Integer.parseInt(txtDuracao.getText()));

                Genero genero = new Genero();
                genero.setId(RecuperarValueTexto(drpGeneros.getSelectedItem().toString()));
                genero = generoRepository.ReadDb(genero.getId());
                filme.setGenero(genero);

                Classificacao classicacao = new Classificacao();
                classicacao.setId(RecuperarValueTexto(drpClassificacao.getSelectedItem().toString()));
                classicacao = classificacaoRepository.ReadDb(classicacao.getId());
                filme.setClassificacao(classicacao);

                Premiacao premiacao = new Premiacao();
                premiacao.setId(RecuperarValueTexto(drpPremiacoes.getSelectedItem().toString()));
                premiacao = premiacaoRepository.ReadDb(premiacao.getId());
                filme.setPremiacoes(premiacao);

                filme.setId(Integer.parseInt(txtId.getText()));
                if (filmeRepository.Update(filme)) {
                    LimparCampos();
                    JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Informe todos os Campos!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        try {
            if (txtId.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione o Registro!");
            } else {
                Filme filme = new Filme();
                filme.setId(Integer.parseInt(tblListagem.getValueAt(tblListagem.getSelectedRow(), 0).toString()));

                if (filmeRepository.Delete(filme.getId())) {
                    LimparCampos();
                    JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
                }
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
            java.util.logging.Logger.getLogger(FilmeViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FilmeViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FilmeViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FilmeViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FilmeViewController().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FilmeViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void LimparCampos() throws SQLException {
        txtId.setText("");
        txtNome.setText("");
        txtLancamento.setText("");
        txtDuracao.setText("");
        drpGeneros.setSelectedIndex(0);
        drpClassificacao.setSelectedIndex(0);
        drpPremiacoes.setSelectedIndex(0);
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

    public boolean CadastroIsValid() {

        if (txtNome.getText().equals("")) {
            return false;
        }
        if (txtDuracao.getText().equals("")) {
            return false;
        }
        if (txtLancamento.getText().equals("")) {
            return false;
        }

        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JComboBox<String> drpClassificacao;
    private javax.swing.JComboBox<String> drpGeneros;
    private javax.swing.JComboBox<String> drpPremiacoes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelNome;
    private javax.swing.JTable tblListagem;
    private javax.swing.JTextField txtDuracao;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLancamento;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
