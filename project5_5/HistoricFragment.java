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

public class HistoricFragment extends Fragment {

    ArrayList<PlacesInfo> arrayList;
    ListView listView;
    PlacesAdapter placesAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_historic,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        arrayList=placesInfoEnter();
        placesAdapter = new PlacesAdapter(getContext(), arrayList);
        listView = view.findViewById(R.id.historic_list);
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
        arrayList.add(new PlacesInfo(getResources().getString(R.string.Pyramids),
                getResources().getString(R.string.Pyramids_data),
                R.drawable.pyramids,
                new Location(getResources().getString(R.string.pyramids_latitude),
                        getResources().getString(R.string.pyramids_Longitude))));
        arrayList.add(new PlacesInfo(getResources().getString(R.string.abu_smbel),
                getResources().getString(R.string.abu_smbel_description),
                R.drawable.abu_smbel,
                new Location(getResources().getString(R.string.abu_smbel_latitude),
                        getResources().getString(R.string.abu_smbel_Longitude))));


        arrayList.add(new PlacesInfo(getResources().getString(R.string.moez_street),
                getResources().getString(R.string.moez_street_data),
                R.drawable.moez_street,
                new Location(getResources().getString(R.string.moez_street_latitude),
                        getResources().getString(R.string.moez_street_Longitude))));

        return arrayList;
    }
}