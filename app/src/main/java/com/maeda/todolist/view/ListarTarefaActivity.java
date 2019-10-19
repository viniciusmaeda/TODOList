package com.maeda.todolist.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.maeda.todolist.R;

public class ListarTarefaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_tarefa);
    }

    public void novaTarefa(View view) {
        // redireciona pra tela que cadastra nova tarefa
        startActivity(new Intent(
                ListarTarefaActivity.this,
                CadastrarTarefaActivity.class));
    }

}
