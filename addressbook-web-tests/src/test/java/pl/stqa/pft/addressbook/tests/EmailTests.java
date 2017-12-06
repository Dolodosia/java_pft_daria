package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EmailTests extends TestBase {

  @Test
  public void testEmail() {

    app.goTo().goToHomePage();
    ContactData contact = app.contact().allContacts().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
//assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));



  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
           // .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  /*
  public static String cleaned(String email) {
    return email.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
  */

  /*
  private String mergePhones(ContactData contact) {
         return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                 .stream().filter((s) -> !s.equals(""))
                 .map(ContactPhoneTests::cleaned)
                 .collect(Collectors.joining("\n"));
                 }

             public static String cleaned(String phone) {
             return phone.replaceAll("\\s", "").replaceAll("[-()]", "");

         }
   */
  }
