package com.quynhlm.dev.lab5_chuabai;

import java.io.Serializable;

public class SinhVienModel implements Serializable {

    private String title;
    private String name;
    private String diaChi;


    public SinhVienModel(String title, String name, String diaChi) {
        this.title = title;
        this.name = name;
        this.diaChi = diaChi;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
