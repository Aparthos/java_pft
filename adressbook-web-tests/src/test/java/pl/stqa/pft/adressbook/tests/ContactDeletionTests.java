package pl.stqa.pft.adressbook.tests;

import java.util.List;

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



    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    app.goToC().Home();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);

      Assert.assertEquals(before, after);




  }


}
