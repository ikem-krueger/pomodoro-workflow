package com.example.pomodoroworkflow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    ArrayList<Mitglied> mitgliederList;
    ArrayList<Task> taskList;

    public MainAdapter(ArrayList<Mitglied> mitgliederList, ArrayList<Task> taskList) {
        this.mitgliederList = mitgliederList;
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
        //holder.vornameTV.setText(mitgliederList.get(position).getVorname());
        //holder.wohnOrtTV.setText(mitgliederList.get(position).getWohnort());
        holder.nameTV.setText(taskList.get(position).getDuration() + " min. " + taskList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mitgliederList.size();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTV, vornameTV, wohnOrtTV;

        public  MainViewHolder(View v) {
            super(v);
            nameTV = v.findViewById(R.id.nachnameTV);
            vornameTV = v.findViewById(R.id.vornameTV);
            wohnOrtTV = v.findViewById(R.id.wohnOrtTV);
        }
    }


    // TODO restlichen Methoden implementieren
}
