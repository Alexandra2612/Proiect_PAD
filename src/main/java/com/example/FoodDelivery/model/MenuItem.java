package com.example.FoodDelivery.model;

import javax.persistence.*;

@Entity
@Table(name = "mancare")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nume")
    private String nume;

    @Column(name = "ingrediente")
    private String ingrediente;

    @Column(name = "imagine")
    private String imagine;

    @Column(name = "pret")
    private double pret;

    @Column(name = "gramaj")
    private int gramaj;

    @Column(name = "toppinguri")
    private String toppinguri;

    public MenuItem() {

    }

    public MenuItem(String nume, String ingrediente, String imagine, double pret, int gramaj, String toppinguri) {
        this.nume = nume;
        this.ingrediente = ingrediente;
        this.imagine = imagine;
        this.pret = pret;
        this.gramaj = gramaj;
        this.toppinguri = toppinguri;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public String getImagine() {
        return imagine;
    }

    public void setImagine(String imagine) {
        this.imagine = imagine;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getGramaj() {
        return gramaj;
    }

    public void setGramaj(int gramaj) {
        this.gramaj = gramaj;
    }

    public String getToppinguri() {
        return toppinguri;
    }

    public void setToppinguri(String toppinguri) {
        this.toppinguri = toppinguri;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", ingrediente='" + ingrediente + '\'' +
                ", imagine='" + imagine + '\'' +
                ", pret=" + pret +
                ", gramaj=" + gramaj +
                ", toppinguri='" + toppinguri + '\'' +
                '}';
    }
}
