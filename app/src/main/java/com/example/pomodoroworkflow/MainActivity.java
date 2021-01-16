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

        MainAdapter mainAdapter = new MainAdapter(getMitgliederList(), getTaskList());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(mainAdapter);
    }

    private ArrayList<Task> getTaskList() {
        ArrayList<Task> tasks = new ArrayList<>();

        tasks.add(new Task());
        tasks.add(new ShortBreak());
        tasks.add(new Task());
        tasks.add(new ShortBreak());
        tasks.add(new Task());
        tasks.add(new ShortBreak());
        tasks.add(new Task());
        tasks.add(new LongBreak());

        return tasks;
    }

    private ArrayList<Mitglied> getMitgliederList() {
        ArrayList<Mitglied> mitgliederList = new ArrayList<>();

        mitgliederList.add(new Mitglied("Assmus", "Nico", "wandlitz"));
        mitgliederList.add(new Mitglied("Bassmus", "Nico", "wandlitz"));
        mitgliederList.add(new Mitglied("Cassmus", "Nico", "wandlitz"));
        mitgliederList.add(new Mitglied("Assmus", "Nico", "wandlitz"));
        mitgliederList.add(new Mitglied("Bassmus", "Nico", "wandlitz"));
        mitgliederList.add(new Mitglied("Cassmus", "Nico", "wandlitz"));
        mitgliederList.add(new Mitglied("Bassmus", "Nico", "wandlitz"));
        mitgliederList.add(new Mitglied("Cassmus", "Nico", "wandlitz"));

        return mitgliederList;
    }
}