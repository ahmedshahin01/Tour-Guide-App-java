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

public class HotelsFragment extends Fragment {
    ArrayList<PlacesInfo> arrayList;
    ListView listView;
    PlacesAdapter placesAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_hotels,null);

    }@Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        arrayList=placesInfoEnter();
        placesAdapter = new PlacesAdapter(getContext(), arrayList);
        listView = view.findViewById(R.id.hotels_list);
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
        arrayList.add(new PlacesInfo(getResources().getString(R.string.four_season),
                getResources().getString(R.string.four_season_data),
                R.drawable.four_seasons,
                new Location(getResources().getString(R.string.four_season_latitude),
                        getResources().getString(R.string.four_season_Longitude))));

        arrayList.add(new PlacesInfo(getResources().getString(R.string.pyramids_plaza),
                getResources().getString(R.string.pyramids_plaza_data),
                R.drawable.pyramids_plaza,
                new Location(getResources().getString(R.string.pyramids_plaza_latitude),
                        getResources().getString(R.string.pyramids_plaza_Longitude))));


        return arrayList;
    }
}