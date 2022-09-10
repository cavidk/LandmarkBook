package com.example.landmarkbook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.landmarkbook.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder>{

    ArrayList<Landmark> landmarkArrayList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHolder(recyclerRowBinding);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull LandmarkAdapter.LandmarkHolder holder, int position) {
        holder.bindig.recyclerViewTextView.setText(landmarkArrayList.get(position).name);


       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(holder.itemView.getContext(),DetailsActivity.class);
               //intent.putExtra("landMark", landmarkArrayList.get(position));

               Singleton singleton = Singleton.getInstance();
               singleton.setSentLandmark(landmarkArrayList.get(position));
               holder.itemView.getContext().startActivity(intent);

           }
       });
    }

    @Override
    public int getItemCount() {
        return landmarkArrayList.size();
    }

      //Landmark Holder another part
    public class LandmarkHolder extends RecyclerView.ViewHolder {

       private RecyclerRowBinding bindig;


        public LandmarkHolder(RecyclerRowBinding bindig) {
            super(bindig.getRoot());
            this.bindig = bindig;
        }
    }
}
