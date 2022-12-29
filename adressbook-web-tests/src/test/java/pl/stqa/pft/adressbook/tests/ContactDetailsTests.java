package pl.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.adressbook.model.ContactData;

public class ContactDetailsTests extends TestBaseC{




  @Test

  public void testContactAddress() {

    app.goToC();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);







  }


}
