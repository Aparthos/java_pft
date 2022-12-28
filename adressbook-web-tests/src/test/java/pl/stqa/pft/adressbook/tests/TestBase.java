package pl.stqa.pft.adressbook.tests;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pl.stqa.pft.adressbook.appmanagerGroup.ApplicationManager;

public class TestBase {


  protected static final ApplicationManager app = new ApplicationManager(Browser.FIREFOX.browserName());

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();

  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();

  }
  public ApplicationManager getApp() {
    return app;
  }

}
