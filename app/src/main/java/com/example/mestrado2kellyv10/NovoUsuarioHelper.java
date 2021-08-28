package com.example.mestrado2kellyv10;

import android.widget.EditText;

import com.example.mestrado2kellyv10.modelo.Usuario;

public class NovoUsuarioHelper {

    private final EditText campoNomeEnfermeiro;
    private final EditText campoSenha;


    public NovoUsuarioHelper(NovoUsuarioActivity novoUsuarioActivity){
        //dica aperta alt+enter depois creadt field para criar a variavel
        campoNomeEnfermeiro = (EditText) novoUsuarioActivity.findViewById(R.id.novo_usuario_nome);
        campoSenha = (EditText) novoUsuarioActivity.findViewById(R.id.novo_usuario_senha);
    }


    public Usuario pegaEnfermeiro(){
        Usuario usuario = new Usuario();
        usuario.setNome(campoNomeEnfermeiro.getText().toString());
        usuario.setSenha(campoSenha.getText().toString());
        return usuario;
    }

}
