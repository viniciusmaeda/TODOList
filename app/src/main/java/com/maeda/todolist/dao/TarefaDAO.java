package com.maeda.todolist.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.maeda.todolist.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

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

    public List<Tarefa> obterTarefas() {

        // objeto que recebe os registros do BD
        List<Tarefa> tarefas = new ArrayList<>();

        // objeter os dados do BD
        Cursor cursor = banco.query(
                "tarefa",
                new String[]{"id", "tarefa", "descricao", "data", "hora"},
                null,
                null,
                null,
                null,
                null
        );

        // loop para percorrer os registros
        while (cursor.moveToNext()) {
            Tarefa tarefa = new Tarefa();

            // transformando o registro num objeto
            tarefa.setId(cursor.getInt(0));
            tarefa.setTarefa(cursor.getString(1));
            tarefa.setDescricao(cursor.getString(2));
            tarefa.setData(cursor.getString(3));
            tarefa.setHora(cursor.getString(4));

            // adicionar a tarefa à lista de tarefas
            tarefas.add(tarefa);
        }

        // retornar a lista de tarefas
        return tarefas;
    }

    public void excluirTarefa() {
    }

    public void atualizarTarefa() {
    }


}
