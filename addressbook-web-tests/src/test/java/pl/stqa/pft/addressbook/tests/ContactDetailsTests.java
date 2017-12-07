package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsTests  extends TestBase {

  @Test
  public void ContactDetailsTest() {
    app.goTo().goToHomePage();
    ContactData contact = app.contact().allContacts().iterator().next();
    ContactData contactInfoFromDetailsForm = app.contact().infoFromDetailsForm(contact);
    ContactData contactInfoFromEditForm = contactDetailsEqualsViewFormat(app.contact().infoFromEditForm(contact));
    assertThat(cleanedEditInfo(contactInfoFromDetailsForm.getAllDetails()), equalTo(cleanedEditInfo(mergeData(contactInfoFromEditForm))));

  }

  private String mergeData(ContactData contact) {
    return Arrays.asList(contact.getFirstname(), contact.getLastname(), contact.getAddress(), contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(),contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            //.map(ContactDetailedInfoTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static ContactData contactDetailsEqualsViewFormat(ContactData contact) {
    String phone = contact.getHomePhone();
    String mobile = contact.getMobilePhone();
    String work = contact.getWorkPhone();
    String address = contact.getAddress();


    if (!address.equals("")) {
      address += "\n";
    }

    if (!phone.equals("")) {
      phone = "H: " + phone;
    }

    if (!mobile.equals("")) {
      mobile = "M: " + mobile;
    }
    if (!work.equals("")) {
      work = "W: " + work + "\n";
    }
    return contact.withHomePhone(phone).withMobilePhone(mobile).withWorkPhone(work).withAddress(address);
  }


  public static String cleanedEditInfo(String info) {
    return info.replaceAll("\\s", "").replaceAll("[-()]", "");
  }




}


