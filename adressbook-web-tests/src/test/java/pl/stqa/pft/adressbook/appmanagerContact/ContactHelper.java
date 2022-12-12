package pl.stqa.pft.adressbook.appmanagerContact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.stqa.pft.adressbook.model.ContactData;

public class ContactHelper extends HelperBaseC {


  public ContactHelper(WebDriver wd) {
    super(wd);

  }


  public void chooseAddNew() {
    click(By.linkText("add new"));
  }


  public void selectID() {
    click(By.name("selected[]"));
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


  public void createContact(ContactData contact, boolean b) {

    chooseAddNew();
    fillContactForm(contact, b);
    submitContactForm();



  }

  public boolean isThereAContact() {

      return isElementPresent (By.name("selected[]"));

  }
}



