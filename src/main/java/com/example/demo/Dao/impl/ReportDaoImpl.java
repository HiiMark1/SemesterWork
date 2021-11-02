package com.example.demo.Dao.impl;

import com.example.demo.Dao.DaoInterface;
import com.example.demo.helper.PostgresqlConnectionHelper;
import com.example.demo.model.Comment;
import com.example.demo.model.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReportDaoImpl implements DaoInterface<Report> {
      public static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
      private final Connection connection = PostgresqlConnectionHelper.getConnection();

      @Override
      public Report get(int id) {
            Report report = null;

            try {
                  String sqlRequest = "SELECT * FROM reports WHERE id = ?;";
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
                        boolean isTech = resultSet.getBoolean("isTech");
                        report = new Report(id, userId, date, text, isTech);
                  }

            } catch (SQLException throwables) {
                  LOGGER.warn("Failed to get report by ID");
            }
            return report;
      }

      @Override
      public Report get(String login) {
            return null;
      }

      @Override
      public List<Report> getAll() {
            try {
                  Statement statement = connection.createStatement();
                  String sql = "SELECT * FROM reports;";
                  ResultSet resultSet = statement.executeQuery(sql);

                  List<Report> reports = new ArrayList<>();

                  while (resultSet.next()) {
                        Report report = new Report(
                                resultSet.getInt("id"),
                                resultSet.getInt("userId"),
                                resultSet.getLong("date"),
                                resultSet.getString("text"),
                                resultSet.getBoolean("isTech")
                        );
                        reports.add(report);
                  }

                  return reports;
            } catch (SQLException throwables) {
                  LOGGER.warn("Failed execute getAll query.", throwables);
                  return new ArrayList<>();
            }
      }

      @Override
      public void save(Report report) {
            String sql = "INSERT INTO reports (userId, date, text, isTech) VALUES (?, ?, ?, ?);";

            try {
                  PreparedStatement preparedStatement = connection.prepareStatement(sql);
                  preparedStatement.setInt(1, report.getUserId());
                  preparedStatement.setLong(2, report.getDate());
                  preparedStatement.setString(3, report.getText());
                  preparedStatement.setBoolean(4, report.isTech());

                  preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                  LOGGER.warn("Failed to save new report.", throwables);
            }
      }
}
