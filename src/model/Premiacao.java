// Vitor Hugo Morais Lopes da Silva - 201802380485

package model;

public class Premiacao {

    private int id;
    private String nome;

    public Premiacao() {
    }

    public Premiacao(int id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public String toString() {
        return this.getId() + ") " + this.getNome();
    }
}
