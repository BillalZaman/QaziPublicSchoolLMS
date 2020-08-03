package com.infotech4It.qazipublicschool.view.adapters;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.infotech4It.qazipublicschool.R;

import java.util.ArrayList;

/**
 * Created by Bilal Zaman on 02/08/2020.
 */
public class SpinnerAdapter extends ArrayAdapter<String> {

    private Context context;
    private ArrayList<String> data;

    public SpinnerAdapter(Context context, int textViewResourseID, ArrayList<String> value) {
        super(context, textViewResourseID, value);

        this.context = context;
        this.data = value;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // And the "magic" goes here
    // This is for the "passive" state of the spinner
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // I created a dynamic TextView here, but you can reference your own  custom layout for each spinner item
        TextView label = (TextView) super.getView(position, convertView, parent);
        label.setTextColor(Color.parseColor("#ffffff"));
        label.setGravity(View.TEXT_ALIGNMENT_TEXT_START|View.TEXT_ALIGNMENT_CENTER | Gravity.CENTER);
//        label.setGravity(Gravity.CENTER | View.TEXT_ALIGNMENT_VIEW_START);
        label.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.dropdown_icon, 0);
        label.setTextSize(12);

        // Then you can get the current item using the values array (Users array) and the current position
        // You can NOW reference each method you has created in your bean object (User class)
        label.setText(data.get(position));

        // And finally return your dynamic (or custom) view for each spinner item
        return label;
    }

    // And here is when the "chooser" is popped up
    // Normally is the same view, but you can customize it if you want
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.parseColor("#676767"));
        label.setText(data.get(position));
        label.setTextSize(14);
        label.setGravity(View.TEXT_ALIGNMENT_TEXT_START|View.TEXT_ALIGNMENT_CENTER | Gravity.CENTER);
        label.setPadding(30, 30, 30, 30);

        return label;
    }

}
