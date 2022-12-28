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

    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withName("Kamil"), true);


    }
  }

  @Test
  public void testContactModification() {




    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData().withId(before.get(index).getId()).withName("Kamil").withSurname("Malinowski").withNickname("Aparthos").withTitle("Mr.").withEmail("kamilmal7wp.pl@wp.pl");
    app.contact().modify(index, contact);
    app.goToC().Home();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() );


    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


}
