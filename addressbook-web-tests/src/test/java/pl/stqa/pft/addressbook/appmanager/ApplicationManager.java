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
  public ContactHelper ContactHelper;
  public pl.stqa.pft.addressbook.appmanager.ContactHelper contactHelper;


  public void init() {
    //wd = new FirefoxDriver();
    wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("C:/Program Files/Mozilla Firefox/firefox.exe"));
    wd.get("http://localhost/addressbook/addressbook/");

    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
    ContactHelper = new ContactHelper(wd);
  }



  public void stop() { wd.quit();
  }

  public void selectdeletedgroup() {
      wd.findElement(By.linkText("groups")).click();
  }



  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}
