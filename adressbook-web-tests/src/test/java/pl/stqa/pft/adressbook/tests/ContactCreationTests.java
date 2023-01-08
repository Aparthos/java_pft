package pl.stqa.pft.adressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.*;
import pl.stqa.pft.adressbook.model.ContactData;
import pl.stqa.pft.adressbook.model.Contacts;
import pl.stqa.pft.adressbook.model.GroupData;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBaseC {


  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {

    if (app.db().contacts().size() == 0) {


      app.goToC().Home();
      app.contact().create(new ContactData().withName("Kamil"), true);




    }



    List<Object[]> list = new ArrayList<Object[]>();
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.xml")))) {
      String xml = "";
      String line = reader.readLine();

      while (line != null) {

        xml += line;
        line = reader.readLine();


      }

      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);

      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }

  }

  @Test(dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) throws Exception {


    app.goToC().Home();
    Contacts before = app.db().contacts();


    File photo = new File("src/test/resources/images.jfif");
    app.contact().create(new ContactData().withName("Kamil").withSurname("Malinowski").withPhoto(photo), false);
    app.goToC().Home();
    Contacts after = app.db().contacts();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(
            contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));


  }
}





