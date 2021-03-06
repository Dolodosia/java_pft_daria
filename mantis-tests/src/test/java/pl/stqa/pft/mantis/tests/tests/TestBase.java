package pl.stqa.pft.mantis.tests.tests;


import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pl.stqa.pft.mantis.tests.appmanager.ApplicationManager;


import java.lang.reflect.Method;
import java.util.Arrays;


public class TestBase {


  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

          //=new ApplicationManager(BrowserType.FIREFOX);

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();

  }

  @AfterSuite (alwaysRun = true)
  public void tearDown() {
    app.stop();
  }



}
