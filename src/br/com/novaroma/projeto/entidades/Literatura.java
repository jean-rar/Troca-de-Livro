package br.com.novaroma.projeto.entidades;

public class Literatura extends Paradidatico {
    private String tipo;

    public Literatura(String tipo, String genero, String nome, String autor, String editora,
                      String isbn, String nPaginas, String idioma, String nEdicao, String anoEdicao) {
        super(genero, nome, autor, editora, isbn, nPaginas, idioma, nEdicao, anoEdicao);

        this.setTipo(tipo);

    }

    public Literatura() {
    }

    public String toString() {
        String string = new String();

        string += "----------L i t e r a t u r a----------\n";
        string += "Nome: " + this.getNome() + "\n";
        string += "Autor: " + this.getAutor() + "\n";
        string += "Tipo: " + this.getTipo() + "\n";
        string += "Editora: " + this.getEditora() + "\n";
        string += "Isbn: " + this.getIsbn() + "\n";
        string += "Número de Páginas: " + this.getnPaginas() + "\n";
        string += "Idioma: " + this.getIdioma() + "\n";
        string += "nº Edição: " + this.getnEdicao() + "\n";
        string += "Ano de Edição: " + this.getAnoEdicao() + "\n";
        string += "----------------------------------------\n";

        return string;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
