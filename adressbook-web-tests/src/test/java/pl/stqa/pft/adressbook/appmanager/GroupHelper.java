package pl.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.stqa.pft.adressbook.model.GroupData;

public class GroupHelper extends HelperBase {

  public GroupHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("Logout"));
  }

  public void submitGroupCreation() {
    click(By.linkText("group page"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.name());
    type(By.name("group_header"), groupData.header());
    type(By.name("group_footer"), groupData.footer());
    click(By.name("submit"));
  }

  public void initGroupCreation() {
    click(By.xpath("//div[@id='content']/form/input[4]"));
  }

  public void deleteSelectedGroup() {
    click(By.name("delete"));
  }
}
