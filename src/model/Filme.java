package model;

import database.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Filme {

    private int id;
    private String nome;
    private Date data_lancamento;
    private int duracao;
    private Genero genero;
    private Classificacao classificacao;
    private Premiacao premiacoes;

    public Filme() {
    }
    
    public Filme(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Filme(int id, String nome, Date data_lancamento, int duracao, Genero genero, Classificacao classificacao, Premiacao premiacoes) {
        this.id = id;
        this.nome = nome;
        this.data_lancamento = data_lancamento;
        this.duracao = duracao;
        this.genero = genero;
        this.classificacao = classificacao;
        this.premiacoes = premiacoes;
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

    public Date getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(Date data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public Premiacao getPremiacoes() {
        return premiacoes;
    }

    public void setPremiacoes(Premiacao premiacoes) {
        this.premiacoes = premiacoes;
    }

    @Override
    public String toString() {
        return this.getId() + ") " + this.getNome();
    }
}
