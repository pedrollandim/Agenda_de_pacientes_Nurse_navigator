package com.example.mestrado2kellyv10.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.example.mestrado2kellyv10.modelo.Paciente;
import com.example.mestrado2kellyv10.modelo.Prontuario;

import java.util.ArrayList;
import java.util.List;

public class ProntuarioDAO extends SQLiteOpenHelper{
    public ProntuarioDAO(Context context) {

        super(context, "Prontuario2", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Prontuario (id INTEGER PRIMARY KEY, nomepa TEXT," +
                "medico TEXT,ultimaconsulta TEXT,motivo TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Prontuario";
        db.execSQL(sql);
        onCreate(db);
    }

     public List<Prontuario> buscaProntuario() {

        String sql = "SELECT * from Prontuario;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);


        List<Prontuario> prontuarios = new ArrayList<>();

        int a=0;
        while (a<11){
            Prontuario prontuario= new Prontuario();
            prontuario.setNomemedico("sabado "+a);
            prontuario.setNomepaciente("Sexta feira "+a);
            prontuarios.add(prontuario);
            a=a+1;
        }

        c.close();
        return prontuarios;
    }





}
