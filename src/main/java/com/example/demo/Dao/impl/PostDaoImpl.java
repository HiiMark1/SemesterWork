package com.example.demo.Dao.impl;

import com.example.demo.Dao.DaoInterface;
import com.example.demo.helper.PostgresqlConnectionHelper;
import com.example.demo.model.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDaoImpl implements DaoInterface<Post> {

      public static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

      private final Connection connection = PostgresqlConnectionHelper.getConnection();

      @Override
      public Post get(int id) {
            Post post = null;

            try {
                  String sqlRequest = "SELECT * FROM posts WHERE id = ?;";
                  PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
                  preparedStatement.setInt(1, id);
                  ResultSet resultSet = preparedStatement.executeQuery();
                  if (resultSet == null) {
                        return null;
                  }
                  while (resultSet.next()) {
                        int userId = resultSet.getInt("userId");
                        long date = resultSet.getLong("date");
                        int rating = resultSet.getInt("rating");
                        String text = resultSet.getString("text");
                        String picUrl = resultSet.getString("picUrl");
                        String name = resultSet.getString("name");
                        post = new Post(id, userId, date, rating, text, picUrl, name);
                  }

            } catch (SQLException throwables) {
                  LOGGER.warn("Failed to get post by ID");
            }
            return post;
      }

      @Override
      public Post get(String login) {
            LOGGER.warn("Can't get post by String");
            return null;
      }

      @Override
      public List<Post> getAll() {
            try {
                  Statement statement = connection.createStatement();
                  String sql = "SELECT * FROM posts";
                  ResultSet resultSet = statement.executeQuery(sql);

                  List<Post> posts = new ArrayList<>();

                  while (resultSet.next()) {
                        Post post = new Post(
                                resultSet.getInt("id"),
                                resultSet.getInt("userId"),
                                resultSet.getLong("date"),
                                resultSet.getInt("rating"),
                                resultSet.getString("text"),
                                resultSet.getString("picUrl"),
                                resultSet.getString("name")
                        );
                        posts.add(post);
                  }

                  return posts;
            } catch (SQLException throwables) {
                  LOGGER.warn("Failed execute getAll query.", throwables);
                  return new ArrayList<>();
            }
      }

      @Override
      public void save(Post post) {
            String sql = "INSERT INTO posts (userId, date, rating, text, picUrl, name) VALUES (?, ?, ?, ?, ?, ?);";

            try {
                  PreparedStatement preparedStatement = connection.prepareStatement(sql);
                  preparedStatement.setInt(1, post.getUserId());
                  preparedStatement.setLong(2, post.getDate());
                  preparedStatement.setInt(3, post.getRating());
                  preparedStatement.setString(4, post.getText());
                  preparedStatement.setString(5, post.getPicUrl());
                  preparedStatement.setString(6, post.getName());

                  preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                  LOGGER.warn("Failed to save new post.", throwables);
            }
      }

      public void changeRating(Post post, int rating) {
            try {
                  String str = "UPDATE posts SET rating = ? WHERE id = ?;";
                  PreparedStatement preparedStatement = connection.prepareStatement(str);
                  preparedStatement.setInt(1, rating);
                  preparedStatement.setInt(2, post.getId());
                  preparedStatement.executeUpdate();
            } catch (SQLException e) {
                  LOGGER.warn("Failed update post rating");
            }
      }

      public void changeText(Post post, String text) {
            try {
                  String str = "UPDATE users SET text = ? WHERE id = ?;";
                  PreparedStatement preparedStatement = connection.prepareStatement(str);
                  preparedStatement.setString(1, text);
                  preparedStatement.setInt(2, post.getId());
                  preparedStatement.executeUpdate();
            } catch (SQLException e) {
                  LOGGER.warn("Failed update post text");
            }
      }

      public void changePicUrl(Post post, String picUrl) {
            try {
                  String str = "UPDATE users SET picUrl = ? WHERE id = ?;";
                  PreparedStatement preparedStatement = connection.prepareStatement(str);
                  preparedStatement.setString(1, picUrl);
                  preparedStatement.setInt(2, post.getId());
                  preparedStatement.executeUpdate();
            } catch (SQLException e) {
                  LOGGER.warn("Failed update post pic Url");
            }
      }

      public void changeName(Post post, String name) {
            try {
                  String str = "UPDATE users SET name = ? WHERE id = ?;";
                  PreparedStatement preparedStatement = connection.prepareStatement(str);
                  preparedStatement.setString(1, name);
                  preparedStatement.setInt(2, post.getId());
                  preparedStatement.executeUpdate();
            } catch (SQLException e) {
                  LOGGER.warn("Failed update post pic Url");
            }
      }

      public List<Post> getLastTenPosts(){
            List<Post> posts = new ArrayList<>();
            try {
                  String str = "SELECT * FROM posts ORDER BY id DESC LIMIT 10";
                  Post post;
                  PreparedStatement preparedStatement = connection.prepareStatement(str);
                  ResultSet resultSet = preparedStatement.executeQuery();
                  if (resultSet == null) {
                        return null;
                  }
                  while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        int userId = resultSet.getInt("userId");
                        long date = resultSet.getLong("date");
                        int rating = resultSet.getInt("rating");
                        String text = resultSet.getString("text");
                        String picUrl = resultSet.getString("picUrl");
                        String name = resultSet.getString("name");
                        post = new Post(id, userId, date, rating, text, picUrl, name);
                        posts.add(post);
                  }
            } catch (SQLException throwables) {
                  LOGGER.warn("Failed to get 10 old posts");
            }
            return posts;
      }
}