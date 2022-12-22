package pl.stqa.pft.adressbook.model;

import java.awt.*;
import java.util.Objects;

public class ContactData {

  private int id;
  private final String name;
  private final String surname;
  private final String nickname;
  private final String title;
  private final String email;

  private String group;


  public void setGroup(String group) {
    this.group = group;
  }




  public ContactData (String name, String surname, String nickname, String title, String email, String group) {

    this.id = Integer.MAX_VALUE;
    this.name = name;
    this.surname = surname;
    this.nickname = nickname;
    this.title = title;
    this.email = email;
    this.group = group;


  }

  public ContactData (int id, String name, String surname, String nickname, String title, String email, String group) {

    this.id = id;
    this.name = name;
    this.surname = surname;
    this.nickname = nickname;
    this.title = title;
    this.email = email;
    this.group = group;


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

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            '}';
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (!Objects.equals(name, that.name)) return false;
    return Objects.equals(surname, that.surname);
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    return result;
  }

}