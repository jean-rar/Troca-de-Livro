package br.com.novaroma.projeto.negocios;

import br.com.novaroma.projeto.dados.DadosUsuario;
import br.com.novaroma.projeto.entidades.Livro;
import br.com.novaroma.projeto.entidades.Usuario;
import br.com.novaroma.projeto.excecoes.ExcecaoUsuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioNegocio {
    private DadosUsuario<Usuario> dados;

    public UsuarioNegocio() {
        this.dados = new DadosUsuario();
    }


    public void cadastrarUsuario(Usuario usuario) throws IOException, ClassNotFoundException {
        ArrayList<Usuario> usuarios = dados.lerArquivo();
        usuarios.add(usuario);
        dados.escrever(usuarios);
    }

    public void removerUsuario(String email) throws IOException, ClassNotFoundException, ExcecaoUsuario {
        if (existeUsuario(email)) {
            ArrayList<Usuario> usuarios = dados.lerArquivo();
            usuarios.remove(buscarUsuario(email));
            dados.escrever(usuarios);
        } else {
            throw new ExcecaoUsuario("Erro! Usuario não cadastrado!");
        }
    }

    public void atualizarUsuario(Usuario usuario) throws IOException, ClassNotFoundException, ExcecaoUsuario {
        if (existeUsuario(usuario.getEmail())) {
            removerUsuario(usuario.getEmail());
            cadastrarUsuario(usuario);
        } else {
            throw new ExcecaoUsuario("Erro! Usuario não Atualizado.");
        }
    }

    public Usuario buscarUsuario(String email) throws IOException, ClassNotFoundException {
        ArrayList<Usuario> usuarios = dados.lerArquivo();
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean existeUsuario(String email) throws IOException, ClassNotFoundException {
        return buscarUsuario(email) != null;
    }

    public List<Usuario> listarTodos() throws IOException, ClassNotFoundException {
        return dados.lerArquivo();
    }


}
