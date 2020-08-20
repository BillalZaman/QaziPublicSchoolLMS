package com.infotech4It.qazipublicschool.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.view.models.Question;

import java.util.ArrayList;

public class QuizAdapter extends RecyclerView.Adapter<QuizViewHolder>{

    private ArrayList<Question> questions;
    private Context context;

    public QuizAdapter(Context context)
    {
        this.context = context;
    }

//    public QuizAdapter(ArrayList<Question> questions, Context context) {
//        this.questions = questions;
//        this.context = context;
//    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.quiz_item, parent, false);
        return new QuizViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {

//        holder.question.setText(questions.get(position).getQuestion());
//        holder.opA.setText(questions.get(position).getOpA());
//        holder.opB.setText(questions.get(position).getOpB());
//        holder.opC.setText(questions.get(position).getOpC());
//        holder.opD.setText(questions.get(position).getOpD());

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}

class QuizViewHolder extends RecyclerView.ViewHolder{

    TextView question, opA, opB, opC, opD;

    public QuizViewHolder(@NonNull View itemView) {
        super(itemView);

        question = itemView.findViewById(R.id.question);
        opA = itemView.findViewById(R.id.optionA);
        opB = itemView.findViewById(R.id.optionB);
        opC = itemView.findViewById(R.id.optionC);
        opD = itemView.findViewById(R.id.optionD);

    }
}
