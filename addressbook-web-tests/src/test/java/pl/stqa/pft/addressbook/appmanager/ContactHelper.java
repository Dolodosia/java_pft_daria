package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
//import java.util.NoSuchElementException;

public class ContactHelper extends HelperBase {

  //ok
  private int id;

  //ok
  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  //ok
  public void goToContactCreation() {
    click(By.linkText("add new"));
  }

//ok
  public void click(By locator) {
       wd.findElement(locator).click();
     }

  //ok
  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("home"), contactData.getPhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("address"), contactData.getAddress());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

//ok
public void type(By locator, String text) {
  click(locator);
  wd.findElement(locator).clear();
  wd.findElement(locator).sendKeys(text);
}


//ok
  public void createContact(ContactData contact, boolean creation) {
    goToContactCreation();
    fillContactForm(contact, true);
    goToHomePage();
  }

  //ok
  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  //ok
  public void goToHomePage() {
    //wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }


  //ok
  public void selectContact(int index) {
    index += 2;
    click(By.xpath("html/body/div/div[4]/form[2]/table/tbody/tr[" + index + "]/td[1]/input"));
    // click(By.name("selected[]"));
  }

//ok
  public void initContactModification(int index) {
    index += 2;
    click(By.xpath("html/body/div/div[4]/form[2]/table/tbody/tr[" + index + "]/td[8]/a/img"));
  }

//ok
  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }


  //exp
  public void contactUpdate() {
    wd.findElement(By.name("update")).click();
  }

  //ok
  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  //ok
  public void alertAccept() {
    wd.switchTo().alert().accept();
  }

  //ok
  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }


  //exp
  public List<ContactData> getContactList() {

    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));

    for (WebElement element: elements) {

      List<WebElement> cells = element.findElements(By.tagName("td"));

      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));

      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();

      ContactData contact = new ContactData(id, firstname, lastname, null, null, null, null);

      contacts.add(contact);

    }

    return contacts;

  }

}






