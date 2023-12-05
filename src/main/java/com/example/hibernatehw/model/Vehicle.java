package com.example.hibernatehw.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Entity
@Table (name = "VEHICLE")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER")
    private List<UserDetails> usersOfVehicle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserDetails> getUsersOfVehicle() {
        return usersOfVehicle;
    }

    public void setUsersOfVehicle(List<UserDetails> usersOfVehicle) {
        this.usersOfVehicle = usersOfVehicle;
    }
}
