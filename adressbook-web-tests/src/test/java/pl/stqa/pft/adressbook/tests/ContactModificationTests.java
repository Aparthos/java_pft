package pl.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.adressbook.model.ContactData;

public class ContactModificationTests extends TestBaseC{

  @Test
  public void testContactModification() {



    app.getNavigationHelperC().chooseHome();
    int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Kamil", "Malinowski", "Aparthos", "Mr.", "kamilmal7wp.pl@wp.pl", "test1"), true);


    }
    app.getContactHelper().selectID();
    app.getContactHelper().initContactModification();
    app.getContactHelper().createContact(new ContactData("Kamil", "Malinowski", "Aparthos", "Mr.", "kamilmal7wp.pl@wp.pl", "test1"), true);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelperC().chooseHome();

    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);


  }



}
