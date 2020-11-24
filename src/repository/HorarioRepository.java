package repository;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Horario;

public class HorarioRepository {

    Connection conexao;

    public HorarioRepository() throws SQLException {
        conexao = Conexao.getConexao();
    }

    public boolean Insert(Horario horario) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("INSERT INTO horarios (horario) values (?)");
                st.setString(1, horario.getHorario());

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

    public boolean Update(Horario horario) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("UPDATE horarios SET horario = ? WHERE idhorarios = ?");
                st.setString(1, horario.getHorario().toString());
                st.setInt(2, horario.getId());
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
                st = conexao.prepareStatement("DELETE FROM horarios WHERE idhorarios = ?");
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

    public ArrayList<Horario> List() throws SQLException {

        ArrayList<Horario> listHorarios = new ArrayList<>();

        try {
            if (conexao != null) {
                PreparedStatement st = null;
                ResultSet rs = null;

                st = conexao.prepareStatement("SELECT * FROM horarios");
                rs = st.executeQuery();

                while (rs.next()) {
                    Horario temp = new Horario();
                    temp.setId(rs.getInt("idhorarios"));
                    temp.setHorario(rs.getString("horario"));
                    listHorarios.add(temp);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        } finally {
            conexao.close();
        }

        return listHorarios;
    }

    public Horario ReadDb(int id) throws SQLException {

        Horario horarios = new Horario();

        try {
            if (conexao != null) {
                PreparedStatement st = null;
                ResultSet rs = null;

                st = conexao.prepareStatement("SELECT * FROM horarios WHERE idhorarios = ?");
                st.setInt(1, id);

                rs = st.executeQuery();

                while (rs.next()) {
                    horarios.setId(rs.getInt("idhorarios"));
                    horarios.setHorario(rs.getString("horario"));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        } finally {
            conexao.close();
        }

        return horarios;
    }

}
