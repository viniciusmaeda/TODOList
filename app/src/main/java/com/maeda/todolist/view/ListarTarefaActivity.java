package com.maeda.todolist.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.maeda.todolist.R;
import com.maeda.todolist.dao.TarefaDAO;
import com.maeda.todolist.model.Tarefa;

import java.util.List;

public class ListarTarefaActivity extends AppCompatActivity {

    // objeto que será utilizado para vincular com o componete da Activity
    ListView listaTarefas;

    // objeto para acessar o BD
    TarefaDAO tarefaDAO;

    // objeto para listar os registros do BD
    List<Tarefa> tarefas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_tarefa);

        // vincular o objeto com o componente
        listaTarefas = (ListView) findViewById(R.id.listar_tarefa_ltv_tarefas);

        // instanciar objeto que cria conexão com o BD
        tarefaDAO = new TarefaDAO(this);

        // consultar os registros do BD
        tarefas = tarefaDAO.obterTarefas();

        // adaptador para atribuir os valores no ListView
        ArrayAdapter adptador =  new ArrayAdapter<Tarefa>(
                this,
                android.R.layout.simple_list_item_1,
                tarefas
        );

        // atribuir os valores à ListView
        listaTarefas.setAdapter(adptador);

        // registro pra dizer que o menu deve ser criado
        registerForContextMenu(listaTarefas);

    }

    public void novaTarefa(View view) {
        // redireciona pra tela que cadastra nova tarefa
        startActivity(new Intent(
                ListarTarefaActivity.this,
                CadastrarTarefaActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();

        // consultar os registros do BD
        tarefas = tarefaDAO.obterTarefas();

        // adaptador para atribuir os valores no ListView
        ArrayAdapter adptador =  new ArrayAdapter<Tarefa>(
                this,
                android.R.layout.simple_list_item_1,
                tarefas
        );

        // atribuir os valores à ListView
        listaTarefas.setAdapter(adptador);
    }

    // método usado para criar o menu de contexto
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();


        menuInflater.inflate(R.menu.menu_contexto, menu);
    }

    // método para editar uma tarefa
    public void editarTarefa(MenuItem item) {

    }

    // método para excluir uma tarefa
    public void excluirTarefa(MenuItem item) {

    }

}
