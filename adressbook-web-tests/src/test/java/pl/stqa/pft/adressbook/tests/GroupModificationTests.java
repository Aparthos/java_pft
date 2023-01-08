package pl.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.adressbook.model.GroupData;
import pl.stqa.pft.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class GroupModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition() {


    if (app.db().groups().size() == 0) {
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("test1"));



    }


  }


  @Test
  public void testGroupModification() {

    Groups before = app.db().groups();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData().
            withtId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
    app.goTo().groupPage();
    app.group().modify(group);
    assertThat (app.group().count(), equalTo(before.size()));
    Groups after = app.db().groups();
    assertEquals(after.size(), before.size());

    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }


}
