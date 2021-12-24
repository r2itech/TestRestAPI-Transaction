package com.fkomuniku.testcoding_qtasnim.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fkomuniku.testcoding_qtasnim.R;
import com.fkomuniku.testcoding_qtasnim.adapter.BarangAdapter;
import com.fkomuniku.testcoding_qtasnim.adapter.JenisBarangAdapter;
import com.fkomuniku.testcoding_qtasnim.adapter.TransaksiAdapter;
import com.fkomuniku.testcoding_qtasnim.helper.BaseActivity;
import com.fkomuniku.testcoding_qtasnim.model.Barang;
import com.fkomuniku.testcoding_qtasnim.model.JenisBarang;
import com.fkomuniku.testcoding_qtasnim.model.Transaksi;
import com.fkomuniku.testcoding_qtasnim.net.NetworkManager;
import com.fkomuniku.testcoding_qtasnim.response.ListBarangResponse;
import com.fkomuniku.testcoding_qtasnim.response.ListJenisBarangResponse;
import com.fkomuniku.testcoding_qtasnim.response.ListTransaksiResponse;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BasicActivity extends BaseActivity {
    LinearLayout icon_tidak_ada_data;
    LinearLayout btn_back;
    TextView tv_title;
    RecyclerView rv_list_data;

    List<Transaksi> transaksi;
    List<Barang> barang;
    List<JenisBarang> jenisBarang;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        findViewById();
        checkPage();
        setListener();
    }

    private void findViewById()
    {
        icon_tidak_ada_data = findViewById(R.id.icon_tidak_ada_data);
        btn_back = findViewById(R.id.btn_back);
        tv_title = findViewById(R.id.tv_title);
        rv_list_data = findViewById(R.id.rv_list_data);
    }

    private void checkPage()
    {
        String title = getIntent().getStringExtra("menu");
        String token = getIntent().getStringExtra("token");

        if(title.equals("transaksi")){
            tv_title.setText(R.string.title_transaksi);
            getListTransaksi(token);
        } else if(title.equals("barang")){
            tv_title.setText(R.string.title_barang);
            getListBarang(token);
        } else if(title.equals("jenis_barang")){
            tv_title.setText(R.string.title_jenis_barang);
            getListJenisBarang(token);
        }
    }

    private void getListTransaksi(String token)
    {
        ShowLoading();
        Call<ListTransaksiResponse> call = NetworkManager.getNetworkService(BasicActivity.this).getListTransaksi(token);
        call.enqueue(new Callback<ListTransaksiResponse>() {
            @Override
            public void onResponse(Call<ListTransaksiResponse> call, Response<ListTransaksiResponse> response) {
                HideLoading();
                if(response.isSuccessful()){
                    ListTransaksiResponse listTransaksiResponse = response.body();

                    if(!listTransaksiResponse.getListTransaksi().isEmpty()){
                        icon_tidak_ada_data.setVisibility(View.INVISIBLE);
                    }else{
                        icon_tidak_ada_data.setVisibility(View.VISIBLE);
                    }

                    transaksi = listTransaksiResponse.getListTransaksi();
                    setUpListTransaksi(transaksi);
                } else{
                       ListTransaksiResponse listTransaksiResponse = new Gson().fromJson(response.errorBody().charStream(), ListTransaksiResponse.class);
                       Toast.makeText(BasicActivity.this, listTransaksiResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListTransaksiResponse> call, Throwable t) {
                HideLoading();
                Toast.makeText(BasicActivity.this, "Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getListBarang(String token)
    {
        ShowLoading();
        Call<ListBarangResponse> call = NetworkManager.getNetworkService(BasicActivity.this).getListBarang(token);
        call.enqueue(new Callback<ListBarangResponse>() {
            @Override
            public void onResponse(Call<ListBarangResponse> call, Response<ListBarangResponse> response) {
                HideLoading();
                if(response.isSuccessful()){
                    ListBarangResponse listBarangResponse = response.body();

                    if(!listBarangResponse.getListBarang().isEmpty()){
                        icon_tidak_ada_data.setVisibility(View.INVISIBLE);
                    }else{
                        icon_tidak_ada_data.setVisibility(View.VISIBLE);
                    }

                    barang = listBarangResponse.getListBarang();
                    setUpListBarang(barang);
                } else{
                    ListBarangResponse listBarangResponse = new Gson().fromJson(response.errorBody().charStream(), ListBarangResponse.class);
                    Toast.makeText(BasicActivity.this, listBarangResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListBarangResponse> call, Throwable t) {
                HideLoading();
                Toast.makeText(BasicActivity.this, "Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getListJenisBarang(String token)
    {
        ShowLoading();
        Call<ListJenisBarangResponse> call = NetworkManager.getNetworkService(BasicActivity.this).getListJenisBarang(token);
        call.enqueue(new Callback<ListJenisBarangResponse>() {
            @Override
            public void onResponse(Call<ListJenisBarangResponse> call, Response<ListJenisBarangResponse> response) {
                HideLoading();
                if(response.isSuccessful()){
                    ListJenisBarangResponse listJenisBarangResponse = response.body();

                    if(!listJenisBarangResponse.getListJenisBarang().isEmpty()){
                        icon_tidak_ada_data.setVisibility(View.INVISIBLE);
                    }else{
                        icon_tidak_ada_data.setVisibility(View.VISIBLE);
                    }

                    jenisBarang = listJenisBarangResponse.getListJenisBarang();
                    setUpListJenisBarang(jenisBarang);
                } else{
                    ListJenisBarangResponse listJenisBarangResponse = new Gson().fromJson(response.errorBody().charStream(), ListJenisBarangResponse.class);
                    Toast.makeText(BasicActivity.this, listJenisBarangResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListJenisBarangResponse> call, Throwable t) {
                HideLoading();
                Toast.makeText(BasicActivity.this, "Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setListener()
    {
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setUpListTransaksi(List<Transaksi> transaksi)
    {
        TransaksiAdapter transaksiAdapter = new TransaksiAdapter(this, transaksi);
        rv_list_data.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_list_data.setAdapter(transaksiAdapter);
    }

    private void setUpListBarang(List<Barang> barang)
    {
        BarangAdapter barangAdapter = new BarangAdapter(this, barang);
        rv_list_data.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_list_data.setAdapter(barangAdapter);
    }

    private void setUpListJenisBarang(List<JenisBarang> jenisBarang)
    {
        JenisBarangAdapter jenisBarangAdapter = new JenisBarangAdapter(this, jenisBarang);
        rv_list_data.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_list_data.setAdapter(jenisBarangAdapter);
    }
}
