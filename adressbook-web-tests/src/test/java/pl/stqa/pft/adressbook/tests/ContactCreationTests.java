package pl.stqa.pft.adressbook.tests;

import org.testng.annotations.*;
import pl.stqa.pft.adressbook.model.ContactData;

public class ContactCreationTests extends TestBaseC{


  @Test
  public void testContactCreation() throws Exception {


    app.getNavigationHelperC().chooseHome();
    app.getContactHelper().chooseAddNew();
    app.getContactHelper().fillContactForm(new ContactData("Kamil", "Malinowski", "Aparthos", "Mr.", "kamilmal7wp.pl@wp.pl"));
    app.getContactHelper().submitContactForm();

  }


}
