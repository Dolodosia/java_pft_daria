package pl.stqa.pft.addressbook.tests;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class ContactPhoneTests extends TestBase {


  //dodac zapewnienie warunkow gdyby nie bylo zadnego kontaktu

  @Test
  public void testContactPhones() {
    app.goTo().goToHomePage();
    ContactData contact = app.contact().all().iterator.next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getPhone(), equalTo(cleaned(contactInfoFromEditForm.getPhone())));
    assertThat(contact.getMobile(), equalTo(cleaned(contactInfoFromEditForm.getMobile())));
    assertThat(contact.getWork(), equalTo(cleaned(contactInfoFromEditForm.getWork())));
  }

    //regular expression

  public String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }


}




