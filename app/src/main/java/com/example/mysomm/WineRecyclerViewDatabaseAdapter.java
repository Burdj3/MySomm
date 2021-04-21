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

import java.util.ArrayList;

public class WineRecyclerViewDatabaseAdapter extends RecyclerView.Adapter<WineRecyclerViewDatabaseAdapter.ViewHolder>{

    private ArrayList<Wine> wines = new ArrayList<>();
    private Context context;
    private OnWinedbListener mOnWinedbListener;

    public WineRecyclerViewDatabaseAdapter(Context context, OnWinedbListener onWinedbListener) {
        this.context = context;
        this.mOnWinedbListener = onWinedbListener;
    }

    @NonNull
    @Override
    public WineRecyclerViewDatabaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wine_list_item_database, parent, false);
        WineRecyclerViewDatabaseAdapter.ViewHolder holder = new WineRecyclerViewDatabaseAdapter.ViewHolder(view, mOnWinedbListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull WineRecyclerViewDatabaseAdapter.ViewHolder holder, int position) {
        holder.txtWine.setText(wines.get(position).getName());
        holder.txtType.setText(wines.get(position).getType());
        holder.txtTaste.setText(wines.get(position).getTaste());
        holder.txtDescription.setText(wines.get(position).getDescription());

        Glide.with(context)
                .asBitmap()
                .load(wines.get(position).getImageURL())
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtWine, txtType, txtTaste, txtDescription;
        private ImageView image;
        private CardView parent;
        OnWinedbListener onWinedbListener;

        public ViewHolder(@NonNull View itemView, OnWinedbListener onWinedbListener) {
            super(itemView);
            txtWine = itemView.findViewById(R.id.txtWine);
            txtType = itemView.findViewById(R.id.txtType);
            txtTaste = itemView.findViewById(R.id.txtTaste);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            image = itemView.findViewById(R.id.image);
            this.onWinedbListener = onWinedbListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onWinedbListener.onWinedbClick(getAdapterPosition());
        }
    }

    public interface OnWinedbListener{
        void onWinedbClick(int position);
    }


}

