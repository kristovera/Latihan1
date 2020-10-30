package com.example.latihan1.Adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latihan1.CrudMatkul.MatkulUpdateActivity;
import com.example.latihan1.Model.MataKuliah;
import com.example.latihan1.R;

import java.util.ArrayList;
import java.util.List;



public class MatkulCRUDRecyclerAdapter extends RecyclerView.Adapter<MatkulCRUDRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<MataKuliah> matakuliahList;


    public MatkulCRUDRecyclerAdapter(Context context) {
        this.context = context;
        matakuliahList = new ArrayList<>();
    }

    public MatkulCRUDRecyclerAdapter(List<MataKuliah> matakuliahList) {
        this.matakuliahList = matakuliahList;
    }


    public List<MataKuliah> getMatakuliahList() {
        return matakuliahList;
    }

    public void setMatakuliahList(List<MataKuliah> matakuliahList) {
        this.matakuliahList = matakuliahList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cardview_matkul,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MataKuliah mk = matakuliahList.get(position);

        holder.txtNama.setText(mk.getNama());
        holder.txtKodeMk.setText(mk.getKode());
        holder.txtHariMk.setText(mk.getHari());
        holder.txtSesiMk.setText(mk.getSesi());
        holder.txtSksMk.setText(mk.getSks());
        holder.mk = mk;
    }


    @Override
    public int getItemCount() {
        return matakuliahList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama,txtKodeMk,txtHariMk,txtSesiMk,txtSksMk;
        private RecyclerView rvMatakuliah;
        MataKuliah mk;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtNama = itemView.findViewById(R.id.txtNamaMatkul);
            txtKodeMk = itemView.findViewById(R.id.txtKode);
            txtHariMk = itemView.findViewById(R.id.txtHari);
            txtSesiMk = itemView.findViewById(R.id.txtSesi);
            txtSksMk = itemView.findViewById(R.id.txtSks);
//            rvMatakuliah = itemView.findViewById(R.id.rvMatakuliah);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), MatkulUpdateActivity.class);
                    intent.putExtra("nama",mk.getNama());
                    intent.putExtra("kode",mk.getKode());
                    intent.putExtra("hari",mk.getHari());
                    intent.putExtra("sesi",mk.getSesi());
                    intent.putExtra("sks",mk.getSks());

                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
