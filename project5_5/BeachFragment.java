package com.example.ahmed.project5_5;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class BeachFragment extends Fragment {

    ArrayList<PlacesInfo> arrayList;
    ListView listView;
    PlacesAdapter placesAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_beach,null);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        arrayList=placesInfoEnter();
        placesAdapter = new PlacesAdapter(getContext(), arrayList);
        listView = view.findViewById(R.id.beach_list);
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
        arrayList.add(new PlacesInfo(getResources().getString(R.string.alex),
                getResources().getString(R.string.alex_data),
                R.drawable.alex,
                new Location(getResources().getString(R.string.alex_latitude),
                        getResources().getString(R.string.alex_Longitude))));

        arrayList.add(new PlacesInfo(getResources().getString(R.string.horghada),
                getResources().getString(R.string.horghada_data),
                R.drawable.horghada,
                new Location(getResources().getString(R.string.horghada_latitude),
                        getResources().getString(R.string.horghada_Longitude))));


        arrayList.add(new PlacesInfo(getResources().getString(R.string.sharm_el_sheikh),
                getResources().getString(R.string.sharm_el_sheikh_data),
                R.drawable.sharm,
                new Location(getResources().getString(R.string.sharm_el_sheikh_latitude),
                        getResources().getString(R.string.sharm_el_sheikh_Longitude))));

        return arrayList;
    }
}