package com.example.latihan1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.latihan1.Model.Mahasiswa;
import com.example.latihan1.R;

public class MahasiswaCRUDRecyclerAdapter extends RecyclerView.Adapter<MahasiswaCRUDRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<Mahasiswa> mahasiswaList;

    public MahasiswaCRUDRecyclerAdapter(Context context) {
        this.context = context;
        mahasiswaList = new ArrayList<>();
    }

    public MahasiswaCRUDRecyclerAdapter(List<Mahasiswa> mahasiswaList){
        this.mahasiswaList = mahasiswaList;
    }

    public List<Mahasiswa> getMahasiswaList() {
        return mahasiswaList;
    }

    public void setMahasiswaList(List<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cardview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mahasiswa m = mahasiswaList.get(position);

        holder.txtNama.setText(m.getNama());
        holder.txtNim.setText(m.getNim());
        //holder.txtNoTelp.setText(m.getNotelp());
    }

    @Override
    public int getItemCount() {
        return mahasiswaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtNim, txtNoTelp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNama = itemView.findViewById(R.id.txtNama);
            txtNim = itemView.findViewById(R.id.tvNim);
            //txtNoTelp = itemView.findViewById(R.id.txtNoTelp);
        }
    }
}