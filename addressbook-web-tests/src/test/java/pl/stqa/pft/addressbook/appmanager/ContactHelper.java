package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.stqa.pft.addressbook.model.Contacts;
import pl.stqa.pft.addressbook.model.GroupData;
import pl.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("address"), contactData.getAddress());
    attach(By.name("photo"), contactData.getPhoto());
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

//exp ???
  public void create(ContactData contact, boolean creation) {
    goToContactCreation();
    fillContactForm(contact, true);
    contactCache = null;
    goToHomePage();
  }


  //ok
  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  //ok
  public void goToHomePage() {
    //wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    //click(By.xpath("//div[@id='content']/form/input[21]"));
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  //ok
  public void selectContact(int index) {
    index += 2;
    click(By.xpath("html/body/div/div[4]/form[2]/table/tbody/tr[" + index + "]/td[1]/input"));
    // click(By.name("selected[]"));
  }

  private void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
  }

//ok
  public void initContactModification(int index) {
    index += 2;
    click(By.xpath("html/body/div/div[4]/form[2]/table/tbody/tr[" + index + "]/td[8]/a/img"));
  }

  public void initContactModification() {
   click(By.name("update"));
   }

  public void selectContactToEditById(int id) {
    wd.findElement(By.xpath("//input[@id='"+ id + "']/../..//img[@title='Edit']")).click();
  }

  public void modify(ContactData contact) {
    selectContactToEditById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
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

  /*
  public void delete(int index) {
    selectContact(index);
    deleteContact();
    alertAccept();
  }
  */

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteContact();
    contactCache = null;
    alertAccept();
  }

  //ok
  public void alertAccept() {
    wd.switchTo().alert().accept();
  }

  //ok
  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  /*
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
*/

  /*
  //brakujaca metoda z lekcji m5 f 10...? ma byc zamiast allContacts...?
  public Set<ContactData> all(){
    Set<ContactData>contacts = new HashSet<ContactData>();
    List<WebElement> rows = wd.findElements((By.name("entry")));
    for (WebElement row : rows){
      List<WebElement> cells = row.findElements(By.tagName("td"));
      //int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String allPhones = cells.get(5).getText();
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withAllPhones(allPhones));
    }
    return contacts;
  }
*/
  private Contacts contactCache = null;


  //new version
  public Contacts allContacts() {
    if (contactCache !=null){
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
       List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element: elements) {
       List<WebElement> cells = element.findElements(By.tagName("td"));
             int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
             String lastname = cells.get(1).getText();
             String firstname = cells.get(2).getText();
              String allPhones = cells.get(5).getText();
            String allEmails = cells.get(4).getText();
      String address = cells.get(3).getText();
//String address = cells.get(3).getText();
      contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address));
           }
         return new Contacts(contactCache);
       }



  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
            .withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address);
  }

  private void initContactModificationById (int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s'", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
// alternatywne sposoby
//wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
//wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
//wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();

  }

  public ContactData infoFromDetailsForm(ContactData contact) {
    initContactDetailsById(contact.getId());
    String allDetails = wd.findElement(By.xpath("//div[@id='content']")).getText();
    wd.navigate().back();
    return new ContactData().withAllDetails(allDetails);
  }

  private void initContactDetailsById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();
  }




}






