package ru.kpfu.itis.vagaviev.service;

import java.util.List;

public interface Service<T> {
      T get(String login);

      T get(int id);

      List<T> getAll();

      void save(T t);
}