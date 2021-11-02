package com.example.demo.Dao.impl;

import com.example.demo.Dao.DaoInterface;
import com.example.demo.helper.PostgresqlConnectionHelper;
import com.example.demo.model.Message;
import com.example.demo.model.User;
import com.example.demo.service.Impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl implements DaoInterface<Message> {
      UserServiceImpl userService = new UserServiceImpl();
      public static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
      private final Connection connection = PostgresqlConnectionHelper.getConnection();

      @Override
      public Message get(int id) {
            Message message = null;

            try {
                  String sqlRequest = "SELECT * FROM messages WHERE id = ?;";
                  PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
                  preparedStatement.setInt(1, id);
                  ResultSet resultSet = preparedStatement.executeQuery();
                  if (resultSet == null) {
                        return null;
                  }
                  while (resultSet.next()) {
                        int fromId = resultSet.getInt("fromId");
                        int toId = resultSet.getInt("toId");
                        long date = resultSet.getLong("date");
                        String text = resultSet.getString("text");
                        String name = resultSet.getString("name");
                        message = new Message(id, text, fromId, toId, date, name);
                  }

            } catch (SQLException throwables) {
                  LOGGER.warn("Failed to get report by ID");
            }
            return message;
      }

      @Override
      public Message get(String login) {
            return null;
      }

      @Override
      public List<Message> getAll() {
            try {
                  Statement statement = connection.createStatement();
                  String sql = "SELECT * FROM messages;";
                  ResultSet resultSet = statement.executeQuery(sql);

                  List<Message> messages = new ArrayList<>();

                  while (resultSet.next()) {
                        Message message = new Message(
                                resultSet.getInt("id"),
                                resultSet.getString("text"),
                                resultSet.getInt("fromId"),
                                resultSet.getInt("toId"),
                                resultSet.getLong("date"),
                                resultSet.getString("name")
                        );
                        messages.add(message);
                  }

                  return messages;
            } catch (SQLException throwables) {
                  LOGGER.warn("Failed execute getAll query.", throwables);
                  return new ArrayList<>();
            }
      }

      @Override
      public void save(Message message) {
            String sql = "INSERT INTO messages (fromId, toId, date, text, name) VALUES (?, ?, ?, ?, ?);";

            try {
                  PreparedStatement preparedStatement = connection.prepareStatement(sql);
                  preparedStatement.setInt(1, message.getFromId());
                  preparedStatement.setInt(2, message.getToId());
                  preparedStatement.setLong(3, message.getDate());
                  preparedStatement.setString(4, message.getText());
                  preparedStatement.setString(4, message.getName());
                  preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                  LOGGER.warn("Failed to save new report.", throwables);
            }
      }

      public List<Message> getAllMessagesForThisChat(int id, int id1) {
            try {
                  Statement statement = connection.createStatement();
                  String sql = "SELECT * FROM messages WHERE (fromId=?) AND (toId=?);";
                  PreparedStatement preparedStatement = connection.prepareStatement(sql);
                  preparedStatement.setInt(1, id);
                  preparedStatement.setInt(1, id1);
                  ResultSet resultSet = statement.executeQuery(sql);

                  List<Message> messages = new ArrayList<>();

                  while (resultSet.next()) {
                        Message message = new Message(
                                resultSet.getInt("id"),
                                resultSet.getString("text"),
                                resultSet.getInt("fromId"),
                                resultSet.getInt("toId"),
                                resultSet.getLong("date"),
                                resultSet.getString("name")
                        );
                        messages.add(message);
                  }

                  return messages;
            } catch (SQLException throwables) {
                  LOGGER.warn("Failed execute getAll query.", throwables);
                  return new ArrayList<>();
            }
      }
}
