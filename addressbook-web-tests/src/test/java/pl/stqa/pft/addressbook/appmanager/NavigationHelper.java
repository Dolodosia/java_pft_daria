package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {


  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void goToGroupPage() {
    click(By.linkText("groups"));
  }

  public void goToHomePage() {
   click(By.xpath("//div[@id='content']/form/input[21]"));
     }


  //exp new method
  public void goToCreatenewContact() {
    click(By.linkText("add new"));
  }


}
