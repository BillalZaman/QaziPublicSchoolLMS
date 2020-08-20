package com.infotech4It.qazipublicschool.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.view.models.NavDrawerItem;

import java.util.Collections;
import java.util.List;

/**
 * Created by Bilal Zaman on 29,June,2019
 */

public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder> {
    List<NavDrawerItem> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;
    private int aditionalCount = 0;

    public NavigationDrawerAdapter(Context context, List<NavDrawerItem> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.nav_drawer_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        NavDrawerItem current = data.get(position);
        holder.title.setText(current.getTitle());
        holder.imgDrawerItem.setImageResource(current.getImgItem());
    }


    public void aditionalCount(int count) {
        aditionalCount = count;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        private ImageView imgDrawerItem, imageView34;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            imgDrawerItem = itemView.findViewById(R.id.imgDrawerItem);
        }
    }
}
