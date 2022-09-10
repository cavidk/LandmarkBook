package com.example.landmarkbook;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;


import com.example.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {


    ArrayList<Landmark> landmarkArrayList;
    private ActivityMainBinding binding;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        landmarkArrayList = new ArrayList<>();

        //Data
       Landmark pisa = new Landmark("Pisa","Italy", R.drawable.pisa);
       Landmark eiffel = new Landmark("Eiffel","France", R.drawable.eiffel);
       Landmark colosseum = new Landmark("Collesium","Italy", R.drawable.collessium);
       Landmark londonBridge = new Landmark("London Bridge","United Kingdom", R.drawable.londonbridge);


        landmarkArrayList.add(pisa);
        landmarkArrayList.add(eiffel);
        landmarkArrayList.add(colosseum);
        landmarkArrayList.add(londonBridge);

        //Click event

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);


/*   => List view Step (Trying to do with ListView||
      //Adapter =>> veri kaynagiyla XML ve listView bir-birine baglayan yapi;
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                landmarkArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList())
        );
        binding.listView.setAdapter(arrayAdapter);

        //Onclick to shows a way to event for swipe another page or schema
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //Toast.makeText(MainActivity.this,landmarkArrayList.get(i).name,Toast.LENGTH_LONG).show();


          // Intent -> messaging object you can use to request an action from another app component.
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                   intent.putExtra("landmark",landmarkArrayList.get(position));
                   startActivity(intent);
            }
        }); */
    }

}