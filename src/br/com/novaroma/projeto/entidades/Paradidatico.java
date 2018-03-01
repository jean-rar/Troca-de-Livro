package br.com.novaroma.projeto.entidades;

public class Paradidatico extends Livro {
    private String genero;

    public Paradidatico(String genero, String nome, String autor, String editora, String isbn,
                        String nPaginas, String idioma, String nEdicao, String anoEdicao) {
        super(nome, autor, editora, isbn, nPaginas, idioma, nEdicao, anoEdicao);

        this.genero = genero;

    }

    public Paradidatico() {
    }

    public String toString() {
        String string = new String();

        string += "--------P a r a d i d a t i c o--------\n";
        string += "Nome: " + this.getNome() + "\n";
        string += "Autor: " + this.getAutor() + "\n";
        string += "Genero: " + this.genero + "\n";
        string += "Editora: " + this.getEditora() + "\n";
        string += "Isbn: " + this.getIsbn() + "\n";
        string += "Número de Páginas: " + this.getnPaginas() + "\n";
        string += "Idioma: " + this.getIdioma() + "\n";
        string += "nº Edição: " + this.getnEdicao() + "\n";
        string += "Ano de Edição: " + this.getAnoEdicao() + "\n";
        string += "----------------------------------------\n";

        return string;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
