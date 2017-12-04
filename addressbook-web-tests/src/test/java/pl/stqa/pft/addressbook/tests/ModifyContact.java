package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ModifyContact extends TestBase {

  //ok
  @Test
  public void testContactModification(){

    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("x", "x", "111222333", "test@test.pl", "test2"),true);
    }

    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();

    ContactData contact = new ContactData("janina", "testerka", "888444888", "test@test.pl","test3");

    app.getContactHelper().fillContactForm(contact, false);


  }

}
