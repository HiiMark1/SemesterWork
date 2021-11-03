package ru.kpfu.itis.vagaviev.service.Impl;

import ru.kpfu.itis.vagaviev.Dao.impl.UserDaoImpl;
import ru.kpfu.itis.vagaviev.helper.PasswordHelper;
import ru.kpfu.itis.vagaviev.model.User;
import ru.kpfu.itis.vagaviev.service.Service;

import java.util.List;

public class UserServiceImpl implements Service<User> {
      private final UserDaoImpl userDao = new UserDaoImpl();

      @Override
      public List<User> getAll() {
            return userDao.getAll();
      }

      @Override
      public User get(String login) {
            return userDao.get(login);
      }

      @Override
      public User get(int id) {
            return userDao.get(id);
      }

      @Override
      public void save(User user) {
            user.setPassword(PasswordHelper.encrypt(user.getPassword()));
            userDao.save(user);
      }

      public void changeName(User user, String name){
            userDao.changeName(user, name);
      }

      public void changeSurname(User user, String surname){
            userDao.changeSurname(user, surname);
      }

      public void changeStatus(User user, String status){
            userDao.changeStatus(user, status);
      }

      public void changePassword(User user, String password){
            userDao.changePassword(user, password);
      }

      public void changeAge(User user, int age){
            userDao.changeAge(user, age);
      }

      public void changeImage(User user, String imageUrl){
            userDao.changeImage(user, imageUrl);
      }
}
