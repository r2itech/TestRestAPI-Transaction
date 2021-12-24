package com.fkomuniku.testcoding_qtasnim.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JenisBarang {
    public void JenisBarang() {

    }

    public void JenisBarang(String jenis_barang){
        this.jenis_barang = jenis_barang;
    }

    @Expose
    @SerializedName("jenis_barang") private String jenis_barang;

    public String getJenis_barang(){ return jenis_barang; }

    public void setJenis_barang(){ this.jenis_barang = jenis_barang; }
}
