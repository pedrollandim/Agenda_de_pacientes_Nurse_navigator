package com.example.mestrado2kellyv10;

import android.widget.EditText;
import android.widget.Switch;

import com.example.mestrado2kellyv10.modelo.Paciente;

public class ProntuarioHelper {

    private Paciente paciente;

    EditText dataagendamento;
    EditText pmotivos;
    EditText evolucao;

    Switch campoA;
    Switch campoNA;
    Switch campoR;
    Switch campoNR;
    Switch campon;
    Switch campoHAS;
    Switch campoDM;
    Switch campoDLP;
    Switch campoICO;
    Switch campoICC;
    Switch campoIRC;


    public ProntuarioHelper(ProntuarioActivity prontuarioActivity) {
        dataagendamento = (EditText) prontuarioActivity.findViewById(R.id.prontuario_paciente_TXT_4_data_do_agendamento);
        pmotivos = (EditText) prontuarioActivity.findViewById(R.id.prontuario_procedimentos_motivos_descricao);
        evolucao = (EditText) prontuarioActivity.findViewById(R.id.prontuario_paciente_evolucao_da_navegacao);

        campoA = (Switch) prontuarioActivity.findViewById(R.id.prontuario_plano_de_cuidados_1_A);
        campoNA = (Switch) prontuarioActivity.findViewById(R.id.prontuario_plano_de_cuidados_1_NA);
        campoR = (Switch) prontuarioActivity.findViewById(R.id.prontuario_plano_de_cuidados_2_R);
        campoNR = (Switch) prontuarioActivity.findViewById(R.id.prontuario_plano_de_cuidados_2_NR);
        campon = (Switch) prontuarioActivity.findViewById(R.id.prontuario_plano_de_cuidados_3_n);
        campoHAS = (Switch) prontuarioActivity.findViewById(R.id.prontuario_plano_de_cuidados_3_HAS);
        campoDM = (Switch) prontuarioActivity.findViewById(R.id.prontuario_plano_de_cuidados_3_DM);
        campoDLP = (Switch) prontuarioActivity.findViewById(R.id.prontuario_plano_de_cuidados_3_DLP);
        campoICO = (Switch) prontuarioActivity.findViewById(R.id.prontuario_plano_de_cuidados_3_ICO);
        campoICC = (Switch) prontuarioActivity.findViewById(R.id.prontuario_plano_de_cuidados_3_ICC);
        campoIRC = (Switch) prontuarioActivity.findViewById(R.id.prontuario_plano_de_cuidados_3_IRC);

        paciente = new Paciente();
    }


    public Paciente pegaPaciente(Paciente paciente) {


        paciente.setDatadoagendamento(dataagendamento.getText().toString());
        paciente.setPequenosprocedimentosMotivos(pmotivos.getText().toString());
        paciente.setEvolucao(evolucao.getText().toString());

        paciente.setCampoA(String.valueOf(campoA.isChecked()));
        paciente.setCampoA(String.valueOf(campoA.isChecked()));
        paciente.setCampoNA(String.valueOf(campoNA.isChecked()));
        paciente.setCampoR(String.valueOf(campoR.isChecked()));
        paciente.setCampoNR(String.valueOf(campoNR.isChecked()));
        paciente.setCampon(String.valueOf(campon.isChecked()));
        paciente.setCampoHAS(String.valueOf(campoHAS.isChecked()));
        paciente.setCampoDM(String.valueOf(campoDM.isChecked()));
        paciente.setCampoDLP(String.valueOf(campoDLP.isChecked()));
        paciente.setCampoICO(String.valueOf(campoICO.isChecked()));
        paciente.setCampoICC(String.valueOf(campoICC.isChecked()));
        paciente.setCampoIRC(String.valueOf(campoIRC.isChecked()));

        //paciente.setCampoIRC(campoIRC.isChecked());

        return paciente;
    }



    public void preencheFormulario(Paciente paciente) {

        dataagendamento.setText(paciente.getDatadoagendamento());
        pmotivos.setText(paciente.getPequenosprocedimentosMotivos());
        evolucao.setText(paciente.getEvolucao());

        campoA.setChecked(Boolean.parseBoolean(paciente.getCampoA()));
        campoNA.setChecked(Boolean.parseBoolean(paciente.getCampoNA()));
        campoR.setChecked(Boolean.parseBoolean(paciente.getCampoR()));
        campoNR.setChecked(Boolean.parseBoolean(paciente.getCampoNR()));
        campon.setChecked(Boolean.parseBoolean(paciente.getCampon()));
        campoHAS.setChecked(Boolean.parseBoolean(paciente.getCampoHAS()));
        campoDM.setChecked(Boolean.parseBoolean(paciente.getCampoDM()));
        campoDLP.setChecked(Boolean.parseBoolean(paciente.getCampoDLP()));
        campoICO.setChecked(Boolean.parseBoolean(paciente.getCampoICO()));
        campoICC.setChecked(Boolean.parseBoolean(paciente.getCampoICC()));
        campoIRC.setChecked(Boolean.parseBoolean(paciente.getCampoIRC()));

        //campoIRC.setChecked(paciente.getCampoIRC());

        this.paciente = paciente;
    }
}
/*
EditText dataagendamento = (EditText) findViewById(R.id.prontuario_paciente_TXT_4_data_do_agendamento);
        EditText pmotivos = (EditText) findViewById(R.id.prontuario_procedimentos_motivos_descricao);
        EditText evolucao = (EditText) findViewById(R.id.prontuario_paciente_evolucao_da_navegacao);

        Switch campoA = (Switch) findViewById(R.id.prontuario_plano_de_cuidados_1_A);
        Switch campoNA = (Switch) findViewById(R.id.prontuario_plano_de_cuidados_1_NA);
        Switch campoR = (Switch) findViewById(R.id.prontuario_plano_de_cuidados_2_R);
        Switch campoNR = (Switch) findViewById(R.id.prontuario_plano_de_cuidados_2_NR);
        Switch campon = (Switch) findViewById(R.id.prontuario_plano_de_cuidados_3_n);
        Switch campoHAS = (Switch) findViewById(R.id.prontuario_plano_de_cuidados_3_HAS);
        Switch campoDM = (Switch) findViewById(R.id.prontuario_plano_de_cuidados_3_DM);
        Switch campoDLP = (Switch) findViewById(R.id.prontuario_plano_de_cuidados_3_DLP);
        Switch campoICO = (Switch) findViewById(R.id.prontuario_plano_de_cuidados_3_ICO);
        Switch campoICC = (Switch) findViewById(R.id.prontuario_plano_de_cuidados_3_ICC);
        Switch campoIRC = (Switch) findViewById(R.id.prontuario_plano_de_cuidados_3_IRC);
 */