package ru.kpfu.itis.vagaviev.service.Impl;

import ru.kpfu.itis.vagaviev.Dao.impl.MessageDaoImpl;
import ru.kpfu.itis.vagaviev.model.Message;
import ru.kpfu.itis.vagaviev.service.Service;

import java.util.List;

public class MessagesServiceImpl implements Service<Message> {
      MessageDaoImpl messageDao = new MessageDaoImpl();

      @Override
      public Message get(String login) {
            return messageDao.get(login);
      }

      @Override
      public Message get(int id) {
            return messageDao.get(id);
      }

      @Override
      public List<Message> getAll() {
            return messageDao.getAll();
      }

      @Override
      public void save(Message message) {
            messageDao.save(message);
      }

      public List<Message> getAllMessagesForUsers(int id, int id1){
            return messageDao.getAllMessagesForThisChat(id, id1);
      }
}
