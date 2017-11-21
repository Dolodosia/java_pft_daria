package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

public class CreateContactTests extends TestBase {
    
    @Test
    public void testCreateContact() {

        app.getNavigationHelper().goToCreatenewContact();
        app.getContactHelper().fillNewContactForm(new ContactData("alien", "testuje", "666000666", "temnail@mail.com"));
        app.getContactHelper().newContactEnd();
    }


}

