package com.example.hibernatehw.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Entity
@Table(name = "USER")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS")
    private Adress adress;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "VEHICLE")
    private List<Vehicle> vehicles;

    @OneToMany (fetch = FetchType.LAZY)
    @JoinColumn(name = "MOBILE")
    private List<Mobile> mobiles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Mobile> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<Mobile> mobiles) {
        this.mobiles = mobiles;
    }
}
