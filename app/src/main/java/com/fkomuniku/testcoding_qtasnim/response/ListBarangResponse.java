package com.fkomuniku.testcoding_qtasnim.response;

import com.fkomuniku.testcoding_qtasnim.model.Barang;
import com.fkomuniku.testcoding_qtasnim.model.Transaksi;

import java.util.List;

public class ListBarangResponse {
    private String status_code;
    private String message;
    private List<Barang> barang;

    public ListBarangResponse(String status_code, String message, List<Barang> barang){
        this.status_code = status_code;
        this.message = message;
        this.barang = barang;
    }

    public String getStatus_code(){ return status_code; }
    public String getMessage(){ return message; }
    public List<Barang> getListBarang(){ return barang; }
}
