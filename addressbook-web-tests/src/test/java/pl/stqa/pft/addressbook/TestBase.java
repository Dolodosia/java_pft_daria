package pl.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
  FirefoxDriver wd;

  public static boolean isAlertPresent(FirefoxDriver wd) {
      try {
          wd.switchTo().alert();
          return true;
      } catch (NoAlertPresentException e) {
          return false;
      }
  }

  @BeforeMethod
  public void setUp() throws Exception {
      //wd = new FirefoxDriver();
      wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("C:/Program Files/Mozilla Firefox/firefox.exe"));

      login("admin", "secret");
  }

  private void login(String username, String password) {
      wd.get("http://localhost/addressbook/addressbook/");
      wd.findElement(By.name("user")).click();
      wd.findElement(By.name("user")).clear();
      wd.findElement(By.name("user")).sendKeys(username);
      wd.findElement(By.id("LoginForm")).click();
      wd.findElement(By.name("pass")).click();
      wd.findElement(By.name("pass")).clear();
      wd.findElement(By.name("pass")).sendKeys(password);
      wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  protected void returnToGroupPage() {
      wd.findElement(By.linkText("group page")).click();
  }

  protected void submitGroupCreation() {
      wd.findElement(By.name("submit")).click();
  }

  protected void fillGroupForm(GroupData groupData) {
      wd.findElement(By.name("group_name")).click();
      wd.findElement(By.name("group_name")).clear();
      wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
      wd.findElement(By.name("group_header")).click();
      wd.findElement(By.name("group_header")).clear();
      wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
      wd.findElement(By.name("group_footer")).click();
      wd.findElement(By.name("group_footer")).clear();
      wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  protected void initGroupCreation() {
      wd.findElement(By.name("new")).click();
  }

  protected void goToGroupPage() {
      wd.findElement(By.linkText("groups")).click();
  }

  @AfterMethod
  public void tearDown() {
      wd.quit();
  }

  protected void selectdeletedgroup() {
      wd.findElement(By.linkText("groups")).click();
  }

  protected void newContactEnd() {
      wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  protected void fillNewContactForm(ContactData contactData) {
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

  protected void addNewContact() {
      wd.findElement(By.linkText("add new")).click();
  }

  protected void deleteContact() {
      wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }


  protected void clickSelectedContactToDelete() {
      if (!wd.findElement(By.id("6")).isSelected()) {
          wd.findElement(By.id("6")).click();
      }
  }


  /*exp
  public void selectContact() {
    wd.click(By.id("6"));
     }
     */

     /*exp
     public void deleteContact1() {
      wd.click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
        }
        */



  //wersja exp
  protected void deleteSelectedGroup() {
    wd.findElement(By.name("delete")).click();
  }
//wersja exp
  protected void selectGroup() {
    if (!wd.findElement(By.xpath("//div[@id='content']/form/span[2]/input")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/span[2]/input")).click();


    }
  }
}