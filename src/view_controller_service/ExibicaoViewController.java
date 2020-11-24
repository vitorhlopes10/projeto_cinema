// Vitor Hugo Morais Lopes da Silva - 201802380485

package view_controller_service;

import model.Exibicao;
import model.Filme;
import model.Funcionario;
import model.Funcao;
import model.Horario;
import model.Sala;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import repository.ExibicaoRepository;
import repository.FilmeRepository;
import repository.FuncaoRepository;
import repository.FuncionarioRepository;
import repository.HorarioRepository;
import repository.SalaRepository;

public class ExibicaoViewController extends javax.swing.JFrame {

    FilmeRepository filmeRepository;
    FuncionarioRepository funcionarioRepository;
    HorarioRepository horarioRepository;
    FuncaoRepository funcaoRepository;
    SalaRepository salaRepository;
    ExibicaoRepository exibicaoRepository;

    public ExibicaoViewController() throws SQLException {
        initComponents();
        filmeRepository = new FilmeRepository();
        funcionarioRepository = new FuncionarioRepository();
        horarioRepository = new HorarioRepository();
        funcaoRepository = new FuncaoRepository();
        salaRepository = new SalaRepository();
        exibicaoRepository = new ExibicaoRepository();
        PreencherDrops();
        PopularGrid();
    }

