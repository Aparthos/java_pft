package pl.stqa.pft.adressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.stqa.pft.adressbook.appmanagerContact.ApplicationManagerC;
import pl.stqa.pft.adressbook.appmanagerGroup.ApplicationManager;

public class TestBase extends ApplicationManager{


  protected final ApplicationManager app = new ApplicationManager();

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
