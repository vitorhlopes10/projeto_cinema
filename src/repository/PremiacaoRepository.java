// Vitor Hugo Morais Lopes da Silva - 201802380485

package repository;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Premiacao;

public class PremiacaoRepository {

    Connection conexao;

    public PremiacaoRepository() throws SQLException {
        conexao = Conexao.getConexao();
    }

    public boolean Insert(Premiacao premiacao) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("INSERT INTO Premiacoes (Nome) values (?)");
                st.setString(1, premiacao.getNome());

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

    public boolean Update(Premiacao premiacao) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("UPDATE Premiacoes SET Nome = ? WHERE IdPremiacoes = ?");
                st.setString(1, premiacao.getNome());
                st.setInt(2, premiacao.getId());

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
                st = conexao.prepareStatement("DELETE FROM Premiacoes WHERE IdPremiacoes = ?");
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

    public ArrayList<Premiacao> List() throws SQLException {
        ArrayList<Premiacao> listPremiacoes = new ArrayList<>();
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                ResultSet rs = null;

                st = conexao.prepareStatement("SELECT * FROM Premiacoes");
                rs = st.executeQuery();

                while (rs.next()) {
                    Premiacao temp = new Premiacao();
                    temp.setId(rs.getInt("IdPremiacoes"));
                    temp.setNome(rs.getString("Nome"));
                    listPremiacoes.add(temp);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        } finally {
            conexao.close();
        }

        return listPremiacoes;
    }

    public Premiacao ReadDb(int id) throws SQLException {
        Premiacao premiacao = new Premiacao();
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                ResultSet rs = null;

                st = conexao.prepareStatement("SELECT * FROM Premiacoes WHERE IdPremiacoes = ?");
                st.setInt(1, id);

                rs = st.executeQuery();

                while (rs.next()) {
                    premiacao.setId(rs.getInt("IdPremiacoes"));
                    premiacao.setNome(rs.getString("Nome"));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        } finally {
            conexao.close();
        }

        return premiacao;
    }

}
