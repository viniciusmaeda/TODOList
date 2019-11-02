package com.maeda.todolist.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.maeda.todolist.R;
import com.maeda.todolist.dao.TarefaDAO;
import com.maeda.todolist.model.Tarefa;

public class CadastrarTarefaActivity extends AppCompatActivity {

    // objetos correspondentes aos componentes da Activity
    private EditText campoTarefa;
    private EditText campoDescricao;
    private EditText campoData;
    private EditText campoHora;

    // objeto para acessar ao BD
    private TarefaDAO tarefaDAO;

    // objeto referente à Tarefa
    private Tarefa tarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_tarefa);

        // relacionar os objetos com os componentes
        campoTarefa = (EditText) findViewById(R.id.cadastrar_tarefa_edt_tarefa);
        campoDescricao = (EditText) findViewById(R.id.cadastrar_tarefa_edt_descricao);
        campoData = (EditText) findViewById(R.id.cadastrar_tarefa_edt_data);
        campoHora = (EditText) findViewById(R.id.cadastrar_tarefa_edt_hora);

        // instanciar o objeto que estabelece a conexão com o BD
        tarefaDAO = new TarefaDAO(this);

        // define um intent para possivelmente resgatar algo
        Intent intent = getIntent();

        // verificar se veio alguma intent de outra Activity
        if (intent.hasExtra("tarefa")) {
            tarefa = (Tarefa) intent.getSerializableExtra("tarefa");

            // preencher os campos do formulário para edição
            campoTarefa.setText(tarefa.getTarefa());
            campoDescricao.setText(tarefa.getDescricao());
            campoData.setText(tarefa.getData());
            campoHora.setText(tarefa.getHora());
        }

    }

    public void salvarTarefa(View view) {

        // verificar se é edição ou novo registro
        if (tarefa == null) { // novo registro
            tarefa = new Tarefa();

            // obter os dados do formulários e salvar no objeto
            tarefa.setTarefa(campoTarefa.getText().toString().trim());
            tarefa.setDescricao(campoDescricao.getText().toString().trim());
            tarefa.setData(campoData.getText().toString().trim());
            tarefa.setHora(campoHora.getText().toString().trim());

            // salvar no BD, recebendo o ID da tarefa
            long id = tarefaDAO.inserirTarefa(tarefa);

            // informar o usuário que foi salvo
            Toast.makeText(this,
                    "Tarefa criada com sucesso. Id: " + id,
                    Toast.LENGTH_LONG).show();

        } else { // atualizar registro existente

            // obter os dados do formulários e salvar no objeto
            tarefa.setTarefa(campoTarefa.getText().toString().trim());
            tarefa.setDescricao(campoDescricao.getText().toString().trim());
            tarefa.setData(campoData.getText().toString().trim());
            tarefa.setHora(campoHora.getText().toString().trim());

            // atualizar os dados no BD
            tarefaDAO.atualizarTarefa(tarefa);

            // emitir mensagem de sucesso
            Toast.makeText(this,
                    "Tarefa atualizada com sucesso!",
                    Toast.LENGTH_LONG).show();

        }

    }

}
