package pl.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.adressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactDetailsTest extends TestBase {


  @Test

  public void testContactDetails() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    ContactData contactInfoFromDetailsView = app.contact().infoFromViewForm(contact);
    assertThat(contactInfoFromDetailsView.getContactDetails()
                    .trim().replaceAll(" +", "").replaceAll("\\s", "")
                    .replaceAll("[HW:]", ""),
            equalTo(mergeAllInfo(contactInfoFromEditForm)
                    .trim().replaceAll(" +", "").replaceAll("\\s", "")));


  }

  private String mergeAllInfo(ContactData contact) {

    return Arrays.asList(contact.getFirstName(), contact.getLastName(), contact.getAddress(), contact.getHomePhone(),
                    contact.getMobilePhone(), contact.getWorkPhone(), contact.getEmail(), contact.getEmail2(),
                    contact.getEmail3())
            .stream().filter((s -> !s.equals("")))
            .collect(Collectors.joining("\n"));


  }
}