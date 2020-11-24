// Vitor Hugo Morais Lopes da Silva - 201802380485

package repository;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Genero;

public class GeneroRepository {

    Connection conexao;

    public GeneroRepository() throws SQLException {
        conexao = Conexao.getConexao();
    }

    public boolean Insert(Genero genero) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("INSERT INTO generos (nome) values (?)");
                st.setString(1, genero.getNome());

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

    public boolean Update(Genero genero) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("UPDATE generos SET nome = ? WHERE idgeneros = ?");
                st.setString(1, genero.getNome());
                st.setInt(2, genero.getId());

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
                st = conexao.prepareStatement("DELETE FROM generos WHERE idgeneros = ?");
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

    public ArrayList<Genero> List() throws SQLException {

        ArrayList<Genero> listGeneros = new ArrayList<>();

        try {
            if (conexao != null) {
                PreparedStatement st = null;
                ResultSet rs = null;

                st = conexao.prepareStatement("SELECT * FROM generos");
                rs = st.executeQuery();

                while (rs.next()) {
                    Genero temp = new Genero();
                    temp.setId(rs.getInt("idgeneros"));
                    temp.setNome(rs.getString("nome"));
                    listGeneros.add(temp);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        } finally {
            conexao.close();
        }

        return listGeneros;
    }

    public Genero ReadDb(int id) throws SQLException {

        Genero genero = new Genero();

        try {
            if (conexao != null) {
                PreparedStatement st = null;
                ResultSet rs = null;

                st = conexao.prepareStatement("SELECT * FROM generos WHERE idgeneros = ?");
                st.setInt(1, id);

                rs = st.executeQuery();

                while (rs.next()) {
                    genero.setId(rs.getInt("idgeneros"));
                    genero.setNome(rs.getString("nome"));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        } finally {
            conexao.close();
        }

        return genero;
    }

}
