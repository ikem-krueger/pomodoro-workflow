package com.example.pomodoroworkflow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Task> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        MainAdapter mainAdapter = new MainAdapter(getTaskList());
        recyclerView.setAdapter(mainAdapter);

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(v -> {
            tasks.add(new Task("25", "focused work", "task"));
            tasks.add(new Task("5", "short break", "shortBreak"));

            mainAdapter.notifyDataSetChanged();
        });
    }

    private ArrayList<Task> getTaskList() {
        tasks.add(new Task("25", "focused work", "task"));
        tasks.add(new Task("5", "short break", "shortBreak"));

        return tasks;
    }
}
