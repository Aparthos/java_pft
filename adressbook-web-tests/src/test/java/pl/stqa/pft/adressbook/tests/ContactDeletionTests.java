package pl.stqa.pft.adressbook.tests;


import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.*;
import pl.stqa.pft.adressbook.model.ContactData;


public class ContactDeletionTests extends TestBaseC {

  @BeforeMethod
  public void ensurePrecondition() {

    app.goToC().Home();

    if (!app.contact().isThereAContact()) {
      app.contact().create(new ContactData().withName("Kamil").withSurname("Malinowski"), true);


    }
  }



  @Test
  public void testContactDeletion() {



    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goToC().Home();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);

      Assert.assertEquals(before, after);




  }


}
