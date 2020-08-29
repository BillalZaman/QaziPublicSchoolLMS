package com.infotech4It.qazipublicschool.view.adapters;

import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.QuizItemBinding;
import com.infotech4It.qazipublicschool.helpers.PreferenceHelper;
import com.infotech4It.qazipublicschool.helpers.SpecialSharedPrefHelper;
import com.infotech4It.qazipublicschool.interfaces.PickingAnswerInterface;
import com.infotech4It.qazipublicschool.view.models.MCQsAnswerModel;
import com.infotech4It.qazipublicschool.view.models.MCQsModel;
import com.infotech4It.qazipublicschool.view.models.Question;
import com.infotech4It.qazipublicschool.view.models.RecentAssessmentModel;

import java.util.ArrayList;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder>{

    private ArrayList<MCQsModel> data;
    private Context context;
    private ArrayList<MCQsAnswerModel> arrayList = new ArrayList<>();
    private PickingAnswerInterface pickingAnswerInterface;

    public QuizAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
        pickingAnswerInterface = (PickingAnswerInterface) context;
    }

    public void setList(ArrayList<MCQsModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        QuizItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.quiz_item, parent, false);
        return new QuizViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final QuizViewHolder holder, final int position) {
        holder.binding.setOnMcqModel(data.get(position));
        holder.binding.question.setText(Html.fromHtml(data.get(position).getqUrdu()));
        holder.binding.optionA.setText(Html.fromHtml(data.get(position).getOption1()));
        holder.binding.optionB.setText(Html.fromHtml(data.get(position).getOption2()));
        holder.binding.optionC.setText(Html.fromHtml(data.get(position).getOption3()));
        holder.binding.optionD.setText(Html.fromHtml(data.get(position).getOption4()));

        holder.binding.answerGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.optionA:{
                        pickingAnswerInterface.pickingAnswer(data.get(position).getId(),
                                holder.binding.optionA.getText().toString());
                        break;
                    }
                    case R.id.optionB:{
                        pickingAnswerInterface.pickingAnswer(data.get(position).getId(),
                                holder.binding.optionB.getText().toString());
                        break;
                    }
                    case R.id.optionC:{
                        pickingAnswerInterface.pickingAnswer(data.get(position).getId(),
                                holder.binding.optionC.getText().toString());
                        break;
                    }
                    case R.id.optionD:{
                        pickingAnswerInterface.pickingAnswer(data.get(position).getId(),
                                holder.binding.optionD.getText().toString());
                        break;
                    }

                }
            }
        });

//        SpecialSharedPrefHelper.getInstance().saveList(holder.binding.answerGroup);
//        holder.question.setText(questions.get(position).getQuestion());
//        holder.opA.setText(questions.get(position).getOpA());
//        holder.opB.setText(questions.get(position).getOpB());
//        holder.opC.setText(questions.get(position).getOpC());
//        holder.opD.setText(questions.get(position).getOpD());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class QuizViewHolder extends RecyclerView.ViewHolder{

        //    TextView question, opA, opB, opC, opD;
        QuizItemBinding binding;

        public QuizViewHolder(@NonNull QuizItemBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;

//        question = itemView.findViewById(R.id.question);
//        opA = itemView.findViewById(R.id.optionA);
//        opB = itemView.findViewById(R.id.optionB);
//        opC = itemView.findViewById(R.id.optionC);
//        opD = itemView.findViewById(R.id.optionD);

        }
    }
}
