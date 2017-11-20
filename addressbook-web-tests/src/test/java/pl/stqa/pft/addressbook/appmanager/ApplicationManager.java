package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pl.stqa.pft.addressbook.model.ContactData;

public class ApplicationManager {

  private final GroupHelper groupHelper = new GroupHelper();

  public static boolean isAlertPresent(FirefoxDriver wd) {
      try {
          wd.switchTo().alert();
          return true;
      } catch (NoAlertPresentException e) {
          return false;
      }
  }

  public void init() {
    //wd = new FirefoxDriver();
    groupHelper.wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("C:/Program Files/Mozilla Firefox/firefox.exe"));
    groupHelper.wd.get("http://localhost/addressbook/addressbook/");
    login("admin", "secret");
  }

  public void login(String username, String password) {

      groupHelper.wd.findElement(By.name("user")).click();
      groupHelper.wd.findElement(By.name("user")).clear();
      groupHelper.wd.findElement(By.name("user")).sendKeys(username);
      groupHelper.wd.findElement(By.id("LoginForm")).click();
      groupHelper.wd.findElement(By.name("pass")).click();
      groupHelper.wd.findElement(By.name("pass")).clear();
      groupHelper.wd.findElement(By.name("pass")).sendKeys(password);
      groupHelper.wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  public void goToGroupPage() {
      groupHelper.wd.findElement(By.linkText("groups")).click();
  }

  public void stop() {
    groupHelper.wd.quit();
  }

  public void selectdeletedgroup() {
      groupHelper.wd.findElement(By.linkText("groups")).click();
  }

  public void newContactEnd() {
      groupHelper.wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillNewContactForm(ContactData contactData) {
      groupHelper.wd.findElement(By.name("firstname")).click();
      groupHelper.wd.findElement(By.name("firstname")).clear();
      groupHelper.wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
      groupHelper.wd.findElement(By.name("lastname")).click();
      groupHelper.wd.findElement(By.name("lastname")).clear();
      groupHelper.wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
      groupHelper.wd.findElement(By.name("mobile")).click();
      groupHelper.wd.findElement(By.name("mobile")).clear();
      groupHelper.wd.findElement(By.name("mobile")).sendKeys(contactData.getPhone());
      groupHelper.wd.findElement(By.name("email")).click();
      groupHelper.wd.findElement(By.name("email")).clear();
      groupHelper.wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
  }

  public void addNewContact() {
      groupHelper.wd.findElement(By.linkText("add new")).click();
  }

  public void deleteContact() {
      groupHelper.wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }

  public void clickSelectedContactToDelete() {
      if (!groupHelper.wd.findElement(By.id("6")).isSelected()) {
          groupHelper.wd.findElement(By.id("6")).click();
      }
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }
}
