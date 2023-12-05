package com.example.hibernatehw.service;

import com.example.hibernatehw.model.Mobile;
import com.example.hibernatehw.model.UserDetails;
import com.example.hibernatehw.model.Vehicle;
import com.example.hibernatehw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserRepository {

    @Autowired
    private List<UserDetails> listOfAllUsers = new ArrayList<>();

    public List<UserDetails> getAllUsers() {
        return listOfAllUsers;
    }

    public List<Mobile> getUserMobiles(UserDetails userDetails) {
        return userDetails.getMobiles();
    }

    public List<Vehicle> getUserVehicles(UserDetails userDetails) {
        return userDetails.getVehicles();
    }

    public void addNewUser(UserDetails user) {
        listOfAllUsers.add(user);
    }

    public void createNewMobileDeviceAndAddToUser(Mobile mobile, UserDetails user) {
        for (UserDetails userOperation : listOfAllUsers) {
            if (user.getId() == userOperation.getId()) {
                userOperation.getMobiles().add(mobile);
            }
        }
    }

    public void createNewVehicleAndAddToUser(Vehicle vehicle, UserDetails user) {
        for (UserDetails userOperation : listOfAllUsers) {
            if (user.getId() == userOperation.getId()) {
                userOperation.getVehicles().add(vehicle);
            }
        }
    }

    public UserDetails getUserByUsername(String username) {
        for (UserDetails user : listOfAllUsers) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }}