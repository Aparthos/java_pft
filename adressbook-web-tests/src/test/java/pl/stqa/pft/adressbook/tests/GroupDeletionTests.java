package pl.stqa.pft.adressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.adressbook.model.GroupData;

public class GroupDeletionTests extends TestBase{

  private WebDriver wd;


  @Test
  public void testGroupDeletion() throws Exception {


    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if (app.getGroupHelper().isThereAGroup()) {

      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }


    app.getGroupHelper().selectedGroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before - 1);

  }


}

