package com.example.demo.Dao.impl;

import com.example.demo.Dao.DaoInterface;
import com.example.demo.helper.PostgresqlConnectionHelper;
import com.example.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements DaoInterface<User> {

      public static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

      private final Connection connection = PostgresqlConnectionHelper.getConnection();

      @Override
      public User get(int id) {
            return null;
      }

      @Override
      public List<User> getAll() {
            try {
                  Statement statement = connection.createStatement();
                  String sql = "SELECT * FROM users";
                  ResultSet resultSet = statement.executeQuery(sql);

                  List<User> users = new ArrayList<>();

                  while (resultSet.next()) {
                        User user = new User(
                                resultSet.getInt("id"),
                                resultSet.getString("login"),
                                resultSet.getString("mail"),
                                resultSet.getString("password"),
                                resultSet.getString("name"),
                                resultSet.getString("surname"),
                                resultSet.getString("status"),
                                resultSet.getInt("age")
                        );
                        users.add(user);
                  }

                  return users;
            } catch (SQLException throwables) {
                  LOGGER.warn("Failed execute getAll query.", throwables);
                  return new ArrayList<>();
            }
      }

      @Override
      public void save(User user) {
            String sql = "INSERT INTO users (login, mail, name, surname, status, password, age) VALUES (?, ?, ?, ?, ?, ?, ?);";

            try {
                  PreparedStatement preparedStatement = connection.prepareStatement(sql);
                  preparedStatement.setString(1, user.getLogin());
                  preparedStatement.setString(2, user.getMail());
                  preparedStatement.setString(3, user.getName());
                  preparedStatement.setString(4, user.getSurname());
                  preparedStatement.setString(5, user.getStatus());
                  preparedStatement.setString(6, user.getPassword());
                  preparedStatement.setInt(7, user.getAge());

                  preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                  LOGGER.warn("Failed to save new user.", throwables);
            }
      }
}