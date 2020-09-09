package com.infotech4It.qazipublicschool.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ItemListImageBinding;
import com.infotech4It.qazipublicschool.view.models.ListImageModel;

import java.util.ArrayList;

/**
 * Created by Bilal Zaman on 02/09/2020.
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ListImageModel> data;
    private ItemListImageBinding binding;

    public ImageAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
    }

    public void setData(ArrayList<ListImageModel> data){
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_image, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setOnImageMOdel(data.get(position));
//        for (int x = 0; x <= data.size(); x++) {
//            Glide.with(context).load(data.get(position).getImage().get(position)).into(binding.imgTask);
//        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemListImageBinding binding;

        public ViewHolder(@NonNull ItemListImageBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
