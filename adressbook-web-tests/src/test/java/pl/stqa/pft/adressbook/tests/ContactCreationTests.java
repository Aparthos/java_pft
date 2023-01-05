package pl.stqa.pft.adressbook.tests;

import org.testng.annotations.*;
import pl.stqa.pft.adressbook.model.ContactData;
import pl.stqa.pft.adressbook.model.Contacts;
import pl.stqa.pft.adressbook.model.GroupData;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBaseC {


  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {

    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
    String line = reader.readLine();

    while (line != null) {

      String[] split = line.split(";");
      list.add(new Object[]{new ContactData().withName(split[0]).withSurname(split[1])});
      line = reader.readLine();


    }

  return list.iterator();

  }

  @Test(dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) throws Exception {


    app.goToC().Home();
    Contacts before = app.contact().all();


    File photo = new File("src/test/resources/images.jfif");
    app.contact().create(new ContactData().withName("Kamil").withSurname("Malinowski").withPhoto(photo), false);
    app.goToC().Home();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(
            contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));


  }
}





