package ru.kpfu.itis.vagaviev.service.Impl;

import ru.kpfu.itis.vagaviev.Dao.impl.CommentDaoImpl;
import ru.kpfu.itis.vagaviev.model.Comment;
import ru.kpfu.itis.vagaviev.service.Service;

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

      public List<Comment> getPostComments(int id){
            return commentDao.getPostComments(id);
      }
}