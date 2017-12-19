package com.ataberkdinc.chatfinansal;

import java.util.Date;

/**
 * Created by ataberkdinc on 13.12.2017.
 */

public class ChatMesaj {

    private String mesajYazi;
    private String mesajKullanici;
    private long mesajZaman;

    public ChatMesaj(String mesajYazi, String mesajKullanici)
    {
        this.mesajYazi = mesajYazi;
        this.mesajKullanici = mesajKullanici;

        mesajZaman = new Date().getTime();

    }

    public String getMesajYazi() {
        return mesajYazi;
    }

    public void setMesajYazi(String mesajYazi) {
        this.mesajYazi = mesajYazi;
    }

    public String getMesajKullanici() {
        return mesajKullanici;
    }

    public void setMesajKullanici(String mesajKullanici) {
        this.mesajKullanici = mesajKullanici;
    }

    public long getMesajZaman() {
        return mesajZaman;
    }

    public void setMesajZaman(long mesajZaman) {
        this.mesajZaman = mesajZaman;
    }

    public ChatMesaj()
    {

    }



}
