package pl.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pl.stqa.pft.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBaseC{


  @Test (enabled = false)
  public void testContactCreation() throws Exception {


    app.getNavigationHelperC().chooseHome();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Kamil", "Malinowski", "Aparthos", "Mr.", "kamilmal7wp.pl@wp.pl", "test1");
    app.getContactHelper().createContact(new ContactData("Kamil", "Malinowski", "Aparthos", "Mr.", "kamilmal7wp.pl@wp.pl", "test1"), true);
    app.getNavigationHelperC().chooseHome();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
  }



