package com.example.mestrado2kellyv10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mestrado2kellyv10.DAO.PacienteDAO;
import com.example.mestrado2kellyv10.DAO.UsuarioDAO;
import com.example.mestrado2kellyv10.modelo.Paciente;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        Button loginEfetuado = (Button)findViewById(R.id.login_login_btn);
        loginEfetuado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDeMudarDeTela = new Intent(LoginActivity.this,NavegadorDoPacienteActivity.class);
                UsuarioDAO dao = new UsuarioDAO(LoginActivity.this);


                EditText campoNome = (EditText)findViewById(R.id.login_login);
                EditText campoSenha = (EditText)findViewById(R.id.login_senha);

                String confirmacaoDeEnfermeiro = dao.verificarUsuario(campoNome.getText().toString(),campoSenha.getText().toString());
                dao.close();

                if ( confirmacaoDeEnfermeiro.equals("usuariocadastrado") ){
                    Toast.makeText(LoginActivity.this,"Login efetuado",Toast.LENGTH_LONG).show();
                    startActivity(intentDeMudarDeTela);
                }
                if (confirmacaoDeEnfermeiro.equals("usuarionaocadastrado")){
                    //Toast.makeText(LoginActivity.this,"Enfermeiro "+ enfermeiro.getNome() +" Salvo.",Toast.LENGTH_LONG).show();
                    Toast.makeText(LoginActivity.this,"Paciente nao cadastrado",Toast.LENGTH_LONG).show();
                }

            }
        });



        Button novoUsuario = (Button)findViewById(R.id.login_novo_usuario_btn);
        novoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irParaTelaNovoUsuario = new Intent(LoginActivity.this,NovoUsuarioActivity.class);
                startActivity(irParaTelaNovoUsuario);
            }
        });
    }
}
