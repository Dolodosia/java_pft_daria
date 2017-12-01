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

      //lista OK...?
        //int before = app.getContactHelper().getContactCount();
      List<ContactData> before = app.getContactHelper().getContactList();

      app.getContactHelper().goToContactCreation();

      ContactData contact = new ContactData("jan", "tester", "666555222", "gmail@email.pl","test2");

      app.getContactHelper().fillContactForm(contact, true);
      app.getContactHelper().goToHomePage();

      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size() + 1);

      contact.setId(after.stream().max((t1, t2) -> Integer.compare(t1.getId(), t2.getId())).get().getId());
      before.add(contact);
      Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);

    }


}

