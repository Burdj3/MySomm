package com.example.mysomm;

import android.content.Context;
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
        holder.txtAge.setText(wines.get(position).getAge());
        holder.txtTaste.setText(wines.get(position).getTaste());
        holder.txtPriceRange.setText(wines.get(position).getPriceRange());

        Glide.with(context)
                .asBitmap()
                .load(wines.get(position).getImageUrl())
                .into(holder.image);
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

        private TextView txtWine, txtType, txtAge, txtTaste, txtPriceRange;
        private CardView parent;
        private ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtWine = itemView.findViewById(R.id.txtWine);
            txtType = itemView.findViewById(R.id.txtType);
            txtAge = itemView.findViewById(R.id.txtAge);
            txtTaste = itemView.findViewById(R.id.txtTaste);
            txtPriceRange = itemView.findViewById(R.id.txtPriceRange);
            image = itemView.findViewById(R.id.image);
        }
    }


}
