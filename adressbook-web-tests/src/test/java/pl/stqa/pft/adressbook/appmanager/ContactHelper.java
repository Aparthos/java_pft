package pl.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.stqa.pft.adressbook.model.ContactData;


public class ContactHelper extends HelperBase {
  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void fillNewContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("mobile"), contactData.getMobileNumber());
    type(By.name("email"), contactData.getEmail());
    click(By.name("submit"));
  }
}


