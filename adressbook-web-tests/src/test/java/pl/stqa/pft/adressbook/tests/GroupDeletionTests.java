package pl.stqa.pft.adressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.adressbook.model.GroupData;

import java.util.List;

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
  public void testGroupDeletion() throws Exception {



    List<GroupData> before = app.group().list();

    app.group().delete(before);
    List<GroupData> after = app.group().list();

    Assert.assertEquals(after.size(), before.size() - 1);


    before.remove(before.size() - 1);
      Assert.assertEquals(before, after);


    }




}




