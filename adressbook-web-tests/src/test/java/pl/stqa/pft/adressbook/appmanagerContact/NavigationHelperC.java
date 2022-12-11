package pl.stqa.pft.adressbook.appmanagerContact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelperC extends HelperBaseC {


  public WebDriver wd;

  NavigationHelperC(WebDriver wd) {
    super (wd);
  }

  public void chooseHome() {

  if (isElementPresent(By.id("maintable")))  {

    return;
  }

    click(By.linkText("home"));
  }
}
