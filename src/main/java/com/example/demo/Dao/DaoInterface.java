package com.example.demo.Dao;

import java.util.List;

public interface DaoInterface<T> {
      T get(int id);

      List<T> getAll();

      void save(T t);
}
