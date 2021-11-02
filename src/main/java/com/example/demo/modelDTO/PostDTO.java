package com.example.demo.modelDTO;

public class PostDTO {
      private int id;
      private int userId;
      private long date;
      private int rating;
      //500
      private String text;
      private String picUrl;
      //30
      private String name;

      public PostDTO(int id, int userId, long date, int rating, String text, String picUrl, String name) {
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

      public int getRating() {
            return rating;
      }

      public void setRating(int rating) {
            this.rating = rating;
      }

      public String getText() {
            return text;
      }

      public void setText(String text) {
            this.text = text;
      }

      public String getPicUrl() {
            return picUrl;
      }

      public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }
}
