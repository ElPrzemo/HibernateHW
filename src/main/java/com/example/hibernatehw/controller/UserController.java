package com.example.hibernatehw.controller;

import com.example.hibernatehw.model.Mobile;
import com.example.hibernatehw.model.UserDetails;
import com.example.hibernatehw.model.Vehicle;
import com.example.hibernatehw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getList(Model model) {
        List<UserDetails> users = userService.getAllUsers();
        model.addAttribute("userList", users);
        return "userList";
    }

    @GetMapping("/users/mobiles/{name}")
    public String getUserMobiles(@PathVariable(name = "name") String name, Model model) {
        UserDetails user = userService.getUserByUsername(name);

        if (user != null) {
            List<Mobile> mobiles = userService.getUserMobiles(user);
            model.addAttribute("mobileList", mobiles);
        } else {
            model.addAttribute("errorMessage", "User not found");
        }

        return "mobileList";
    }

    @GetMapping("/users/vehicles/{name}")
    public String getUserVehicles(@PathVariable(name = "name") String name, Model model) {
        UserDetails user = userService.getUserByUsername(name);

        if (user != null) {
            List<Vehicle> vehicles = userService.getUserVehicles(user);
            model.addAttribute("vehicleList", vehicles);
        } else {
            model.addAttribute("errorMessage", "User not found");
        }

        return "vehicleList";
    }

    @GetMapping("/users/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("userDetails", new UserDetails());
        return "addUserForm";
    }

    @PostMapping("/users/add")
    public String addUser(@ModelAttribute("userDetails") UserDetails userDetails) {
        userService.addNewUser(userDetails);
        return "redirect:/users";
    }

    @PostMapping("/users/addMobile/{username}")
    public String addMobileToUser(
            @PathVariable(name = "username") String username,
            @ModelAttribute("mobile") Mobile mobile) {
        UserDetails user = userService.getUserByUsername(username);

        if (user != null) {
            userService.createNewMobileDeviceAndAddToUser(mobile, user);
            return "redirect:/users";
        } else {
            return "error";
        }
    }

    @PostMapping("/users/addVehicle/{username}")
    public String addVehicleToUser(
            @PathVariable(name = "username") String username,
            @ModelAttribute("vehicle") Vehicle vehicle) {
        UserDetails user = userService.getUserByUsername(username);

        if (user != null) {
            userService.createNewVehicleAndAddToUser(vehicle, user);
            return "redirect:/users";
        } else {
            return "error";
        }
    }

    @GetMapping("/users/view/{username}")
    public String viewUserDetails(@PathVariable(name = "username") String username, Model model) {
        UserDetails user = userService.getUserByUsername(username);

        if (user != null) {
            model.addAttribute("userDetails", user);
            return "userDetails";
        } else {
            model.addAttribute("errorMessage", "User not found");
            return "error";
        }
    }
}