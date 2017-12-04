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
      app.getContactHelper().createContact(new ContactData("x", "x", "111222333", "test@test.pl", "test2", "adr"),true);
    }

    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().initContactModification(before.size()-1);

    ContactData contact = new ContactData(before.get(before.size()-1).getId(),"janina", "testerka", "888444888", "test@test.pl","test3", "addr");

    app.getContactHelper().fillContactForm(contact, false);

    app.getContactHelper().submitContactModification();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size()- 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}
