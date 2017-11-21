package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pl.stqa.pft.addressbook.model.ContactData;

public class ApplicationManager {

  FirefoxDriver wd;

  private SessionHelper sessionHelper;
  private  NavigationHelper navigationHelper;
  private GroupHelper groupHelper;



  public void init() {
    //wd = new FirefoxDriver();
    wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("C:/Program Files/Mozilla Firefox/firefox.exe"));
    wd.get("http://localhost/addressbook/addressbook/");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }



  public void stop() { wd.quit();
  }

  public void selectdeletedgroup() {
      wd.findElement(By.linkText("groups")).click();
  }

  public void newContactEnd() {
      wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillNewContactForm(ContactData contactData) {
      wd.findElement(By.name("firstname")).click();
     wd.findElement(By.name("firstname")).clear();
      wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
      wd.findElement(By.name("lastname")).click();
     wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
      wd.findElement(By.name("mobile")).click();
      wd.findElement(By.name("mobile")).clear();
     wd.findElement(By.name("mobile")).sendKeys(contactData.getPhone());
      wd.findElement(By.name("email")).click();
      wd.findElement(By.name("email")).clear();
      wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
  }

  public void addNewContact() {
      navigationHelper.wd.findElement(By.linkText("add new")).click();
  }

  public void deleteContact() {
      wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }

  public void clickSelectedContactToDelete() {
      if (!wd.findElement(By.id("6")).isSelected()) {
          wd.findElement(By.id("6")).click();
      }
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
