package ru.kpfu.itis.vagaviev.modelDTO;

public class MessageDTO {
      int id;
      //500
      String text;
      int fromId;
      int toId;
      long date;
      String name;

      public MessageDTO(int id, String text, int fromId, int toId, long date, String name) {
            this.id = id;
            this.text = text;
            this.fromId = fromId;
            this.toId = toId;
            this.date = date;
            this.name = name;
      }

      public MessageDTO(String text, int fromId, int toId, long date, String name) {
            this.text = text;
            this.fromId = fromId;
            this.toId = toId;
            this.date = date;
            this.name = name;
      }

      public int getId() {
            return id;
      }

      public void setId(int id) {
            this.id = id;
      }

      public String getText() {
            return text;
      }

      public void setText(String text) {
            this.text = text;
      }

      public int getFromId() {
            return fromId;
      }

      public void setFromId(int fromId) {
            this.fromId = fromId;
      }

      public int getToId() {
            return toId;
      }

      public void setToId(int toId) {
            this.toId = toId;
      }

      public long getDate() {
            return date;
      }

      public void setDate(long date) {
            this.date = date;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }
}
