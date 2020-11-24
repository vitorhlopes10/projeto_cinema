// Vitor Hugo Morais Lopes da Silva - 201802380485

package repository;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Indicacao;

public class IndicacaoRepository {

    Connection conexao;

    public IndicacaoRepository() throws SQLException {
        conexao = Conexao.getConexao();
    }

    public boolean Insert(Indicacao indicacao) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("INSERT INTO Indicacoes (Nome) values (?)");
                st.setString(1, indicacao.getNome());

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

    public boolean Update(Indicacao indicacao) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("UPDATE Indicacoes SET Nome = ? WHERE idIndicacoes = ?");
                st.setString(1, indicacao.getNome());
                st.setInt(2, indicacao.getId());

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
                st = conexao.prepareStatement("DELETE FROM Indicacoes WHERE idIndicacoes = ?");
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

    public ArrayList<Indicacao> List() throws SQLException {

        ArrayList<Indicacao> listIndicacoes = new ArrayList<>();

        try {
            if (conexao != null) {
                PreparedStatement st = null;
                ResultSet rs = null;

                st = conexao.prepareStatement("SELECT * FROM Indicacoes");
                rs = st.executeQuery();

                while (rs.next()) {
                    Indicacao temp = new Indicacao();
                    temp.setId(rs.getInt("idIndicacoes"));
                    temp.setNome(rs.getString("Nome"));
                    listIndicacoes.add(temp);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        } finally {
            conexao.close();
        }

        return listIndicacoes;
    }

    public Indicacao ReadDb(int id) throws SQLException {

        Indicacao indicacao = new Indicacao();

        try {
            if (conexao != null) {
                PreparedStatement st = null;
                ResultSet rs = null;

                st = conexao.prepareStatement("SELECT * FROM Indicacoes WHERE IdIndicacoes = ?");
                st.setInt(1, id);

                rs = st.executeQuery();

                while (rs.next()) {
                    indicacao.setId(rs.getInt("IdIndicacoes"));
                    indicacao.setNome(rs.getString("Nome"));
                }

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        } finally {
            conexao.close();
        }

        return indicacao;
    }

}
