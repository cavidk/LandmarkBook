package com.example.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.landmarkbook.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);



        //Intent intent = getIntent();
        //Casting
        //Landmark selectedLandmark =(Landmark) intent.getSerializableExtra("landmark");

        Singleton singleton = Singleton.getInstance();

        //LandmarkAdapter(class)<< >>  icerisinde neyi "set" etdiysek onu bize <return> etmek ucun istifade olunur!
        Landmark selectedLandmark = singleton.getSentLandmark();

        //Here we get alttext view of selected item
        binding.countryText.setText(selectedLandmark.name);
        binding.mainText.setText(selectedLandmark.name);
        binding.imageView.setImageResource(selectedLandmark.image);

    }
}