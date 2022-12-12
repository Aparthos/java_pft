package pl.stqa.pft.adressbook.tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.stqa.pft.adressbook.model.ContactData;

public class ContactDeletionTests extends TestBaseC {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelperC().chooseHome();

    if (! app.getContactHelper().isThereAContact()) {
          app.getContactHelper().createContact(new ContactData("Kamil", "Malinowski", "Aparthos", "Mr.", "kamilmal7wp.pl@wp.pl", "test1"), true);


    }



    app.getContactHelper().selectID();
    app.getContactHelper().deleteSelectedContact();
    app.getNavigationHelperC().chooseHome();



  }









}

