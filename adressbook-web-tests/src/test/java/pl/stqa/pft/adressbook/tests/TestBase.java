package pl.stqa.pft.adressbook.tests;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.stqa.pft.adressbook.appmanagerContact.ApplicationManagerC;
import pl.stqa.pft.adressbook.appmanagerGroup.ApplicationManager;

public class TestBase {


  protected final ApplicationManager app = new ApplicationManager(Browser.EDGE.browserName());

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();

  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();

  }
  public ApplicationManager getApp() {
    return app;
  }

}
