package com.example.FoodDelivery.model;

import javax.persistence.*;

@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nume")
    private String nume;

    @Column(name = "imagine")
    private String imagine;

    @Column(name = "adresa")
    private String adresa;

    @Column(name = "descriere")
    private String descriere;

    @Column(name = "meniu")
    private String meniu;

    public Restaurant() {

    }

    public Restaurant(String nume, String imagine, String adresa, String descriere, String meniu) {
        this.nume = nume;
        this.imagine = imagine;
        this.adresa = adresa;
        this.descriere = descriere;
        this.meniu = meniu;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getImagine() {
        return imagine;
    }

    public void setImagine(String imagine) {
        this.imagine = imagine;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public String getMeniu() {
        return meniu;
    }

    public void setMeniu(String meniu) {
        this.meniu = meniu;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", imagine='" + imagine + '\'' +
                ", adresa='" + adresa + '\'' +
                ", descriere='" + descriere + '\'' +
                ", meniu='" + meniu + '\'' +
                '}';
    }
}
