package pl.stqa.pft.adressbook.appmanagerContact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.stqa.pft.adressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBaseC {


  public ContactHelper(WebDriver wd) {
    super(wd);

  }


  public void chooseAddNew() {
    click(By.linkText("add new"));
  }


  public void selectID(int index) {

    wd.findElements(By.name("selected[]")).get(index).click();

  }


  public void submitContactForm() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getName());

    type(By.name("lastname"), contactData.getSurname());

    type(By.name("nickname"), contactData.getNickname());

    type(By.name("title"), contactData.getTitle());

    type(By.name("email"), contactData.getEmail());


    if (creation)  {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());


    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }



  public void deleteSelectedContact () {
      click(By.name("Delete"));
    }

    public void initContactModification () {
      click(By.xpath("img[@alt='Edit'"));
    }


    public void submitContactModification () {
      click(By.name("submit"));
    }


  public void create(ContactData contact, boolean b) {

    chooseAddNew();
    fillContactForm(contact, b);
    submitContactForm();



  }

  public void modify(int index, ContactData contact) {
    selectID(index);
    initContactModification();
    create(new ContactData("Kamil", "Malinowski", "Aparthos", "Mr.", "kamilmal7wp.pl@wp.pl", "test1"), true);
    submitContactModification();
  }

  public void delete(int index) {
    selectID(index);
    deleteSelectedContact();

  }


  public boolean isThereAContact() {

      return isElementPresent (By.name("selected[]"));

  }

  public int getContactCount() {

    return wd.findElements(By.name("selected[]")).size();

  }

  public List<ContactData> list() {

    List<ContactData> contacts = new ArrayList<ContactData>();

    List<WebElement> elements = wd.findElements(By.cssSelector("span.contact"));
    for (WebElement element : elements) {
      String name = element.getText ();
      String surname = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("intput")).getAttribute("value"));
      ContactData contact = new ContactData(id,name, surname, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }





}



