package pl.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.adressbook.model.ContactData;

public class ContactCreationTest extends TestBase {



    @Test

    public void testContactCreation () {
      app.getNavigationHelper().goToAddNewContactForm();
      app.getContactHelper().fillNewContactForm(new ContactData("Kamil", "Malinowski",
              "+48 538 191 625", "kamilmal7wp.pl@wp.pl"));
      app.logout();
    }
  }

