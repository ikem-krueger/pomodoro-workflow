package com.example.pomodoroworkflow;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private final MainActivity mainActivity;
    ArrayList<Task> taskList;

    public MainAdapter(ArrayList<Task> taskList, MainActivity mainActivity) {
        this.mainActivity = mainActivity;
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

        int taskColor = mainActivity.getResources().getColor(R.color.taskColor,null);
        int pauseColor = mainActivity.getResources().getColor(R.color.pauseColor,null);

        switch (task.getType()) {
            case "task":
                holder.view.setBackgroundColor(taskColor);
                holder.taskIcon.setImageResource(R.drawable.ic_alarm_black_22dp);

                break;
            case "shortBreak":
            case "longBreak":
                holder.view.setBackgroundColor(pauseColor);
                holder.taskIcon.setImageResource(R.drawable.ic_pause_black_44dp);

                break;
        }

        holder.taskDescription.setText(task.getDescription());
        holder.taskDuration.setText(task.getDuration() + " minutes");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Edit " + (task.getType().equals("task") ? "Task" : "Break"));

                View viewInflated = LayoutInflater.from(v.getContext()).inflate(R.layout.activity_dialog, (ViewGroup) v.findViewById(android.R.id.content), false);
                builder.setView(viewInflated);

                // Set up the input
                final EditText edittext_description = viewInflated.findViewById(R.id.edittext_editactivity_description);
                edittext_description.setText(task.getDescription());

                final EditText edittext_duration = viewInflated.findViewById(R.id.edittext_editactivity_duration);
                edittext_duration.setText(task.getDuration() + " minutes");

                final CheckBox checkBox = viewInflated.findViewById(R.id.checkBox);
                checkBox.setVisibility(View.GONE);

                // Set up the cancel button
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                // Set up the update button
                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        /*
                        taskList.add(new Task("25", "focused work", "task"));

                        if(checkBox.isChecked()) {
                            taskList.add(new Task("5", "short break", "shortBreak"));
                        }
                        */

                        notifyDataSetChanged();

                        dialog.dismiss();
                    }
                });

                // Show dialog
                builder.show();
           }
        });

        holder.itemView.setOnLongClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setTitle("Delete " + (task.getType().equals("task") ? "Task" : "Break"));

            builder.setMessage("Do you want to delete '" + task.getDescription() + "'" + "?");

            builder.setNegativeButton("Cancel", ((dialog, which) -> {
                dialog.cancel();
            }));

            builder.setPositiveButton("Delete", (dialog, which) -> {
                taskList.remove(position);

                notifyDataSetChanged();

                dialog.dismiss();
            });

            builder.show();

            return true; // NOTE: Why is here a return statement?
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {
        private final View view;
        private final ImageView taskIcon;
        private final TextView taskDescription;
        private final TextView taskDuration;

        public  MainViewHolder(View v) {
            super(v);

            view = v;
            taskIcon = v.findViewById(R.id.taskIcon);
            taskDescription = v.findViewById(R.id.taskDescription);
            taskDuration = v.findViewById(R.id.taskDuration);
        }
    }
}
