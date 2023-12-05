package com.example.hibernatehw.repository;

import com.example.hibernatehw.model.Mobile;
import com.example.hibernatehw.model.UserDetails;
import com.example.hibernatehw.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository {

    List<UserDetails> getAllUsers();

    List<Mobile> getUserMobiles(UserDetails userDetails);

    List<Vehicle> getUserVehicles(UserDetails userDetails);

    void addNewUser(UserDetails user);

    void createNewMobileDeviceAndAddToUser(Mobile mobile, UserDetails user);

    void createNewVehicleAndAddToUser(Vehicle vehicle, UserDetails user);

    UserDetails getUserByUsername(String username);
}