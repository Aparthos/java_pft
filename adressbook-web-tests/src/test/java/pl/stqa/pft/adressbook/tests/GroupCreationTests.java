package pl.stqa.pft.adressbook.tests;


import com.thoughtworks.xstream.XStream;
import org.testng.annotations.*;
import pl.stqa.pft.adressbook.model.ContactData;
import pl.stqa.pft.adressbook.model.GroupData;
import pl.stqa.pft.adressbook.model.Groups;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {


  @DataProvider
  public Iterator <Object[]> validGroups() throws IOException {


    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));



    }






    List<Object[]> list = new ArrayList<Object[]>();
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")))) {
      String xml = "";
      String line = reader.readLine();

      while (line != null) {

        xml += line;
        line = reader.readLine();


      }


      XStream xstream = new XStream();
      xstream.processAnnotations(GroupData.class);
      List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
      return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
    }



  @Test (dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) throws Exception {




      app.goTo().groupPage();
      Groups before = app.db().groups();
      app.group().create(group);
      Groups after = app.db().groups();
      assertThat(app.group().count(), equalTo(before.size() + 1));
      assertThat(after, equalTo(
              before.withAdded(group.withtId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));



  }

  @Test (enabled = false)
  public void testBadGroupCreation() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test2'");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));

  }
}
