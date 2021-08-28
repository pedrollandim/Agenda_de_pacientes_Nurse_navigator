package com.example.mestrado2kellyv10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mestrado2kellyv10.DAO.PacienteDAO;
import com.example.mestrado2kellyv10.DAO.ProntuarioDAO;
import com.example.mestrado2kellyv10.modelo.Paciente;
import com.example.mestrado2kellyv10.modelo.Prontuario;

import java.util.List;

public class ListaDeClientesActivity extends AppCompatActivity {

    private ListView listaPacientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_clientes);



        listaPacientes =(ListView)findViewById(R.id.lista_pacientes);
        listaPacientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                Paciente paciente = (Paciente) listaPacientes.getItemAtPosition(position);
                Intent prontuario = new Intent(ListaDeClientesActivity.this,ProntuarioActivity.class);
                //***
                // MOVENDO OBJETO ENTRE TELAS
                prontuario.putExtra("paciente",paciente );
                //***
                startActivity(prontuario);
            }
        });

    }


/*
    private void carregaLista() {
        PacienteDAO dao = new PacienteDAO(ListaDeClientesActivity.this);
        ProntuarioDAO dao2=new ProntuarioDAO(ListaDeClientesActivity.this);

        List<Paciente> pacientes = dao.buscaPacientesCOREN();
        dao2.buscaProntuario();

        dao.close();
        dao2.close();
        ListView listaAlunos = (ListView) findViewById(R.id.lista_pacientes);
        ArrayAdapter<Paciente> adapter = new ArrayAdapter<Paciente>(this, android.R.layout.simple_list_item_1,pacientes);
        listaAlunos.setAdapter(adapter);
    }
*/


    private void carregaLista() {
        PacienteDAO dao = new PacienteDAO(this);
        List<Paciente> pacientes = dao.buscaPacientesCOREN();
        dao.close();

        ArrayAdapter<Paciente> adapter = new ArrayAdapter<Paciente>(this, android.R.layout.simple_list_item_1, pacientes);
        listaPacientes.setAdapter(adapter);
    }
    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }


}
