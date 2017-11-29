package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import java.util.NoSuchElementException;
import org.openqa.selenium.NoSuchElementException;

public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

//nowa wewrsja
protected void type(By locator, String text) {
  click(locator);
  if (text != null) {
    //wd.findElement(locator).clear();
    //wd.findElement(locator).sendKeys(text);
    String existingText = wd.findElement(locator).getAttribute("value");
    if (!text.equals(existingText)) {
      //wd.findElement(locator).clear();
      wd.findElement(locator).clear();
      wd.findElement(locator).sendKeys(text);
    }
  }
}

  /* moja wersja
  protected void type(By locator, String text) {
    click(locator);
    if (text != null) {
      String existingText = wd.findElement(locator).getAttribute("value");
      if(!text.equals(existingText)){
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }

    }
  }
*/

  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
