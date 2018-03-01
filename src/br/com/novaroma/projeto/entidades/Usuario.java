package br.com.novaroma.projeto.entidades;

import br.com.novaroma.projeto.excecoes.ExcecaoUsuario;
import br.com.novaroma.projeto.negocios.UsuarioNegocio;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class Usuario implements Serializable {
    static UsuarioNegocio un = new UsuarioNegocio();

    private String nome;
    private String nascimento;
    private String email;
    private String senha;

    private Set<Livro> livros;
    private List<Livro> livrosInteresse;

    public Usuario() {
        livros = new HashSet<>();
        livrosInteresse = new ArrayList<>();
    }

    public String toString() {
        String string = new String();

        string += "     --------------------------\n";
        string += "     Nome: " + this.nome + "\n";
        string += "     Email: " + this.email + "\n";
        string += "     D.Nascimento: " + this.nascimento + "\n";
        string += "     --------------------------\n";

        return string;
    }

    public String listarLivros() {
        String string = new String();

        string += "              L I V R O S       \n";
            string += livros;

        string += "\n";
        string += "         I N T E R E S S E S     \n";

        for(int i=0; i<livrosInteresse.size(); i++){
            string += livrosInteresse.get(i).toString() +"\n";
        }

        return string;
    }

    public String removerLivro(String isbn) throws ExcecaoUsuario, IOException, ClassNotFoundException {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn))
                livros.remove(livro);
            return "Livro removido!";
        }
        return "Livro não encontrado!";
    }

    public String removerLivroInterese(String isbn) throws ExcecaoUsuario, IOException, ClassNotFoundException {
        for (Livro x : livrosInteresse) {
            if (x.getIsbn().equals(isbn))
                livrosInteresse.remove(x);
            return "Livro removido!";
        }
        return "Livro não encontrado!";
    }

    public Livro buscarLivro(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn))
                return livro;
        }
        throw new NoSuchElementException("Livro não encontrado: " + isbn);
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Livro> getLivros() {
        return livros;
    }

    public void setLivros(Set<Livro> livros) {
        this.livros = livros;
    }

    public List<Livro> getLivrosInteresse() {
        return livrosInteresse;
    }

    public void setLivrosInteresse(List<Livro> livrosInteresse) {
        this.livrosInteresse = livrosInteresse;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        if (nome != null ? !nome.equals(usuario.nome) : usuario.nome != null) return false;
        if (nascimento != null ? !nascimento.equals(usuario.nascimento) : usuario.nascimento != null) return false;
        if (email != null ? !email.equals(usuario.email) : usuario.email != null) return false;
        if (senha != null ? !senha.equals(usuario.senha) : usuario.senha != null) return false;
        if (livros != null ? !livros.equals(usuario.livros) : usuario.livros != null) return false;
        return livrosInteresse != null ? livrosInteresse.equals(usuario.livrosInteresse) : usuario.livrosInteresse == null;
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
