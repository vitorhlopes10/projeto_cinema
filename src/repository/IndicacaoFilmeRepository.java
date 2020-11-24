// Vitor Hugo Morais Lopes da Silva - 201802380485

package repository;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Filme;
import model.Indicacao;
import model.IndicacaoFilme;

public class IndicacaoFilmeRepository {

    Connection conexao;
    FilmeRepository filmeRepository;
    IndicacaoRepository indicacaoRepository;
    SalaRepository salaRepository;
    CinemaRepository cinemaRepository;

    public IndicacaoFilmeRepository() throws SQLException {
        conexao = Conexao.getConexao();
        filmeRepository = new FilmeRepository();
        indicacaoRepository = new IndicacaoRepository();
        salaRepository = new SalaRepository();
        cinemaRepository = new CinemaRepository();
    }

    public boolean Insert(IndicacaoFilme indicacaoFilme) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("INSERT INTO indicacoes_filmes (id_filmes, id_indicacoes) values (?, ?)");
                st.setInt(1, indicacaoFilme.getFilme().getId());
                st.setInt(2, indicacaoFilme.getIndicacao().getId());

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

    public boolean Update(int idFilme, int idIndicacao) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("UPDATE indicacoes_filmes SET id_filmes = ?, id_indicacoes = ? WHERE id_filmes = ? AND id_indicacoes = ?");
                st.setInt(1, idFilme);
                st.setInt(2, idIndicacao);
                st.setInt(3, idFilme);
                st.setInt(4, idIndicacao);

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

    public boolean Delete(int idFilme, int idIndicacao) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("DELETE FROM indicacoes_filmes WHERE id_filmes = ? AND id_indicacoes = ?");
                st.setInt(1, idFilme);
                st.setInt(2, idIndicacao);

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

    public ArrayList<IndicacaoFilme> List() throws SQLException {

        ArrayList<IndicacaoFilme> listIndicacoesFilmes = new ArrayList<>();

        try {
            if (conexao != null) {
                PreparedStatement st = null;
                ResultSet rs = null;

                st = conexao.prepareStatement("SELECT * FROM indicacoes_filmes cif \n"
                        + "JOIN filmes cf on cf.idfilmes = cif.id_filmes \n"
                        + "JOIN indicacoes ci on ci.idindicacoes = cif.id_indicacoes");

                rs = st.executeQuery();

                while (rs.next()) {
                    IndicacaoFilme temp = new IndicacaoFilme();

                    temp.setFilme(new Filme(rs.getInt("idfilmes"), rs.getString("cf.nome")));
                    temp.setIndicacao(new Indicacao(rs.getInt("idindicacoes"), rs.getString("ci.Nome")));

                    listIndicacoesFilmes.add(temp);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        } finally {
            conexao.close();
        }

        return listIndicacoesFilmes;
    }
}
