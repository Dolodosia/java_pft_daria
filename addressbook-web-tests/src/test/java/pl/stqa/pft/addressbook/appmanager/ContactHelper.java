package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

//konstruktor
  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  //exp nowa metoda
  public void goToCreatenewContact() {
    click(By.linkText("add new"));
     }


  public void fillNewContactForm(ContactData contactData) {

    type(By.name("firstname"),contactData.getFirstname());
    type(By.name("lastname"),contactData.getLastname());
    type(By.name("phone"),contactData.getPhone());
    type(By.name("email"),contactData.getEmail());
  }

  public void newContactEnd() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }



/*
  public void addNewContact() {
    navigationHelper.wd.findElement(By.linkText("add new")).click();
  }
  */

  public void deleteContact() {
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }

  public void clickSelectedContactToDelete() {
    if (!wd.findElement(By.id("6")).isSelected()) {
      wd.findElement(By.id("6")).click();
    }
  }

  //m
  public void goToContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }

  //m
  public void goToHomePage() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  //m
  public void fillContactForm(ContactData contactData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
  }

  }
