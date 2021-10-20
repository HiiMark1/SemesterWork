package com.example.demo.modelDTO;

public class UserDTO {
      private int id;
      private int age;
      private String name;
      private String surname;
      private String mail;
      private String status;
      private String login;
      private String password;

      public UserDTO(int id, String login, String name, String surname, String mail, String status, String password, int age) {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.status = status;
            this.age = age;
            this.mail = mail;
            this.login = login;
            this.password = password;
      }

      public int getId() {
            return id;
      }

      public String getName() {
            return name;
      }

      public String getSurname() {
            return surname;
      }

      public String getStatus() {
            return status;
      }

      public int getAge() {
            return age;
      }

      public String getMail() {
            return mail;
      }

      public String getLogin(){
            return login;
      }

      public String getPassword(){
            return login;
      }
}
