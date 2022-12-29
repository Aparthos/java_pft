package pl.stqa.pft.adressbook.tests;


import org.testng.annotations.*;
import pl.stqa.pft.adressbook.model.GroupData;
import pl.stqa.pft.adressbook.model.Groups;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {



  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName ("test2");
    app.group().create(group);
    Groups after = app.group().all();
    assertThat (app.group().count(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(group.withtId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));



  }

  @Test
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
