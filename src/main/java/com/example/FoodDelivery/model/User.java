package com.example.FoodDelivery.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "rol")
    private char rol;

    @Column(name = "email")
    private String email;

    @Column(name = "parola")
    private String parola;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "nume")
    private String nume;

    @Column(name = "prenume")
    private String prenume;

    @Column(name = "adrese")
    private String adrese;

    @Column(name = "phoneNumber")
    private String phonenumber;

    public User() {

    }

    public User(char rol, String email, String nickname, String nume, String prenume, String adrese, String phonenumber, String parola) {
        this.rol = rol;
        this.email = email;
        this.nickname = nickname;
        this.nume = nume;
        this.prenume = prenume;
        this.adrese = adrese;
        this.phonenumber = phonenumber;
        this.parola=parola;
    }
    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public char getRol() {
        return rol;
    }

    public void setRol(char rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getAdrese() {
        return adrese;
    }

    public void setAdrese(String adrese) {
        this.adrese = adrese;
    }

    public String getPhoneNumber() {
        return phonenumber;
    }

    public void setPhoneNumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "User[" +
                "id=" + id +
                ", rol=" + rol +
                ", email='" + email + '\'' +
                ", parola='" + parola + '\'' +
                ", nickname='" + nickname + '\'' +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", adrese='" + adrese + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ']';
    }
}
