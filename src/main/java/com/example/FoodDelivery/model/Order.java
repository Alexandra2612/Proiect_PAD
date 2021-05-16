package com.example.FoodDelivery.model;

import javax.persistence.*;

@Entity
@Table(name = "comanda")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "client")
    private String client;

    @Column(name = "livrator")
    private String livrator;

    @Column(name = "restaurant")
    private String restaurant;

    @Column(name = "continut")
    private String continut;

    @Column(name = "prettotal")
    private int prettotal;

    @Column(name = "metodaplata")
    private char metodaplata;

    @Column(name = "adresa")
    private String adresa;

    @Column(name = "finished")
    private int finished;

    public Order() {

    }

    public Order(String client, String livrator, String restaurant, String continut, int prettotal, char metodaplata, String adresa) {
        this.client = client;
        this.livrator = livrator;
        this.restaurant = restaurant;
        this.continut = continut;
        this.prettotal = prettotal;
        this.metodaplata = metodaplata;
        this.adresa = adresa;
        this.finished = 0;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getLivrator() {
        return livrator;
    }

    public void setLivrator(String livrator) {
        this.livrator = livrator;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getContinut() {
        return continut;
    }

    public void setContinut(String continut) {
        this.continut = continut;
    }

    public int getPrettotal() {
        return prettotal;
    }

    public void setPrettotal(int prettotal) {
        this.prettotal = prettotal;
    }

    public char getMetodaplata() {
        return metodaplata;
    }

    public void setMetodaplata(char metodaplata) {
        this.metodaplata = metodaplata;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getFinished() {
        return finished;
    }

    public void setFinished(int finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client +
                ", livrator=" + livrator +
                ", restaurant=" + restaurant +
                ", finished=" + finished +
                ", continut='" + continut + '\'' +
                ", prettotal=" + prettotal +
                ", metodaplata=" + metodaplata +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}
