package com.example.demo.model;

public class Report {
      int id;
      int userId;
      long date;
      //2000
      String text;
      boolean isTech;

      public Report(int id, int userId, long date, String text, boolean isTech) {
            this.id = id;
            this.userId = userId;
            this.date = date;
            this.text = text;
            this.isTech = isTech;
      }

      public Report(int userId, long date, String text, boolean isTech) {
            this.userId = userId;
            this.date = date;
            this.text = text;
            this.isTech = isTech;
      }

      public int getId() {
            return id;
      }

      public void setId(int id) {
            this.id = id;
      }

      public int getUserId() {
            return userId;
      }

      public void setUserId(int userId) {
            this.userId = userId;
      }

      public long getDate() {
            return date;
      }

      public void setDate(long date) {
            this.date = date;
      }

      public String getText() {
            return text;
      }

      public void setText(String text) {
            this.text = text;
      }

      public boolean isTech() {
            return isTech;
      }

      public void setTech(boolean tech) {
            isTech = tech;
      }
}
