package com.example.mestrado2kellyv10;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mestrado2kellyv10.DAO.PacienteDAO;
import com.example.mestrado2kellyv10.DAO.ProntuarioDAO;
import com.example.mestrado2kellyv10.modelo.Paciente;
import com.example.mestrado2kellyv10.modelo.Prontuario;

import java.util.Calendar;
import java.util.List;

public class ProntuarioActivity extends AppCompatActivity {


    private ProntuarioHelper ajuda;

    Calendar c;
    String dataAUX;
    DatePickerDialog pegaData;
    EditText data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prontuario);

        TextView prontuario_paciente1 = (TextView) findViewById(R.id.prontuario_paciente_TXT_1);
        TextView prontuario_paciente2 = (TextView) findViewById(R.id.prontuario_paciente_TXT_2);
        TextView prontuario_paciente3 = (TextView) findViewById(R.id.prontuario_paciente_TXT_3);


        final Paciente paciente = (Paciente) getIntent().getSerializableExtra("paciente");// RECEBENDO O PACIENTE DE OUTRA TELA
        ajuda = new ProntuarioHelper(this);
        /*
        private String campoNR;
        private String campon;
        private String campoHAS;
        private String campoDM;
        private String campoDLP;
        private String campoICO;
        private String campoICC;
        private String campoIRC;*/
        if (paciente.getDatadoagendamento() != null ||
                paciente.getPequenosprocedimentosMotivos() != null ||
                paciente.getEvolucao() != null ||
                paciente.getCampoA() != null ||
                paciente.getCampoNA() != null ||
                paciente.getCampoR() != null) {
            Toast.makeText(ProntuarioActivity.this, "ENTRO"+paciente.getNome(), Toast.LENGTH_LONG).show();

            ajuda.preencheFormulario(paciente);

        }

        prontuario_paciente1.setText("Nome do paciente: " + paciente.getNome() + " idade: " + paciente.getIdade());
        prontuario_paciente2.setText("Telefone de contato: " + paciente.getTelefone() + " Carteira: " + paciente.getCarteira());
        prontuario_paciente3.setText("Médico responsável: " + paciente.getMedico() + " CID: " + paciente.getCID());
        // prontuario_paciente4.setText("Data do agendamento: "+paciente.getDatadoagendamento());


        data = (EditText) findViewById(R.id.prontuario_paciente_TXT_4_data_do_agendamento);
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();

                int dia = c.get(Calendar.DAY_OF_MONTH);
                int mes = c.get(Calendar.MONTH);
                int ano = c.get(Calendar.YEAR);

                pegaData = new DatePickerDialog(ProntuarioActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int plyear, int plmonth, int pldayOfMonth) {
                        int mesaux;
                        mesaux = plmonth + 1;
                        data.setText(pldayOfMonth + "/" + mesaux + "/" + plyear);
                        dataAUX = pldayOfMonth + "/" + mesaux + "/" + plyear;
                        paciente.setDatadoagendamento(dataAUX);
                    }
                }, dia, mes, ano);
                pegaData.show();
            }
        });


        Button contato = (Button) findViewById(R.id.prontuario_contato);
        contato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paciente contato = paciente;
                Intent irParaTelaDaEvolucaoDaNavegacao = new Intent(ProntuarioActivity.this, ContatoActivity.class);
                irParaTelaDaEvolucaoDaNavegacao.putExtra("contato", contato);
                startActivity(irParaTelaDaEvolucaoDaNavegacao);
            }
        });

        Button salvar = (Button) findViewById(R.id.salvar_prontuario);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Paciente paciente2 = ajuda.pegaPaciente(paciente);
                PacienteDAO dao = new PacienteDAO(ProntuarioActivity.this);
                Toast.makeText(ProntuarioActivity.this, "contato-> " + paciente.getContato(), Toast.LENGTH_LONG).show();

                dao.altera(paciente2);
                dao.close();
                finish();
            }
        });


    }/*
    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    private void carregaLista() {
        ProntuarioDAO dao2=new ProntuarioDAO(ProntuarioActivity.this);

        List<Prontuario> medicos = dao2.buscaProntuario();
        dao2.buscaProntuario();

        dao2.close();
        ListView listaMedicos1 = (ListView) findViewById(R.id.prontuario_consultas_1_medico_especialista);
        ListView listaMedicos2 = (ListView) findViewById(R.id.prontuario_pronto_socorro_2_lista);
        ListView listaMedicos3 = (ListView) findViewById(R.id.prontuario_internacaoes_3_lista);
        ListView listaMedicos4 = (ListView) findViewById(R.id.prontuario_procedimentos_4_lista);
        ArrayAdapter<Prontuario> adapter = new ArrayAdapter<Prontuario>(this, android.R.layout.simple_list_item_1,medicos);
        listaMedicos1.setAdapter(adapter);
        listaMedicos2.setAdapter(adapter);
        listaMedicos3.setAdapter(adapter);
        listaMedicos4.setAdapter(adapter);
    }*/
}
