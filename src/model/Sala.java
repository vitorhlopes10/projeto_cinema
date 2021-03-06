// Vitor Hugo Morais Lopes da Silva - 201802380485

package model;

public class Sala {

    private int id;
    private String nome;
    private Cinema cinema;

    public Sala() {
    }
    
    public Sala(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Sala(int id, String nome, Cinema cinema) {
        this.id = id;
        this.nome = nome;
        this.cinema = cinema;
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

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public String toString() {
        return this.getId() + ") " + this.getNome();
    }
}
