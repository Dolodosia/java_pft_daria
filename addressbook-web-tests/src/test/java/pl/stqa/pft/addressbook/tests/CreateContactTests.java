package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;
import pl.stqa.pft.addressbook.model.GroupData;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;


public class CreateContactTests extends TestBase {

  //(enabled = false)
  @Test
  public void testCreateContact() {

    Contacts before = app.contact().allContacts();


    File photo = new File("src/test/resources/nietoperz.jpg");

    ContactData contact = new ContactData().withFirstname("mirek").withLastname("photo").withAddress("hamcreststreet")
            .withHomePhone("666555444").withEmail("test@test.pl").withGroup("test2").withPhoto(photo);

    app.contact().create(contact, true);
    Contacts after = app.contact().allContacts();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()))));

  }

  /*
@Test
    public void testCurrentDir(){
      File currentDir = new File(".");
      System.out.println(currentDir.getAbsolutePath());
  File photo = new File("src/test/resources/nietoperz.jpg");
  System.out.println(photo.getAbsolutePath());
  System.out.println(photo.exists());
  }
//C:\Users\michalda\Desktop\kurs JAVA\java_pft_daria\addressbook-web-tests\.
*/

}

