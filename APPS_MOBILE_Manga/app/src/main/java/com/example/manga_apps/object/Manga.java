package com.example.manga_apps.object;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.jar.JarException;

public class Manga {
    private String tenManga, tenchap, LinkAnh;

    public Manga(){

    }


    public Manga(String tenManga, String tenchap, String linkAnh) {
        this.tenManga = tenManga;
        this.tenchap = tenchap;
        LinkAnh = linkAnh;
    }

    public String getTenManga() {
        return tenManga;
    }

    public void setTenManga(String tenManga) {
        this.tenManga = tenManga;
    }

    public String getTenchap() {
        return tenchap;
    }

    public void setTenchap(String tenchap) {
        this.tenchap = tenchap;
    }

    public String getLinkAnh() {
        return LinkAnh;
    }

    public void setLinkAnh(String linkAnh) {
        LinkAnh = linkAnh;
    }
}
