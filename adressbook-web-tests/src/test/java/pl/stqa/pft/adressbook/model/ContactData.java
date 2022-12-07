package pl.stqa.pft.adressbook.model;

public class ContactData {

  private final String name;
  private final String surname;
  private final String nickname;
  private final String title;
  private final String email;


  public ContactData (String name, String surname, String nickname, String title, String email) {

    this.name = name;
    this.surname = surname;
    this.nickname = nickname;
    this.title = title;
    this.email = email;


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
}