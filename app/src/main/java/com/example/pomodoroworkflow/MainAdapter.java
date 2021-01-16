package com.example.pomodoroworkflow;

import android.graphics.Color;
import android.util.TypedValue;
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

        if(task.getClass() == Task.class) {
            holder.view.setBackgroundColor(Color.parseColor("#ED5755"));
        } else if(task.getClass() == ShortBreak.class) {
            holder.view.setBackgroundColor(Color.parseColor("#779C74"));
            holder.taskIcon.setImageResource(R.drawable.ic_pause_black_44dp);
            holder.taskIcon.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 36, holder.taskIcon.getContext().getResources().getDisplayMetrics());
        } else if (task.getClass() == LongBreak.class) {
            holder.view.setBackgroundColor(Color.parseColor("#779C74"));
            holder.taskIcon.setImageResource(R.drawable.ic_pause_black_44dp);
            holder.taskIcon.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, holder.taskIcon.getContext().getResources().getDisplayMetrics());
        }

        holder.taskDescription.setText(task.getDuration() + " min. " + task.getDescription());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {

        private View view;
        private ImageView taskIcon;
        private TextView taskDescription;

        public  MainViewHolder(View v) {
            super(v);

            view = v;
            taskIcon = v.findViewById(R.id.taskIcon);
            taskDescription = v.findViewById(R.id.taskDescription);
        }
    }
}
