package net.demo.entities;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    private int userId;
    private double balance;
    private LocalDate createdAt;

    public User(int userId, double balance, LocalDate createdAt) {
        this.userId = userId;
        this.balance = balance;
        this.createdAt = createdAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return userId == user.userId && Double.compare(balance, user.balance) == 0 && Objects.equals(createdAt, user.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, balance, createdAt);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                '}';
    }
}
