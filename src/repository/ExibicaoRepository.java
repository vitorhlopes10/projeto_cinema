package repository;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Exibicao;
import model.Filme;
import model.Funcao;
import model.Funcionario;
import model.Horario;
import model.Sala;

public class ExibicaoRepository {

    Connection conexao;
    FilmeRepository filmeRepository;
    FuncionarioRepository funcionarioRepository;
    HorarioRepository horarioRepository;
    FuncaoRepository funcaoRepository;
    SalaRepository salaRepository;

    public ExibicaoRepository() throws SQLException {
        conexao = Conexao.getConexao();
        filmeRepository = new FilmeRepository();
        funcionarioRepository = new FuncionarioRepository();
        horarioRepository = new HorarioRepository();
        funcaoRepository = new FuncaoRepository();
        salaRepository = new SalaRepository();
    }

    public boolean Insert(Exibicao exibicao) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("INSERT INTO exibicoes (id_filmes, id_funcionarios, id_horarios, id_funcoes, id_salas) values (?, ?, ?, ?, ?)");
                st.setInt(1, exibicao.getFilme().getId());
                st.setInt(2, exibicao.getFuncionario().getId());
                st.setInt(3, exibicao.getHorario().getId());
                st.setInt(4, exibicao.getFuncao().getId());
                st.setInt(5, exibicao.getSala().getId());

                st.execute();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
            return false;
        } finally {
            conexao.close();
        }
        return true;
    }

    public boolean Update(Exibicao exibicao) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("UPDATE exibicoes SET id_filmes = ?, id_funcionarios = ?, "
                        + "id_horarios = ?, id_funcoes = ?, id_salas = ? WHERE idexibicoes = ?");

                st.setInt(1, exibicao.getFilme().getId());
                st.setInt(2, exibicao.getFuncionario().getId());
                st.setInt(3, exibicao.getHorario().getId());
                st.setInt(4, exibicao.getFuncao().getId());
                st.setInt(5, exibicao.getSala().getId());
                st.setInt(6, exibicao.getId());

                st.execute();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
            return false;
        } finally {
            conexao.close();
        }
        return true;
    }

    public boolean Delete(int id) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("DELETE FROM exibicoes WHERE idexibicoes = ?");
                st.setInt(1, id);

                st.execute();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
            return false;
        } finally {
            conexao.close();
        }
        return true;
    }

    public ArrayList<Exibicao> List() throws SQLException {

        ArrayList<Exibicao> listExibicoes = new ArrayList<>();

        try {
            if (conexao != null) {
                PreparedStatement st = null;
                ResultSet rs = null;

                st = conexao.prepareStatement("SELECT * FROM cinema.exibicoes ce \n"
                        + "JOIN cinema.filmes cf on cf.idfilmes = ce.id_filmes \n"
                        + "JOIN cinema.funcionarios cfu on cfu.idfuncionarios = ce.id_funcionarios \n"
                        + "JOIN cinema.horarios ch on ch.idhorarios = ce.id_horarios \n"
                        + "JOIN cinema.funcoes cfc on cfc.idfuncoes = ce.id_funcoes \n"
                        + "JOIN cinema.salas cs on cs.idsalas = ce.id_salas");

                rs = st.executeQuery();

                while (rs.next()) {
                    Exibicao temp = new Exibicao();

                    temp.setId(rs.getInt("ce.idExibicoes"));
                    temp.setFilme(new Filme(rs.getInt("cf.idfilmes"), rs.getString("cf.nome")));
                    temp.setFuncionario(new Funcionario(rs.getInt("cfu.idfuncionarios"), rs.getString("cfu.nome")));
                    temp.setHorario(new Horario(rs.getInt("ch.idhorarios"), rs.getString("ch.horario")));
                    temp.setFuncao(new Funcao(rs.getInt("cfc.idfuncoes"), rs.getString("cfc.nome")));
                    temp.setSala(new Sala(rs.getInt("cs.idsalas"), rs.getString("cs.nome")));

                    listExibicoes.add(temp);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        } finally {
            conexao.close();
        }

        return listExibicoes;
    }

}
