package pl.stqa.pft.adressbook.tests;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pl.stqa.pft.adressbook.appmanagerContact.ApplicationManagerC;

public class TestBaseC{

  protected static final ApplicationManagerC app = new ApplicationManagerC(Browser.FIREFOX.browserName());

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();

  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();

  }

  public ApplicationManagerC getApp() {
    return app;
  }
}
