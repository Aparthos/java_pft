package pl.stqa.pft.adressbook.appmanagerContact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.stqa.pft.adressbook.model.ContactData;
import pl.stqa.pft.adressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBaseC {


  public ContactHelper(WebDriver wd) {
    super(wd);

  }


  public void chooseAddNew() {
    click(By.linkText("add new"));
  }






  public void selectContactByID(int id) {

    wd.findElement(By.cssSelector("input[value= '" + id + "']")).click();

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
    contactCache = null;
    submitContactForm();


  }

  public void modify(ContactData contact) {
    selectContactByID(contact.getId());
    initContactModification();
    create(contact, true);
    contactCache = null;
    submitContactModification();
  }


  public void delete(ContactData contact) {

    selectContactByID(contact.getId());
    deleteSelectedContact();
    contactCache = null;

  }

  public boolean isThereAContact() {

      return isElementPresent (By.name("selected[]"));

  }

  public int count() {

    return wd.findElements(By.name("selected[]")).size();

  }

  private Contacts contactCache = null;


  public Contacts all() {

  if (contactCache != null) {

    return new Contacts(contactCache);

  }


    contactCache = new Contacts();

    List<WebElement> elements = wd.findElements(By.cssSelector("span.contact"));
    for (WebElement element : elements) {
      String name = element.getText ();
      String surname = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("intput")).getAttribute("value"));
      ContactData contact = new ContactData().withId(id).withName(name);
      contactCache.add(contact);
    }
    return new Contacts(contactCache);
  }



}



