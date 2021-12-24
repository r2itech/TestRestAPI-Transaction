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
import com.fkomuniku.testcoding_qtasnim.model.JenisBarang;

import java.util.List;

public class JenisBarangAdapter extends RecyclerView.Adapter<JenisBarangAdapter.MyViewHolder> {
    private Context mContext;
    List<JenisBarang> jenisBarang;

    public JenisBarangAdapter(Context mContext, List<JenisBarang> jenisBarang){
        this.mContext = mContext;
        this.jenisBarang = jenisBarang;
    }

    @NonNull
    @Override
    public JenisBarangAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.item_list_jenis_barang, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull JenisBarangAdapter.MyViewHolder holder, int position) {
        final int position_row = position;
        final JenisBarang t = jenisBarang.get(position);
        holder.tv_jenis_barang.setText("Jenis Barang: " +t.getJenis_barang());
    }

    @Override
    public int getItemCount() { return jenisBarang.size(); }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_jenis_barang;

        public MyViewHolder(@NonNull final View itemView)
        {
            super(itemView);
            tv_jenis_barang = itemView.findViewById(R.id.tv_jenis_barang);
        }
    }
}
