package repository;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Classificacao;
import model.Filme;
import model.Genero;
import model.Premiacao;

public class FilmeRepository {

    Connection conexao;
    GeneroRepository generoRepository;
    ClassificacaoRepository classificacaoRepository;
    PremiacaoRepository premiacaoRepository;

    public FilmeRepository() throws SQLException {
        generoRepository = new GeneroRepository();
        classificacaoRepository = new ClassificacaoRepository();
        premiacaoRepository = new PremiacaoRepository();
        conexao = Conexao.getConexao();
    }

    public boolean Insert(Filme filme) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("INSERT INTO filmes (nome, data_lancamento, duracao, idgeneros, "
                        + "idclassificacao, idpremiacao) values (?, ?, ?, ?, ?, ?)");
                st.setString(1, filme.getNome());
                st.setDate(2, new java.sql.Date(filme.getData_lancamento().getTime()));
                st.setInt(3, filme.getDuracao());
                st.setInt(4, filme.getGenero().getId());
                st.setInt(5, filme.getClassificacao().getId());
                st.setInt(6, filme.getPremiacoes().getId());

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

    public boolean Update(Filme filme) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("UPDATE filmes SET nome = ?, data_lancamento = ?, "
                        + "duracao = ?, idgeneros = ?, idclassificacao = ?, idpremiacao = ?"
                        + "   WHERE idfilmes = ?");
                st.setString(1, filme.getNome());
                st.setDate(2, new java.sql.Date(filme.getData_lancamento().getTime()));
                st.setInt(3, filme.getDuracao());
                st.setInt(4, filme.getGenero().getId());
                st.setInt(5, filme.getClassificacao().getId());
                st.setInt(6, filme.getPremiacoes().getId());
                st.setInt(7, filme.getId());

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
                st = conexao.prepareStatement("DELETE FROM filmes WHERE idfilmes = ?");
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

    public ArrayList<Filme> List() throws SQLException {

        ArrayList<Filme> listFilmes = new ArrayList<Filme>();

        try {
            if (conexao != null) {
                PreparedStatement st = null;
                ResultSet rs = null;

                st = conexao.prepareStatement("SELECT * FROM cinema.filmes cf\n"
                        + "JOIN cinema.generos cg on cg.idgeneros = cf.idgeneros\n"
                        + "JOIN cinema.classificacoes cc on cc.idclassificacoes = cf.idclassificacao");
                
                rs = st.executeQuery();

                while (rs.next()) {
                    Filme temp = new Filme();

                    temp.setId(rs.getInt("IdFilmes"));
                    temp.setNome(rs.getString("Nome"));
                    temp.setData_lancamento(rs.getDate("Data_lancamento"));
                    temp.setDuracao(rs.getInt("Duracao"));
                    temp.setGenero(new Genero(rs.getInt("idgeneros"), rs.getString("nome")));
                    temp.setClassificacao(new Classificacao(rs.getInt("idclassificacoes"), rs.getString("nome")));
                    temp.setPremiacoes(rs.getInt("idpremiacao") != 0 ? premiacaoRepository.ReadDb(rs.getInt("idpremiacao")) : null);

                    listFilmes.add(temp);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        } finally {
            conexao.close();
        }

        return listFilmes;
    }

    public Filme ReadDb(int id) throws SQLException {

        Filme filmes = new Filme();

        try {
            if (conexao != null) {
                PreparedStatement st = null;
                ResultSet rs = null;

                st = conexao.prepareStatement("SELECT * FROM filmes WHERE Idfilmes = ?");
                st.setInt(1, id);

                rs = st.executeQuery();

                while (rs.next()) {
                    filmes.setId(rs.getInt("idfilmes"));
                    filmes.setNome(rs.getString("nome"));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        } finally {
            conexao.close();
        }

        return filmes;
    }
}
