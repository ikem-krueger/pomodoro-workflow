package com.example.pomodoroworkflow;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Task> tasks = new ArrayList<>();
    MainAdapter mainAdapter = new MainAdapter(getTaskList(), MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(mainAdapter);

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(v -> {
            showAddDialog(v);
        });
    }

    private ArrayList<Task> getTaskList() {
        tasks.add(new Task("25", "focused work", "task"));
        tasks.add(new Task("5", "short break", "shortBreak"));

        return tasks;
    }

    public void showAddDialog(final View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Add Task");

        View viewInflated = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_dialog, (ViewGroup) findViewById(android.R.id.content), false);
        builder.setView(viewInflated);

        // Set up the input
        final EditText edittext_duration = viewInflated.findViewById(R.id.edittext_editactivity_duration);
        final EditText edittext_description = viewInflated.findViewById(R.id.edittext_editactivity_description);
        final CheckBox checkBox = viewInflated.findViewById(R.id.checkBox);

        // Set up the cancel button
        builder.setNegativeButton(getString(R.string.button_cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // Set up the update button
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                tasks.add(new Task("25", "focused work", "task"));

                if(checkBox.isChecked()) {
                    tasks.add(new Task("5", "short break", "shortBreak"));
                }

                mainAdapter.notifyDataSetChanged();

                dialog.dismiss();
            }
        });

        // Show dialog
        builder.show();
    }
}
