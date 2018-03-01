package br.com.novaroma.projeto.negocios;

import br.com.novaroma.projeto.entidades.Livro;
import br.com.novaroma.projeto.entidades.Usuario;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class AdministradorNegocio {

    public String exibirUsuarios(){
        String string = new String();
        try{
            FileInputStream fis = new FileInputStream("usuario.data");

            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Usuario> lista = (ArrayList<Usuario>) ois.readObject();

            for(int i=0; i<lista.size(); i++){
                string += lista.get(i);
            }

            fis.close();
            ois.close();

        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return string;
    }

}
