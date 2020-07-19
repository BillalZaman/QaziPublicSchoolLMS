package com.infotech4It.qazipublicschool.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ItemListAllLessonsBinding;
import com.infotech4It.qazipublicschool.databinding.ItemListRecentAssessmentsBinding;
import com.infotech4It.qazipublicschool.view.models.AllLessonModel;
import com.infotech4It.qazipublicschool.view.models.RecentAssessmentModel;

import java.util.ArrayList;

/**
 * Created by Bilal Zaman on 18/07/2020.
 */
public class AllLessonAdapter extends RecyclerView.Adapter<AllLessonAdapter.ViewHolder> {

    private Context context;
    private ArrayList<AllLessonModel> data;

    public AllLessonAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
    }

    public void setList(ArrayList<AllLessonModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListAllLessonsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_all_lessons, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setOnAllLessonModel(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemListAllLessonsBinding binding;

        public ViewHolder(@NonNull ItemListAllLessonsBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}



