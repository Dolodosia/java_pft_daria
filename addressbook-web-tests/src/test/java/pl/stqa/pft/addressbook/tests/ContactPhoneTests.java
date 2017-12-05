package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

public class ContactPhoneTests extends TestBase {


  //dodac zapewnienie warunkow gdyby nie bylo zadnego kontaktu

@Test
  public void testContactPhones(){
  app.goTo().goToHomePage();
  ContactData contact = app.contact().allContacts().iterator.next();
  ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);


}


}
