package com.example.pomodoroworkflow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        Task task = taskList.get(position);

        int taskColor = holder.view.getResources().getColor(R.color.taskColor,null);
        int pauseColor = holder.view.getResources().getColor(R.color.pauseColor,null);

        switch (task.getType()) {
            case "task":
                holder.view.setBackgroundColor(taskColor);

                break;
            case "shortBreak":
            case "longBreak":
                holder.view.setBackgroundColor(pauseColor);
                holder.taskIcon.setImageResource(R.drawable.ic_pause_black_44dp);

                break;
        }

        holder.taskDescription.setText(task.getDescription());
        holder.taskDuration.setText(task.getDuration() + " minutes");
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {
        private final View view;
        private final ImageView taskIcon;
        private final TextView taskDuration;
        private final TextView taskDescription;

        public  MainViewHolder(View v) {
            super(v);

            view = v;
            taskIcon = v.findViewById(R.id.taskIcon);
            taskDescription = v.findViewById(R.id.taskDescription);
            taskDuration = v.findViewById(R.id.taskDuration);
        }
    }
}
