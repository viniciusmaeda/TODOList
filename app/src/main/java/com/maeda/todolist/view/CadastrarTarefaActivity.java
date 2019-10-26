package com.maeda.todolist.view;

import androidx.appcompat.app.AppCompatActivity;

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

    }

    public void salvarTarefa(View view) {

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

    }

}
