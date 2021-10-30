package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface Service<T> {
      T get(String login);

      T get(int id);

      List<T> getAll();

      void save(T t);
}