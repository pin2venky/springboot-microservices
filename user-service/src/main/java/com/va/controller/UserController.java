package com.va.controller;

import com.va.domain.User;
import com.va.service.UserService;
import com.va.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "User Controller")
@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @ApiOperation(value = "Add New User")
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewUser(@Valid @RequestBody User user) {
        userService.addNewUser(user);
    }

    @ApiOperation(value = "Get User By Id")
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }


    @ApiOperation(value = "Get All Users")
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @ApiOperation(value = "Update a user")
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@PathVariable Long id,
                           @Valid @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @ApiOperation(value = "Delete a user")
    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long id,
                           @Valid @RequestBody User user) {
        userService.deleteUser(id, user);
    }

}
