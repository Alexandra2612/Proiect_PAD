package com.example.FoodDelivery.model;

import javax.persistence.*;

@Entity
@Table(name = "comanda")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "clientid")
    private long clientId;

    @Column(name = "livratorid")
    private long livratorId;

    @Column(name = "restaurantid")
    private long restaurantId;

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

    public Order(long clientId, long livratorId, long restaurantId, String continut, int prettotal, char metodaplata, String adresa) {
        this.clientId = clientId;
        this.livratorId = livratorId;
        this.restaurantId = restaurantId;
        this.continut = continut;
        this.prettotal = prettotal;
        this.metodaplata = metodaplata;
        this.adresa = adresa;
        this.finished = 0;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getLivratorId() {
        return livratorId;
    }

    public void setLivratorId(long livratorId) {
        this.livratorId = livratorId;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
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
                ", clientId=" + clientId +
                ", livratorId=" + livratorId +
                ", restaurantId=" + restaurantId +
                ", finished=" + finished +
                ", continut='" + continut + '\'' +
                ", prettotal=" + prettotal +
                ", metodaplata=" + metodaplata +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}
