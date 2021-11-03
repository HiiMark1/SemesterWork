package ru.kpfu.itis.vagaviev.Dao.impl;

import ru.kpfu.itis.vagaviev.Dao.DaoInterface;
import ru.kpfu.itis.vagaviev.helper.PasswordHelper;
import ru.kpfu.itis.vagaviev.helper.PostgresqlConnectionHelper;
import ru.kpfu.itis.vagaviev.model.User;
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
            String sqlRequest = "SELECT * FROM users WHERE id = ?;";
            User user = null;

            try {
                  PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
                  preparedStatement.setInt(1, id);
                  ResultSet resultSet = preparedStatement.executeQuery();
                  if (resultSet == null) {
                        return null;
                  }
                  while (resultSet.next()) {
                        String name = resultSet.getString("name");
                        String surname = resultSet.getString("surname");
                        String status = resultSet.getString("status");
                        String login = resultSet.getString("login");
                        String password = resultSet.getString("password");
                        String mail = resultSet.getString("mail");
                        int age = resultSet.getInt("age");
                        String imageUri = resultSet.getString("image");
                        user = new User(id, login, mail, password, name, surname, status, age, imageUri);
                  }

            } catch (SQLException throwables) {
                  LOGGER.warn("Failed to get user by ID");
            }
            return user;
      }

      @Override
      public User get(String login) {
            String sqlRequest = "SELECT * FROM users WHERE login = ?;";
            User user = null;

            try {
                  PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
                  preparedStatement.setString(1, login);
                  ResultSet resultSet = preparedStatement.executeQuery();
                  if (resultSet == null) {
                        return null;
                  }
                  while (resultSet.next()) {
                        String name = resultSet.getString("name");
                        String surname = resultSet.getString("surname");
                        String status = resultSet.getString("status");
                        String password = resultSet.getString("password");
                        String mail = resultSet.getString("mail");
                        int age = resultSet.getInt("age");
                        int id = resultSet.getInt("id");
                        String imageUri = resultSet.getString("image");
                        user = new User(id, login, mail, password, name, surname, status, age, imageUri);
                  }

            } catch (SQLException throwables) {
                  LOGGER.warn("Failed to get user by ID");
            }
            return user;
      }

      @Override
      public List<User> getAll() {
            try {
                  Statement statement = connection.createStatement();
                  String sql = "SELECT * FROM users;";
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
                                resultSet.getInt("age"),
                                resultSet.getString("image")
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
            String sql = "INSERT INTO users(login, mail, name, surname, status, password, age) VALUES (?, ?, ?, ?, ?, ?, ?);";

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

      public void changeName(User user, String name) {
            try {
                  String str = "UPDATE users SET name = ? WHERE id = ?;";
                  PreparedStatement preparedStatement = connection.prepareStatement(str);
                  preparedStatement.setString(1, name);
                  preparedStatement.setInt(2, user.getId());
                  preparedStatement.executeUpdate();
            } catch (SQLException e) {
                  LOGGER.warn("Failed update users Name");
            }
      }

      public void changeSurname(User user, String surname) {
            try {
                  String str = "UPDATE users SET surname = ? WHERE id = ?;";
                  PreparedStatement preparedStatement = connection.prepareStatement(str);
                  preparedStatement.setString(1, surname);
                  preparedStatement.setInt(2, user.getId());
                  preparedStatement.executeUpdate();
            } catch (SQLException e) {
                  LOGGER.warn("Failed update users Surname");
            }
      }

      public void changeStatus(User user, String status) {
            try {
                  String str = "UPDATE users SET status = ? WHERE id = ?;";
                  PreparedStatement preparedStatement = connection.prepareStatement(str);
                  preparedStatement.setString(1, status);
                  preparedStatement.setInt(2, user.getId());
                  preparedStatement.executeUpdate();
            } catch (SQLException e) {
                  LOGGER.warn("Failed update users Status");
            }
      }

      public void changePassword(User user, String password) {
            try {
                  String str = "UPDATE users SET password = ? WHERE id = ?;";
                  PreparedStatement preparedStatement = connection.prepareStatement(str);
                  preparedStatement.setString(1, PasswordHelper.encrypt(password));
                  preparedStatement.setInt(2, user.getId());
                  preparedStatement.executeUpdate();
            } catch (SQLException e) {
                  LOGGER.warn("Failed update users Password");
            }
      }

      public void changeAge(User user, int age) {
            try {
                  String str = "UPDATE users SET age = ? WHERE id = ?;";
                  PreparedStatement preparedStatement = connection.prepareStatement(str);
                  preparedStatement.setInt(1, age);
                  preparedStatement.setInt(2, user.getId());
                  preparedStatement.executeUpdate();
            } catch (SQLException e) {
                  LOGGER.warn("Failed update users Age");
            }
      }

      public void changeImage(User user, String imageUrl) {
            try {
                  String str = "UPDATE users SET image = ? WHERE id = ?;";
                  PreparedStatement preparedStatement = connection.prepareStatement(str);
                  preparedStatement.setString(1, imageUrl);
                  preparedStatement.setInt(2, user.getId());
                  preparedStatement.executeUpdate();
            } catch (SQLException e) {
                  LOGGER.warn("Failed update users Image");
            }
      }
}