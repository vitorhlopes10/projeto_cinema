package repository;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cinema;

public class CinemaRepository {
    
    Connection conexao;
    
    public CinemaRepository() throws SQLException {
        conexao = Conexao.getConexao();
    }

    public boolean Insert(Cinema cinema) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("INSERT INTO cinemas (Nome, CNPJ) values (?, ?)");
                st.setString(1, cinema.getNome());
                st.setString(2, cinema.getCnpj());

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

    public boolean Update(Cinema cinema) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("UPDATE cinemas SET Nome = ?, CNPJ = ? WHERE idcinemas = ?");
                st.setString(1, cinema.getNome());
                st.setString(2, cinema.getCnpj());
                st.setInt(3, cinema.getId());

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
                st = conexao.prepareStatement("DELETE FROM cinemas WHERE idcinemas = ?");
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

    public ArrayList<Cinema> List() throws SQLException {

        ArrayList<Cinema> listCinema = new ArrayList<>();

        try {
            if (conexao != null) {
                PreparedStatement st = null;
                ResultSet rs = null;

                st = conexao.prepareStatement("SELECT * FROM cinemas");
                rs = st.executeQuery();

                while (rs.next()) {
                    Cinema temp = new Cinema();
                    temp.setId(rs.getInt("idcinemas"));
                    temp.setNome(rs.getString("Nome"));
                    temp.setCnpj(rs.getString("CNPJ"));
                    listCinema.add(temp);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        } finally {
            conexao.close();
        }

        return listCinema;
    }

    public Cinema ReadDb(int id) throws SQLException {

        Cinema cinema = new Cinema();

        try {
            if (conexao != null) {
                PreparedStatement st = null;
                ResultSet rs = null;

                st = conexao.prepareStatement("SELECT * FROM cinemas WHERE idcinemas = ?");
                st.setInt(1, id);

                rs = st.executeQuery();

                while (rs.next()) {
                    cinema.setId(rs.getInt("idcinemas"));
                    cinema.setNome(rs.getString("Nome"));
                    cinema.setCnpj(rs.getString("CNPJ"));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        } finally {
            conexao.close();
        }

        return cinema;
    }

}
