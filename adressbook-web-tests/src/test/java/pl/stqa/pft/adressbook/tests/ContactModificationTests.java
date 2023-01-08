package pl.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.adressbook.model.ContactData;
import pl.stqa.pft.adressbook.model.Contacts;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;

public class ContactModificationTests extends TestBaseC{

  @BeforeMethod
  public void ensurePrecondition() {

    if (app.db().contacts().size() == 0) {


    app.goToC().Home();
    app.contact().create(new ContactData().withName("Kamil"), true);




    }
  }

  @Test
  public void testContactModification() {




    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withName("Kamil").withSurname("Malinowski")
            .withNickname("Aparthos").withTitle("Mr.").withEmail("kamilmal7wp.pl@wp.pl");

    app.contact().modify(contact);
    app.goToC().Home();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size() );

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }


}
