package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;
import pl.stqa.pft.addressbook.model.GroupData;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;


public class CreateContactTests extends TestBase {

  @Test
  public void testCreateContact() {

    Contacts before = app.contact().allContacts();
    ContactData contact = new ContactData().withFirstname("jan").withLastname("hamcrest").withAddress("hamcreststreet").withPhone("666555444").withEmail("test@test.pl").withGroup("test2");
    app.contact().create(contact, true);
    Contacts after = app.contact().allContacts();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()))));

  }


}

