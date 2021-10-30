package com.example.demo.Dao;

import java.util.List;

public interface DaoInterface<T> {
      T get(int id);

      T get(String login);

      List<T> getAll();

      void save(T t);


}
