package pl.stqa.pft.adressbook.tests;


import org.hamcrest.CoreMatchers;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pl.stqa.pft.adressbook.appmanagerContact.ApplicationManagerC;
import pl.stqa.pft.adressbook.model.ContactData;
import pl.stqa.pft.adressbook.model.Contacts;
import pl.stqa.pft.adressbook.model.GroupData;

import java.io.IOException;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBaseC {

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


  public void verifyContactListInUI() {

    if (Boolean.getBoolean("verifyUI")) {
      Contacts dbContacts = app.db().contacts();
      Contacts uiContacts = app.contact().all();
      assertThat(uiContacts, equalTo(dbContacts.stream()
              .map((g) -> new ContactData().withId(g.getId()).withName(g.getName()).withSurname(g.getSurname())).collect(Collectors.toSet())));
    }


  }
}