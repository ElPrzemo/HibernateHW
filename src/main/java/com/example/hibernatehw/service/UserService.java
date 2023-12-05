package org.example.service;

import org.example.model.Mobile;
import org.example.model.UserDetails;
import org.example.model.Vehicle;
import org.example.repository.UserRepository;
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

    public List<Vehicle> getUserVehicles(UserDetails userDetails) {
        for (UserDetails user : listOfAllUsers) {
            if (userDetails.getId() == user.getId()) {
                return user.getVehicles();
            }
        }

        return null;
    }

    public List<Mobile> getUserMobiles(UserDetails userDetails) {
        for (UserDetails user : listOfAllUsers) {
            if (userDetails.getId() == user.getId()) {
                return user.getMobiles();
            }
        }

        return null;
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
}