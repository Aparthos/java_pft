package pl.stqa.pft.adressbook.appmanagerContact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.stqa.pft.adressbook.model.ContactData;

public class ContactHelper extends HelperBaseC {


  public ContactHelper(WebDriver wd) {
    super(wd);

  }


  public void chooseAddNew() {
    click(By.linkText("add new"));
  }

  public void submitContactForm() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getName());

    type(By.name("lastname"), contactData.getSurname());

    type(By.name("nickname"), contactData.getNickname());

    type(By.name("title"), contactData.getTitle());

    type(By.name("email"), contactData.getEmail());
  }


    private void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete'"));
  }

}
