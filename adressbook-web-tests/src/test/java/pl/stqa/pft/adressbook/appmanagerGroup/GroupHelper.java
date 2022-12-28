package pl.stqa.pft.adressbook.appmanagerGroup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.stqa.pft.adressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
    click(By.name("submit"));
  }

  public void initGroupCreation() {
    click(By.xpath("//div[@id='content']/form/input[4]"));
  }

  public void deleteSelectedGroup() {
    click(By.name("delete"));
  }

  public void initGroupModification() {
    click(By.name("edit"));

  }

  public void submitGroupModification() {
    click(By.name("update"));

  }

  public void selectedGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();

  }

  public void create(GroupData group) {

    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();

  }

  public void modify(int index, GroupData group) {
    selectedGroup(index);
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    returnToGroupPage();

  }

  public void delete(List<GroupData> before) {
    selectedGroup(before.size() - 1);
    deleteSelectedGroup();
    returnToGroupPage();
  }



  public boolean isThereAGroup () {
      return isElementPresent(By.name("selected"));
    }

    public int getGroupCount () {
      return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> list() {

      List<GroupData> groups = new ArrayList<GroupData>();
      List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));

      for (WebElement element : elements) {

        String name = element.getText();
        int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
        groups.add(new GroupData().withtId(id).withName(name));

      }


      return groups;

    }


}

