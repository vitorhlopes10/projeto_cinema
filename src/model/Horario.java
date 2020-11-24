package model;

import database.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Horario {

    private int id;
    private String Horario;

    public Horario() {
    }

    public Horario(int id, String Horario) {
        this.id = id;
        this.Horario = Horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

    @Override
    public String toString() {
        return this.getId() + ") " + this.getHorario();
    }
}
