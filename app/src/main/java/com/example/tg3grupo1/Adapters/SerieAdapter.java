package com.example.tg3grupo1.Adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tg3grupo1.Modelo.Modelo;
import com.example.tg3grupo1.R;

import java.util.List;

public class SerieAdapter extends RecyclerView.Adapter<SerieAdapter.ViewHolder> {
    private List<Modelo> paradas;
    private OnNoteListener onNoteListener;

    public SerieAdapter(List<Modelo> paradas, OnNoteListener onNoteListener) {
        this.paradas = paradas;
        this.onNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_contenedor_de_datos, parent, false);
        return new ViewHolder(view, onNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.campoid.setText(paradas.get(position).getId());
        holder.campoTitulo.setText(paradas.get(position).getTitulo());
//        holder.campoImagen.setImageBitmap();
    }

    @Override
    public int getItemCount() {
        return paradas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView campoid;
        public TextView campoTitulo;
        public ImageView campoImagen;
        OnNoteListener onNoteListener;

        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            campoid = itemView.findViewById(R.id.campoId);
            campoTitulo = itemView.findViewById(R.id.campoTitulo);
            campoImagen = itemView.findViewById(R.id.campoImagen);
            this.onNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClic(getAdapterPosition());
        }
    }

    public interface OnNoteListener {
        void onNoteClic(int posicion);
    }
}