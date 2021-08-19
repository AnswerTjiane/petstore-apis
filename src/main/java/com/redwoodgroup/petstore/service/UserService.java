package com.redwoodgroup.petstore.service;

import com.redwoodgroup.petstore.dto.ApiResponse;
import com.redwoodgroup.petstore.dto.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public ApiResponse createUser(User user){
        ApiResponse response = new ApiResponse();
        users.add(user);
        response.setCode(200);
        response.setMessage("created user successfully");

        return response;
    }

    public ApiResponse createWithArray(List <User> users){
        ApiResponse response = new ApiResponse();
        this.users.addAll(users);
        response.setCode(200);
        response.setMessage("created users successfully");

        return response;
    }

    public ApiResponse deleteUser(String username){
        ApiResponse response = new ApiResponse();
        User deleteusr = null;
        for (User user: users){
            if (user.getUsername().equalsIgnoreCase(username)){
                deleteusr = user;
            }
        }
        users.remove(deleteusr);

        response.setCode(200);
        response.setMessage("deleted user successfully");

        return response;

    }

    public User getUser(String username){
        User user = new User();
        for (User usr: users){
            if (usr.getUsername().equalsIgnoreCase(username)){
                user = usr;
            }
        }

        return user;
    }

    public ApiResponse updateUser(String username, User user){
        ApiResponse response = new ApiResponse();
        int index = -1;
        for (User usr: users){
            if (usr.getUsername().equalsIgnoreCase(username)){
                index = users.indexOf(usr);
                break;
            }
        }
        if (index != -1) {
            users.set(index, user);
            response.setCode(200);
            response.setMessage("updated user successfully");
        }
        else {
            response.setCode(404);
            response.setMessage("username not found");
        }

        return response;
    }
}
