package pl.stqa.pft.adressbook;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{

  private WebDriver wd;


  @Test
  public void testGroupDeletion() throws Exception {

    gotoGroupPage();
    deleteSelectedGroup();
   returnToGroupPage();
  }


}

