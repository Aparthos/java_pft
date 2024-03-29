package pl.stqa.pft.adressbook.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "addressbook")
public class ContactData {

  private int id = Integer.MAX_VALUE;
  private String firstName;
  private String lastName;
  private String group;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String allPhones;
  private String email;
  private String email2;
  private String email3;
  private String allEmails;
  private String address;
  private String contactDetails;



  public int getId() {
    return this.id;
  }
  public ContactData withId(int id) {


    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }
  public ContactData withFirstName(String firstName) {


    this.firstName = firstName;
    return this;
  }
  public String getLastName() {
    return lastName;
  }
  public ContactData withLastName(String lastName) {


    this.lastName = lastName;
    return this;
  }
  public String getGroup() {
    return group;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getEmail() {
    return email;

  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public String getEmail2() {
    return email2;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public String getEmail3() {
    return email3;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public String getContactDetails() {
    return contactDetails;
  }

  public ContactData withContactDetails(String contactDetails) {
    this.contactDetails = contactDetails;
    return this;
  }


  @Override

  public String toString() {

    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';

  }
}
