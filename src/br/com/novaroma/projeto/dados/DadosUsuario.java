package br.com.novaroma.projeto.dados;

import br.com.novaroma.projeto.entidades.Usuario;

import java.io.*;
import java.util.ArrayList;

public class DadosUsuario<T> implements LerArquivo<T> {

    private File arquivo;

    public DadosUsuario() {
        arquivo = new File("usuario.data");
    }

    public void escrever(ArrayList<Usuario> usuarios) throws IOException {
        FileOutputStream fos = new FileOutputStream(arquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        try {
            oos.writeObject(usuarios);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            oos.flush();
            oos.close();
            fos.flush();
            fos.close();
        }
    }

    public ArrayList<T> lerArquivo() throws IOException, ClassNotFoundException {
        ArrayList<Usuario> usuarios = null;

        if (!arquivo.exists()) {
            arquivo.createNewFile();
            usuarios = new ArrayList<>();
        } else {
            FileInputStream fis = new FileInputStream(arquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);

            usuarios = (ArrayList<Usuario>) ois.readObject();

            ois.close();
            fis.close();
        }

        return (ArrayList<T>) usuarios;
    }
}
