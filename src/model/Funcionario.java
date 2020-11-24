package model;

import database.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Funcionario {

    private int id;
    private String nome;
    private Date data_Nascimento;
    private String cpf;
    private String Bairro;
    private String logradouro;
    private String sexo;
    private String telefone_contato;

    public Funcionario() {
    }
    
    public Funcionario(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Funcionario(int id, String nome, Date data_Nascimento, String cpf, String Bairro, String logradouro, String sexo, String telefone_contato) {
        this.id = id;
        this.nome = nome;
        this.data_Nascimento = data_Nascimento;
        this.cpf = cpf;
        this.Bairro = Bairro;
        this.logradouro = logradouro;
        this.sexo = sexo;
        this.telefone_contato = telefone_contato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_Nascimento() {
        return data_Nascimento;
    }

    public void setData_Nascimento(Date data_Nascimento) {
        this.data_Nascimento = data_Nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone_contato() {
        return telefone_contato;
    }

    public void setTelefone_contato(String telefone_contato) {
        this.telefone_contato = telefone_contato;
    }
    
    @Override
    public String toString() {
        return this.getId() + ") " + this.getNome();
    }
}
