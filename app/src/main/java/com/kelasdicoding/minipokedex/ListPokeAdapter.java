package com.kelasdicoding.minipokedex;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListPokeAdapter extends RecyclerView.Adapter<ListPokeAdapter.ListViewHolder> {

    private ArrayList<Poke> listPoke;

    public ListPokeAdapter(ArrayList<Poke> list){
        this.listPoke = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_poke, parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Poke poke =listPoke.get(position);
        Glide.with(holder.itemView.getContext())
                .load(poke.getPhoto())
                .apply(new RequestOptions().override(57, 57))
                .into(holder.imgPhoto);
        holder.txtName.setText(poke.getName());
        holder.txtType.setText(poke.getDetail());
    }

    @Override
    public int getItemCount() {
        return listPoke.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView txtName,txtType;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.crcl_poke_image);
            txtName = itemView.findViewById(R.id.txt_poke_name);
            txtType = itemView.findViewById(R.id.txt_poke_type);
        }
    }
}
