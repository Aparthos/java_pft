package pl.stqa.pft.adressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.adressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase{

  private WebDriver wd;


  @Test
  public void testGroupDeletion() throws Exception {


    app.getNavigationHelper().gotoGroupPage();

    if (app.getGroupHelper().isThereAGroup()) {

      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();

    app.getGroupHelper().selectedGroup(before.size() - 1);
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();

    Assert.assertEquals(after.size(), before.size() - 1);

  }


}

