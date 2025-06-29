package net.demo.services;

import net.demo.entities.User;

import java.util.List;

public interface UserService {
    void setUser(int userId, double balance);
    void printAllUsers();
    List<User> getAllUsers();
}
