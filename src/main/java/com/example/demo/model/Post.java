package com.example.demo.model;

import java.util.List;

public class Post {
      int id;
      String AuthMail;
      long date;
      int rating;
      List<String> pics;

      public Post(int id, String authMail, long date, int rating, List<String> pics) {
            this.id = id;
            AuthMail = authMail;
            this.date = date;
            this.rating = rating;
            this.pics = pics;
      }

      public int getId() {
            return id;
      }

      public void setId(int id) {
            this.id = id;
      }

      public String getAuthMail() {
            return AuthMail;
      }

      public void setAuthMail(String authMail) {
            AuthMail = authMail;
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

      public List<String> getPics() {
            return pics;
      }

      public void setPics(List<String> pics) {
            this.pics = pics;
      }
}
