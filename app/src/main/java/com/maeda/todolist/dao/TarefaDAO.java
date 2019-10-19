package com.maeda.todolist.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class TarefaDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public TarefaDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserirTarefa() {
    }

    public void obterTarefas() {
    }

    public void excluirTarefa() {
    }

    public void atualizarTarefa() {
    }


}
