package br.com.novaroma.projeto.entidades;

import java.io.Serializable;

public class Livro implements Serializable {

    private String nome;
    private String autor;
    private String editora;
    private String isbn;
    private String nPaginas;
    private String idioma;
    private String nEdicao;
    private String anoEdicao;

    public Livro(String nome, String autor, String editora, String isbn, String nPaginas,
                 String idioma, String nEdicao, String anoEdicao) {

        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.isbn = isbn;
        this.nPaginas = nPaginas;
        this.idioma = idioma;
        this.nEdicao = nEdicao;
        this.anoEdicao = anoEdicao;

    }

    public Livro() {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getnPaginas() {
        return nPaginas;
    }

    public void setnPaginas(String nPaginas) {
        this.nPaginas = nPaginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getnEdicao() {
        return nEdicao;
    }

    public void setnEdicao(String nEdicao) {
        this.nEdicao = nEdicao;
    }

    public String getAnoEdicao() {
        return anoEdicao;
    }

    public void setAnoEdicao(String anoEdicao) {
        this.anoEdicao = anoEdicao;
    }

    public String toString() {
        String string = new String();

        string += this.nome + "\n";
        string += this.anoEdicao + "\n";
        string += this.autor + "\n";
        string += this.editora + "\n";
        string += this.idioma + "\n";
        string += this.isbn + "\n";
        string += this.nEdicao + "\n";
        string += this.nPaginas + "\n";

        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Livro livro = (Livro) o;

        if (!nome.equals(livro.nome)) return false;
        if (!autor.equals(livro.autor)) return false;
        if (!editora.equals(livro.editora)) return false;
        if (!isbn.equals(livro.isbn)) return false;
        if (!nPaginas.equals(livro.nPaginas)) return false;
        if (!idioma.equals(livro.idioma)) return false;
        if (!nEdicao.equals(livro.nEdicao)) return false;
        return anoEdicao.equals(livro.anoEdicao);
    }

    @Override
    public int hashCode() {
        int result = nome.hashCode();
        result = 31 * result + autor.hashCode();
        result = 31 * result + editora.hashCode();
        result = 31 * result + isbn.hashCode();
        result = 31 * result + nPaginas.hashCode();
        result = 31 * result + idioma.hashCode();
        result = 31 * result + nEdicao.hashCode();
        result = 31 * result + anoEdicao.hashCode();
        return result;
    }
}
