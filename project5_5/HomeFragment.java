package com.example.ahmed.project5_5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ahmed.project5_5.Location;
import com.example.ahmed.project5_5.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ArrayList<PlacesInfo> arrayList;
    ListView listView;
    PlacesAdapter placesAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_home,null);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);arrayList=placesInfoEnter();
        placesAdapter = new PlacesAdapter(getContext(), arrayList);
        listView = view.findViewById(R.id.home_list);
        listView.setAdapter(placesAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), PlaceDataActivity.class);
                intent.putExtra("placesInfo", arrayList.get(i));
                startActivity(intent);
            }
        });


    }
    private ArrayList<PlacesInfo> placesInfoEnter(){
        ArrayList<PlacesInfo>arrayList=new ArrayList<>();
        arrayList.add(new PlacesInfo(getResources().getString(R.string.Eygpt),
                getResources().getString(R.string.egypt_data),
                R.drawable.imagesegypt,
                new Location(getResources().getString(R.string.egypt_latitude),
                        getResources().getString(R.string.egypt_Longitude))));

        arrayList.add(new PlacesInfo(getResources().getString(R.string.Luxor),
                getResources().getString(R.string.loxer_data),
                R.drawable.luxor,
                new Location(getResources().getString(R.string.luxor_latitude),
                        getResources().getString(R.string.luxor_Longitude))));


        arrayList.add(new PlacesInfo(getResources().getString(R.string.aswan),
                getResources().getString(R.string.aswan_data),
                R.drawable.aswan,
                new Location(getResources().getString(R.string.aswan_latitude),
                        getResources().getString(R.string.aswan_Longitude))));

        arrayList.add(new PlacesInfo(getResources().getString(R.string.Egyptian_museum),
                getResources().getString(R.string.museum_data),
                R.drawable.museum,
                new Location(getResources().getString(R.string.museum_latitude),
                        getResources().getString(R.string.museum_Longitude))));


        return arrayList;
    }
}