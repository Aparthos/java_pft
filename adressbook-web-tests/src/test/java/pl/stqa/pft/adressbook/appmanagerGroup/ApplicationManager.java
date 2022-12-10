package pl.stqa.pft.adressbook.appmanagerGroup;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Browser;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  public WebDriver wd;

  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;

  private String browser;

  public ApplicationManager(String browser) {
  this.browser = browser;

  }

  public void init() {

    if (browser == Browser.FIREFOX.browserName()) {
      wd = new FirefoxDriver();
    } else if (browser == Browser.CHROME.browserName()) {
      wd = new ChromeDriver();
    } else if (browser == Browser.EDGE.browserName()) {
      wd = new EdgeDriver();
    }
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    groupHelper = new GroupHelper((FirefoxDriver) wd);
    navigationHelper = new NavigationHelper (wd);
    sessionHelper = new SessionHelper(wd);
    wd.get("http://localhost/addressbook/edit.php#");
    sessionHelper.login("admin", "secret");

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



  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
