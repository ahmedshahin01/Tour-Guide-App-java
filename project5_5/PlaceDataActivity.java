package com.example.ahmed.project5_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceDataActivity extends AppCompatActivity {
    PlacesInfo placesInfo;
    ImageView imageView;
    TextView nameText;
    TextView detailsText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_data);
        imageView = findViewById(R.id.place_image);
        nameText = findViewById(R.id.place_name);
        detailsText = findViewById(R.id.place_data);
        button = findViewById(R.id.location);
        placesInfo = (PlacesInfo)getIntent().getExtras().get("placesInfo");
        imageView.setImageResource(placesInfo.getImage());
        nameText.setText(placesInfo.getName());
        detailsText.setText(placesInfo.getPlaceData());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMap(placesInfo.getLocation().getUri());
            }
        });

    }
    private void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
