package pl.stqa.pft.adressbook.model;

import java.util.Objects;

public class ContactData {

  private int id = Integer.MAX_VALUE;
  private String name;
  private String surname;
  private String nickname;
  private String title;
  private String email;

  private String group;
  private String home;
  private String mobile;
  private String work;


  public void setGroup(String group) {
    this.group = group;
  }


  public int getId() {

    return id;
  }
  public ContactData withId(int id) {

    this.id = id;
    return this;

  }



  public ContactData withName(String name) {
    this.name = name;
    return this;
  }

  public ContactData withSurname(String surname) {
    this.surname = surname;
    return this;

  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;

  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;

  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;

  }

  public ContactData withHomePhone(String home) {
    this.home = home;
    return this;

  }

  public ContactData withMobilePhone(String mobile) {
    this.mobile = mobile;
    return this;

  }
  public ContactData withWorkPhone(String work) {
    this.work = work;
    return this;

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
  public String getHomePhone() {
    return home;
  }

  public String getMobilePhone() {
    return mobile;
  }

  public String getWorkPhone() {
    return work;
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

    if (id != that.id) return false;
    if (!Objects.equals(name, that.name)) return false;
    return Objects.equals(surname, that.surname);
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    return result;
  }


}
