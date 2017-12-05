package pl.stqa.pft.addressbook.tests;

        import org.testng.Assert;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;
        import pl.stqa.pft.addressbook.model.ContactData;
        import pl.stqa.pft.addressbook.model.Contacts;

        import java.util.List;
        import static org.hamcrest.CoreMatchers.*;
        import static org.hamcrest.MatcherAssert.*;

public class DeleteContactTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().allContacts().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Jan").withLastname("tester").withAddress("ulica").withPhone("111222333")
              .withEmail("test@test.pl").withGroup("test1"), true);
    }
  }

      @Test
      public void testDeleteContact(){

        Contacts before = app.contact().allContacts();
        ContactData deletedContact = before.iterator().next();
// int index = before.size()- 1;
        app.contact().delete(deletedContact);
        Contacts after = app.contact().allContacts();
        Assert.assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.without(deletedContact)));

      }

    /*
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("ddd", "ttttt", "666999111", "ooo@ccc.pl", "test1", "ulica"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact((before.size()- 1));
    app.getContactHelper().deleteContact();
    app.getContactHelper().alertAccept();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size() , before.size() - 1);
    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);

  }
*/


    }

