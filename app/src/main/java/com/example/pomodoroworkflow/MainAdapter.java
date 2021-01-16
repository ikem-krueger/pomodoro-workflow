package com.example.pomodoroworkflow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    ArrayList<Task> taskList;

    public MainAdapter(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_main, parent, false);
        return new MainViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.taskDescriptionTV.setText(taskList.get(position).getDuration() + " min. " + taskList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {

        private TextView taskDescriptionTV;

        public  MainViewHolder(View v) {
            super(v);
            taskDescriptionTV = v.findViewById(R.id.taskDescriptionTV);
        }
    }


    // TODO restlichen Methoden implementieren
}
