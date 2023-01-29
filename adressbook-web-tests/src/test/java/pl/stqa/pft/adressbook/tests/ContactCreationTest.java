package pl.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.adressbook.model.ContactData;
import pl.stqa.pft.adressbook.model.Contacts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactCreationTest extends TestBase {



    @Test

    public void testContactCreation () {

      Contacts before = app.contact().all();
      app.goTo().newContactForm();
      ContactData contact = new ContactData().withFirstName("Kamil").withLastName("Malinowski");
      app.contact().create(contact);
      app.goTo().homePage();
      Contacts after = app.contact().all();
      Assert.assertEquals(after.size(), before.size() + 1);

      assertThat(after, equalTo(
              before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));


    }

@Test

public void testBadContactCreation() {

  Contacts before = app.contact().all();
  app.goTo().newContactForm();
  ContactData contact = new ContactData().withFirstName("Kamil").withLastName("Malinowski");
  app.contact().create(contact);
  app.goTo().homePage();
  assertThat(app.contact().count(), equalTo(before.size()));
  Contacts after = app.contact().all();
  assertThat(after, equalTo(before));


}




}


