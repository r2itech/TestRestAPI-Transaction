package com.fkomuniku.testcoding_qtasnim.response;

import com.fkomuniku.testcoding_qtasnim.model.Transaksi;

import java.util.List;

public class ListTransaksiResponse {
    private String status_code;
    private String message;
    private List<Transaksi> transaksi;

    public ListTransaksiResponse(String status_code, String message, List<Transaksi> transaksi){
        this.status_code = status_code;
        this.message = message;
        this.transaksi = transaksi;
    }

    public String getStatus_code(){ return status_code; }
    public String getMessage(){ return message; }
    public List<Transaksi> getListTransaksi(){ return transaksi; }
}
