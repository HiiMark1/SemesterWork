package ru.kpfu.itis.vagaviev.modelDTO;

public class UserDTO {
      private int id;
      private int age;
      private String name;
      private String surname;
      private String mail;
      private String status;
      private String login;
      private String password;
      private String imageUri;

      public UserDTO(int id, int age, String name, String surname, String mail, String status, String login, String password, String imageUri) {
            this.id = id;
            this.age = age;
            this.name = name;
            this.surname = surname;
            this.mail = mail;
            this.status = status;
            this.login = login;
            this.password = password;
            this.imageUri = imageUri;
      }

      public int getId() {
            return id;
      }

      public void setId(int id) {
            this.id = id;
      }

      public int getAge() {
            return age;
      }

      public void setAge(int age) {
            this.age = age;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public String getSurname() {
            return surname;
      }

      public void setSurname(String surname) {
            this.surname = surname;
      }

      public String getMail() {
            return mail;
      }

      public void setMail(String mail) {
            this.mail = mail;
      }

      public String getStatus() {
            return status;
      }

      public void setStatus(String status) {
            this.status = status;
      }

      public String getLogin() {
            return login;
      }

      public void setLogin(String login) {
            this.login = login;
      }

      public String getPassword() {
            return password;
      }

      public void setPassword(String password) {
            this.password = password;
      }

      public String getImageUri() {
            return imageUri;
      }

      public void setImageUri(String imageUri) {
            this.imageUri = imageUri;
      }
}
