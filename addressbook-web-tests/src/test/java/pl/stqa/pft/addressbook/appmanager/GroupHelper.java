package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
      click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  //wersja exp
  public void deleteSelectedGroup() {
    click(By.name("delete"));
  }

  //wersja exp
  public void selectGroup() {
    if (!wd.findElement(By.xpath("//div[@id='content']/form/span[2]/input")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/span[2]/input"));


    }
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModifications() {
    click(By.name("update"));
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
