package com.example.mestrado2kellyv10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mestrado2kellyv10.DAO.PacienteDAO;
import com.example.mestrado2kellyv10.DAO.ProntuarioDAO;
import com.example.mestrado2kellyv10.modelo.Paciente;
import com.example.mestrado2kellyv10.modelo.Prontuario;

import java.util.List;

public class EvolucaoDaNavegacaoActivity extends AppCompatActivity {

    private ListView listaDeNavegacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evolucao_da_navegacao);


        Paciente paciente = (Paciente) getIntent().getSerializableExtra("paciente");// RECEBENDO O PACIENTE DE OUTRA TELA

        listaDeNavegacao =(ListView)findViewById(R.id.evolucao_da_navegacao_lista_de_navegacao);
        listaDeNavegacao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                Prontuario paciente = (Prontuario) listaDeNavegacao.getItemAtPosition(position);

            }
        });

        carregaLista();
        Toast.makeText(EvolucaoDaNavegacaoActivity.this,"-> "+paciente.getNome(),Toast.LENGTH_LONG).show();
    }



    private void carregaLista() {
        ProntuarioDAO dao = new ProntuarioDAO(EvolucaoDaNavegacaoActivity.this);

        List<Prontuario> prontuarios = dao.buscaProntuario();

        dao.close();
        ListView listaAlunos = (ListView) findViewById(R.id.evolucao_da_navegacao_lista_de_navegacao);
        ArrayAdapter<Prontuario> adapter = new ArrayAdapter<Prontuario>(this, android.R.layout.simple_list_item_1,prontuarios);
        listaAlunos.setAdapter(adapter);
    }
}
