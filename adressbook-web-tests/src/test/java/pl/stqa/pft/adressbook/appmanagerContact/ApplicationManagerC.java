package pl.stqa.pft.adressbook.appmanagerContact;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import pl.stqa.pft.adressbook.appmanagerGroup.DbHelper;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManagerC {

  private final Properties properties;
  public WebDriver wd;

  private SessionHelperC sessionHelperC;
  private NavigationHelperC navigationHelperC;
  private ContactHelper contactHelper;

  private String browser;
  private DbHelper dbHelper;


  public ApplicationManagerC(String browser) throws IOException {



    this.browser = browser;

    String target = System.getProperty("target", "local");
    properties = new Properties();
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
  }

  public void init() throws IOException {





    String target = System.getProperty("target", "local");

    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));


    dbHelper = new DbHelper();


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
    wd.get(properties.getProperty("web.baseURL"));
    sessionHelperC.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));






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



  public ContactHelper contact() {
    return contactHelper;
  }

  public NavigationHelperC goToC() {
    return navigationHelperC;
  }


  public DbHelper db() {
    return dbHelper;
  }

}
