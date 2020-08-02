package com.infotech4It.qazipublicschool.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ItemListQuestionAnswerBinding;
import com.infotech4It.qazipublicschool.interfaces.FillBlankInterface;
import com.infotech4It.qazipublicschool.view.models.FillBlankModel;

import java.util.ArrayList;

/**
 * Created by Bilal Zaman on 29/07/2020.
 */
public class FillBlankAdapter extends RecyclerView.Adapter<FillBlankAdapter.ViewHolder> {
    private Context context;
    private ArrayList<FillBlankModel> data;
    private FillBlankInterface fillBlankInterface;

    public FillBlankAdapter(Context context, ArrayList<FillBlankModel> data) {
        this.context = context;
        this.data = data;
//        fillBlankInterface = (FillBlankInterface) context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListQuestionAnswerBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_question_answer, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setOnFillModel(data.get(position));
//        fillBlankInterface.authenticateAnswer(data.get(position).getAnswer(), position);
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemListQuestionAnswerBinding binding;

        public ViewHolder(@NonNull ItemListQuestionAnswerBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}

