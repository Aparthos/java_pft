package pl.stqa.pft.adressbook.tests;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pl.stqa.pft.adressbook.appmanagerGroup.ApplicationManager;
import pl.stqa.pft.adressbook.model.GroupData;
import pl.stqa.pft.adressbook.model.Groups;

import java.io.IOException;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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

  public void verifyGroupListInUI() {


    if (Boolean.getBoolean("verifyUI")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupData().withtId(g.getId()).withName(g.getName())).collect(Collectors.toSet())));


    }


  }
}
