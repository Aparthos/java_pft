package pl.stqa.pft.adressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.adressbook.model.GroupData;


import java.util.Set;

public class GroupDeletionTests extends TestBase{

  private WebDriver wd;

  @BeforeMethod
  public void ensurePrecondition() {

    app.goTo().groupPage();

    if (app.group().isThereAGroup()) {

      app.group().create(new GroupData().withName("test2"));
    }


  }


  @Test
  public void testGroupDeletion() {



    Set<GroupData> before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Set<GroupData> after = app.group().all();

    Assert.assertEquals(after.size(), before.size() - 1);


    before.remove(deletedGroup);
      Assert.assertEquals(before, after);


    }




}




