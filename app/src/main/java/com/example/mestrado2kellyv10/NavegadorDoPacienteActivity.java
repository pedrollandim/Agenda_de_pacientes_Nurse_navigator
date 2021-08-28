package com.example.mestrado2kellyv10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mestrado2kellyv10.DAO.PacienteDAO;
import com.example.mestrado2kellyv10.modelo.Paciente;

public class NavegadorDoPacienteActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegador_do_paciente);

        PacienteDAO dao = new PacienteDAO(NavegadorDoPacienteActivity.this);
        int a = 1, b = 1;
        //Toast.makeText(NavegadorDoPacienteActivity.this,"->"+a,Toast.LENGTH_LONG).show();

        while (a < 10) {

            Paciente paciente = new Paciente();


            paciente.setNome("Paciente " + a);
            paciente.setMedico("Médico " + (a + 2));
            paciente.setCID("" + (a + 300));
            paciente.setIdade("" + (a + 20));
            paciente.setTelefone("9999-9999");

            if (a==1){paciente.setFoiinternado("Internado ");}
            if (a==4){paciente.setFoinoprontoatendimento(2+a);}
            if (a==7){paciente.setPequenosprocedimentosMotivos("Ortopedista ");}


            if (b >= 30) {
                b = 1;
            }
            paciente.setUltimaconsulta("" + b + "/05/" + (2000 + b));
            if ((a % 2) == 0) {
                paciente.setCarteira("Normal");
            } if ((a % 2) != 0) {
                paciente.setCarteira("Plus");
            }
            if (a==1){

            }

            dao.insere(paciente);
            a = a + 1;
            b = b + 1;
            //Toast.makeText(NavegadorDoPacienteActivity.this,"->"+a,Toast.LENGTH_LONG).show();
            dao.close();
        }

        //paciente.setNome("pedro");
        //Toast.makeText(NavegadorDoPacienteActivity.this, "->" + paciente.getNome(), Toast.LENGTH_LONG).show();

        //dao.insere(paciente);
        //dao.close();

        Button novoPaciente = (Button) findViewById(R.id.navegador_paciente_lista_clientes);
        novoPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irParaTelaDePacientes = new Intent(NavegadorDoPacienteActivity.this, ListaDeClientesActivity.class);
                startActivity(irParaTelaDePacientes);
            }
        });


        Button alertas = (Button) findViewById(R.id.navegador_paciente_sinais_alerta);
        alertas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irParaTelaAlertas = new Intent(NavegadorDoPacienteActivity.this, AlertasActivity.class);
                startActivity(irParaTelaAlertas);
            }
        });
    }


}
