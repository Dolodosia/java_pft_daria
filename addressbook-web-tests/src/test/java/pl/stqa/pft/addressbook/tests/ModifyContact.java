package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

public class ModifyContact extends TestBase {

  @Test
  public void testContactModification(){

//app.getNavigationHelper().goToHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("contdxxxx", "modxxx", "123456789", "testwmod@test.com", null), false);
    app.getContactHelper().submitContactModification();

  }

}
