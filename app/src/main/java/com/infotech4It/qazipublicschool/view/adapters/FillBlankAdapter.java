package com.infotech4It.qazipublicschool.view.adapters;

import android.content.Context;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ItemListQuestionAnswerBinding;
import com.infotech4It.qazipublicschool.helpers.PreferenceHelper;
import com.infotech4It.qazipublicschool.helpers.SpecialSharedPrefHelper;
import com.infotech4It.qazipublicschool.interfaces.FillBlankInterface;
import com.infotech4It.qazipublicschool.interfaces.PickingAnswerInterface;
import com.infotech4It.qazipublicschool.interfaces.PositionInterface;
import com.infotech4It.qazipublicschool.view.models.FillBlankModel;
import com.infotech4It.qazipublicschool.view.models.MCQsAnswerModel;
import com.infotech4It.qazipublicschool.view.models.McqlistModel;

import java.util.ArrayList;

/**
 * Created by Bilal Zaman on 29/07/2020.
 */
public class FillBlankAdapter extends RecyclerView.Adapter<FillBlankAdapter.ViewHolder> {
    private Context context;
    private ArrayList<FillBlankModel> data;
    private ArrayList<MCQsAnswerModel> arrayList;
    private PickingAnswerInterface pickingAnswerInterface;
    private TextWatcher textWatcher;

    private FillBlankInterface fillBlankInterface;
//    private PositionInterface positionInterface;

    public FillBlankAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
        pickingAnswerInterface = (PickingAnswerInterface) context;
//        positionInterface = (PositionInterface) context;
//        fillBlankInterface = (FillBlankInterface) context;
    }

    public void setList(ArrayList<FillBlankModel> data){
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListQuestionAnswerBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_question_answer, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.binding.setOnFillModel(data.get(position));
//        fillBlankInterface.authenticateAnswer(data.get(position).getAnswer(), position);

        int questionnumber = position+1;
        holder.binding.txtQuestion.setText(Html.fromHtml("Qno"+questionnumber+" : "+data.get(position).getqEng()));

             holder.binding.edtAnswer.addTextChangedListener(new TextWatcher() {
                 @Override
                 public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                     Toast.makeText(context, "1", Toast.LENGTH_SHORT).show();

                 }

                 @Override
                 public void onTextChanged(CharSequence s, int start, int before, int count) {
                     pickingAnswerInterface.pickingAnswer(data.get(position).getId(),
                             String.valueOf(s));
//                     Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
//                     Toast.makeText(context, "2", Toast.LENGTH_SHORT).show();
                 }

                 @Override
                 public void afterTextChanged(Editable s) {
//                     Toast.makeText(context, "13", Toast.LENGTH_SHORT).show();

                 }
             });


//        for (int i=0; i< data.size(); i++){
//            if (arrayList!=null) {
//                pickingAnswerInterface.pickingAnswer(data.get(position).getId(),
//                        holder.binding.edtAnswer.getText().toString());
//            }
//        }
//        positionInterface.position_(position, holder.binding.edtAnswer.getText().toString());
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

