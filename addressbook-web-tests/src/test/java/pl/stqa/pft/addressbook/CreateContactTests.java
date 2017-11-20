package pl.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class CreateContactTests extends TestBase {
    
    @Test
    public void testCreateContact() {

        app.addNewContact();
        app.fillNewContactForm(new ContactData("alien", "testuje", "666000666", "temnail@mail.com"));
        app.newContactEnd();
    }


}

