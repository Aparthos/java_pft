package pl.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.adressbook.model.ContactData;

import java.util.*;

public class ContactModificationTests extends TestBaseC{

  @BeforeMethod
  public void ensurePrecondition() {

    app.goToC().Home();

    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withName("Kamil"), true);


    }
  }

  @Test
  public void testContactModification() {




    Set<ContactData> before = app.contact().all();
    int index = before.size() - 1;
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withName("Kamil").withSurname("Malinowski").withNickname("Aparthos").withTitle("Mr.").withEmail("kamilmal7wp.pl@wp.pl");
    app.contact().modify(contact);
    app.goToC().Home();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() );


    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }


}
