package pl.stqa.pft.adressbook.appmanagerContact;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

public class ApplicationManagerC {

  public WebDriver wd;

  private SessionHelperC sessionHelperC;
  private NavigationHelperC navigationHelperC;
  private ContactHelper contactHelper;

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    contactHelper = new ContactHelper(wd);
    navigationHelperC = new NavigationHelperC(wd);
    sessionHelperC = new SessionHelperC(wd);
    wd.get("http://localhost/addressbook/edit.php#");
    sessionHelperC.login("admin", "secret");
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }



  public void stop() {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }



  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public NavigationHelperC getNavigationHelperC() {
    return navigationHelperC;
  }
}
