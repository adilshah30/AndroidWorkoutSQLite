package com.adilshah.adil.androidworkoutsqlite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by adil on 10/02/2018.
 */

public class CustomAdapter extends ArrayAdapter<String> {

    String[] foods ;
    String[] food_description ;
    int[] food_imgs;



    public CustomAdapter(Context context, String[] foods , int[] food_imgs,String[] food_description) {
        super(context, R.layout.custom_list_view_row, foods);
        this.foods= foods;
        this.food_imgs = food_imgs;
        this.food_description = food_description;
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        LayoutInflater customlistviewInflater = LayoutInflater.from(getContext());

        View customlistviewrow =  customlistviewInflater.inflate(R.layout.custom_list_view_row,parent,false);

        //String SingleFoodItem = getItem(position);


        TextView tvFoodName = (TextView) customlistviewrow.findViewById(R.id.tvFoodName);
        TextView tvFoodDescription = (TextView) customlistviewrow.findViewById(R.id.tvFoodDescription);
        ImageView imgviewFood = (ImageView) customlistviewrow.findViewById(R.id.imgviewFood);


        tvFoodName.setText(foods[position]);
        tvFoodDescription.setText(food_description[position]);
        imgviewFood.setImageResource(food_imgs[position]);
        return  customlistviewrow;

    }
}
