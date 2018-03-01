package br.com.novaroma.projeto.entidades;

public class Hqs extends Paradidatico {

    private String marca;
    private String ilustrador;

    public Hqs(String marca, String ilustrador, String genero, String nome, String autor, String editora,
               String isbn, String nPaginas, String idioma, String nEdicao, String anoEdicao) {
        super(genero, nome, autor, editora, isbn, nPaginas, idioma, nEdicao, anoEdicao);

        this.setMarca(marca);
        this.setIlustrador(ilustrador);

    }

    public Hqs() {
    }

    public String toString() {
        String string = new String();

        string += "------------------H Q------------------\n";
        string += "Nome: " + this.getNome() + "\n";
        string += "Autor: " + this.getAutor() + "\n";
        string += "Ilustrador: " + this.getIlustrador() + "\n";
        string += "Marca: " + this.getMarca() + "\n";
        string += "Editora: " + this.getEditora() + "\n";
        string += "Isbn: " + this.getIsbn() + "\n";
        string += "Número de Páginas: " + this.getnPaginas() + "\n";
        string += "Idioma: " + this.getIdioma() + "\n";
        string += "nº Edição: " + this.getnEdicao() + "\n";
        string += "Ano de Edição: " + this.getAnoEdicao() + "\n";
        string += ("----------------------------------------\n");

        return string;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getIlustrador() {
        return ilustrador;
    }

    public void setIlustrador(String ilustrador) {
        this.ilustrador = ilustrador;
    }
}
