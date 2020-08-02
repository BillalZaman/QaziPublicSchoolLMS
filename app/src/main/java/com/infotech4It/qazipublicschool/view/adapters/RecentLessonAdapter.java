package com.infotech4It.qazipublicschool.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ItemListRecentLessonsBinding;
import com.infotech4It.qazipublicschool.view.activities.SubjectDetailActivity;
import com.infotech4It.qazipublicschool.view.models.RecentLessonModel;

import java.util.ArrayList;

/**
 * Created by Bilal Zaman on 18/07/2020.
 */
public class RecentLessonAdapter extends RecyclerView.Adapter<RecentLessonAdapter.ViewHolder> {

    private Context context;
    private ArrayList<RecentLessonModel> data;

    public RecentLessonAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
    }

    public void setList(ArrayList<RecentLessonModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListRecentLessonsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_recent_lessons, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setOnRecentLessonModel(data.get(position));

        holder.binding.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SubjectDetailActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemListRecentLessonsBinding binding;

        public ViewHolder(@NonNull ItemListRecentLessonsBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}

