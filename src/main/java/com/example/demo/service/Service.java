package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
      User get(String login);

      User get(int id);

      void save(User user);
}