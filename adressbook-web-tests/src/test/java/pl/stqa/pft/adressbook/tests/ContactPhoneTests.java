package pl.stqa.pft.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import pl.stqa.pft.adressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactPhoneTests extends TestBaseC {

@Test

  public void testContactPhones() {

  app.goToC();
  ContactData contact = app.contact().all().iterator().next();
  ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

  assertThat(contact.getHomePhone(), equalTo(contactInfoFromEditForm.getHomePhone()));
  assertThat(contact.getMobilePhone(), equalTo(contactInfoFromEditForm.getMobilePhone()));
  assertThat(contact.getWorkPhone(), equalTo(contactInfoFromEditForm.getWorkPhone()));
}

public String cleaned (String phone) {

  return phone.replaceAll("\\s", "").replaceAll("[-()]","");

}


}
