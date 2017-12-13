package pl.stqa.pft.addressbook.tests;

        import org.testng.Assert;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;
        import pl.stqa.pft.addressbook.model.ContactData;
        import pl.stqa.pft.addressbook.model.Contacts;

        import java.util.List;
        import static org.hamcrest.CoreMatchers.*;
        import static org.hamcrest.MatcherAssert.*;

        //zad 17
public class DeleteContactTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Jan").withLastname("tester").withAddress("ulica").withHomePhone("111222333")
              .withEmail("test@test.pl").withGroup("test1"), true);
    }
  }


    @Test
      public void testDeleteContact(){

      app.goTo().goToHomePage();
       // Contacts before = app.contact().allContacts();
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
// int index = before.size()- 1;
        app.contact().delete(deletedContact);
        //Contacts after = app.contact().allContacts();
      app.goTo().goToHomePage();
        Contacts after = app.db().contacts();
        Assert.assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.without(deletedContact)));

}

    }

