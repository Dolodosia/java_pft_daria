package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.stqa.pft.addressbook.appmanager.ApplicationManager;
//import sun.plugin2.util.BrowserType;
import org.openqa.selenium.remote.BrowserType;


public class TestBase {

  protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();

  }

  @AfterMethod
  public void tearDown() {
    app.stop();
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
