package pl.stqa.pft.adressbook.appmanagerContact;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;


import java.util.concurrent.TimeUnit;

public class ApplicationManagerC {

  public WebDriver wd;

  private SessionHelperC sessionHelperC;
  private NavigationHelperC navigationHelperC;
  private ContactHelper contactHelper;

  private String browser;

  public ApplicationManagerC(String browser) {
    this.browser = browser;
  }

  public void init() {

    String browser = Browser.FIREFOX.browserName();
    if (browser.equals(Browser.FIREFOX.browserName())) {
      wd = new FirefoxDriver();
    } else if (browser.equals(Browser.CHROME.browserName())) {
      wd = new ChromeDriver();
    } else if (browser.equals(Browser.EDGE.browserName())) {
      wd = new EdgeDriver();
    }
    wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    contactHelper = new ContactHelper(wd);
    navigationHelperC = new NavigationHelperC(wd);
    sessionHelperC = new SessionHelperC(wd);
    wd.get("http://localhost/addressbook");
    sessionHelperC.login("admin", "secret");
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
