package pl.stqa.pft.mantis.applicationmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private final Properties properties;
  public WebDriver wd;


  private String browser;
  private RegistrationHelper registrationHelper;
  private FtpHelper ftp;
  private MailHelper mailHelper;
  private SoapHelper soapHelper;


  public ApplicationManager(String browser) throws IOException {
    this.browser = browser;

    String target = System.getProperty("target", "local");
    properties = new Properties();
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

  }

  public void init() throws IOException {


    String target = System.getProperty("target", "local");

    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));




  }


  public void stop() {

    if (wd != null) {


      wd.quit();
    }
  }

  public HttpSession newSesion() {

    return new HttpSession(this);

  }

  public String getProperty(String key) {

    return properties.getProperty(key);


  }


  public RegistrationHelper registration() {

    if (registrationHelper == null) {

      registrationHelper = new RegistrationHelper(this);
    }
    return registrationHelper;


  }


  public FtpHelper ftp() {

    if (ftp == null) {

      ftp = new FtpHelper(this);

    }

    return ftp;
  }

    public WebDriver getDriver() {

    if (wd == null) {
      if (browser.equals(Browser.FIREFOX.browserName())) {
        wd = new FirefoxDriver();
      } else if (browser.equals(Browser.CHROME.browserName())) {
        wd = new ChromeDriver();
      } else if (browser.equals(Browser.EDGE.browserName())) {
        wd = new EdgeDriver();
      }
      wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

      wd.get(properties.getProperty("web.baseURL"));

    }

      return wd;


  }

public MailHelper mail() {

    if (mailHelper == null) {

      mailHelper = new MailHelper(this);

    }
    return mailHelper;



}

public SoapHelper soap() {

  if (soapHelper == null) {

    soapHelper = new SoapHelper(this);

  }
  return soapHelper;
}



}



