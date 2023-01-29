package pl.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.stqa.pft.adressbook.model.ContactData;
import pl.stqa.pft.adressbook.model.Contacts;

import java.util.List;


public class ContactHelper extends HelperBase {
  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillNewContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByIndex(0);
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }


  public void submitNewContactForm() {

    click(By.name("submit"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();

  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
    acceptAlert();

  }

  public void initContactModification() {

    wd.findElement(By.xpath("//img[@alt='Edit']")).click();
  }

  public void submitContactModification() {

    click(By.name("update"));
  }

  public void create(ContactData contact) {

    fillNewContactForm(contact, true);

    submitNewContactForm();

    contactCache = null;

  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    initContactModification();
    fillNewContactForm(contact, false);
    submitContactModification();
    contactCache = null;
  }


  public void delete(ContactData contact) {

    selectContactById(contact.getId());
    deleteSelectedContacts();
    waitForDynamicElement(By.cssSelector("div.msgbox"));
    contactCache = null;

  }


  public boolean isThereAContact() {

    return isElementPresent(By.name("selected[]"));

  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {

    if (contactCache != null) {
      return new Contacts ();
    }
    contactCache = new Contacts();
    List<WebElement> rows = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String firstName = cells.get(2).getText();
      String lastName = cells.get(1).getText();
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      String address = cells.get(3).getText();
      contactCache.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName)
              .withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address));

    }

    return new Contacts();

  }

  public ContactData infoFromEditForm(ContactData contact) {

    initContactModificationById(contact.getId());
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getText();
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstName).withLastName(lastName).withHomePhone(home)
            .withMobilePhone(mobile).withWorkPhone(work).withEmail(email)
            .withEmail2(email2).withEmail3(email3).withAddress(address);
  }
  private void initContactModificationById(int id){
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }


}
