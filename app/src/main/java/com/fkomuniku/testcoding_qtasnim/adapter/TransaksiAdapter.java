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
import com.fkomuniku.testcoding_qtasnim.model.Transaksi;

import java.util.List;

public class TransaksiAdapter extends RecyclerView.Adapter<TransaksiAdapter.MyViewHolder> {
    private Context mContext;
    List<Transaksi> transaksi;

    public TransaksiAdapter(Context mContext, List<Transaksi> transaksi){
        this.mContext = mContext;
        this.transaksi = transaksi;
    }

    @NonNull
    @Override
    public TransaksiAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.item_list_transaksi, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull TransaksiAdapter.MyViewHolder holder, int position) {
        final int position_row = position;
        final Transaksi t = transaksi.get(position);
        holder.tv_nama_barang.setText("Barang: " +t.getNama_barang() +" (" +t.getJenis_barang() +")");
        holder.tv_tgl_transaksi.setText("Tanggal Transaksi: " +t.getTanggal_transaksi());
        holder.btn_stok.setText("Stok: " +t.getStok());
    }

    @Override
    public int getItemCount() { return transaksi.size(); }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nama_barang, tv_tgl_transaksi;
        Button btn_stok;

        public MyViewHolder(@NonNull final View itemView)
        {
            super(itemView);
            tv_nama_barang = itemView.findViewById(R.id.tv_nama_barang);
            tv_tgl_transaksi = itemView.findViewById(R.id.tv_tanggal_transaksi);
            btn_stok = itemView.findViewById(R.id.btn_stok);
        }
    }
}
