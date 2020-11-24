package repository;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Funcionario;

public class FuncionarioRepository {
    
    Connection conexao;

    public FuncionarioRepository() throws SQLException {
        conexao = Conexao.getConexao();
    }
    
    public boolean Insert(Funcionario funcionario) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("INSERT INTO Funcionarios (nome, data_Nascimento, cpf, bairro, logradouro, sexo, telefone_contato) values (?, ?, ?, ?, ?, ?, ?)");
                st.setString(1, funcionario.getNome());
                st.setDate(2, new java.sql.Date(funcionario.getData_Nascimento().getTime()));
                st.setString(3, funcionario.getCpf());
                st.setString(4, funcionario.getBairro());
                st.setString(5, funcionario.getLogradouro());
                st.setString(6, funcionario.getSexo());
                st.setString(7, funcionario.getTelefone_contato());

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

    public boolean Update(Funcionario funcionario) throws SQLException {
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                st = conexao.prepareStatement("UPDATE Funcionarios SET nome = ?, data_Nascimento = ?, "
                        + "cpf = ?, bairro = ?, logradouro = ?,"
                        + "sexo = ?,telefone_contato = ? WHERE idFuncionarios = ?");
                st.setString(1, funcionario.getNome());
                st.setDate(2, new java.sql.Date(funcionario.getData_Nascimento().getTime()));
                st.setString(3, funcionario.getCpf());
                st.setString(4, funcionario.getBairro());
                st.setString(5, funcionario.getLogradouro());
                st.setString(6, funcionario.getSexo());
                st.setString(7, funcionario.getTelefone_contato());
                st.setInt(8, funcionario.getId());

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
                st = conexao.prepareStatement("DELETE FROM Funcionarios WHERE idFuncionarios = ?");
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

    public ArrayList<Funcionario> List() throws SQLException {
        
        ArrayList<Funcionario> listFuncionarios = new ArrayList<>();
        
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                ResultSet rs = null;

                st = conexao.prepareStatement("SELECT * FROM funcionarios");
                rs = st.executeQuery();

                while (rs.next()) {
                    Funcionario temp = new Funcionario();
                    temp.setId(rs.getInt("idfuncionarios"));
                    temp.setNome(rs.getString("nome"));
                    temp.setData_Nascimento(rs.getDate("data_nascimento"));
                    temp.setCpf(rs.getString("cpf"));
                    temp.setBairro(rs.getString("bairro"));
                    temp.setLogradouro(rs.getString("logradouro"));
                    temp.setSexo(rs.getString("sexo"));
                    temp.setTelefone_contato(rs.getString("telefone_contato"));

                    listFuncionarios.add(temp);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        } finally {
            conexao.close();
        }

        return listFuncionarios;
    }

    public Funcionario ReadDb(int id) throws SQLException {
        
        Funcionario funcionarios = new Funcionario();
        
        try {
            if (conexao != null) {
                PreparedStatement st = null;
                ResultSet rs = null;

                st = conexao.prepareStatement("SELECT * FROM funcionarios WHERE idfuncionarios = ?");
                st.setInt(1, id);

                rs = st.executeQuery();

                while (rs.next()) {
                    funcionarios.setId(rs.getInt("idfuncionarios"));
                    funcionarios.setNome(rs.getString("nome"));
                    funcionarios.setData_Nascimento(rs.getDate("data_nascimento"));
                    funcionarios.setCpf(rs.getString("cpf"));
                    funcionarios.setBairro(rs.getString("bairro"));
                    funcionarios.setLogradouro(rs.getString("logradouro"));
                    funcionarios.setSexo(rs.getBlob("sexo").toString());
                    funcionarios.setTelefone_contato(rs.getString("telefone_contato"));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        } finally {
            conexao.close();
        }

        return funcionarios;
    }
    
}
