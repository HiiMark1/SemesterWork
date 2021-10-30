package com.example.demo.model;

import java.util.List;

public class Post {
      int id;
      int userId;
      long date;
      int rating;
      String text;
      String picUrl;
      String name;

      public Post(int id, int userId, long date, int rating, String text, String picUrl, String name) {
            this.id = id;
            this.userId = userId;
            this.date = date;
            this.rating = rating;
            this.text = text;
            this.picUrl = picUrl;
            this.name = name;
      }

      public Post(int userId, long date, int rating, String text, String picUrl, String name) {
            this.id = id;
            this.userId = userId;
            this.date = date;
            this.rating = rating;
            this.text = text;
            this.picUrl = picUrl;
            this.name = name;
      }

      public int getId() {
            return id;
      }

      public void setId(int id) {
            this.id = id;
      }

      public long getDate() {
            return date;
      }

      public void setDate(long date) {
            this.date = date;
      }

      public int getRating() {
            return rating;
      }

      public void setRating(int rating) {
            this.rating = rating;
      }

      public String getPicUrl() {
            return picUrl;
      }

      public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
      }

      public int getUserId() {
            return userId;
      }

      public void setUserId(int userId) {
            this.userId = userId;
      }

      public String getText() {
            return text;
      }

      public void setText(String text) {
            this.text = text;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }
}
