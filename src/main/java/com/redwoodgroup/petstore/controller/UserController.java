package com.redwoodgroup.petstore.controller;

import com.redwoodgroup.petstore.dto.ApiResponse;
import com.redwoodgroup.petstore.dto.User;
import com.redwoodgroup.petstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse createUser(@Valid @RequestBody User user){

        return userService.createUser(user);
    }

    @RequestMapping(value = "/user/createWithArray", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse createWithArray(@Valid @RequestBody List<User> user){

        return userService.createWithArray(user);
    }

    @RequestMapping(value = "/user/delete/{username}", method = RequestMethod.DELETE)
    @ResponseBody
    public ApiResponse deleteUser(@PathVariable("username") String username){

        return userService.deleteUser(username);
    }

    @RequestMapping(value = "/user/get/{username}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("username") String username){

        return userService.getUser(username);
    }

    @RequestMapping(value = "/user/update/{username}", method = RequestMethod.PUT)
    @ResponseBody
    public ApiResponse updateUser(@PathVariable("username") String username, @Valid @RequestBody User user){

        return userService.updateUser(username, user);
    }

}
