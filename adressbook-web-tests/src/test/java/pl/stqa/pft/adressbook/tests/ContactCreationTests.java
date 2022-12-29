package pl.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pl.stqa.pft.adressbook.model.ContactData;


import java.util.Set;

public class ContactCreationTests extends TestBaseC{


  @Test
  public void testContactCreation() throws Exception {


    app.goToC().Home();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withName("Kamil");
    app.contact().create(contact, true);
    app.goToC().Home();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);

    Assert.assertEquals(before, after);


  }


}