    private void PreencherDrops() throws SQLException {
        try {
            ArrayList<Filme> filmes = filmeRepository.List();
            for (Filme filmeAux : filmes) {
                drpFilmes.addItem(filmeAux.toString());
            }

            ArrayList<Funcionario> funcionarios = funcionarioRepository.List();
            for (Funcionario funcionarioAux : funcionarios) {
                drpFuncionarios.addItem(funcionarioAux.toString());
            }

            ArrayList<Horario> horarios = horarioRepository.List();
            for (Horario horariosAux : horarios) {
                drpHorarios.addItem(horariosAux.toString());
            }

            ArrayList<Funcao> funcoes = funcaoRepository.List();
            for (Funcao funcaoAux : funcoes) {
                drpFuncoes.addItem(funcaoAux.toString());
            }

            ArrayList<Sala> salas = salaRepository.List();
            for (Sala salaAux : salas) {
                drpSalas.addItem(salaAux.toString());
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

            Object colunas[] = new Object[6];

            Exibicao exibicoes = new Exibicao();
            ArrayList<Exibicao> listExibicoes = new ArrayList<Exibicao>();
            listExibicoes = exibicaoRepository.List();

            for (int i = 0; i < listExibicoes.size(); i++) {
                exibicoes = listExibicoes.get(i);
                colunas[0] = exibicoes.getId();
                colunas[1] = exibicoes.getFilme().toString();
                colunas[2] = exibicoes.getFuncionario().toString();
                colunas[3] = exibicoes.getHorario().toString();
                colunas[4] = exibicoes.getFuncao().toString();
                colunas[5] = exibicoes.getSala().toString();

                modelo.addRow(colunas);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void LimparCampos() throws SQLException {
        txtId.setText("");
        drpFilmes.setSelectedIndex(0);
        drpFuncionarios.setSelectedIndex(0);
        drpHorarios.setSelectedIndex(0);
        drpFuncoes.setSelectedIndex(0);
        drpSalas.setSelectedIndex(0);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        drpFilmes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        drpFuncionarios = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        drpHorarios = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        drpFuncoes = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        drpSalas = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnIncluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListagem = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manter Exibições", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel1.setText("Filmes: ");

        jLabel2.setText("Funcionários:");

        jLabel3.setText("Horários:");

        jLabel4.setText("Funções:");

        jLabel5.setText("Salas: ");

        jLabel6.setText("Id:");

        txtId.setEditable(false);

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

        btnExluir.setText("EXCLUIR");
        btnExluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExluirActionPerformed(evt);
            }
        });

        tblListagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Filme", "Funcionário", "Horários", "Função", "Sala"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
        jScrollPane2.setViewportView(tblListagem);
        if (tblListagem.getColumnModel().getColumnCount() > 0) {
            tblListagem.getColumnModel().getColumn(0).setResizable(false);
            tblListagem.getColumnModel().getColumn(1).setResizable(false);
            tblListagem.getColumnModel().getColumn(2).setResizable(false);
            tblListagem.getColumnModel().getColumn(3).setResizable(false);
            tblListagem.getColumnModel().getColumn(4).setResizable(false);
            tblListagem.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(drpHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(drpFuncoes, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(drpSalas, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnIncluir)
                                .addGap(71, 71, 71)
                                .addComponent(btnAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExluir))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(drpFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(drpFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(drpFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(drpFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(drpHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(drpFuncoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(drpSalas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIncluir)
                    .addComponent(btnAlterar)
                    .addComponent(btnExluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        try {
            Exibicao exibicao = new Exibicao();

            Filme filme = new Filme();
            filme.setId(RecuperarValueTexto(drpFilmes.getSelectedItem().toString()));
            filme = filmeRepository.ReadDb(filme.getId());
            exibicao.setFilme(filme);

            Funcionario funcionario = new Funcionario();
            funcionario.setId(RecuperarValueTexto(drpFuncionarios.getSelectedItem().toString()));
            funcionario = funcionarioRepository.ReadDb(funcionario.getId());
            exibicao.setFuncionario(funcionario);

            Horario horario = new Horario();
            horario.setId(RecuperarValueTexto(drpHorarios.getSelectedItem().toString()));
            horario = horarioRepository.ReadDb(horario.getId());
            exibicao.setHorario(horario);

            Funcao funcao = new Funcao();
            funcao.setId(RecuperarValueTexto(drpFuncoes.getSelectedItem().toString()));
            funcao = funcaoRepository.ReadDb(funcao.getId());
            exibicao.setFuncao(funcao);

            Sala sala = new Sala();
            sala.setId(RecuperarValueTexto(drpSalas.getSelectedItem().toString()));
            sala = salaRepository.ReadDb(sala.getId());
            exibicao.setSala(sala);

            if (exibicaoRepository.Insert(exibicao)) {
                LimparCampos();
                JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            if (txtId.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione o Registro!");
            } else {
                Exibicao exibicao = new Exibicao();
                exibicao.setId(Integer.parseInt(txtId.getText()));

                Filme filme = new Filme();
                filme.setId(RecuperarValueTexto(drpFilmes.getSelectedItem().toString()));
                filme = filmeRepository.ReadDb(filme.getId());
                exibicao.setFilme(filme);

                Funcionario funcionario = new Funcionario();
                funcionario.setId(RecuperarValueTexto(drpFuncionarios.getSelectedItem().toString()));
                funcionario = funcionarioRepository.ReadDb(funcionario.getId());
                exibicao.setFuncionario(funcionario);

                Horario horario = new Horario();
                horario.setId(RecuperarValueTexto(drpHorarios.getSelectedItem().toString()));
                horario = horarioRepository.ReadDb(horario.getId());
                exibicao.setHorario(horario);

                Funcao funcao = new Funcao();
                funcao.setId(RecuperarValueTexto(drpFuncoes.getSelectedItem().toString()));
                funcao = funcaoRepository.ReadDb(funcao.getId());
                exibicao.setFuncao(funcao);

                Sala sala = new Sala();
                sala.setId(RecuperarValueTexto(drpSalas.getSelectedItem().toString()));
                sala = salaRepository.ReadDb(sala.getId());
                exibicao.setSala(sala);

                if (exibicaoRepository.Update(exibicao)) {
                    LimparCampos();
                    JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExluirActionPerformed
        try {
            if (txtId.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione o Registro!");
            } else {
                Exibicao exibicao = new Exibicao();
                exibicao.setId(Integer.parseInt(tblListagem.getValueAt(tblListagem.getSelectedRow(), 0).toString()));

                if (exibicaoRepository.Delete(exibicao.getId())) {
                    LimparCampos();
                    JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnExluirActionPerformed

    private void tblListagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListagemMouseClicked
        try {
            txtId.setText(tblListagem.getValueAt(tblListagem.getSelectedRow(), 0).toString());

            Filme filme = new Filme();
            filme.setId(RecuperarValueTexto(tblListagem.getValueAt(tblListagem.getSelectedRow(), 1).toString()));
            filme = filmeRepository.ReadDb(filme.getId());
            drpFilmes.setSelectedItem(filme.toString());

            Funcionario funcionario = new Funcionario();
            funcionario.setId(RecuperarValueTexto(tblListagem.getValueAt(tblListagem.getSelectedRow(), 2).toString()));
            funcionario = funcionarioRepository.ReadDb(funcionario.getId());
            drpFuncionarios.setSelectedItem(funcionario.toString());

            Horario horario = new Horario();
            horario.setId(RecuperarValueTexto(tblListagem.getValueAt(tblListagem.getSelectedRow(), 3).toString()));
            horario = horarioRepository.ReadDb(horario.getId());
            drpHorarios.setSelectedItem(horario.toString());

            Funcao funcao = new Funcao();
            funcao.setId(RecuperarValueTexto(tblListagem.getValueAt(tblListagem.getSelectedRow(), 4).toString()));
            funcao = funcaoRepository.ReadDb(funcao.getId());
            drpFuncoes.setSelectedItem(funcao.toString());

            Sala sala = new Sala();
            sala.setId(RecuperarValueTexto(tblListagem.getValueAt(tblListagem.getSelectedRow(), 5).toString()));
            sala = salaRepository.ReadDb(sala.getId());
            drpSalas.setSelectedItem(sala.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tblListagemMouseClicked
    
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExibicaoViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExibicaoViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExibicaoViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExibicaoViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ExibicaoViewController().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ExibicaoViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JComboBox<String> drpFilmes;
    private javax.swing.JComboBox<String> drpFuncionarios;
    private javax.swing.JComboBox<String> drpFuncoes;
    private javax.swing.JComboBox<String> drpHorarios;
    private javax.swing.JComboBox<String> drpSalas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblListagem;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
