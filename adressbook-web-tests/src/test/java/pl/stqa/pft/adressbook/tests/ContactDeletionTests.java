package pl.stqa.pft.adressbook.tests;


import java.util.Set;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;
import pl.stqa.pft.adressbook.model.ContactData;
import pl.stqa.pft.adressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;


public class ContactDeletionTests extends TestBaseC {

  @BeforeMethod
  public void ensurePrecondition() {

    if (app.db().contacts().size() == 0) {


      app.goToC().Home();
      app.contact().create(new ContactData().withName("Kamil"), true);




    }
  }



  @Test
  public void testContactDeletion() {



    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goToC().Home();
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();

    assertEquals(after.size(), before.size() - 1);

    assertThat(after, equalTo(before.without (deletedContact)));





  }


}
