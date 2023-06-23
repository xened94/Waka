package com.example.waka.Adaptor;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.waka.Domain.PlatoFondoDomain;
import com.example.waka.MostrarDetalleActivity;
import com.example.waka.R;

import java.util.ArrayList;

public class PlatoFondoAdaptor extends RecyclerView.Adapter<PlatoFondoAdaptor.ViewHolder> {
    ArrayList<PlatoFondoDomain>platoFondoDomains;

    public PlatoFondoAdaptor(ArrayList<PlatoFondoDomain> platoFondoDomains){
        this.platoFondoDomains=platoFondoDomains;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_platofondo,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PlatoFondoAdaptor.ViewHolder holder, int position) {
        holder.platoFondoName.setText(platoFondoDomains.get(position).getTitle());
        String picUrl= "";
        switch (position){
            case 0:{
                picUrl="cat_1";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background1));
                break;
            }
            case 1:{
                picUrl="cat_2";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background2));
                break;
            }
            case 2:{
                picUrl="cat_3";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background3));
                break;
            }
            case 3:{
                picUrl="cat_4";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background4));
                break;
            }
            case 4:{
                picUrl="cat_5";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background5));
                break;
            }
        };
        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(picUrl, "drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.platoFondoPic);

    }

    @Override
    public int getItemCount() {
        return platoFondoDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView platoFondoName;
        ImageView platoFondoPic;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            platoFondoName=itemView.findViewById(R.id.platoFondoName);
            platoFondoPic=itemView.findViewById(R.id.platoFondoPic);
            mainLayout=itemView.findViewById(R.id.mainLayout);
        }
    }
}
