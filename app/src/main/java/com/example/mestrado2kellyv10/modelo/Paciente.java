package com.example.mestrado2kellyv10.modelo;



import android.app.Application;

import java.io.Serializable;

public class Paciente extends Application implements Serializable{


    private long id;
    private String nome;
    private String idade;
    private String medico;
    private String ultimaconsulta;
    private String carteira;
    private String telefone;
    private String CID;
    private String datadoagendamento;

    private String pequenosprocedimentosMotivos;
    private String evolucao;

    private String campoA;
    private String campoNA;
    private String campoR;
    private String campoNR;
    private String campon;
    private String campoHAS;
    private String campoDM;
    private String campoDLP;
    private String campoICO;
    private String campoICC;
    private String campoIRC;

    private String contato;

    private String foiinternado;
    private int foinoprontoatendimento;

    public String getFoiinternado() {
        return foiinternado;
    }

    public void setFoiinternado(String foiinternado) {
        this.foiinternado = foiinternado;
    }

    public int getFoinoprontoatendimento() {
        return foinoprontoatendimento;
    }

    public void setFoinoprontoatendimento(int foinoprontoatendimento) {
        this.foinoprontoatendimento = foinoprontoatendimento;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCampoA() {
        return campoA;
    }

    public void setCampoA(String campoA) {
        this.campoA = campoA;
    }

    public String getCampoNA() {
        return campoNA;
    }

    public void setCampoNA(String campoNA) {
        this.campoNA = campoNA;
    }

    public String getCampoR() {
        return campoR;
    }

    public void setCampoR(String campoR) {
        this.campoR = campoR;
    }

    public String getCampoNR() {
        return campoNR;
    }

    public void setCampoNR(String campoNR) {
        this.campoNR = campoNR;
    }

    public String getCampon() {
        return campon;
    }

    public void setCampon(String campon) {
        this.campon = campon;
    }

    public String getCampoHAS() {
        return campoHAS;
    }

    public void setCampoHAS(String campoHAS) {
        this.campoHAS = campoHAS;
    }

    public String getCampoDM() {
        return campoDM;
    }

    public void setCampoDM(String campoDM) {
        this.campoDM = campoDM;
    }

    public String getCampoDLP() {
        return campoDLP;
    }

    public void setCampoDLP(String campoDLP) {
        this.campoDLP = campoDLP;
    }

    public String getCampoICO() {
        return campoICO;
    }

    public void setCampoICO(String campoICO) {
        this.campoICO = campoICO;
    }

    public String getCampoICC() {
        return campoICC;
    }

    public void setCampoICC(String campoICC) {
        this.campoICC = campoICC;
    }

    public String getCampoIRC() {
        return campoIRC;
    }

    public void setCampoIRC(String campoIRC) {
        this.campoIRC = campoIRC;
    }

    public String getPequenosprocedimentosMotivos() {
        return pequenosprocedimentosMotivos;
    }

    public void setPequenosprocedimentosMotivos(String pequenosprocedimentosMotivos) {
        this.pequenosprocedimentosMotivos = pequenosprocedimentosMotivos;
    }

    public String getEvolucao() {
        return evolucao;
    }

    public void setEvolucao(String evolucao) {
        this.evolucao = evolucao;
    }


    public String getDatadoagendamento() {
        return datadoagendamento;
    }

    public void setDatadoagendamento(String datadoagendamento) {
        this.datadoagendamento = datadoagendamento;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }


    public String getCarteira() {
        return carteira;
    }

    public void setCarteira(String carteira) {
        this.carteira = carteira;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getUltimaconsulta() {
        return ultimaconsulta;
    }

    public void setUltimaconsulta(String ultimaconsulta) {
        this.ultimaconsulta = ultimaconsulta;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    @Override
    public String toString() {

        return "-> " + getNome()+" °Consulta agendada para o dia: "+getDatadoagendamento();
    }


}
