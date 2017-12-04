package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.GroupData;
import java.util.HashSet;
import java.util.Comparator;
import java.util.List;

public class CreateContactTests extends TestBase {

  @Test
  public void testCreateContact() {

    app.getContactHelper().goToContactCreation();
    ContactData contact = new ContactData( "ggggg", "kkkkk","777888999", "ggg@test.pl","test2");
    app.getContactHelper().fillContactForm(contact, true);
    app.getContactHelper().goToHomePage();


  }


}

