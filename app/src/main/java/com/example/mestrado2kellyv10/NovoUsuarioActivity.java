package com.example.mestrado2kellyv10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mestrado2kellyv10.DAO.UsuarioDAO;
import com.example.mestrado2kellyv10.modelo.Usuario;

public class NovoUsuarioActivity extends AppCompatActivity {

    private NovoUsuarioHelper ajudaUSUARIO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);


        ajudaUSUARIO = new NovoUsuarioHelper(this);

        Button salvarNovoEnfermeiro = (Button)findViewById(R.id.novo_usuario_salvar);
        salvarNovoEnfermeiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText campoSenha1 = (EditText)findViewById(R.id.novo_usuario_senha);
                EditText campoSenha2 = (EditText)findViewById(R.id.novo_usuario_confirmar_senha);
                if(campoSenha1.getText().toString().equals(campoSenha2.getText().toString())){
                    Usuario usuario = ajudaUSUARIO.pegaEnfermeiro();
                    UsuarioDAO dao = new UsuarioDAO(NovoUsuarioActivity.this);
                    dao.insereUsuario(usuario);
                    dao.close();
                    //Toast.makeText(NovoUsuarioActivity.this," - "+ usuario.getNome()+" - ",Toast.LENGTH_LONG).show();
                    Toast.makeText(NovoUsuarioActivity.this,"Cadastro efetuado",Toast.LENGTH_LONG).show();
                    finish();
                }
                if(!campoSenha1.getText().toString().equals(campoSenha2.getText().toString())){
                    Toast.makeText(NovoUsuarioActivity.this,"Senha incorreta",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
