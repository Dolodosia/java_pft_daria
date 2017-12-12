package pl.stqa.pft.addressbook.tests;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pl.stqa.pft.addressbook.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;


public class TestBase {

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

          //=new ApplicationManager(BrowserType.FIREFOX);

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();

  }

  @AfterSuite
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
