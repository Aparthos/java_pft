package pl.stqa.pft.adressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{

  private WebDriver wd;


  @Test
  public void testGroupDeletion() throws Exception {

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().deleteSelectedGroup();
   app.getGroupHelper().returnToGroupPage();
  }


}

