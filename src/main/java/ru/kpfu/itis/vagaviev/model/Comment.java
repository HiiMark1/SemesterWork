package ru.kpfu.itis.vagaviev.model;

public class Comment {
      int id;
      int userId;
      long date;
      //1000
      String text;
      int postId;

      public Comment(int id, int userId, long date, String text, int postId) {
            this.id = id;
            this.userId = userId;
            this.date = date;
            this.text = text;
            this.postId = postId;
      }

      public int getPostId() {
            return postId;
      }

      public void setPostId(int postId) {
            this.postId = postId;
      }

      public Comment(int userId, long date, String text, int postId) {
            this.userId = userId;
            this.date = date;
            this.text = text;
            this.postId = postId;
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
}
