package pl.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {



    @Test

    public void testContactCreation () {

      List<ContactData> before = app.getContactHelper().getContactList();
      app.getNavigationHelper().goToAddNewContactForm();
      ContactData contact = new ContactData("Kamil", "Malinowski");
      app.getContactHelper().createContact(contact);
      app.getNavigationHelper().goToHomePage();
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size() + 1);

      contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
      before.add(contact);
      Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
      app.logout();

    }
  }

