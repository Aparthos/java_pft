package pl.stqa.pft.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import pl.stqa.pft.adressbook.model.ContactData;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactPhoneTests extends TestBaseC {

@Test

  public void testContactPhones() {

  app.goToC();
  ContactData contact = app.contact().all().iterator().next();
  ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

  assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));

}

  private String mergePhones(ContactData contact) {

    return  Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())


            .stream().filter((s) -> !s.equals(""))

            .map(ContactPhoneTests::cleaned)


            .collect(Collectors.joining("\n"));


}

  public static String cleaned (String phone) {

  return phone.replaceAll("\\s", "").replaceAll("[-()]","");

}


}
