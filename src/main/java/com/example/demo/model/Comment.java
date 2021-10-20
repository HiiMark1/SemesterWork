package com.example.demo.model;

public class Comment {
      int id;
      String AuthMail;
      long date;
      int rating;

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

      public Comment(int id, String authMail, long date, int rating) {
            this.id = id;
            AuthMail = authMail;
            this.date = date;
            this.rating = rating;
      }
}
