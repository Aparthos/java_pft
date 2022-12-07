package pl.stqa.pft.adressbook.tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactDeletionTests extends TestBaseC {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelperC().chooseHome();
    app.getContactHelper().selectID();
    app.getContactHelper().deleteSelectedContact();
    app.getNavigationHelperC().chooseHome();



  }









}

