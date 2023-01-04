package pl.stqa.pft.adressbook.tests;

import org.testng.annotations.*;
import pl.stqa.pft.adressbook.model.ContactData;
import pl.stqa.pft.adressbook.model.Contacts;


import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBaseC{


  @Test
  public void testContactCreation() throws Exception {


    app.goToC().Home();
    Contacts before = app.contact().all();

    ContactData contact = new ContactData().withName("Kamil").withSurname("Malinowski");

    File photo = new File("src/test/resources/images.jfif");
    app.contact().create(new ContactData().withName("Kamil").withSurname("Malinowski").withPhoto(photo), false);
    app.goToC().Home();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(
            contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));


  }


}



