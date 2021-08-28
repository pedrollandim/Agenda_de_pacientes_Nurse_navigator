package com.example.mestrado2kellyv10.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.example.mestrado2kellyv10.modelo.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteDAO extends SQLiteOpenHelper {
    public PacienteDAO(Context context) {

        super(context, "AgendaDePacientes", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Pacientes (id INTEGER PRIMARY KEY, nome TEXT NOT NULL," +
                "idade TEXT,medico TEXT,ultimaconsulta TEXT," +
                "carteira TEXT,telefone TEXT,CID TEXT,datadoagendamento TEXT," +
                "foinoprontoatendimento INTEGER,foiinternado TEXT," +
                "pequenosprocedimentosMotivos TEXT,evolucao TEXT,campoA INTERGER,campoNA TEXT," +
                "campoR TEXT,campoNR TEXT,campon TEXT,campoHAS TEXT,campoDM TEXT," +
                "campoDLP TEXT,campoICO TEXT,campoICC TEXT,campoIRC TEXT,contato TEXT);";
        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Pacientes";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Paciente paciente) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosDoPaciente(paciente);
        db.insert("Pacientes", null, dados);
    }


    public void altera(Paciente paciente) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosDoPaciente(paciente);
        String[] params = {String.valueOf(paciente.getId())};
        db.update("Pacientes", dados, "id = ?", params);
    }


    @NonNull
    private ContentValues pegaDadosDoPaciente(Paciente paciente) {
        ContentValues dados = new ContentValues();
        dados.put("nome", paciente.getNome());
        dados.put("telefone", paciente.getTelefone());
        dados.put("idade", paciente.getIdade());
        dados.put("medico", paciente.getMedico());
        dados.put("ultimaconsulta", paciente.getUltimaconsulta());
        dados.put("carteira", paciente.getCarteira());
        dados.put("CID", paciente.getCID());
        dados.put("datadoagendamento", paciente.getDatadoagendamento());
        dados.put("pequenosprocedimentosMotivos", paciente.getPequenosprocedimentosMotivos());
        dados.put("evolucao", paciente.getEvolucao());
        dados.put("campoA", paciente.getCampoA());
        dados.put("campoNA", paciente.getCampoNA());
        dados.put("campoR", paciente.getCampoR());
        dados.put("campoNR", paciente.getCampoNR());
        dados.put("campon", paciente.getCampon());
        dados.put("campoHAS", paciente.getCampoHAS());
        dados.put("campoDM", paciente.getCampoDM());
        dados.put("campoDLP", paciente.getCampoDLP());
        dados.put("campoICO", paciente.getCampoICO());
        dados.put("campoICC", paciente.getCampoICC());
        dados.put("campoIRC", paciente.getCampoIRC());
        dados.put("contato", paciente.getContato());

        dados.put("foinoprontoatendimento", paciente.getFoinoprontoatendimento());
        dados.put("foiinternado", paciente.getFoiinternado());

        return dados;
    }


    /*
        public void insere(Paciente paciente) {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues dados = pegaDadosDoPaciente(paciente);
            db.insert("Pacientes", null, dados);
        }

        public void altera(Paciente paciente) {
            SQLiteDatabase db = getWritableDatabase();

            ContentValues dados = pegaDadosDoPaciente(paciente);
            String[] params = {String.valueOf(paciente.getId())};

            db.update("Pacientes", dados, "id = ?", params);

        }

        @NonNull
        private ContentValues pegaDadosDoPaciente(Paciente paciente) {
            ContentValues dados = new ContentValues();
            dados.put("id", paciente.getId());
            dados.put("nome", paciente.getNome());
            dados.put("telefone", paciente.getTelefone());
            dados.put("idade", paciente.getIdade());
            dados.put("medico", paciente.getMedico());
            dados.put("ultimaconsulta", paciente.getUltimaconsulta());
            dados.put("carteira", paciente.getCarteira());
            dados.put("CID", paciente.getCID());
            dados.put("datadoagendamento", paciente.getDatadoagendamento());
            dados.put("pequenosprocedimentosMotivos", paciente.getPequenosprocedimentosMotivos());
            dados.put("evolucao", paciente.getEvolucao());
            dados.put("campoA", paciente.getCampoA());
            dados.put("campoNA", paciente.getCampoNA());
            dados.put("campoR", paciente.getCampoR());
            dados.put("campoNR", paciente.getCampoNR());
            dados.put("campon", paciente.getCampon());
            dados.put("campoHAS", paciente.getCampoHAS());
            dados.put("campoDM", paciente.getCampoDM());
            dados.put("campoDLP", paciente.getCampoDLP());
            dados.put("campoICO", paciente.getCampoICO());
            dados.put("campoICC", paciente.getCampoICC());
            dados.put("campoIRC", paciente.getCampoIRC());
            return dados;
            }
    */
    public List<Paciente> buscaPacientesCOREN() {

        String sql = "SELECT * from Pacientes;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Paciente> pacientes = new ArrayList<>();
        while (c.moveToNext()) {
            Paciente paciente = new Paciente();

            paciente.setId(c.getLong(c.getColumnIndex("id")));
            paciente.setNome(c.getString(c.getColumnIndex("nome")));
            paciente.setTelefone(c.getString(c.getColumnIndex("telefone")));
            paciente.setIdade(c.getString(c.getColumnIndex("idade")));
            paciente.setMedico(c.getString(c.getColumnIndex("medico")));
            paciente.setUltimaconsulta(c.getString(c.getColumnIndex("ultimaconsulta")));
            paciente.setCarteira(c.getString(c.getColumnIndex("carteira")));
            paciente.setCID(c.getString(c.getColumnIndex("CID")));
            paciente.setDatadoagendamento(c.getString(c.getColumnIndex("datadoagendamento")));
            paciente.setPequenosprocedimentosMotivos(c.getString(c.getColumnIndex("pequenosprocedimentosMotivos")));
            paciente.setEvolucao(c.getString(c.getColumnIndex("evolucao")));
            paciente.setCampoA(c.getString(c.getColumnIndex("campoA")));
            paciente.setCampoNA(c.getString(c.getColumnIndex("campoNA")));
            paciente.setCampoR(c.getString(c.getColumnIndex("campoR")));
            paciente.setCampoNR(c.getString(c.getColumnIndex("campoNR")));
            paciente.setCampon(c.getString(c.getColumnIndex("campon")));
            paciente.setCampoHAS(c.getString(c.getColumnIndex("campoHAS")));
            paciente.setCampoDM(c.getString(c.getColumnIndex("campoDM")));
            paciente.setCampoDLP(c.getString(c.getColumnIndex("campoDLP")));
            paciente.setCampoICO(c.getString(c.getColumnIndex("campoICO")));
            paciente.setCampoICC(c.getString(c.getColumnIndex("campoICC")));
            paciente.setCampoIRC(c.getString(c.getColumnIndex("campoIRC")));
            paciente.setContato(c.getString(c.getColumnIndex("contato")));

            paciente.setFoinoprontoatendimento(c.getInt(c.getColumnIndex("foinoprontoatendimento")));
            paciente.setFoiinternado(c.getString(c.getColumnIndex("foiinternado")));

            pacientes.add(paciente);

        }
        c.close();
        return pacientes;
    }


    public List<Paciente> buscadealertas() {

        String sql = "SELECT * from Pacientes;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Paciente> pacientes = new ArrayList<>();
        while (c.moveToNext()) {
            Paciente paciente = new Paciente();

            paciente.setId(c.getLong(c.getColumnIndex("id")));
            paciente.setNome(c.getString(c.getColumnIndex("nome")));
            paciente.setTelefone(c.getString(c.getColumnIndex("telefone")));
            paciente.setIdade(c.getString(c.getColumnIndex("idade")));
            paciente.setMedico(c.getString(c.getColumnIndex("medico")));
            paciente.setUltimaconsulta(c.getString(c.getColumnIndex("ultimaconsulta")));
            paciente.setCarteira(c.getString(c.getColumnIndex("carteira")));
            paciente.setCID(c.getString(c.getColumnIndex("CID")));
            paciente.setDatadoagendamento(c.getString(c.getColumnIndex("datadoagendamento")));
            paciente.setPequenosprocedimentosMotivos(c.getString(c.getColumnIndex("pequenosprocedimentosMotivos")));
            paciente.setEvolucao(c.getString(c.getColumnIndex("evolucao")));
            paciente.setCampoA(c.getString(c.getColumnIndex("campoA")));
            paciente.setCampoNA(c.getString(c.getColumnIndex("campoNA")));
            paciente.setCampoR(c.getString(c.getColumnIndex("campoR")));
            paciente.setCampoNR(c.getString(c.getColumnIndex("campoNR")));
            paciente.setCampon(c.getString(c.getColumnIndex("campon")));
            paciente.setCampoHAS(c.getString(c.getColumnIndex("campoHAS")));
            paciente.setCampoDM(c.getString(c.getColumnIndex("campoDM")));
            paciente.setCampoDLP(c.getString(c.getColumnIndex("campoDLP")));
            paciente.setCampoICO(c.getString(c.getColumnIndex("campoICO")));
            paciente.setCampoICC(c.getString(c.getColumnIndex("campoICC")));
            paciente.setCampoIRC(c.getString(c.getColumnIndex("campoIRC")));
            paciente.setContato(c.getString(c.getColumnIndex("contato")));

            paciente.setFoinoprontoatendimento(c.getInt(c.getColumnIndex("foinoprontoatendimento")));
            paciente.setFoiinternado(c.getString(c.getColumnIndex("foiinternado")));

            if (paciente.getPequenosprocedimentosMotivos()!=null ||
            paciente.getFoiinternado()!=null ||
            paciente.getFoinoprontoatendimento()>=2) {
               pacientes.add(paciente);
            }
        }
        c.close();
        return pacientes;
    }


}
