package pl.stqa.pft.adressbook.appmanagerGroup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase{


  public SessionHelper(WebDriver wd) {
   super (wd);
    this.wd = wd;

 }
  public void login(String username, String password) {
    type(By.name("user"), username);
    type(By.name("pass"), password);
    click(By.xpath("//input[@value='Login']"));
  }

}
