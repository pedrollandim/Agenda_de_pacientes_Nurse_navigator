package com.example.mestrado2kellyv10.modelo;

import android.app.Application;

import java.io.Serializable;

public class Prontuario extends Application implements Serializable {


    private String nomepaciente;
    private String nomemedico;
    private String ultimaconsulta;
    private String motivo;

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNomepaciente() {
        return nomepaciente;
    }

    public void setNomepaciente(String nomepaciente) {
        this.nomepaciente = nomepaciente;
    }

    public String getNomemedico() {
        return nomemedico;
    }

    public void setNomemedico(String nomemedico) {
        this.nomemedico = nomemedico;
    }

    public String getUltimaconsulta() {
        return ultimaconsulta;
    }

    public void setUltimaconsulta(String ultimaconsulta) {
        this.ultimaconsulta = ultimaconsulta;
    }

    @Override
    public String toString() {

        return "->Médico: " + getNomemedico();
    }


}
