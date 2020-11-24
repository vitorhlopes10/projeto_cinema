// Vitor Hugo Morais Lopes da Silva - 201802380485

package repository;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Classificacao;

public class ClassificacaoRepository {

    Connection conexao;

    public ClassificacaoRepository() throws SQLException {
        conexao = Conexao.getConexao();
    }

    public boolean Insert(Classificacao classificacao) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("INSERT INTO classificacoes (Nome) values (?)");
                st.setString(1, classificacao.getNome());

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

    public boolean Update(Classificacao classificacao) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("UPDATE classificacoes SET Nome = ? WHERE idclassificacoes = ?");
                st.setString(1, classificacao.getNome());
                st.setInt(2, classificacao.getId());

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
                st = conexao.prepareStatement("DELETE FROM classificacoes WHERE idclassificacoes = ?");
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

    public ArrayList<Classificacao> List() throws SQLException {

        ArrayList<Classificacao> listClassificacoes = new ArrayList<>();

        try {
            if (conexao != null) {
                PreparedStatement st = null;
                ResultSet rs = null;

                st = conexao.prepareStatement("SELECT * FROM classificacoes");
                rs = st.executeQuery();

                while (rs.next()) {
                    Classificacao temp = new Classificacao();
                    temp.setId(rs.getInt("idclassificacoes"));
                    temp.setNome(rs.getString("Nome"));
                    listClassificacoes.add(temp);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        } finally {
            conexao.close();
        }

        return listClassificacoes;
    }

    public Classificacao ReadDb(int id) throws SQLException {

        Classificacao classificacao = new Classificacao();

        try {
            if (conexao != null) {
                PreparedStatement st = null;
                ResultSet rs = null;

                st = conexao.prepareStatement("SELECT * FROM classificacoes WHERE idclassificacoes = ?");
                st.setInt(1, id);

                rs = st.executeQuery();

                while (rs.next()) {
                    classificacao.setId(rs.getInt("idclassificacoes"));
                    classificacao.setNome(rs.getString("Nome"));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        } finally {
            conexao.close();
        }

        return classificacao;
    }

}
