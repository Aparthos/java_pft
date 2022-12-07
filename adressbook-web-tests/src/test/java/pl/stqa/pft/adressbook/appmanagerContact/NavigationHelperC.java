package pl.stqa.pft.adressbook.appmanagerContact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelperC extends HelperBaseC {


  public WebDriver wd;

  NavigationHelperC(WebDriver wd) {
    super (wd);
  }

  public void chooseHome() {
    click(By.linkText("home"));
  }
}
