package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
 import static org.hamcrest.MatcherAssert.*;
 import static org.testng.Assert.*;


public class ModifyContact extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().allContacts().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Jan").withLastname("Test").withAddress("ulica").withHomePhone("111222555").withEmail("test@test.pl").withGroup("test2"), true);
    }
  }

    //(enabled = false)
    @Test
    public void testContactModification () {

      //Contacts before = app.contact().allContacts();
      Contacts before = app.db().contacts();
      ContactData modifiedContact = before.iterator().next();
      //int index = before.size()-1;
      ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Janina").withLastname("Testuje").withAddress("ulica").withHomePhone("111000888").withEmail("test@test.pl").withGroup("test2");


      app.contact().modify(contact);
      //Contacts after = app.contact().allContacts();
      Contacts after = app.db().contacts();
      assertEquals(after.size(), before.size());
      assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

    }

  }
