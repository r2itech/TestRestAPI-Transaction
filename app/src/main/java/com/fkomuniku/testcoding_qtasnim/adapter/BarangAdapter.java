package com.fkomuniku.testcoding_qtasnim.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fkomuniku.testcoding_qtasnim.R;
import com.fkomuniku.testcoding_qtasnim.model.Barang;

import java.util.List;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.MyViewHolder> {
    private Context mContext;
    List<Barang> barang;

    public BarangAdapter(Context mContext, List<Barang> barang){
        this.mContext = mContext;
        this.barang = barang;
    }

    @NonNull
    @Override
    public BarangAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.item_list_barang, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull BarangAdapter.MyViewHolder holder, int position) {
        final int position_row = position;
        final Barang t = barang.get(position);
        holder.tv_nama_barang.setText("Nama Barang: " +t.getNama_barang());
        holder.tv_jenis_barang.setText("Jenis Barang: " +t.getJenis_barang());
        holder.btn_stok.setText("Stok: " +t.getStok());
    }

    @Override
    public int getItemCount() { return barang.size(); }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nama_barang, tv_jenis_barang;
        Button btn_stok;

        public MyViewHolder(@NonNull final View itemView)
        {
            super(itemView);
            tv_nama_barang = itemView.findViewById(R.id.tv_nama_barang);
            tv_jenis_barang = itemView.findViewById(R.id.tv_jenis_barang);
            btn_stok = itemView.findViewById(R.id.btn_stok);
        }
    }
}
