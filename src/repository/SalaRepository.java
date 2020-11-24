package repository;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cinema;
import model.Sala;

public class SalaRepository {

    Connection conexao;
    CinemaRepository cinemaRepository;

    public SalaRepository() throws SQLException {
        cinemaRepository = new CinemaRepository();
    }

    public boolean Insert(Sala sala) throws SQLException {
        Connection conexao = Conexao.getConexao();
        conexao = Conexao.getConexao();

        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("INSERT INTO Salas (Nome, IdCinemas) values (?, ?)");
                st.setString(1, sala.getNome());
                st.setInt(2, sala.getCinema().getId());

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

    public boolean Update(Sala sala) throws SQLException {
        Connection conexao = Conexao.getConexao();

        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("UPDATE Salas SET Nome = ?, idCinemas = ? WHERE idSalas = ?");
                st.setString(1, sala.getNome());
                st.setInt(2, sala.getCinema().getId());
                st.setInt(3, sala.getId());

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
        Connection conexao = Conexao.getConexao();

        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("DELETE FROM Salas WHERE idSalas = ?");
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

    public ArrayList<Sala> List() throws SQLException {

        ArrayList<Sala> listSalas = new ArrayList<>();
        Connection conexao = Conexao.getConexao();

        try {
            if (conexao != null) {
                PreparedStatement st = null;
                ResultSet rs = null;

                st = conexao.prepareStatement("SELECT * FROM salas JOIN cinemas on cinemas.idcinemas = salas.idcinemas");
                rs = st.executeQuery();

                while (rs.next()) {
                    Sala temp = new Sala();

                    temp.setId(rs.getInt("idsalas"));
                    temp.setNome(rs.getString("Nome"));
                    temp.setCinema(new Cinema(rs.getInt("cinemas.idcinemas"), rs.getString("cinemas.cnpj"), rs.getString("cinemas.nome")));

                    listSalas.add(temp);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        } finally {
            conexao.close();
        }

        return listSalas;
    }

    public Sala ReadDb(int id) throws SQLException {

        Sala sala = new Sala();
        Connection conexao = Conexao.getConexao();

        try {
            if (conexao != null) {
                PreparedStatement st = null;
                ResultSet rs = null;

                st = conexao.prepareStatement("SELECT * FROM Salas WHERE IdSalas = ?");
                st.setInt(1, id);

                rs = st.executeQuery();

                while (rs.next()) {
                    sala.setId(rs.getInt("idSalas"));
                    sala.setNome(rs.getString("Nome"));
                    sala.setCinema(cinemaRepository.ReadDb(rs.getInt("IdCinemas")));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        } finally {
            conexao.close();
        }

        return sala;
    }

}
