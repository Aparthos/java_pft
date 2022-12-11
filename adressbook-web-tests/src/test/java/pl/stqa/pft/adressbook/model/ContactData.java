package pl.stqa.pft.adressbook.model;

import java.awt.*;

public class ContactData {

  private final String name;
  private final String surname;
  private final String nickname;
  private final String title;
  private final String email;

  private String group;


  public ContactData (String name, String surname, String nickname, String title, String email, String group) {

    this.name = name;
    this.surname = surname;
    this.nickname = nickname;
    this.title = title;
    this.email = email;
    this.group = group;


  }

  public String getName() {
    return name;

    }

  public String getSurname() {
    return surname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }
}