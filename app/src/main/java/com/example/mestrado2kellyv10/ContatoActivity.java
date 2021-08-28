package com.example.mestrado2kellyv10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mestrado2kellyv10.DAO.PacienteDAO;
import com.example.mestrado2kellyv10.modelo.Paciente;

public class ContatoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        final Paciente contato = (Paciente) getIntent().getSerializableExtra("contato");// RECEBENDO O PACIENTE DE OUTRA TELA
        final PacienteDAO dao=new PacienteDAO(this);

        Button contato1=(Button)findViewById(R.id.contato_CS);
        contato1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contato.setContato("Contato com sucesso");
                Toast.makeText(ContatoActivity.this,"OK-> "+contato.getId(),Toast.LENGTH_LONG).show();
                dao.altera(contato);
                dao.close();
                finish();
            }
        });

        Button contato2=(Button)findViewById(R.id.contato_NA);
        contato2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contato.setContato("Não atendeu");
                //Toast.makeText(ContatoActivity.this,"OK",Toast.LENGTH_LONG).show();
                dao.altera(contato);
                dao.close();
                finish();
            }
        });

        Button contato3=(Button)findViewById(R.id.contato_OC);
        contato3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contato.setContato("Ocupado");
                //Toast.makeText(ContatoActivity.this,"OK",Toast.LENGTH_LONG).show();
                dao.altera(contato);
                dao.close();
                finish();
            }
        });

        Button contato4=(Button)findViewById(R.id.contato_RE);
        contato4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contato.setContato("Retornar depois");
                //Toast.makeText(ContatoActivity.this,"OK",Toast.LENGTH_LONG).show();
                dao.altera(contato);
                dao.close();
                finish();
            }
        });

        final EditText contato5=(EditText)findViewById(R.id.contato_OU);
        Button contato6=(Button)findViewById(R.id.contato_OU_ok);
        contato6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contato.setContato(contato5.getText().toString());
                //Toast.makeText(ContatoActivity.this,"OK "+ contato.getContato(),Toast.LENGTH_LONG).show();
                dao.altera(contato);
                dao.close();
                finish();
            }
        });
    }
}
