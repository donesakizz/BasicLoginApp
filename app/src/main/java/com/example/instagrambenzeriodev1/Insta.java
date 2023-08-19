package com.example.instagrambenzeriodev1;

public class Insta {
    private int resim;
    private String yazi;



    public Insta(int resim , String yazi) {
        this.resim = resim;
        this.yazi=yazi;
    }

    public int getResim() {
        return resim;
    }

    public void setResim(int resim) {
        this.resim = resim;
    }

    public String getYazi() {
        return yazi;
    }

    public void setYazi(String yazi) {
        this.yazi = yazi;
    }
}
