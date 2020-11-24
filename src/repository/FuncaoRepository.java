// Vitor Hugo Morais Lopes da Silva - 201802380485

package repository;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Funcao;

public class FuncaoRepository {

    Connection conexao;

    public FuncaoRepository() throws SQLException {
        conexao = Conexao.getConexao();
    }

    public boolean Insert(Funcao funcao) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("INSERT INTO funcoes (nome) values (?)");
                st.setString(1, funcao.getNome());

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

    public boolean Update(Funcao funcao) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("UPDATE funcoes SET nome = ? WHERE idfuncoes = ?");
                st.setString(1, funcao.getNome());
                st.setInt(2, funcao.getId());

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
                st = conexao.prepareStatement("DELETE FROM funcoes WHERE idfuncoes = ?");
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

    public ArrayList<Funcao> List() throws SQLException {

        ArrayList<Funcao> listFuncoes = new ArrayList<>();

        try {
            if (conexao != null) {
                PreparedStatement st = null;
                ResultSet rs = null;

                st = conexao.prepareStatement("SELECT * FROM funcoes");
                rs = st.executeQuery();

                while (rs.next()) {
                    Funcao temp = new Funcao();
                    temp.setId(rs.getInt("idfuncoes"));
                    temp.setNome(rs.getString("nome"));
                    listFuncoes.add(temp);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        } finally {
            conexao.close();
        }

        return listFuncoes;
    }

    public Funcao ReadDb(int id) throws SQLException {

        Funcao funcoes = new Funcao();

        try {
            if (conexao != null) {
                PreparedStatement st = null;
                ResultSet rs = null;

                st = conexao.prepareStatement("SELECT * FROM Funcoes WHERE IdFuncoes = ?");
                st.setInt(1, id);

                rs = st.executeQuery();

                while (rs.next()) {
                    funcoes.setId(rs.getInt("IdFuncoes"));
                    funcoes.setNome(rs.getString("Nome"));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        } finally {
            conexao.close();
        }

        return funcoes;
    }

}
