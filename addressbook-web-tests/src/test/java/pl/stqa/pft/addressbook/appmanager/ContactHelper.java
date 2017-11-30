package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
//import java.util.NoSuchElementException;

public class ContactHelper extends HelperBase {

  //konstruktor
  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  //ok
  public void goToContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }

  //ok
  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("home"), contactData.getPhone());
    type(By.name("email"), contactData.getEmail());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void createContact(ContactData contactData, boolean creation) {
    goToContactCreation();
    fillContactForm(contactData, true);
    goToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  //ok
  public void goToHomePage() {
    //wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }



  public void selectContact() {
    //click(By.id("49"));
    click(By.name("selected[]"));
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  //exp
public void contactUpdate() {
    wd.findElement(By.name("update")).click();
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void alertAccept() {
    wd.switchTo().alert().accept();
  }

  }

