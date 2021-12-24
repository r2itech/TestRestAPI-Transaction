package com.fkomuniku.testcoding_qtasnim.response;

import com.fkomuniku.testcoding_qtasnim.model.Barang;
import com.fkomuniku.testcoding_qtasnim.model.JenisBarang;

import java.util.List;

public class ListJenisBarangResponse {
    private String status_code;
    private String message;
    private List<JenisBarang> jenisBarang;

    public ListJenisBarangResponse(String status_code, String message, List<JenisBarang> jenisBarang){
        this.status_code = status_code;
        this.message = message;
        this.jenisBarang = jenisBarang;
    }

    public String getStatus_code(){ return status_code; }
    public String getMessage(){ return message; }
    public List<JenisBarang> getListJenisBarang(){ return jenisBarang; }
}
