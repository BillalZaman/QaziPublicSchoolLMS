package com.infotech4It.qazipublicschool.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ItemListMcqsBinding;
import com.infotech4It.qazipublicschool.view.models.MCQsAnswerModel;
import com.infotech4It.qazipublicschool.view.models.MCQsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bilal Zaman on 27/07/2020.
 */
public class McqsAdapters extends RecyclerView.Adapter<McqsAdapters.ViewHolder> {
    private Context context;
    private ArrayList<MCQsModel> data;

    public McqsAdapters(Context context, ArrayList<MCQsModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListMcqsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
        R.layout.item_list_mcqs,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setMcqsMOdel(data.get(position));

        if (holder.binding.getMcqsMOdel().getAnswerModelList()!=null){

            for (int i=0; i<=data.get(position).getAnswerModelList().size(); i++ ){
                addRadioButtons(holder.binding.radioGroupAnsw, data.get(position).getAnswerModelList());
//                holder.binding.radioAnswer.setText(data.get(position).getAnswerModelList().get(position).getMcqsAnswer());
            }
        }
    }

    private void addRadioButtons(RadioGroup quizOptionsRadioGroup,
                                 List<MCQsAnswerModel> optionList) {

        final RadioButton[] radioButtons = new RadioButton[optionList.size()];

        for (int i = 0; i < optionList.size(); i++) {
            radioButtons[i] = new RadioButton(context);
            radioButtons[i].setText(optionList.get(i).getMcqsAnswer());
            quizOptionsRadioGroup.addView(radioButtons[i]);
        }
    }

        @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemListMcqsBinding binding;
        public ViewHolder(@NonNull ItemListMcqsBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
