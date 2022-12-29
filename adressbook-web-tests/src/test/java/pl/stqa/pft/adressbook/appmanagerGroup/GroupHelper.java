package pl.stqa.pft.adressbook.appmanagerGroup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.stqa.pft.adressbook.model.GroupData;
import pl.stqa.pft.adressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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



  public void selectedGroupById(int id) {
    wd.findElement(By.cssSelector("input[value= '" + id + "']")).click();
  }


  public void create(GroupData group) {

    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();

  }

  public void modify(GroupData group) {
    selectedGroupById(group.getId());
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    returnToGroupPage();

  }




  public void delete(GroupData group) {
    selectedGroupById(group.getId());
    deleteSelectedGroup();
    returnToGroupPage();


  }

  public boolean isThereAGroup () {
      return isElementPresent(By.name("selected"));
    }

    public int getGroupCount () {
      return wd.findElements(By.name("selected[]")).size();
    }

    public Groups all() {

      Groups groups = new Groups();
      List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));

      for (WebElement element : elements) {

        String name = element.getText();
        int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
        groups.add(new GroupData().withtId(id).withName(name));

      }


      return groups;

    }



}

