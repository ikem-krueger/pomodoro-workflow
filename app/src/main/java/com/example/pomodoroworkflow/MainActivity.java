package com.example.pomodoroworkflow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        MainAdapter mainAdapter = new MainAdapter(getTaskList());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(mainAdapter);
    }

    private ArrayList<Task> getTaskList() {
        ArrayList<Task> tasks = new ArrayList<>();

        tasks.add(new Task("25", "focused work", "task"));
        tasks.add(new Task("5", "short break", "shortBreak"));
        tasks.add(new Task("25", "focused work", "task"));
        tasks.add(new Task("5", "short break", "shortBreak"));
        tasks.add(new Task("25", "focused work", "task"));
        tasks.add(new Task("5", "short break", "shortBreak"));
        tasks.add(new Task("25", "focused work", "task"));
        tasks.add(new Task("30", "long break", "longBreak"));

        return tasks;
    }
}
