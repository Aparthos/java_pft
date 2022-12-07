package pl.stqa.pft.adressbook.appmanagerContact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelperC extends HelperBaseC{
  private WebDriver wd;

  public SessionHelperC(WebDriver wd) {

    super(wd);
  }

  public void login(String username, String password) {
    type(By.name("user"), username);
    type(By.name("pass"), password);
    click(By.xpath("//input[@value='Login']"));
  }




}


