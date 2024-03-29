package com.infotech4It.qazipublicschool.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ItemListCommentingBinding;
import com.infotech4It.qazipublicschool.view.models.CommentingModel;

import java.util.ArrayList;

/**
 * Created by Bilal Zaman on 28/07/2020.
 */
public class CommentingAdapter extends RecyclerView.Adapter<CommentingAdapter.ViewHolder>{
    private Context context;
    private ArrayList<CommentingModel> data;

    public CommentingAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
    }

    public void setData(ArrayList<CommentingModel> data){
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListCommentingBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_commenting, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setOnCommentMOdel(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemListCommentingBinding binding;
        public ViewHolder(@NonNull ItemListCommentingBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
