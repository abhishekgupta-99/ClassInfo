package com.abhishek.SEM6.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abhishek.SEM6.R;
import com.abhishek.SEM6.models.Subject_db;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * Created by abhishek on 3/2020.
 */

public class SubjectAdapter_db extends RecyclerView.Adapter<SubjectAdapter_db.ViewHolder> {

    public ArrayList<Subject_db> subjects;
    private Context context;
    private LayoutInflater layoutInflater;
    String chiptype;
    int num;
    View v;

    public SubjectAdapter_db(ArrayList<Subject_db> subjects, Context context,String chiptype,int num,View v) {
        this.subjects = subjects;
        this.context = context;
        this.chiptype = chiptype;
        this.num = num;
        this.v = v;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public SubjectAdapter_db(ArrayList<Subject_db> subjects, Context context,String chiptype,int num) {
        this.subjects = subjects;
        this.context = context;
        this.chiptype = chiptype;
        this.num = num;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.single_subject, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.recyclerView.setAdapter(new BookAdapter_db(context, subjects.get(position).books,subjects.get(position).subjectName,num,v));
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setHasFixedSize(true);

        //Toast.makeText(context, subjects.get(position).subjectName+" : BOOK", Toast.LENGTH_SHORT).show();
        holder.tvHeading.setText(subjects.get(position).subjectName);
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    public void clear() {
        subjects.clear();
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        TextView tvHeading;

        public ViewHolder(View itemView) {
            super(itemView);

            recyclerView = itemView.findViewById(R.id.rvChapters);
            tvHeading = itemView.findViewById(R.id.tvSubjectName);
        }
    }
}
