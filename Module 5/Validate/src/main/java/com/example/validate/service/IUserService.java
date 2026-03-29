package com.example.validate.service;

import com.example.validate.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void save(User user);
}
