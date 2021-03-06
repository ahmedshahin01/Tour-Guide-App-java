package com.example.ahmed.project5_5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class PlacesAdapter extends ArrayAdapter<PlacesInfo> {
    public PlacesAdapter(Context context, ArrayList<PlacesInfo> placesInfos) {
        super(context, 0, placesInfos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        PlacesInfo currentAttraction = getItem(position);

        ImageView imageView = listItemView.findViewById(R.id.list_image);
        imageView.setImageResource(currentAttraction.getImage());

        TextView miwokTextView = listItemView.findViewById(R.id.list_text);
        miwokTextView.setText(currentAttraction.getName());

        return listItemView;
    }

}
