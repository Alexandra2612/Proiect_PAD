package com.example.FoodDelivery.model;

import javax.persistence.*;

@Entity
@Table(name = "comanda")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "clientId")
    private long clientId;

    @Column(name = "livratorId")
    private long livratorId;

    @Column(name = "restaurantId")
    private long restaurantId;

    @Column(name = "continut")
    private String continut;

    @Column(name = "prettotal")
    private int prettotal;

    @Column(name = "metodaplata")
    private char metodaplata;

    @Column(name = "prenume")
    private String prenume;

    @Column(name = "adresa")
    private String adresa;

    public Order() {

    }

    public Order(int clientId, int livratorId, int restaurantId, String continut, int prettotal, char metodaplata, String prenume, String adresa) {
        this.clientId = clientId;
        this.livratorId = livratorId;
        this.restaurantId = restaurantId;
        this.continut = continut;
        this.prettotal = prettotal;
        this.metodaplata = metodaplata;
        this.prenume = prenume;
        this.adresa = adresa;
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

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", livratorId=" + livratorId +
                ", restaurantId=" + restaurantId +
                ", continut='" + continut + '\'' +
                ", prettotal=" + prettotal +
                ", metodaplata=" + metodaplata +
                ", prenume='" + prenume + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}
