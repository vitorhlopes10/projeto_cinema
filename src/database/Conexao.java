package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection conn = null;

    public static Connection getConexao() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cinema";
            String username = "root";
            String password = "123456";

            conn = DriverManager.getConnection(url, username, password);

            return conn;
        } catch (Exception e) {
            System.out.println("Erro:" + e.getMessage());
            return null;
        }
    }

    public static boolean fecharConexao() {
        try {
            Conexao.getConexao().close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
