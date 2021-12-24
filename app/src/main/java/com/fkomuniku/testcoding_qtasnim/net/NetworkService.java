package com.fkomuniku.testcoding_qtasnim.net;

import com.fkomuniku.testcoding_qtasnim.response.ListBarangResponse;
import com.fkomuniku.testcoding_qtasnim.response.ListJenisBarangResponse;
import com.fkomuniku.testcoding_qtasnim.response.ListTransaksiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkService {

    //Transaksi
    @GET("get-transaksi")
    Call<ListTransaksiResponse> getListTransaksi(
            @Query("token") String token
    );

    //Barang
    @GET("get-barang")
    Call<ListBarangResponse> getListBarang(
            @Query("token") String token
    );

    //Jenis Barang
    @GET("get-jenis-barang")
    Call<ListJenisBarangResponse> getListJenisBarang(
            @Query("token") String token
    );
}
