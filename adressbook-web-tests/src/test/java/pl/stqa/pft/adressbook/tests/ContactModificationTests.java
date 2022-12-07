package pl.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.adressbook.model.ContactData;

public class ContactModificationTests extends TestBaseC{

  @Test
  public void testContactModification() {

    app.getNavigationHelperC().chooseHome();
    app.getContactHelper().selectID();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Kamil", "Malinowski", "Aparthos", "Mr.", "kamilmal7wp.pl@wp.pl"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelperC().chooseHome();




  }



}
