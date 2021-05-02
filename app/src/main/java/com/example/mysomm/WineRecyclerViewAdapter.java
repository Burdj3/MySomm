package com.example.mysomm;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class WineRecyclerViewAdapter extends RecyclerView.Adapter<WineRecyclerViewAdapter.ViewHolder>{

    private ArrayList<Wine> wines = new ArrayList<>();
    private Context context;

    public WineRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wine_list_item, parent, false);
        ViewHolder holder = new ViewHolder((view));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtWine.setText(wines.get(position).getName());
        holder.txtType.setText(wines.get(position).getType());
        holder.txtTaste.setText(wines.get(position).getTaste());
        holder.txtDescription.setText(wines.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return wines.size();
    }

    public void setWines(ArrayList<Wine> wines)
    {
        this.wines = wines;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtWine, txtType, txtTaste, txtDescription;
        private CardView parent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtWine = itemView.findViewById(R.id.txtWine);
            txtType = itemView.findViewById(R.id.txtType);
            txtTaste = itemView.findViewById(R.id.txtTaste);
            txtDescription = itemView.findViewById(R.id.txtDescription);
        }
    }


}
