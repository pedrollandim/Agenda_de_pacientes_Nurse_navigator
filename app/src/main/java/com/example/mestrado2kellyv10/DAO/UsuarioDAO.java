package com.example.mestrado2kellyv10.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.example.mestrado2kellyv10.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends SQLiteOpenHelper {

    public UsuarioDAO(Context context) {

        super(context, "AgendaDeUsuarios", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Usuarios (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, senha TEXT NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Usuarios";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insereUsuario(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosDoEnfermeiro(usuario);
        db.insert("Usuarios", null,dados);
    }

    @NonNull
    private ContentValues pegaDadosDoEnfermeiro(Usuario usuario) {
        ContentValues dados = new ContentValues();
        dados.put("nome",usuario.getNome());
        dados.put("senha",usuario.getSenha());
        return dados;
    }




    public List<Usuario> buscaUsuario() {
        String sql = "SELECT * from Usuarios;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Usuario> usuarios = new ArrayList<>();
        while(c.moveToNext()){
            Usuario usuario= new Usuario();
            usuario.setId(c.getLong(c.getColumnIndex("id")));
            usuario.setNome(c.getString(c.getColumnIndex("nome")));
            usuario.setSenha(c.getString(c.getColumnIndex("senha")));
            usuarios.add(usuario);
        }
        c.close();
        return usuarios;
    }

    public void deletaUsuario(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {String.valueOf(usuario.getId())};
        db.delete("Usuarios","id = ?",params);
    }

    public void alteraUsuario(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosDoEnfermeiro(usuario);
        String[] params ={String.valueOf(usuario.getId())};

        db.update("Usuarios",dados,"id = ?",params);

    }


    public String verificarUsuario(String nome, String senha) {
        String sql = "SELECT * FROM Usuarios;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);
        String nome1;
        String senha1;
        while (c.moveToNext()){
            nome1 = c.getString(c.getColumnIndex("nome"));
            senha1 = c.getString(c.getColumnIndex("senha"));
            if (nome.equals(nome1)){
                    if (senha.equals(senha1)){
                        return "usuariocadastrado";
                    }
            }
        }
        return  "usuarionaocadastrado";
    }
}


