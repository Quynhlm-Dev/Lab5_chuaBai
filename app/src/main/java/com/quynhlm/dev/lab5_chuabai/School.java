package com.quynhlm.dev.lab5_chuabai;

public class School {
    private String name;
    private int imglogo;

    public School(String name, int imglogo) {
        this.name = name;
        this.imglogo = imglogo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImglogo() {
        return imglogo;
    }

    public void setImglogo(int imglogo) {
        this.imglogo = imglogo;
    }
}
