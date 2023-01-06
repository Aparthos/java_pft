package pl.stqa.pft.adressbook.tests;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pl.stqa.pft.adressbook.appmanagerGroup.ApplicationManager;

import java.io.IOException;

public class TestBase {


  protected static final ApplicationManager app;

  static {
    try {
      app = new ApplicationManager(System.getProperty("browser"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

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
