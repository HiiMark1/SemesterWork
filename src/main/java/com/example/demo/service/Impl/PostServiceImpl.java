package com.example.demo.service.Impl;

import com.example.demo.Dao.impl.PostDaoImpl;
import com.example.demo.model.Post;
import com.example.demo.service.Service;

import java.util.List;

public class PostServiceImpl implements Service<Post> {
      private final PostDaoImpl postDao = new PostDaoImpl();

      @Override
      public List<Post> getAll() {
            return postDao.getAll();
      }

      @Override
      public Post get(String login) {
            return postDao.get(login);
      }

      @Override
      public Post get(int id) {
            return postDao.get(id);
      }

      @Override
      public void save(Post post) {
            postDao.save(post);
      }

      public void changeRating(Post post, int rating){
            postDao.changeRating(post, rating);
      }

      public void changeText(Post post, String text){
            postDao.changeText(post, text);
      }

      public void changePicUrl(Post post, String picUrl){
            postDao.changePicUrl(post, picUrl);
      }

      public List<Post> getLastTenPosts(){
            return postDao.getLastTenPosts();
      }

      public void changeName(Post post, String name){
            postDao.changeName(post, name);
      }
}