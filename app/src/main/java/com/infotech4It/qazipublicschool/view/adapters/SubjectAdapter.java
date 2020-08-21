package com.infotech4It.qazipublicschool.view.adapters;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ItemListSubjectsBinding;
import com.infotech4It.qazipublicschool.helpers.PreferenceHelper;
import com.infotech4It.qazipublicschool.interfaces.SubjectListInterface;
import com.infotech4It.qazipublicschool.view.models.StudentSubjectModel;
import com.infotech4It.qazipublicschool.view.models.SubjectModel;

import java.util.ArrayList;

import constants.Constants;

/**
 * Created by Bilal Zaman on 18/07/2020.
 */
public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.ViewHolder> {

    private Context context;
    private ArrayList<StudentSubjectModel> data;
    private SubjectListInterface subjectListInterface;
    int widthdp, heightdp;

    public SubjectAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
        subjectListInterface = (SubjectListInterface) context;
        widthdp = (int) (144.5 * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
        heightdp = (int) (102.2 * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));

    }

    public void setList(ArrayList<StudentSubjectModel> data){
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListSubjectsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_subjects, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.binding.setOnSubjectModel(data.get(position));
        Glide.with(context).load(data.get(position).getImage())
                .apply(new RequestOptions().override(widthdp, heightdp)).placeholder(R.drawable.islamiat)
                .into(holder.binding.imgSubjectIcon1);
        holder.binding.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subjectListInterface.onSubjectList(position, data.get(position).getName());
                PreferenceHelper.getInstance().setInt(Constants.subjectID, data.get(position).getId());
                PreferenceHelper.getInstance().setString(Constants.subjectName, data.get(position).getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemListSubjectsBinding binding;
        public ViewHolder(@NonNull ItemListSubjectsBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
