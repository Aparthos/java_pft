package pl.stqa.pft.adressbook.tests;


import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pl.stqa.pft.adressbook.appmanagerContact.ApplicationManagerC;

import java.io.IOException;

public class TestBaseC{

  protected static final ApplicationManagerC app;

  static {
    try {
      app = new ApplicationManagerC(System.getProperty("browser"));
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

  public ApplicationManagerC getApp() {
    return app;
  }
}
