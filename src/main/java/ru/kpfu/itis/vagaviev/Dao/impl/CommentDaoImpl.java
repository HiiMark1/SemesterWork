package ru.kpfu.itis.vagaviev.Dao.impl;

import ru.kpfu.itis.vagaviev.Dao.DaoInterface;
import ru.kpfu.itis.vagaviev.helper.PostgresqlConnectionHelper;
import ru.kpfu.itis.vagaviev.model.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl implements DaoInterface<Comment> {

      public static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

      private final Connection connection = PostgresqlConnectionHelper.getConnection();

      @Override
      public Comment get(int id) {
            Comment comment = null;

            try {
                  String sqlRequest = "SELECT * FROM comments WHERE id = ?;";
                  PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
                  preparedStatement.setInt(1, id);
                  ResultSet resultSet = preparedStatement.executeQuery();
                  if (resultSet == null) {
                        return null;
                  }
                  while (resultSet.next()) {
                        int userId = resultSet.getInt("userId");
                        long date = resultSet.getLong("date");
                        String text = resultSet.getString("text");
                        int postId = resultSet.getInt("postId");
                        comment = new Comment(id, userId, date, text, postId);
                  }

            } catch (SQLException throwables) {
                  LOGGER.warn("Failed to get comment by ID");
            }
            return comment;
      }

      @Override
      public Comment get(String login) {
            LOGGER.warn("Can't get comment by String");
            return null;
      }

      @Override
      public List<Comment> getAll() {
            try {
                  Statement statement = connection.createStatement();
                  String sql = "SELECT * FROM comments";
                  ResultSet resultSet = statement.executeQuery(sql);

                  List<Comment> comments = new ArrayList<>();

                  while (resultSet.next()) {
                        Comment comment = new Comment(
                                resultSet.getInt("id"),
                                resultSet.getInt("userId"),
                                resultSet.getLong("date"),
                                resultSet.getString("text"),
                                resultSet.getInt("postId")
                        );
                        comments.add(comment);
                  }

                  return comments;
            } catch (SQLException throwables) {
                  LOGGER.warn("Failed execute getAll query.", throwables);
                  return new ArrayList<>();
            }
      }

      @Override
      public void save(Comment comment) {
            String sql = "INSERT INTO comments (userId, date, text, postId) VALUES (?, ?, ?, ?);";

            try {
                  PreparedStatement preparedStatement = connection.prepareStatement(sql);
                  preparedStatement.setInt(1, comment.getUserId());
                  preparedStatement.setLong(2, comment.getDate());
                  preparedStatement.setString(3, comment.getText());
                  preparedStatement.setInt(4, comment.getPostId());

                  preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                  LOGGER.warn("Failed to save new comment.", throwables);
            }
      }

      public List<Comment> getPostComments(int post_id){
            List<Comment> comments = new ArrayList<>();
            try {
                  String str = "SELECT * FROM comments WHERE postId=? ORDER BY id DESC;";
                  Comment comment;
                  PreparedStatement preparedStatement = connection.prepareStatement(str);
                  preparedStatement.setInt(1, post_id);
                  ResultSet resultSet = preparedStatement.executeQuery();
                  if (resultSet == null) {
                        return null;
                  }
                  while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        int userId = resultSet.getInt("userId");
                        long date = resultSet.getLong("date");
                        String text = resultSet.getString("text");
                        int postId = resultSet.getInt("postId");
                        comment = new Comment(id, userId, date, text, postId);
                        comments.add(comment);
                  }
            } catch (SQLException throwables) {
                  LOGGER.warn("Failed to get 10 old comments");
            }
            return comments;
      }
}