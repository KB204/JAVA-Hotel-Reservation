package net.demo.services.impl;

import net.demo.entities.User;
import net.demo.exceptions.ResourceAlreadyExists;
import net.demo.exceptions.ResourceNotFoundException;
import net.demo.services.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.String.format;

public class UserServiceImpl implements UserService {
    private final List<User> users = new ArrayList<>();

    @Override
    public void setUser(int userId, double balance) {
        var user = new User(userId,balance, LocalDate.now());
        checkUser(user);
    }

    @Override
    public void printAllUsers() {
        users.stream()
                .sorted(Comparator.comparing(User::getCreatedAt).reversed())
                .forEach(System.out::println);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    private void checkUser(User user) {
        if (user.getBalance() < 0) {
            throw new ResourceNotFoundException("User balance cannot be negative");
        }
        if (users.contains(user)) {
            throw new ResourceAlreadyExists(format("User identified by the id %s already exists",user.getUserId()));
        } else {
            users.add(user);
        }
    }
}
