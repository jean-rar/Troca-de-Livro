package br.com.novaroma.projeto.entidades;

public class Didatico extends Livro {

    private String grau;
    private String volume;
    private String materia;

    public Didatico(String grau, String volume, String materia, String nome, String autor,
                    String editora, String isbn, String nPaginas, String idioma,
                    String nEdicao, String anoEdicao) {

        super(nome, autor, editora, isbn, nPaginas, idioma, nEdicao, anoEdicao);

        this.grau = grau;
        this.volume = volume;
        this.materia = materia;

    }

    public Didatico() {
    }

    public String toString() {
        String string = new String();

        string += "-------------D i d a t i c o-------------\n";
        string += "Nome: " + this.getNome() + "\n";
        string += "Matéria: " + this.materia + "\n";
        string += "Autor: " + this.getAutor() + "\n";
        string += "Volume: " + this.volume + "\n";
        string += "Grau: " + this.grau + "\n";
        string += "Editora: " + this.getEditora() + "\n";
        string += "Isbn: " + this.getIsbn() + "\n";
        string += "Número de Páginas: " + this.getnPaginas() + "\n";
        string += "Idioma: " + this.getIdioma() + "\n";
        string += "nº Edição: " + this.getnEdicao() + "\n";
        string += "Ano de Edição: " + this.getAnoEdicao() + "\n";
        string += ("----------------------------------------\n");

        return string;
    }

    public String getGrau() {
        return grau;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
