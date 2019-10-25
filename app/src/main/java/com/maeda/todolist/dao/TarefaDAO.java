package com.maeda.todolist.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.maeda.todolist.model.Tarefa;

public class TarefaDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public TarefaDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserirTarefa(Tarefa tarefa) {

        // objeto contendo os valores para salvar no BD
        ContentValues values = new ContentValues();

        // colocar os valores
        values.put("tarefa", tarefa.getTarefa());
        values.put("descricao", tarefa.getDescricao());
        values.put("data", tarefa.getData());
        values.put("hora", tarefa.getHora());

        // insere no BD e retorna com o novo ID
        return banco.insert("tarefa", null, values);
    }

    public void obterTarefas() {
    }

    public void excluirTarefa() {
    }

    public void atualizarTarefa() {
    }


}
