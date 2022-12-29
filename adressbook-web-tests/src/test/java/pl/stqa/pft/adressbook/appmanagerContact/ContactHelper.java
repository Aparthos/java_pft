package pl.stqa.pft.adressbook.appmanagerContact;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.stqa.pft.adressbook.model.ContactData;
import pl.stqa.pft.adressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    Set<ContactData> contacts = new HashSet<ContactData>();
  List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("intput")).getAttribute("value"));
      String name = cells.get(1).getText ();
      String surname = cells.get(2).getText();
      String email = cells.get(4).getText();
      String allPhones = cells.get(5).getText();
      String address = cells.get(3).getText();
      contacts.add(new ContactData().withId(id).withName(name).withSurname(surname)
                      .withAllPhones(allPhones));
      ContactData contact = new ContactData().withId(id).withName(name);

      contactCache.add(contact);
    }
    return new Contacts(contactCache);
  }


  public ContactData infoFromEditForm(ContactData contact) {

    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withName(firstname).withSurname(lastname).withEmail(email)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withAddress(address);

  }

  private void initContactModificationById(int id) {

  WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value= '%s']", id)));
  WebElement row = checkbox.findElement(By.xpath("./../.."));
  List<WebElement> cells = row.findElements(By.tagName("td"));
  cells.get(7).findElement(By.tagName("a")).click();




  }
}



