package pl.stqa.pft.adressbook.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.stqa.pft.adressbook.model.ContactData;

public class ContactDeletionTests extends TestBaseC {

  @Test (enabled = false)
  public void testContactDeletion() {


    app.getNavigationHelperC().chooseHome();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Kamil", "Malinowski", "Aparthos", "Mr.", "kamilmal7wp.pl@wp.pl", "test1"), true);


    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectID(before.size() - 1);
    app.getContactHelper().deleteSelectedContact();
    app.getNavigationHelperC().chooseHome();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);

      Assert.assertEquals(before, after);




  }
}
