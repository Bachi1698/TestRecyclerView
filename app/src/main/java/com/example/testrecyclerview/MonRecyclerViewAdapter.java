package com.example.testrecyclerview;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MonRecyclerViewAdapter extends RecyclerView.Adapter<MonRecyclerViewAdapter.ConteneurDeDonnee> {
    private ArrayList<Donnee> donnees;

    private static DetecteurDeClicSurRecycler detecteurDeClicSurRecycler;


    public MonRecyclerViewAdapter(ArrayList<Donnee> donnees) {
        this.donnees = donnees;
    }

    @Override
    public ConteneurDeDonnee onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new ConteneurDeDonnee(view);
    }

    @Override
    public void onBindViewHolder(ConteneurDeDonnee conteneur, int position) {
        conteneur.tv_principal.setText(donnees.get(position).getPrincipal());
        conteneur.tv_auxiliaire.setText(donnees.get(position).getAuxiliaire());
        conteneur.image.setImageResource(donnees.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return donnees.size();
    }

    public static class ConteneurDeDonnee extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView image;
        TextView tv_principal;
        TextView tv_auxiliaire;

        public ConteneurDeDonnee(View itemView) {
            super(itemView);
            tv_principal = (TextView) itemView.findViewById(R.id.tv_principal);
            tv_auxiliaire = (TextView) itemView.findViewById(R.id.tv_auxiliaire);
            image = itemView.findViewById(R.id.image1);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            ((CardView)itemView).setCardBackgroundColor(Color.rgb(255,0,0));
            detecteurDeClicSurRecycler.clicSurRecyclerItem(getAdapterPosition(), v);
        }


    }

    public void setDetecteurDeClicSurRecycler(DetecteurDeClicSurRecycler detecteurDeClicSurRecycler) {
        this.detecteurDeClicSurRecycler = detecteurDeClicSurRecycler;


    }
}


