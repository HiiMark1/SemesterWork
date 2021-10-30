package com.example.demo.service.Impl;

import com.example.demo.Dao.impl.CommentDaoImpl;
import com.example.demo.model.Comment;
import com.example.demo.service.Service;

import java.util.List;

public class CommentServiceImpl implements Service<Comment> {
      private final CommentDaoImpl commentDao = new CommentDaoImpl();

      @Override
      public List<Comment> getAll() {
            return commentDao.getAll();
      }

      @Override
      public Comment get(String login) {
            return commentDao.get(login);
      }

      @Override
      public Comment get(int id) {
            return commentDao.get(id);
      }

      @Override
      public void save(Comment comment) {
            commentDao.save(comment);
      }

      public List<Comment> getLastTenPosts(){
            return commentDao.getLastTenComments();
      }
}