package com.example.FoodDelivery.model;

import javax.persistence.*;

@Entity
@Table(name = "topping")
public class Topping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nume")
    private String nume;

    @Column(name = "pret")
    private double pret;

    @Column(name = "gramaj")
    private int gramaj;

    public Topping() {

    }

    public Topping(String nume, double pret, int gramaj) {
        this.nume = nume;
        this.pret = pret;
        this.gramaj = gramaj;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
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

    @Override
    public String toString() {
        return "Topping{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", pret=" + pret +
                ", gramaj=" + gramaj +
                '}';
    }
}
