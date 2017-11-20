package pl.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends ApplicationManager{

  @BeforeMethod
  public void setUp() throws Exception {
    init();

  }

  @AfterMethod
  public void tearDown() {
    stop();
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


}
