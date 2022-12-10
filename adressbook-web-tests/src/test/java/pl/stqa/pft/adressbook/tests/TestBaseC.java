package pl.stqa.pft.adressbook.tests;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.stqa.pft.adressbook.appmanagerContact.ApplicationManagerC;

public class TestBaseC{

  protected final ApplicationManagerC app = new ApplicationManagerC(Browser.CHROME.browserName());

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();

  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();

  }

  public ApplicationManagerC getApp() {
    return app;
  }
}
