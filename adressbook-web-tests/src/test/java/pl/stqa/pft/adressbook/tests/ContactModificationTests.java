package pl.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.adressbook.model.ContactData;

import java.util.*;

public class ContactModificationTests extends TestBaseC{

  @Test
  public void testContactModification() {



    app.getNavigationHelperC().chooseHome();

    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Kamil", "Malinowski", "Aparthos", "Mr.", "kamilmal7wp.pl@wp.pl", "test1"), true);


    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectID(before.size() - 1);
    app.getContactHelper().initContactModification();
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Kamil", "Malinowski", "Aparthos", "Mr.", "kamilmal7wp.pl@wp.pl", "test1");
    app.getContactHelper().createContact(new ContactData("Kamil", "Malinowski", "Aparthos", "Mr.", "kamilmal7wp.pl@wp.pl", "test1"), true);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelperC().chooseHome();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() );


    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }



}
